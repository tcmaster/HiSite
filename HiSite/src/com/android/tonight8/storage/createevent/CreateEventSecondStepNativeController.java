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
		preference = context.getSharedPreferences(STORE_NAME, Context.MODE_PRIVATE);

	}

	/**
	 * 存到本地
	 * 
	 * @param createEventModel
	 */
	public void SaveCreateEventSecondStep(Coupon coupon) {

		return;
	}

	/**
	 * 读取本地存储
	 * 
	 * @return
	 */
	public Coupon ReadCreateEventSecondStep() {
		return null;
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
