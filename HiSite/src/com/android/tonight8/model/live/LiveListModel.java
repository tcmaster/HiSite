package com.android.tonight8.model.live;

import java.util.ArrayList;
import java.util.List;

import com.android.tonight8.model.BaseModel;
import com.android.tonight8.model.common.Event;
import com.android.tonight8.model.common.SignIn;
import com.android.tonight8.model.common.Org;
import com.android.tonight8.model.common.User;

/**
 * @author liuzhao 活动现场列表的实体
 */
public class LiveListModel extends BaseModel {
	/** */
	private static final long serialVersionUID = 1L;
	/** 活动对象 */
	public Event event;
	/** 商家对象 */
	public Org org;
	/** 签到对象 */
	public List<SignIn> signIn = new ArrayList<SignIn>();
	/** 用户对象 */
	public User user;

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	public Org getOrg() {
		return org;
	}

	public void setOrg(Org org) {
		this.org = org;
	}

	public List<SignIn> getSignIn() {
		return signIn;
	}

	public void setSignIn(List<SignIn> signIn) {
		this.signIn = signIn;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}


}
