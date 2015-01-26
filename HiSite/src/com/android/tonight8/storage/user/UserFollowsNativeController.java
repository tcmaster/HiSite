/**
 * 2015-1-26
 */
package com.android.tonight8.storage.user;

import java.util.ArrayList;
import java.util.List;

import com.android.tonight8.model.common.Follow;
import com.android.tonight8.model.common.Org;
import com.android.tonight8.model.common.Question;
import com.android.tonight8.model.user.UserFollowModel;
import com.android.tonight8.storage.DBUtil;
import com.android.tonight8.storage.entity.FollowEntity;
import com.android.tonight8.storage.entity.OrgEntity;
import com.android.tonight8.storage.entity.QuestionEntity;
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
		List<QuestionEntity> questionEntities = new ArrayList<QuestionEntity>();
		List<UserEntity> userEntities = new ArrayList<UserEntity>();
		for (int i = 0; i < models.size(); i++) {
			UserFollowModel model = models.get(i);
			FollowEntity followEntity = new FollowEntity();
			OrgEntity orgEntity = new OrgEntity();
			UserEntity userEntity = new UserEntity();
			QuestionEntity questionEntity = new QuestionEntity();
			DBUtil.copyData(Follow.class, FollowEntity.class, model.follow, followEntity);
			DBUtil.copyData(Question.class, QuestionEntity.class, model.question, questionEntity);
			DBUtil.copyData(Org.class, OrgEntity.class, model.org, orgEntity);
			// DBUtil.copyData(User.class, UserEntity.class,, t2)
		}
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
		return models;
	}
}
