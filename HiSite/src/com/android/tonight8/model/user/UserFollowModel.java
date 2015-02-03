package com.android.tonight8.model.user;

import com.android.tonight8.model.BaseModel;
import com.android.tonight8.model.common.Follow;
import com.android.tonight8.model.common.Org;

/**
 * @author liuzhao 用户关注的商家
 */
public class UserFollowModel extends BaseModel {

	/** */
	private static final long serialVersionUID = 1L;
	/** 关注对象 */
	public Follow follow;
	/** 商家对象 */
	public Org org;

	public Follow getFollow() {
		return follow;
	}

	public void setFollow(Follow follow) {
		this.follow = follow;
	}

	public Org getOrg() {
		return org;
	}

	public void setOrg(Org org) {
		this.org = org;
	}

	@Override
	public String toString() {
		return "UserFollowModel [follow=" + follow + ", org=" + org + "]";
	}

}
