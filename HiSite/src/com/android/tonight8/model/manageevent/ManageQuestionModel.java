package com.android.tonight8.model.manageevent;

import com.android.tonight8.model.BaseModel;
import com.android.tonight8.model.common.Org;
import com.android.tonight8.model.common.Question;

public class ManageQuestionModel extends BaseModel {
	private static final long serialVersionUID = 1L;
	/** 询问对象*/
	public Question question;
	/** 商家对象*/
	public Org org;

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public Org getOrg() {
		return org;
	}

	public void setOrg(Org org) {
		this.org = org;
	}

}
