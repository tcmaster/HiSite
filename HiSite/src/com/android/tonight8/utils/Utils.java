package com.android.tonight8.utils;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.Toast;

import com.android.tonight8.base.Tonight8App;
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
		if (Tonight8App.toastMgr.builder != null) {
			Tonight8App.toastMgr.builder.display(strMsg, Toast.LENGTH_SHORT);
		}
	}

	public static void toast(int msg) {
		if (Tonight8App.toastMgr.builder != null) {
			Tonight8App.toastMgr.builder.display(msg, Toast.LENGTH_SHORT);
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
    /** 
     * 根据手机的分辨率从 dp 的单位 转成为 px(像素) 
     */  
    public static int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;  
        return (int) (dpValue * scale + 0.5f);  
    }  
  
    /** 
     * 根据手机的分辨率从 px(像素) 的单位 转成为 dp 
     */  
    public static int px2dip(Context context, float pxValue) {
        final float scale = context.getResources().getDisplayMetrics().density;  
        return (int) (pxValue / scale + 0.5f);  
    }
	/**
	 * 隐藏软键盘
	 * 
	 * @param activity
	 *            要隐藏软键盘的activity
	 */
	public static void hideSoftKeyBoard(Activity activity) {
		final View v = activity.getWindow().peekDecorView();
		if (v != null && v.getWindowToken() != null) {
			try {
				((InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE)).hideSoftInputFromWindow(activity.getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
			} catch (Exception e) {

			}
		}
	}

	/**
	 * 显示软键盘
	 * 
	 * @param context
	 * @param editText
	 */
	public static void showSoftKeyBroad(Context context, EditText editText) {
		InputMethodManager mgr = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
		mgr.showSoftInput(editText, InputMethodManager.SHOW_IMPLICIT);
	}
}