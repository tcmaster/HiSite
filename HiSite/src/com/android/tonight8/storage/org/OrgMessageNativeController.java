package com.android.tonight8.storage.org;

import java.util.ArrayList;
import java.util.List;

import com.android.tonight8.dao.DaoSession;
import com.android.tonight8.model.common.Message;
import com.android.tonight8.model.common.Org;
import com.android.tonight8.model.common.User;
import com.android.tonight8.model.organization.OrgMessageModel;
import com.android.tonight8.storage.DBUtil;
import com.android.tonight8.storage.GreenDaoUtils;
import com.android.tonight8.storage.entity.MessageEntity;
import com.android.tonight8.storage.entity.OrgEntity;
import com.android.tonight8.storage.entity.UserEntity;

import de.greenrobot.dao.async.AsyncSession;

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

			// OrgEntity orgEntity = new OrgEntity();
			// DBUtil.copyData(Org.class, OrgEntity.class, listModel.get(i).org,
			// orgEntity);
			// orglist.add(orgEntity);
		}
		final DaoSession daoSession = GreenDaoUtils.getDaoSession();
		daoSession.runInTx(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				
			}
		});
	}

	/**
	 * @Description:查询数据
	 * @param orgid
	 * @param limit
	 * @param offset
	 * @return
	 * @author: LiuZhao
	 * @date:2015年3月4日
	 */

	public List<OrgMessageModel> selectData(String orgid, int limit, int offset) {
		List<OrgMessageModel> listModels = new ArrayList<OrgMessageModel>();
		List<MessageEntity> messageEntities = DBUtil.getData(MessageEntity.class, limit, offset);
		if (messageEntities != null) {
			for (int j = 0; j < messageEntities.size(); j++) {
				OrgMessageModel model = new OrgMessageModel();
				Message message = new Message();
				DBUtil.copyData(MessageEntity.class, Message.class, messageEntities.get(j), message);
				model.setMessage(message);

				User user = new User();
				DBUtil.copyData(UserEntity.class, User.class, messageEntities.get(j).user, user);
				model.setUser(user);

//				Org org = new Org();
//				DBUtil.copyData(OrgEntity.class, Org.class, messageEntities.get(j).org, org);
//				model.setOrg(org);
			}

		}
		final DaoSession daoSession = GreenDaoUtils.getDaoSession();
		final AsyncSession asyncSession = daoSession.startAsyncSession();
		asyncSession.runInTx(new Runnable() {
			
			@Override
			public void run() {

			}
		});

		return listModels;
	}
}
