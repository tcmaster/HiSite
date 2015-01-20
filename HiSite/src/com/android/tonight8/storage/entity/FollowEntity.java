package com.android.tonight8.storage.entity;

import com.lidroid.xutils.db.annotation.Foreign;

/**
 * @Description:关注对象表
 * @author LiXiaoSong
 * @date 2015-1-17
 */
public class FollowEntity extends EntityBaseEntity {
	@Foreign(column = "rid", foreign = "id")
	private UserEntity user;
	@Foreign(column = "oid", foreign = "id")
	private OrgEntity org;

	@Override
	public String toString() {
		return "Follow [user=" + user + ", org=" + org + "]";
	}

}
