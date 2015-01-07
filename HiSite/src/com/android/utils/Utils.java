package com.android.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

import com.android.hisite.HiApp;
import com.lidroid.xutils.util.LogUtils;

/**
 * 工具类
 * 
 * @Date:2014年5月22日
 */
public class Utils {

	public static void toast(String strMsg) {
		if (StringUtils.isNullOrEmpty(strMsg)) {
			return;
		}
		if (HiApp.toastMgr.builder != null) {
			HiApp.toastMgr.builder.display(strMsg, Toast.LENGTH_SHORT);
		}

	}

	public static void toast(int msg) {
		if (HiApp.toastMgr.builder != null) {
			HiApp.toastMgr.builder.display(msg, Toast.LENGTH_SHORT);
		}

	}

	/**
	 * 判断是否联网
	 * 
	 * @param context
	 * @return
	 */
	public static boolean isNetConn(Context context) {
		try {
			ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
			NetworkInfo info = connectivityManager.getActiveNetworkInfo();
			if (info != null && info.isAvailable()) {
				String name = info.getTypeName();
				LogUtils.v("联网方式" + name);
				return true;
			} else {
				LogUtils.v("断网");
				return false;
			}
		} catch (Exception e) {
			LogUtils.w(e.toString());
		}
		return false;
	}
}