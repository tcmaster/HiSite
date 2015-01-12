package com.android.tonight8.model.manageevent;

import com.android.tonight8.model.BaseModel;
import com.android.tonight8.model.common.Award;
import com.android.tonight8.model.common.User;

/**
 * 中奖名单管理
 */
public class ManageAwardModel extends BaseModel {

	private static final long serialVersionUID = 1L;
	/** 中奖*/
	public Award award;
	/** 对象*/
	public User user;

	public Award getAward() {
		return award;
	}

	public void setAward(Award award) {
		this.award = award;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
