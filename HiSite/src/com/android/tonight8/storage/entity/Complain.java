package com.android.tonight8.storage.entity;

import com.lidroid.xutils.db.annotation.Column;
import com.lidroid.xutils.db.annotation.Foreign;
import com.lidroid.xutils.db.annotation.NotNull;

/**
 * 
 * @Description:投诉表
 * @author LiXiaoSong
 * @date 2015-1-17
 */
public class Complain extends EntityBase {
	/** 投诉类型 */
	@Column(column = "type")
	@NotNull()
	private int type;
	/** 投诉内容 */
	@Column(column = "content")
	@NotNull()
	private String content;
	/** 联系方式内容 */
	@Column(column = "contactContent")
	@NotNull()
	private String contactContent;
	/** 投诉日期 */
	@Column(column = "date")
	@NotNull()
	private String date;
	/** 投诉时间 */
	@Column(column = "time")
	@NotNull()
	private String time;
	@Foreign(column = "rid", foreign = "id")
	Event event;
	@Foreign(column = "uid", foreign = "id")
	User user;

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getContactContent() {
		return contactContent;
	}

	public void setContactContent(String contactContent) {
		this.contactContent = contactContent;
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
		return "Complain [type=" + type + ", content=" + content
				+ ", contactContent=" + contactContent + ", date=" + date
				+ ", time=" + time + ", event=" + event + ", user=" + user
				+ "]";
	}

}
