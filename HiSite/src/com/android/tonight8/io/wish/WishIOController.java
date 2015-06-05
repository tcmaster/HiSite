package com.android.tonight8.io.wish;

import java.util.List;
import java.util.Map;

import android.os.Handler;

import com.android.tonight8.io.HandlerConstants;
import com.android.tonight8.io.net.NetEntityBase;
import com.android.tonight8.io.net.NetRequest;
import com.android.tonight8.io.net.NetRequest.RequestResult;
import com.android.tonight8.io.net.NetRequest.RequestResultList;
import com.android.tonight8.model.wish.SubjectListModel;
import com.android.tonight8.model.wish.WishDetailModel;
import com.android.tonight8.model.wish.WishListModel;
import com.android.tonight8.model.wish.WishSponsorList;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.util.LogUtils;

public class WishIOController {

	private static final String EVENT_LIST_URL = NetRequest.BASE_URL
			+ "/api/index/index";
	private static final String EVENT_RECOMMAND_URL = NetRequest.BASE_URL + "";
	private static final String EVENT_DETAIL_URL = NetRequest.BASE_URL + "";
	private static final String EVENT_EVENT_PUBLISH_CONSULTS = NetRequest.BASE_URL
			+ "";

	/**
	 * @Description:心愿列表信息
	 * @param handler
	 * @date:2015-2-12
	 */
	public static void getWishList(final Handler handler,
			Map<String, String> params, final int... attachments) {
		if (params == null) {
			return;
		}
		params.put(NetRequest.REQUEST_URL, EVENT_LIST_URL);

		// HandlerConstants.sendMessage(handler, null,
		// HandlerConstants.Event.MAINPAGE_LIST,
		// HandlerConstants.NETWORK_BEGIN, attachments[0]);
		NetRequest.doGetRequestList(params,
				new RequestResultList<WishListModel>(WishListModel.class,
						handler) {

					@Override
					public void getDataList(NetEntityBase netEntityBase,
							List<WishListModel> t, Handler handler) {
						LogUtils.v("the t is " + t);

						HandlerConstants.sendMessage(handler, t,
								HandlerConstants.Event.MAINPAGE_LIST,
								HandlerConstants.RESULT_OK, attachments[0]);
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
	 * @Description:心愿现场讨论区列表
	 * @param handler
	 * @author: lz
	 * @date:2015-2-12
	 */
	public static void getWishTalkRead(final Handler handler,
			Map<String, String> params, final int... attachments) {
		if (params == null) {
			return;
		}
		params.put(NetRequest.REQUEST_URL, EVENT_LIST_URL);

		// HandlerConstants.sendMessage(handler, null,
		// HandlerConstants.Event.MAINPAGE_LIST,
		// HandlerConstants.NETWORK_BEGIN, attachments[0]);
		NetRequest.doGetRequestList(params,
				new RequestResultList<SubjectListModel>(SubjectListModel.class,
						handler) {

					@Override
					public void getDataList(NetEntityBase netEntityBase,
							List<SubjectListModel> t, Handler handler) {
						LogUtils.v("the t is " + t);

						HandlerConstants.sendMessage(handler, t,
								HandlerConstants.Event.MAINPAGE_LIST,
								HandlerConstants.RESULT_OK, attachments[0]);
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
	 * @author: lz
	 * @Description:心愿现场赞助列表
	 * @param handler
	 * @param params
	 * @param attachments
	 */
	public static void getWishSponorRead(final Handler handler,
			Map<String, String> params, final int... attachments) {
		if (params == null) {
			return;
		}
		params.put(NetRequest.REQUEST_URL, EVENT_LIST_URL);

		// HandlerConstants.sendMessage(handler, null,
		// HandlerConstants.Event.MAINPAGE_LIST,
		// HandlerConstants.NETWORK_BEGIN, attachments[0]);
		NetRequest.doGetRequestList(params,
				new RequestResultList<WishSponsorList>(WishSponsorList.class,
						handler) {

					@Override
					public void getDataList(NetEntityBase netEntityBase,
							List<WishSponsorList> t, Handler handler) {
						LogUtils.v("the t is " + t);

						HandlerConstants.sendMessage(handler, t,
								HandlerConstants.Event.MAINPAGE_LIST,
								HandlerConstants.RESULT_OK, attachments[0]);
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
	 * @Description:心愿详情信息
	 * @param handler
	 * @date:2015-2-12
	 */
	public static void getWishLiveDetail(final Handler handler,
			Map<String, String> params, final int... attachments) {
		if (params == null) {
			return;
		}
		params.put(NetRequest.REQUEST_URL, EVENT_LIST_URL);

		// HandlerConstants.sendMessage(handler, null,
		// HandlerConstants.Event.MAINPAGE_LIST,
		// HandlerConstants.NETWORK_BEGIN, attachments[0]);
		NetRequest.doGetRequest(params, new RequestResult<WishDetailModel>(
				WishDetailModel.class, handler) {

			@Override
			public void getData(NetEntityBase netEntityBase, WishDetailModel t,
					Handler handler) {
				LogUtils.v("the t is " + t);

				HandlerConstants.sendMessage(handler, t,
						HandlerConstants.Event.MAINPAGE_LIST,
						HandlerConstants.RESULT_OK, attachments[0]);
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
}
