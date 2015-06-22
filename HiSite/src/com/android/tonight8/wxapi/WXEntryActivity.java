package com.android.tonight8.wxapi;

import java.util.HashMap;
import java.util.Map;

import android.content.Intent;
import android.os.Bundle;

import com.android.tonight8.base.BaseActivity;
import com.android.tonight8.base.Tonight8App;
import com.android.tonight8.io.other.WXIoController;
import com.android.tonight8.utils.Utils;
import com.lidroid.xutils.util.LogUtils;
import com.tencent.mm.sdk.modelbase.BaseReq;
import com.tencent.mm.sdk.modelbase.BaseResp;
import com.tencent.mm.sdk.modelmsg.SendAuth;
import com.tencent.mm.sdk.openapi.IWXAPIEventHandler;

/**
 * @Description：微信分享发出的请求将回调到onReq方法，发送到微信请求的响应结果将回调到onResp方法
 * @date 2015-3-20下午3:52:57
 * @author liuzhao
 */
public class WXEntryActivity extends BaseActivity implements IWXAPIEventHandler {

	@Override
	public void onReq(BaseReq arg0) {
		LogUtils.i("==onReq()arg0-->" + arg0.getType());

	}

	@Override
	public void onResp(BaseResp arg0) {
		LogUtils.i("==onResp()arg0-->" + arg0.getType());
		switch (arg0.errCode) {
		case BaseResp.ErrCode.ERR_OK:
			Utils.toast("分享成功");
			break;
		case BaseResp.ErrCode.ERR_USER_CANCEL:
			Utils.toast("分享取消");
			break;
		case BaseResp.ErrCode.ERR_AUTH_DENIED:
			Utils.toast("分享被拒绝");
			break;
		default:

			break;
		}

		// TODO 微信分享 成功之后调用接口
		this.finish();
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		LogUtils.i("==onCreate()");
		handleIntent(getIntent());
	}

	@Override
	protected void onRestart() {
		super.onRestart();
		LogUtils.i("==onRestart()");
	}

	@Override
	protected void onStart() {
		super.onStart();
		LogUtils.i("==onStart()");
		this.finish();// 分享（成功或失败后）不做任何处理
	}

	@Override
	protected void onNewIntent(Intent intent) {
		super.onNewIntent(intent);
		handleIntent(intent);
	}

	// 微信登录返回
	private void handleIntent(Intent intent) {
		SendAuth.Resp resp = new SendAuth.Resp(intent.getExtras());
		switch (resp.errCode) {
		case BaseResp.ErrCode.ERR_OK:// 用户同意
			Utils.toast("授权成功");
			// code 用户换取access_token的code，仅在ErrCode为0时有效
			String code = resp.code;
			// state
			// 第三方程序发送时用来标识其请求的唯一性的标志，由第三方程序调用sendReq时传入，由微信终端回传，state字符串长度不能超过1K
			String state = resp.state;
			Map<String, String> params = new HashMap<String, String>();
			params.put("appid", Tonight8App.WX_APP_ID);
			params.put("secret", Tonight8App.WX_APP_SECRET);
			params.put("code", code);
			params.put("grant_type", "authorization_code");
			WXIoController.getWXAccessToken(null, params);
			// 获取用户信息
			// Map<String, String> params2 = new HashMap<String, String>();
			// AccessToken accessToken = new AccessToken();
			// params2.put("access_token", accessToken.getAccess_token());
			// params2.put("openid", accessToken.getOpenid());
			// WXIoController.getWxUserInfo(null, params2);
			break;
		case BaseResp.ErrCode.ERR_USER_CANCEL:
			Utils.toast("授权取消");
			break;
		case BaseResp.ErrCode.ERR_AUTH_DENIED:
			Utils.toast("授权失败");
			break;
		default:

			break;
		}
		// 微信登录成功之后调用接口
		this.finish();
	}
}
