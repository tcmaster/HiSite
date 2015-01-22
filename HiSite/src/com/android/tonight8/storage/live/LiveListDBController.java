package com.android.tonight8.storage.live;

import java.util.ArrayList;
import java.util.List;

import com.android.tonight8.model.common.Event;
import com.android.tonight8.model.common.Org;
import com.android.tonight8.model.common.SignIn;
import com.android.tonight8.model.common.User;
import com.android.tonight8.model.live.LiveListModel;
import com.android.tonight8.storage.DBUtil;
import com.android.tonight8.storage.entity.EventEntity;
import com.android.tonight8.storage.entity.OrgEntity;
import com.android.tonight8.storage.entity.SignInEntity;
import com.android.tonight8.storage.entity.UserEntity;

/**
 * @Description:现场列表数据存储控制类
 * @author:LiuZhao
 * @Date:2015年1月21日
 */
public class LiveListDBController {

	public void InsertData(List<LiveListModel> listModel) {
		List<EventEntity> eventEntities = new ArrayList<EventEntity>();
		List<OrgEntity> orgEntities = new ArrayList<OrgEntity>();
		List<SignInEntity> signLists = new ArrayList<SignInEntity>();
		List<UserEntity> userEntities = new ArrayList<UserEntity>();
		for (int i = 0; i < listModel.size(); i++) {

			// 查询是否有该活动，有的话，更新数据
			EventEntity hasEventEvent = DBUtil.getDataFirst(EventEntity.class, "id = " + listModel.get(i).getEvent().getId());
			EventEntity eventEntity = new EventEntity();
			DBUtil.copyData(Event.class, EventEntity.class, listModel.get(i).getEvent(), eventEntity);
			eventEntity = hasEventEvent;
			eventEntities.add(eventEntity);

			OrgEntity hasOrgEvent = DBUtil.getDataFirst(OrgEntity.class, "id = " + listModel.get(i).getOrg().getId());
			OrgEntity orgEntity = new OrgEntity();
			DBUtil.copyData(Org.class, OrgEntity.class, listModel.get(i).getOrg(), orgEntity);
			orgEntity = hasOrgEvent;
			orgEntities.add(orgEntity);

			for (int j = 0; j < listModel.get(i).getSignIn().size(); j++) {

				SignInEntity hasSignInEvent = DBUtil.getDataFirst(SignInEntity.class, "id = " + listModel.get(i).getSignIn().get(j).id);
				SignInEntity signInEntity = new SignInEntity();
				DBUtil.copyData(SignIn.class, SignInEntity.class, listModel.get(i).getSignIn().get(j), signInEntity);
				signInEntity = hasSignInEvent;
				signLists.add(signInEntity);

			}
			UserEntity hasUserEntity = DBUtil.getDataFirst(UserEntity.class, "id = " + listModel.get(i).getOrg().getId());
			UserEntity userEntity = new UserEntity();
			DBUtil.copyData(User.class, UserEntity.class, listModel.get(i).getUser(), userEntity);
			userEntity = hasUserEntity;
			userEntities.add(userEntity);
		}
		DBUtil.saveOrUpdate(eventEntities);
		DBUtil.saveOrUpdate(orgEntities);
		DBUtil.saveOrUpdate(signLists);
		DBUtil.saveOrUpdate(userEntities);
	}

	public void SelectData(String id) {
		
	}
}
