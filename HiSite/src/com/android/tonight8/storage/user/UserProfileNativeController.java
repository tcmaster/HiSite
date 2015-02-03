package com.android.tonight8.storage.user;

import com.android.tonight8.model.common.ThirdPartyAccount;
import com.android.tonight8.model.common.User;
import com.android.tonight8.model.user.UserProfileModel;
import com.android.tonight8.storage.DBUtil;
import com.android.tonight8.storage.entity.ThirdPartyAccountEntity;
import com.android.tonight8.storage.entity.UserEntity;
import com.lidroid.xutils.db.sqlite.WhereBuilder;

/**
 * 
 * @Descripton 用户资料更新本地控制模块
 * @author LiXiaoSong
 * @2015-1-24
 * @Tonight8
 */
public class UserProfileNativeController {

	/**
	 * 存储/更新用户资料
	 */
	public void insertOrUpdateData(UserProfileModel model) {
		ThirdPartyAccountEntity thirdPartyAccountEntity = new ThirdPartyAccountEntity();
		UserEntity userEntity = new UserEntity();
		DBUtil.copyData(ThirdPartyAccount.class, ThirdPartyAccountEntity.class, model.thirdPartyAccount, thirdPartyAccountEntity);
		DBUtil.copyData(User.class, UserEntity.class, model.user, userEntity);
		thirdPartyAccountEntity.user = userEntity;
		DBUtil.saveOrUpdate(userEntity, UserEntity.class, "name", "gender", "mobilePhone", "email", "address", "pic");
		DBUtil.saveOrUpdate(thirdPartyAccountEntity, ThirdPartyAccountEntity.class, WhereBuilder.b("rid", "=", userEntity.getId()), "type", "account", "isGrant", "grantCode");
	}

	/**
	 * 根据用户得到用户资料
	 */
	public UserProfileModel selectData(long userId) {
		UserProfileModel model = new UserProfileModel();
		User user = new User();
		ThirdPartyAccount thirdPartyAccount = new ThirdPartyAccount();
		DBUtil.copyData(UserEntity.class, User.class, DBUtil.getDataFirst(UserEntity.class, "id = " + userId), user);
		DBUtil.copyData(ThirdPartyAccountEntity.class, ThirdPartyAccount.class, DBUtil.getDataFirst(ThirdPartyAccountEntity.class, "rid = " + userId), thirdPartyAccount);
		model.thirdPartyAccount = thirdPartyAccount;
		model.user = user;
		return model;
	}
}
