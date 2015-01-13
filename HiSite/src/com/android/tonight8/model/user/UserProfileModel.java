package com.android.tonight8.model.user;

import com.android.tonight8.model.BaseModel;
import com.android.tonight8.model.common.ThirdPartyAccount;
import com.android.tonight8.model.common.User;

/**
 * @author liuzhao
 * 用户资料
 */
public class UserProfileModel extends BaseModel {
	private static final long serialVersionUID = 1L;
	/** 用户对象*/
	public User user;
	/** 第三方账号*/
	public ThirdPartyAccount thirdPartyAccount;
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public ThirdPartyAccount getThirdPartyAccount() {
		return thirdPartyAccount;
	}
	public void setThirdPartyAccount(ThirdPartyAccount thirdPartyAccount) {
		this.thirdPartyAccount = thirdPartyAccount;
	}
}
