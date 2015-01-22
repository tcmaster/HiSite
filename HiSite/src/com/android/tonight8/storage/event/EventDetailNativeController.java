/**
 * 2015-1-21
 */
package com.android.tonight8.storage.event;

import java.util.ArrayList;
import java.util.List;

import com.android.tonight8.model.common.Coupon;
import com.android.tonight8.model.common.Event;
import com.android.tonight8.model.common.Goods;
import com.android.tonight8.model.common.Org;
import com.android.tonight8.model.event.EventDetailModel;
import com.android.tonight8.storage.DBUtil;
import com.android.tonight8.storage.entity.CouponEntity;
import com.android.tonight8.storage.entity.EventEntity;
import com.android.tonight8.storage.entity.GoodsEntity;
import com.android.tonight8.storage.entity.OrgEntity;

/**
 * @Description:活动详情本地控制类
 * @author:LiXiaoSong
 * @copyright @HiSite
 * @Date:2015-1-21
 */
public class EventDetailNativeController {

	/**
	 * @Description:存储一个活动详情
	 * @param model
	 *            要存储的model
	 * @author: LiXiaoSong
	 * @date:2015-1-22
	 */
	public void insertData(EventDetailModel model) {
		EventEntity eventEntity = new EventEntity();
		OrgEntity orgEntity = new OrgEntity();
		CouponEntity couponEntity = new CouponEntity();
		List<GoodsEntity> goodsEntities = new ArrayList<GoodsEntity>();
		List<Goods> goodses = model.goodses;
		DBUtil.copyData(Event.class, EventEntity.class, model.event, eventEntity);
		DBUtil.copyData(Org.class, OrgEntity.class, model.org, orgEntity);
		DBUtil.copyData(Coupon.class, CouponEntity.class, model.coupon, couponEntity);
		eventEntity.org = orgEntity;
		couponEntity.event = eventEntity;
		for (int i = 0; i < goodses.size(); i++) {
			GoodsEntity goodsEntity = new GoodsEntity();
			DBUtil.copyData(Goods.class, GoodsEntity.class, goodses.get(i), goodsEntity);
			goodsEntity.event = eventEntity;
			goodsEntities.add(goodsEntity);
		}
		DBUtil.saveOrUpdate(eventEntity);
		DBUtil.saveOrUpdate(orgEntity);
		DBUtil.saveOrUpdate(couponEntity);
		DBUtil.saveOrUpdateAll(goodsEntities);
	}

	/**
	 * @Description:根据活动id得到活动详情
	 * @param id
	 *            活动的id
	 * @author: LiXiaoSong
	 * @date:2015-1-22
	 */
	public EventDetailModel selectData(long id) {
		EventDetailModel model = new EventDetailModel();
		Event event = new Event();
		Org org = new Org();
		Coupon coupon = new Coupon();
		List<Goods> goodses = new ArrayList<Goods>();
		EventEntity eventEntity = DBUtil.getDataFirst(EventEntity.class, "id = " + id);
		OrgEntity orgEntity = eventEntity.org;
		CouponEntity couponEntity = DBUtil.getDataFirst(CouponEntity.class, "rid = " + eventEntity.getId());
		List<GoodsEntity> goodsEntities = DBUtil.getData(GoodsEntity.class, "rid = " + event.getId());
		DBUtil.copyData(EventEntity.class, Event.class, eventEntity, event);
		DBUtil.copyData(OrgEntity.class, Org.class, orgEntity, org);
		DBUtil.copyData(CouponEntity.class, Coupon.class, couponEntity, coupon);
		for (int i = 0; i < goodsEntities.size(); i++) {
			Goods goods = new Goods();
			DBUtil.copyData(GoodsEntity.class, Goods.class, goodsEntities.get(i), goods);
			goodses.add(goods);
		}
		model.event = event;
		model.org = org;
		model.coupon = coupon;
		model.goodses = goodses;
		return model;
	}
}
