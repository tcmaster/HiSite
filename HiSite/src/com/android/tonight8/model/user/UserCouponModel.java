package com.android.tonight8.model.user;

import com.android.tonight8.model.BaseModel;
import com.android.tonight8.model.common.Coupon;
import com.android.tonight8.model.common.Org;

/**
 * @author liuzhao 用户优惠券
 */
public class UserCouponModel extends BaseModel {

	/** */
	private static final long serialVersionUID = 1L;
	/** 优惠券对象 */
	public Coupon Coupon;
	/** 商家对象 */
	public Org org;

	public Coupon getCoupon() {
		return Coupon;
	}

	public void setCoupon(Coupon coupon) {
		Coupon = coupon;
	}

	public Org getOrg() {
		return org;
	}

	public void setOrg(Org org) {
		this.org = org;
	}

}
