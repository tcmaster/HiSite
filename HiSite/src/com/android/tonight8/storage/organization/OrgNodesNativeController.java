package com.android.tonight8.storage.organization;

import java.util.ArrayList;
import java.util.List;

import com.android.tonight8.model.common.Bind;
import com.android.tonight8.model.common.Org;
import com.android.tonight8.model.organization.OrgNodeModel;
import com.android.tonight8.storage.DBUtil;
import com.android.tonight8.storage.entity.BindEntity;
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

	public List<OrgNodeModel> selectData(String orgId) {
		List<OrgNodeModel> list = new ArrayList<OrgNodeModel>();
		List<BindEntity> listEntity = DBUtil.getData(BindEntity.class, " rid = " + orgId);
		if (list != null) {
			for (int i = 0; i < list.size(); i++) {
				OrgNodeModel orgNodeModel = new OrgNodeModel();
				DBUtil.copyData(BindEntity.class, Bind.class, listEntity.get(i), orgNodeModel.bind);
				DBUtil.copyData(OrgEntity.class, Org.class, listEntity.get(i).org, orgNodeModel.org);
				list.add(orgNodeModel);
			}
		}
		return list;
	}
}
