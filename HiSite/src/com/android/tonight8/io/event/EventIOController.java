package com.android.tonight8.io.event;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import android.os.Handler;
import android.os.Message;

import com.android.tonight8.io.HandlerConstants;
import com.android.tonight8.io.event.entity.EventListNetEntity;
import com.android.tonight8.io.event.entity.EventRecommendNetEntity;
import com.android.tonight8.io.net.NetEntityBase;
import com.android.tonight8.io.net.NetRequest;
import com.android.tonight8.io.net.NetRequest.RequestResult;
import com.android.tonight8.model.common.CouponProvide;
import com.android.tonight8.model.common.Event;
import com.android.tonight8.model.common.Exchange;
import com.android.tonight8.model.common.Org;
import com.android.tonight8.model.common.PopGoods;
import com.android.tonight8.model.event.EventListModel;
import com.android.tonight8.storage.event.EventStorage;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.util.LogUtils;

public class EventIOController {

	private static final String EVENT_LIST_URL = NetRequest.BASE_URL + "/api/index/index";
	private static final String EVENT_RECOMMAND_URL = NetRequest.BASE_URL + "";
	private static String[] imgs = { "http://img4.imgtn.bdimg.com/it/u=2352711400,4289515900&fm=11&gp=0.jpg", "http://img4.imgtn.bdimg.com/it/u=3923171974,2721923014&fm=21&gp=0.jpg", "http://img0.imgtn.bdimg.com/it/u=3934165751,994592123&fm=21&gp=0.jpg", "http://img4.imgtn.bdimg.com/it/u=3027043412,2228507304&fm=21&gp=0.jpg", "http://img2.imgtn.bdimg.com/it/u=3255667149,1938179631&fm=21&gp=0.jpg", "http://img1.gamersky.com/image2013/05/20130518u_6/gamersky_24small_48_20135181047D16.jpg", "http://image.tianjimedia.com/uploadImages/2013/081/77E8DL96VPZ4_0000784667.jpg", "http://img4.imgtn.bdimg.com/it/u=1195536478,3585633064&fm=21&gp=0.jpg" };

	/**
	 * @Description:活动开奖列表
	 * @param handler
	 * @author: LiXiaoSong
	 * @date:2015-2-12
	 */
	public static void eventsRead(final Handler handler) {
		Map<String, String> params = new HashMap<String, String>();
		params.put(NetRequest.REQUEST_URL, EVENT_LIST_URL);
		params.put("user.coordinate", "39.9,116.3");
		params.put("city.code", "1");
		NetRequest.doGetRequest(params, new RequestResult<EventListNetEntity>(EventListNetEntity.class, handler) {

			@Override
			public void getData(NetEntityBase netEntityBase, EventListNetEntity t, Handler handler) {
				EventListNetEntity testData = new EventListNetEntity();
				ArrayList<EventListModel> lists = new ArrayList<EventListModel>();
				for (int i = 0; i < 10; i++) {
					EventListModel model = new EventListModel();
					Event event = new Event();
					PopGoods popGoods = new PopGoods();
					Org org = new Org();
					CouponProvide couponProvide = new CouponProvide();
					Exchange exchange = new Exchange();
					couponProvide.id = (long)(12342 * Math.random());
					couponProvide.type = 1;
					couponProvide.provideNum = (int)(1000 * Math.random());
					couponProvide.provideAll = false;
					event.id = (int) (122935 * Math.random());
					event.name = "中英文花式奖品" + ((int) (Math.random() * 2394));
					event.distance = (float) (Math.random() * 11);
					event.applyCount = (int) Math.random() * 2000;
					event.consultCount = (int) Math.random() * 2000;
					popGoods.popGoodsName = "神之海报" + (int) (Math.random() * 199);
					popGoods.popGoodsPic = imgs[(int) (Math.random() * 8)];
					popGoods.popGoodsPrice = (int) (Math.random() * 888);
					org.id = (int) (Math.random() * 100);
					org.name = "龙翔控股科技发展公司" + Math.random() * 5;
					exchange.method = false;
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
				Message msg = handler.obtainMessage();
				msg.obj = EventStorage.getEventListNativeController().selectData();
				msg.arg1 = HandlerConstants.RESULT_OK;
				msg.what = HandlerConstants.Event.MAINPAGE_LIST;
				handler.sendMessage(msg);
			}

			@Override
			public void onFailure(HttpException arg0, String arg1) {
				LogUtils.v("why");
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
		NetRequest.doGetRequest(params, new RequestResult<EventRecommendNetEntity>(EventRecommendNetEntity.class, handler) {

			@Override
			public void getData(NetEntityBase netEntityBase, EventRecommendNetEntity t, Handler handler) {

			}

			@Override
			public void onFailure(HttpException arg0, String arg1) {
			}
		});
	}
}
