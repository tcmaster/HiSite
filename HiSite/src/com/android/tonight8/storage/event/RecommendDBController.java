/**
 * 2015-1-20
 */
package com.android.tonight8.storage.event;

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
public class RecommendDBController {

	/**
	 * 保存活动推荐数据
	 * 
	 * @param model
	 *            数据
	 */
	public void saveData(EventRecommendModel model) {
		EventRecommendEntity entity = new EventRecommendEntity();
		// 查询是否有该活动，有的话，更新数据
		EventEntity hasEvent = DBUtil.getDataFirst(EventEntity.class, "id = " + model.getId());
		PopGoodsEntity hasPopGoods = DBUtil.getDataFirst(PopGoodsEntity.class, "id = " + model.popGoods.id);
		PopGoodsEntity popGoodsEntity = null;
		if (hasPopGoods == null) {
			popGoodsEntity = new PopGoodsEntity();
			DBUtil.copyData(PopGoods.class, PopGoodsEntity.class, model.popGoods, popGoodsEntity);
		}
		DBUtil.copyData(EventRecommendModel.class, EventRecommendEntity.class, model, entity);
		entity.popGoods = popGoodsEntity;
		if (hasEvent != null)
			entity.popGoods.event = hasEvent;
		DBUtil.addData(popGoodsEntity);
		DBUtil.addData(entity);
	}

	/**
	 * @param id
	 *            获取活动推荐数据
	 * @return 返回的数据
	 */
	public EventRecommendModel getData(long id) {
		EventRecommendModel model = new EventRecommendModel();
		EventRecommendEntity entity = DBUtil.getDataFirst(EventRecommendEntity.class, "id = " + id);
		if (entity != null) {
			PopGoods goods = new PopGoods();
			DBUtil.copyData(PopGoodsEntity.class, PopGoods.class, entity.popGoods, goods);
			model.popGoods = goods;
			DBUtil.copyData(EventRecommendEntity.class, EventRecommendModel.class, entity, model);
		}
		return model;
	}

	/**
	 * 
	 * @param model
	 * @param id
	 */
	public void update(EventRecommendModel model, long id) {

	}

	public void delete(long id) {

	}
}
