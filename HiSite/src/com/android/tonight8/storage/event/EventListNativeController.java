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

/**
 * @Description:开奖列表本地数据控制
 * @author:LiXiaoSong
 * @copyright @HiSite
 * @Date:2015-1-21
 */
public class EventListNativeController {

	public void insertData(List<EventListModel> models) {
		List<EventEntity> eventEntities = new ArrayList<EventEntity>();
		List<OrgEntity> orgEntities = new ArrayList<OrgEntity>();
		List<CouponProvideEntity> couponProvideEntities = new ArrayList<CouponProvideEntity>();
		List<ExchangeEntity> exchangeEntities = new ArrayList<ExchangeEntity>();
		for (int i = 0; i < models.size(); i++) {
			EventListModel model = models.get(i);
			EventEntity eventEntity = new EventEntity();
			OrgEntity orgEntity = new OrgEntity();
			CouponProvideEntity couponEntity = new CouponProvideEntity();
			ExchangeEntity exchangeEntity = new ExchangeEntity();
			PopGoodsEntity popGoodsEntity = new PopGoodsEntity();
			// 数据存储
			DBUtil.copyData(PopGoods.class, PopGoodsEntity.class, model.popGoods, popGoodsEntity);
			DBUtil.copyData(Event.class, EventEntity.class, model.event, eventEntity);
			DBUtil.copyData(Org.class, OrgEntity.class, model.org, orgEntity);
			DBUtil.copyData(CouponProvide.class, CouponProvideEntity.class, model.couponProvide, couponEntity);
			DBUtil.copyData(Exchange.class, ExchangeEntity.class, model.exchange, exchangeEntity);
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
			// DBUtil.saveOrUpdate(popGoodsEntity, PopGoodsEntity.class, WhereBuilder.b("rid", "=",
			// eventEntity.getId()), "popGoodsName", "popGoodsPic", "popGoodsPrice");
			// DBUtil.saveOrUpdate(exchangeEntity,ExchangeEntity.class,WhereBuilder.b("rid","=",eventEntity.getId()),"method",
			// "address", "orgAll");
		}
		DBUtil.saveOrUpdateAll(eventEntities, EventEntity.class, "name", "distance", "applyCount", "consultCount");
		DBUtil.saveOrUpdateAll(orgEntities, OrgEntity.class, "name");
		DBUtil.saveOrUpdateAll(couponProvideEntities, CouponProvideEntity.class, "type", "provideNum", "provideAll");
		// DBUtil.saveOrUpdateAll(exchangeEntities, ExchangeEntity.class, "method", "address", "orgAll");
	}

	/**
	 * @Description: 获取所有的活动列表，暂时按活动开始时间戳排序
	 * @return 排序好的数据
	 * @author: LiXiaoSong
	 * @date:2015-1-21
	 */
	public List<EventListModel> selectData() {
		List<EventListModel> models = new ArrayList<EventListModel>();
		List<EventEntity> eventEntities = DBUtil.getData(EventEntity.class);
		for (int i = 0; i < eventEntities.size(); i++) {
			EventListModel model = new EventListModel();
			EventEntity eventEntity = eventEntities.get(i);
			OrgEntity orgEntity = eventEntity.org;
			CouponProvideEntity couponEntity = DBUtil.getDataFirst(CouponProvideEntity.class, "rid = " + eventEntity.getId());
			ExchangeEntity exchangeEntity = DBUtil.getDataFirst(ExchangeEntity.class, "rid = " + eventEntity.getId());
			PopGoodsEntity popGoodsEntity = DBUtil.getDataFirst(PopGoodsEntity.class, "rid = " + eventEntity.getId());
			Event event = new Event();
			Org org = new Org();
			CouponProvide couponProvide = new CouponProvide();
			Exchange exchange = new Exchange();
			PopGoods popGoods = new PopGoods();
			DBUtil.copyData(EventEntity.class, Event.class, eventEntity, event);
			DBUtil.copyData(OrgEntity.class, Org.class, orgEntity, org);
			DBUtil.copyData(CouponProvideEntity.class, CouponProvide.class, couponEntity, couponProvide);
			DBUtil.copyData(ExchangeEntity.class, Exchange.class, exchangeEntity, exchange);
			DBUtil.copyData(PopGoodsEntity.class, PopGoods.class, popGoodsEntity, popGoods);
			model.event = event;
			model.org = org;
			model.couponProvide = couponProvide;
			model.exchange = exchange;
			model.popGoods = popGoods;
			models.add(model);
		}
		return models;
	}

	public void deleteAll() {
	}
}
