package com.android.tonight8.model.common;

import java.io.Serializable;

/**
 * @Description:询问对象
 * @author:LiXiaoSong
 * @copyright @HiSite
 * @Date:2015-1-13
 */
public class Question implements Serializable {

	private static final long serialVersionUID = 1L;
	/** 询问id */
	public long id;
	/** 询问内容 */
	public String content;
	/** 询问日期 */
	public String date;
	/** 询问时间 */
	public String time;
	/** 被回复的问题id*/
	public int toId;
	/** 用户外键 */
	public long uid;
	/** 商家外键 */
	public long oid;

	public long getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public long getOid() {
		return oid;
	}

	public void setOid(int oid) {
		this.oid = oid;
	}

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

	
	public int getToId() {
		return toId;
	}

	
	public void setToId(int toId) {
		this.toId = toId;
	}


}
