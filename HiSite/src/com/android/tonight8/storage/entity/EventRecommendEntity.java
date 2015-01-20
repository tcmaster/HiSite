package com.android.tonight8.storage.entity;

import com.lidroid.xutils.db.annotation.Column;
import com.lidroid.xutils.db.annotation.Foreign;
import com.lidroid.xutils.db.annotation.NotNull;

/**
 * @Description：活动推荐表
 * @author LiXiaoSong
 * @date 2015-1-17
 */
public class EventRecommendEntity{
	/**自增长的主键*/
	@NotNull()
	public long id;
	/** 活动推荐名称 */
	@Column(column = "name")
	@NotNull()
	private String name;
	@Foreign(column = "rid", foreign = "id")
	public EventEntity event;
	@Foreign(column = "popId", foreign = "id")
	public PopGoodsEntity popGoods;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "EventRecommend [name=" + name + ", event=" + event + ", popGoods=" + popGoods + "]";
	}

}
