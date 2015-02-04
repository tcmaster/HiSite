package com.android.tonight8.storage.user;

import java.util.ArrayList;
import java.util.List;

import android.database.Cursor;

import com.android.tonight8.model.common.Event;
import com.android.tonight8.model.common.Exchange;
import com.android.tonight8.model.common.Org;
import com.android.tonight8.model.user.UserExchangeModel;
import com.android.tonight8.storage.DBUtil;
import com.android.tonight8.storage.entity.EventEntity;
import com.android.tonight8.storage.entity.ExchangeEntity;
import com.android.tonight8.storage.entity.OrgEntity;
import com.lidroid.xutils.db.sqlite.WhereBuilder;
import com.lidroid.xutils.exception.DbException;

/**
 * 
 * @Descripton 用户中奖码兑换本地存储控制类
 * @author LiXiaoSong
 * @2015-1-24
 * @Tonight8
 */
public class UserExchangeNativeController {

	/**
	 * 存储用户中奖码兑换详情实体
	 * 
	 * @param models
	 */
	public void insertData(UserExchangeModel model) {
		ExchangeEntity exchangeEntity = new ExchangeEntity();
		List<OrgEntity> orgEntities = new ArrayList<OrgEntity>();
		EventEntity eventEntity = new EventEntity();
		DBUtil.copyData(Exchange.class, ExchangeEntity.class, model.exchange, exchangeEntity);
		DBUtil.copyData(Event.class, EventEntity.class, model.event, eventEntity);
		exchangeEntity.event = eventEntity;
		for (int i = 0; i < model.orgs.size(); i++) {
			OrgEntity orgEntity = new OrgEntity();
			DBUtil.copyData(Org.class, OrgEntity.class, model.orgs.get(i), orgEntity);
			orgEntities.add(orgEntity);
		}
		DBUtil.saveOrUpdate(exchangeEntity, ExchangeEntity.class, WhereBuilder.b("rid", "=", eventEntity.getId()), "method", "address", "orgAll", "rid");
		DBUtil.saveOrUpdate(eventEntity, Event.class, "name", "timeRangeStart", "timeRangeEnd");
		DBUtil.saveOrUpdateAll(orgEntities, OrgEntity.class, "name", "address");
	}

	/**
	 * 根据活动获取用户中奖码兑换详情
	 * 
	 * @param eventId
	 *            活动id
	 */
	public UserExchangeModel selectData(long eventId) {
		UserExchangeModel model = new UserExchangeModel();
		EventEntity eventEntity = DBUtil.getDataFirst(EventEntity.class, "id = " + eventId);
		ExchangeEntity exchangeEntity = DBUtil.getDataFirst(ExchangeEntity.class, "rid = " + eventId);
		/** 自定义查询与添加 */
		Cursor cursor = null;
		try {
			cursor = DBUtil.getDB().execQuery("select bindTree.childId as child from org join bindTree on bindTree.parentId = org.id where org.id = " + exchangeEntity.event.org);
		} catch (DbException e) {
			e.printStackTrace();
		}
		Exchange exchange = new Exchange();
		Event event = new Event();
		DBUtil.copyData(EventEntity.class, Event.class, eventEntity, event);
		DBUtil.copyData(ExchangeEntity.class, Exchange.class, exchangeEntity, exchange);
		if (cursor != null) {
			List<Long> orgIds = new ArrayList<Long>();
			while (cursor.moveToNext()) {
				orgIds.add(cursor.getLong(cursor.getColumnIndex("child")));
			}
			List<OrgEntity> orgEntities = new ArrayList<OrgEntity>();
			for (int i = 0; i < orgIds.size(); i++) {
				orgEntities.add(DBUtil.getDataFirst(OrgEntity.class, "id = " + orgIds.get(i)));
			}
			List<Org> orgs = new ArrayList<Org>();
			for (int i = 0; i < orgEntities.size(); i++) {
				Org org = new Org();
				DBUtil.copyData(OrgEntity.class, Org.class, orgEntities.get(i), org);
				orgs.add(org);
			}
			model.orgs = orgs;
		}
		model.event = event;
		model.exchange = exchange;
		return model;
	}
}
