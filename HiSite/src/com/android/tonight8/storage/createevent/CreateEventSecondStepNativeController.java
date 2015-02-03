package com.android.tonight8.storage.createevent;

import android.content.Context;
import android.content.SharedPreferences;

import com.android.tonight8.model.common.CouponProvide;
import com.android.tonight8.model.common.Event;

/**
 * @Description:发活动第二步本地存储 发优惠券
 * @author:LiuZhao
 * @Date:2015年1月26日
 */
public class CreateEventSecondStepNativeController {

	public static String STORE_NAME = "CREATE_EVENT";
	private SharedPreferences preference;

	public CreateEventSecondStepNativeController(Context context) {
		super();
		preference = context.getSharedPreferences(STORE_NAME, Context.MODE_PRIVATE);

	}

	/**
	 * 存到本地
	 * 
	 * @param createEventModel
	 */
	public void saveCreateEventSecondStep(Event event, CouponProvide couponProvide) {
		SharedPreferences.Editor editor = preference.edit();
		editor.putBoolean("event_isCouponNoneAward", event.isCouponNoneAward);
		editor.putString("couponProvide_content", couponProvide.content);
		editor.putInt("couponProvide_type", couponProvide.type);
		editor.putInt("couponProvide_value", couponProvide.value);
		editor.putInt("couponProvide_provideNum", couponProvide.provideNum);
		editor.putString("couponProvide_dateRangeStart", couponProvide.dateRangeStart);
		editor.putString("couponProvide_dateRangeEnd", couponProvide.dateRangeEnd);
		editor.commit();
		return;
	}

	/**
	 * 读取本地存储（优惠券）
	 * 
	 * @return
	 */
	public CouponProvide readCreateEventSecondStepCouponProvide() {
		CouponProvide couponProvide = new CouponProvide();
		couponProvide.setContent(preference.getString("couponProvide_content", ""));
		couponProvide.setType(preference.getInt("couponProvide_type", 0));
		couponProvide.setValue(preference.getInt("couponProvide_value", 0));
		couponProvide.setProvideNum(preference.getInt("couponProvide_provideNum", 0));
		couponProvide.setDateRangeStart(preference.getString("couponProvide_dateRangeStart", ""));
		couponProvide.setDateRangeEnd(preference.getString("couponProvide_dateRangeEnd", ""));
		return couponProvide;
	}

	/**
	 * 读取本地存储（活动）
	 * 
	 * @return
	 */
	public Event readCreateEventSecondStepEvent() {
		Event event = new Event();
		event.setWinningStatus(preference.getBoolean("event_isCouponNoneAward", false));
		return event;
	}

	/**
	 * 清空数据
	 */
	public void deleteCreateEventSecondStep() {
		SharedPreferences.Editor editor = preference.edit();
		editor.clear();
		editor.commit();
		return;
	}
}
