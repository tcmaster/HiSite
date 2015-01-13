package com.android.tonight8.model.common;

import com.android.tonight8.model.BaseModel;

/**
 * @Description:咨询对象
 * @author:LiXiaoSong
 * @copyright @HiSite
 * @Date:2015-1-13
 */
public class Consult extends BaseModel {

	private static final long serialVersionUID = 1L;
	/** 咨询id */
	public long id;
	/** 回复引用的咨询id */
	public long rid;
	/** 咨询内容 */
	public String content;
	/** 咨询日期 */
	public String date;
	/** 咨询时间 */
	public String time;
	/** 对谁回复的用户名称 */
	public String replyTo;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getRid() {
		return rid;
	}

	public void setRid(long rid) {
		this.rid = rid;
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

	public String getReplyTo() {
		return replyTo;
	}

	public void setReplyTo(String replyTo) {
		this.replyTo = replyTo;
	}

	@Override
	public String toString() {
		return "Consult [id=" + id + ", rid=" + rid + ", content=" + content + ", date=" + date + ", time=" + time + ", replyTo=" + replyTo + "]";
	}

}
