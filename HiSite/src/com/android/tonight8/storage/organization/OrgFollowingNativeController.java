package com.android.tonight8.storage.organization;

import com.android.tonight8.model.common.Follow;
import com.android.tonight8.storage.DBUtil;
import com.android.tonight8.storage.entity.FollowEntity;

/**
 * @author liuzhao 商家关注与取消
 */
public class OrgFollowingNativeController {

	/**
	 * @Description:关注商家
	 * @param listModel
	 * @date:2015年1月22日
	 */
	public void SaveOrUpdateData(Follow model) {
		FollowEntity followEntity = new FollowEntity();
		DBUtil.copyData(Follow.class, FollowEntity.class, model, followEntity);
		DBUtil.saveOrUpdate(followEntity,FollowEntity.class,"rid","oid");
	}

	/**
	 * @Description:取消关注
	 * @param listModel
	 * @date:2015年1月22日
	 */
	public void DeleteData(String id) {
		DBUtil.deleteData(FollowEntity.class, id);
	}
}