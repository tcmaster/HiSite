package com.android.tonight8.storage.user;

import java.util.ArrayList;
import java.util.List;

import com.android.tonight8.model.common.Org;
import com.android.tonight8.model.common.Question;
import com.android.tonight8.model.common.User;
import com.android.tonight8.model.user.UserQuestionModel;
import com.android.tonight8.storage.DBUtil;
import com.android.tonight8.storage.entity.OrgEntity;
import com.android.tonight8.storage.entity.QuestionEntity;
import com.android.tonight8.storage.entity.UserEntity;

/**
 * 
 * @Descripton 用户询问本地存储控制类
 * @author LiXiaoSong
 * @2015-1-24
 * @Tonight8
 */
public class UserQuestionsNativeController {

	/**
	 * 存储用户询问列表数据
	 * 
	 * @param models
	 */
	public void insertData(List<UserQuestionModel> models) {
		List<QuestionEntity> questionEntities = new ArrayList<QuestionEntity>();
		List<UserEntity> userEntities = new ArrayList<UserEntity>();
		List<OrgEntity> orgEntities = new ArrayList<OrgEntity>();
		for (int i = 0; i < models.size(); i++) {
			QuestionEntity questionEntity = new QuestionEntity();
			UserEntity userEntity = new UserEntity();
			OrgEntity orgEntity = new OrgEntity();
			DBUtil.copyData(Question.class, QuestionEntity.class, models.get(i).question, questionEntity);
			DBUtil.copyData(User.class, UserEntity.class, models.get(i).user, userEntity);
			DBUtil.copyData(Org.class, OrgEntity.class, models.get(i).org, orgEntity);
			questionEntity.user = userEntity;
			questionEntity.org = orgEntity;
			questionEntities.add(questionEntity);
			userEntities.add(userEntity);
			orgEntities.add(orgEntity);
		}
		DBUtil.saveOrUpdateAll(questionEntities);
		DBUtil.saveOrUpdateAll(userEntities);
		DBUtil.saveOrUpdateAll(orgEntities);
	}

	/**
	 * 读取用户存储列表
	 * 
	 * @param userId
	 */
	public List<UserQuestionModel> selectData(long userId) {
		List<UserQuestionModel> models = new ArrayList<UserQuestionModel>();
		List<QuestionEntity> questionEntities = DBUtil.getData(QuestionEntity.class, "uid = " + userId);
		for (int i = 0; i < questionEntities.size(); i++) {
			UserQuestionModel model = new UserQuestionModel();
			Org org = new Org();
			Question question = new Question();
			User user = new User();
			DBUtil.copyData(QuestionEntity.class, Question.class, questionEntities.get(i), question);
			DBUtil.copyData(OrgEntity.class, Org.class, questionEntities.get(i).org, org);
			DBUtil.copyData(UserEntity.class, User.class, questionEntities.get(i).user, user);
			model.question = question;
			model.org = org;
			model.user = user;
			models.add(model);
		}
		return models;
	}

	/**
	 * 写入用户询问数据
	 * 
	 * @date:2015-1-26
	 */
	public void insertData(UserQuestionModel model) {
		QuestionEntity questionEntity = new QuestionEntity();
		UserEntity userEntity = new UserEntity();
		OrgEntity orgEntity = new OrgEntity();
		DBUtil.copyData(Question.class, QuestionEntity.class, model.question, questionEntity);
		DBUtil.copyData(User.class, UserEntity.class, model.user, userEntity);
		DBUtil.copyData(Org.class, OrgEntity.class, model.org, orgEntity);
		questionEntity.user = userEntity;
		questionEntity.org = orgEntity;
		DBUtil.saveOrUpdate(questionEntity);
		DBUtil.saveOrUpdate(userEntity);
		DBUtil.saveOrUpdate(orgEntity);
	}
}
