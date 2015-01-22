package com.android.tonight8.storage.live;

import java.util.ArrayList;
import java.util.List;

import com.android.tonight8.model.common.Event;
import com.android.tonight8.model.common.Org;
import com.android.tonight8.model.live.LiveDetailModel;
import com.android.tonight8.model.live.LiveListModel;
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
	public void InsertData(List<LiveDetailModel> listModel) {
		List<EventEntity> eventEntities = new ArrayList<EventEntity>();
		List<OrgEntity> orgEntities = new ArrayList<OrgEntity>();
		for (int i = 0; i < listModel.size(); i++) {

			// 查询是否有该活动
			EventEntity hasEventEvent = DBUtil.getDataFirst(EventEntity.class, "id = " + listModel.get(i).getEvent().getId());
			EventEntity eventEntity = new EventEntity();
			DBUtil.copyData(Event.class, EventEntity.class, listModel.get(i).getEvent(), eventEntity);
			eventEntity = hasEventEvent;
			eventEntities.add(eventEntity);

			OrgEntity hasOrgEvent = DBUtil.getDataFirst(OrgEntity.class, "id = " + listModel.get(i).getOrg().getId());
			OrgEntity orgEntity = new OrgEntity();
			DBUtil.copyData(Org.class, OrgEntity.class, listModel.get(i).getOrg(), orgEntity);
			orgEntity = hasOrgEvent;
			orgEntities.add(orgEntity);
		}
		// 存到数据库中
		DBUtil.saveOrUpdate(eventEntities);
		DBUtil.saveOrUpdate(orgEntities);
	}

	/**
	 * @Description:查询现场列表数据
	 * @return
	 * @author: LiuZhao
	 * @date:2015年1月22日
	 */
	public List<LiveDetailModel> SelectData() {
		List<LiveDetailModel> listModels = new ArrayList<LiveDetailModel>();
		List<EventEntity> eventEntities = DBUtil.getData(EventEntity.class, "order by timeStamp desc");
		if (eventEntities == null) {
			return null;
		}
		for (int i = 0; i < eventEntities.size(); i++) {
			LiveListModel listModel = new LiveListModel();
			// 活动
			Event event = new Event();
			EventEntity eventEntity = new EventEntity();
			eventEntity = eventEntities.get(i);
			DBUtil.copyData(EventEntity.class, Event.class, eventEntity, event);
			listModel.setEvent(event);
			// 商家
			Org org = new Org();
			OrgEntity orgEntity = eventEntity.org;
			DBUtil.copyData(OrgEntity.class, Org.class, orgEntity, org);
			listModel.setOrg(org);

		}
		return listModels;

	}
}
