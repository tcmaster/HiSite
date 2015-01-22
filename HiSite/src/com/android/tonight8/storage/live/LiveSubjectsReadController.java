package com.android.tonight8.storage.live;

import java.util.ArrayList;
import java.util.List;

import com.android.tonight8.model.common.Comment;
import com.android.tonight8.model.common.Event;
import com.android.tonight8.model.common.Org;
import com.android.tonight8.model.common.Photo;
import com.android.tonight8.model.live.LiveSubjectModel;
import com.android.tonight8.storage.DBUtil;
import com.android.tonight8.storage.entity.EventEntity;
import com.android.tonight8.storage.entity.OrgEntity;
import com.android.tonight8.storage.entity.SubjectEntity;
import com.android.tonight8.storage.entity.UserEntity;

/**
 * @Description:现场话题列表数据存储
 * @author:LiuZhao
 * @Date:2015年1月22日
 */
public class LiveSubjectsReadController {

	public void InsertData(List<LiveSubjectModel> listModel) {
		List<SubjectEntity> eventEntities = new ArrayList<SubjectEntity>();
		List<Photo> listPhotos = new ArrayList<Photo>();
		List<Comment> listComments = new ArrayList<Comment>();
		List<UserEntity> userEntities = new ArrayList<UserEntity>();
		for (int i = 0; i < listModel.size(); i++) {

			// // 查询是否有该活动
			// EventEntity hasEventEvent = DBUtil.getDataFirst(EventEntity.class, "id = " +
			// listModel.get(i).getEvent().getId());
			// EventEntity eventEntity = new EventEntity();
			// DBUtil.copyData(Event.class, EventEntity.class, listModel.get(i).getEvent(), eventEntity);
			// eventEntity = hasEventEvent;
			// eventEntities.add(eventEntity);

		}
		// 存到数据库中
		DBUtil.saveOrUpdate(eventEntities);
		DBUtil.saveOrUpdate(listPhotos);
		DBUtil.saveOrUpdate(listComments);
		DBUtil.saveOrUpdate(userEntities);
	}
}
