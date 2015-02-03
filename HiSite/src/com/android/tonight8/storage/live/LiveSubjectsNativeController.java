package com.android.tonight8.storage.live;

import java.util.ArrayList;
import java.util.List;

import com.android.tonight8.model.common.Comment;
import com.android.tonight8.model.common.Photo;
import com.android.tonight8.model.common.Subject;
import com.android.tonight8.model.common.User;
import com.android.tonight8.model.live.LiveSubjectModel;
import com.android.tonight8.storage.DBUtil;
import com.android.tonight8.storage.entity.CommentEntity;
import com.android.tonight8.storage.entity.PhotoEntitiy;
import com.android.tonight8.storage.entity.SubjectEntity;
import com.android.tonight8.storage.entity.UserEntity;

/**
 * @Description:现场话题列表数据存储
 * @author:LiuZhao
 * @Date:2015年1月22日
 */
public class LiveSubjectsNativeController {

	public void InsertData(List<LiveSubjectModel> listModel) {
		List<SubjectEntity> subjectEntities = new ArrayList<SubjectEntity>();
		List<PhotoEntitiy> listPhotoEntitiys = new ArrayList<PhotoEntitiy>();
		List<CommentEntity> listCommentEntities = new ArrayList<CommentEntity>();
		List<UserEntity> userEntities = new ArrayList<UserEntity>();
		for (int i = 0; i < listModel.size(); i++) {
			// 话题
			SubjectEntity subjectEntity = new SubjectEntity();
			DBUtil.copyData(Subject.class, SubjectEntity.class, listModel.get(i).getSubject(), subjectEntity);
			subjectEntities.add(subjectEntity);
			// 照片的数量
			int photoCount = listModel.get(i).getPhotos().size();
			List<Photo> listPhoto = listModel.get(i).getPhotos();
			for (int j = 0; j < photoCount; j++) {
				PhotoEntitiy photoEntitiy = new PhotoEntitiy();
				DBUtil.copyData(Photo.class, PhotoEntitiy.class, listPhoto.get(j), photoEntitiy);
				listPhotoEntitiys.add(photoEntitiy);
			}
			// 评论的数量
			int commentCount = listModel.get(i).getComments().size();
			List<Comment> comments = listModel.get(i).getComments();
			for (int j = 0; j < commentCount; j++) {
				CommentEntity commentEntity = new CommentEntity();
				DBUtil.copyData(Comment.class, CommentEntity.class, comments.get(j), commentEntity);
				listCommentEntities.add(commentEntity);
			}
			// 用户
			UserEntity userEntity = new UserEntity();
			DBUtil.copyData(User.class, UserEntity.class, listModel.get(i).getUser(), userEntity);

		}
		// 存到数据库中
		DBUtil.saveOrUpdateAll(subjectEntities, SubjectEntity.class, "content", "date", "time");
		DBUtil.saveOrUpdateAll(listPhotoEntitiys, PhotoEntitiy.class, "url", "size");
		DBUtil.saveOrUpdateAll(listCommentEntities, CommentEntity.class, "rid", "content", "date", "time", "replyTo");
		DBUtil.saveOrUpdateAll(userEntities, UserEntity.class, "name");
	}

	/**
	 * @Description:查询话题的列表数据
	 * @return
	 * @date:2015年1月23日 话题id
	 */
	public List<LiveSubjectModel> SelectData() {
		List<LiveSubjectModel> liveSubjectModels = new ArrayList<LiveSubjectModel>();
		// 话题（根据话题id降序排列）
		List<SubjectEntity> list = DBUtil.getData(SubjectEntity.class, "order by id desc");
		if (list == null) {
			return null;
		}
		for (int j = 0; j < list.size(); j++) {

			Subject subject = new Subject();
			List<Photo> listPhotos = new ArrayList<Photo>();
			List<Comment> listComments = new ArrayList<Comment>();
			User user = new User();
			// 话题
			DBUtil.copyData(SubjectEntity.class, Subject.class, list.get(j), subject);
			// 图片
			List<PhotoEntitiy> photoEntitiy = DBUtil.getData(PhotoEntitiy.class, "rid = " + list.get(j).getId() + " and uid = " + list.get(j).user.getId());
			if (photoEntitiy != null) {
				for (int i = 0; i < photoEntitiy.size(); i++) {
					Photo photos = new Photo();
					DBUtil.copyData(PhotoEntitiy.class, Photo.class, photoEntitiy.get(i), photos);
					listPhotos.add(photos);
				}
			}
			// 评论
			List<CommentEntity> commentEntitiys = DBUtil.getData(CommentEntity.class, "rid = " + list.get(j).getId() + " and uid = " + list.get(j).user.getId());
			if (commentEntitiys != null) {
				for (int i = 0; i < commentEntitiys.size(); i++) {
					Comment comment = new Comment();
					DBUtil.copyData(CommentEntity.class, Comment.class, commentEntitiys.get(i), comment);
					listComments.add(comment);
				}
			}
			// 用户
			DBUtil.copyData(UserEntity.class, User.class, list.get(j).user, user);

			LiveSubjectModel model = new LiveSubjectModel();
			model.setSubject(subject);
			model.setPhotos(listPhotos);
			model.setComments(listComments);
			model.setUser(user);
			liveSubjectModels.add(model);
		}
		return liveSubjectModels;

	}
}
