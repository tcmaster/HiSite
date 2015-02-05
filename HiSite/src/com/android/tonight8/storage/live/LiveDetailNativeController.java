package com.android.tonight8.storage.live;

import com.android.tonight8.model.common.Event;
import com.android.tonight8.model.common.Org;
import com.android.tonight8.model.common.PopGoods;
import com.android.tonight8.model.live.LiveDetailModel;
import com.android.tonight8.storage.DBUtil;
import com.android.tonight8.storage.entity.EventEntity;
import com.android.tonight8.storage.entity.OrgEntity;
import com.android.tonight8.storage.entity.PopGoodsEntity;
import com.lidroid.xutils.db.sqlite.WhereBuilder;

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
	public void insertData(LiveDetailModel listModel) {
		EventEntity eventEntity = new EventEntity();
		OrgEntity orgEntity = new OrgEntity();
		PopGoodsEntity popGoodsEntity = new PopGoodsEntity();
		DBUtil.copyData(Event.class, EventEntity.class, listModel.getEvent(), eventEntity);
		DBUtil.copyData(Org.class, OrgEntity.class, listModel.getOrg(), orgEntity);
		DBUtil.copyData(PopGoods.class, PopGoodsEntity.class, listModel.getEvent().popGoods, popGoodsEntity);
		// 存到数据库中
		DBUtil.saveOrUpdate(eventEntity, EventEntity.class, "name", "distance", "timeRangeStart", "timeRangeEnd");
		DBUtil.saveOrUpdate(orgEntity, OrgEntity.class, "name", "logo");
		DBUtil.saveOrUpdate(popGoodsEntity, PopGoodsEntity.class, WhereBuilder.b("rid", "=", eventEntity.getId()), "popGoodsName", "popGoodsPic", "popGoodsPrice");
	}

	/**
	 * @Description:查询现场活动详情
	 * @return
	 * @author: LiuZhao
	 * @date:2015年1月22日
	 */
	public LiveDetailModel selectData(String eventId) {
		LiveDetailModel listModels = new LiveDetailModel();
		EventEntity eventEntity = DBUtil.getDataFirst(EventEntity.class, "id = " + eventId);
		if (eventEntity == null) {
			return null;
		}
		// 活动
		Event event = new Event();
		DBUtil.copyData(EventEntity.class, Event.class, eventEntity, event);
		// 商家
		OrgEntity orgEntity = eventEntity.org;
		Org org = new Org();
		DBUtil.copyData(OrgEntity.class, Org.class, orgEntity, org);
		// 活动海报
		PopGoods popGoods = new PopGoods();
		PopGoodsEntity popGoodsEntity = DBUtil.getDataFirst(PopGoodsEntity.class, " id = " + eventEntity.getId());
		DBUtil.copyData(PopGoodsEntity.class, PopGoods.class, popGoodsEntity, popGoods);

		listModels.setEvent(event);
		listModels.setOrg(org);

		return listModels;

	}

	/**
	 * @Description:删除现场活动数据
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
