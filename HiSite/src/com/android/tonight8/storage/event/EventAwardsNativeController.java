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
		List<ExchangeEntity> exchangeEntities = new ArrayList<ExchangeEntity>();
		List<EventEntity> eventEntities = new ArrayList<EventEntity>();
		List<OrgEntity> orgEntities = new ArrayList<OrgEntity>();
		List<UserEntity> userEntities = new ArrayList<UserEntity>();
		for (int i = 0; i < models.size(); i++) {
			AwardEntity awardEntity = new AwardEntity();
			ApplyEntity applyEntity = new ApplyEntity();
			UserEntity userEntity = new UserEntity();
			ExchangeEntity exchangeEntity = new ExchangeEntity();
			EventEntity eventEntity = new EventEntity();
			OrgEntity orgEntity = new OrgEntity();
			DBUtil.copyData(Award.class, AwardEntity.class, models.get(i).award, awardEntity);
			DBUtil.copyData(Apply.class, ApplyEntity.class, models.get(i).apply, applyEntity);
			DBUtil.copyData(Exchange.class, ExchangeEntity.class, models.get(i).exchange, exchangeEntity);
			DBUtil.copyData(User.class, UserEntity.class, models.get(i).user, userEntity);
			DBUtil.copyData(Event.class, EventEntity.class, models.get(i).event, eventEntity);
			DBUtil.copyData(Org.class, OrgEntity.class, models.get(i).org, orgEntity);
			awardEntity.event = eventEntity;
			awardEntity.user = userEntity;
			applyEntity.event = eventEntity;
			applyEntity.user = userEntity;
			exchangeEntity.org = orgEntity;
			eventEntity.org = orgEntity;
			awardEntities.add(awardEntity);
			applyEntities.add(applyEntity);
			userEntities.add(userEntity);
			eventEntities.add(eventEntity);
			orgEntities.add(orgEntity);
			exchangeEntities.add(exchangeEntity);
		}
		DBUtil.saveOrUpdateAll(awardEntities, AwardEntity.class, "code");
		DBUtil.saveOrUpdateAll(applyEntities, ApplyEntity.class, "date", "time");
		DBUtil.saveOrUpdateAll(exchangeEntities, ExchangeEntity.class, "method", "address", "orgAll");
		DBUtil.saveOrUpdateAll(userEntities, UserEntity.class, "name", "pic");
		DBUtil.saveOrUpdateAll(eventEntities, EventEntity.class, "distance", "timeRangeStart", "timeRangeEnd");
		DBUtil.saveOrUpdateAll(orgEntities, OrgEntity.class, "address");
	}

	/**
	 * @Description: 活动中奖名单列表取出
	 * @param models
	 * @author: LiXiaoSong
	 * @date:2015-1-22
	 */
	public List<EventAwardModel> selectData(long eventId) {
		List<EventAwardModel> models = new ArrayList<EventAwardModel>();
		EventEntity eventEntity = DBUtil.getDataFirst(EventEntity.class, "id = " + eventId);
		List<AwardEntity> awardEntities = DBUtil.getData(AwardEntity.class, "rid = " + eventId);
		for (int i = 0; i < awardEntities.size(); i++) {
			EventAwardModel model = new EventAwardModel();
			Award award = new Award();
			Apply apply = new Apply();
			Exchange exchange = new Exchange();
			User user = new User();
			Event event = new Event();
			Org org = new Org();
			AwardEntity awardEntity = awardEntities.get(i);
			ApplyEntity applyEntity = DBUtil.getDataFirst(ApplyEntity.class, "uid = " + awardEntity.user.getId());
			// exchange没法进行
			UserEntity userEntity = awardEntity.user;
			EventEntity myEventEntity = awardEntity.event;
			OrgEntity orgEntity = awardEntity.event.org;
			DBUtil.copyData(AwardEntity.class, Award.class, awardEntity, award);
			DBUtil.copyData(ApplyEntity.class, Apply.class, applyEntity, apply);
			// exchange暂时没添加
			// DBUtil.copyData(AwardEntity.class, Award.class, awardEntity,award);
			DBUtil.copyData(UserEntity.class, User.class, userEntity, user);
			DBUtil.copyData(EventEntity.class, Event.class, eventEntity, event);
			DBUtil.copyData(OrgEntity.class, Org.class, orgEntity, org);
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
