package com.android.tonight8.model.event;

import com.android.tonight8.model.BaseModel;
import com.android.tonight8.model.common.Consult;
import com.android.tonight8.model.common.User;

/**
 * 活动咨询
 * 
 * @author LiXiaoSong
 * 
 */
public class EventConsultModel extends BaseModel {
	private static final long serialVersionUID = 1L;
	/** 咨询 */
	public Consult consult;
	/** 用户 */
	public User user;

	public Consult getConsult() {
		return consult;
	}

	public void setConsult(Consult consult) {
		this.consult = consult;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "EventConsultModel [consult=" + consult + ", user=" + user + "]";
	}

}
