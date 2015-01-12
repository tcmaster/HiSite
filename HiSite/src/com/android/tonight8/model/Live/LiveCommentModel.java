package com.android.tonight8.model.Live;

import com.android.tonight8.model.BaseModel;
import com.android.tonight8.model.common.Comment;
import com.android.tonight8.model.common.User;

/**
 * @author liuzhao
 * 活动现场评论
 */
public class LiveCommentModel extends BaseModel{

	private static final long serialVersionUID = 1L;
	/** 评论对象*/
	public Comment comment;
	/** 用户对象*/
	public User user;
	public Comment getComment() {
		return comment;
	}
	public void setComment(Comment comment) {
		this.comment = comment;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	

}
