package com.android.tonight8.io.live.entity;

import java.util.List;

import com.android.tonight8.model.live.LiveListModel;

/**
 * @Description:现场活动列表的数据
 * @author:LiuZhao
 * @Date:2015年2月5日
 */
public class ArrayLiveEventsData {

	private List<LiveListModel> event_live_events;

	public List<LiveListModel> getEvent_live_events() {
		return event_live_events;
	}

	public void setEvent_live_events(List<LiveListModel> event_live_events) {
		this.event_live_events = event_live_events;
	}

}
