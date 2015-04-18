package com.android.tonight8.utils;

import java.net.URL;
import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;

import com.android.tonight8.base.AppConstants;
import com.android.tonight8.base.Tonight8App;
import com.sina.weibo.sdk.api.VideoObject;
import com.sina.weibo.sdk.api.WebpageObject;
import com.sina.weibo.sdk.api.WeiboMessage;
import com.sina.weibo.sdk.api.share.IWeiboShareAPI;
import com.sina.weibo.sdk.api.share.SendMessageToWeiboRequest;
import com.sina.weibo.sdk.utils.Utility;
import com.tencent.connect.share.QQShare;
import com.tencent.connect.share.QzoneShare;
import com.tencent.mm.sdk.modelmsg.SendMessageToWX;
import com.tencent.mm.sdk.modelmsg.WXImageObject;
import com.tencent.mm.sdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.modelmsg.WXTextObject;
import com.tencent.mm.sdk.modelmsg.WXWebpageObject;
import com.tencent.tauth.IUiListener;

public class SharedUtils {
	// 分享图片的大小
	private static final int THUMB_SIZE = 150;

	public static class ShareThirdEntity {

		/** 分享的标题,最长30个字符 */
		public String title;
		/** 分享图片的URL，音乐只支持网络链接,分享类型是纯图片时需要分享的本地图片路径 */
		public String imageUrl;
		/** 手Q客户端顶部，替换“返回”按钮文字，如果为空，用返回代替 */
		public String appName;
		/** 分享后好友点击的url地址 */
		public String targetUrl;
		/**
		 * 分享类型（ 图文1、网页2、纯图片3 、分享音乐4、应用分享5 、视频6。类型是图文时：targetUrl和title不能为空
		 */
		public int shareType;
		/** 分享的消息摘要,最长40个字 */
		public String summary;
		/** 分享的音乐时必填的链接 */
		public String audioUrl;

	}

	/**
	 * @Description:分享到朋友圈和微信
	 * @param context
	 * @param isFriends
	 *            true分享到朋友圈
	 * @author: LiuZhao
	 * @date:2015年2月9日
	 */

	public static void shareToWXOrFriends(Context context, ShareThirdEntity shareThirdEntity, boolean isFriends) {
		if (shareThirdEntity == null) {
			shareThirdEntity = new ShareThirdEntity();
			return;
		}
		if (isFriends) {
			if (!isSupportFriendsShare()) {
				Utils.toast("当前微信版本不支持分享到朋友圈");
				return;
			}
		}

		SendMessageToWX.Req req = new SendMessageToWX.Req();
		// 分享图文
		if (shareThirdEntity.shareType == 1) {
			// 初始化一个WXTextObject对象
			WXTextObject textObj = new WXTextObject();
			textObj.text = shareThirdEntity.title;

			// 用WXTextObject对象初始化一个WXMediaMessage对象
			WXMediaMessage msg = new WXMediaMessage();
			msg.mediaObject = textObj;
			// 发送文本类型的消息时，title字段不起作用
			// msg.title = "Will be ignored";
			msg.description = shareThirdEntity.summary;
			// 构造一个Req
			req.transaction = buildTransaction("text"); // transaction字段用于唯一标识一个请求
			req.message = msg;

			// 分享网页
		} else if (shareThirdEntity.shareType == 2) {
			try {
				WXWebpageObject webpage = new WXWebpageObject();
				webpage.webpageUrl = shareThirdEntity.targetUrl;
				WXMediaMessage msg = new WXMediaMessage(webpage);
				msg.title = shareThirdEntity.title;
				msg.description = shareThirdEntity.summary;
				Bitmap bmp = BitmapFactory.decodeStream(new URL(shareThirdEntity.imageUrl).openStream());
				Bitmap thumbBmp = Bitmap.createScaledBitmap(bmp, THUMB_SIZE, THUMB_SIZE, true);
				msg.thumbData = WXUtils.bmpToByteArray(thumbBmp, true);
				req.transaction = buildTransaction("webpage");
				req.message = msg;

			} catch (Exception e) {
				e.printStackTrace();
			}
			// 分享到朋友圈还是微信
			req.scene = isFriends ? SendMessageToWX.Req.WXSceneTimeline : SendMessageToWX.Req.WXSceneSession;
			// 调用api接口发送数据到微信
			Tonight8App.getSelf().wxApi.sendReq(req);

			// 分享纯图片
		} else if (shareThirdEntity.shareType == 3) {

			try {
				WXImageObject imgObj = new WXImageObject();
				imgObj.imageUrl = shareThirdEntity.imageUrl;

				WXMediaMessage msg = new WXMediaMessage();
				msg.mediaObject = imgObj;

				Bitmap bmp = BitmapFactory.decodeStream(new URL(shareThirdEntity.imageUrl).openStream());
				Bitmap thumbBmp = Bitmap.createScaledBitmap(bmp, THUMB_SIZE, THUMB_SIZE, true);
				bmp.recycle();
				msg.thumbData = WXUtils.bmpToByteArray(thumbBmp, true);

				req.transaction = buildTransaction("img");
				req.message = msg;
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

	}

	private static String buildTransaction(final String type) {
		return (type == null) ? String.valueOf(System.currentTimeMillis()) : type + System.currentTimeMillis();
	}

	/**
	 * @Description:分享到QQ好友
	 * @param activity
	 * @param qqShareListener
	 * @author: LiuZhao
	 * @date:2015年2月9日
	 */

	public static void shareToQQ(Activity activity, ShareThirdEntity shareThirdEntity, IUiListener qqShareListener) {
		int mExtarFlag = 0x00;
		if (shareThirdEntity == null) {
			shareThirdEntity = new ShareThirdEntity();
			return;
		}

		Bundle params = new Bundle();
		// 分享图文
		if (shareThirdEntity.shareType == 1 || shareThirdEntity.shareType == 2) {
			params.putInt(QQShare.SHARE_TO_QQ_KEY_TYPE, QQShare.SHARE_TO_QQ_TYPE_DEFAULT);
			params.putString(QQShare.SHARE_TO_QQ_TITLE, shareThirdEntity.title);
			params.putString(QQShare.SHARE_TO_QQ_IMAGE_URL, shareThirdEntity.imageUrl);
			params.putString(QQShare.SHARE_TO_QQ_APP_NAME, shareThirdEntity.appName);
			params.putString(QQShare.SHARE_TO_QQ_TARGET_URL, shareThirdEntity.targetUrl);
			params.putString(QQShare.SHARE_TO_QQ_SUMMARY, shareThirdEntity.summary);
			params.putInt(QQShare.SHARE_TO_QQ_EXT_INT, mExtarFlag);
			// 分享纯图片
		} else if (shareThirdEntity.shareType == 3) {
			params.putString(QQShare.SHARE_TO_QQ_IMAGE_LOCAL_URL, shareThirdEntity.imageUrl);
			params.putString(QQShare.SHARE_TO_QQ_APP_NAME, shareThirdEntity.appName);
			params.putInt(QQShare.SHARE_TO_QQ_KEY_TYPE, QQShare.SHARE_TO_QQ_TYPE_IMAGE);
			params.putInt(QQShare.SHARE_TO_QQ_EXT_INT, QQShare.SHARE_TO_QQ_FLAG_QZONE_AUTO_OPEN);
			// 分享音乐
		} else if (shareThirdEntity.shareType == 4) {
			params.putInt(QQShare.SHARE_TO_QQ_KEY_TYPE, QQShare.SHARE_TO_QQ_TYPE_AUDIO);
			params.putString(QQShare.SHARE_TO_QQ_TITLE, shareThirdEntity.title);
			params.putString(QQShare.SHARE_TO_QQ_SUMMARY, shareThirdEntity.summary);
			params.putString(QQShare.SHARE_TO_QQ_TARGET_URL, shareThirdEntity.targetUrl);
			params.putString(QQShare.SHARE_TO_QQ_IMAGE_URL, shareThirdEntity.imageUrl);
			params.putString(QQShare.SHARE_TO_QQ_AUDIO_URL, shareThirdEntity.audioUrl);
			params.putString(QQShare.SHARE_TO_QQ_APP_NAME, shareThirdEntity.appName);
			params.putInt(QQShare.SHARE_TO_QQ_EXT_INT, QQShare.SHARE_TO_QQ_FLAG_QZONE_AUTO_OPEN);
			// 分享应用
		} else if (shareThirdEntity.shareType == 5) {
			params.putInt(QQShare.SHARE_TO_QQ_KEY_TYPE, QQShare.SHARE_TO_QQ_TYPE_APP);
			params.putString(QQShare.SHARE_TO_QQ_TITLE, shareThirdEntity.title);
			params.putString(QQShare.SHARE_TO_QQ_SUMMARY, shareThirdEntity.summary);
			params.putString(QQShare.SHARE_TO_QQ_IMAGE_URL, shareThirdEntity.imageUrl);
			params.putString(QQShare.SHARE_TO_QQ_APP_NAME, shareThirdEntity.appName);
		}

		Tonight8App.getSelf().mTencent.shareToQQ(activity, params, qqShareListener);

	}

	/**
	 * @Description：分享到QQ空间，目前只支持图文分享
	 * @date 2015-3-20下午5:28:58
	 * @author liuzhao
	 */
	public static void shareToQzone(Activity activity, ShareThirdEntity shareThirdEntity, IUiListener qqShareListener) {
		if (shareThirdEntity == null) {
			shareThirdEntity = new ShareThirdEntity();
			return;
		}
		Bundle bundle = new Bundle();
		bundle.putInt(QzoneShare.SHARE_TO_QZONE_KEY_TYPE, QzoneShare.SHARE_TO_QZONE_TYPE_IMAGE_TEXT);
		bundle.putString(QzoneShare.SHARE_TO_QQ_TITLE, shareThirdEntity.title);
		bundle.putString(QzoneShare.SHARE_TO_QQ_SUMMARY, shareThirdEntity.summary);
		bundle.putString(QzoneShare.SHARE_TO_QQ_TARGET_URL, shareThirdEntity.targetUrl);
		// QZone接口暂不支持发送多张图片的能力，若传入多张图片，则会自动选入第一张图片作为预览图。多图的能力将会在以后支持
		ArrayList<String> imageUrl = new ArrayList<String>();
		imageUrl.add(shareThirdEntity.imageUrl);
		bundle.putStringArrayList(QzoneShare.SHARE_TO_QQ_IMAGE_URL, imageUrl);

		Tonight8App.getSelf().mTencent.shareToQzone(activity, bundle, qqShareListener);

	}

	/**
	 * @Description：是否支持分享到朋友圈
	 * @date 2015-2-7下午4:15:15
	 * @author liuzhao
	 */
	private static boolean isSupportFriendsShare() {
		int wxSdkVersion = Tonight8App.getSelf().wxApi.getWXAppSupportAPI();
		if (wxSdkVersion >= AppConstants.TIMELINE_SUPPORTED_VERSION) {
			return true;
		}
		return false;
	}

	public boolean isInstalledWeibo = Tonight8App.getSelf().mWeiboShareAPI.isWeiboAppInstalled();
	public int supportApiLevel = Tonight8App.getSelf().mWeiboShareAPI.getWeiboAppSupportAPI();

	public static void shareToSinaWeiBo(Activity mActivity, ShareThirdEntity shareThirdEntity) {
		// 获取微博客户端相关信息，如是否安装、支持 SDK 的版本
		boolean isInstalledWeibo = Tonight8App.getSelf().mWeiboShareAPI.isWeiboAppInstalled();
		int supportApiLevel = Tonight8App.getSelf().mWeiboShareAPI.getWeiboAppSupportAPI();
		if (!isInstalledWeibo) {
			sendSingleMessage(mActivity, shareThirdEntity);
		}
	}

	/**
	 * 第三方应用发送请求消息到微博，唤起微博分享界面。 当{@link IWeiboShareAPI#getWeiboAppSupportAPI()}
	 * < 10351 时，只支持分享单条消息，即 文本、图片、网页、音乐、视频中的一种，不支持Voice消息。
	 * 
	 * @param hasText
	 *            分享的内容是否有文本
	 * @param hasImage
	 *            分享的内容是否有图片
	 * @param hasWebpage
	 *            分享的内容是否有网页
	 * @param hasMusic
	 *            分享的内容是否有音乐
	 * @param hasVideo
	 *            分享的内容是否有视频
	 */
	public static void sendSingleMessage(Activity mActivity, ShareThirdEntity shareThirdEntity) {

		// 1. 初始化微博的分享消息
		// 用户可以分享文本、图片、网页、音乐、视频中的一种
		WeiboMessage weiboMessage = new WeiboMessage();

		if (shareThirdEntity.shareType == 3) {

			WebpageObject mediaObject = new WebpageObject();
			mediaObject.identify = Utility.generateGUID();
			mediaObject.title = shareThirdEntity.title;
			mediaObject.description = shareThirdEntity.summary;

			// 设置 Bitmap 类型的图片到视频对象里
			// mediaObject.setThumbImage(shareThirdEntity.imageUrl;
			mediaObject.actionUrl = shareThirdEntity.imageUrl;
			mediaObject.defaultText = "Webpage 默认文案";
			weiboMessage.mediaObject = mediaObject;
		}

		if (shareThirdEntity.shareType == 6) {

			// 创建媒体消息
			VideoObject videoObject = new VideoObject();
			videoObject.identify = Utility.generateGUID();
			videoObject.title = shareThirdEntity.title;
			videoObject.description = shareThirdEntity.summary;

			// 设置 Bitmap 类型的图片到视频对象里
			videoObject.actionUrl = shareThirdEntity.targetUrl;
			videoObject.dataUrl = "www.weibo.com";
			videoObject.dataHdUrl = "www.weibo.com";
			videoObject.duration = 10;
			videoObject.defaultText = "Vedio 默认文案";
			weiboMessage.mediaObject = videoObject;
		}
		/*
		 * if (hasVoice) { weiboMessage.mediaObject = getVoiceObj(); }
		 */

		// 2. 初始化从第三方到微博的消息请求
		SendMessageToWeiboRequest request = new SendMessageToWeiboRequest();
		// 用transaction唯一标识一个请求
		request.transaction = String.valueOf(System.currentTimeMillis());
		request.message = weiboMessage;

		// 3. 发送请求消息到微博，唤起微博分享界面
		Tonight8App.getSelf().mWeiboShareAPI.sendRequest(mActivity, request);
	}

}
