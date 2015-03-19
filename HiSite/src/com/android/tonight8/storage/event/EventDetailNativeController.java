/**
 * 2015-1-21
 */
package com.android.tonight8.storage.event;

import java.util.ArrayList;
import java.util.List;

import com.android.tonight8.model.common.CouponProvide;
import com.android.tonight8.model.common.Event;
import com.android.tonight8.model.common.Exchange;
import com.android.tonight8.model.common.Goods;
import com.android.tonight8.model.common.Org;
import com.android.tonight8.model.common.PopGoods;
import com.android.tonight8.model.event.EventDetailModel;
import com.android.tonight8.storage.DBUtil;
import com.android.tonight8.storage.entity.CouponProvideEntity;
import com.android.tonight8.storage.entity.EventEntity;
import com.android.tonight8.storage.entity.ExchangeEntity;
import com.android.tonight8.storage.entity.GoodsEntity;
import com.android.tonight8.storage.entity.OrgEntity;
import com.android.tonight8.storage.entity.PopGoodsEntity;
import com.lidroid.xutils.db.sqlite.WhereBuilder;

/**
 * @Description:活动详情本地控制类
 * @author:LiXiaoSong
 * @copyright @HiSite
 * @Date:2015-1-21
 */
public class EventDetailNativeController {

	/**
	 * @Description:存储一个活动详情
	 * @param model
	 *            要存储的model
	 * @author: LiXiaoSong
	 * @date:2015-1-22
	 */
	public void insertData(EventDetailModel model) {
		EventEntity eventEntity = new EventEntity();
		OrgEntity orgEntity = new OrgEntity();
		CouponProvideEntity couponEntity = new CouponProvideEntity();
		ExchangeEntity exchangeEntity = new ExchangeEntity();
		PopGoodsEntity popGoodsEntity = new PopGoodsEntity();
		List<GoodsEntity> goodsEntities = new ArrayList<GoodsEntity>();
		List<Goods> goodses = model.goodses;
		// 数据存储
		DBUtil.copyData(PopGoods.class, PopGoodsEntity.class, model.popGoods,
				popGoodsEntity);
		DBUtil.copyData(Event.class, EventEntity.class, model.event,
				eventEntity);
		DBUtil.copyData(Org.class, OrgEntity.class, model.org, orgEntity);
		DBUtil.copyData(CouponProvide.class, CouponProvideEntity.class,
				model.couponProvide, couponEntity);
		DBUtil.copyData(Exchange.class, ExchangeEntity.class, model.exchange,
				exchangeEntity);
		// 外键连接
		popGoodsEntity.event = eventEntity;
		eventEntity.org = orgEntity;
		couponEntity.event = eventEntity;
		exchangeEntity.event = eventEntity;
		popGoodsEntity.event = eventEntity;
		for (int i = 0; i < goodses.size(); i++) {
			GoodsEntity goodsEntity = new GoodsEntity();
			DBUtil.copyData(Goods.class, GoodsEntity.class, goodses.get(i),
					goodsEntity);
			goodsEntity.event = eventEntity;
			goodsEntities.add(goodsEntity);
		}
		DBUtil.saveOrUpdate(eventEntity, EventEntity.class, "name",
				"timeStamp", "applyCount", "goodsCount", "timeRangeStart",
				"timeRangeEnd", "ruleDesc");
		DBUtil.saveOrUpdate(orgEntity, OrgEntity.class, "name");
		DBUtil.saveOrUpdate(couponEntity, CouponProvideEntity.class, "type",
				"provideNum", "provideAll", "value");
		DBUtil.saveOrUpdate(exchangeEntity, ExchangeEntity.class, "method",
				"address", "orgAll");
		DBUtil.saveOrUpdate(popGoodsEntity, PopGoodsEntity.class,
				WhereBuilder.b("rid", "=", eventEntity.getId()),
				"popGoodsName", "popGoodsPic", "popGoodsPrice");
		DBUtil.saveOrUpdateAll(goodsEntities, GoodsEntity.class, "name", "pic",
				"size", "price");
	}

	/**
	 * @Description:根据活动id得到活动详情
	 * @param id
	 *            活动的id
	 * @author: LiXiaoSong
	 * @date:2015-1-22
	 */
	public EventDetailModel selectData(long id) {
		EventDetailModel model = new EventDetailModel();
		Event event = new Event();
		Org org = new Org();
		CouponProvide couponProvide = new CouponProvide();
		Exchange exchange = new Exchange();
		PopGoods popGoods = new PopGoods();
		List<Goods> goodses = new ArrayList<Goods>();
		EventEntity eventEntity = DBUtil.getDataFirst(EventEntity.class,
				"id = " + id);
		OrgEntity orgEntity = eventEntity.org;
		CouponProvideEntity couponProvideEntity = DBUtil.getDataFirst(
				CouponProvideEntity.class, "rid = " + eventEntity.getId());
		List<GoodsEntity> goodsEntities = DBUtil.getData(GoodsEntity.class,
				"rid = " + event.getId());
		ExchangeEntity exchangeEntity = DBUtil.getDataFirst(
				ExchangeEntity.class, "rid = " + event.rid);
		PopGoodsEntity popGoodsEntity = DBUtil.getDataFirst(
				PopGoodsEntity.class, "rid = " + event.getId());
		DBUtil.copyData(EventEntity.class, Event.class, eventEntity, event);
		DBUtil.copyData(OrgEntity.class, Org.class, orgEntity, org);
		DBUtil.copyData(CouponProvideEntity.class, CouponProvide.class,
				couponProvideEntity, couponProvide);
		for (int i = 0; i < goodsEntities.size(); i++) {
			Goods goods = new Goods();
			DBUtil.copyData(GoodsEntity.class, Goods.class,
					goodsEntities.get(i), goods);
			goodses.add(goods);
		}
		DBUtil.copyData(ExchangeEntity.class, Exchange.class, exchangeEntity,
				exchange);
		DBUtil.copyData(PopGoodsEntity.class, PopGoods.class, popGoodsEntity,
				popGoods);
		model.event = event;
		model.org = org;
		model.couponProvide = couponProvide;
		model.exchange = exchange;
		model.popGoods = popGoods;
		model.goodses = goodses;
		return model;
	}
}
