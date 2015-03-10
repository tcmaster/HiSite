package com.android.tonight8.model.manageevent;

import com.android.tonight8.model.BaseModel;
import com.android.tonight8.model.common.Event;
import com.android.tonight8.model.common.Exchange;
import com.android.tonight8.model.common.PopGoods;

/**
 * @Description：活动中奖管理（商家）
 * @date 2015-3-7下午2:45:57
 * @author liuzhao
 */
public class ManageAwardEventModel extends BaseModel {

	/** */
	private static final long serialVersionUID = 1L;
	/** 活动对象 */
	public Event event;
	/** 兑奖对象 */
	public Exchange exchange;
	/** 活动海报 */
	public PopGoods popGoods;

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	public Exchange getExchange() {
		return exchange;
	}

	public void setExchange(Exchange exchange) {
		this.exchange = exchange;
	}

	public PopGoods getPopGoods() {
		return popGoods;
	}

	public void setPopGoods(PopGoods popGoods) {
		this.popGoods = popGoods;
	}

}
