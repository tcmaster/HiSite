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
		if (base.status.equals("success")) {// 成功时的处理
			return true;
		} else if (base.status.equals("fail")) {// 失败时的处理
			Utils.toast(base.message);
			return false;
		} else if (base.status.equals("error")) {// 错误时的处理
			Utils.toast(base.message);
			return false;
		} else {
			return false;
		}
	}
}
