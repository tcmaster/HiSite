package com.android.tonight8.model.wish;

import com.android.tonight8.dao.entity.Wish;
import com.android.tonight8.dao.entity.WishItem;
import com.android.tonight8.dao.entity.WishSponsor;

/**
 * @author 我的心愿
 * 
 */
public class MyWishListModel {
	/** 心愿 */
	private Wish wish;
	/** 心愿项目 */
	private WishItem wishItem;
	/** 心愿赞助 */
	private WishSponsor wishSponsor;

	public Wish getWish() {
		return wish;
	}

	public void setWish(Wish wish) {
		this.wish = wish;
	}

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
