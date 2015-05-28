package com.android.tonight8.io.event;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.os.Handler;

import com.android.tonight8.io.HandlerConstants;
import com.android.tonight8.io.event.entity.EventConsultListEntity;
import com.android.tonight8.io.event.entity.EventDetailNetEntity;
import com.android.tonight8.io.event.entity.EventListNetEntity;
import com.android.tonight8.io.event.entity.EventRecommendNetEntity;
import com.android.tonight8.io.net.NetEntityBase;
import com.android.tonight8.io.net.NetRequest;
import com.android.tonight8.io.net.NetRequest.RequestResult;
import com.android.tonight8.model.event.EventConsultModel;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.util.LogUtils;

public class EventIOController {

	private static final String EVENT_LIST_URL = NetRequest.BASE_URL
			+ "/api/index/index";
	private static final String EVENT_RECOMMAND_URL = NetRequest.BASE_URL + "";
	private static final String EVENT_DETAIL_URL = NetRequest.BASE_URL + "";
	private static final String EVENT_EVENT_PUBLISH_CONSULTS = NetRequest.BASE_URL
			+ "";

	/**
	 * @Description:活动开奖列表
	 * @param handler
	 * @author: LiXiaoSong
	 * @date:2015-2-12
	 */
	public static void eventsRead(final Handler handler,
			final int... attachments) {
		Map<String, String> params = new HashMap<String, String>();
		params.put(NetRequest.REQUEST_URL, EVENT_LIST_URL);
		params.put("user.coordinate", "39.9,116.3");
		params.put("city.code", "1");
		HandlerConstants.sendMessage(handler, null,
				HandlerConstants.Event.MAINPAGE_LIST,
				HandlerConstants.NETWORK_BEGIN, attachments[0]);
		NetRequest.doGetRequest(params, new RequestResult<EventListNetEntity>(
				EventListNetEntity.class, handler) {

			@Override
			public void getData(NetEntityBase netEntityBase,
					EventListNetEntity t, Handler handler) {
				LogUtils.v("the t is " + t);
				// EventStorage.getEventListNativeController().insertData(
				// t.getEvent_publish_events());
				// HandlerConstants.sendMessage(
				// handler,
				// //EventStorage.getEventListNativeController().selectData(
				// // attachments[1], attachments[2]),
				// HandlerConstants.Event.MAINPAGE_LIST,
				// HandlerConstants.RESULT_OK, attachments[0]);
			}

			@Override
			public void onFailure(HttpException arg0, String arg1) {
				LogUtils.v("why");
				HandlerConstants.sendMessage(handler, null,
						HandlerConstants.Event.MAINPAGE_LIST,
						HandlerConstants.RESULT_FAIL, attachments[0]);
			}
		});
	}

	/**
	 * @Description:活动推荐
	 * @param handler
	 * @author: LiXiaoSong
	 * @date:2015-2-12
	 */
	public static void eventRecommend(final Handler handler) {
		Map<String, String> params = new HashMap<String, String>();
		params.put(NetRequest.REQUEST_URL, EVENT_RECOMMAND_URL);
		NetRequest.doGetRequest(params,
				new RequestResult<EventRecommendNetEntity>(
						EventRecommendNetEntity.class, handler) {

					@Override
					public void getData(NetEntityBase netEntityBase,
							EventRecommendNetEntity t, Handler handler) {

					}

					@Override
					public void onFailure(HttpException arg0, String arg1) {
					}
				});
	}

	/**
	 * @Description:活动详情
	 * @param handler
	 * @author: LiXiaoSong
	 * @date:2015-2-12
	 */
	public static void eventDetailRead(final Handler handler,
			int... attachments) {
		Map<String, String> params = new HashMap<String, String>();
		params.put(NetRequest.REQUEST_URL, EVENT_DETAIL_URL);
		HandlerConstants.sendMessage(handler, null,
				HandlerConstants.Event.EVENT_DETAIL,
				HandlerConstants.NETWORK_BEGIN, 0);
		NetRequest.doGetRequest(params,
				new RequestResult<EventDetailNetEntity>(
						EventDetailNetEntity.class, handler) {

					@Override
					public void getData(NetEntityBase netEntityBase,
							EventDetailNetEntity t, Handler handler) {
						HandlerConstants.sendMessage(handler,
								t.getEventPublishDetail(),
								HandlerConstants.Event.EVENT_DETAIL,
								HandlerConstants.RESULT_OK, 0);
					}

					@Override
					public void onFailure(HttpException error, String msg) {
						HandlerConstants.sendMessage(handler, null,
								HandlerConstants.Event.EVENT_DETAIL,
								HandlerConstants.RESULT_FAIL, 0);
					}
				});
	}

	public static void eventConsultsRead(final Handler handler,
			int... attachments) {
		Map<String, String> params = new HashMap<String, String>();
		params.put(NetRequest.REQUEST_URL, EVENT_EVENT_PUBLISH_CONSULTS);
		HandlerConstants.sendMessage(handler, null,
				HandlerConstants.Event.EVENT_DETAIL_CONSULT,
				HandlerConstants.NETWORK_BEGIN, 0);
		NetRequest.doGetRequest(params,
				new RequestResult<EventConsultListEntity>(
						EventConsultListEntity.class, handler) {

					@Override
					public void getData(NetEntityBase netEntityBase,
							EventConsultListEntity t, Handler handler) {
						List<EventConsultModel> models = new ArrayList<EventConsultModel>();
						HandlerConstants.sendMessage(handler,
								t.getEventPublishConsults(),
								HandlerConstants.Event.EVENT_DETAIL_CONSULT,
								HandlerConstants.RESULT_OK, 0);
					}

					@Override
					public void onFailure(HttpException error, String msg) {
						HandlerConstants.sendMessage(handler, null,
								HandlerConstants.Event.EVENT_DETAIL_CONSULT,
								HandlerConstants.RESULT_FAIL, 0);
					}
				});
	}
}
