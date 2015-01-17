package com.android.tonight8.model.live;

import com.android.tonight8.model.BaseModel;
import com.android.tonight8.model.common.Event;
import com.android.tonight8.model.common.SignIn;
import com.android.tonight8.model.common.Org;

/**
 * @author liuzhao
 * 活动现场
 */
public class LiveListModel extends BaseModel {
	/** */
	private static final long serialVersionUID = 1L;
	/** 活动对象*/
	public Event event;
	/** 商家对象*/
	public Org org;
	/** 现场对象*/
	public SignIn live;

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

	public SignIn getLive() {
		return live;
	}

	public void setLive(SignIn live) {
		this.live = live;
	}

}
