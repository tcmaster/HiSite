/**
 * 2014-12-26
 */
package com.android.hisite.net;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.http.RequestParams;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest.HttpMethod;

/**
 * @Description: 网络请求公共类
 * @author:LiXiaoSong
 * @copyright @HiSite
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
	 * @Description: 进行一次GET请求
	 * @see:
	 * @since:
	 * @author: LiXiaoSong
	 * @date:2014-12-26
	 */
	public static void doGetRequest() {

	}

	/**
	 * @Description: 进行一次POST请求
	 * @see:
	 * @since:
	 * @author: LiXiaoSong
	 * @date:2014-12-26
	 */
	public static void doPostRequest() {

	}

	public abstract class RequestResult<T> extends RequestCallBack<String> {

		private Class<T> clazz;

		public RequestResult(Class<T> clazz) {
			this.clazz = clazz;
		}

		@Override
		public void onSuccess(ResponseInfo<String> arg0) {
			// 这里使用json解析工具进行解析
			T t;
			try {
				t = clazz.newInstance();
				getData(t);
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}

		}

		public abstract void getData(T t);
	}

}
