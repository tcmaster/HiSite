/**
 * 2015-1-20
 */
package com.android.tonight8.storage.event;

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
public class RecommendDBController {
	/**
	 * 保存活动推荐数据
	 * @param model 数据
	 */
	public void saveData(EventRecommendModel model) {
		EventRecommendEntity recommend = new EventRecommendEntity();
		recommend.setName(model.name);
		PopGoodsEntity goods = new PopGoodsEntity();
		//查询是否有该活动，有的话，更新数据
		EventEntity hasEvent = DBUtil.getDataFirst(EventEntity.class,"id = "+model.getId());
		EventEntity eventEntity = null;
		if(hasEvent == null){
			eventEntity = new EventEntity();
			eventEntity.setId(model.getId());
			eventEntity.setName(model.name);
		}else {
			eventEntity = hasEvent;
		}
		recommend.event = eventEntity;
		PopGoodsEntity hasPopGoods = DBUtil.getDataFirst(PopGoodsEntity.class,"id = "+model.popGoods.id);
		PopGoodsEntity popGoodsEntity = null;
		if(hasPopGoods == null){
			popGoodsEntity = new PopGoodsEntity();
			DBUtil.copyData(PopGoods.class, PopGoodsEntity.class,model.popGoods,popGoodsEntity);
		}
		recommend.event = eventEntity;
		recommend.popGoods = popGoodsEntity;
		DBUtil.copyData(PopGoods.class, PopGoodsEntity.class, model.popGoods,goods);
		DBUtil.addData(recommend);
		DBUtil.addData(goods);
		DBUtil.addData(eventEntity);
	}
	/**
	 * @param id 获取活动推荐数据
	 * @return 返回的数据
	 */
	public EventRecommendModel getData(long id) {
		EventRecommendModel model = new EventRecommendModel();
		List<EventRecommendEntity> data = DBUtil.getData(EventRecommendEntity.class, "id = " + id);
		if (data != null && data.size() != 0) {
			EventRecommendEntity recommend = data.get(0);
			PopGoods goods = new PopGoods();
			DBUtil.copyData(PopGoodsEntity.class,PopGoods.class,recommend.popGoods,goods);
			model.popGoods = goods;
		}
		return model;
	}
	/**
	 * 
	 * @param model 
	 * @param id
	 */
	public void update(EventRecommendModel model,long id){
		
	}
	public void delete(long id){
		
	}
}
