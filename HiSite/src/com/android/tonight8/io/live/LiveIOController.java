package com.android.tonight8.io.live;

import java.util.HashMap;
import java.util.Map;

import android.os.Handler;

import com.android.tonight8.io.HandlerConstants;
import com.android.tonight8.io.live.entity.EventLiveCommitNetEntity;
import com.android.tonight8.io.live.entity.EventLiveNetEntity;
import com.android.tonight8.io.live.entity.EventLiveWinnerListNetEntity;
import com.android.tonight8.io.net.NetEntityBase;
import com.android.tonight8.io.net.NetRequest;
import com.android.tonight8.io.net.NetRequest.RequestResult;
import com.lidroid.xutils.exception.HttpException;

/**
 * @Description:读取活动现场列表数据
 * @author:LiuZhao
 * @Date:2015年2月5日
 */
public class LiveIOController {
	private static final String EVENT_LIVE_TITLE = NetRequest.BASE_URL + "";
	private static final String EVENT_LIVE_COMMIT = NetRequest.BASE_URL + "";
	private static final String EVENT_LIVE_WINNER_LIST = NetRequest.BASE_URL
			+ "";

	public static void readLiveTitle(final Handler handler) {
		Map<String, String> param = new HashMap<String, String>();
		param.put(NetRequest.REQUEST_URL, EVENT_LIVE_TITLE);
		HandlerConstants.sendMessage(handler, null,
				HandlerConstants.Live.LIVE_TITLE,
				HandlerConstants.NETWORK_BEGIN, -1);
		NetRequest.doGetRequest(param, new RequestResult<EventLiveNetEntity>(
				EventLiveNetEntity.class, handler) {

			@Override
			public void getData(NetEntityBase netEntityBase,
					EventLiveNetEntity t, Handler handler) {
				HandlerConstants.sendMessage(handler, t.getEventLive(),
						HandlerConstants.Live.LIVE_TITLE,
						HandlerConstants.RESULT_OK, -1);
			}

			@Override
			public void onFailure(HttpException error, String msg) {
			}
		});
	}

	public static void readEventLiveCommit(final Handler handler) {
		Map<String, String> param = new HashMap<String, String>();
		param.put(NetRequest.REQUEST_URL, EVENT_LIVE_COMMIT);
		HandlerConstants.sendMessage(handler, null,
				HandlerConstants.Live.LIVE_COMMIT,
				HandlerConstants.NETWORK_BEGIN, -1);
		NetRequest.doGetRequest(param,
				new RequestResult<EventLiveCommitNetEntity>(
						EventLiveCommitNetEntity.class, handler) {

					@Override
					public void getData(NetEntityBase netEntityBase,
							EventLiveCommitNetEntity t, Handler handler) {
						HandlerConstants.sendMessage(handler,
								t.getSubjectList(),
								HandlerConstants.Live.LIVE_COMMIT,
								HandlerConstants.RESULT_OK, -1);
					}

					@Override
					public void onFailure(HttpException error, String msg) {
					}
				});
	}

	public static void readLiveWinnerList(Handler handler) {
		Map<String, String> param = new HashMap<String, String>();
		param.put(NetRequest.REQUEST_URL, EVENT_LIVE_WINNER_LIST);
		HandlerConstants.sendMessage(handler, null,
				HandlerConstants.Live.LIVE_WINNER_LIST,
				HandlerConstants.NETWORK_BEGIN, -1);
		NetRequest.doGetRequest(param,
				new RequestResult<EventLiveWinnerListNetEntity>(
						EventLiveWinnerListNetEntity.class, handler) {

					@Override
					public void getData(NetEntityBase netEntityBase,
							EventLiveWinnerListNetEntity t, Handler handler) {
						HandlerConstants.sendMessage(handler,
								t.getEventAwards(),
								HandlerConstants.Live.LIVE_WINNER_LIST,
								HandlerConstants.RESULT_OK, -1);
					}

					@Override
					public void onFailure(HttpException error, String msg) {
					}
				});
	}
}
