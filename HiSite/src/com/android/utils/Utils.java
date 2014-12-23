package com.android.utils;

import android.widget.Toast;
import com.android.hisite.HiApp;

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
}