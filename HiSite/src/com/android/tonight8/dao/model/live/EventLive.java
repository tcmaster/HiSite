package com.android.tonight8.dao.model.live;

import java.util.List;

import com.android.tonight8.dao.entity.Event;
import com.android.tonight8.dao.entity.Seller;

/**
 * @Descripton 活动现场详情
 * @author LiXiaoSong
 * @2015-6-11
 * @Tonight8
 */
public class EventLive {
	private Event event;
	private List<Seller> sellers;

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	public List<Seller> getSellers() {
		return sellers;
	}

	public void setSellers(List<Seller> sellers) {
		this.sellers = sellers;
	}

	@Override
	public String toString() {
		return "EventLive [event=" + event + ", sellers=" + sellers + "]";
	}

}
