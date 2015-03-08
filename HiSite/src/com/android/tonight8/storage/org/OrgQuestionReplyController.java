package com.android.tonight8.storage.org;

import com.android.tonight8.model.common.Question;
import com.android.tonight8.storage.DBUtil;
import com.android.tonight8.storage.entity.ConsultEntity;
import com.android.tonight8.storage.entity.QuestionEntity;

/**
 * @author liuzhao 商家询问回复录入
 */
public class OrgQuestionReplyController {
	/**
	 * @Description:插入数据
	 * @param listModel
	 * @date:2015年1月22日
	 */
	public void saveOrUpdateData(Question model) {
		QuestionEntity questionEntity = new QuestionEntity();
		DBUtil.copyData(Question.class, QuestionEntity.class, model,
				questionEntity);
		DBUtil.saveOrUpdate(questionEntity, ConsultEntity.class, "oid",
				"content", "toId");
	}

	// /**
	// * @Description:查询数据
	// * @param listModel
	// * @date:2015年1月22日
	// */
	// public Question selectData(String id) {
	// Question question = new Question();
	// QuestionEntity questionEntity = DBUtil.getDataFirst(
	// QuestionEntity.class, " id = " + id);
	// DBUtil.copyData(QuestionEntity.class, Question.class, questionEntity,
	// question);
	// return question;
	// }
}
