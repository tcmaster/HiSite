/**
 * 2015-2-12
 */
package com.android.tonight8.io;

import android.os.Handler;
import android.os.Message;

/**
 * @Description:
 * @author:LiXiaoSong
 * @copyright @HiSite
 * @Date:2015-2-12
 */
public class HandlerConstants {

	// --------------------------发送的全局状态变量---------------
	public static final int RESULT_OK = 1;
	public static final int NETWORK_BEGIN = 2;
	public static final int NETWORK_END = 3;
	public static final int RESULT_FAIL = 4;

	// ---------------------------发送的标识（确定发给谁）--------
	public static interface Event {// 活动相关
		/** 首页上部 */
		public static final int MAINPAGE_TOP = 101;
		/** 首页列表 */
		public static final int MAINPAGE_LIST = 102;
		/** 详情部分 */
		public static final int EVENT_DETAIL = 103;
		/** 详情部分右下咨询 */
		public static final int EVENT_DETAIL_CONSULT = 104;
		public static final int EVENT_BILL_LIST = 105;
	}

	public static interface Live {
		/** 现场直播title */
		public static final int LIVE_TITLE = 201;
		/** 现场评论 */
		public static final int LIVE_COMMIT = 202;
		/** 中奖名单 */
		public static final int LIVE_WINNER_LIST = 203;
		/** 商品详情 */
		public static final int GOODS_DETAIL = 204;
		/** 商品口碑 */
		public static final int GOODS_COMMENT = 205;
		/** 商品订单展示 */
		public static final int GOODS_ORDER = 206;
	}

	public static interface WISH {// 心愿相关
		/** 心愿赞助列表 */
		public static final int WISH_SPONOR_LIST = 301;
		/** 心愿首页列表 （已实现） */
		public static final int WISH_LIST_REALIZED = 302;
		/** 心愿首页列表（未实现） */
		public static final int WISH_LIST_UNREALIZED = 303;
		/** 心愿详情 */
		public static final int WISH_DETAIL = 304;
		/** 心愿赞助录入 */
		public static final int WISH_SPONOR_POST = 305;
		/** 心愿赞助清单 */
		public static final int WISH_SPONOR_CHECK_LIST = 306;
		/** 心愿讨论区 */
		public static final int WISH_LIVE_TALK = 307;
		/** 我的心愿：赞助的心愿 */
		public static final int MYWISH_SPONSOR = 308;
		/** 我的心愿：我发布的心愿*/
		public static final int MYWISH_POST = 309;
		/** 我制作的心愿提交*/
		public static final int MAKEWISH_POST = 310;
		/** 我的心愿赞助回复*/
		public static final int MYWISH_REPLAY = 311;
	}

	/**
	 * @param 发送一条handler消息
	 * @param handler
	 *            发送消息的handler
	 * @param obj
	 *            要发送的数据(没有的话，传null即可）
	 * @param what
	 *            向哪个内容发送
	 * @param arg1
	 *            当前发送的状态（开始，结束，网络状况良好，较差）
	 * @param arg2
	 *            附加信息
	 * @param objs
	 *            额外使用到的信息
	 */
	public static void sendMessage(Handler handler, Object obj, int what,
			int arg1, int arg2) {
		Message msg = handler.obtainMessage();
		msg.what = what;
		msg.arg1 = arg1;
		msg.arg2 = arg2;
		msg.obj = obj;
		handler.sendMessage(msg);
	}

}
