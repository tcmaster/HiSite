package com.android.tonight8.model.common;

import java.io.Serializable;

/**
 * @Description:通知对象
 * @author:LiXiaoSong
 * @copyright @HiSite
 * @Date:2015-1-13
 */
public class Notice implements Serializable {

	private static final long serialVersionUID = 1L;
	/** 通知id */
	public long id;
	/** 通知内容 */
	public String content;
	/** 通知日期 */
	public String date;
	/** 通知时间 */
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
		return "Notice [id=" + id + ", content=" + content + ", date=" + date
				+ ", time=" + time + "]";
	}

}
