package com.android.tonight8.dao.model.live;

import com.android.tonight8.dao.entity.Address;
import com.android.tonight8.dao.entity.User;

/**
 * @Descripton 活动中奖名单
 * @author LiXiaoSong
 * @2015-6-15
 * @Tonight8
 */
public class EventAward {
	private User user;
	private Address address;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "EventAward [user=" + user + ", address=" + address + "]";
	}

}
