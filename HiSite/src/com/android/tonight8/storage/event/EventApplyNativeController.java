/**
 * 2015-1-23
 */
package com.android.tonight8.storage.event;

import java.util.ArrayList;
import java.util.List;

import com.android.tonight8.model.common.Apply;
import com.android.tonight8.storage.DBUtil;
import com.android.tonight8.storage.entity.ApplyEntity;
import com.android.tonight8.storage.entity.EventEntity;
import com.android.tonight8.storage.entity.UserEntity;

/**
 * @Description: 报名活动写入接口
 * @author:LiXiaoSong
 * @copyright @HiSite
 * @Date:2015-1-23
 */
public class EventApplyNativeController {

	/**
	 * @Description:写入一条报名数据
	 * @param model
	 *            报名数据
	 * @param eventid
	 *            报的哪个活动
	 * @param userid
	 *            哪个用户报的
	 * @author: LiXiaoSong
	 * @date:2015-1-23
	 */
	public void insertData(Apply model, long eventId, long userId) {
		ApplyEntity entity = new ApplyEntity();
		DBUtil.copyData(Apply.class, ApplyEntity.class, model, entity);
		entity.event = DBUtil.getDataFirst(EventEntity.class, "id = " + eventId);
		entity.user = DBUtil.getDataFirst(UserEntity.class, "id = " + userId);
		DBUtil.addData(entity);
	}
	/**
	 * @Description 查找出某个活动的所有报名数据
	 * @param eventId  报的哪个活动
	 * @return
	 */
	public List<Apply> selectDataByEvent(long eventId) {
		List<Apply> models = new ArrayList<Apply>();
		List<ApplyEntity> entities = DBUtil.getData(ApplyEntity.class,"rid = " + eventId);
		for(int i = 0;i < entities.size();i++){
			Apply model = new Apply();
			DBUtil.copyData(ApplyEntity.class, Apply.class,entities.get(i), model);
			models.add(model);
		}
		return models;
	}
	/**
	 * @Description 查找出某个用户的所有报名数据
	 * @param userId 哪个用户报的
	 * @return
	 */
	public List<Apply> selectDataByUser(long userId){
		List<Apply> models = new ArrayList<Apply>();
		List<ApplyEntity> entities = DBUtil.getData(ApplyEntity.class,"uid = " + userId);
		for(int i = 0;i < entities.size();i++){
			Apply model = new Apply();
			DBUtil.copyData(ApplyEntity.class, Apply.class,entities.get(i), model);
			models.add(model);
		}
		return models;
	}
}
