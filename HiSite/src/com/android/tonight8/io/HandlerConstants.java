/**
 * 2015-2-12
 */
package com.android.tonight8.io;

import android.os.Handler;
import android.os.Message;

/**
 * @Description:
 * @author:LiXiaoSong
 * @see:
 * @since:
 * @copyright @HiSite
 * @Date:2015-2-12
 */
public class HandlerConstants {

	// --------------------------handler发送的全局状态变量---------------
	public static final int RESULT_OK = 1;
	public static final int NETWORK_BEGIN = 2;
	public static final int NETWORK_END = 3;
	public static final int RESULT_FAIL = 4;

	// ---------------------------handler发送的标识（确定发给谁）--------
	public static interface Event {// 活动相关
		/**首页上部*/
		public static final int MAINPAGE_TOP = 1; 
		/**首页列表*/
		public static final int MAINPAGE_LIST = 2;
		/**详情部分*/
		public static final int EVENT_DETAIL = 3;
		/**详情部分右下咨询*/
		public static final int EVENT_DETAIL_CONSULT = 4;
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
	 */
	public static void sendMessage(Handler handler, Object obj, int what, int arg1, int arg2) {
		Message msg = handler.obtainMessage();
		msg.what = what;
		msg.arg1 = arg1;
		msg.arg2 = arg2;
		msg.obj = obj;
		handler.sendMessage(msg);
	}

}
