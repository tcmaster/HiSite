package com.android.tonight8.model.common;

import java.io.Serializable;

/**
 * @Description:商家绑定对象
 * @author:LiXiaoSong
 * @copyright @HiSite
 * @Date:2015-1-13
 */
public class Bind implements Serializable {

	private static final long serialVersionUID = 1L;
	/** bind的id值*/
	public int id;
	/**商家的id外键*/
	public int rid;
	/** 商家绑定状态 */
	public boolean status;
	/** 商家绑定日期 */
	public String date;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getRid() {
		return rid;
	}
	public void setRid(int rid) {
		this.rid = rid;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "Bind [id=" + id + ", rid=" + rid + ", status=" + status
				+ ", date=" + date + "]";
	}
	
	
}
