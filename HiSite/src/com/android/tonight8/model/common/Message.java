package com.android.tonight8.model.common;

import java.io.Serializable;

/**
 * @Description:商家消息
 * @author:LiuZhao
 * @Date:2015年3月4日
 */
public class Message implements Serializable {

	/** */
	private static final long serialVersionUID = 1L;
	/** */
	public int id;
	/** */
	public int fromId;
	/** 消息类型 */
	public int type;
	/** 消息标题 */
	public String title;
	/** 消息内容 */
	public String content;
	/** 消息链接 */
	public String link;
	/** 消息日期 */
	public String date;
	/** 消息时间 */
	public String time;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getFromId() {
		return fromId;
	}
	
	public void setFromId(int fromId) {
		this.fromId = fromId;
	}
	
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
	
	public String getLink() {
		return link;
	}
	
	public void setLink(String link) {
		this.link = link;
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

}
