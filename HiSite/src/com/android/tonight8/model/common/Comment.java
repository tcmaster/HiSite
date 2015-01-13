package com.android.tonight8.model.common;

import java.io.Serializable;

/**
 * @Description:评论对象
 * @author:LiXiaoSong
 * @copyright @HiSite
 * @Date:2015-1-13
 */
public class Comment implements Serializable {

	private static final long serialVersionUID = 1L;
	/** 评论id */
	public long id;
	/** 评论内容 */
	public String content;
	/** 评论创建日期 */
	public String date;
	/** 评论创建时间 */
	public String time;
	/** 对谁回复的用户名称 */
	public String replyTo;

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

	public String getReplyTo() {
		return replyTo;
	}

	public void setReplyTo(String replyTo) {
		this.replyTo = replyTo;
	}

	@Override
	public String toString() {
		return "Comment [id=" + id + ", content=" + content + ", date=" + date
				+ ", time=" + time + ", replyTo=" + replyTo + "]";
	}

}
