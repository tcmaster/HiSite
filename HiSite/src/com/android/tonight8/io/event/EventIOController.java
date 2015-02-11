package com.android.tonight8.io.event;

import java.util.HashMap;
import java.util.Map;

import android.os.Handler;

import com.android.tonight8.io.event.entity.EventListNetEntity;
import com.android.tonight8.io.net.NetEntityBase;
import com.android.tonight8.io.net.NetRequest;
import com.android.tonight8.io.net.NetRequest.RequestResult;
import com.android.tonight8.storage.event.EventStorage;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.util.LogUtils;

public class EventIOController {

	private static final String EVENT_LIST_URL = NetRequest.BASE_URL + "/api/index/index";

	// 活动开奖列表
	public static void eventsRead(final Handler handler) {
		Map<String, String> params = new HashMap<String, String>();
		params.put(NetRequest.REQUEST_URL, EVENT_LIST_URL);
		params.put("user.coordinate", "39.9,116.3");
		params.put("city.code", "1");
		NetRequest.doGetRequest(params, new RequestResult<EventListNetEntity>(EventListNetEntity.class, handler) {

			@Override
			public void getData(NetEntityBase netEntityBase, EventListNetEntity t, Handler handler) {
				EventStorage.getEventListNativeController().insertData(t.eventPublishEvents);
			}

			@Override
			public void onFailure(HttpException arg0, String arg1) {
				LogUtils.v("why");
			}
		});
	}
}
