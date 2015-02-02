package com.android.tonight8.storage.live;

import com.android.tonight8.model.common.Comment;
import com.android.tonight8.model.common.User;
import com.android.tonight8.model.live.LiveCommentModel;
import com.android.tonight8.storage.DBUtil;
import com.android.tonight8.storage.entity.CommentEntity;
import com.android.tonight8.storage.entity.UserEntity;

/**
 * @author liuzhao 现场评论回复录入保存数据
 */
public class LiveCommentReplyNativeController {
	/**
	 * @Description:现场评论回复录入保存数据
	 * @param listModel
	 * @date:2015年1月22日
	 */
	public void InsertData(LiveCommentModel model) {

		CommentEntity commentEntity = new CommentEntity();
		UserEntity userEntity = new UserEntity();
		DBUtil.copyData(Comment.class, CommentEntity.class, model.getComment(),
				commentEntity);
		DBUtil.copyData(User.class, UserEntity.class, model.user, userEntity);
		// 存到数据库中
		DBUtil.saveOrUpdate(commentEntity, CommentEntity.class, "content");
		DBUtil.saveOrUpdate(userEntity, UserEntity.class, "name", "pic");

	}

	public void InsertData(Comment model) {

		CommentEntity commentEntity = new CommentEntity();
		DBUtil.copyData(Comment.class, CommentEntity.class, model,
				commentEntity);
		// 存到数据库中
		DBUtil.saveOrUpdate(commentEntity, CommentEntity.class, "content");

	}

}
