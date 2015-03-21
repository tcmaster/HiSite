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

import de.greenrobot.dao.async.AsyncSession;

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
							"distance", "apply_count", "consult_count");
					GreenDaoUtils.insertOrUpdate(daoSession.getExchangeDao(),
							eventList.getExchange(), ExchangeDao.Properties.Id,
							eventList.getExchange().getId(), "rid", "method",
							"address", "org_all");
					GreenDaoUtils.insertOrUpdate(daoSession
							.getCouponProvideDao(), eventList
							.getCouponProvide(),
							CouponProvideDao.Properties.Id, eventList
									.getCouponProvide().getId(), "type", "rid",
							"provide_num", "provide_all");
					GreenDaoUtils.insertOrUpdate(daoSession.getPopGoodsDao(),
							eventList.getPopGoods(), PopGoodsDao.Properties.Id,
							eventList.getPopGoods().getId(), "rid",
							"pop_goods_price", "pop_goods_pic",
							"pop_goods_name");
				}
				tUtils.testTimeEnd("表面的时间");
			}
		});

	}

	public void insertData(final List<EventList> models, String a) {
		final DaoSession daoSession = GreenDaoUtils.getDaoSession();
		final AsyncSession asyncSession = daoSession.startAsyncSession();
		for (int i = 0; i < models.size(); i++) {
			EventList model = models.get(i);
			model.getEvent().setOrg(model.getOrg());
			model.getExchange().setEvent(model.getEvent());
			model.getCouponProvide().setEvent(model.getEvent());
			model.getPopGoods().setEvent(model.getEvent());
		}
		asyncSession.runInTx(new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i < models.size(); i++) {
					EventList model = models.get(i);
					GreenDaoUtils.InsertOrUpdate(asyncSession, daoSession
							.getOrgDao(), OrgDao.Properties.Id, model.getOrg()
							.getId(), model.getOrg(), "name");
					GreenDaoUtils.InsertOrUpdate(asyncSession,
							daoSession.getEventDao(), EventDao.Properties.Id,
							model.getEvent().getId(), model.getEvent(), "rid",
							"name", "distance", "apply_count", "consult_count");
					GreenDaoUtils.InsertOrUpdate(asyncSession, daoSession
							.getExchangeDao(), ExchangeDao.Properties.Id, model
							.getExchange().getId(), model.getExchange(), "rid",
							"method", "address", "org_all");
					GreenDaoUtils.InsertOrUpdate(asyncSession, daoSession
							.getCouponProvideDao(),
							CouponProvideDao.Properties.Id, model
									.getCouponProvide().getId(), model
									.getCouponProvide(), "type", "rid",
							"provide_num", "provide_all");
					GreenDaoUtils.InsertOrUpdate(asyncSession, daoSession
							.getPopGoodsDao(), PopGoodsDao.Properties.Id, model
							.getPopGoods().getId(), model.getPopGoods(), "rid",
							"pop_goods_price", "pop_goods_pic",
							"pop_goods_name");
				}

			}
		});
	}
}
