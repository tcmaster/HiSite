package com.android.tonight8.model.wish;

import com.android.tonight8.dao.entity.User;
import com.android.tonight8.dao.entity.Wish;
import com.android.tonight8.dao.entity.WishItem;
import com.android.tonight8.dao.entity.WishSponsor;

/**
 * @author lz赞助的心愿列表
 * 
 */
public class MyWishSponsorListModel {
	/** 心愿 */
	private Wish wish;
	/** 心愿项目 */
	private WishItem wishItem;
	/** 心愿赞助 */
	private WishSponsor wishSponsor;
	/** 心愿赞助 */
	private User user;

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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
