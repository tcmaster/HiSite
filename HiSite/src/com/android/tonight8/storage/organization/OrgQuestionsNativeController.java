package com.android.tonight8.storage.organization;

import java.util.ArrayList;
import java.util.List;

import com.android.tonight8.model.common.Org;
import com.android.tonight8.model.common.Question;
import com.android.tonight8.model.common.User;
import com.android.tonight8.model.organization.OrgQuestionModel;
import com.android.tonight8.storage.DBUtil;
import com.android.tonight8.storage.entity.OrgEntity;
import com.android.tonight8.storage.entity.QuestionEntity;
import com.android.tonight8.storage.entity.UserEntity;

/**
 * @author liuzhao 商家询问列表
 */
public class OrgQuestionsNativeController {
	/**
	 * @Description:插入数据
	 * @param listModel
	 * @date:2015年1月22日
	 */
	public void SaveOrUpdateData(List<OrgQuestionModel> listModel) {
		List<QuestionEntity> questionlist = new ArrayList<QuestionEntity>();
		List<UserEntity> userlist = new ArrayList<UserEntity>();
		List<OrgEntity> orglist = new ArrayList<OrgEntity>();
		for (int i = 0; i < listModel.size(); i++) {
			QuestionEntity questionEntity = new QuestionEntity();
			DBUtil.copyData(Question.class, QuestionEntity.class,
					listModel.get(i).question, questionEntity);
			questionlist.add(questionEntity);

			UserEntity userEntity = new UserEntity();
			DBUtil.copyData(User.class, UserEntity.class,
					listModel.get(i).user, userEntity);
			userlist.add(userEntity);

			OrgEntity orgEntity = new OrgEntity();
			DBUtil.copyData(Org.class, OrgEntity.class, listModel.get(i).org,
					orgEntity);
			orglist.add(orgEntity);
		}
		// 存到数据库中
		DBUtil.saveOrUpdateAll(questionlist, QuestionEntity.class);
		DBUtil.saveOrUpdateAll(userlist, UserEntity.class, "name", "pic");
		DBUtil.saveOrUpdateAll(orglist, OrgEntity.class, "name", "pic");
	}

	/**
	 * 查询数据
	 * 
	 * @param isReply问题回复状态
	 * @param limit
	 *            限制条数
	 * @param offset
	 *            跳过几条
	 * @return
	 */
	public List<OrgQuestionModel> SelectData(Boolean isReply, String limit,
			String offset) {
		List<OrgQuestionModel> lisModels = new ArrayList<OrgQuestionModel>();

		// 在question.isReply请求参数值为假，则查看最近10条未回复用户的询问内容，为真则查看已回复的询问记录
		List<QuestionEntity> listQuestionEntities = DBUtil.getData(
				QuestionEntity.class, " isReply = " + isReply + "limit "
						+ limit + " offset " + offset
						+ " order by date,time desc");
		if (listQuestionEntities != null) {
			for (int j = 0; j < listQuestionEntities.size(); j++) {
				OrgQuestionModel model = new OrgQuestionModel();
				Question question = new Question();
				DBUtil.copyData(QuestionEntity.class, Question.class,
						listQuestionEntities.get(j), question);
				model.setQuestion(question);

				User user = new User();
				DBUtil.copyData(UserEntity.class, User.class,
						listQuestionEntities.get(j).user, user);
				model.setUser(user);

				Org org = new Org();
				DBUtil.copyData(OrgEntity.class, Org.class,
						listQuestionEntities.get(j).org, org);
				model.setOrg(org);
			}

		}

		return lisModels;
	}
}
