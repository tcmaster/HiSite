package com.android.tonight8.utils;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

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
		context.startActivity(new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + phone)));
	}
}
