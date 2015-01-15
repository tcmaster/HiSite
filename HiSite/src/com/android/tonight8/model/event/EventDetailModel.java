package com.android.tonight8.model.event;

import java.util.List;

import com.android.tonight8.model.BaseModel;
import com.android.tonight8.model.common.Coupon;
import com.android.tonight8.model.common.Event;
import com.android.tonight8.model.common.Goods;
import com.android.tonight8.model.common.Org;

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
	public Coupon coupon;
	/** 活动奖品 */
	public List<Goods> goodses;

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

	public List<Goods> getGoodses() {
		return goodses;
	}

	public void setGoodses(List<Goods> goodses) {
		this.goodses = goodses;
	}

	@Override
	public String toString() {
		return "EventDetailModel [event=" + event + ", org=" + org
				+ ", coupon=" + coupon + ", goodses=" + goodses + "]";
	}

}
