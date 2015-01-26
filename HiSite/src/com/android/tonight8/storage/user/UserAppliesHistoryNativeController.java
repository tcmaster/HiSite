package com.android.tonight8.storage.user;

import java.util.ArrayList;
import java.util.List;

import com.android.tonight8.model.common.Coupon;
import com.android.tonight8.model.common.Event;
import com.android.tonight8.model.common.PopGoods;
import com.android.tonight8.model.user.UserApplyHistoryModel;
import com.android.tonight8.storage.DBUtil;
import com.android.tonight8.storage.entity.CouponEntity;
import com.android.tonight8.storage.entity.EventEntity;
import com.android.tonight8.storage.entity.PopGoodsEntity;

/**
 * @Description: 用户抽奖历史列表
 * @author:LiXiaoSong
 * @copyright @HiSite
 * @Date:2015-1-26
 */
public class UserAppliesHistoryNativeController {

	/**
	 * @Description:存储用户抽奖历史
	 * @param models
	 * @author: LiXiaoSong
	 * @date:2015-1-26
	 */
	public void insertData(List<UserApplyHistoryModel> models) {
		List<EventEntity> eventEntities = new ArrayList<EventEntity>();
		List<CouponEntity> couponEntities = new ArrayList<CouponEntity>();
		List<PopGoodsEntity> popGoodsEntities = new ArrayList<PopGoodsEntity>();
		for (int i = 0; i < models.size(); i++) {
			UserApplyHistoryModel model = models.get(i);
			EventEntity eventEntity = new EventEntity();
			CouponEntity couponEntity = new CouponEntity();
			PopGoodsEntity popGoodsEntity = new PopGoodsEntity();
			DBUtil.copyData(Event.class, EventEntity.class, model.event, eventEntity);
			DBUtil.copyData(Coupon.class, CouponEntity.class, model.coupon, couponEntity);
			DBUtil.copyData(PopGoods.class, PopGoodsEntity.class, model.popGoods, popGoodsEntity);
			couponEntity.event = eventEntity;
			popGoodsEntity.event = eventEntity;
			eventEntities.add(eventEntity);
			couponEntities.add(couponEntity);
			popGoodsEntities.add(popGoodsEntity);
		}
		DBUtil.saveOrUpdateAll(eventEntities);
		DBUtil.saveOrUpdateAll(couponEntities);
		DBUtil.saveOrUpdateAll(popGoodsEntities);
	}

	/**
	 * @Description:没有对应的关系，暂时放置
	 * @param userId
	 * @author: LiXiaoSong
	 * @date:2015-1-26
	 */
	public void selectData(long userId) {

	}
}
