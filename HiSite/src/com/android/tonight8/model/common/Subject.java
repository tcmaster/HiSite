package com.android.tonight8.model.common;

import java.io.Serializable;

/**
 * @Description:话题对象
 * @author:LiXiaoSong
 * @copyright @HiSite
 * @Date:2015-1-13
 */
public class Subject implements Serializable {

	private static final long serialVersionUID = 1L;
	/** 话题id */
	public long id;
	/** 话题内容 */
	public String content;
	/** 话题创建日期 */
	public String date;
	/** 话题创建时间 */
	public String time;

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

	@Override
	public String toString() {
		return "Subject [id=" + id + ", content=" + content + ", date=" + date
				+ ", time=" + time + "]";
	}

}
