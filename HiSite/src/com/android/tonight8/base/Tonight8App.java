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
import com.android.tonight8.storage.DBUtil;
import com.android.tonight8.function.LocationFunction;
import com.android.tonight8.utils.MD5Utils;
import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.mapapi.SDKInitializer;
import com.lidroid.xutils.BitmapUtils;
import com.lidroid.xutils.bitmap.BitmapDisplayConfig;
import com.lidroid.xutils.util.LogUtils;

public class Tonight8App extends Application {

	/** 保存当前Application实例，用于方便调用当前应用的全局变量 */
	private static Tonight8App mApp;
	/** BitmapUtils全局共用实例 */
	public BitmapUtils bitmapUtils;
	/** BitmapUtils管理配置类 */
	public BitmapDisplayConfig config;
	/** 应用名称 */
	public static final String PACKAGE_NAME = "com.android.tonight8";

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
