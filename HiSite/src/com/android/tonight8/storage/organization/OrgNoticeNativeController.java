package com.android.tonight8.storage.organization;

import java.util.ArrayList;
import java.util.List;

import com.android.tonight8.model.common.Event;
import com.android.tonight8.model.common.Notice;
import com.android.tonight8.model.common.Org;
import com.android.tonight8.model.live.LiveDetailModel;
import com.android.tonight8.storage.DBUtil;
import com.android.tonight8.storage.entity.EventEntity;
import com.android.tonight8.storage.entity.NoticeEntity;
import com.android.tonight8.storage.entity.OrgEntity;

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
	public void InsertData(List<Notice> listModel, String orgId) {
		List<NoticeEntity> list = new ArrayList<NoticeEntity>();
		OrgEntity orgEntity = DBUtil.getDataFirst(OrgEntity.class, " id = " + orgId);
		for (int i = 0; i < listModel.size(); i++) {
			NoticeEntity noticeEntity = new NoticeEntity();

			DBUtil.copyData(Notice.class, NoticeEntity.class, listModel.get(i), noticeEntity);
			noticeEntity.org = orgEntity;
			list.add(noticeEntity);
		}
		// 存到数据库中
		DBUtil.saveOrUpdateAll(list);

	}

}
