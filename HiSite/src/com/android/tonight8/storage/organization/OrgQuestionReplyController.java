package com.android.tonight8.storage.organization;

import com.android.tonight8.model.common.Consult;
import com.android.tonight8.storage.DBUtil;
import com.android.tonight8.storage.entity.ConsultEntity;

/**
 * @author liuzhao 商家询问回复录入
 */
public class OrgQuestionReplyController {
	/**
	 * @Description:插入数据
	 * @param listModel
	 * @date:2015年1月22日
	 */
	public void SaveOrUpdateData(Consult model) {
		ConsultEntity consultEntity = new ConsultEntity();
		DBUtil.copyData(Consult.class, ConsultEntity.class, model,
				consultEntity);
		DBUtil.saveOrUpdate(consultEntity);
	}

	/**
	 * @Description:查询数据
	 * @param listModel
	 * @date:2015年1月22日
	 */
	public Consult SelectData(String id) {
		Consult consult = new Consult();
		ConsultEntity consultEntity = DBUtil.getDataFirst(ConsultEntity.class,
				" id = " + id);
		DBUtil.copyData(ConsultEntity.class, Consult.class, consultEntity,
				consult);
		return consult;
	}
}
