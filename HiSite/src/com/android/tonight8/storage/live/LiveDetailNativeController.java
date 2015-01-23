package com.android.tonight8.storage.live;

import com.android.tonight8.model.common.Event;
import com.android.tonight8.model.common.Org;
import com.android.tonight8.model.live.LiveDetailModel;
import com.android.tonight8.storage.DBUtil;
import com.android.tonight8.storage.entity.EventEntity;
import com.android.tonight8.storage.entity.OrgEntity;

/**
 * @Description:现场活动详情数据存储
 * @author:LiuZhao
 * @Date:2015年1月22日
 */
public class LiveDetailNativeController {

	/**
	 * @Description:插入数据
	 * @param listModel
	 * @date:2015年1月22日
	 */
	public void InsertData(LiveDetailModel listModel) {
		EventEntity eventEntity = new EventEntity();
		OrgEntity orgEntity = new OrgEntity();
		DBUtil.copyData(Event.class, EventEntity.class, listModel.getEvent(), eventEntity);
		DBUtil.copyData(Org.class, OrgEntity.class, listModel.getOrg(), orgEntity);
		// 存到数据库中
		DBUtil.saveOrUpdate(eventEntity);
		DBUtil.saveOrUpdate(orgEntity);
	}

	/**
	 * @Description:查询现场列表数据
	 * @return
	 * @author: LiuZhao
	 * @date:2015年1月22日
	 */
	public LiveDetailModel SelectData(String id) {
		LiveDetailModel listModels = new LiveDetailModel();
		EventEntity eventEntity = DBUtil.getDataFirst(EventEntity.class, "id = " + id);
		if (eventEntity == null) {
			return null;
		}
		// 活动
		Event event = new Event();
		DBUtil.copyData(EventEntity.class, Event.class, eventEntity, event);
		OrgEntity orgEntity = eventEntity.org;
		// 商家
		Org org = new Org();
		DBUtil.copyData(OrgEntity.class, Org.class, orgEntity, org);

		listModels.setEvent(event);
		listModels.setOrg(org);

		return listModels;

	}

	/**
	 * @Description:删除现场列表数据
	 * @return
	 * @author: LiuZhao
	 * @date:2015年1月22日
	 */
	public void DeleteData(String id) {
		EventEntity eventEntity = DBUtil.getDataFirst(EventEntity.class, "id = " + id);
		DBUtil.deleteData(EventEntity.class, id);
		DBUtil.deleteData(OrgEntity.class, eventEntity.org.getId());
	}
}
