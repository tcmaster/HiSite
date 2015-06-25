package com.android.tonight8.io.live.entity;

import java.util.List;

import com.android.tonight8.dao.model.live.EventGoodServiceMark;

public class EventGoodsServiceNetEntity {
	private List<EventGoodServiceMark> eventGoodsServiceMarkList;

	public List<EventGoodServiceMark> getEventGoodsServiceMarkList() {
		return eventGoodsServiceMarkList;
	}

	public void setEventGoodsServiceMarkList(
			List<EventGoodServiceMark> eventGoodsServiceMarkList) {
		this.eventGoodsServiceMarkList = eventGoodsServiceMarkList;
	}

	@Override
	public String toString() {
		return "EventGoodsServiceNetEntity [eventGoodsServiceMarkList="
				+ eventGoodsServiceMarkList + "]";
	}

}
