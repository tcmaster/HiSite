package com.android.tonight8.storage.live;

import com.android.tonight8.model.common.Subject;
import com.android.tonight8.storage.DBUtil;
import com.android.tonight8.storage.entity.SubjectEntity;

/**
 * @Description:现场话题录入数据存储
 * @author:LiuZhao
 * @Date:2015年1月22日
 */
public class LiveSubjectNativeController {

	public void InsertData(Subject subject, String eventId, String userid) {
		// 话题
		SubjectEntity subjectEntity = new SubjectEntity();
		// subjectEntity.user.setId(userid);
		// subjectEntity.ev.setId(userid);
		DBUtil.copyData(Subject.class, SubjectEntity.class, subject, subjectEntity);
		// 存到数据库中
		DBUtil.saveOrUpdate(subjectEntity);

	}
}
