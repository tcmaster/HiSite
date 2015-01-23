package com.android.tonight8.storage.createevent;

import com.android.tonight8.model.common.Event;
import com.android.tonight8.model.common.Exchange;
import com.android.tonight8.model.createevent.CreateEventModel;
import com.android.tonight8.storage.DBUtil;
import com.android.tonight8.storage.entity.EventEntity;
import com.android.tonight8.storage.entity.ExchangeEntity;

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
		DBUtil.copyData(Event.class, EventEntity.class, listModel.event,
				eventEntity);
		ExchangeEntity exchangeEntity = new ExchangeEntity();
		DBUtil.copyData(Exchange.class, ExchangeEntity.class,
				listModel.exchange, exchangeEntity);

		// 存到数据库中
		DBUtil.saveOrUpdate(eventEntity);
		DBUtil.saveOrUpdate(exchangeEntity);

	}

	/**
	 * @Description: 活动中奖名单列表取出
	 * @param models
	 * @author: LiXiaoSong
	 * @date:2015-1-22
	 */
	public CreateEventModel selectData(String id) {
		CreateEventModel createEventModel = new CreateEventModel();
		EventEntity eventEntity = DBUtil.getDataFirst(EventEntity.class,
				"id = " + id);
		DBUtil.copyData(EventEntity.class, Event.class, eventEntity,
				createEventModel.event);

		ExchangeEntity exchangeEntity = DBUtil.getDataFirst(
				ExchangeEntity.class, "id = " + id);
		DBUtil.copyData(ExchangeEntity.class, Exchange.class, exchangeEntity,
				createEventModel.exchange);

		return createEventModel;
	}

}
