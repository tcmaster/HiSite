package com.android.tonight8.model.manageevent;

import com.android.tonight8.model.BaseModel;
import com.android.tonight8.model.common.Coupon;
import com.android.tonight8.model.common.User;

/**
 * 促销券管理
 */
public class MangeCouponModel extends BaseModel {

	private static final long serialVersionUID = 1L;
	/** 优惠券对象*/
	public Coupon coupon;
	/** 用户对象*/
	public User user;
	public Coupon getCoupon() {
		return coupon;
	}
	public void setCoupon(Coupon coupon) {
		this.coupon = coupon;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	

}
