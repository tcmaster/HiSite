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
public class LiveListNativeController {

	/**
	 * @Description:插入数据
	 * @param listModel
	 * @date:2015年1月22日
	 */
	public void InsertData(List<LiveListModel> listModel) {
		List<EventEntity> eventEntities = new ArrayList<EventEntity>();
		List<OrgEntity> orgEntities = new ArrayList<OrgEntity>();
		List<SignInEntity> signLists = new ArrayList<SignInEntity>();
		// List<UserEntity> userEntities = new ArrayList<UserEntity>();
		for (int i = 0; i < listModel.size(); i++) {

			// 查询是否有该活动
			EventEntity eventEntity = new EventEntity();
			DBUtil.copyData(Event.class, EventEntity.class, listModel.get(i)
					.getEvent(), eventEntity);
			eventEntities.add(eventEntity);

			OrgEntity orgEntity = new OrgEntity();
			DBUtil.copyData(Org.class, OrgEntity.class, listModel.get(i)
					.getOrg(), orgEntity);
			orgEntities.add(orgEntity);

			for (int j = 0; j < listModel.get(i).getSignIn().size(); j++) {
				SignInEntity signInEntity = new SignInEntity();
				DBUtil.copyData(SignIn.class, SignInEntity.class, listModel
						.get(i).getSignIn().get(j), signInEntity);
				signLists.add(signInEntity);

			}
			// UserEntity hasUserEntity = DBUtil.getDataFirst(UserEntity.class,
			// "id = " + listModel.get(i).getOrg().getId());
			// UserEntity userEntity = new UserEntity();
			// DBUtil.copyData(User.class, UserEntity.class,
			// listModel.get(i).getUser(), userEntity);
			// userEntity = hasUserEntity;
			// userEntities.add(userEntity);
		}
		// 存到数据库中
		DBUtil.saveOrUpdate(eventEntities);
		DBUtil.saveOrUpdate(orgEntities);
		DBUtil.saveOrUpdate(signLists);
		// DBUtil.saveOrUpdate(userEntities);
	}

	/**
	 * @Description:查询现场列表数据
	 * @return
	 * @author: LiuZhao
	 * @date:2015年1月22日
	 */

	public List<LiveListModel> SelectData() {
		List<LiveListModel> listModels = new ArrayList<LiveListModel>();
		List<EventEntity> eventEntities = DBUtil.getData(EventEntity.class,
				"order by timeStamp desc");
		if (eventEntities == null) {
			return null;
		}
		for (int i = 0; i < eventEntities.size(); i++) {
			LiveListModel listModel = new LiveListModel();
			// 活动
			Event event = new Event();
			EventEntity eventEntity = new EventEntity();
			eventEntity = eventEntities.get(i);
			DBUtil.copyData(EventEntity.class, Event.class, eventEntity, event);
			listModel.setEvent(event);
			// 商家
			Org org = new Org();
			OrgEntity orgEntity = eventEntity.org;
			DBUtil.copyData(OrgEntity.class, Org.class, orgEntity, org);
			listModel.setOrg(org);
			// 签到
			List<SignIn> listSignIn = new ArrayList<SignIn>();
			List<SignInEntity> listSignInEntities = new ArrayList<SignInEntity>();
			listSignInEntities = DBUtil.getData(SignInEntity.class, "eid = "
					+ eventEntity.getId());
			for (int j = 0; j < listSignInEntities.size(); j++) {
				SignIn signIn = new SignIn();
				SignInEntity signInEntity = listSignInEntities.get(j);
				DBUtil.copyData(SignInEntity.class, SignIn.class, signInEntity,
						signIn);
				listSignIn.add(signIn);
			}
			listModel.setSignIn(listSignIn);

		}
		return listModels;

	}

	public void DeleteAll() {

	}
}
