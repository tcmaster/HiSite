/**
 * 2015-1-22
 */
package com.android.tonight8.storage.event;

import java.util.ArrayList;
import java.util.List;

import com.android.tonight8.model.common.Consult;
import com.android.tonight8.model.common.User;
import com.android.tonight8.model.event.EventConsultModel;
import com.android.tonight8.storage.DBUtil;
import com.android.tonight8.storage.entity.ConsultEntity;
import com.android.tonight8.storage.entity.EventEntity;
import com.android.tonight8.storage.entity.UserEntity;

/**
 * @Description:活动咨询列表
 * @author:LiXiaoSong
 * @copyright @HiSite
 * @Date:2015-1-22
 */
public class EventConsultsNativeController {

	/**
	 * @Description:插入活动咨询数据
	 * @param models
	 * @author: LiXiaoSong
	 * @date:2015-1-22
	 */
	public void insertData(List<EventConsultModel> models) {
		List<ConsultEntity> consultEntities = new ArrayList<ConsultEntity>();
		List<UserEntity> userEntities = new ArrayList<UserEntity>();
		for (int i = 0; i < models.size(); i++) {
			EventConsultModel model = models.get(i);
			ConsultEntity consultEntity = new ConsultEntity();
			UserEntity userEntity = new UserEntity();
			DBUtil.copyData(Consult.class, ConsultEntity.class, model.consult, consultEntity);
			DBUtil.copyData(User.class, UserEntity.class, model.user, userEntity);
			consultEntity.event = DBUtil.getDataFirst(EventEntity.class, "id = " + model.consult.rid);
			consultEntity.user = userEntity;
			consultEntities.add(consultEntity);
			userEntities.add(userEntity);
		}
		DBUtil.saveOrUpdateAll(consultEntities);
		DBUtil.saveOrUpdateAll(userEntities);
	}

	/**
	 * @Description:取出活动咨询数据
	 * @param eventid
	 *            活动id
	 * @author: LiXiaoSong
	 * @date:2015-1-22
	 */
	public List<EventConsultModel> selectData(long eventid) {
		List<EventConsultModel> models = new ArrayList<EventConsultModel>();
		List<ConsultEntity> consultEntities = new ArrayList<ConsultEntity>();
		consultEntities = DBUtil.getData(ConsultEntity.class, "rid = " + eventid);
		for (int i = 0; i < consultEntities.size(); i++) {
			EventConsultModel model = new EventConsultModel();
			Consult consult = new Consult();
			User user = new User();
			DBUtil.copyData(ConsultEntity.class, Consult.class, consultEntities.get(i), consult);
			DBUtil.copyData(UserEntity.class, User.class, consultEntities.get(i).user, user);
			model.consult = consult;
			model.user = user;
			models.add(model);
		}
		return models;
	}
}
