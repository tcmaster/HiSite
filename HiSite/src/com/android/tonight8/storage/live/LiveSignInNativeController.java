package com.android.tonight8.storage.live;

import com.android.tonight8.model.common.SignIn;
import com.android.tonight8.model.common.User;
import com.android.tonight8.storage.DBUtil;
import com.android.tonight8.storage.entity.SignInEntity;
import com.android.tonight8.storage.entity.UserEntity;

/**
 * @Description:现场签到数据存储
 * @author:LiuZhao
 * @Date:2015年1月23日
 */
public class LiveSignInNativeController {

	/**
	 * @Description:插入现场签到数据
	 * @param listModel
	 * @date:2015年1月22日
	 */
	public void InsertData(SignIn listModel) {

		SignInEntity signInEntity = new SignInEntity();
		DBUtil.copyData(SignIn.class, SignInEntity.class, listModel,
				signInEntity);
		// 存到数据库中
		DBUtil.saveOrUpdate(signInEntity);

	}

	/**
	 * @param userid
	 * @param subjectid
	 * @return 查询数据
	 */
	public SignIn SelectData(String userid, String eventid) {
		SignIn signIn = new SignIn();
		SignInEntity signInEntity = DBUtil.getDataFirst(SignInEntity.class,
				"rid = " + userid + " and " + "eid = " + eventid);
		UserEntity userEntity = DBUtil.getDataFirst(UserEntity.class, "rid = "
				+ userid);
		DBUtil.copyData(SignInEntity.class, SignIn.class, signInEntity, signIn);
		DBUtil.copyData(UserEntity.class, User.class, userEntity, signIn.user);
		return signIn;

	}
}
