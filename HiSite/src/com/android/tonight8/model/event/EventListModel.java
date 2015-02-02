package com.android.tonight8.model.event;

import com.android.tonight8.model.BaseModel;
import com.android.tonight8.model.common.CouponProvide;
import com.android.tonight8.model.common.Event;
import com.android.tonight8.model.common.Exchange;
import com.android.tonight8.model.common.Org;
import com.android.tonight8.model.common.PopGoods;

/**
 * 活动开奖列表
 */
public class EventListModel extends BaseModel {

	private static final long serialVersionUID = 1L;
	/** 活动 */
	public Event event;
	/** 活动海报 */
	public PopGoods popGoods;
	/** 商家 */
	public Org org;
	/** 优惠券 */
	public CouponProvide couponProvide;
	/** 兑奖 */
	public Exchange exchange;

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
		return "EventListModel [event=" + event + ", popGoods=" + popGoods + ", org=" + org + ", couponProvide=" + couponProvide + ", exchange=" + exchange + "]";
	}

}
