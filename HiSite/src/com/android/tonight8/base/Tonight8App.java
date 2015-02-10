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
import com.android.tonight8.function.LocationFunction;
import com.android.tonight8.storage.DBUtil;
import com.android.tonight8.utils.MD5Utils;
import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.mapapi.SDKInitializer;
import com.lidroid.xutils.BitmapUtils;
import com.lidroid.xutils.bitmap.BitmapDisplayConfig;
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
	/** 微信的注册id */
	private static final String WX_APP_ID = "";
	/** QQ的注册id */
	private static final String QQ_APP_ID = "";
	/** IWXAPI是第三方APP与微信通信的接口 */
	public IWXAPI wxApi;
	/** Tencent是第三方APP与QQ通信的接口 */
	public Tencent mTencent;

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
		SDKInitializer.initialize(getApplicationContext());
		initDeviceParams();
		// 初始化数据库
		DBUtil.initDB(this);
		bitmapUtils = new BitmapUtils(mApp);
		config = new BitmapDisplayConfig();
//		// 注册到微信
//		wxApi = WXAPIFactory.createWXAPI(this, WX_APP_ID);
//		wxApi.registerApp(WX_APP_ID);
//		// Tencent类是SDK的主要实现类，开发者可通过Tencent类访问腾讯开放的OpenAPI。
//		// 其中APP_ID是分配给第三方应用的appid，类型为String。
//		mTencent = Tencent.createInstance(QQ_APP_ID, this.getApplicationContext());

	}

	/**
	 * @Description:初始化应用必要参数
	 * @author: LiXiaoSong
	 * @date:2014-12-29
	 */
	public void initDeviceParams() {
		WindowManager wm = (WindowManager) getSystemService(WINDOW_SERVICE);
		TelephonyManager tm = (TelephonyManager) this.getSystemService(TELEPHONY_SERVICE);
		DisplayMetrics dm = new DisplayMetrics();
		wm.getDefaultDisplay().getMetrics(dm);
		AppConstants.dpi = dm.densityDpi + "";// 设备分辨率
		AppConstants.heightPx = dm.heightPixels;// 设备像素“高”
		AppConstants.widthPx = dm.widthPixels;// 设备像素“宽”
		AppConstants.imei = tm.getDeviceId();// 设备imei码
		AppConstants.os_version = android.os.Build.VERSION.SDK_INT + "";// 操作系统版本号
		try {
			AppConstants.version = getPackageManager().getPackageInfo(PACKAGE_NAME, 0).versionCode + "";// 应用版本
		} catch (NameNotFoundException e) {
			e.printStackTrace();
		}
		AppConstants.phone_model = android.os.Build.MODEL;// 手机型号
		AppConstants.auth_code = MD5Utils.md5s(AppConstants.version + AppConstants.device_type + AppConstants.imei + AppConstants.dpi + AppConstants.os_version + AppConstants.phone_model + "keleping");
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
