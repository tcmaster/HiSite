package com.android.tonight8.storage.event;

import java.util.List;

import com.android.tonight8.dao.CouponProvideDao;
import com.android.tonight8.dao.DaoSession;
import com.android.tonight8.dao.EventDao;
import com.android.tonight8.dao.ExchangeDao;
import com.android.tonight8.dao.OrgDao;
import com.android.tonight8.dao.PopGoodsDao;
import com.android.tonight8.dao.entity.EventList;
import com.android.tonight8.storage.GreenDaoUtils;
import com.android.tonight8.utils.TestUtils;

public class EventListNativeControllerTest {
	public void insertData(final List<EventList> models) {
		final DaoSession daoSession = GreenDaoUtils.getDaoSession();
		for (int i = 0; i < models.size(); i++) {
			EventList model = models.get(i);
			model.getEvent().setOrg(model.getOrg());
			model.getExchange().setEvent(model.getEvent());
			model.getCouponProvide().setEvent(model.getEvent());
			model.getPopGoods().setEvent(model.getEvent());
		}
		daoSession.runInTx(new Runnable() {

			@Override
			public void run() {
				TestUtils tUtils = new TestUtils();
				tUtils.testTimeBegin();
				for (int i = 0; i < models.size(); i++) {
					EventList eventList = models.get(i);
					GreenDaoUtils.insertOrUpdate(daoSession.getOrgDao(),
							eventList.getOrg(), OrgDao.Properties.Id, eventList
									.getOrg().getId(), "name");
					GreenDaoUtils.insertOrUpdate(daoSession.getEventDao(),
							eventList.getEvent(), EventDao.Properties.Id,
							eventList.getEvent().getId(), "rid", "name",
							"distance");
					GreenDaoUtils.insertOrUpdate(daoSession.getExchangeDao(),
							eventList.getExchange(), ExchangeDao.Properties.Id,
							eventList.getExchange().getId(), "rid", "method",
							"address", "orgAll");
					GreenDaoUtils.insertOrUpdate(daoSession
							.getCouponProvideDao(), eventList
							.getCouponProvide(),
							CouponProvideDao.Properties.Id, eventList
									.getCouponProvide().getId(), "type", "rid",
							"provideNum", "provideAll");
					GreenDaoUtils.insertOrUpdate(daoSession.getPopGoodsDao(),
							eventList.getPopGoods(), PopGoodsDao.Properties.Id,
							eventList.getPopGoods().getId(), "rid",
							"popGoodsPrice", "popGoodsPic", "popGoodsName");
				}
				tUtils.testTimeEnd("表面的时间");
			}
		});

	}
}
