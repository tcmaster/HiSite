package com.android.tonight8.storage.org;

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
	public void saveOrUpdateData(List<OrgQuestionModel> listModel, int orgId, long uid, long oid) {
		List<QuestionEntity> questionlist = new ArrayList<QuestionEntity>();
		List<UserEntity> userlist = new ArrayList<UserEntity>();
		List<OrgEntity> orglist = new ArrayList<OrgEntity>();
		for (int i = 0; i < listModel.size(); i++) {
			QuestionEntity questionEntity = new QuestionEntity();
			questionEntity.setOrgId(orgId);
			questionEntity.user = userlist.get(i);
			questionEntity.org = orglist.get(i);
			DBUtil.copyData(Question.class, QuestionEntity.class, listModel.get(i).question, questionEntity);
			questionlist.add(questionEntity);

//			if (listModel.get(i).user == null) {
//				UserEntity userEntity = new UserEntity();
//				DBUtil.copyData(User.class, UserEntity.class, listModel.get(i).user, userEntity);
//				userlist.add(userEntity);
//
//			}
//			if (listModel.get(i).org == null) {
//				OrgEntity orgEntity = new OrgEntity();
//				DBUtil.copyData(Org.class, OrgEntity.class, listModel.get(i).org, orgEntity);
//				orglist.add(orgEntity);
//
//			}

		}
		// 存到数据库中
		DBUtil.saveOrUpdateAll(questionlist, QuestionEntity.class);
//		if (userlist != null && userlist.size() != 0) {
//			DBUtil.saveOrUpdateAll(userlist, UserEntity.class, "name", "pic");
//		}
//		if (orglist != null && orglist.size() != 0) {
//			DBUtil.saveOrUpdateAll(orglist, OrgEntity.class, "name", "pic");
//		}

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
	public List<OrgQuestionModel> selectData(int orgId, int toId, int limit, int offset) {
		List<OrgQuestionModel> lisModels = new ArrayList<OrgQuestionModel>();
		List<QuestionEntity> listQuestionEntities;
		listQuestionEntities = DBUtil.getData(QuestionEntity.class, " orgId = " + orgId + " toId = " + toId + " limit " + limit + " offset " + offset + " order by date,time desc");

		if (listQuestionEntities != null) {
			for (int j = 0; j < listQuestionEntities.size(); j++) {
				OrgQuestionModel model = new OrgQuestionModel();
				Question question = new Question();
				DBUtil.copyData(QuestionEntity.class, Question.class, listQuestionEntities.get(j), question);
				model.setQuestion(question);

				User user = new User();
				if (listQuestionEntities.get(j).user != null) {
					DBUtil.copyData(UserEntity.class, User.class, listQuestionEntities.get(j).user, user);
					model.setUser(user);
				}

				if (listQuestionEntities.get(j).org != null) {
					Org org = new Org();
					DBUtil.copyData(OrgEntity.class, Org.class, listQuestionEntities.get(j).org, org);
					model.setOrg(org);
				}
			}

		}

		return lisModels;
	}
}
