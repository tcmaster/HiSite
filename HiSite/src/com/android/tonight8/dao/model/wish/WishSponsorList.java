package com.android.tonight8.dao.model.wish;

import com.android.tonight8.dao.entity.WishItem;
import com.android.tonight8.dao.entity.WishSponsor;

/**
 * @author 心愿赞助列表
 * 
 */
public class WishSponsorList {
	/** 心愿项目对象 */
	private WishItem wishItem;
	/** 心愿赞助对象 */
	private WishSponsor wishSponsor;

	public WishItem getWishItem() {
		return wishItem;
	}

	public void setWishItem(WishItem wishItem) {
		this.wishItem = wishItem;
	}

	public WishSponsor getWishSponsor() {
		return wishSponsor;
	}

	public void setWishSponsor(WishSponsor wishSponsor) {
		this.wishSponsor = wishSponsor;
	}
}
