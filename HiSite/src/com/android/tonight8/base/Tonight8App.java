package com.android.tonight8.base;

import android.app.Application;
import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import com.android.tonight8.R;
import com.android.tonight8.easemob.EaseMobManager;
import com.android.tonight8.function.LocationFunction;
import com.android.tonight8.storage.DBUtil;
import com.android.tonight8.storage.GreenDaoUtils;
import com.android.tonight8.utils.MD5Utils;
import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.lidroid.xutils.BitmapUtils;
import com.lidroid.xutils.bitmap.BitmapDisplayConfig;
import com.sina.weibo.sdk.api.share.IWeiboShareAPI;
import com.sina.weibo.sdk.api.share.WeiboShareSDK;
import com.sina.weibo.sdk.auth.AuthInfo;
import com.tencent.mm.sdk.modelpay.PayReq;
import com.tencent.mm.sdk.openapi.IWXAPI;
import com.tencent.mm.sdk.openapi.WXAPIFactory;
import com.tencent.tauth.Tencent;

public class Tonight8App extends Application {

	/** 保存当前Application实例，用于方便调用当前应用的全局变量 */
	private static Tonight8App mApp;
	/** BitmapUtils全局共用实例 */
	public BitmapUtils bitmapUtils;
	/** BitmapUtils管理配置类 */
	public BitmapDisplayConfig config;
	/** 应用名称 */
	public static final String PACKAGE_NAME = "com.android.tonight8";
	// --------------------------新浪微博授权时所需要的参数--------------------
	/** 新浪微博的 APP_KEY */
	public static final String SINA_APP_KEY = "3956016765";
	/** 新浪微博默认回调页：https://api.weibo.com/oauth2/default.html */
	public static final String SINA_REDIRECT_URL = "https://api.weibo.com/oauth2/default.html";
	/** Scope 新是 OAuth2.0 授权机制中 authorize 接口的一个参数。通过 Scope，平台将开放更多的微博信息 */
	public static final String SINA_SCOPE = "email,direct_messages_read";
	/** 新浪微博的 APP_SECRET */
	public static final String SINA_APP_SECRET = "2ea023b56f329f5bf5426416ddc3ddd7";
	/** 新浪微博与第三方APP通信的接口 */
	public AuthInfo mSinaAuth;
	/** 微博分享的接口实例 */
	public IWeiboShareAPI mWeiboShareAPI;
	// --------------------------微信授权时所需要的参数--------------------
	/** 微信与第三方APP通信的接口 */
	public IWXAPI wxApi;
	/** 微信的注册id */
	public static final String WX_APP_ID = "wxb5731b78779c42cf";
	/** 微信的SECRET id */
	public static final String WX_APP_SECRET = "a3657f1d3e772ed6d576ccc455c6e082";
	// --------------------------QQ授权时所需要的参数--------------------
	/** QQ与第三方APP通信的接口 */
	public Tencent mTencent;
	/** QQ的注册id */
	public static final String QQ_APP_ID = "1101316332";

	public Tonight8App() {
		/* 当前应用对像初始化 */
		mApp = this;
	}

	/**
	 * 获取全局的Application静态变量（单例）的方法
	 */
	public static Tonight8App getSelf() {
		return mApp;
	}

	@Override
	public void onCreate() {
		super.onCreate();
		toastMgr.builder.init(mApp);
		// 初始化百度地图
		// SDKInitializer.initialize(getApplicationContext());
		initDeviceParams();
		// 初始化数据库
		DBUtil.initDB(this);
		GreenDaoUtils.init(this);
		bitmapUtils = new BitmapUtils(mApp);
		config = new BitmapDisplayConfig();
		// 注册到微信
		wxApi = WXAPIFactory.createWXAPI(this.getApplicationContext(),
				WX_APP_ID, true);
		wxApi.registerApp(WX_APP_ID);
		// 注册到QQ
		mTencent = Tencent.createInstance(QQ_APP_ID,
				this.getApplicationContext());
		// 注册到微博
		mSinaAuth = new AuthInfo(this, SINA_APP_KEY, SINA_REDIRECT_URL,
				SINA_SCOPE);
		// 创建微博 SDK 接口实例
		mWeiboShareAPI = WeiboShareSDK.createWeiboAPI(this, SINA_APP_KEY);
		mWeiboShareAPI.registerApp();
		// 初始化聊天账号信息
		EaseMobManager.initEaseMob(this);
	}

	/**
	 * 初始化微信支付
	 */
	private void initWXPay() {
		PayReq request = new PayReq();
		request.appId = "wxd930ea5d5a258f4f";
		request.partnerId = "1900000109";
		request.prepayId = "1101000000140415649af9fc314aa427";
		request.packageValue = "Sign=WXPay";
		request.nonceStr = "1101000000140429eb40476f8896f4c9";
		request.timeStamp = "1398746574";
		request.sign = "7FFECB600D7157C5AA49810D2D8F28BC2811827B";
		wxApi.sendReq(request);

	}

	/**
	 * @Description:初始化应用必要参数
	 * @author: LiXiaoSong
	 * @date:2014-12-29
	 */
	public void initDeviceParams() {
		WindowManager wm = (WindowManager) getSystemService(WINDOW_SERVICE);
		TelephonyManager tm = (TelephonyManager) this
				.getSystemService(TELEPHONY_SERVICE);
		DisplayMetrics dm = new DisplayMetrics();
		wm.getDefaultDisplay().getMetrics(dm);
		AppConstants.dpi = dm.densityDpi + "";// 设备分辨率
		AppConstants.heightPx = dm.heightPixels;// 设备像素“高”
		AppConstants.widthPx = dm.widthPixels;// 设备像素“宽”
		AppConstants.imei = tm.getDeviceId();// 设备imei码
		AppConstants.os_version = android.os.Build.VERSION.SDK_INT + "";// 操作系统版本号
		try {
			AppConstants.version = getPackageManager().getPackageInfo(
					PACKAGE_NAME, 0).versionCode
					+ "";// 应用版本
		} catch (NameNotFoundException e) {
			e.printStackTrace();
		}
		AppConstants.phone_model = android.os.Build.MODEL;// 手机型号
		AppConstants.auth_code = MD5Utils.md5s(AppConstants.version
				+ AppConstants.device_type + AppConstants.imei
				+ AppConstants.dpi + AppConstants.os_version
				+ AppConstants.phone_model + "keleping");
		LocationFunction lcf = new LocationFunction(this);
		lcf.beginLocation(new BDLocationListener() {

			private final int GPS_RESULT = 61;// gps定位结果
			private final int NETWORK_RESULT = 161;// 网络定位结果
			private final int GACHE_RESULT = 65;// 缓存定位结果
			private final int OFFLINE_RESULT = 66;// 离线定位结果
			private final int OFFLINE_LOCATION_RESULT = 68;// 本地离线定位结果

			@Override
			public void onReceiveLocation(BDLocation location) {
				if (location != null) {
					switch (location.getLocType()) {
					case GPS_RESULT:

						break;
					case NETWORK_RESULT:

						break;
					case GACHE_RESULT:

						break;
					case OFFLINE_RESULT:

						break;
					case OFFLINE_LOCATION_RESULT:

						break;
					default:
						break;
					}
				}
			}
		});
	}

	public enum toastMgr {
		builder;

		private View v;
		private TextView tv;
		private Toast toast;

		private void init(Context c) {
			v = LayoutInflater.from(c).inflate(R.layout.toast, null);
			tv = (TextView) v.findViewById(R.id.tv_toast);
			toast = new Toast(c);
			toast.setView(v);
			toast.setGravity(Gravity.CENTER, 0, 0);
		}

		public void display(CharSequence text, int duration) {
			if (text.length() != 0) {
				tv.setText(text);
				toast.setDuration(duration);
				toast.show();
			}
		}

		public void display(int Resid, int duration) {
			if (Resid != 0) {
				tv.setText(Resid);
				toast.setDuration(duration);
				toast.show();
			}
		}

		public void display() {
			toast.cancel();
		}

		public Toast getToast() {
			return toast;
		}
	}
}
