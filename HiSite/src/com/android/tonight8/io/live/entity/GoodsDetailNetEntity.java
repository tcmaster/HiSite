package com.android.tonight8.io.live.entity;

import com.android.tonight8.dao.model.live.EventGoods;

public class GoodsDetailNetEntity {
	private EventGoods eventGoods;

	public EventGoods getEventGoods() {
		return eventGoods;
	}

	public void setEventGoods(EventGoods eventGoods) {
		this.eventGoods = eventGoods;
	}

	@Override
	public String toString() {
		return "GoodsDetailNetEntity [eventGoods=" + eventGoods + "]";
	}

}
