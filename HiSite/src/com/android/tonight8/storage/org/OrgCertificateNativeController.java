package com.android.tonight8.storage.org;

import com.android.tonight8.model.common.Org;
import com.android.tonight8.storage.DBUtil;
import com.android.tonight8.storage.entity.OrgEntity;

/**
 * @Description:商家认证
 * @author:LiuZhao
 * @Date:2015年2月4日
 */
public class OrgCertificateNativeController {

	/**
	 * @Description:绑定经销商
	 * @param modle
	 * @author: LiuZhao
	 * @date:2015年2月2日
	 */

	public void saveOrUpdateData(Org org) {
		OrgEntity orgEntity = new OrgEntity();
		DBUtil.copyData(Org.class, OrgEntity.class, org, orgEntity);
		// 存到数据库中
		DBUtil.saveOrUpdate(orgEntity, OrgEntity.class, "identityType", "name", "provinceCode", "cityCode", "areaCode", "address", "contactPerson", "contactMobilPhone", "email", "paperPhoto", "identityPhotoFront", "identityPhotoReverse");
	}
}
