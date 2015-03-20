package com.android.tonight8.dao.entity;

public class EventList {
	private Event event;
	private PopGoods popGoods;
	private Org org;
	private CouponProvide couponProvide;
	private Exchange exchange;

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

	public Org getOrg() {
		return org;
	}

	public void setOrg(Org org) {
		this.org = org;
	}

	public CouponProvide getCouponProvide() {
		return couponProvide;
	}

	public void setCouponProvide(CouponProvide couponProvide) {
		this.couponProvide = couponProvide;
	}

	public Exchange getExchange() {
		return exchange;
	}

	public void setExchange(Exchange exchange) {
		this.exchange = exchange;
	}

	@Override
	public String toString() {
		return "EventList [event=" + event + ", popGoods=" + popGoods
				+ ", org=" + org + ", couponProvide=" + couponProvide
				+ ", exchange=" + exchange + "]";
	}

}
