package com.android.tonight8.dao.model.wish;

import java.util.List;

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
	private List<WishSponsor> wishSponsors;
	private boolean isChecked = false;

	public boolean isChecked() {
		return isChecked;
	}

	public void setChecked(boolean isChecked) {
		this.isChecked = isChecked;
	}

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

	public List<WishSponsor> getWishSponsors() {
		return wishSponsors;
	}

	public void setWishSponsors(List<WishSponsor> wishSponsors) {
		this.wishSponsors = wishSponsors;
	}

}
