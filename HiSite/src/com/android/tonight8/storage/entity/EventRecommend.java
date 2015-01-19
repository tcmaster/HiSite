package com.android.tonight8.storage.entity;

import com.lidroid.xutils.db.annotation.Column;
import com.lidroid.xutils.db.annotation.Foreign;
import com.lidroid.xutils.db.annotation.NotNull;

/**
 * @Description：活动推荐表
 * @author LiXiaoSong
 * @date 2015-1-17
 */
public class EventRecommend extends EntityBase {
	/** 活动推荐名称 */
	@Column(column = "name")
	@NotNull()
	private String name;
	@Foreign(column = "rid", foreign = "id")
	private Event event;
	@Foreign(column = "popId", foreign = "id")
	private PopGoods popGoods;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "EventRecommend [name=" + name + ", event=" + event
				+ ", popGoods=" + popGoods + "]";
	}

}
