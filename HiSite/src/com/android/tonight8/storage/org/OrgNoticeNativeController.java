package com.android.tonight8.storage.org;

import java.util.ArrayList;
import java.util.List;

import com.android.tonight8.model.common.Notice;
import com.android.tonight8.storage.DBUtil;
import com.android.tonight8.storage.entity.NoticeEntity;

/**
 * @Description:商家通知列表数据存储
 * @author:LiuZhao
 * @Date:2015年1月26日
 */
public class OrgNoticeNativeController {

	/**
	 * @Description:插入数据
	 * @param listModel
	 * @date:2015年1月22日
	 */
	public void savaOrUpdateData(List<Notice> listModel) {
		List<NoticeEntity> noticeEntities = new ArrayList<NoticeEntity>();
		for (int j = 0; j < listModel.size(); j++) {
			NoticeEntity noticeEntity = new NoticeEntity();
			DBUtil.copyData(Notice.class, NoticeEntity.class, listModel.get(j),
					noticeEntity);
			noticeEntities.add(noticeEntity);
		}
		// 存到数据库中
		DBUtil.saveOrUpdateAll(noticeEntities, NoticeEntity.class);

	}

	/**
	 * @Description:查询数据
	 * @param listModel
	 * @date:2015年1月22日
	 */
	public List<Notice> selectData(String orgId) {
		List<Notice> notices = new ArrayList<Notice>();
		List<NoticeEntity> noticeEntities = DBUtil.getData(NoticeEntity.class,
				" rid = " + orgId);
		if (noticeEntities == null) {
			return null;
		}
		for (int i = 0; i < noticeEntities.size(); i++) {
			Notice notice = new Notice();
			DBUtil.copyData(NoticeEntity.class, Notice.class,
					noticeEntities.get(i), notice);
			notices.add(notice);
		}

		return notices;
	}

}
