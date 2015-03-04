package com.android.tonight8.storage.org;

import java.util.ArrayList;
import java.util.List;

import com.android.tonight8.model.common.Bind;
import com.android.tonight8.model.common.BindTree;
import com.android.tonight8.model.common.Org;
import com.android.tonight8.model.organization.OrgNodeModel;
import com.android.tonight8.storage.DBUtil;
import com.android.tonight8.storage.entity.BindEntity;
import com.android.tonight8.storage.entity.BindTreeEntity;
import com.android.tonight8.storage.entity.OrgEntity;

/**
 * @Description:商家经销商列表
 * @author:LiuZhao
 * @Date:2015年2月2日
 */
public class OrgNodesNativeController {

	/**
	 * @Description:商家经销商列表
	 * @param modle
	 * @author: LiuZhao
	 * @date:2015年2月2日
	 */

	public void saveOrUpdateData(List<OrgNodeModel> listmodel) {

		List<OrgEntity> orgEntities = new ArrayList<OrgEntity>();
		List<BindEntity> bindEntities = new ArrayList<BindEntity>();
		List<BindTreeEntity> bindTreeEntities = new ArrayList<BindTreeEntity>();
		for (int i = 0; i < listmodel.size(); i++) {
			OrgEntity orgEntity = new OrgEntity();
			DBUtil.copyData(Org.class, OrgEntity.class, listmodel.get(i).org, orgEntity);
			orgEntities.add(orgEntity);

			BindEntity bindEntity = new BindEntity();
			DBUtil.copyData(Bind.class, BindEntity.class, listmodel.get(i).bind, bindEntity);
			bindEntities.add(bindEntity);

			BindTreeEntity bindTreeEntity = new BindTreeEntity();
			DBUtil.copyData(BindTree.class, BindTreeEntity.class, listmodel.get(i).bindTree, bindTreeEntity);
			bindTreeEntities.add(bindTreeEntity);
		}
		DBUtil.saveOrUpdateAll(orgEntities, OrgEntity.class, "name", "logo", "provinceCode", "cityCode", "areaCode", "address");
		DBUtil.saveOrUpdateAll(bindEntities, BindEntity.class, "date", "status");
		DBUtil.saveOrUpdateAll(bindTreeEntities, BindTreeEntity.class, "asTerminal", "orgTree");
	}

	/**
	 * @Description:商家经销商列表
	 * @param modle
	 * @author: LiuZhao
	 * @date:2015年2月2日
	 */

	public List<OrgNodeModel> selectData(String orgId) {
		List<OrgNodeModel> list = new ArrayList<OrgNodeModel>();
		List<BindEntity> bindEntities = DBUtil.getData(BindEntity.class, " rid = " + orgId);
		if (list != null) {
			for (int i = 0; i < list.size(); i++) {
				OrgNodeModel orgNodeModel = new OrgNodeModel();
				DBUtil.copyData(BindEntity.class, Bind.class, bindEntities.get(i), orgNodeModel.bind);
				DBUtil.copyData(OrgEntity.class, Org.class, bindEntities.get(i).org, orgNodeModel.org);
				DBUtil.copyData(BindTreeEntity.class, BindTree.class, DBUtil.getDataFirst(BindTreeEntity.class, " childId = " + orgId), orgNodeModel.bindTree);
				list.add(orgNodeModel);
			}
		}
		return list;
	}
}
