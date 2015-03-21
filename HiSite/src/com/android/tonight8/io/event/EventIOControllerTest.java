package com.android.tonight8.io.event;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.os.Handler;

import com.android.tonight8.dao.entity.CouponProvide;
import com.android.tonight8.dao.entity.Event;
import com.android.tonight8.dao.entity.EventList;
import com.android.tonight8.dao.entity.Exchange;
import com.android.tonight8.dao.entity.Org;
import com.android.tonight8.dao.entity.PopGoods;
import com.android.tonight8.io.event.entity.EventListNetEntity;
import com.android.tonight8.io.net.NetEntityBase;
import com.android.tonight8.io.net.NetRequest;
import com.android.tonight8.io.net.NetRequest.RequestResult;
import com.android.tonight8.storage.event.EventListNativeControllerTest;
import com.android.tonight8.utils.TestUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.util.LogUtils;

public class EventIOControllerTest {
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

	public static void eventListRead(final Handler handler, int... attachments) {
		Map<String, String> params = new HashMap<String, String>();
		params.put(NetRequest.REQUEST_URL, EVENT_LIST_URL);
		params.put("user.coordinate", "39.9,116.3");
		params.put("city.code", "1");
		NetRequest.doGetRequest(params, new RequestResult<EventListNetEntity>(
				EventListNetEntity.class, handler) {
			@Override
			public void getData(NetEntityBase netEntityBase,
					EventListNetEntity t, Handler handler) {
				List<EventList> eventLists = new ArrayList<EventList>();
				for (int i = 0; i < 10; i++) {
					EventList eventList = new EventList();
					Event event = new Event();
					event.setId(122935 + i);
					event.setName("中英文花式奖品" + ((int) (Math.random() * 2394)));
					event.setDistance((int) (Math.random() * 11));
					event.setApplyCount((int) Math.random() * 2000);
					event.setConsultCount((int) Math.random() * 2000);
					PopGoods popGoods = new PopGoods();
					popGoods.setId(event.getId());
					popGoods.setPopGoodsName("神之海报"
							+ (int) (Math.random() * 199));
					popGoods.setPopGoodsPic(imgs[(int) (Math.random() * 8)]);
					popGoods.setPopGoodsPrice((int) (Math.random() * 888));
					Org org = new Org();
					org.setId(i);
					org.setName("龙翔控股科技发展公司" + Math.random() * 5);
					Exchange exchange = new Exchange();
					exchange.setId(event.getId());
					exchange.setMethod(1);
					exchange.setAddress("ddkafkkdkfkd");
					exchange.setOrgAll(1);
					CouponProvide couponProvide = new CouponProvide();
					couponProvide.setId(event.getId());
					couponProvide.setType(1);
					couponProvide.setProvideNum((int) (1000 * Math.random()));
					couponProvide.setProvideAll(2);
					eventList.setEvent(event);
					eventList.setExchange(exchange);
					eventList.setOrg(org);
					eventList.setCouponProvide(couponProvide);
					eventList.setPopGoods(popGoods);
					eventLists.add(eventList);
				}
				final TestUtils tUtils = new TestUtils();
				tUtils.testTimeBegin();
				EventListNativeControllerTest eventListNativeControllerTest = new EventListNativeControllerTest();
				eventListNativeControllerTest.insertData(eventLists);
			}

			@Override
			public void onFailure(HttpException arg0, String arg1) {
				LogUtils.v("why");
			}
		});
	}
}
