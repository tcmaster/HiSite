/**
 * 2015-2-12
 */
package com.android.tonight8.io.event.entity;

import java.util.List;

import com.android.tonight8.dao.model.event.EventRecommends;
import com.android.tonight8.io.net.NetEntityBase;

/**
 * @Description:活动推荐网络实体
 * @author:LiXiaoSong
 * @copyright @HiSite
 * @Date:2015-2-12
 */
public class EventRecommendNetEntity extends NetEntityBase {

	private List<EventRecommends> eventRecommends;

	public List<EventRecommends> getEventRecommends() {
		return eventRecommends;
	}

	public void setEventRecommends(List<EventRecommends> eventRecommends) {
		this.eventRecommends = eventRecommends;
	}

	@Override
	public String toString() {
		return "EventRecommendNetEntity [eventRecommends=" + eventRecommends
				+ "]";
	}

}
