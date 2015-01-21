package com.android.tonight8.storage.entity;

import com.lidroid.xutils.db.annotation.Column;
import com.lidroid.xutils.db.annotation.Foreign;
import com.lidroid.xutils.db.annotation.NotNull;
import com.lidroid.xutils.db.annotation.Table;

/**
 * @author liuzhao
 * @date 2015-1-17 话题
 */
@Table(name = "subject")
public class SubjectEntity extends BaseEntity {
	/** 活动 */
	@Foreign(column = "rid", foreign = "id")
	private EventEntity event;
	/** 用户 */
	@Foreign(column = "uid", foreign = "id")
	private UserEntity user;
	/** 话题内容 */
	@Column(column = "content")
	@NotNull
	private String content;
	/** 话题创建日期 */
	@Column(column = "date")
	@NotNull
	private String date;
	/** 话题创建时间 */
	@Column(column = "time")
	@NotNull
	private String time;

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

	@Override
	public String toString() {
		return "Subject [event=" + event + ", user=" + user + ", content="
				+ content + ", date=" + date + ", time=" + time + "]";
	}

}
