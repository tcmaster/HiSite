package com.android.tonight8.dao.model.wish;

import java.util.List;

import com.android.tonight8.dao.entity.User;
import com.android.tonight8.dao.entity.Wish;
import com.android.tonight8.dao.entity.WishItem;

/**
 * @author lz心愿赞助清单
 * 
 */
public class WishItemModel {
	private Wish wish;
	private List<WishItem> wishitems;
	private User user;

	public Wish getWish() {
		return wish;
	}

	public void setWish(Wish wish) {
		this.wish = wish;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<WishItem> getWishitems() {
		return wishitems;
	}

	public void setWishitems(List<WishItem> wishitems) {
		this.wishitems = wishitems;
	}
	
}
