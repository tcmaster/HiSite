package com.android.tonight8.storage.organization;

import com.android.tonight8.model.common.Identity;
import com.android.tonight8.model.common.Org;
import com.android.tonight8.model.common.QuickMark;
import com.android.tonight8.model.common.ThirdPartyAccount;
import com.android.tonight8.model.organization.OrgProfileModel;
import com.android.tonight8.storage.DBUtil;
import com.android.tonight8.storage.entity.OrgEntity;
import com.android.tonight8.storage.entity.QuickMarkEntity;
import com.android.tonight8.storage.entity.ThirdPartyAccountEntity;

/**
 * @author liuzhao
 * 商家资料
 */
public class OrgProfileNativeController {
	/**
	 * 存储/更新商家资料
	 */
	public void saveOrUpdateData(OrgProfileModel model) {
		ThirdPartyAccountEntity thirdPartyAccountEntity = new ThirdPartyAccountEntity();
		OrgEntity orgEntity = new OrgEntity();
		QuickMarkEntity quickMarkEntity = new QuickMarkEntity();

		DBUtil.copyData(ThirdPartyAccount.class, ThirdPartyAccountEntity.class,
				model.thirdPartyAccount, thirdPartyAccountEntity);
		DBUtil.copyData(Org.class, OrgEntity.class, model.org, orgEntity);
		DBUtil.copyData(QuickMark.class, QuickMarkEntity.class,
				model.quickMark, quickMarkEntity);

		orgEntity.setIdentityType(model.identity.type);
		orgEntity.setIdentityCode(model.identity.code);

		DBUtil.saveOrUpdate(orgEntity, OrgEntity.class, "name", "description",
				"logo", "provinceCode", "cityCode", "areaCode", "address",
				"contactPerson", "contactMobilePhone", "telephone", "email",
				"paperCode", "identityType", "identityCode");
		DBUtil.saveOrUpdate(thirdPartyAccountEntity,
				ThirdPartyAccountEntity.class, "type", "account", "url");
		DBUtil.saveOrUpdate(quickMarkEntity, QuickMarkEntity.class, "code",
				"photo");

	}

	/**
	 * 查询商家资料
	 */
	public OrgProfileModel selectData(String orgId) {
		OrgProfileModel orgModel = new OrgProfileModel();
		ThirdPartyAccount thirdPartyAccount = new ThirdPartyAccount();

		Org org = new Org();
		OrgEntity orgEntity = DBUtil.getDataFirst(OrgEntity.class, "id = "
				+ orgId);
		DBUtil.copyData(OrgEntity.class, Org.class, orgEntity, org);
		DBUtil.copyData(
				ThirdPartyAccountEntity.class,
				ThirdPartyAccount.class,
				DBUtil.getDataFirst(ThirdPartyAccountEntity.class, "rid = "
						+ orgId), thirdPartyAccount);

		QuickMark quickMark = new QuickMark();
		DBUtil.copyData(QuickMarkEntity.class, QuickMark.class,
				DBUtil.getDataFirst(QuickMarkEntity.class, "oid = " + orgId),
				quickMark);

		Identity identity = new Identity();
		identity.code = orgEntity.getIdentityCode();
		identity.type = orgEntity.getIdentityType();

		orgModel.thirdPartyAccount = thirdPartyAccount;
		orgModel.org = org;
		orgModel.quickMark = quickMark;
		return orgModel;
	}
}
