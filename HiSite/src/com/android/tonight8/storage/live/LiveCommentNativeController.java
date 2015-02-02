package com.android.tonight8.storage.live;

import com.android.tonight8.model.common.Comment;
import com.android.tonight8.model.common.User;
import com.android.tonight8.model.live.LiveCommentModel;
import com.android.tonight8.storage.DBUtil;
import com.android.tonight8.storage.entity.CommentEntity;
import com.android.tonight8.storage.entity.UserEntity;

/**
 * @Description:评论录入数据存储
 * @author:LiuZhao
 * @Date:2015年1月23日
 */
public class LiveCommentNativeController {

	/**
	 * @Description:插入数据
	 * @param listModel
	 * @date:2015年1月22日
	 */
	public void InsertData(LiveCommentModel listModel) {

		CommentEntity commentEntity = new CommentEntity();
		DBUtil.copyData(Comment.class, CommentEntity.class, listModel.getComment(), commentEntity);
		// 存到数据库中
		DBUtil.addData(commentEntity);

	}
	//
	// // 通过查询评论列表查询出来
	// /**
	// * @param userid
	// * @param subjectid
	// * @return 查询数据
	// */
	// public LiveCommentModel SelectData(String userid, String subjectid) {
	// LiveCommentModel liveCommentModel = new LiveCommentModel();
	// CommentEntity commentEntity = DBUtil.getDataFirst(CommentEntity.class, "rid = " + subjectid + " and " +
	// "uid = " + userid);
	// UserEntity userEntity = DBUtil.getDataFirst(UserEntity.class, "uid = " + userid);
	// DBUtil.copyData(CommentEntity.class, Comment.class, commentEntity, liveCommentModel.getComment());
	// DBUtil.copyData(UserEntity.class, User.class, userEntity, liveCommentModel.getUser());
	// return liveCommentModel;
	// }
}
