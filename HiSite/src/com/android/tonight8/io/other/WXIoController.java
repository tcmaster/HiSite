package com.android.tonight8.io.other;

import java.util.Map;

import android.os.Handler;

import com.android.tonight8.io.HandlerConstants;
import com.android.tonight8.io.net.NetEntityBase;
import com.android.tonight8.io.net.NetRequest;
import com.android.tonight8.io.net.NetRequest.RequestResult;
import com.android.tonight8.model.other.AccessToken;
import com.android.tonight8.model.other.ReFreshAccessToken;
import com.android.tonight8.model.other.WXUserInfo;
import com.android.tonight8.utils.Utils;
import com.lidroid.xutils.exception.HttpException;

/**
 * 微信登录接口
 */
public class WXIoController {

	// ------------微信登录用到的接口------------
	// 通过code获取access_token的接口appid=APPID&secret=SECRET&code=CODE&grant_type=authorization_code
	public static String ACCESS_TOKEN_URL = "https://api.weixin.qq.com/sns/oauth2/access_token?";
	// 获取用户个人信息（UnionID机制）access_token=ACCESS_TOKEN&openid=OPENID
	public static String WX_USERINFO_URL = "https://api.weixin.qq.com/sns/userinfo?";
	/**
	 * access_token是调用授权关系接口的调用凭证，由于access_token有效期（目前为2个小时）较短，当access_token超时后，
	 * refresh_token拥有较长的有效期（30天），当refresh_token失效的后，需要用户重新授权。
	 */
	// 刷新或续期access_token使用appid=APPID&grant_type=refresh_token&refresh_token=REFRESH_TOKEN
	public static String REFRESH_TOKEN_URL = "https://api.weixin.qq.com/sns/oauth2/refresh_token?";

	/**
	 * @Title: getWXAccessToken
	 * @Description: 通过code获取access_token的接口
	 * @param @param handler
	 * @param @param params 设定文件
	 * @return void 返回类型
	 * @throws
	 */
	public static void getWXAccessToken(final Handler handler, Map<String, String> params) {
		params.put(NetRequest.REQUEST_URL, ACCESS_TOKEN_URL);
		NetRequest.doGetThirdRequest(params, new RequestResult<AccessToken>(AccessToken.class, handler) {

			@Override
			public void getData(NetEntityBase netEntityBase, AccessToken t, Handler handler) {
				if (t != null) {
					Utils.toast("access_token获取成功");
					HandlerConstants.sendMessage(handler, t, 0, HandlerConstants.RESULT_OK, 0);
				}
			}

			@Override
			public void onFailure(HttpException arg0, String arg1) {
				HandlerConstants.sendMessage(handler, null, 0, HandlerConstants.RESULT_FAIL, 0);
			}

		});
	}

	/**
	 * @Title: getWXRefreshAccessToken
	 * @Description: 通过code获取access_token的接口
	 * @param @param handler
	 * @param @param params 设定文件
	 * @return void 返回类型
	 * @throws
	 */
	public static void getWXRefreshAccessToken(final Handler handler, Map<String, String> params) {
		params.put(NetRequest.REQUEST_URL, REFRESH_TOKEN_URL);
		NetRequest.doGetThirdRequest(params, new RequestResult<ReFreshAccessToken>(ReFreshAccessToken.class, handler) {

			@Override
			public void getData(NetEntityBase netEntityBase, ReFreshAccessToken t, Handler handler) {
				if (t != null) {
					Utils.toast("ReFreshAccessToken获取成功");
					HandlerConstants.sendMessage(handler, t, 0, HandlerConstants.RESULT_OK, 0);
				}
			}

			@Override
			public void onFailure(HttpException arg0, String arg1) {
				HandlerConstants.sendMessage(handler, null, 0, HandlerConstants.RESULT_FAIL, 0);
			}

		});
	}

	/**
	 * @Title: getWxUserInfo
	 * @Description: 获取用户个人信息（UnionID机制）
	 * @param @param handler
	 * @param @param params 设定文件
	 * @return void 返回类型
	 * @throws
	 */
	public static void getWxUserInfo(final Handler handler, Map<String, String> params) {
		params.put(NetRequest.REQUEST_URL, WX_USERINFO_URL);
		NetRequest.doGetThirdRequest(params, new RequestResult<WXUserInfo>(WXUserInfo.class, handler) {

			@Override
			public void getData(NetEntityBase netEntityBase, WXUserInfo t, Handler handler) {
				if (t != null) {
					HandlerConstants.sendMessage(handler, t, 0, HandlerConstants.RESULT_OK, 0);
				}
			}

			@Override
			public void onFailure(HttpException arg0, String arg1) {
				HandlerConstants.sendMessage(handler, null, 0, HandlerConstants.RESULT_FAIL, 0);
			}

		});
	}
}
