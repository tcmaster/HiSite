/**
 * 2015-1-20
 */
package com.android.tonight8.storage.event;

import java.util.ArrayList;
import java.util.List;

import com.android.tonight8.model.common.PopGoods;
import com.android.tonight8.model.event.EventRecommendModel;
import com.android.tonight8.storage.DBUtil;
import com.android.tonight8.storage.entity.EventEntity;
import com.android.tonight8.storage.entity.EventRecommendEntity;
import com.android.tonight8.storage.entity.PopGoodsEntity;

/**
 * @Description:活动推荐数据存取控制类
 * @author:LiXiaoSong
 * @copyright @HiSite
 * @Date:2015-1-20
 */
public class RecommendNativeController {

	/**
	 * 保存活动推荐数据
	 * 
	 * @param model
	 *            数据
	 */
	public void insertData(List<EventRecommendModel> models) {
		List<EventRecommendEntity> entities = new ArrayList<EventRecommendEntity>();
		List<PopGoodsEntity> pEntities = new ArrayList<PopGoodsEntity>();
		for (int i = 0; i < models.size(); i++) {
			EventRecommendEntity entity = new EventRecommendEntity();
			EventRecommendModel model = models.get(i);
			// 查询是否有该活动，有的话，更新数据
			EventEntity hasEvent = DBUtil.getDataFirst(EventEntity.class, "id = " + model.getId());
			PopGoodsEntity popGoodsEntity = null;
			popGoodsEntity = new PopGoodsEntity();
			DBUtil.copyData(PopGoods.class, PopGoodsEntity.class, model.popGoods, popGoodsEntity);
			popGoodsEntity.event = hasEvent;
			pEntities.add(popGoodsEntity);
			DBUtil.copyData(EventRecommendModel.class, EventRecommendEntity.class, model, entity);
			entity.popGoods = popGoodsEntity;
			entity.popGoods.event = hasEvent;
			entities.add(entity);
		}
		DBUtil.saveOrUpdateAll(pEntities);
		DBUtil.addDataAll(entities);
	}

	/**
	 * @param id
	 *            获取活动推荐数据
	 * @return 返回的数据
	 */
	public List<EventRecommendModel> selectData() {
		List<EventRecommendModel> models = new ArrayList<EventRecommendModel>();
		List<EventRecommendEntity> entities = DBUtil.getData(EventRecommendEntity.class);
		if (entities != null) {
			for (int i = 0; i < entities.size(); i++) {
				EventRecommendEntity entity = entities.get(i);
				EventRecommendModel model = new EventRecommendModel();
				if (entity != null) {
					PopGoods goods = new PopGoods();
					DBUtil.copyData(PopGoodsEntity.class, PopGoods.class, entity.popGoods, goods);
					model.popGoods = goods;
					DBUtil.copyData(EventRecommendEntity.class, EventRecommendModel.class, entity, model);
					models.add(model);
				}
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
		if (id == -1) {
			DBUtil.deleteData(EventRecommendEntity.class);
		} else {
			DBUtil.deleteData(EventRecommendEntity.class, id);
		}
	}
}
