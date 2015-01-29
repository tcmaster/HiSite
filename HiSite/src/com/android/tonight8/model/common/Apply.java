package com.android.tonight8.model.common;

import java.io.Serializable;

/**
 * @Description:活动用户报名对象
 * @author:LiXiaoSong
 * @copyright @HiSite
 * @Date:2015-1-13
 */
public class Apply implements Serializable {

	private static final long serialVersionUID = 1L;
	/** 报名记录id */
	public long id;
	/**活动外键引用*/
	public int rid;
	/**用户外键引用*/
	public int uid;
	/** 用户报名日期 */
	public String date;
	/** 用户报名时间 */
	public String time;

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
		return "Apply [id=" + id + ", date=" + date + ", time=" + time + "]";
	}

}
