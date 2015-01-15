package com.android.tonight8.model.user;

import com.android.tonight8.model.BaseModel;
import com.android.tonight8.model.common.Award;
import com.android.tonight8.model.common.Event;

/**
 * @author liuzhao
 * 用户中奖码
 */
public class UserAwardModel extends BaseModel {

	private static final long serialVersionUID = 1L;
	/** 中奖对象*/
	public Award award;
	/** 活动对象*/
	public Event event;

	public Award getAward() {
		return award;
	}

	public void setAward(Award award) {
		this.award = award;
	}

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

}
