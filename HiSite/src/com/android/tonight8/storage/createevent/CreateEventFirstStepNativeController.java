package com.android.tonight8.storage.createevent;

import android.content.Context;
import android.content.SharedPreferences;
import com.android.tonight8.model.common.Event;
import com.android.tonight8.model.common.Goods;
import com.android.tonight8.model.createevent.CreateEventModel;

/**
 * 发活动第一步本地存储
 * 
 * @author liuzhao
 * @date 2015-1-24
 */
public class CreateEventFirstStepNativeController {
	private String STORE_NAME = "CREATE_EVENT";
	private SharedPreferences preference;

	public CreateEventFirstStepNativeController(Context context) {
		super();
		preference = context.getSharedPreferences(STORE_NAME,
				Context.MODE_PRIVATE);

	}

	/**
	 * 存到本地
	 * 
	 * @param createEventModel
	 */
	public void SaveCreateEventFirstStep(CreateEventModel createEventModel) {
		Goods goods = createEventModel.goods;
		Event event = createEventModel.event;
		SharedPreferences.Editor editor = preference.edit();
		editor.putString("event_name", event.name);
		editor.putString("event_publishTime", event.publishTime);
		editor.putString("event_timeRangeStart", event.timeRangeStart);
		editor.putString("event_timeRangeEnd", event.timeRangeEnd);
		editor.putString("goods_name", goods.name);
		editor.putString("goods_pic", goods.pic);
		editor.putInt("goods_price", goods.price);
		editor.putInt("event_winningLimit", event.winningLimit);
		editor.commit();
		return;
	}

	/**
	 * 读取本地存储的发活动第一步信息
	 * 
	 * @return
	 */
	public CreateEventModel ReadCreateEventFirstStep() {
		CreateEventModel createEventModel = new CreateEventModel();
		Event event = new Event();
		Goods goods = new Goods();
		event.setName(preference.getString("event_name", ""));
		event.setPublishTime(preference.getString("event_publishTime", ""));
		event.setTimeRangeStart(preference
				.getString("event_timeRangeStart", ""));
		event.setTimeRangeEnd(preference.getString("event_timeRangeEnd", ""));
		goods.setName(preference.getString("goods_name", ""));
		goods.setPic(preference.getString("goods_pic", ""));
		goods.setPrice(preference.getInt("goods_price", 0));
		event.setWinningLimit(preference.getInt("event_winningLimit", 0));
		createEventModel.setEvent(event);
		return createEventModel;
	}

	/**
	 * 清空数据
	 */
	public void DeleteCreateEventFirstStep() {
		SharedPreferences.Editor editor = preference.edit();
		editor.clear();
		editor.commit();
		return;
	}
}
