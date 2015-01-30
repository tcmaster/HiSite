package com.android.tonight8.storage.entity;

import com.lidroid.xutils.db.annotation.Column;
import com.lidroid.xutils.db.annotation.Foreign;
import com.lidroid.xutils.db.annotation.Id;
import com.lidroid.xutils.db.annotation.NoAutoIncrement;
import com.lidroid.xutils.db.annotation.NotNull;
import com.lidroid.xutils.db.annotation.Table;

/**
 * @author liuzhao
 * @date 2015-1-17 活动海报
 * 主键是自增长的
 */
@Table(name = "popgoods")
public class PopGoodsEntity {
	@Id()
	private int id;
	/** 活动海报奖品名称 */
	@Column(column = "popGoodsName")
	private String popGoodsName;
	/** 活动海报奖品图片文件地址 */
	@Column(column = "popGoodsPic")
	private String popGoodsPic;
	/** 活动海报奖品价格 */
	@Column(column = "popGoodsPrice")
	private int popGoodsPrice;
	/** 活动 */
	@Foreign(column = "rid", foreign = "id")
	public EventEntity event;

	public String getPopGoodsName() {
		return popGoodsName;
	}

	public void setPopGoodsName(String popGoodsName) {
		this.popGoodsName = popGoodsName;
	}

	public String getPopGoodsPic() {
		return popGoodsPic;
	}

	public void setPopGoodsPic(String popGoodsPic) {
		this.popGoodsPic = popGoodsPic;
	}

	public int getPopGoodsPrice() {
		return popGoodsPrice;
	}

	public void setPopGoodsPrice(int popGoodsPrice) {
		this.popGoodsPrice = popGoodsPrice;
	}

	@Override
	public String toString() {
		return "PopGoods [event=" + event + ", popGoodsName=" + popGoodsName
				+ ", popGoodsPic=" + popGoodsPic + ", popGoodsPrice="
				+ popGoodsPrice + "]";
	}
}
