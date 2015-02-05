package com.android.tonight8.io.event.entity;

import java.util.ArrayList;

import com.android.tonight8.model.event.EventListModel;
/**
 * @Descripton 活动列表网络实体
 * @author LiXiaoSong
 * @2015-2-5
 * @Tonight8
 */
public class EventListNetEntity {
	public ArrayList<EventListModel> event_publish_events;

	public ArrayList<EventListModel> getEvent_publish_events() {
		return event_publish_events;
	}

	public void setEvent_publish_events(
			ArrayList<EventListModel> event_publish_events) {
		this.event_publish_events = event_publish_events;
	}

	@Override
	public String toString() {
		return "EventListNetEntity [event_publish_events="
				+ event_publish_events + "]";
	}
	
}
