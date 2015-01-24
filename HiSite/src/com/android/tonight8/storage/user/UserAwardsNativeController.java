package com.android.tonight8.storage.user;

import java.util.ArrayList;
import java.util.List;

import com.android.tonight8.model.common.Award;
import com.android.tonight8.model.common.Event;
import com.android.tonight8.model.user.UserAwardModel;
import com.android.tonight8.storage.DBUtil;
import com.android.tonight8.storage.entity.AwardEntity;
import com.android.tonight8.storage.entity.EventEntity;
import com.android.tonight8.storage.entity.UserEntity;

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
	 * @param models 实体内容
	 */
	public void insertData(List<UserAwardModel> models,long userId){
		List<AwardEntity> awardEntities = new ArrayList<AwardEntity>();
		List<EventEntity> eventEntities = new ArrayList<EventEntity>();
		UserEntity userEntity = DBUtil.getDataFirst(UserEntity.class,"id = "+ userId);
		for(int i = 0;i < models.size();i++){
			AwardEntity awardEntity = new AwardEntity();
			DBUtil.copyData(Award.class, AwardEntity.class,models.get(i).award,awardEntity);
			EventEntity eventEntity = DBUtil.getDataFirst(EventEntity.class,"id = " + models.get(i).event.id);
			if(eventEntity == null){
				eventEntity = new EventEntity();
				DBUtil.copyData(Event.class, EventEntity.class,models.get(i).event,eventEntity);
				eventEntities.add(eventEntity);
			}
			awardEntity.event = eventEntity;
			awardEntity.user = userEntity;
			awardEntities.add(awardEntity);
		}
		DBUtil.saveOrUpdateAll(awardEntities);
		DBUtil.saveOrUpdateAll(eventEntities);
	}
	/**
	 * 根据用户id获取用户中奖码
	 * @param userId 用户id
	 * @return
	 */
	public List<UserAwardModel> selectData(long userId){
		List<UserAwardModel> models = new ArrayList<UserAwardModel>();
		List<AwardEntity> awardEntities = DBUtil.getData(AwardEntity.class,"uid = " + userId);
		for(int i = 0;i < awardEntities.size();i++){
			UserAwardModel model = new UserAwardModel();
			Event event = new Event();
			Award award = new Award();
			DBUtil.copyData(AwardEntity.class,Award.class,awardEntities.get(i),award);
			DBUtil.copyData(EventEntity.class, Event.class,DBUtil.getDataFirst(EventEntity.class, "id ="+ awardEntities.get(i).event.getId()), event);
			model.award = award;
			model.event = event;
			models.add(model);
		}
		return models;
	}
}
