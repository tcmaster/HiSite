package com.android.utils;

import com.android.hisite.R;

import cn.sharesdk.onekeyshare.OnekeyShare;
import cn.sharesdk.onekeyshare.OnekeyShareTheme;
import android.content.Context;
import android.view.View;

public class SharedUtils {

	public static void showShare(Context context, boolean silent, String platform, boolean captureView) {
//		final OnekeyShare oks = new OnekeyShare();
//		View view = null;
//
//		oks.setNotification(R.drawable.ic_launcher, context.getString(R.string.app_name));
//		// oks.setAddress("12345678901");
//		oks.setTitle("");
//		oks.setTitleUrl("");
//		String customText = "";
//
//		if (captureView) {
//			oks.setViewToShare(view);
//		} else {
//			oks.setImagePath(CustomShareFieldsPage.getString("imagePath", MainActivity.TEST_IMAGE));
//			oks.setImageUrl(CustomShareFieldsPage.getString("imageUrl", MainActivity.TEST_IMAGE_URL));
//			oks.setImageArray(new String[] { MainActivity.TEST_IMAGE, MainActivity.TEST_IMAGE_URL });
//		}
//		oks.setUrl(CustomShareFieldsPage.getString("url", "http://www.mob.com"));
//		oks.setFilePath(CustomShareFieldsPage.getString("filePath", MainActivity.TEST_IMAGE));
//		oks.setComment(CustomShareFieldsPage.getString("comment", context.getString(R.string.share)));
//		oks.setSite(CustomShareFieldsPage.getString("site", context.getString(R.string.app_name)));
//		oks.setSiteUrl(CustomShareFieldsPage.getString("siteUrl", "http://mob.com"));
//		oks.setVenueName(CustomShareFieldsPage.getString("venueName", "ShareSDK"));
//		oks.setVenueDescription(CustomShareFieldsPage.getString("venueDescription", "This is a beautiful place!"));
//		oks.setLatitude(23.056081f);
//		oks.setLongitude(113.385708f);
//		oks.setSilent(silent);
//		oks.setShareFromQQAuthSupport(shareFromQQLogin);
//		String theme = CustomShareFieldsPage.getString("theme", "skyblue");
//		if (OnekeyShareTheme.SKYBLUE.toString().toLowerCase().equals(theme)) {
//			oks.setTheme(OnekeyShareTheme.SKYBLUE);
//		} else {
//			oks.setTheme(OnekeyShareTheme.CLASSIC);
//		}
//
//		if (platform != null) {
//			oks.setPlatform(platform);
//		}
//
//		// 令编辑页面显示为Dialog模式
//		oks.setDialogMode();
//
//		// 在自动授权时可以禁用SSO方式
//		if (!CustomShareFieldsPage.getBoolean("enableSSO", true))
//			oks.disableSSOWhenAuthorize();
//
//		// 去除注释，则快捷分享的操作结果将通过OneKeyShareCallback回调
//		// oks.setCallback(new OneKeyShareCallback());
//
//		// 去自定义不同平台的字段内容
//		oks.setShareContentCustomizeCallback(new ShareContentCustomizeDemo());
//
//		// 为EditPage设置一个背景的View
//		oks.setEditPageBackground(view);
//
//		// 设置kakaoTalk分享链接时，点击分享信息时，如果应用不存在，跳转到应用的下载地址
//		oks.setInstallUrl("http://www.mob.com");
//		// 设置kakaoTalk分享链接时，点击分享信息时，如果应用存在，打开相应的app
//		oks.setExecuteUrl("kakaoTalkTest://starActivity");
//
//		oks.show(context);
	}

}
