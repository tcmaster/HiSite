package com.android.tonight8.storage.event;

import java.util.ArrayList;
import java.util.List;

import com.android.tonight8.dao.entity.CouponProvide;
import com.android.tonight8.dao.entity.Event;
import com.android.tonight8.dao.entity.EventList;
import com.android.tonight8.dao.entity.Exchange;
import com.android.tonight8.dao.entity.Org;
import com.android.tonight8.dao.entity.PopGoods;
import com.android.tonight8.storage.GreenDaoUtils;
import com.android.tonight8.utils.TestUtils;

import de.greenrobot.dao.async.AsyncOperationListener;
import de.greenrobot.dao.async.AsyncSession;

public class EventListNativeControllerTest {
	public void insertData(List<EventList> models,
			AsyncOperationListener listener) {
		TestUtils tUtils = new TestUtils();
		tUtils.testTimeBegin();
		AsyncSession daoSession = GreenDaoUtils.getAsyncDaoSession();
		List<Event> events = new ArrayList<Event>();
		List<PopGoods> popGoodses = new ArrayList<PopGoods>();
		List<Exchange> exchanges = new ArrayList<Exchange>();
		List<Org> orgs = new ArrayList<Org>();
		List<CouponProvide> couponProvides = new ArrayList<CouponProvide>();
		for (int i = 0; i < models.size(); i++) {
			EventList model = models.get(i);
			model.getEvent().setOrg(model.getOrg());
			model.getExchange().setEvent(model.getEvent());
			model.getCouponProvide().setEvent(model.getEvent());
			model.getPopGoods().setEvent(model.getEvent());
			events.add(model.getEvent());
			popGoodses.add(model.getPopGoods());
			exchanges.add(model.getExchange());
			orgs.add(model.getOrg());
			couponProvides.add(model.getCouponProvide());
		}
		daoSession.insertOrReplaceInTx(Org.class, orgs);
		daoSession.insertOrReplaceInTx(Event.class, events);
		daoSession.insertOrReplaceInTx(PopGoods.class, popGoodses);
		daoSession.insertOrReplaceInTx(Exchange.class, exchanges);
		daoSession.insertOrReplaceInTx(CouponProvide.class, couponProvides);
		daoSession.setListener(listener);
		tUtils.testTimeEnd("表面的时间");
	}
}
