package com.android.tonight8.storage.event;

public class EventStorage {

	/**
	 * @Description:获取活动推荐数据
	 * @return
	 * @author: LiXiaoSong
	 * @date:2015-1-20
	 */
	public static RecommendDBController getRecommandsDBController() {
		return new RecommendDBController();
	}
}
