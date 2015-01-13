package com.android.tonight8.model.user;

import com.android.tonight8.model.BaseModel;
import com.android.tonight8.model.common.Org;
import com.android.tonight8.model.common.Question;
import com.android.tonight8.model.common.User;

/**
 * @author liuzhao 
 * 用户询问
 */
public class UserQuestionModel extends BaseModel {

	/** */
	private static final long serialVersionUID = 1L;
	/** 问题对象*/
	public Question question;
	/** 用户对象*/
	public User user;
	/** 商家对象*/
	public Org org;

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Org getOrg() {
		return org;
	}

	public void setOrg(Org org) {
		this.org = org;
	}
}
