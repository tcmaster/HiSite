package com.android.tonight8.storage.entity;

import com.lidroid.xutils.db.annotation.Foreign;

/**
 * @Description:关注对象表
 * @author LiXiaoSong
 * @date 2015-1-17
 */
public class Follow extends EntityBase {
	@Foreign(column = "rid", foreign = "id")
	private User user;
	@Foreign(column = "oid", foreign = "id")
	private Org org;

	@Override
	public String toString() {
		return "Follow [user=" + user + ", org=" + org + "]";
	}

}
