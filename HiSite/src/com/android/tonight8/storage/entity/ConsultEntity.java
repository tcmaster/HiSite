package com.android.tonight8.storage.entity;

import com.lidroid.xutils.db.annotation.Column;
import com.lidroid.xutils.db.annotation.Foreign;
import com.lidroid.xutils.db.annotation.NotNull;

/**
 * @Description:咨询表
 * @author LiXiaoSong
 * @date 2015-1-17
 */
public class ConsultEntity extends BaseEntity {

	/** 咨询内容 */
	@Column(column = "content")
	@NotNull()
	private String content;
	/** 咨询日期 */
	@Column(column = "date")
	@NotNull()
	private String date;
	/** 咨询时间 */
	@Column(column = "time")
	@NotNull()
	private String time;
	/** 对谁回复的用户名称 */
	@Column(column = "replyTo")
	@NotNull()
	private String replyTo;
	@Foreign(column = "rid", foreign = "id")
	public EventEntity event;
	@Foreign(column = "uid", foreign = "id")
	public UserEntity user;

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
		return "Consult [content=" + content + ", date=" + date + ", time=" + time + ", replyTo=" + replyTo + ", event=" + event + ", user=" + user + "]";
	}

}
