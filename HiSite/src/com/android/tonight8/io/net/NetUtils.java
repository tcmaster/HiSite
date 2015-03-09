/**
 * 2015-2-4
 */
package com.android.tonight8.io.net;

import com.android.tonight8.utils.Utils;

/**
 * @Description:一些网路数据处理的公共方法
 * @author:LiXiaoSong
 * @copyright @HiSite
 * @Date:2015-2-4
 */
public class NetUtils {

	public static boolean checkResult(NetEntityBase base) {
		if (base == null) {
			return false;
		}
		switch (base.status) {
		case 1:
			return true;
		case 2:
			Utils.toast(base.message);
			return false;
		case 3:
			Utils.toast(base.message);
			return false;
		default:
			return false;
		}
	}
}
