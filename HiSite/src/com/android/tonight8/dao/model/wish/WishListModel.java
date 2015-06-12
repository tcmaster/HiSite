package com.android.tonight8.dao.model.wish;

import com.android.tonight8.dao.entity.PopPic;
import com.android.tonight8.dao.entity.User;
import com.android.tonight8.dao.entity.Wish;

/**
 * @author lz 心愿列表
 * 
 */
public class WishListModel {
	/** 心愿 */
	private Wish wish;
	/** 海报 */
	private PopPic popPic;
	/** 用户信息 */
	private User user;

	public Wish getWish() {
		return wish;
	}

	public void setWish(Wish wish) {
		this.wish = wish;
	}

	public PopPic getPopPic() {
		return popPic;
	}

	public void setPopPic(PopPic popPic) {
		this.popPic = popPic;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}