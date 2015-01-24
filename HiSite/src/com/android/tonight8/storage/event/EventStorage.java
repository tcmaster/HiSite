package com.android.tonight8.storage.event;

import java.lang.ref.SoftReference;
/**
 * @Descripton 活动本地存储模块
 * @author LiXiaoSong
 * @2015-1-24
 * @Tonight8
 */
public class EventStorage {

	/** 活动推荐本地控制类对象 */
	private static SoftReference<EventRecommendNativeController> rdc = new SoftReference<EventRecommendNativeController>(new EventRecommendNativeController());

	/** 活动列表本地控制类对象 */
	private static SoftReference<EventListNativeController> elc = new SoftReference<EventListNativeController>(new EventListNativeController());

	/**
	 * @Description:获取活动推荐本地控制类
	 * @return
	 * @author: LiXiaoSong
	 * @date:2015-1-20
	 */
	public static EventRecommendNativeController getRecommandsNativeController() {
		if (rdc.get() == null) {
			rdc = new SoftReference<EventRecommendNativeController>(new EventRecommendNativeController());
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
