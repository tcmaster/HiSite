package com.android.tonight8.storage.entity;

import com.lidroid.xutils.db.annotation.Column;
import com.lidroid.xutils.db.annotation.Foreign;
import com.lidroid.xutils.db.annotation.NotNull;
import com.lidroid.xutils.db.annotation.Table;

/**
 * @author liuzhao
 * @date 2015-1-17 问题询问
 */
@Table(name = "question")
public class Question extends EntityBase{
	/** */
	@Foreign(column = "uid", foreign = "id")
	private User user;
	/** */
	@Foreign(column = "oid", foreign = "id")
	private Org org;
	/** 询问内容 */
	@Column(column = "content")
	@NotNull
	public String content;
	/** 询问日期 */
	@Column(column = "date")
	@NotNull
	public String date;
	/** 询问时间 */
	@Column(column = "time")
	@NotNull
	public String time;
	/** 是否是回复记录 */
	@Column(column = "isReply", defaultValue = "0")
	public int isReply;

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

	public int getIsReply() {
		return isReply;
	}

	public void setIsReply(int isReply) {
		this.isReply = isReply;
	}

	@Override
	public String toString() {
		return "Question [user=" + user + ", org=" + org + ", content="
				+ content + ", date=" + date + ", time=" + time + ", isReply="
				+ isReply + "]";
	}
	

}
