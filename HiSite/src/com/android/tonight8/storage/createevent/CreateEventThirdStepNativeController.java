package com.android.tonight8.storage.createevent;

import android.content.Context;
import android.content.SharedPreferences;

import com.android.tonight8.model.common.Event;
import com.android.tonight8.model.common.Exchange;
import com.android.tonight8.model.createevent.CreateEventModel;

/**
 * @Description:发活动第三步本地存储 活动地区和兑奖设置
 * @author:LiuZhao
 * @Date:2015年1月26日
 */
public class CreateEventThirdStepNativeController {

	public static String STORE_NAME = "CREATE_EVENT";
	private SharedPreferences preference;

	public CreateEventThirdStepNativeController(Context context) {
		super();
		preference = context.getSharedPreferences(STORE_NAME, Context.MODE_PRIVATE);

	}

	/**
	 * 存到本地
	 * 
	 * @param createEventModel
	 */
	public void saveCreateEventSecondStep(CreateEventModel createEventModel) {
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
	 * 读取本地存储
	 * 
	 * @return
	 */
	public Event readCreateEventSecondStepEvent() {
		Event event = new Event();
		event.setCityAll(preference.getBoolean("event_cityall", false));
		return event;
	}

	/**
	 * 读取本地存储
	 * 
	 * @return
	 */
	public Exchange readCreateEventSecondStepExchange() {
		Exchange exChange = new Exchange();
		exChange.setAddress(preference.getString("exchange_address", ""));
		exChange.setMethod(preference.getBoolean("exchange_method", true));
		exChange.setOrgAll(preference.getBoolean("exchange_orgall", true));
		return exChange;
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
