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
 * @Description:现场话题录入数据存储
 * @author:LiuZhao
 * @Date:2015年1月22日
 */
public class LiveSubjectNativeController {

	/**
	 * @Description:插入数据
	 * @param liveSubjectModel
	 * @param eventId
	 */
	public void InsertData(LiveSubjectModel liveSubjectModel, String eventId) {
		// 话题
		SubjectEntity subjectEntity = new SubjectEntity();
		DBUtil.copyData(Subject.class, SubjectEntity.class,
				liveSubjectModel.getSubject(), subjectEntity);
		// 照片的数量
		int photoCount = liveSubjectModel.getPhotos().size();
		List<Photo> listPhoto = liveSubjectModel.getPhotos();
		List<PhotoEntitiy> lisPhotoEntitiys = new ArrayList<PhotoEntitiy>();
		for (int j = 0; j < photoCount; j++) {
			PhotoEntitiy photoEntitiy = new PhotoEntitiy();
			DBUtil.copyData(Photo.class, PhotoEntitiy.class, listPhoto.get(j),
					photoEntitiy);
			lisPhotoEntitiys.add(photoEntitiy);
		}
		// 用户
		UserEntity userEntity = new UserEntity();
		DBUtil.copyData(User.class, UserEntity.class,
				liveSubjectModel.getUser(), userEntity);
		// 存到数据库中
		DBUtil.saveOrUpdate(subjectEntity);
		DBUtil.saveOrUpdateAll(lisPhotoEntitiys);
		DBUtil.saveOrUpdate(userEntity);

	}

	/**
	 * @Description:查询数据
	 * @param eventId
	 * @param userId
	 * @return
	 */
	public LiveSubjectModel SelectData(String eventId, String userId) {
		LiveSubjectModel model = new LiveSubjectModel();
		// 话题
		Subject subject = new Subject();
		SubjectEntity subjectEntity = DBUtil.getDataFirst(SubjectEntity.class,
				"rid = " + eventId + " and uid = " + userId);
		List<Photo> listPhotos = new ArrayList<Photo>();
		List<Comment> listComments = new ArrayList<Comment>();
		User user = new User();
		// 话题
		DBUtil.copyData(SubjectEntity.class, Subject.class, subjectEntity,
				subject);
		// 图片
		List<PhotoEntitiy> photoEntitiy = DBUtil.getData(PhotoEntitiy.class,
				"rid = " + subjectEntity + " and uid = " + userId);
		if (photoEntitiy != null) {
			for (int i = 0; i < photoEntitiy.size(); i++) {
				Photo photos = new Photo();
				DBUtil.copyData(PhotoEntitiy.class, Photo.class,
						photoEntitiy.get(i), photos);
				listPhotos.add(photos);
			}
		}
		// 评论
		List<CommentEntity> commentEntitiys = DBUtil.getData(
				CommentEntity.class, "rid = " + subjectEntity.getId()
						+ " and uid = " + userId);
		if (commentEntitiys != null) {
			for (int i = 0; i < commentEntitiys.size(); i++) {
				Comment comment = new Comment();
				DBUtil.copyData(CommentEntity.class, Comment.class,
						commentEntitiys.get(i), comment);
				listComments.add(comment);
			}
		}
		// 用户
		DBUtil.copyData(UserEntity.class, User.class, subjectEntity.user, user);

		model.setSubject(subject);
		model.setPhotos(listPhotos);
		model.setComments(listComments);
		model.setUser(user);

		return model;
	}
}
