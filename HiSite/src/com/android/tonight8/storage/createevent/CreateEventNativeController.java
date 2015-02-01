package com.android.tonight8.storage.createevent;

import com.android.tonight8.model.common.Event;
import com.android.tonight8.model.common.Exchange;
import com.android.tonight8.model.common.Goods;
import com.android.tonight8.model.createevent.CreateEventModel;
import com.android.tonight8.storage.DBUtil;
import com.android.tonight8.storage.entity.EventEntity;
import com.android.tonight8.storage.entity.ExchangeEntity;
import com.android.tonight8.storage.entity.GoodsEntity;

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
	public void InsertData(CreateEventModel listModel) {

		// 查询是否有该活动

		EventEntity eventEntity = new EventEntity();
		DBUtil.copyData(Event.class, EventEntity.class, listModel.event, eventEntity);
		ExchangeEntity exchangeEntity = new ExchangeEntity();
		DBUtil.copyData(Exchange.class, ExchangeEntity.class, listModel.exchange, exchangeEntity);
		GoodsEntity goodsEntity = new GoodsEntity();
		DBUtil.copyData(Goods.class, GoodsEntity.class, listModel.goods, goodsEntity);
		// 存到数据库中
		DBUtil.saveOrUpdate(eventEntity);
		DBUtil.saveOrUpdate(exchangeEntity);
		DBUtil.saveOrUpdate(goodsEntity);
	}

	/**
	 * 查询发布的活动数据
	 * @param id
	 * @return
	 */
	public CreateEventModel selectData(String id) {
		CreateEventModel createEventModel = new CreateEventModel();
		EventEntity eventEntity = DBUtil.getDataFirst(EventEntity.class, "id = " + id);
		DBUtil.copyData(EventEntity.class, Event.class, eventEntity, createEventModel.event);

		ExchangeEntity exchangeEntity = DBUtil.getDataFirst(ExchangeEntity.class, "rid = " + id);
		DBUtil.copyData(ExchangeEntity.class, Exchange.class, exchangeEntity, createEventModel.exchange);
		
		GoodsEntity goodsEntity = DBUtil.getDataFirst(GoodsEntity.class, "rid = " + id);
		DBUtil.copyData(GoodsEntity.class, Goods.class, goodsEntity, createEventModel.goods);
		
		return createEventModel;
	}

}
