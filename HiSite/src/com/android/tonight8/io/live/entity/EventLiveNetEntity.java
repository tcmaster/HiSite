package com.android.tonight8.io.live.entity;

import com.android.tonight8.dao.model.live.EventLive;

/**
 * @Descripton 活动现场详情
 * @author LiXiaoSong
 * @2015-6-11
 * @Tonight8
 */
public class EventLiveNetEntity {
	private EventLive eventLive;

	public EventLive getEventLive() {
		return eventLive;
	}

	public void setEventLive(EventLive eventLive) {
		this.eventLive = eventLive;
	}

	@Override
	public String toString() {
		return "EventLiveNetEntity [eventLive=" + eventLive + "]";
	}

}
