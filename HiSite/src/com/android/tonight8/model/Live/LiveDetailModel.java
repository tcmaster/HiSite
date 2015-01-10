package com.android.tonight8.model.Live;

import com.android.tonight8.model.BaseModel;
import com.android.tonight8.model.common.Event;
import com.android.tonight8.model.common.Org;

/**
 * @author liuzhao 活动现场详情
 */
public class LiveDetailModel extends BaseModel {
	/** */
	private static final long serialVersionUID = 1L;
	/** 活动对象 */
	public Event event;
	/** 商家对象 */
	public Org org;

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

}
