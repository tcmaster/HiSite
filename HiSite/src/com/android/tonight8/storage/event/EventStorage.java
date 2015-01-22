package com.android.tonight8.storage.event;

import java.lang.ref.SoftReference;

public class EventStorage {

	/** 活动推荐本地控制类对象 */
	private static SoftReference<RecommendNativeController> rdc = new SoftReference<RecommendNativeController>(new RecommendNativeController());

	/** 活动列表本地控制类对象 */
	private static SoftReference<EventListNativeController> elc = new SoftReference<EventListNativeController>(new EventListNativeController());

	/**
	 * @Description:获取活动推荐本地控制类
	 * @return
	 * @author: LiXiaoSong
	 * @date:2015-1-20
	 */
	public static RecommendNativeController getRecommandsNativeController() {
		if (rdc.get() == null) {
			rdc = new SoftReference<RecommendNativeController>(new RecommendNativeController());
		}
		return rdc.get();
	}

	/**
	 * @Description:获取活动列表本地控制对象
	 * @return
	 * @author: LiXiaoSong
	 * @date:2015-1-21
	 */
	public static EventListNativeController getEventListNativeController() {
		if (elc.get() == null) {
			elc = new SoftReference<EventListNativeController>(new EventListNativeController());
		}
		return elc.get();
	}
}
