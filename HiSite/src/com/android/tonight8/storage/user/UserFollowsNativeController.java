/**
 * 2015-1-26
 */
package com.android.tonight8.storage.user;

import java.util.ArrayList;
import java.util.List;

import com.android.tonight8.model.common.Follow;
import com.android.tonight8.model.common.Org;
import com.android.tonight8.model.user.UserFollowModel;
import com.android.tonight8.storage.DBUtil;
import com.android.tonight8.storage.entity.FollowEntity;
import com.android.tonight8.storage.entity.OrgEntity;
import com.android.tonight8.storage.entity.UserEntity;

/**
 * @Description:用户关注列表本地存储控制类
 * @author:LiXiaoSong
 * @copyright @HiSite
 * @Date:2015-1-26
 */
public class UserFollowsNativeController {

	/**
	 * @Description:存储关注列表
	 * @param models
	 * @author: LiXiaoSong
	 * @date:2015-1-26
	 */
	public void insertData(List<UserFollowModel> models) {
		List<FollowEntity> followEntities = new ArrayList<FollowEntity>();
		List<OrgEntity> orgEntities = new ArrayList<OrgEntity>();
		for (int i = 0; i < models.size(); i++) {
			UserFollowModel model = models.get(i);
			FollowEntity followEntity = new FollowEntity();
			OrgEntity orgEntity = new OrgEntity();
			DBUtil.copyData(Follow.class, FollowEntity.class, model.follow, followEntity);
			DBUtil.copyData(Org.class, OrgEntity.class, model.org, orgEntity);
			followEntity.org = orgEntity;
			followEntity.user = DBUtil.getDataFirst(UserEntity.class, "id = " + model.follow.rid);
			followEntities.add(followEntity);
			orgEntities.add(orgEntity);
		}
		DBUtil.saveOrUpdateAll(followEntities, FollowEntity.class, "oid", "rid");
		DBUtil.saveOrUpdateAll(orgEntities, OrgEntity.class, "name", "distance", "provinceCode", "cityCode", "areaCode", "address", "telphone");
	}

	/**
	 * @Description: 根据用户关系取出关注列表
	 * @param userId
	 * @return
	 * @author: LiXiaoSong
	 * @date:2015-1-26
	 */
	public List<UserFollowModel> selectData(long userId) {
		List<UserFollowModel> models = new ArrayList<UserFollowModel>();
		List<FollowEntity> followEntities = DBUtil.getData(FollowEntity.class, "rid = " + userId);
		for (int i = 0; i < followEntities.size(); i++) {
			UserFollowModel model = new UserFollowModel();
			FollowEntity followEntity = followEntities.get(i);
			OrgEntity orgEntity = followEntity.org;
			Follow follow = new Follow();
			Org org = new Org();
			DBUtil.copyData(FollowEntity.class, Follow.class, followEntity, follow);
			DBUtil.copyData(OrgEntity.class, Org.class, orgEntity, org);
			follow.oid = org.getId();
			follow.rid = (int) userId;
			model.follow = follow;
			model.org = org;
			models.add(model);
		}
		return models;
	}
}
