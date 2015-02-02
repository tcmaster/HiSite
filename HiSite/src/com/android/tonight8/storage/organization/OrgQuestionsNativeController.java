package com.android.tonight8.storage.organization;

import java.util.ArrayList;
import java.util.List;

import com.android.tonight8.model.common.Question;
import com.android.tonight8.storage.DBUtil;
import com.android.tonight8.storage.entity.QuestionEntity;

/**
 * @author liuzhao 商家询问列表
 */
public class OrgQuestionsNativeController {
	/**
	 * @Description:插入数据
	 * @param listModel
	 * @date:2015年1月22日
	 */
	public void SaveOrUpdateData(List<Question> listModel) {
		List<QuestionEntity> list = new ArrayList<QuestionEntity>();
		for (int i = 0; i < listModel.size(); i++) {
			QuestionEntity questionEntity = new QuestionEntity();

			DBUtil.copyData(Question.class, QuestionEntity.class,
					listModel.get(i), questionEntity);
			list.add(questionEntity);
		}
		// 存到数据库中
		DBUtil.saveOrUpdateAll(list);
	}

	/**
	 * @Description:查询数据
	 * @param listModel
	 * @date:2015年1月22日
	 */
	public List<Question> SelectData(String id, String oid) {
		List<Question> list = new ArrayList<Question>();
		List<QuestionEntity> listQuestionEntities = DBUtil.getData(
				QuestionEntity.class, " id = " + id + " and oid = " + oid);
		if (listQuestionEntities != null) {
			for (int j = 0; j < listQuestionEntities.size(); j++) {
				Question question = new Question();
				DBUtil.copyData(QuestionEntity.class, Question.class,
						listQuestionEntities.get(j), question);
				list.add(question);
			}

		}

		return list;
	}
}
