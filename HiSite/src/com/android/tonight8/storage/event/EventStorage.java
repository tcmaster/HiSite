package com.android.tonight8.storage.event;

import java.lang.ref.SoftReference;

public class EventStorage {

	/** 活动推荐控制类对象 */
	private static SoftReference<RecommendDBController> rdc = new SoftReference<RecommendDBController>(new RecommendDBController());

	/**
	 * @Description:获取活动推荐数据
	 * @return
	 * @author: LiXiaoSong
	 * @date:2015-1-20
	 */
	public static RecommendDBController getRecommandsDBController() {
		if (rdc.get() == null) {
			rdc = new SoftReference<RecommendDBController>(new RecommendDBController());
		}
		return rdc.get();
	}
}
