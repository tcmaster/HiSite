package com.android.tonight8.storage.createevent;

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

/**
 * @author liuzhao
 * @date 2015-1-22 发布活动
 */
public class CreateEventNativeController {

	/**
	 * @Description:插入数据
	 * @param listModel
	 * @date:2015年1月22日
	 */
	public void InsertData(EventDetailModel listModel) {

		EventEntity eventEntity = new EventEntity();
		DBUtil.copyData(Event.class, EventEntity.class, listModel.event, eventEntity);
		ExchangeEntity exchangeEntity = new ExchangeEntity();
		DBUtil.copyData(Exchange.class, ExchangeEntity.class, listModel.exchange, exchangeEntity);
		List<GoodsEntity> goodsEntities = new ArrayList<GoodsEntity>();
		for (int i = 0; i < listModel.getGoodses().size(); i++) {
			GoodsEntity goodsEntity = new GoodsEntity();
			DBUtil.copyData(Goods.class, GoodsEntity.class, listModel.goodses.get(i), goodsEntity);
			goodsEntities.add(goodsEntity);

		}
		OrgEntity orgEntity = new OrgEntity();
		DBUtil.copyData(Org.class, OrgEntity.class, listModel.org, orgEntity);

		PopGoodsEntity popGoodsEntity = new PopGoodsEntity();
		DBUtil.copyData(PopGoods.class, PopGoodsEntity.class, listModel.popGoods, popGoodsEntity);

		CouponProvideEntity couponProvide = new CouponProvideEntity();
		DBUtil.copyData(CouponProvide.class, CouponProvideEntity.class, listModel.couponProvide, couponProvide);
		// 存到数据库中
		DBUtil.saveOrUpdateAll(goodsEntities, GoodsEntity.class, "name", "pic", "price");
		DBUtil.saveOrUpdate(eventEntity, EventEntity.class, "name", "winningLimit", "ruleDesc");
		DBUtil.saveOrUpdate(exchangeEntity, ExchangeEntity.class, "address", "orgAll", "method");
		DBUtil.saveOrUpdate(orgEntity, OrgEntity.class, "address", "orgAll", "method");
		DBUtil.saveOrUpdate(couponProvide, CouponProvideEntity.class, "content", "type", "value", "provideAll", "provideNum", "dateRangeStart", "dateRangeEnd");
		DBUtil.saveOrUpdate(popGoodsEntity, PopGoodsEntity.class, "popGoodsName", "popGoodsPic", "popGoodsPrice");
	}

	// /**
	// * 查询发布的活动数据
	// *
	// * @param id
	// * @return
	// */
	// public CreateEventModel selectData(String id) {
	// CreateEventModel createEventModel = new CreateEventModel();
	// EventEntity eventEntity = DBUtil.getDataFirst(EventEntity.class, "id = " + id);
	// DBUtil.copyData(EventEntity.class, Event.class, eventEntity, createEventModel.event);
	//
	// ExchangeEntity exchangeEntity = DBUtil.getDataFirst(ExchangeEntity.class, "rid = " + id);
	// DBUtil.copyData(ExchangeEntity.class, Exchange.class, exchangeEntity, createEventModel.exchange);
	//
	// GoodsEntity goodsEntity = DBUtil.getDataFirst(GoodsEntity.class, "rid = " + id);
	// DBUtil.copyData(GoodsEntity.class, Goods.class, goodsEntity, createEventModel.goods);
	//
	// return createEventModel;
	// }

}
