/**
 * 2015-1-22
 */
package com.android.tonight8.storage.event;

import java.util.ArrayList;
import java.util.List;

import com.android.tonight8.model.common.Apply;
import com.android.tonight8.model.common.Award;
import com.android.tonight8.model.common.Event;
import com.android.tonight8.model.common.Exchange;
import com.android.tonight8.model.common.Org;
import com.android.tonight8.model.common.User;
import com.android.tonight8.model.event.EventAwardModel;
import com.android.tonight8.storage.DBUtil;
import com.android.tonight8.storage.entity.ApplyEntity;
import com.android.tonight8.storage.entity.AwardEntity;
import com.android.tonight8.storage.entity.EventEntity;
import com.android.tonight8.storage.entity.ExchangeEntity;
import com.android.tonight8.storage.entity.OrgEntity;
import com.android.tonight8.storage.entity.UserEntity;

/**
 * @Description:活动中奖名单本地控制类
 * @author:LiXiaoSong
 * @copyright @HiSite
 * @Date:2015-1-22
 */
public class EventAwardsNativeController {

	/**
	 * @Description: 活动中奖名单列表存入
	 * @param models
	 * @author: LiXiaoSong
	 * @date:2015-1-22
	 */
	public void insertData(List<EventAwardModel> models) {
		// 商家和活动在这个名单里仅一份，可以通过查询找到，无需存入
		List<AwardEntity> awardEntities = new ArrayList<AwardEntity>();
		List<ApplyEntity> applyEntities = new ArrayList<ApplyEntity>();
		ExchangeEntity exchangeEntity = new ExchangeEntity();
		List<UserEntity> userEntities = new ArrayList<UserEntity>();
		DBUtil.copyData(Exchange.class, ExchangeEntity.class, models.get(0).exchange, exchangeEntity);
		EventEntity eventEntity = DBUtil.getDataFirst(EventEntity.class, "id = " + models.get(0).event.id);
		for (int i = 0; i < models.size(); i++) {
			AwardEntity awardEntity = new AwardEntity();
			ApplyEntity applyEntity = new ApplyEntity();
			UserEntity userEntity = new UserEntity();
			DBUtil.copyData(Award.class, AwardEntity.class, models.get(i).award, awardEntity);
			DBUtil.copyData(Apply.class, ApplyEntity.class, models.get(i).apply, applyEntity);
			DBUtil.copyData(Exchange.class, ExchangeEntity.class, models.get(i).exchange, exchangeEntity);
			DBUtil.copyData(User.class, UserEntity.class, models.get(i).user, userEntity);
			awardEntity.event = eventEntity;
			awardEntity.user = userEntity;
			applyEntity.event = eventEntity;
			applyEntity.user = userEntity;
			exchangeEntity.event = eventEntity;
			awardEntities.add(awardEntity);
			applyEntities.add(applyEntity);
			userEntities.add(userEntity);
		}
		DBUtil.saveOrUpdateAll(awardEntities);
		DBUtil.saveOrUpdateAll(applyEntities);
		DBUtil.saveOrUpdate(exchangeEntity);
		DBUtil.saveOrUpdateAll(userEntities);
	}

	/**
	 * @Description: 活动中奖名单列表取出
	 * @param models
	 * @author: LiXiaoSong
	 * @date:2015-1-22
	 */
	public List<EventAwardModel> selectData(long eventId) {
		List<EventAwardModel> models = new ArrayList<EventAwardModel>();
		List<AwardEntity> awardEntities = DBUtil.getData(AwardEntity.class, "rid = " + eventId);
		List<ApplyEntity> applyEntities = DBUtil.getData(ApplyEntity.class, "rid = " + eventId);
		ExchangeEntity exchangeEntity = DBUtil.getDataFirst(ExchangeEntity.class, "rid = " + eventId);
		for (int i = 0; i < awardEntities.size(); i++) {
			EventAwardModel model = new EventAwardModel();
			Award award = new Award();
			Apply apply = new Apply();
			Exchange exchange = new Exchange();
			User user = new User();
			Event event = new Event();
			Org org = new Org();
			DBUtil.copyData(AwardEntity.class, Award.class, awardEntities.get(i), award);
			DBUtil.copyData(ApplyEntity.class, Apply.class, applyEntities.get(i), apply);
			DBUtil.copyData(ExchangeEntity.class, Exchange.class, exchangeEntity, exchange);
			DBUtil.copyData(UserEntity.class, User.class, awardEntities.get(i).user, user);
			DBUtil.copyData(EventEntity.class, Event.class, awardEntities.get(i).event, event);
			DBUtil.copyData(OrgEntity.class, Org.class, exchangeEntity.event.org, org);
			model.apply = apply;
			model.award = award;
			model.event = event;
			model.exchange = exchange;
			model.org = org;
			model.user = user;
			models.add(model);
		}
		return models;
	}
}
