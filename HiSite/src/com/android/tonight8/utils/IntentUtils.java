package com.android.tonight8.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;

import com.android.tonight8.activity.other.MipcaActivityCapture;

/**
 * @Description：Intent管理类
 * @date 2015-3-7下午5:20:48
 * @author liuzhao
 */
public class IntentUtils {

	/**
	 * @Description：打电话
	 * @date 2015-3-7下午5:20:40
	 * @author liuzhao
	 */
	public static void showCallPhoneDialog(Context context, String phone) {
		context.startActivity(new Intent(Intent.ACTION_CALL, Uri.parse("tel:"
				+ phone)));
	}

	/**
	 * @Description：跳转到二维码扫描界面
	 * @date 2015-3-18下午12:02:53
	 * @author liuzhao
	 */
	public static void startQRScanCodeActivity(Activity activity, int requestCode) {
		Intent intent = new Intent();
		intent.setClass(activity, MipcaActivityCapture.class);
		intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		activity.startActivityForResult(intent, requestCode);
	}
}
