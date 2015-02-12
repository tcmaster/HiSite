/**
 * 2015-2-12
 */
package com.android.tonight8.io;

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

		public static final int MAINPAGE_TOP = 1;// 首页上部
		public static final int MAINPAGE_LIST = 2;// 首页列表
	}

}
