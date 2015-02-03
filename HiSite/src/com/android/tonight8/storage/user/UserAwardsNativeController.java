package com.android.tonight8.storage.user;

import java.util.ArrayList;
import java.util.List;

import com.android.tonight8.model.common.Award;
import com.android.tonight8.model.common.Event;
import com.android.tonight8.model.common.PopGoods;
import com.android.tonight8.model.user.UserAwardModel;
import com.android.tonight8.storage.DBUtil;
import com.android.tonight8.storage.entity.AwardEntity;
import com.android.tonight8.storage.entity.EventEntity;
import com.android.tonight8.storage.entity.PopGoodsEntity;
import com.android.tonight8.storage.entity.UserEntity;
import com.lidroid.xutils.db.sqlite.WhereBuilder;

/**
 * 
 * @Descripton 用户中奖码本地存储控制类
 * @author LiXiaoSong
 * @2015-1-24
 * @Tonight8
 */
public class UserAwardsNativeController {

	/**
	 * 存储用户中奖码
	 * 
	 * @param models
	 *            实体内容
	 */
	public void insertData(List<UserAwardModel> models, long userId) {
		List<AwardEntity> awardEntities = new ArrayList<AwardEntity>();
		List<EventEntity> eventEntities = new ArrayList<EventEntity>();
		UserEntity userEntity = DBUtil.getDataFirst(UserEntity.class, "id = " + userId);
		for (int i = 0; i < models.size(); i++) {
			AwardEntity awardEntity = new AwardEntity();
			EventEntity eventEntity = new EventEntity();
			PopGoodsEntity popGoodsEntity = new PopGoodsEntity();
			DBUtil.copyData(Award.class, AwardEntity.class, models.get(i).award, awardEntity);
			DBUtil.copyData(Event.class, EventEntity.class, models.get(i).event, eventEntity);
			DBUtil.copyData(PopGoods.class, PopGoodsEntity.class, models.get(i).popGoods, popGoodsEntity);
			awardEntity.event = eventEntity;
			awardEntity.user = userEntity;
			popGoodsEntity.event = eventEntity;
			awardEntities.add(awardEntity);
			eventEntities.add(eventEntity);
			DBUtil.saveOrUpdate(popGoodsEntity, PopGoodsEntity.class, WhereBuilder.b("rid", "=", eventEntity.getId()), "popGoodsName", "popGoodsPic", "popGoodsPrice");
		}
		DBUtil.saveOrUpdateAll(awardEntities, AwardEntity.class, "code");
		DBUtil.saveOrUpdateAll(eventEntities, EventEntity.class, "name");
	}

	/**
	 * 根据用户id获取用户中奖码
	 * 
	 * @param userId
	 *            用户id
	 * @return
	 */
	public List<UserAwardModel> selectData(long userId) {
		List<UserAwardModel> models = new ArrayList<UserAwardModel>();
		List<AwardEntity> awardEntities = DBUtil.getData(AwardEntity.class, "uid = " + userId);
		for (int i = 0; i < awardEntities.size(); i++) {
			UserAwardModel model = new UserAwardModel();
			Event event = new Event();
			Award award = new Award();
			PopGoods popGoods = new PopGoods();
			DBUtil.copyData(AwardEntity.class, Award.class, awardEntities.get(i), award);
			DBUtil.copyData(EventEntity.class, Event.class, awardEntities.get(i).event, event);
			DBUtil.copyData(PopGoodsEntity.class, PopGoods.class, DBUtil.getDataFirst(PopGoodsEntity.class, "rid = " + awardEntities.get(i).event.getId()), popGoods);
			model.award = award;
			model.event = event;
			model.popGoods = popGoods;
			models.add(model);
		}
		return models;
	}
}
