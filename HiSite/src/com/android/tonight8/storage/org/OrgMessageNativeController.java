package com.android.tonight8.storage.org;

import java.util.ArrayList;
import java.util.List;

import com.android.tonight8.model.common.Message;
import com.android.tonight8.model.common.Org;
import com.android.tonight8.model.common.User;
import com.android.tonight8.model.organization.OrgMessageModel;
import com.android.tonight8.storage.DBUtil;
import com.android.tonight8.storage.entity.MessageEntity;
import com.android.tonight8.storage.entity.OrgEntity;
import com.android.tonight8.storage.entity.UserEntity;

public class OrgMessageNativeController {

	/**
	 * @Description:插入数据
	 * @param listModel
	 * @date:2015年1月22日
	 */
	public void saveOrUpdateData(List<OrgMessageModel> listModel) {
		List<MessageEntity> messageEntities = new ArrayList<MessageEntity>();
		List<UserEntity> userlist = new ArrayList<UserEntity>();
		List<OrgEntity> orglist = new ArrayList<OrgEntity>();
		for (int i = 0; i < listModel.size(); i++) {
			MessageEntity messageEntity = new MessageEntity();
			DBUtil.copyData(Message.class, MessageEntity.class, listModel.get(i).message, messageEntity);
			messageEntities.add(messageEntity);

			UserEntity userEntity = new UserEntity();
			DBUtil.copyData(User.class, UserEntity.class, listModel.get(i).user, userEntity);
			userlist.add(userEntity);

			OrgEntity orgEntity = new OrgEntity();
			DBUtil.copyData(Org.class, OrgEntity.class, listModel.get(i).org, orgEntity);
			orglist.add(orgEntity);
		}
		// 存到数据库中
		DBUtil.saveOrUpdateAll(messageEntities, MessageEntity.class);
		DBUtil.saveOrUpdateAll(userlist, UserEntity.class, "name", "pic");
		DBUtil.saveOrUpdateAll(orglist, OrgEntity.class, "name", "pic");
	}

	/**
	 * @Description:查询数据
	 * @param userid
	 * @param limit
	 * @param offset
	 * @return
	 * @author: LiuZhao
	 * @date:2015年3月4日
	 */

	public List<OrgMessageModel> selectData(String id, String limit, String offset) {
		List<OrgMessageModel> listModels = new ArrayList<OrgMessageModel>();
		List<MessageEntity> messageEntities = DBUtil.getData(MessageEntity.class, " id = " + id + "limit " + limit + " offset " + offset + " order by date,time desc");
		if (messageEntities != null) {
			for (int j = 0; j < messageEntities.size(); j++) {
				OrgMessageModel model = new OrgMessageModel();
				Message message = new Message();
				DBUtil.copyData(MessageEntity.class, Message.class, messageEntities.get(j), message);
				model.setMessage(message);

				User user = new User();
				DBUtil.copyData(UserEntity.class, User.class, messageEntities.get(j).user, user);
				model.setUser(user);

				Org org = new Org();
				DBUtil.copyData(OrgEntity.class, Org.class, messageEntities.get(j).org, org);
				model.setOrg(org);
			}

		}

		return listModels;
	}
}
