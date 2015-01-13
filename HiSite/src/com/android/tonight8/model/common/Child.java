package com.android.tonight8.model.common;

import java.io.Serializable;

/**
 * 子级对象
 * 
 * @author LiXiaoSong
 * 
 */
public class Child implements Serializable {
	private static final long serialVersionUID = 1L;
	/** 子级id */
	public int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Child [id=" + id + "]";
	}

}
