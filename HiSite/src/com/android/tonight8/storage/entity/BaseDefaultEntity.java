package com.android.tonight8.storage.entity;

import com.lidroid.xutils.db.annotation.Id;
import com.lidroid.xutils.db.annotation.NotNull;
/**
 * @Description:用于自增长的主键表
 * @author LiXiaoSong
 * @date 2015-1-17
 */
public class BaseDefaultEntity {
	/** 主键id，自增长但不为空 */
	@Id
	@NotNull()
	protected long id;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
}
