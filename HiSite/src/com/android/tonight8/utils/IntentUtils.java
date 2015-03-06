package com.android.tonight8.utils;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

public class IntentUtils {

	public static void showListDialog(Context context, String phone) {
		context.startActivity(new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + phone)));
	}
}
