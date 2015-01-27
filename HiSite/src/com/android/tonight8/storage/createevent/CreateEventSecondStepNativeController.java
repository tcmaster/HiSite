package com.android.tonight8.storage.createevent;

import android.content.Context;
import android.content.SharedPreferences;

import com.android.tonight8.model.common.Event;
import com.android.tonight8.model.common.Exchange;
import com.android.tonight8.model.createevent.CreateEventModel;

/**
 * @Description:发活动第二步本地存储 活动地区和兑奖设置
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
	public void SaveCreateEventSecondStep(CreateEventModel createEventModel) {
		Exchange exChange = new Exchange();
		Event event = createEventModel.event;
		SharedPreferences.Editor editor = preference.edit();
		editor.putBoolean("event_cityall", event.cityAll);
		editor.putString("exchange_address", exChange.address);
		editor.putBoolean("exchange_method", exChange.method);
		editor.putBoolean("exchange_orgall", exChange.orgAll);
		editor.commit();
		return;
	}

	/**
	 * 读取本地存储的发活动第一步信息
	 * 
	 * @return
	 */
	public CreateEventModel ReadCreateEventSecondStep() {
		CreateEventModel createEventModel = new CreateEventModel();
		Event event = new Event();
		Exchange exChange = new Exchange();
		event.setName(preference.getString("event_cityall", ""));
		exChange.setAddress(preference.getString("exchange_address", ""));
		exChange.setMethod(preference.getBoolean("exchange_method", true));
		exChange.setOrgAll(preference.getBoolean("exchange_orgall", true));

		createEventModel.setEvent(event);
		createEventModel.setExchange(exChange);
		return createEventModel;
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
