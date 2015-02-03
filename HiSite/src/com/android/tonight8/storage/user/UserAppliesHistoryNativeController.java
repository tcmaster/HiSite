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
import com.android.tonight8.storage.entity.OrgEntity;
import com.android.tonight8.storage.entity.PopGoodsEntity;
import com.android.tonight8.storage.entity.UserEntity;

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
		for (int i = 0; i < models.size(); i++) {
			UserApplyHistoryModel model = models.get(i);
			EventEntity eventEntity = new EventEntity();
			CouponEntity couponEntity = new CouponEntity();
			PopGoodsEntity popGoodsEntity = new PopGoodsEntity();
			DBUtil.copyData(Event.class, EventEntity.class, model.event, eventEntity);
			DBUtil.copyData(Coupon.class, CouponEntity.class, model.coupon, couponEntity);
			DBUtil.copyData(PopGoods.class, PopGoodsEntity.class, model.popGoods, popGoodsEntity);
			couponEntity.event = eventEntity;
			couponEntity.user = DBUtil.getDataFirst(UserEntity.class, "id = " + model.coupon.uid);
			popGoodsEntity.event = eventEntity;
			eventEntity.org = DBUtil.getDataFirst(OrgEntity.class, "id =" + model.event.rid);
			eventEntities.add(eventEntity);
			couponEntities.add(couponEntity);
			DBUtil.saveOrUpdate(popGoodsEntity, PopGoodsEntity.class, "rid = " + eventEntity.getId(), "popGoodsName", "popGoodsPic", "popGoodsPrice");
		}
		DBUtil.saveOrUpdateAll(eventEntities, EventEntity.class, "name", "winningStatus", "distance", "winningLimit", "applyCount", "rid");
		DBUtil.saveOrUpdateAll(couponEntities, CouponEntity.class, "provideType", "provideNum", "provideAll", "rid", "uid");
	}

	/**
	 * @Description:获取用户抽奖历史
	 * @param userId
	 *            用户id
	 * @author: LiXiaoSong
	 * @date:2015-1-26
	 */
	public List<UserApplyHistoryModel> selectData(long userId) {
		List<UserApplyHistoryModel> models = new ArrayList<UserApplyHistoryModel>();
		List<CouponEntity> couponEntities = DBUtil.getData(CouponEntity.class, "uid = " + userId);
		for (int i = 0; i < couponEntities.size(); i++) {
			UserApplyHistoryModel model = new UserApplyHistoryModel();
			CouponEntity couponEntity = couponEntities.get(i);
			EventEntity eventEntity = couponEntity.event;
			PopGoodsEntity popGoodsEntity = DBUtil.getDataFirst(PopGoodsEntity.class, "rid = " + eventEntity.getId());
			Coupon coupon = new Coupon();
			Event event = new Event();
			PopGoods popGoods = new PopGoods();
			DBUtil.copyData(PopGoodsEntity.class, PopGoods.class, popGoodsEntity, popGoods);
			DBUtil.copyData(CouponEntity.class, Coupon.class, couponEntity, coupon);
			DBUtil.copyData(EventEntity.class, Event.class, eventEntity, event);
			model.coupon = coupon;
			model.event = event;
			model.popGoods = popGoods;
			models.add(model);
		}
		return models;
	}
}
