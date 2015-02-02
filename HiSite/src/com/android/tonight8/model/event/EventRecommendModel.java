package com.android.tonight8.model.event;

import com.android.tonight8.model.BaseModel;
import com.android.tonight8.model.common.Event;
import com.android.tonight8.model.common.PopGoods;

/**
 * 活动推荐
 * 
 * @author LiXiaoSong
 * 
 */
public class EventRecommendModel extends BaseModel {

	private static final long serialVersionUID = 1L;
	public Event event;
	/***/
	public PopGoods popGoods;

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	public PopGoods getPopGoods() {
		return popGoods;
	}

	public void setPopGoods(PopGoods popGoods) {
		this.popGoods = popGoods;
	}

	@Override
	public String toString() {
		return "EventRecommendModel [event=" + event + ", popGoods=" + popGoods + "]";
	}

}
