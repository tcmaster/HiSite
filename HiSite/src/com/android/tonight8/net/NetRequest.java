/**
 * 2014-12-26
 */
package com.android.tonight8.net;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.android.tonight8.base.AppConstants;
import com.android.tonight8.utils.JsonUtils;
import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.http.RequestParams;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest.HttpMethod;

/**
 * @Description: 网络请求公共类
 * @author:LiXiaoSong
 * @copyright @tonight8
 * @Date:2014-12-26
 */
public class NetRequest {

	public static final String GET_METHOD = "get";
	public static final String POST_METHOD = "method";

	/**
	 * @Description:多任务请求方法(用于请求多个任务)，每个map与同位置的callback一一对应(此方法不能上传大文件,参数必需均为String),在每个map中，必需传送含有"method"和"requesUrl"的字段
	 * @param params
	 *            所有请求的参数集合
	 * @param callbacks
	 *            所有请求结果的回调集合
	 * @author: LiXiaoSong
	 * @date:2014-12-26
	 */
	public static <T> void doRequest(List<Map<String, String>> params, RequestResult<T>... callbacks) {
		HttpUtils httpUtils = new HttpUtils();
		httpUtils.configTimeout(5000);
		httpUtils.configRequestThreadPoolSize(callbacks.length);
		for (int i = 0; i < params.size(); i++) {
			Map<String, String> param = params.get(i);// 各个参数
			final RequestResult<T> callback = callbacks[i];// 对应的回调方法
			HttpMethod method = null;
			String requestUrl = "";
			Set<Map.Entry<String, String>> entry = param.entrySet();
			Iterator<Map.Entry<String, String>> it = entry.iterator();
			RequestParams rP = new RequestParams("utf-8");
			// 为各个参数添加必要头部
			addHeader(rP);
			// 这里需要增加若干基本参数
			while (it.hasNext()) {
				Map.Entry<String, String> kv = it.next();
				if (kv.getKey().equals("method")) {
					if (kv.getValue().equals(GET_METHOD))
						method = HttpMethod.GET;
					else if (kv.getValue().equals(POST_METHOD))
						method = HttpMethod.POST;
					continue;
				}
				if (kv.getKey().equals("requesUrl")) {
					requestUrl = kv.getValue();
					continue;
				}
				rP.addBodyParameter(kv.getKey(), kv.getValue());

			}
			httpUtils.send(method, requestUrl, rP, callback);
		}
	}

	/**
	 * @Description: 进行一次GET请求(无需传method方法)
	 * @author: LiXiaoSong
	 * @date:2014-12-26
	 */
	@SuppressWarnings("unchecked")
	public static <T> void doGetRequest(Map<String, String> param, RequestResult<T> callback) {
		param.put("method", GET_METHOD);
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		list.add(param);
		doRequest(list, callback);
	}

	/**
	 * @Description: 进行一次POST请求
	 * @author: LiXiaoSong
	 * @date:2014-12-26
	 */
	@SuppressWarnings("unchecked")
	public static <T> void doPostRequest(Map<String, String> param, RequestResult<T> callback) {
		param.put("method", POST_METHOD);
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		list.add(param);
		doRequest(list, callback);
	}

	/**
	 * 
	 * @Description: 上传文件到服务器(无需传方法类型)
	 * @param param
	 *            其余参数，包括url
	 * @param callback
	 *            回调方法
	 * @param fN
	 *            上传文件的参数
	 * @param file
	 *            上传的文件
	 * @author:LiXiaoSong
	 * @copyright @tonight8
	 * @Date:2014-12-29
	 */
	public static <T> void postImageToServer(Map<String, String> param, RequestResult<T> callback, String fN, File file) {
		HttpUtils httpUtils = new HttpUtils();
		httpUtils.configTimeout(5000);
		HttpMethod method = null;
		String requestUrl = "";
		Set<Map.Entry<String, String>> entry = param.entrySet();
		Iterator<Map.Entry<String, String>> it = entry.iterator();
		RequestParams rP = new RequestParams("utf-8");
		addHeader(rP);
		// 这里需要增加若干基本参数
		while (it.hasNext()) {
			Map.Entry<String, String> kv = it.next();
			if (kv.getKey().equals("requesUrl")) {
				requestUrl = kv.getValue();
				continue;
			}
			rP.addBodyParameter(kv.getKey(), kv.getValue());
		}
		rP.addBodyParameter(fN, file);
		httpUtils.send(HttpMethod.POST, requestUrl, callback);
	}

	public abstract class RequestResult<T> extends RequestCallBack<String> {

		private Class<T> clazz;

		public RequestResult(Class<T> clazz) {
			this.clazz = clazz;
		}

		@Override
		public void onSuccess(ResponseInfo<String> arg0) {
			T t = JsonUtils.parseJsonStr(arg0.result, clazz);// 解析好需要的实体
			getData(t);
		}

		public abstract void getData(T t);
	}

	private static void addHeader(RequestParams rP) {
		rP.addBodyParameter("version", AppConstants.version);
		rP.addBodyParameter("device_type", AppConstants.device_type);
		rP.addBodyParameter("imei", AppConstants.imei);
		rP.addBodyParameter("dpi", AppConstants.dpi);
		rP.addBodyParameter("os_version", AppConstants.os_version);
		rP.addBodyParameter("phone_model", AppConstants.phone_model);
		rP.addBodyParameter("auth_code", AppConstants.auth_code);
	}
}
