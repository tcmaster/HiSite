package com.android.tonight8.dao.model.event;

import java.util.List;

import com.android.tonight8.dao.entity.CouponProvide;
import com.android.tonight8.dao.entity.DetailPic;
import com.android.tonight8.dao.entity.Event;
import com.android.tonight8.dao.entity.Exchange;
import com.android.tonight8.dao.entity.ExchangeAddress;
import com.android.tonight8.dao.entity.ExchangeCity;
import com.android.tonight8.dao.entity.Org;
import com.android.tonight8.dao.entity.PopPic;
import com.android.tonight8.dao.entity.Prize;

/**
 * 活动详情实体
 * 
 * @Descripton
 * @author LiXiaoSong
 * @2015-6-4
 * @Tonight8
 */
public class EventDetail {
	private Event event;
	private Org org;
	private CouponProvide couponProvide;
	private Exchange exchange;
	private List<ExchangeCity> exchangeCities;
	private List<ExchangeAddress> exchangeAddresses;
	private Prize prize;
	private List<PopPic> popPics;
	private List<DetailPic> detailPics;

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

	public Prize getPrize() {
		return prize;
	}

	public void setPrize(Prize prize) {
		this.prize = prize;
	}

	public List<PopPic> getPopPics() {
		return popPics;
	}

	public void setPopPics(List<PopPic> popPics) {
		this.popPics = popPics;
	}

	public List<DetailPic> getDetailPics() {
		return detailPics;
	}

	public void setDetailPics(List<DetailPic> detailPics) {
		this.detailPics = detailPics;
	}

	@Override
	public String toString() {
		return "EventDetail [event=" + event + ", org=" + org
				+ ", couponProvide=" + couponProvide + ", exchange=" + exchange
				+ ", exchangeCities=" + exchangeCities + ", exchangeAddresses="
				+ exchangeAddresses + ", prize=" + prize + ", popPics="
				+ popPics + ", detailPics=" + detailPics + "]";
	}

}
