package com.android.tonight8.utils;

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.provider.MediaStore;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
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
			ConnectivityManager connectivityManager = (ConnectivityManager) context
					.getSystemService(Context.CONNECTIVITY_SERVICE);
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
	 * 获取网络连接类型
	 * 
	 * @return -1表示没有网络
	 */
	public static final int TYPE_WIFI = 0;
	public static final int TYPE_3G = 1;
	public static final int TYPE_GPRS = 2;

	public static final int getNetWorkType(Context c) {
		ConnectivityManager conn = (ConnectivityManager) c
				.getSystemService(Context.CONNECTIVITY_SERVICE);
		if (conn == null) {
			return -1;
		}
		NetworkInfo info = conn.getActiveNetworkInfo();
		if (info == null || !info.isAvailable()) {
			return -1;
		}

		int type = info.getType(); // MOBILE（GPRS）;WIFI
		if (type == ConnectivityManager.TYPE_WIFI) {
			return TYPE_WIFI;
		} else if (type == ConnectivityManager.TYPE_MOBILE) {
			return TYPE_3G;
		} else {
			TelephonyManager tm = (TelephonyManager) c
					.getSystemService(Context.TELEPHONY_SERVICE);
			switch (tm.getNetworkType()) {
			case TelephonyManager.NETWORK_TYPE_CDMA:
				return TYPE_GPRS;
			case TelephonyManager.NETWORK_TYPE_EDGE:
				return TYPE_GPRS;
			case TelephonyManager.NETWORK_TYPE_GPRS:
				return TYPE_GPRS;
			default:
				return TYPE_3G;
			}
		}
	}

	/**
	 * @category 将Uri转换为绝对地址
	 * @param contentUri
	 *            Uri内容
	 * @param context
	 *            上下文
	 * @return 绝对地址
	 */
	public static String getRealPathFromURI(Uri contentUri, Context context) {
		String res = null;
		String[] proj = { MediaStore.Images.Media.DATA };
		Cursor cursor = context.getContentResolver().query(contentUri, proj,
				null, null, null);
		if (cursor.moveToFirst()) {
			;
			int column_index = cursor
					.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
			res = cursor.getString(column_index);
		}
		cursor.close();
		return res;
	}

	/**
	 * 
	 * 判断是否尽在Wifi环境下上传图片 "0"为仅在Wifi环境环境下上传 "1"为在3G和Wifi都能上传
	 * 
	 * @author:LiuBing
	 * @see:
	 * @since:
	 * @copyright © soufun.com
	 * @Date:2014年6月25日
	 */
	public static boolean isOnlyWifi(Context c, boolean isService) {
		String cb_choice = "";// 从设置里获取网络网络提醒值
		if ("0".equals(cb_choice)) {
			if (Utils.getNetWorkType(c) == 1) {
				if (!isService) {
					Utils.toast("当前为3G网络，不能上传图片");
				}
				return false;

			} else if (Utils.getNetWorkType(c) == -1) {
				if (!isService) {
					Utils.toast("当前无Wifi");
				}
				return false;
			}
		} else if ("1".equals(cb_choice)) {
			if (Utils.getNetWorkType(c) == 1) {
				if (!isService) {
					Utils.toast("已开启3G上传");
				}
				return true;
			} else if (Utils.getNetWorkType(c) == -1) {
				if (!isService) {
					Utils.toast("当前无可用网络");
				}
				return false;
			}
		}
		return true;
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
				((InputMethodManager) activity
						.getSystemService(Context.INPUT_METHOD_SERVICE))
						.hideSoftInputFromWindow(activity.getCurrentFocus()
								.getWindowToken(),
								InputMethodManager.HIDE_NOT_ALWAYS);
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
		editText.setFocusable(true); 
        editText.setFocusableInTouchMode(true); 
        editText.requestFocus(); 
		InputMethodManager mgr = (InputMethodManager) context
				.getSystemService(Context.INPUT_METHOD_SERVICE);
		mgr.showSoftInput(editText, InputMethodManager.SHOW_IMPLICIT);
	}

	// QQ登录加载对话框
	private static Dialog mProgressDialog;

	public static final void showProgressDialog(Context context, String title,
			String message) {
		dismissDialog();
		if (TextUtils.isEmpty(title)) {
			title = "请稍候";
		}
		if (TextUtils.isEmpty(message)) {
			message = "正在加载...";
		}
		mProgressDialog = ProgressDialog.show(context, title, message);
	}

	public static final void dismissDialog() {
		if (mProgressDialog != null) {
			mProgressDialog.dismiss();
			mProgressDialog = null;
		}
	}
}