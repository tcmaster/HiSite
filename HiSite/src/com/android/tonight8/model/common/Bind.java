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
	/** 商家绑定状态 */
	public boolean status;
	/** 商家绑定日期 */
	public String date;
	/** 商家被绑定的父级商家id */
	public int parentId;
	/** 子级 */
	public Child child;

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

	public int getParentId() {
		return parentId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
	}

	public Child getChild() {
		return child;
	}

	public void setChild(Child child) {
		this.child = child;
	}

	@Override
	public String toString() {
		return "Bind [status=" + status + ", date=" + date + ", parentId="
				+ parentId + ", child=" + child + "]";
	}

}
