/**
 * 2015-2-26
 */
package com.android.tonight8.utils;

import com.lidroid.xutils.util.LogUtils;

/**
 * @Description:测试工具类
 * @author:LiXiaoSong
 * @copyright @HiSite
 * @Date:2015-2-26
 */
public class TestUtils {

	private static boolean enabled = true;
	private long begin;
	private long end;

	/**
	 * @Description: 测试时间开始
	 * @author: LiXiaoSong
	 * @date:2015-2-26
	 */
	public void testTimeBegin() {
		if (enabled)
			begin = System.currentTimeMillis();
	}

	/**
	 * @Description:测试时间结束
	 * @author: LiXiaoSong
	 * @date:2015-2-26
	 */
	public void testTimeEnd(String attachmentStr) {
		if (enabled) {
			end = System.currentTimeMillis();
			LogUtils.v(attachmentStr + "耗时" + (end - begin) + "ms");
		}
	}

}
