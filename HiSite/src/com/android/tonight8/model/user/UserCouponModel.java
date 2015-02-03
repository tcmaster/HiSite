package com.android.tonight8.model.user;

import com.android.tonight8.model.BaseModel;
import com.android.tonight8.model.common.Coupon;
import com.android.tonight8.model.common.CouponProvide;
import com.android.tonight8.model.common.Org;
import com.android.tonight8.model.common.QuickMark;

/**
 * @author liuzhao 用户优惠券
 */
public class UserCouponModel extends BaseModel {

	/** */
	private static final long serialVersionUID = 1L;
	/** 优惠券对象,用户 */
	public Coupon coupon;
	/** 商家对象 */
	public Org org;
	/** 二维码对象 */
	public QuickMark quickMark;
	/** 优惠券对象，商家 */
	public CouponProvide couponProvide;

	public Coupon getCoupon() {
		return coupon;
	}

	public void setCoupon(Coupon coupon) {
		this.coupon = coupon;
	}

	public Org getOrg() {
		return org;
	}

	public void setOrg(Org org) {
		this.org = org;
	}

	public QuickMark getQuickMark() {
		return quickMark;
	}

	public void setQuickMark(QuickMark quickMark) {
		this.quickMark = quickMark;
	}

	public CouponProvide getCouponProvide() {
		return couponProvide;
	}

	public void setCouponProvide(CouponProvide couponProvide) {
		this.couponProvide = couponProvide;
	}

	@Override
	public String toString() {
		return "UserCouponModel [coupon=" + coupon + ", org=" + org + ", quickMark=" + quickMark + ", couponProvide=" + couponProvide + "]";
	}

}
