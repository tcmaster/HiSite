package com.android.tonight8.io.org.entity;

import java.util.ArrayList;

import com.android.tonight8.model.organization.OrgMessageModel;

/**
 * @Description:接口返回商家消息列表
 * @author:LiuZhao
 * @Date:2015年3月5日
 */
public class OrgMessageNetEntity {

	public ArrayList<OrgMessageModel> org_messages;

	public ArrayList<OrgMessageModel> getOrg_messages() {
		return org_messages;
	}

	public void setOrg_messages(ArrayList<OrgMessageModel> org_messages) {
		this.org_messages = org_messages;
	}

}
