/**
 * 2015-1-21
 */
package com.android.tonight8.storage.event;

import java.util.ArrayList;
import java.util.List;

import com.android.tonight8.model.common.CouponProvide;
import com.android.tonight8.model.common.Event;
import com.android.tonight8.model.common.Exchange;
import com.android.tonight8.model.common.Org;
import com.android.tonight8.model.common.PopGoods;
import com.android.tonight8.model.event.EventListModel;
import com.android.tonight8.storage.DBUtil;
import com.android.tonight8.storage.entity.CouponProvideEntity;
import com.android.tonight8.storage.entity.EventEntity;
import com.android.tonight8.storage.entity.ExchangeEntity;
import com.android.tonight8.storage.entity.OrgEntity;
import com.android.tonight8.storage.entity.PopGoodsEntity;
import com.android.tonight8.utils.TestUtils;
import com.lidroid.xutils.db.sqlite.WhereBuilder;

/**
 * @Description:开奖列表本地数据控制
 * @author:LiXiaoSong
 * @copyright @HiSite
 * @Date:2015-1-21
 */
public class EventListNativeController {

	public void insertData(List<EventListModel> models) {
		TestUtils utils = new TestUtils();
		utils.testTimeBegin();
		List<EventEntity> eventEntities = new ArrayList<EventEntity>();
		List<OrgEntity> orgEntities = new ArrayList<OrgEntity>();
		List<CouponProvideEntity> couponProvideEntities = new ArrayList<CouponProvideEntity>();
		List<ExchangeEntity> exchangeEntities = new ArrayList<ExchangeEntity>();
		List<PopGoodsEntity> popGoodsEntities = new ArrayList<PopGoodsEntity>();
		List<WhereBuilder> exchangeBuilders = new ArrayList<WhereBuilder>();
		List<WhereBuilder> popGoodsBuilders = new ArrayList<WhereBuilder>();
		for (int i = 0; i < models.size(); i++) {
			EventListModel model = models.get(i);
			EventEntity eventEntity = new EventEntity();
			OrgEntity orgEntity = new OrgEntity();
			CouponProvideEntity couponEntity = new CouponProvideEntity();
			ExchangeEntity exchangeEntity = new ExchangeEntity();
			PopGoodsEntity popGoodsEntity = new PopGoodsEntity();

			Object object = new Object();
			// 数据存储
			DBUtil.copyData(PopGoods.class, PopGoodsEntity.class,
					model.popGoods, popGoodsEntity);
			DBUtil.copyData(Event.class, EventEntity.class, model.event,
					eventEntity);
			DBUtil.copyData(Org.class, OrgEntity.class, model.org, orgEntity);
			DBUtil.copyData(CouponProvide.class, CouponProvideEntity.class,
					model.couponProvide, couponEntity);
			DBUtil.copyData(Exchange.class, ExchangeEntity.class,
					model.exchange, exchangeEntity);
			// 外键连接
			popGoodsEntity.event = eventEntity;
			eventEntity.org = orgEntity;
			couponEntity.event = eventEntity;
			exchangeEntity.event = eventEntity;
			// 增加数据，加入表中
			eventEntities.add(eventEntity);
			orgEntities.add(orgEntity);
			couponProvideEntities.add(couponEntity);
			exchangeEntities.add(exchangeEntity);
			popGoodsEntities.add(popGoodsEntity);
			popGoodsBuilders
					.add(WhereBuilder.b("rid", "=", eventEntity.getId()));
			exchangeBuilders
					.add(WhereBuilder.b("rid", "=", eventEntity.getId()));
		}
		try {
			DBUtil.beginTransation();
			DBUtil.saveOrUpdateAll(popGoodsEntities, PopGoodsEntity.class,
					popGoodsBuilders, "popGoodsName", "popGoodsPic",
					"popGoodsPrice", "rid");
			DBUtil.saveOrUpdateAll(exchangeEntities, ExchangeEntity.class,
					exchangeBuilders, "method", "address", "orgAll", "rid");
			DBUtil.saveOrUpdateAll(eventEntities, EventEntity.class, "name",
					"distance", "applyCount", "consultCount", "rid");
			DBUtil.saveOrUpdateAll(orgEntities, OrgEntity.class, "name");
			DBUtil.saveOrUpdateAll(couponProvideEntities,
					CouponProvideEntity.class, "type", "provideNum",
					"provideAll", "rid");
			DBUtil.setTransactionSuccessful();
		} finally {
			DBUtil.endTransation();
		}

		utils.testTimeEnd("存数据");
	}

	/**
	 * @Description: 获取所有的活动列表，暂时按活动开始时间戳排序
	 * @return 排序好的数据
	 * @author: LiXiaoSong
	 * @param count显示多少条记录
	 * @param offset
	 *            跳过多少条记录
	 * 
	 * @date:2015-1-21
	 */
	public List<EventListModel> selectData(int count, int offset) {
		TestUtils utils = new TestUtils();
		utils.testTimeBegin();
		List<EventListModel> models = new ArrayList<EventListModel>();
		List<EventEntity> eventEntities = DBUtil.getData(EventEntity.class,
				count, offset);
		for (int i = 0; i < eventEntities.size(); i++) {
			EventListModel model = new EventListModel();
			EventEntity eventEntity = eventEntities.get(i);
			OrgEntity orgEntity = eventEntity.org;
			CouponProvideEntity couponEntity = DBUtil.getDataFirst(
					CouponProvideEntity.class, "rid = " + eventEntity.getId());
			ExchangeEntity exchangeEntity = DBUtil.getDataFirst(
					ExchangeEntity.class, "rid = " + eventEntity.getId());
			PopGoodsEntity popGoodsEntity = DBUtil.getDataFirst(
					PopGoodsEntity.class, "rid = " + eventEntity.getId());
			Event event = new Event();
			Org org = new Org();
			CouponProvide couponProvide = new CouponProvide();
			Exchange exchange = new Exchange();
			PopGoods popGoods = new PopGoods();
			DBUtil.copyData(EventEntity.class, Event.class, eventEntity, event);
			DBUtil.copyData(OrgEntity.class, Org.class, orgEntity, org);
			DBUtil.copyData(CouponProvideEntity.class, CouponProvide.class,
					couponEntity, couponProvide);
			DBUtil.copyData(ExchangeEntity.class, Exchange.class,
					exchangeEntity, exchange);
			DBUtil.copyData(PopGoodsEntity.class, PopGoods.class,
					popGoodsEntity, popGoods);
			model.event = event;
			model.org = org;
			model.couponProvide = couponProvide;
			model.exchange = exchange;
			model.popGoods = popGoods;
			models.add(model);
		}
		utils.testTimeEnd("取数据");
		return models;
	}

	public void deleteAll() {
	}
}
