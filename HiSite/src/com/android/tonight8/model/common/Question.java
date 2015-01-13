package com.android.tonight8.model.common;

import com.android.tonight8.model.BaseModel;

/**
 * @Description:询问对象
 * @author:LiXiaoSong
 * @copyright @HiSite
 * @Date:2015-1-13
 */
public class Question extends BaseModel {

	private static final long serialVersionUID = 1L;
	/** 询问id */
	public long id;
	/** 询问内容 */
	public String content;
	/** 询问日期 */
	public String date;
	/** 询问时间 */
	public String time;
	/** 是否是回复记录 */
	public boolean isReply;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public boolean isReply() {
		return isReply;
	}

	public void setReply(boolean isReply) {
		this.isReply = isReply;
	}

	@Override
	public String toString() {
		return "Question [id=" + id + ", content=" + content + ", date=" + date + ", time=" + time + ", isReply=" + isReply + "]";
	}

}
