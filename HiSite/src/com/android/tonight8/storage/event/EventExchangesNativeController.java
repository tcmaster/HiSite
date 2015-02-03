/**
 * 2015-1-22
 */
package com.android.tonight8.storage.event;

import java.util.ArrayList;
import java.util.List;

import com.android.tonight8.model.common.Exchange;
import com.android.tonight8.model.common.Org;
import com.android.tonight8.model.event.EventExchangeModel;
import com.android.tonight8.storage.DBUtil;
import com.android.tonight8.storage.entity.EventEntity;
import com.android.tonight8.storage.entity.ExchangeEntity;
import com.android.tonight8.storage.entity.OrgEntity;
import com.lidroid.xutils.db.sqlite.WhereBuilder;

/**
 * @Description: 活动开奖地址
 * @author:LiXiaoSong
 * @copyright @HiSite
 * @Date:2015-1-22
 */
public class EventExchangesNativeController {

	/**
	 * @Description: 存储活动开奖地址列表
	 * @param models
	 *            活动实体
	 * @param eventId
	 *            活动id
	 * @author: LiXiaoSong
	 * @date:2015-1-23
	 */
	public void insertData(List<EventExchangeModel> models, long eventId) {
		List<OrgEntity> orgEntities = new ArrayList<OrgEntity>();
		for (int i = 0; i < models.size(); i++) {
			ExchangeEntity exchangeEntity = new ExchangeEntity();
			OrgEntity orgEntity = new OrgEntity();
			DBUtil.copyData(Exchange.class, ExchangeEntity.class, models.get(i).exchange, exchangeEntity);
			DBUtil.copyData(Org.class, OrgEntity.class, models.get(i).org, orgEntity);
			exchangeEntity.event = DBUtil.getDataFirst(EventEntity.class, "id = " + eventId);
			if (exchangeEntity.event != null) {
				exchangeEntity.event.org = orgEntity;
			}
			DBUtil.saveOrUpdate(exchangeEntity, ExchangeEntity.class, WhereBuilder.b("rid", "=", eventId), "method", "address", "orgAll");
			orgEntities.add(orgEntity);
		}
		DBUtil.saveOrUpdateAll(orgEntities, OrgEntity.class, "name", "address", "telphone", "distance");
	}

	/**
	 * @Description: 得到活动开奖地址列表
	 * @param eventId
	 *            活动id
	 * @return 开奖列表
	 * @author: LiXiaoSong
	 * @date:2015-1-23
	 */
	public List<EventExchangeModel> selectData(long eventId) {
		List<EventExchangeModel> models = new ArrayList<EventExchangeModel>();
		EventEntity eventEntity = DBUtil.getDataFirst(EventEntity.class, "id = " + eventId);
		List<ExchangeEntity> exchangeEntities = DBUtil.getData(ExchangeEntity.class, "rid = " + eventEntity.getId());
		for (int i = 0; i < exchangeEntities.size(); i++) {
			EventExchangeModel model = new EventExchangeModel();
			Exchange exchange = new Exchange();
			Org org = new Org();
			DBUtil.copyData(ExchangeEntity.class, Exchange.class, exchangeEntities.get(i), exchange);
			DBUtil.copyData(OrgEntity.class, Org.class, exchangeEntities.get(i).event.org, org);
			model.exchange = exchange;
			model.org = org;
			models.add(model);
		}
		return models;
	}
}
