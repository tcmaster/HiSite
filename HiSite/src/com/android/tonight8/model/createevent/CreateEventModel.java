package com.android.tonight8.model.createevent;

import java.util.List;

import com.android.tonight8.model.BaseModel;
import com.android.tonight8.model.common.CouponProvide;
import com.android.tonight8.model.common.Event;
import com.android.tonight8.model.common.Exchange;
import com.android.tonight8.model.common.Goods;
import com.android.tonight8.model.common.Org;
import com.android.tonight8.model.common.PopGoods;
import com.android.tonight8.model.common.Ready;

/**
 * @author liuzhao 发布活动
 */
public class CreateEventModel extends BaseModel {

	/** */
	private static final long serialVersionUID = 1L;
	/** 活动对象 */
	public Event event;
	/** 兑奖对象 */
	public Exchange exchange;
	/** 商家 */
	public Org org;
	/** 奖品对象 */
	public List<Goods> goodses;
	/** 优惠券 */
	public CouponProvide couponProvide;
	/** 海报 */
	public PopGoods popGoods;
	/** 准备发活动对象 */
	public Ready ready;

	
	public Ready getReady() {
		return ready;
	}

	
	public void setReady(Ready ready) {
		this.ready = ready;
	}

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

	public Org getOrg() {
		return org;
	}

	public void setOrg(Org org) {
		this.org = org;
	}

	public List<Goods> getGoodses() {
		return goodses;
	}

	public void setGoodses(List<Goods> goodses) {
		this.goodses = goodses;
	}

	public CouponProvide getCouponProvide() {
		return couponProvide;
	}

	public void setCouponProvide(CouponProvide couponProvide) {
		this.couponProvide = couponProvide;
	}

	public PopGoods getPopGoods() {
		return popGoods;
	}

	public void setPopGoods(PopGoods popGoods) {
		this.popGoods = popGoods;
	}

}
