package com.android.tonight8.storage.entity;

import com.lidroid.xutils.db.annotation.Column;
import com.lidroid.xutils.db.annotation.Foreign;
import com.lidroid.xutils.db.annotation.Table;

/**
 * @author liuzhao
 * @date 2015-1-17 问题询问
 */
@Table(name = "question")
public class QuestionEntity extends BaseEntity {
	/** 登录的商家Id */
	@Column(column = "orgId")
	private int orgId;
	/** 询问内容 */
	@Column(column = "content")
	private String content;
	/** 询问日期 */
	@Column(column = "date")
	private String date;
	/** 询问时间 */
	@Column(column = "time")
	private String time;
	/** 是否是回复记录 */
	@Column(column = "toId", defaultValue = "0")
	private int toId;
	/** 用户表外键 */
	@Foreign(column = "uid", foreign = "id")
	public UserEntity user;
	/** 商家表外键 */
	@Foreign(column = "oid", foreign = "id")
	public OrgEntity org;


	
	public int getOrgId() {
		return orgId;
	}

	
	public void setOrgId(int orgId) {
		this.orgId = orgId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public int getToId() {
		return toId;
	}

	public void setToId(int toId) {
		this.toId = toId;
	}


}
