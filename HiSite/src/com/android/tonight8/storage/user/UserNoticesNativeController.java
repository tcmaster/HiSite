/**
 * 2015-2-3
 */
package com.android.tonight8.storage.user;

import java.util.ArrayList;
import java.util.List;

import com.android.tonight8.model.common.Notice;
import com.android.tonight8.storage.DBUtil;
import com.android.tonight8.storage.entity.NoticeEntity;
import com.android.tonight8.storage.entity.OrgEntity;

/**
 * @Description: 用户通知本地存储控制类
 * @author:LiXiaoSong
 * @copyright @HiSite
 * @Date:2015-2-3
 */
public class UserNoticesNativeController {

	public void insertData(List<Notice> models) {
		List<NoticeEntity> noticeEntities = new ArrayList<NoticeEntity>();
		for (int i = 0; i < models.size(); i++) {
			NoticeEntity noticeEntity = new NoticeEntity();
			DBUtil.copyData(Notice.class, NoticeEntity.class, models.get(i), noticeEntity);
			noticeEntity.org = DBUtil.getDataFirst(OrgEntity.class, "id = " + models.get(i).rid);
			noticeEntities.add(noticeEntity);
		}
		DBUtil.saveOrUpdateAll(noticeEntities, NoticeEntity.class, "content", "date", "time", "rid");
	}

	/**
	 * @Description:根据用户信息取出
	 * @param userId
	 * @return
	 * @author: LiXiaoSong
	 * @date:2015-2-3
	 */
	public List<Notice> selectData(long userId) {
		List<Notice> models = new ArrayList<Notice>();
		return models;
	}
}
