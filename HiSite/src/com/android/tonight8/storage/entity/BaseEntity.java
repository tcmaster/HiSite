package com.android.tonight8.storage.entity;

import com.lidroid.xutils.db.annotation.Id;
import com.lidroid.xutils.db.annotation.NoAutoIncrement;
import com.lidroid.xutils.db.annotation.NotNull;

/**
 * @Description:
 * @author LiXiaoSong
 * @date 2015-1-17
 */
public class BaseEntity {

	/** 主键id，不可自增长且不为空 */
	@Id
	@NoAutoIncrement()
	@NotNull()
	protected long id;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
}
