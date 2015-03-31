//package com.android.tonight8.activity;
//
//import java.text.SimpleDateFormat;
//
//import org.json.JSONException;
//import org.json.JSONObject;
//
//import android.content.Intent;
//import android.os.Bundle;
//import android.text.TextUtils;
//import android.view.View;
//import android.view.View.OnClickListener;
//import android.widget.Button;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import com.android.tonight8.R;
//import com.android.tonight8.base.AppConstants;
//import com.android.tonight8.base.BaseActivity;
//import com.android.tonight8.base.Tonight8App;
//import com.android.tonight8.wxapi.AccessTokenKeeper;
//import com.lidroid.xutils.view.annotation.ViewInject;
//import com.sina.weibo.sdk.auth.AuthInfo;
//import com.sina.weibo.sdk.auth.Oauth2AccessToken;
//import com.sina.weibo.sdk.auth.WeiboAuthListener;
//import com.sina.weibo.sdk.exception.WeiboException;
//import com.sina.weibo.sdk.net.RequestListener;
//import com.sina.weibo.sdk.widget.LoginButton;
//import com.tencent.mm.sdk.modelmsg.SendAuth;
//
///**
// * @Description:登录接口
// * @author:LiuZhao
// * @Date:2014年12月25日
// */
//public class LoginActivity extends BaseActivity {
//
//	/** */
//	@ViewInject(R.id.btn_qq_login_ok)
//	private Button btn_qq_login_ok;
//	@ViewInject(R.id.btn_wx_login_ok)
//	private Button btn_wx_login_ok;
//	// @ViewInject(R.id.btn_sina_login_ok)
//	private Button btn_sina_login_ok;
//	@ViewInject(R.id.tv_back)
//	private TextView tv_back;
//	// ------------登录用到的微信接口------------
//	// 通过code获取access_token的接口
//	String access_token = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=APPID&secret=SECRET&code=CODE&grant_type=authorization_code";
//	// 获取用户个人信息（UnionID机制）
//	String userinfo = "https://api.weixin.qq.com/sns/userinfo?access_token=ACCESS_TOKEN&openid=OPENID";
//	// 刷新或续期access_token使用
//	/**
//	 * access_token是调用授权关系接口的调用凭证，由于access_token有效期（目前为2个小时）较短，当access_token超时后，
//	 * 可以使用refresh_token进行刷新，access_token刷新结果有两种：
//	 * 
//	 * 1.若access_token已超时，那么进行refresh_token会获取一个新的access_token，新的超时时间；
//	 * 
//	 * 2.若access_token未超时，那么进行refresh_token不会改变access_token，但超时时间会刷新，
//	 * 相当于续期access_token。
//	 * 
//	 * refresh_token拥有较长的有效期（30天），当refresh_token失效的后，需要用户重新授权。
//	 */
//	String refresh_token = "https://api.weixin.qq.com/sns/oauth2/refresh_token?appid=APPID&grant_type=refresh_token&refresh_token=REFRESH_TOKEN";
//	/** 登陆认证对应的listener */
//	private AuthListener mLoginListener = new AuthListener();
//	/** 登出操作对应的listener */
//	private LogOutRequestListener mLogoutListener = new LogOutRequestListener();
//	private AuthInfo mAuthInfo;
//	private Button mCurrentClickedButton;
//
//	@Override
//	protected void onCreate(Bundle savedInstanceState) {
//		setContentView(R.layout.activity_login);
//		super.onCreate(savedInstanceState);
//		getActionBarBase("登录页");
//		initData();
//	}
//
//	private void initData() {
//
//		// 微信授权登录认证请求 oauth request
//		final SendAuth.Req req = new SendAuth.Req();
//		req.scope = "snsapi_userinfo";
//		req.state = "wechat_sdk_demo_test";
//		Tonight8App.getSelf().wxApi.sendReq(req);
//
//		// 微博创建授权认证信息
//		mAuthInfo = new AuthInfo(this, AppConstants.APP_KEY, AppConstants.REDIRECT_URL, AppConstants.SCOPE);
//		btn_sina_login_ok = (Button) findViewById(R.id.btn_sina_login_ok);
//		// btn_sina_login_ok.setWeiboAuthInfo(mAuthInfo, mLoginListener);
//		// btn_sina_login_ok.setExternalOnClickListener(mButtonClickListener);
//	}
//
//	@Override
//	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//		super.onActivityResult(requestCode, resultCode, data);
//
//	}
//
//	/**
//	 * 请注意：为每个 Button 设置一个额外的 Listener 只是为了记录当前点击的 是哪一个 Button，用于在
//	 * {@link #onActivityResult} 函数中进行区分。 通常情况下，我们的应用不需要定义该 Listener。
//	 */
//	private OnClickListener mButtonClickListener = new OnClickListener() {
//		@Override
//		public void onClick(View v) {
//			if (v instanceof Button) {
//				mCurrentClickedButton = (Button) v;
//			}
//		}
//	};
//
//	//
//	// @OnClick({ R.id.btn_sina_login_ok })
//	// public void onClick(View arg0) {
//	// switch (arg0.getId()) {
//	// case R.id.btn_sina_login_ok:
//	// initData();
//	// break;
//	//
//	// default:
//	// break;
//	// }
//	// }
//
//	/**
//	 * 登入按钮的监听器，接收授权结果。
//	 */
//	private class AuthListener implements WeiboAuthListener {
//		@Override
//		public void onComplete(Bundle values) {
//			Oauth2AccessToken accessToken = Oauth2AccessToken.parseAccessToken(values);
//			if (accessToken != null && accessToken.isSessionValid()) {
//				String date = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new java.util.Date(accessToken
//						.getExpiresTime()));
//				String format = "Token：%1$s \n有效期：%2$s";
//				tv_back.setText(String.format(format, accessToken.getToken(), date));
//
//				AccessTokenKeeper.writeAccessToken(getApplicationContext(), accessToken);
//			}
//		}
//
//		@Override
//		public void onWeiboException(WeiboException e) {
//			Toast.makeText(LoginActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
//		}
//
//		@Override
//		public void onCancel() {
//			Toast.makeText(LoginActivity.this, "取消授权", Toast.LENGTH_SHORT).show();
//		}
//	}
//
//	/**
//	 * 登出按钮的监听器，接收登出处理结果。（API 请求结果的监听器）
//	 */
//	private class LogOutRequestListener implements RequestListener {
//		@Override
//		public void onComplete(String response) {
//			if (!TextUtils.isEmpty(response)) {
//				try {
//					JSONObject obj = new JSONObject(response);
//					String value = obj.getString("result");
//
//					if ("true".equalsIgnoreCase(value)) {
//						AccessTokenKeeper.clear(LoginActivity.this);
//						tv_back.setText("已注销");
//					}
//				} catch (JSONException e) {
//					e.printStackTrace();
//				}
//			}
//		}
//
//		@Override
//		public void onWeiboException(WeiboException e) {
//			tv_back.setText("注销失败");
//		}
//	}
//
//}
