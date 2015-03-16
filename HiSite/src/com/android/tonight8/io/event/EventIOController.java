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
import com.android.tonight8.model.common.Consult;
import com.android.tonight8.model.common.CouponProvide;
import com.android.tonight8.model.common.Event;
import com.android.tonight8.model.common.Exchange;
import com.android.tonight8.model.common.ExchangeAddress;
import com.android.tonight8.model.common.ExchangeCity;
import com.android.tonight8.model.common.Goods;
import com.android.tonight8.model.common.Org;
import com.android.tonight8.model.common.PopGoods;
import com.android.tonight8.model.common.User;
import com.android.tonight8.model.event.EventConsultModel;
import com.android.tonight8.model.event.EventDetailModel;
import com.android.tonight8.model.event.EventListModel;
import com.android.tonight8.storage.event.EventStorage;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.util.LogUtils;

public class EventIOController {

	private static final String EVENT_LIST_URL = NetRequest.BASE_URL
			+ "/api/index/index";
	private static final String EVENT_RECOMMAND_URL = NetRequest.BASE_URL + "";
	private static final String EVENT_DETAIL_URL = NetRequest.BASE_URL + "";
	private static final String EVENT_EVENT_PUBLISH_CONSULTS = NetRequest.BASE_URL
			+ "";
	private static String[] imgs = {
			"http://img4.imgtn.bdimg.com/it/u=2352711400,4289515900&fm=11&gp=0.jpg",
			"http://img4.imgtn.bdimg.com/it/u=3923171974,2721923014&fm=21&gp=0.jpg",
			"http://img0.imgtn.bdimg.com/it/u=3934165751,994592123&fm=21&gp=0.jpg",
			"http://img4.imgtn.bdimg.com/it/u=3027043412,2228507304&fm=21&gp=0.jpg",
			"http://img2.imgtn.bdimg.com/it/u=3255667149,1938179631&fm=21&gp=0.jpg",
			"http://img1.gamersky.com/image2013/05/20130518u_6/gamersky_24small_48_20135181047D16.jpg",
			"http://image.tianjimedia.com/uploadImages/2013/081/77E8DL96VPZ4_0000784667.jpg",
			"http://img4.imgtn.bdimg.com/it/u=1195536478,3585633064&fm=21&gp=0.jpg" };

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
				ArrayList<EventListModel> lists = new ArrayList<EventListModel>();
				for (int i = 0; i < 10; i++) {
					EventListModel model = new EventListModel();
					Event event = new Event();
					PopGoods popGoods = new PopGoods();
					Org org = new Org();
					CouponProvide couponProvide = new CouponProvide();
					Exchange exchange = new Exchange();
					couponProvide.id = (long) (12342 + i);
					couponProvide.type = 1;
					couponProvide.provideNum = (int) (1000 * Math.random());
					couponProvide.provideAll = false;
					event.id = (int) (122935 + i);
					event.name = "中英文花式奖品" + ((int) (Math.random() * 2394));
					event.distance = (float) (Math.random() * 11);
					event.applyCount = (int) Math.random() * 2000;
					event.consultCount = (int) Math.random() * 2000;
					popGoods.popGoodsName = "神之海报"
							+ (int) (Math.random() * 199);
					popGoods.popGoodsPic = imgs[(int) (Math.random() * 8)];
					popGoods.popGoodsPrice = (int) (Math.random() * 888);
					org.id = i;
					org.name = "龙翔控股科技发展公司" + Math.random() * 5;
					exchange.method = 1;
					exchange.address = "ddkafkkdkfkd";
					exchange.locationType = 1;
					model.event = event;
					model.org = org;
					model.popGoods = popGoods;
					model.couponProvide = couponProvide;
					model.exchange = exchange;
					lists.add(model);
				}
				EventStorage.getEventListNativeController().insertData(lists);
				HandlerConstants.sendMessage(
						handler,
						EventStorage.getEventListNativeController().selectData(
								attachments[1], attachments[2]),
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
						EventDetailModel model = new EventDetailModel();
						Event event = new Event();
						event.id = 234931;
						event.name = "花式奖品与海边螺壳";
						event.timeStamp = 314252523;
						event.applyCount = 204;
						event.timeRangeStart = "2014-12-12 00:00:00";
						event.timeRangeEnd = "2014-12-12 23:59:59";
						event.ruleDesc = "中英文花式活动总体说明";
						CouponProvide couponProvide = new CouponProvide();
						couponProvide.id = 1;
						couponProvide.type = 1;
						couponProvide.provideNum = 234;
						couponProvide.provideAll = false;
						couponProvide.value = 2313;
						Org org = new Org();
						org.id = 243592454;
						org.name = "神瓶";
						Exchange exchange = new Exchange();
						exchange.method = 1;
						List<ExchangeCity> exchangeCities = new ArrayList<ExchangeCity>();
						for (int i = 0; i < 5; i++) {
							ExchangeCity exchangeCity = new ExchangeCity();
							exchangeCity.id = 14343;
							exchangeCity.cityCode = "2312";
							exchangeCities.add(exchangeCity);
						}
						List<ExchangeAddress> exchangeAddresses = new ArrayList<ExchangeAddress>();
						for (int i = 0; i < 5; i++) {
							ExchangeAddress exchangeAddress = new ExchangeAddress();
							exchangeAddress.id = 2343;
							exchangeAddress.address = "dskkfkf";
							exchangeAddress.coordinate = "203.22,334.2";
							exchangeAddresses.add(exchangeAddress);
						}
						PopGoods popGoods = new PopGoods();
						popGoods.popGoodsName = "海报王";
						popGoods.popGoodsPic = "http://img4.imgtn.bdimg.com/it/u=2352711400,4289515900&fm=11&gp=0.jpg";
						popGoods.popGoodsPrice = 2343;
						List<Goods> goodses = new ArrayList<Goods>();
						for (int i = 0; i < 5; i++) {
							Goods goods = new Goods();
							goods.id = 233;
							goods.name = "dkkwd";
							goods.pic = imgs[(int) (Math.random() * 8)];
							goods.size = "1800,500";
							goodses.add(goods);
						}
						model.event = event;
						model.couponProvide = couponProvide;
						model.org = org;
						model.exchange = exchange;
						model.exchangeCities = exchangeCities;
						model.exchangeAddresses = exchangeAddresses;
						model.popGoods = popGoods;
						model.goodses = goodses;
						HandlerConstants.sendMessage(handler, model,
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
		HandlerConstants.sendMessage(handler,null,HandlerConstants.Event.EVENT_DETAIL_CONSULT,HandlerConstants.NETWORK_BEGIN,0);
		NetRequest.doGetRequest(params,
				new RequestResult<EventConsultListEntity>(
						EventConsultListEntity.class, handler) {

					@Override
					public void getData(NetEntityBase netEntityBase,
							EventConsultListEntity t, Handler handler) {
						List<EventConsultModel> models = new ArrayList<EventConsultModel>();
						for (int i = 0; i < 5; i++) {
							EventConsultModel model = new EventConsultModel();
							Consult consult = new Consult();
							consult.content = "我想知道为何量子力学是否能解决一切的终极问题";
							consult.date = "2015年3月20日";
							consult.id = (int) (Math.random() * 100);
							consult.time = "12点50分";
							User user = new User();
							user.name = "董大师";
							user.pic = imgs[(int) (Math.random() * 8)];
							model.consult = consult;
							model.user = user;
							models.add(model);
							HandlerConstants
									.sendMessage(
											handler,
											models,
											HandlerConstants.Event.EVENT_DETAIL_CONSULT,
											HandlerConstants.RESULT_OK, 0);
						}
					}

					@Override
					public void onFailure(HttpException error, String msg) {
						HandlerConstants.sendMessage(handler,null,HandlerConstants.Event.EVENT_DETAIL_CONSULT,HandlerConstants.RESULT_FAIL,0);
					}
				});
	}
}
