package com.android.tonight8.model.common;

import java.io.Serializable;

/**
 * 活动海报
 * 
 * @author LiXiaoSong
 * 
 */
public class PopGoods implements Serializable {

	private static final long serialVersionUID = 1L;
	/** 活动海报奖品名称 */
	public String popGoodsName;
	/** 活动海报奖品图片文件地址 */
	public String popGoodsPic;
	/** 活动海报奖品价格 */
	public int popGoodsPrice;
	/** 活动外键 */
	private long rid;

	public long getRid() {
		return rid;
	}

	public void setRid(long rid) {
		this.rid = rid;
	}

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
		return "PopGoods [popGoodsName=" + popGoodsName + ", popGoodsPic="
				+ popGoodsPic + ", popGoodsPrice=" + popGoodsPrice + ", rid="
				+ rid + "]";
	}

}
