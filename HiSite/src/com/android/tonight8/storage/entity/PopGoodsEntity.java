package com.android.tonight8.storage.entity;

import com.lidroid.xutils.db.annotation.Column;
import com.lidroid.xutils.db.annotation.Foreign;
import com.lidroid.xutils.db.annotation.NotNull;
import com.lidroid.xutils.db.annotation.Table;

/**
 * @author liuzhao
 * @date 2015-1-17 活动海报
 */
@Table(name = "popgoods")
public class PopGoodsEntity extends EntityBaseEntity {

	/** 活动 */
	@Foreign(column = "rid", foreign = "id")
	private EventEntity event;
	/** 活动海报奖品名称 */
	@NotNull
	@Column(column = "popGoodsName")
	private String popGoodsName;
	/** 活动海报奖品图片文件地址 */
	@NotNull
	@Column(column = "popGoodsPic")
	private String popGoodsPic;
	/** 活动海报奖品价格 */
	@NotNull
	@Column(column = "popGoodsPrice")
	private int popGoodsPrice;

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
		return "PopGoods [event=" + event + ", popGoodsName=" + popGoodsName + ", popGoodsPic=" + popGoodsPic + ", popGoodsPrice=" + popGoodsPrice + "]";
	}
}
