package com.android.tonight8.storage.live;

import com.android.tonight8.model.common.SignIn;
import com.android.tonight8.storage.DBUtil;
import com.android.tonight8.storage.entity.SignInEntity;

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
		DBUtil.copyData(SignIn.class, SignInEntity.class, listModel, signInEntity);
		// 存到数据库中
		DBUtil.saveOrUpdate(signInEntity);

	}

}
