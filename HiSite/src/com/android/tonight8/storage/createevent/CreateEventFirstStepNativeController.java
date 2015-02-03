package com.android.tonight8.storage.createevent;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.content.SharedPreferences;

import com.android.tonight8.model.common.Event;
import com.android.tonight8.model.common.Goods;

/**
 * 发活动第一步本地存储
 * 
 * @author liuzhao
 * @date 2015-1-24
 */
public class CreateEventFirstStepNativeController {

	public static String STORE_NAME = "CREATE_EVENT";
	private SharedPreferences preference;

	public CreateEventFirstStepNativeController(Context context) {
		super();
		preference = context.getSharedPreferences(STORE_NAME, Context.MODE_PRIVATE);

	}

	/**
	 * 存到本地
	 * 
	 * @param createEventModel
	 */
	public void saveCreateEventFirstStep(Event event) {

		SharedPreferences.Editor editor = preference.edit();
		editor.putString("event_name", event.name);
		editor.putString("event_publishTime", event.publishTime);
		editor.putString("event_timeRangeStart", event.timeRangeStart);
		editor.putString("event_timeRangeEnd", event.timeRangeEnd);
		editor.putInt("event_winningLimit", event.winningLimit);
		editor.putString("event_ruleDesc", event.ruleDesc);
		editor.commit();
		return;
	}

	/**
	 * 存到本地
	 * 
	 * @param createEventModel
	 */
	public void saveCreateEventFirstStep(List<Goods> list) {
		Goods goods = new Goods();
		SharedPreferences.Editor editor = preference.edit();
		// 存取活动奖品列表数量，用于读取
		editor.putInt("list_goods_count", list.size());
		for (int i = 0; i < list.size(); i++) {
			editor.putString("goods_name" + i, goods.name);
			editor.putString("goods_pic" + i, goods.pic);
			editor.putInt("goods_price" + i, goods.price);
		}

		editor.commit();
		return;
	}

	/**
	 * 读取本地存储的发活动第一步信息（活动）
	 * 
	 * @return
	 */
	public Event readCreateEventFirstStepEvent() {
		Event event = new Event();
		event.setName(preference.getString("event_name", ""));
		event.setPublishTime(preference.getString("event_publishTime", ""));
		event.setTimeRangeStart(preference.getString("event_timeRangeStart", ""));
		event.setTimeRangeEnd(preference.getString("event_timeRangeEnd", ""));
		event.setWinningLimit(preference.getInt("event_winningLimit", 0));
		event.setRuleDesc(preference.getString("event_ruleDesc", ""));
		return event;
	}

	/**
	 * 读取本地存储的发活动第一步信息（活动奖品）
	 * 
	 * @return
	 */
	public List<Goods> readCreateEventFirstStepGoods() {
		List<Goods> list = new ArrayList<Goods>();
		int list_goods_count = preference.getInt("list_goods_count", 0);
		for (int i = 0; i < list_goods_count; i++) {
			Goods goods = new Goods();
			goods.setName(preference.getString("goods_name" + i, ""));
			goods.setPic(preference.getString("goods_pic" + i, ""));
			goods.setPrice(preference.getInt("goods_price" + i, 0));
			list.add(goods);
		}
		return list;
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
