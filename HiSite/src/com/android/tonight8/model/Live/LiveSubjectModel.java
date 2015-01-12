package com.android.tonight8.model.Live;

import java.util.ArrayList;
import java.util.List;

import com.android.tonight8.model.BaseModel;
import com.android.tonight8.model.common.Comment;
import com.android.tonight8.model.common.Photo;
import com.android.tonight8.model.common.Subject;
import com.android.tonight8.model.common.User;

/**
 * @author liuzhao 活动现场话题
 */
public class LiveSubjectModel extends BaseModel {

	/** */
	private static final long serialVersionUID = 1L;
	/** 话题对象 */
	public Subject subject;
	/** 图片 */
	public List<Photo> photos = new ArrayList<Photo>();
	/** 用户对象 */
	public User user;
	/** 评论 */
	public List<Comment> comments = new ArrayList<Comment>();

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public List<Photo> getPhotos() {
		return photos;
	}

	public void setPhotos(List<Photo> photos) {
		this.photos = photos;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

}
