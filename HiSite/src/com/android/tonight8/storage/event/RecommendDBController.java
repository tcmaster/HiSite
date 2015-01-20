/**
 * 2015-1-20
 */
package com.android.tonight8.storage.event;

import java.util.List;

import com.android.tonight8.model.common.Event;
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

	public void saveData(EventRecommendModel model) {
		EventRecommendEntity recommend = new EventRecommendEntity();
		recommend.setId(model.id);
		recommend.setName(model.name);
		PopGoodsEntity goods = new PopGoodsEntity();
		EventEntity eventEntity = new EventEntity();
		DBUtil.copyData(PopGoods.class, PopGoodsEntity.class, model.popGoods,goods);
		//DBUtil.copyData(Event.class, EventEntity.class,model., t2)
		recommend.popGoods = goods;
		// 这里的goods缺少rid
		DBUtil.addData(recommend);
		DBUtil.addData(goods);
		// 这里还应该增加一条event
	}

	public EventRecommendModel getData(long id) {
		EventRecommendModel model = new EventRecommendModel();
		List<EventRecommendEntity> data = DBUtil.getData(EventRecommendEntity.class, "id = " + id);
		if (data != null && data.size() != 0) {
			EventRecommendEntity recommend = data.get(0);
			model.id = recommend.getId();
			model.name = recommend.getName();
			PopGoods goods = new PopGoods();
			DBUtil.copyData(PopGoodsEntity.class,PopGoods.class,recommend.popGoods,goods);
			model.popGoods = goods;
		}
		return model;
	}
	public void update(){
		
	}
	public void delete(){
		
	}
}
