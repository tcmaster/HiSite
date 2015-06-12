package com.android.tonight8.dao.model.wish;

import com.android.tonight8.dao.entity.Audio;
import com.android.tonight8.dao.entity.Org;
import com.android.tonight8.dao.entity.Photo;
import com.android.tonight8.dao.entity.Seller;
import com.android.tonight8.dao.entity.Source;
import com.android.tonight8.dao.entity.Subject;
import com.android.tonight8.dao.entity.User;

/**
 * @author zl 话题列表
 *
 */
public class SubjectListModel {
	private Subject subject;
	private Photo photos;
	private Audio audio;
	private Source source;
	private User user;
	private Seller seller;
	private Org org;

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public Photo getPhotos() {
		return photos;
	}

	public void setPhotos(Photo photos) {
		this.photos = photos;
	}

	public Audio getAudio() {
		return audio;
	}

	public void setAudio(Audio audio) {
		this.audio = audio;
	}

	public Source getSource() {
		return source;
	}

	public void setSource(Source source) {
		this.source = source;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Seller getSeller() {
		return seller;
	}

	public void setSeller(Seller seller) {
		this.seller = seller;
	}

	public Org getOrg() {
		return org;
	}

	public void setOrg(Org org) {
		this.org = org;
	}

}
