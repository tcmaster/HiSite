package com.android.tonight8.storage.organization;

import com.android.tonight8.model.common.Org;
import com.android.tonight8.model.common.Regional;
import com.android.tonight8.model.common.ThirdPartyAccount;
import com.android.tonight8.model.organization.OrgProfileModel;
import com.android.tonight8.storage.DBUtil;
import com.android.tonight8.storage.entity.OrgEntity;
import com.android.tonight8.storage.entity.RegionalEntity;
import com.android.tonight8.storage.entity.ThirdPartyAccountEntity;

public class OrgProfileNativeController {
	/**
	 * 存储/更新商家资料
	 */
	public void insertOrUpdateData(OrgProfileModel model) {
		ThirdPartyAccountEntity thirdPartyAccountEntity = new ThirdPartyAccountEntity();
		OrgEntity orgEntity = new OrgEntity();
		RegionalEntity province = new RegionalEntity();
		RegionalEntity city = new RegionalEntity();
		RegionalEntity area = new RegionalEntity();
		DBUtil.copyData(ThirdPartyAccount.class, ThirdPartyAccountEntity.class,
				model.thirdPartyAccount, thirdPartyAccountEntity);
		DBUtil.copyData(Org.class, OrgEntity.class, model.org, orgEntity);
		DBUtil.copyData(Regional.class, RegionalEntity.class, model.province,
				province);
		DBUtil.copyData(Regional.class, RegionalEntity.class, model.city, city);
		DBUtil.copyData(Regional.class, RegionalEntity.class, model.area, area);
		DBUtil.saveOrUpdate(orgEntity);
		DBUtil.saveOrUpdate(thirdPartyAccountEntity);
		DBUtil.saveOrUpdate(province);
		DBUtil.saveOrUpdate(city);
		DBUtil.saveOrUpdate(area);
	}

	/**
	 * 删除商家资料
	 */
	public OrgProfileModel selectData(String orgId) {
		OrgProfileModel orgModel = new OrgProfileModel();
		ThirdPartyAccount thirdPartyAccount = new ThirdPartyAccount();
		Org org = new Org();
		Regional province = new Regional();
		Regional city = new Regional();
		Regional area = new Regional();

		DBUtil.copyData(OrgEntity.class, Org.class,
				DBUtil.getDataFirst(OrgEntity.class, "id = " + orgId), org);
		// DBUtil.copyData(
		// ThirdPartyAccountEntity.class,
		// ThirdPartyAccount.class,
		// DBUtil.getDataFirst(ThirdPartyAccountEntity.class, "rid = "
		// + orgId), thirdPartyAccount);
		// DBUtil.copyData(
		// RegionalEntity.class,
		// Regional.class,
		// DBUtil.getDataFirst(RegionalEntity.class, "rid = "
		// + orgId), province);
		// DBUtil.copyData(
		// ThirdPartyAccountEntity.class,
		// ThirdPartyAccount.class,
		// DBUtil.getDataFirst(ThirdPartyAccountEntity.class, "rid = "
		// + orgId), thirdPartyAccount);
		orgModel.thirdPartyAccount = thirdPartyAccount;
		orgModel.org = org;
		orgModel.province = province;
		orgModel.city = city;
		orgModel.area = area;
		return orgModel;
	}
}
