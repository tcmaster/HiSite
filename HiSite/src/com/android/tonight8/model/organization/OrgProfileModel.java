package com.android.tonight8.model.organization;

import com.android.tonight8.model.BaseModel;
import com.android.tonight8.model.common.Identity;
import com.android.tonight8.model.common.Org;
import com.android.tonight8.model.common.QuickMark;
import com.android.tonight8.model.common.Regional;
import com.android.tonight8.model.common.ThirdPartyAccount;

/**
 * 商家详情
 */
public class OrgProfileModel extends BaseModel {

	private static final long serialVersionUID = 1L;
	/** 商家对象 */
	public Org org;
	/** 省份对象 */
	public Regional province;
	/** 城市对象 */
	public Regional city;
	/** 地区对象 */
	public Regional area;
	/** 二维码对象 */
	public QuickMark quickMark;
	/** 第三方账号对象 */
	public ThirdPartyAccount thirdPartyAccount;
	/** 身份对象 */
	public Identity identity;

	public Org getOrg() {
		return org;
	}

	public void setOrg(Org org) {
		this.org = org;
	}

	public Regional getProvince() {
		return province;
	}

	public void setProvince(Regional province) {
		this.province = province;
	}

	public Regional getCity() {
		return city;
	}

	public void setCity(Regional city) {
		this.city = city;
	}

	public Regional getArea() {
		return area;
	}

	public void setArea(Regional area) {
		this.area = area;
	}

	public QuickMark getQuickMark() {
		return quickMark;
	}

	public void setQuickMark(QuickMark quickMark) {
		this.quickMark = quickMark;
	}

	public Identity getIdentity() {
		return identity;
	}

	public void setIdentity(Identity identity) {
		this.identity = identity;
	}

	public ThirdPartyAccount getThirdPartyAccount() {
		return thirdPartyAccount;
	}

	public void setThirdPartyAccount(ThirdPartyAccount thirdPartyAccount) {
		this.thirdPartyAccount = thirdPartyAccount;
	}

}
