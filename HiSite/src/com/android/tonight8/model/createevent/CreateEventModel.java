package com.android.tonight8.model.createevent;

import com.android.tonight8.model.BaseModel;
import com.android.tonight8.model.common.Event;
import com.android.tonight8.model.common.Exchange;

/**
 * @author liuzhao 
 * 发布活动
 */
public class CreateEventModel extends BaseModel {

	/** */
	private static final long serialVersionUID = 1L;
	/** 活动对象*/
	public Event event;
	/** 兑奖对象*/
	public Exchange exchange;
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

}
