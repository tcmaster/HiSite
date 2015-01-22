/**
 * 2015-1-21
 */
package com.android.tonight8.storage.event;

import java.util.ArrayList;
import java.util.List;

import com.android.tonight8.model.common.Coupon;
import com.android.tonight8.model.common.Event;
import com.android.tonight8.model.common.Exchange;
import com.android.tonight8.model.common.Org;
import com.android.tonight8.model.event.EventListModel;
import com.android.tonight8.storage.DBUtil;
import com.android.tonight8.storage.entity.CouponEntity;
import com.android.tonight8.storage.entity.EventEntity;
import com.android.tonight8.storage.entity.ExchangeEntity;
import com.android.tonight8.storage.entity.OrgEntity;

/**
 * @Description:开奖列表本地数据控制
 * @author:LiXiaoSong
 * @copyright @HiSite
 * @Date:2015-1-21
 */
public class EventListNativeController {

	public void insertData(List<EventListModel> models) {
		List<EventEntity> eventEntities = new ArrayList<EventEntity>();
		List<OrgEntity> orgEntities = new ArrayList<OrgEntity>();
		List<CouponEntity> couponEntities = new ArrayList<CouponEntity>();
		List<ExchangeEntity> exchangeEntities = new ArrayList<ExchangeEntity>();
		for (int i = 0; i < models.size(); i++) {
			EventListModel model = models.get(i);
			EventEntity eventEntity = new EventEntity();
			OrgEntity orgEntity = new OrgEntity();
			CouponEntity couponEntity = new CouponEntity();
			ExchangeEntity exchangeEntity = new ExchangeEntity();
			// 数据存储
			DBUtil.copyData(Event.class, EventEntity.class, model.event, eventEntity);
			DBUtil.copyData(Org.class, OrgEntity.class, model.org, orgEntity);
			DBUtil.copyData(Coupon.class, CouponEntity.class, model.coupon, couponEntity);
			DBUtil.copyData(Exchange.class, ExchangeEntity.class, model.exchange, exchangeEntity);
			// 外键连接
			eventEntity.org = orgEntity;
			couponEntity.event = eventEntity;
			exchangeEntity.event = eventEntity;
			// 增加数据，加入表中
			eventEntities.add(eventEntity);
			orgEntities.add(orgEntity);
			couponEntities.add(couponEntity);
			exchangeEntities.add(exchangeEntity);
		}
		DBUtil.saveOrUpdateAll(eventEntities);
		DBUtil.saveOrUpdateAll(orgEntities);
		DBUtil.saveOrUpdateAll(couponEntities);
		DBUtil.saveOrUpdateAll(exchangeEntities);
	}

	/**
	 * @Description: 获取所有的活动列表，暂时按活动开始时间戳排序
	 * @return 排序好的数据
	 * @author: LiXiaoSong
	 * @date:2015-1-21
	 */
	public List<EventListModel> selectData() {
		List<EventListModel> models = new ArrayList<EventListModel>();
		List<EventEntity> eventEntities = DBUtil.getData(EventEntity.class, "order by timeStamp desc");
		for (int i = 0; i < eventEntities.size(); i++) {
			EventListModel model = new EventListModel();
			EventEntity eventEntity = eventEntities.get(i);
			OrgEntity orgEntity = eventEntity.org;
			CouponEntity couponEntity = DBUtil.getDataFirst(CouponEntity.class, "rid = " + eventEntity.getId());
			ExchangeEntity exchangeEntity = DBUtil.getDataFirst(ExchangeEntity.class, "rid = " + eventEntity.getId());
			Event event = new Event();
			Org org = new Org();
			Coupon coupon = new Coupon();
			Exchange exchange = new Exchange();
			DBUtil.copyData(EventEntity.class, Event.class, eventEntity, event);
			DBUtil.copyData(OrgEntity.class, Org.class, orgEntity, org);
			DBUtil.copyData(CouponEntity.class, Coupon.class, couponEntity, coupon);
			DBUtil.copyData(ExchangeEntity.class, Exchange.class, exchangeEntity, exchange);
			model.event = event;
			model.org = org;
			model.coupon = coupon;
			model.exchange = exchange;
			models.add(model);
		}
		return models;
	}

	public void deleteAll() {
	}
}
