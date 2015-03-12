package com.android.tonight8.model.event;

import java.util.List;

import com.android.tonight8.model.BaseModel;
import com.android.tonight8.model.common.CouponProvide;
import com.android.tonight8.model.common.Event;
import com.android.tonight8.model.common.Exchange;
import com.android.tonight8.model.common.ExchangeAddress;
import com.android.tonight8.model.common.ExchangeCity;
import com.android.tonight8.model.common.Goods;
import com.android.tonight8.model.common.Org;
import com.android.tonight8.model.common.PopGoods;

/**
 * 活动详情
 * 
 * @author LiXiaoSong
 */
public class EventDetailModel extends BaseModel {

	private static final long serialVersionUID = 1L;
	/** 活动 */
	public Event event;
	/** 商家 */
	public Org org;
	/** 优惠券 */
	public CouponProvide couponProvide;
	/** 兑换 */
	public Exchange exchange;
	/** 海报 */
	public PopGoods popGoods;
	/** 活动奖品 */
	public List<Goods> goodses;
	/** 活动城市*/
	public List<ExchangeCity> exchangeCities;
	/** 城市下的活动地址*/
	public List<ExchangeAddress> exchangeAddresses;
	

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

	public PopGoods getPopGoods() {
		return popGoods;
	}

	public void setPopGoods(PopGoods popGoods) {
		this.popGoods = popGoods;
	}

	public List<Goods> getGoodses() {
		return goodses;
	}

	public void setGoodses(List<Goods> goodses) {
		this.goodses = goodses;
	}
	
	public List<ExchangeCity> getExchangeCities() {
		return exchangeCities;
	}

	public void setExchangeCities(List<ExchangeCity> exchangeCities) {
		this.exchangeCities = exchangeCities;
	}

	public List<ExchangeAddress> getExchangeAddresses() {
		return exchangeAddresses;
	}

	public void setExchangeAddresses(List<ExchangeAddress> exchangeAddresses) {
		this.exchangeAddresses = exchangeAddresses;
	}

	@Override
	public String toString() {
		return "EventDetailModel [event=" + event + ", org=" + org
				+ ", couponProvide=" + couponProvide + ", exchange=" + exchange
				+ ", popGoods=" + popGoods + ", goodses=" + goodses
				+ ", exchangeCities=" + exchangeCities + ", exchangeAddresses="
				+ exchangeAddresses + "]";
	}

	

}
