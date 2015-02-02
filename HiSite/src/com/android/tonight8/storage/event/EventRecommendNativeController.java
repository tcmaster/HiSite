/**
 * 2015-1-20
 */
package com.android.tonight8.storage.event;

import java.util.ArrayList;
import java.util.List;

import com.android.tonight8.model.common.Event;
import com.android.tonight8.model.common.PopGoods;
import com.android.tonight8.model.event.EventRecommendModel;
import com.android.tonight8.storage.DBUtil;
import com.android.tonight8.storage.entity.EventEntity;
import com.android.tonight8.storage.entity.PopGoodsEntity;
import com.lidroid.xutils.db.sqlite.WhereBuilder;

/**
 * @Description:活动推荐数据存取控制类
 * @author:LiXiaoSong
 * @copyright @HiSite
 * @Date:2015-1-20
 */
public class EventRecommendNativeController {

	/**
	 * 保存活动推荐数据
	 * 
	 * @param model
	 *            数据
	 */
	public void insertData(List<EventRecommendModel> models) {
		List<PopGoodsEntity> pEntities = new ArrayList<PopGoodsEntity>();
		List<EventEntity> eEntities = new ArrayList<EventEntity>();
		for (int i = 0; i < models.size(); i++) {
			EventRecommendModel model = models.get(i);
			EventEntity eventEntity = new EventEntity();
			PopGoodsEntity popGoodsEntity = new PopGoodsEntity();
			DBUtil.copyData(PopGoods.class, PopGoodsEntity.class, model.popGoods, popGoodsEntity);
			DBUtil.copyData(Event.class, EventEntity.class, model.event, eventEntity);
			popGoodsEntity.event = eventEntity;
			pEntities.add(popGoodsEntity);
			eEntities.add(eventEntity);
			DBUtil.saveOrUpdate(popGoodsEntity, PopGoodsEntity.class, WhereBuilder.b("rid", "=", eventEntity.getId()), "popGoodsName", "popGoodsPic", "popGoodsPrice");
		}
		DBUtil.saveOrUpdateAll(eEntities, EventEntity.class, "name");
	}

	/**
	 * @param id
	 *            获取活动推荐数据
	 * @return 返回的数据
	 */
	public List<EventRecommendModel> selectData(long eventId) {
		List<EventRecommendModel> models = new ArrayList<EventRecommendModel>();
		List<PopGoodsEntity> popGoodsEntities = DBUtil.getData(PopGoodsEntity.class, "rid = " + eventId);
		if (popGoodsEntities != null) {
			for (int i = 0; i < popGoodsEntities.size(); i++) {
				EventRecommendModel model = new EventRecommendModel();
				PopGoods popGoods = new PopGoods();
				Event event = new Event();
				DBUtil.copyData(PopGoodsEntity.class, PopGoods.class, popGoodsEntities.get(i), popGoods);
				DBUtil.copyData(EventEntity.class, Event.class, popGoodsEntities.get(i).event, event);
				model.event = event;
				model.popGoods = popGoods;
				models.add(model);
			}
		}
		return models;
	}

	/**
	 * 更新
	 * 
	 * @param model
	 * @param id
	 */
	public void update(EventRecommendModel model, long id) {

	}

	/**
	 * @Description:删除推荐活动数据，根据id值删除，若id为-1，则删除所有条目
	 * @param id
	 *            要删除的id值
	 * @author: LiXiaoSong
	 * @date:2015-1-21
	 */
	public void delete(long id) {

	}
}
