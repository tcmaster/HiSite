package com.android.tonight8.io.event.entity;

import com.android.tonight8.dao.model.event.EventDetail;
import com.android.tonight8.io.net.NetEntityBase;

/**
 * 
 * @Descripton 活动详情网络实体
 * @author LiXiaoSong
 * @2015-3-7
 * @Tonight8
 */
public class EventDetailNetEntity extends NetEntityBase {
	/** 活动详情 */
	EventDetail eventDetail;

	public EventDetail getEventDetail() {
		return eventDetail;
	}

	public void setEventDetail(EventDetail eventDetail) {
		this.eventDetail = eventDetail;
	}

	@Override
	public String toString() {
		return "EventDetailNetEntity [eventDetail=" + eventDetail + "]";
	}

}
