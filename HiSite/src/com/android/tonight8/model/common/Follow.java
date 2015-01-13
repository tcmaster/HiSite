package com.android.tonight8.model.common;

import com.android.tonight8.model.BaseModel;

/**
 * @Description:关注对象
 * @author:LiXiaoSong
 * @copyright @HiSite
 * @Date:2015-1-13
 */
public class Follow extends BaseModel {

	private static final long serialVersionUID = 1L;
	/** 关注id */
	public int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Follow [id=" + id + "]";
	}

}
