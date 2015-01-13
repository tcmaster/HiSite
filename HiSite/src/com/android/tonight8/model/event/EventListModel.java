package com.android.tonight8.model.event;

import com.android.tonight8.model.BaseModel;
import com.android.tonight8.model.common.Coupon;
import com.android.tonight8.model.common.Event;
import com.android.tonight8.model.common.Exchange;
import com.android.tonight8.model.common.Org;

/**
 * 活动开奖列表
 */
public class EventListModel extends BaseModel {
	private static final long serialVersionUID = 1L;
	/** 活动 */
	public Event event;
	/** 商家 */
	public Org org;
	/** 优惠券 */
	public Coupon coupon;
	/** 兑奖 */
	public Exchange exchange;

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	public Org getOrg() {
		return org;
	}

	public void setOrg(Org org) {
		this.org = org;
	}

	public Coupon getCoupon() {
		return coupon;
	}

	public void setCoupon(Coupon coupon) {
		this.coupon = coupon;
	}

	public Exchange getExchange() {
		return exchange;
	}

	public void setExchange(Exchange exchange) {
		this.exchange = exchange;
	}

	@Override
	public String toString() {
		return "EventListModel [event=" + event + ", org=" + org + ", coupon="
				+ coupon + ", exchange=" + exchange + "]";
	}

}
