/**
 * 2015-2-4
 */
package com.android.tonight8.storage.other;

import java.lang.ref.SoftReference;

/**
 * @Description: 其他本地存储模块
 * @author:LiXiaoSong
 * @copyright @HiSite
 * @Date:2015-2-4
 */
public class RegionalStorage {

	/** 活动推荐本地控制类对象 */
	private static SoftReference<RegionalNativeController> rnc = new SoftReference<RegionalNativeController>(new RegionalNativeController());

	public static RegionalNativeController getRegionalNativeController() {
		if (rnc.get() == null) {
			rnc = new SoftReference<RegionalNativeController>(new RegionalNativeController());
		}
		return rnc.get();
	}
}
