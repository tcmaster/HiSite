package com.android.tonight8.io.event.entity;

import java.util.ArrayList;

import com.android.tonight8.dao.model.event.EventList;
import com.android.tonight8.io.net.NetEntityBase;

/**
 * @Descripton 活动列表网络实体
 * @author LiXiaoSong
 * @2015-2-5
 * @Tonight8
 */
public class EventListNetEntity extends NetEntityBase {

	public ArrayList<EventList> eventList;

	public ArrayList<EventList> getEventList() {
		return eventList;
	}

	public void setEventList(ArrayList<EventList> eventList) {
		this.eventList = eventList;
	}

	@Override
	public String toString() {
		return "EventListNetEntity [eventList=" + eventList + "]";
	}

}
