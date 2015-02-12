/**
 * 2015-2-12
 */
package com.android.tonight8.io.event.entity;

import java.util.ArrayList;

import com.android.tonight8.io.net.NetEntityBase;
import com.android.tonight8.model.event.EventRecommendModel;

/**
 * @Description:活动推荐网络实体
 * @author:LiXiaoSong
 * @copyright @HiSite
 * @Date:2015-2-12
 */
public class EventRecommendNetEntity extends NetEntityBase {

	public ArrayList<EventRecommendModel> eventPublishRecommends;

	public ArrayList<EventRecommendModel> getEventPublishRecommends() {
		return eventPublishRecommends;
	}

	public void setEventPublishRecommends(ArrayList<EventRecommendModel> eventPublishRecommends) {
		this.eventPublishRecommends = eventPublishRecommends;
	}

	@Override
	public String toString() {
		return "EventRecommendNetEntity [eventPublishRecommends=" + eventPublishRecommends + "]";
	}

}
