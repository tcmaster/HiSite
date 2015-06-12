package com.android.tonight8.io.wish;

import java.util.List;
import java.util.Map;

import android.os.Handler;

import com.android.tonight8.dao.model.wish.MyWishListModel;
import com.android.tonight8.dao.model.wish.MyWishSponsorListModel;
import com.android.tonight8.dao.model.wish.SubjectListModel;
import com.android.tonight8.dao.model.wish.WishDetailModel;
import com.android.tonight8.dao.model.wish.WishItemModel;
import com.android.tonight8.dao.model.wish.WishListModel;
import com.android.tonight8.dao.model.wish.WishSponsorList;
import com.android.tonight8.io.HandlerConstants;
import com.android.tonight8.io.net.NetEntityBase;
import com.android.tonight8.io.net.NetRequest;
import com.android.tonight8.io.net.NetRequest.RequestResult;
import com.android.tonight8.io.net.NetRequest.RequestResultList;
import com.android.tonight8.model.BaseModel;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.util.LogUtils;

public class WishIOController {
	/** 心愿列表 */
	private static final String WISH_LIST_URL = NetRequest.BASE_URL
			+ "/api/index/index";
	/** 心愿讨论区 */
	private static final String WISH_LIVE_TALK_URL = NetRequest.BASE_URL + "";
	/** 心愿赞助列表 */
	private static final String WISH_SPONOR_LIST_URL = NetRequest.BASE_URL + "";
	/** 心愿详情 */
	private static final String WISH_DETAIL_URL = NetRequest.BASE_URL + "";
	/** 心愿赞助清单 */
	private static final String WISH_SPONOR_CHECKLIST = NetRequest.BASE_URL
			+ "";
	/** 心愿赞助录入 */
	private static final String WISH_SPONOR_POST_URL = NetRequest.BASE_URL + "";
	/** 我的心愿赞助 */
	private static final String MYWISH_SPONOR_URL = NetRequest.BASE_URL + "";
	/** 我的心愿发布列表 */
	private static final String MYWISH_POST_URL = NetRequest.BASE_URL + "";

	/**
	 * 主页面心愿列表
	 * 
	 * @param handler
	 * @param params
	 * @param attachments
	 */
	public static void getWishList(final Handler handler,
			Map<String, String> params, final int... attachments) {
		if (params == null) {
			return;
		}
		params.put(NetRequest.REQUEST_URL, WISH_LIST_URL);

		NetRequest.doGetRequestList(params,
				new RequestResultList<WishListModel>(WishListModel.class,
						handler) {

					@Override
					public void getDataList(NetEntityBase netEntityBase,
							List<WishListModel> t, Handler handler) {
						LogUtils.v("the t is " + t);

						HandlerConstants.sendMessage(handler, t,
								attachments[0], HandlerConstants.RESULT_OK,
								attachments[1]);
					}

					@Override
					public void onFailure(HttpException arg0, String arg1) {
						LogUtils.v("why");
						HandlerConstants.sendMessage(handler, null,
								attachments[0], HandlerConstants.RESULT_FAIL,
								attachments[1]);
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
		params.put(NetRequest.REQUEST_URL, WISH_LIVE_TALK_URL);

		NetRequest.doGetRequestList(params,
				new RequestResultList<SubjectListModel>(SubjectListModel.class,
						handler) {

					@Override
					public void getDataList(NetEntityBase netEntityBase,
							List<SubjectListModel> t, Handler handler) {
						HandlerConstants.sendMessage(handler, t,
								attachments[0], HandlerConstants.RESULT_OK,
								attachments[1]);
					}

					@Override
					public void onFailure(HttpException arg0, String arg1) {
						HandlerConstants.sendMessage(handler, null,
								attachments[0], HandlerConstants.RESULT_FAIL,
								attachments[1]);
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
		params.put(NetRequest.REQUEST_URL, WISH_SPONOR_LIST_URL);

		NetRequest.doGetRequestList(params,
				new RequestResultList<WishSponsorList>(WishSponsorList.class,
						handler) {

					@Override
					public void getDataList(NetEntityBase netEntityBase,
							List<WishSponsorList> t, Handler handler) {
						HandlerConstants.sendMessage(handler, t,
								attachments[0], HandlerConstants.RESULT_OK,
								attachments[1]);
					}

					@Override
					public void onFailure(HttpException arg0, String arg1) {
						HandlerConstants.sendMessage(handler, null,
								attachments[0], HandlerConstants.RESULT_FAIL,
								attachments[1]);
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
		params.put(NetRequest.REQUEST_URL, WISH_DETAIL_URL);

		NetRequest.doGetRequest(params, new RequestResult<WishDetailModel>(
				WishDetailModel.class, handler) {

			@Override
			public void getData(NetEntityBase netEntityBase, WishDetailModel t,
					Handler handler) {
				HandlerConstants.sendMessage(handler, t, attachments[0],
						HandlerConstants.RESULT_OK, attachments[1]);
			}

			@Override
			public void onFailure(HttpException arg0, String arg1) {
				HandlerConstants.sendMessage(handler, null, attachments[0],
						HandlerConstants.RESULT_FAIL, attachments[1]);
			}

		});
	}

	/**
	 * @Description:心愿赞助清单
	 * @param handler
	 * @date:2015-2-12
	 */
	public static void getWishSponsorChecklist(final Handler handler,
			Map<String, String> params, final int... attachments) {
		if (params == null) {
			return;
		}
		params.put(NetRequest.REQUEST_URL, WISH_SPONOR_CHECKLIST);

		NetRequest.doGetRequest(params, new RequestResult<WishItemModel>(
				WishItemModel.class, handler) {

			@Override
			public void getData(NetEntityBase netEntityBase, WishItemModel t,
					Handler handler) {
				HandlerConstants.sendMessage(handler, t, attachments[0],
						HandlerConstants.RESULT_OK, attachments[1]);
			}

			@Override
			public void onFailure(HttpException error, String msg) {
				HandlerConstants.sendMessage(handler, null, attachments[0],
						HandlerConstants.RESULT_FAIL, attachments[1]);
			}

		});
	}

	/**
	 * @Description:心愿赞助录入
	 * @param handler
	 * @date:2015-2-12
	 */
	public static void postWishSponsor(Handler handler,
			Map<String, String> params, final int... attachments) {
		if (params == null) {
			return;
		}
		params.put(NetRequest.REQUEST_URL, WISH_SPONOR_POST_URL);

		NetRequest.doGetRequest(params, new RequestResult<BaseModel>(
				BaseModel.class, handler) {

			@Override
			public void getData(NetEntityBase netEntityBase, BaseModel t,
					Handler handler) {
				HandlerConstants.sendMessage(handler, t, attachments[0],
						HandlerConstants.RESULT_OK, attachments[1]);

			}

			@Override
			public void onFailure(HttpException arg0, String arg1) {
			}

		});
	}

	/**
	 * @Description:我的心愿列表
	 * @param handler
	 * @date:2015-2-12
	 */
	public static void getMyWishList(final Handler handler,
			Map<String, String> params, final int... attachments) {
		if (params == null) {
			return;
		}
		params.put(NetRequest.REQUEST_URL, WISH_SPONOR_CHECKLIST);

		NetRequest.doGetRequestList(params,
				new RequestResultList<MyWishListModel>(MyWishListModel.class,
						handler) {

					@Override
					public void getDataList(NetEntityBase netEntityBase,
							List<MyWishListModel> t, Handler handler) {
						HandlerConstants.sendMessage(handler, t,
								attachments[0], HandlerConstants.RESULT_OK,
								attachments[1]);
					}

					@Override
					public void onFailure(HttpException error, String msg) {
						HandlerConstants.sendMessage(handler, null,
								attachments[0], HandlerConstants.RESULT_FAIL,
								attachments[1]);
					}

				});
	}

	/**
	 * @Description:我的心愿赞助列表
	 * @param handler
	 * @date:2015-2-12
	 */
	public static void getMyWishSponsorList(final Handler handler,
			Map<String, String> params, final int... attachments) {
		if (params == null) {
			return;
		}
		params.put(NetRequest.REQUEST_URL, WISH_SPONOR_CHECKLIST);

		NetRequest.doGetRequestList(params,
				new RequestResultList<MyWishSponsorListModel>(
						MyWishSponsorListModel.class, handler) {

					@Override
					public void getDataList(NetEntityBase netEntityBase,
							List<MyWishSponsorListModel> t, Handler handler) {
						HandlerConstants.sendMessage(handler, t,
								attachments[0], HandlerConstants.RESULT_OK,
								attachments[1]);
					}

					@Override
					public void onFailure(HttpException error, String msg) {
						HandlerConstants.sendMessage(handler, null,
								attachments[0], HandlerConstants.RESULT_FAIL,
								attachments[1]);
					}

				});
	}
}
