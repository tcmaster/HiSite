package com.android.tonight8.storage.entity;

import com.lidroid.xutils.db.annotation.NoAutoIncrement;
import com.lidroid.xutils.db.annotation.NotNull;

/**
 * @Description:
 * @author LiXiaoSong
 * @date 2015-1-17
 */
public class EntityBase {
	/** 主键id，不可自增长且不为空 */
	@NoAutoIncrement()
	@NotNull()
	protected int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
