package com.android.tonight8.storage.createevent;

import android.content.Context;
import android.content.SharedPreferences;

import com.android.tonight8.model.common.Coupon;

/**
 * @Description:发活动第二步本地存储 发优惠券
 * @author:LiuZhao
 * @Date:2015年1月26日
 */
public class CreateEventSecondStepNativeController {

	private String STORE_NAME = "CREATE_EVENT_SECOND";
	private SharedPreferences preference;

	public CreateEventSecondStepNativeController(Context context) {
		super();
		preference = context.getSharedPreferences(STORE_NAME,
				Context.MODE_PRIVATE);

	}

	/**
	 * 存到本地
	 * 
	 * @param createEventModel
	 */
	public void SaveCreateEventSecondStep(Coupon coupon) {

		SharedPreferences.Editor editor = preference.edit();
		editor.putBoolean("coupon_provideall", coupon.provideAll);
		editor.putString("coupon_content", coupon.content);
		editor.putInt("coupon_providetype", coupon.provideType);
		editor.putInt("coupon_value", coupon.value);
		editor.putInt("coupon_providenum", coupon.provideNum);
		editor.putString("coupon_daterangestart", coupon.dateRangeStart);
		editor.putString("coupon_daterangeend", coupon.dateRangeEnd);
		editor.commit();
		return;
	}

	/**
	 * 读取本地存储
	 * 
	 * @return
	 */
	public Coupon ReadCreateEventSecondStep() {
		Coupon coupon = new Coupon();
		coupon.setProvideAll(preference.getBoolean("coupon_provideall", true));
		coupon.setContent(preference.getString("coupon_content", ""));
		coupon.setProvideType(preference.getInt("coupon_providetype", 0));
		coupon.setValue(preference.getInt("coupon_value", 0));
		coupon.setProvideNum(preference.getInt("coupon_providenum", 0));
		coupon.setDateRangeStart(preference.getString("coupon_daterangestart",
				""));
		coupon.setDateRangeEnd(preference.getString("coupon_daterangeend", ""));
		return coupon;
	}

	/**
	 * 清空数据
	 */
	public void DeleteCreateEventSecondStep() {
		SharedPreferences.Editor editor = preference.edit();
		editor.clear();
		editor.commit();
		return;
	}
}
