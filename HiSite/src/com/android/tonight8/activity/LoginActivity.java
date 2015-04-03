package com.android.tonight8.activity;

import java.text.SimpleDateFormat;

import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.tonight8.R;
import com.android.tonight8.base.BaseActivity;
import com.android.tonight8.base.Tonight8App;
import com.android.tonight8.utils.Utils;
import com.android.tonight8.wxapi.AccessTokenKeeper;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnClick;
import com.sina.weibo.sdk.auth.Oauth2AccessToken;
import com.sina.weibo.sdk.auth.WeiboAuthListener;
import com.sina.weibo.sdk.exception.WeiboException;
import com.sina.weibo.sdk.net.RequestListener;
import com.sina.weibo.sdk.openapi.LogoutAPI;
import com.sina.weibo.sdk.openapi.UsersAPI;
import com.sina.weibo.sdk.openapi.models.ErrorInfo;
import com.sina.weibo.sdk.openapi.models.User;
import com.sina.weibo.sdk.widget.LoginoutButton;
import com.tencent.connect.UserInfo;
import com.tencent.connect.common.Constants;
import com.tencent.mm.sdk.modelmsg.SendAuth;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.Tencent;
import com.tencent.tauth.UiError;

/**
 * @Description:登录接口
 * @author:LiuZhao
 * @Date:2014年12月25日
 */
public class LoginActivity extends BaseActivity {

	/** */
	@ViewInject(R.id.btn_qq_login_ok)
	private Button btn_qq_login_ok;
	@ViewInject(R.id.btn_wx_login_ok)
	private Button btn_wx_login_ok;
	private LoginoutButton btn_sina_login_ok;
	@ViewInject(R.id.btn_qq_login_cancle)
	private Button btn_qq_login_cancle;
	@ViewInject(R.id.btn_wx_login_cancel)
	private Button btn_wx_login_cancel;
	@ViewInject(R.id.btn_sina_login_cancel)
	private Button btn_sina_login_cancel;
	@ViewInject(R.id.tv_back)
	private TextView tv_back;

	@ViewInject(R.id.user_nickname)
	private TextView mUserInfo;
	@ViewInject(R.id.user_logo)
	private ImageView mUserLogo;
	private UserInfo mInfo;
	// -------微博登录----------
	/** 登陆认证对应的listener */
	private AuthListener mLoginListener = new AuthListener();
	/** 登出操作对应的listener */
	private LogOutRequestListener mLogoutListener = new LogOutRequestListener();
	/** 用户信息接口 */
	private UsersAPI mUsersAPI;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		setContentView(R.layout.activity_login);
		super.onCreate(savedInstanceState);
		getActionBarBase("登录页");
		initData();
	}

	@OnClick({ R.id.btn_sina_login_cancel, R.id.btn_wx_login_ok, R.id.btn_wx_login_cancel, R.id.btn_qq_login_ok,
			R.id.btn_qq_login_cancle })
	public void onClick(View arg0) {
		switch (arg0.getId()) {

		case R.id.btn_sina_login_cancel:
			// 注销按钮
			new LogoutAPI(LoginActivity.this, Tonight8App.SINA_APP_KEY,
					AccessTokenKeeper.readAccessToken(LoginActivity.this)).logout(mLogoutListener);
			break;
		case R.id.btn_wx_login_ok:
			weixinLogin();
			break;
		case R.id.btn_wx_login_cancel:

			break;
		case R.id.btn_qq_login_ok:
			QqLogin();
			break;
		case R.id.btn_qq_login_cancle:
			Tonight8App.getSelf().mTencent.logout(LoginActivity.this);
			break;

		default:
			break;
		}
	}

	private void initData() {
		// 新浪登陆按钮（银灰色）
		btn_sina_login_ok = (LoginoutButton) findViewById(R.id.btn_sina_login_ok);
		btn_sina_login_ok.setWeiboAuthInfo(Tonight8App.getSelf().mSinaAuth, mLoginListener);
		btn_sina_login_ok.setLogoutListener(mLogoutListener);
	}

	/**
	 * @Title: weixinLogin微信登录
	 * @Description: TODO
	 * @param 设定文件
	 * @return void 返回类型
	 * @throws
	 */
	private void weixinLogin() {

		// 微信授权登录认证请求 oauth request
		final SendAuth.Req req = new SendAuth.Req();
		req.scope = "snsapi_userinfo";
		req.state = "wechat_sdk_demo_test";
		Tonight8App.getSelf().wxApi.sendReq(req);
	}

	private void updateUserInfo() {
		if (Tonight8App.getSelf().mTencent != null && Tonight8App.getSelf().mTencent.isSessionValid()) {
			IUiListener listener = new IUiListener() {

				@Override
				public void onError(UiError e) {

				}

				@Override
				public void onComplete(final Object response) {
					Message msg = new Message();
					msg.obj = response;
					msg.what = 0;
					mHandler.sendMessage(msg);
					new Thread() {

						@Override
						public void run() {
							JSONObject json = (JSONObject) response;
							if (json.has("figureurl")) {
								Bitmap bitmap = null;
								String imageurl = null;
								try {
									// bitmap =
									// Util.getbitmap(json.getString("figureurl_qq_2"));
									imageurl = json.getString("figureurl_qq_2");
								} catch (JSONException e) {

								}
								Message msg = new Message();
								// msg.obj = bitmap;
								msg.obj = imageurl;
								msg.what = 1;
								mHandler.sendMessage(msg);
							}
						}

					}.start();
				}

				@Override
				public void onCancel() {

				}
			};
			mInfo = new UserInfo(this, Tonight8App.getSelf().mTencent.getQQToken());
			mInfo.getUserInfo(listener);

		} else {
			mUserInfo.setText("");
			mUserInfo.setVisibility(View.GONE);
			mUserLogo.setVisibility(View.GONE);
		}
	}

	Handler mHandler = new Handler() {

		@Override
		public void handleMessage(Message msg) {
			if (msg.what == 0) {
				JSONObject response = (JSONObject) msg.obj;
				if (response.has("nickname")) {
					try {
						mUserInfo.setVisibility(android.view.View.VISIBLE);
						mUserInfo.setText(response.getString("nickname"));
					} catch (JSONException e) {
						e.printStackTrace();
					}
				}
			} else if (msg.what == 1) {
				// Bitmap bitmap = (Bitmap)msg.obj;
				// mUserLogo.setImageBitmap(bitmap);
				String imageurl = (String) msg.obj;
				Tonight8App.getSelf().bitmapUtils.display(mUserLogo, imageurl);
				mUserLogo.setVisibility(android.view.View.VISIBLE);
			}
		}

	};

	/**
	 * 新浪登入按钮的监听器，接收授权结果。
	 */
	private class AuthListener implements WeiboAuthListener {
		@Override
		public void onComplete(Bundle values) {
			Oauth2AccessToken accessToken = Oauth2AccessToken.parseAccessToken(values);
			if (accessToken != null && accessToken.isSessionValid()) {
				String date = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new java.util.Date(accessToken
						.getExpiresTime()));
				String format = "Token：%1$s \n有效期：%2$s";
				Utils.toast(String.format(format, accessToken.getToken(), date));
				AccessTokenKeeper.writeAccessToken(getApplicationContext(), accessToken);

				String token = values.getString("access_token");
				String expires_in = values.getString("expires_in");
				Utils.toast("access_token : " + token + "  expires_in: " + expires_in);

				// 微博获取当前已保存过的 Token
				accessToken = AccessTokenKeeper.readAccessToken(LoginActivity.this);
				// 微博获取用户信息接口
				mUsersAPI = new UsersAPI(LoginActivity.this, Tonight8App.SINA_APP_KEY, accessToken);
				long uid = Long.parseLong(accessToken.getUid());
				mUsersAPI.show(uid, sinaListener);
			}
		}

		@Override
		public void onWeiboException(WeiboException e) {

		}

		@Override
		public void onCancel() {

		}
	}

	/**
	 * 微博 OpenAPI 回调接口。用户信息
	 */
	private RequestListener sinaListener = new RequestListener() {
		@Override
		public void onComplete(String response) {
			if (!TextUtils.isEmpty(response)) {
				// 调用 User#parse 将JSON串解析成User对象
				User user = User.parse(response);
				if (user != null) {
					Toast.makeText(LoginActivity.this, "获取User信息成功，用户昵称：" + user.screen_name, Toast.LENGTH_LONG).show();
				} else {
					Toast.makeText(LoginActivity.this, response, Toast.LENGTH_LONG).show();
				}
			}
		}

		@Override
		public void onWeiboException(WeiboException e) {
			ErrorInfo info = ErrorInfo.parse(e.getMessage());
			Toast.makeText(LoginActivity.this, info.toString(), Toast.LENGTH_LONG).show();
		}
	};

	/**
	 * 新浪退出按钮的监听器，接收登出处理结果。（API 请求结果的监听器）
	 */
	private class LogOutRequestListener implements RequestListener {
		@Override
		public void onComplete(String response) {
			if (!TextUtils.isEmpty(response)) {
				try {
					JSONObject obj = new JSONObject(response);
					String value = obj.getString("result");

					if ("true".equalsIgnoreCase(value)) {
						AccessTokenKeeper.clear(LoginActivity.this);

					}
				} catch (JSONException e) {
					e.printStackTrace();
				}
			}
		}

		@Override
		public void onWeiboException(WeiboException e) {

		}
	}

	/**
	 * @Title: onClickLogin QQ登录
	 * @Description: TODO
	 * @param 设定文件
	 * @return void 返回类型
	 * @throws
	 */
	private void QqLogin() {
		if (!Tonight8App.getSelf().mTencent.isSessionValid()) {
			Tonight8App.getSelf().mTencent.login(this, "all", loginListener);
			Log.d("SDKQQAgentPref", "FirstLaunch_SDK:" + SystemClock.elapsedRealtime());
		} else {
			Tonight8App.getSelf().mTencent.logout(this);
			updateUserInfo();
		}
	}

	public static void initOpenidAndToken(JSONObject jsonObject) {
		try {
			String token = jsonObject.getString(Constants.PARAM_ACCESS_TOKEN);
			String expires = jsonObject.getString(Constants.PARAM_EXPIRES_IN);
			String openId = jsonObject.getString(Constants.PARAM_OPEN_ID);
			if (!TextUtils.isEmpty(token) && !TextUtils.isEmpty(expires) && !TextUtils.isEmpty(openId)) {
				Tonight8App.getSelf().mTencent.setAccessToken(token, expires);
				Tonight8App.getSelf().mTencent.setOpenId(openId);
			}
		} catch (Exception e) {
		}
	}

	public IUiListener loginListener = new BaseUiListener() {
		@Override
		protected void doComplete(JSONObject values) {
			Log.d("SDKQQAgentPref", "AuthorSwitch_SDK:" + SystemClock.elapsedRealtime());
			initOpenidAndToken(values);
			updateUserInfo();
		}
	};

	/**
	 * @author asus QQ登录返回
	 * 
	 */
	private class BaseUiListener implements IUiListener {

		@Override
		public void onComplete(Object response) {
			if (null == response) {
				Utils.toast("返回为空,登录失败");
				return;
			}
			JSONObject jsonResponse = (JSONObject) response;
			if (null != jsonResponse && jsonResponse.length() == 0) {
				Utils.toast("返回为空,登录失败");
				return;
			}
			Utils.toast("登录成功");
			doComplete((JSONObject) response);
		}

		protected void doComplete(JSONObject values) {

		}

		@Override
		public void onError(UiError e) {
			Utils.toast("登录出错： " + e.errorDetail);
			Utils.dismissDialog();

		}

		@Override
		public void onCancel() {
			Utils.toast("登录取消： ");
			Utils.dismissDialog();
		}
	}

	public static boolean ready(Context context) {
		if (Tonight8App.getSelf().mTencent == null) {
			return false;
		}
		boolean ready = Tonight8App.getSelf().mTencent.isSessionValid()
				&& Tonight8App.getSelf().mTencent.getQQToken().getOpenId() != null;
		if (!ready) {
			Toast.makeText(context, "login and get openId first, please!", Toast.LENGTH_SHORT).show();
		}
		return ready;
	}

	/**
	 * 当 SSO 授权 Activity 退出时，该函数被调用。
	 * 
	 * @see {@link Activity#onActivityResult}
	 */
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		// 微博
		if (btn_sina_login_ok != null) {
			btn_sina_login_ok.onActivityResult(requestCode, resultCode, data);
		}
		// QQ登录
		if (requestCode == Constants.REQUEST_API) {
			if (resultCode == Constants.RESULT_LOGIN) {
				Tencent.handleResultData(data, loginListener);
			}
		}
	}
}
