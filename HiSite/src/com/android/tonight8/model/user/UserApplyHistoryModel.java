package com.android.tonight8.model.user;

import com.android.tonight8.model.BaseModel;
import com.android.tonight8.model.common.Coupon;
import com.android.tonight8.model.common.Event;

/**
 * @author liuzhao 用户抽奖历史
 */
public class UserApplyHistoryModel extends BaseModel {

	/** */
	private static final long serialVersionUID = 1L;
	/** 活动对象*/
	public Event event;
	/** 优惠券对象*/
	public Coupon Coupon;

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	public Coupon getCoupon() {
		return Coupon;
	}

	public void setCoupon(Coupon coupon) {
		Coupon = coupon;
	}

}
