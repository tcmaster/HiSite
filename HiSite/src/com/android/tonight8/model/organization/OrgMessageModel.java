package com.android.tonight8.model.organization;

import com.android.tonight8.model.BaseModel;
import com.android.tonight8.model.common.Message;
import com.android.tonight8.model.common.Org;
import com.android.tonight8.model.common.User;

/**
 * @Description:商家消息列表
 * @author:LiuZhao
 * @Date:2015年3月4日
 */
public class OrgMessageModel extends BaseModel {

	/** */
	private static final long serialVersionUID = 1L;
	/** 商家消息 */
	public Message message;
	/** 商家信息 */
	public Org org;
	/** 用户信息 */
	public User user;

	public Message getMessage() {
		return message;
	}

	public void setMessage(Message message) {
		this.message = message;
	}

	public Org getOrg() {
		return org;
	}

	public void setOrg(Org org) {
		this.org = org;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
