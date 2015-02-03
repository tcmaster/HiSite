/**
 * 2015-2-3
 */
package com.android.tonight8.storage.user;

import java.util.ArrayList;
import java.util.List;

import com.android.tonight8.model.common.SignIn;
import com.android.tonight8.storage.DBUtil;
import com.android.tonight8.storage.entity.EventEntity;
import com.android.tonight8.storage.entity.SignInEntity;
import com.android.tonight8.storage.entity.UserEntity;

/**
 * @Description: 用户签到签收本地存储控制类
 * @author:LiXiaoSong
 * @copyright @HiSite
 * @Date:2015-2-3
 */
public class UserSignInNativeController {

	/**
	 * 用户签到/签收
	 */
	public void insertData(SignIn model) {
		SignInEntity signInEntity = new SignInEntity();
		DBUtil.copyData(SignIn.class, SignInEntity.class, model, signInEntity);
		signInEntity.event = DBUtil.getDataFirst(EventEntity.class, "id = " + model.rid);
		signInEntity.user = DBUtil.getDataFirst(UserEntity.class, "id = " + model.uid);
		DBUtil.saveOrUpdate(signInEntity, SignInEntity.class, "time", "pic", "size", "rid", "uid");
	}

	/**
	 * 
	 * @Description:根据用户id得到用户签到数据
	 * @param userId
	 * @author: LiXiaoSong
	 * @date:2015-2-3
	 */
	public List<SignIn> selectData(long userId) {
		List<SignIn> models = new ArrayList<SignIn>();
		List<SignInEntity> signInEntities = DBUtil.getData(SignInEntity.class, "uid = " + userId);
		for (int i = 0; i < signInEntities.size(); i++) {
			SignInEntity entity = signInEntities.get(i);
			SignIn signIn = new SignIn();
			DBUtil.copyData(SignInEntity.class, SignIn.class, entity, signIn);
			signIn.rid = (int) entity.event.getId();
			signIn.uid = (int) entity.user.getId();
			models.add(signIn);
		}
		return models;
	}
}
