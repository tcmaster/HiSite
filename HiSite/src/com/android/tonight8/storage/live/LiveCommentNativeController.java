package com.android.tonight8.storage.live;

import com.android.tonight8.model.common.Comment;
import com.android.tonight8.storage.DBUtil;
import com.android.tonight8.storage.entity.CommentEntity;

/**
 * @Description:评论录入数据存储
 * @author:LiuZhao
 * @Date:2015年1月23日
 */
public class LiveCommentNativeController {

	/**
	 * @Description:评论录入插入数据
	 * @param listModel
	 * @date:2015年1月22日
	 */
	public void InsertData(Comment modle) {

		CommentEntity commentEntity = new CommentEntity();
		DBUtil.copyData(Comment.class, CommentEntity.class, modle,
				commentEntity);
		// 存到数据库中
		DBUtil.saveOrUpdate(commentEntity, CommentEntity.class, "content",
				"rid", "uid");

	}

}
