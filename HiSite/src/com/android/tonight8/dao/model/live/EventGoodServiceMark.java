package com.android.tonight8.dao.model.live;

import com.android.tonight8.dao.entity.Photo;
import com.android.tonight8.dao.entity.SignIn;
import com.android.tonight8.dao.entity.User;

public class EventGoodServiceMark {
	private SignIn signIn;
	private Photo photo;
	private User user;

	public SignIn getSignIn() {
		return signIn;
	}

	public void setSignIn(SignIn signIn) {
		this.signIn = signIn;
	}

	public Photo getPhoto() {
		return photo;
	}

	public void setPhoto(Photo photo) {
		this.photo = photo;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "EventGoodService [signIn=" + signIn + ", photo=" + photo
				+ ", user=" + user + "]";
	}

}
