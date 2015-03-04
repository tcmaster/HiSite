package com.android.tonight8.storage.entity;

import com.lidroid.xutils.db.annotation.Column;
import com.lidroid.xutils.db.annotation.Foreign;
import com.lidroid.xutils.db.annotation.Table;

/**
 * @Description:消息通知
 * @author:LiuZhao
 * @Date:2015年3月4日
 */
@Table(name = "message")
public class MessageEntity extends BaseEntity {

	/** 消息类型 */
	@Column(column = "type")
	public int type;
	/** 消息标题 */
	@Column(column = "title")
	public String title;
	/** 通知内容 */
	@Column(column = "content")
	public String content;
	/** 通知日期 */
	@Column(column = "date")
	public String date;
	/** 通知时间 */
	@Column(column = "time")
	public String time;
	/** 消息链接 */
	@Column(column = "link")
	public String link;
	/** 商家 */
	@Foreign(column = "rid", foreign = "id")
	public OrgEntity org;
	/** 商家 */
	@Foreign(column = "uid", foreign = "id")
	public UserEntity user;

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

}
