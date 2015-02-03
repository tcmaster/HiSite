package com.android.tonight8.storage.live;

import com.android.tonight8.model.common.Comment;
import com.android.tonight8.storage.DBUtil;
import com.android.tonight8.storage.entity.CommentEntity;

/**
 * @author liuzhao 现场评论回复录入保存数据
 */
public class LiveCommentReplyNativeController {

	/**
	 * @Description:现场评论回复录入保存数据
	 * @param listModel
	 * @date:2015年1月22日
	 */
	public void InsertData(Comment model) {

		CommentEntity commentEntity = new CommentEntity();
		DBUtil.copyData(Comment.class, CommentEntity.class, model, commentEntity);
		// 存到数据库中
		DBUtil.saveOrUpdate(commentEntity, CommentEntity.class, "content", "rid", "uid","replyTo");

	}

}
