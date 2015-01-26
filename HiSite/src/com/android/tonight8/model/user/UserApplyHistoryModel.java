package com.android.tonight8.model.user;

import com.android.tonight8.model.BaseModel;
import com.android.tonight8.model.common.Coupon;
import com.android.tonight8.model.common.Event;
import com.android.tonight8.model.common.PopGoods;

/**
 * @author liuzhao 用户抽奖历史
 */
public class UserApplyHistoryModel extends BaseModel {

	/** */
	private static final long serialVersionUID = 1L;
	/** 活动对象 */
	public Event event;
	/** 优惠券对象 */
	public Coupon coupon;
	/** 海报对象 */
	public PopGoods popGoods;

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	public Coupon getCoupon() {
		return coupon;
	}

	public void setCoupon(Coupon coupon) {
		coupon = coupon;
	}

	public PopGoods getPopGoods() {
		return popGoods;
	}

	public void setPopGoods(PopGoods popGoods) {
		this.popGoods = popGoods;
	}

	@Override
	public String toString() {
		return "UserApplyHistoryModel [event=" + event + ", Coupon=" + coupon + ", popGoods=" + popGoods + "]";
	}

}
