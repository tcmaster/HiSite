package com.android.tonight8.dao.model.live;

import java.util.List;

import com.android.tonight8.dao.entity.Audio;
import com.android.tonight8.dao.entity.Org;
import com.android.tonight8.dao.entity.Photo;
import com.android.tonight8.dao.entity.Seller;
import com.android.tonight8.dao.entity.Source;
import com.android.tonight8.dao.entity.Subject;
import com.android.tonight8.dao.entity.User;

/**
 * 
 * @Descripton 话题列表
 * @author LiXiaoSong
 * @2015-6-12
 * @Tonight8
 */
public class SubjectList {
	private Subject subject;
	private User user;
	private Seller seller;
	private Org org;
	private List<Photo> photos;
	private Audio audio;
	private Source source;

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
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

	public List<Photo> getPhotos() {
		return photos;
	}

	public void setPhotos(List<Photo> photos) {
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

	@Override
	public String toString() {
		return "SubjectList [subject=" + subject + ", user=" + user
				+ ", seller=" + seller + ", org=" + org + ", photos=" + photos
				+ ", audio=" + audio + ", source=" + source + "]";
	}

}
