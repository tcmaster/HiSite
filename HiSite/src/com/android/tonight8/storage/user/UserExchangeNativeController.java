package com.android.tonight8.storage.user;

import java.util.ArrayList;
import java.util.List;

import com.android.tonight8.model.common.Event;
import com.android.tonight8.model.common.Exchange;
import com.android.tonight8.model.common.Org;
import com.android.tonight8.model.user.UserExchangeModel;
import com.android.tonight8.storage.DBUtil;
import com.android.tonight8.storage.entity.EventEntity;
import com.android.tonight8.storage.entity.ExchangeEntity;
import com.android.tonight8.storage.entity.OrgEntity;

/**
 * 
 * @Descripton 用户中奖码兑换本地存储控制类
 * @author LiXiaoSong
 * @2015-1-24
 * @Tonight8
 */
public class UserExchangeNativeController {

	/**
	 * 存储用户中奖码兑换详情实体
	 * 
	 * @param models
	 */
	public void insertData(UserExchangeModel model) {
		ExchangeEntity exchangeEntity = new ExchangeEntity();
		List<OrgEntity> orgEntities = new ArrayList<OrgEntity>();
		EventEntity eventEntity = new EventEntity();
		DBUtil.copyData(Exchange.class, ExchangeEntity.class, model.exchange, exchangeEntity);
		DBUtil.copyData(Event.class, EventEntity.class, model.event, eventEntity);
		// exchangeEntity.event = eventEntity;
		for (int i = 0; i < model.orgs.size(); i++) {
			OrgEntity orgEntity = new OrgEntity();
			DBUtil.copyData(Org.class, OrgEntity.class, model.orgs.get(i), orgEntity);
			orgEntities.add(orgEntity);
		}
		exchangeEntity.orgs = orgEntities;
		DBUtil.saveOrUpdate(exchangeEntity);
		DBUtil.saveOrUpdate(eventEntity);
		DBUtil.saveOrUpdateAll(orgEntities);
	}

	/**
	 * 根据用户和活动获取用户中奖码兑换详情
	 * 
	 * @param eventId
	 *            活动id
	 * @param userId
	 *            哪个用户(得不到，暂停）
	 */
	public UserExchangeModel selectData(long eventId, long userId) {
		UserExchangeModel model = new UserExchangeModel();

		return model;
	}
}
