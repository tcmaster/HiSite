/**
 * 2014-12-26
 */
package com.android.tonight8.io.net;

import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import android.os.Handler;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.android.tonight8.base.AppConstants;
import com.android.tonight8.utils.JsonUtils;
import com.android.tonight8.utils.StringUtils;
import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.http.RequestParams;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest.HttpMethod;
import com.lidroid.xutils.util.LogUtils;

/**
 * @Description: 网络请求公共类
 * @author:LiXiaoSong
 * @copyright @tonight8
 * @Date:2014-12-26
 */
public class NetRequest {

	public static final String GET_METHOD = "get";
	public static final String POST_METHOD = "method";
	public static final String REQUEST_URL = "requesUrl";
	public static final String METHOD = "method";
	public static final String BASE_URL = "http://180.150.179.226/activitys";

	/**
	 * @Description:多任务请求方法(用于请求多个任务)，每个map与同位置的callback一一对应(此方法不能上传大文件,参数必需均为String),在每个map中，必需传送含有"method"和"requesUrl"的字段
	 * @param params
	 *            所有请求的参数集合
	 * @param callbacks
	 *            所有请求结果的回调集合
	 * @author: LiXiaoSong
	 * @date:2014-12-26
	 */
	public static <T> void doRequest(final Map<String, String> param,
			final RequestResult<T> callback) {
		new Thread(new Runnable() {

			@Override
			public void run() {
				HttpUtils httpUtils = new HttpUtils();
				httpUtils.configTimeout(5000);
				httpUtils.configRequestThreadPoolSize(5);
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
					if (kv.getKey().equals(REQUEST_URL)) {
						requestUrl = kv.getValue();
						continue;
					}
					// rP.addBodyParameter(kv.getKey(), kv.getValue());
					rP.addQueryStringParameter(kv.getKey(), kv.getValue());

				}
				httpUtils.send(method, requestUrl, rP, callback);
			}

		}).start();

	}

	/**
	 * @Title: doGetThirdRequest第三方接口请求
	 * @Description: TODO
	 * @param @param param
	 * @param @param callback 设定文件
	 * @return void 返回类型
	 * @throws
	 */
	public static <T> void doGetThirdRequest(final Map<String, String> param,
			final RequestResult<T> callback) {
		param.put("method", GET_METHOD);
		doRequest(param, callback);
		// 测试，暂时未调用网络
		new Thread(new Runnable() {

			@Override
			public void run() {
				callback.getData(null, null, callback.handler);
			}
		}).start();

	}

	/**
	 * @Description: 进行一次GET请求(无需传method方法)
	 * @author: LiXiaoSong
	 * @date:2014-12-26
	 */
	@SuppressWarnings("unchecked")
	public static <T> void doGetRequest(final Map<String, String> param,
			final RequestResult<T> callback) {
		// param.put("method", GET_METHOD);
		// doRequest(param, callback);
		// 测试，暂时未调用网络
		new Thread(new Runnable() {

			@Override
			public void run() {
				// try {
				// Thread.sleep(1000);
				callback.getData(null,
						JsonUtils.getVirualData(callback.getResultClass()),
						callback.handler);
				// } catch (InterruptedException e) {
				// e.printStackTrace();
				// }
			}
		}).start();
	}

	/**
	 * @Description: 进行一次GET请求(无需传method方法)
	 * @author: LiXiaoSong
	 * @date:2014-12-26
	 */
	@SuppressWarnings("unchecked")
	public static <T> void doGetRequestList(final Map<String, String> param,
			final RequestResultList<T> callback) {
		// param.put("method", GET_METHOD);
		// doRequest(param, callback);
		// 测试，暂时未调用网络
		new Thread(new Runnable() {

			@Override
			public void run() {
				// try {
				// Thread.sleep(1000);
				callback.getDataList(null,
						JsonUtils.getVirualDataList(callback.getResultClass()),
						callback.handler);
				// } catch (InterruptedException e) {
				// e.printStackTrace();
				// }
			}
		}).start();
	}

	/**
	 * @Description: 进行一次POST请求
	 * @author: LiXiaoSong
	 * @date:2014-12-26
	 */
	@SuppressWarnings("unchecked")
	public static <T> void doPostRequest(final Map<String, String> param,
			final RequestResult<T> callback) {
		param.put("method", POST_METHOD);
		doRequest(param, callback);
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
	public static <T> void postImageToServer(final Map<String, String> param,
			final RequestResult<T> callback, final String fN, final File file) {
		new Thread(new Runnable() {

			@Override
			public void run() {
				HttpUtils httpUtils = new HttpUtils();
				httpUtils.configTimeout(5000);
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
					// rP.addQueryStringParameter(kv.getKey(), kv.getValue());
				}
				rP.addBodyParameter(fN, file);
				httpUtils.send(HttpMethod.POST, requestUrl, rP, callback);
			}
		}).start();

	}

	public abstract static class RequestResult<T> extends
			RequestCallBack<String> {

		private Class<T> clazz;
		private Handler handler;

		/**
		 * @param clazz
		 *            需要解析的实体类（如果解析完以后就是NetBaseEntity，则该类可为任何类型）
		 * @param handler
		 *            主线程的handler（用于将数据传输给UI界面）
		 */
		public RequestResult(final Class<T> clazz, final Handler handler) {
			this.handler = handler;
			this.clazz = clazz;
		}

		public Class<T> getResultClass() {
			return clazz;
		}

		@Override
		public void onSuccess(final ResponseInfo<String> arg0) {
			// 解析基本的网络实体,根据业务需求，需要另开线程(数据库操作比较频繁)
			new Thread(new Runnable() {

				@Override
				public void run() {
					NetEntityBase base = getBaseJsonObject(arg0.result);
					T t = null;
					if (!StringUtils.isNullOrEmpty(base.data)) {
						t = JsonUtils.parseJsonStr(base.data, clazz);// 解析好需要的实体
					}
					getData(base, t, handler);
				}
			}).start();

		}

		private NetEntityBase getBaseJsonObject(String baseStr) {
			NetEntityBase base = new NetEntityBase();
			JSONObject object = JSON.parseObject(baseStr);
			base.status = object.getInteger("status");
			base.attachment_path = object.getString("attachment_path");
			base.message = object.getString("message");
			JsonUtils.newJsonkey = "";
			String jsonkey = JsonUtils.getObjectToString(object
					.getJSONObject("data"));
			LogUtils.v("ori is " + object.getJSONObject("data"));
			base.data = JsonUtils.getStringData(jsonkey,
					object.getJSONObject("data"));
			LogUtils.v("data is on parseFinish " + base.data);
			return base;
		}

		public abstract void getData(NetEntityBase netEntityBase, T t,
				Handler handler);
	}

	public abstract static class RequestResultList<T> extends
			RequestCallBack<String> {

		private Class<T> clazz;
		private Handler handler;

		/**
		 * @param clazz
		 *            需要解析的实体类（如果解析完以后就是NetBaseEntity，则该类可为任何类型）
		 * @param handler
		 *            主线程的handler（用于将数据传输给UI界面）
		 */
		public RequestResultList(final Class<T> clazz, final Handler handler) {
			this.handler = handler;
			this.clazz = clazz;
		}

		public Class<T> getResultClass() {
			return clazz;
		}

		@Override
		public void onSuccess(final ResponseInfo<String> arg0) {
			// 解析基本的网络实体,根据业务需求，需要另开线程(数据库操作比较频繁)
			new Thread(new Runnable() {

				@Override
				public void run() {
					NetEntityBase base = getBaseJsonObject(arg0.result);
					List<T> t = null;
					if (!StringUtils.isNullOrEmpty(base.data)) {
						t = JsonUtils.parseJsonList(base.data, clazz);// 解析好需要的实体
					}
					getDataList(base, t, handler);
				}
			}).start();

		}

		private NetEntityBase getBaseJsonObject(String baseStr) {
			NetEntityBase base = new NetEntityBase();
			JSONObject object = JSON.parseObject(baseStr);
			base.status = object.getInteger("status");
			base.attachment_path = object.getString("attachment_path");
			base.message = object.getString("message");
			JsonUtils.newJsonkey = "";
			String jsonkey = JsonUtils.getObjectToString(object
					.getJSONObject("data"));
			LogUtils.v("ori is " + object.getJSONObject("data"));
			base.data = JsonUtils.getStringData(jsonkey,
					object.getJSONObject("data"));
			LogUtils.v("data is on parseFinish " + base.data);
			return base;
		}

		public abstract void getDataList(NetEntityBase netEntityBase,
				List<T> t, Handler handler);
	}

	private static void addHeader(RequestParams rP) {
		rP.addQueryStringParameter("version", AppConstants.version);
		rP.addQueryStringParameter("device_type", AppConstants.device_type);
		rP.addQueryStringParameter("imei", AppConstants.imei);
		rP.addQueryStringParameter("dpi", AppConstants.dpi);
		rP.addQueryStringParameter("os_version", AppConstants.os_version);
		rP.addQueryStringParameter("phone_model", AppConstants.phone_model);
		rP.addQueryStringParameter("auth_code", AppConstants.auth_code);
	}

}
