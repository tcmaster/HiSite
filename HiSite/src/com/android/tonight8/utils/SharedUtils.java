package com.android.tonight8.utils;

import android.content.Context;

import com.android.tonight8.base.AppConstants;
import com.android.tonight8.base.Tonight8App;

public class SharedUtils {

	/**
	 * @Description：
	 * @date 2015-2-7下午4:15:55
	 * @author liuzhao
	 */
	public static void showShare(Context context, boolean silent,
			String platform, boolean captureView) {

	}

	/**
	 * @Description：分享到朋友圈
	 * @date 2015-2-7下午4:17:02
	 * @author liuzhao
	 */
	public static void shareFriends(Context context) {

	}

	/**
	 * @Description：是否支持分享到朋友圈
	 * @date 2015-2-7下午4:15:15
	 * @author liuzhao
	 */
	private boolean isSupportFriendsShare() {
		int wxSdkVersion = Tonight8App.getSelf().wxApi.getWXAppSupportAPI();
		if (wxSdkVersion >= AppConstants.TIMELINE_SUPPORTED_VERSION) {
			return true;
		}
		return false;
	}
}
