package com.android.tonight8.model.common;

import java.io.Serializable;

/**
 * @Description:咨询对象
 * @author:LiXiaoSong
 * @copyright @HiSite
 * @Date:2015-1-13
 */
public class Consult implements Serializable {

	private static final long serialVersionUID = 1L;
	/** 咨询id */
	public long id;
	/** 活动id */
	public int rid;
	/** 咨询id */
	public int uid;
	/** 回复id */
	public long quoteId;
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
	public int getRid() {
		return rid;
	}
	public void setRid(int rid) {
		this.rid = rid;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public long getQuoteId() {
		return quoteId;
	}
	public void setQuoteId(long quoteId) {
		this.quoteId = quoteId;
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
		return "Consult [id=" + id + ", rid=" + rid + ", uid=" + uid
				+ ", quoteId=" + quoteId + ", content=" + content + ", date="
				+ date + ", time=" + time + ", replyTo=" + replyTo + "]";
	}

	

}
