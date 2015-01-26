package com.android.tonight8.model.user;

import com.android.tonight8.model.BaseModel;
import com.android.tonight8.model.common.Follow;
import com.android.tonight8.model.common.Org;
import com.android.tonight8.model.common.Question;

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
	/** 问题 */
	public Question question;

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

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	@Override
	public String toString() {
		return "UserFollowModel [follow=" + follow + ", org=" + org + ", question=" + question + "]";
	}

}
