package com.android.tonight8.storage.createevent;

import java.util.List;

import android.content.Context;
import android.content.SharedPreferences;

import com.android.tonight8.model.common.CouponProvide;
import com.android.tonight8.model.common.Event;
import com.android.tonight8.model.common.Exchange;
import com.android.tonight8.model.common.Goods;
import com.android.tonight8.model.event.EventDetailModel;

/**
 * @Description:活动预览
 * @author:LiuZhao
 * @Date:2015年2月3日
 */
public class CreateEventPreviewStepNativeController {

	private SharedPreferences preference;
	public static String STORE_NAME = "CREATE_EVENT";
	private Context context;

	public CreateEventPreviewStepNativeController(Context context) {
		super();
		this.context = context;
		preference = context.getSharedPreferences(STORE_NAME, Context.MODE_PRIVATE);

	}

	/**
	 * @Description:获取活动预览信息详情
	 * @return
	 * @author: LiuZhao
	 * @date:2015年2月3日
	 */

	public EventDetailModel getEventDetailModelData() {
		EventDetailModel eventDetailModel = new EventDetailModel();
		Event event = ReadCreateEventPreviewStepEvent();
		eventDetailModel.setEvent(event);

		CreateEventSecondStepNativeController secondController = new CreateEventSecondStepNativeController(context);
		CouponProvide couponProvide = secondController.readCreateEventSecondStepCouponProvide();
		eventDetailModel.setCouponProvide(couponProvide);

		CreateEventFirstStepNativeController fistController = new CreateEventFirstStepNativeController(context);
		List<Goods> goodses = fistController.readCreateEventFirstStepGoods();
		eventDetailModel.setGoodses(goodses);

		CreateEventThirdStepNativeController thirdController = new CreateEventThirdStepNativeController(context);
		Exchange exchange = thirdController.readCreateEventSecondStepExchange();
		eventDetailModel.setExchange(exchange);
		return eventDetailModel;
	}

	/**
	 * 读取本地存储的发活动第一步信息（活动）
	 * 
	 * @return
	 */
	private Event ReadCreateEventPreviewStepEvent() {
		Event event = new Event();
		event.setName(preference.getString("event_name", ""));
		event.setPublishTime(preference.getString("event_publishTime", ""));
		event.setTimeRangeStart(preference.getString("event_timeRangeStart", ""));
		event.setTimeRangeEnd(preference.getString("event_timeRangeEnd", ""));
		event.setWinningLimit(preference.getInt("event_winningLimit", 0));
		event.setRuleDesc(preference.getString("event_ruleDesc", ""));

		event.setWinningStatus(preference.getBoolean("event_isCouponNoneAward", false));

		event.setCityAll(preference.getBoolean("event_cityall", false));
		return event;
	}
}
