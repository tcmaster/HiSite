package com.android.tonight8.storage.organization;

import com.android.tonight8.model.common.Bind;
import com.android.tonight8.model.common.BindTree;
import com.android.tonight8.model.organization.OrgNodeModel;
import com.android.tonight8.storage.DBUtil;
import com.android.tonight8.storage.entity.BindEntity;
import com.android.tonight8.storage.entity.BindTreeEntity;

/**
 * @Description:商家经销商绑定
 * @author:LiuZhao
 * @Date:2015年2月2日
 */
public class OrgNodeNativeController {

	/**
	 * @Description:绑定经销商 Or解除绑定
	 * @param modle
	 * @author: LiuZhao
	 * @date:2015年2月2日
	 */

	public void saveOrUpdateBindingData(OrgNodeModel modle) {

		BindEntity bindEntity = new BindEntity();
		DBUtil.copyData(Bind.class, BindEntity.class, modle.bind, bindEntity);
		DBUtil.saveOrUpdate(bindEntity, BindEntity.class, "date", "status");

		BindTreeEntity bindTreeEntity = new BindTreeEntity();
		DBUtil.copyData(BindTree.class, BindTreeEntity.class, modle.bindTree,
				bindTreeEntity);
		DBUtil.saveOrUpdate(bindTreeEntity, BindTreeEntity.class, "asTerminal",
				"orgTree");
	}

}
