package com.android.tonight8.model.event;

import com.android.tonight8.model.BaseModel;
import com.android.tonight8.model.common.PopGoods;

/**
 * 活动推荐
 * 
 * @author LiXiaoSong
 * 
 */
public class EventRecommendModel extends BaseModel {
	private static final long serialVersionUID = 1L;
	/** 活动id */
	public long id;
	/** 活动名称 */
	public String name;
	/***/
	public PopGoods popGoods;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public PopGoods getPopGoods() {
		return popGoods;
	}

	public void setPopGoods(PopGoods popGoods) {
		this.popGoods = popGoods;
	}

	@Override
	public String toString() {
		return "EventRecommendModel [id=" + id + ", name=" + name
				+ ", popGoods=" + popGoods + "]";
	}

}
