package com.android.tonight8.storage.live;

import java.util.ArrayList;
import java.util.List;
import com.android.tonight8.model.common.Comment;
import com.android.tonight8.model.common.User;
import com.android.tonight8.model.live.LiveCommentModel;
import com.android.tonight8.storage.DBUtil;
import com.android.tonight8.storage.entity.CommentEntity;
import com.android.tonight8.storage.entity.UserEntity;

/**
 * @Description:评论列表数据存储
 * @author:LiuZhao
 * @Date:2015年1月23日
 */
public class LiveCommentsNativeController {

	/**
	 * @Description:插入数据
	 * @param listModel
	 * @date:2015年1月22日
	 */
	public void InsertData(List<LiveCommentModel> listModel) {
		List<CommentEntity> commentEntities = new ArrayList<CommentEntity>();
		List<UserEntity> userEntities = new ArrayList<UserEntity>();
		for (int i = 0; i < listModel.size(); i++) {
			CommentEntity commentEntity = new CommentEntity();
			UserEntity userEntity = new UserEntity();
			DBUtil.copyData(Comment.class, CommentEntity.class, listModel.get(i).comment, commentEntity);
			DBUtil.copyData(User.class, UserEntity.class, listModel.get(i).user, userEntity);
			commentEntities.add(commentEntity);
			userEntities.add(userEntity);
		}
		// 存到数据库中
		DBUtil.saveOrUpdateAll(commentEntities, CommentEntity.class, "content", "date", "time", "replyTo");
		DBUtil.saveOrUpdateAll(userEntities, UserEntity.class, "name");
	}

	/**
	 * @Description:查询评论列表
	 * @param listId
	 *            话题id
	 * @return
	 * @author: LiuZhao
	 * @date:2015年1月23日
	 */

	public List<LiveCommentModel> SelectData(String subjectId) {
		List<LiveCommentModel> listModels = new ArrayList<LiveCommentModel>();
		List<CommentEntity> commentlist = DBUtil.getData(CommentEntity.class, "rid = " + subjectId);
		if (commentlist == null) {
			return null;
		}
		for (int i = 0; i < commentlist.size(); i++) {

			LiveCommentModel liveCommentModel = new LiveCommentModel();
			// 评论
			Comment comment = new Comment();
			DBUtil.copyData(CommentEntity.class, Comment.class, commentlist.get(i), liveCommentModel.comment);

			// 用户
			User user = new User();
			DBUtil.copyData(UserEntity.class, User.class, commentlist.get(i).user, liveCommentModel.user);

			liveCommentModel.setComment(comment);
			liveCommentModel.setUser(user);
			listModels.add(liveCommentModel);
		}
		return listModels;

	}
	//
	// /**
	// * @Description:删除现场列表数据
	// * @return
	// * @author: LiuZhao
	// * @date:2015年1月22日
	// */
	// public void DeleteData(String subjectId) {
	// DBUtil.deleteData(CommentEntity.class, subjectId);
	// }
}
