package com.android.tonight8.io.live.entity;


/**
 * @Description:接口返回活动现场列表
 * @author:LiuZhao
 * @Date:2015年2月5日
 */
public class LiveListNetEntity {

	public ArrayLiveEventsData event_live_events;

	public ArrayLiveEventsData getEvent_live_events() {
		return event_live_events;
	}

	public void setEvent_live_events(ArrayLiveEventsData event_live_events) {
		this.event_live_events = event_live_events;
	}
}
