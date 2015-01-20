package com.android.tonight8.storage.entity;

import com.lidroid.xutils.db.annotation.Column;
import com.lidroid.xutils.db.annotation.Foreign;
import com.lidroid.xutils.db.annotation.NotNull;
import com.lidroid.xutils.db.annotation.Table;

/**
 * 通知
 * 
 * @author liuzhao
 * @date 2015-1-17
 */
@Table(name="notice")
public class NoticeEntity extends EntityBaseEntity {
	/** 通知内容 */
	@NotNull
	@Column(column = "content")
	public String content;
	/** 通知日期 */
	@NotNull
	@Column(column = "date")
	public String date;
	/** 通知时间 */
	@NotNull
	@Column(column = "time")
	public String time;
	/** 商家 */
	@Foreign(column = "rid", foreign = "id")
	private OrgEntity org;

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

	public OrgEntity getOrg() {
		return org;
	}

	public void setOrg(OrgEntity org) {
		this.org = org;
	}

	@Override
	public String toString() {
		return "Notice [content=" + content + ", date=" + date + ", time="
				+ time + ", org=" + org + "]";
	}
	
}
