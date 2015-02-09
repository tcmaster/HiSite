package com.android.tonight8.utils;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import com.android.tonight8.base.AppConstants;
import com.android.tonight8.base.Tonight8App;
import com.tencent.connect.share.QQShare;
import com.tencent.mm.sdk.modelmsg.SendMessageToWX;
import com.tencent.mm.sdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.modelmsg.WXTextObject;
import com.tencent.tauth.IUiListener;

public class SharedUtils {

	public static class ShareThirdEntity {

		/** 标题 */
		public String title;
		/** 网络图片url(不包括本地) */
		public String imageUrl;
		/** app的名字 */
		public String appName;
		/** 分享后好友点击的url地址 */
		public String targetUrl;
		/** 分享类型一般为默认（ 纯文本、纯图片、文图、应用分享） */
		public int shareType;
		/** 摘要 */
		public String summary;

	}

	/**
	 * @Description:分享到朋友圈和微信
	 * @param context
	 * @param isFriends true分享到朋友圈
	 * @author: LiuZhao
	 * @date:2015年2月9日
	 */
	 
	public static void shareToWXOrFriends(Context context, boolean isFriends) {
		if (isSupportFriendsShare()) {
			String text = "share our application";
			WXTextObject textObj = new WXTextObject();
			textObj.text = text;

			WXMediaMessage msg = new WXMediaMessage(textObj);
			msg.mediaObject = textObj;
			msg.description = text;
			// 发送文本类型的消息时，title字段不起作用
			// msg.title = "Will be ignored";

			SendMessageToWX.Req req = new SendMessageToWX.Req();
			req.transaction = String.valueOf(System.currentTimeMillis());
			req.message = msg;
			req.scene = isFriends ? SendMessageToWX.Req.WXSceneTimeline : SendMessageToWX.Req.WXSceneSession;
			Tonight8App.getSelf().wxApi.sendReq(req);
		}

	}

	/**
	 * @Description:分享到QQ好友或者QQ空间
	 * @param activity
	 * @param qqShareListener
	 * @param isToQQqzone
	 *            true分享到QQ空间 false分享到QQ好友
	 * @author: LiuZhao
	 * @date:2015年2月9日
	 */

	public static void shareToQQOrQzone(Activity activity, ShareThirdEntity shareThirdEntity, IUiListener qqShareListener, boolean isToQQqzone) {
		int mExtarFlag = 0x00;
		if (shareThirdEntity == null) {
			shareThirdEntity = new ShareThirdEntity();
			return;
		}
		shareThirdEntity.title = "标题";
		shareThirdEntity.shareType = QQShare.SHARE_TO_QQ_TYPE_DEFAULT;
		// 网络图片url
		shareThirdEntity.imageUrl = "http://img3.douban.com/lpic/s3635685.jpg";
		shareThirdEntity.appName = "app的名字";
		// 分享后好友点击打开的目标链接地址
		shareThirdEntity.targetUrl = "http://douban.fm/?start=8508g3c27g-3&amp;cid=-3";
		shareThirdEntity.summary = "摘要，再多加两句话";
		if (isToQQqzone) {
			// 隐藏分享到空间
			mExtarFlag |= QQShare.SHARE_TO_QQ_FLAG_QZONE_AUTO_OPEN;
		} else {
			// 显示分享到空间对话框
			mExtarFlag |= QQShare.SHARE_TO_QQ_FLAG_QZONE_ITEM_HIDE;
		}

		Bundle bundle = new Bundle();
		bundle.putString(QQShare.SHARE_TO_QQ_TITLE, shareThirdEntity.title);
		bundle.putString(QQShare.SHARE_TO_QQ_IMAGE_URL, shareThirdEntity.imageUrl);
		bundle.putString(QQShare.SHARE_TO_QQ_APP_NAME, shareThirdEntity.appName);
		bundle.putString(QQShare.SHARE_TO_QQ_TARGET_URL, shareThirdEntity.targetUrl);
		bundle.putString(QQShare.SHARE_TO_QQ_SUMMARY, shareThirdEntity.summary);
		bundle.putInt(QQShare.SHARE_TO_QQ_KEY_TYPE, shareThirdEntity.shareType);
		bundle.putInt(QQShare.SHARE_TO_QQ_EXT_INT, mExtarFlag);

		Tonight8App.getSelf().mTencent.shareToQQ(activity, bundle, qqShareListener);

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
}
