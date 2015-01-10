package com.android.tonight8.model.common;

import com.android.tonight8.model.BaseModel;

/**
 * 活动海报
 * 
 * @author LiXiaoSong
 * 
 */
public class PopGoods extends BaseModel {
	private static final long serialVersionUID = 1L;
	/** 活动海报奖品名称 */
	public String popGoodsName;
	/** 活动海报奖品图片文件地址 */
	public String popGoodsPic;
	/** 活动海报奖品价格 */
	public int popGoodsPrice;

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
				+ popGoodsPic + ", popGoodsPrice=" + popGoodsPrice + "]";
	}

}
