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
		List<ExchangeEntity> exchangeEntities = new ArrayList<ExchangeEntity>();
		EventEntity eventEntity = DBUtil.getDataFirst(EventEntity.class, "id = " + eventId);
		OrgEntity orgEntity = new OrgEntity();
		DBUtil.copyData(Org.class, OrgEntity.class, models.get(0).getOrg(), orgEntity);
		for (int i = 0; i < models.size(); i++) {
			ExchangeEntity exchangeEntity = new ExchangeEntity();
			DBUtil.copyData(Exchange.class, ExchangeEntity.class, models.get(i).exchange, exchangeEntity);
			exchangeEntity.event = eventEntity;
			exchangeEntity.event.org = orgEntity;
			exchangeEntities.add(exchangeEntity);
		}
		DBUtil.saveOrUpdateAll(exchangeEntities);
		DBUtil.saveOrUpdate(orgEntity);
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
		List<ExchangeEntity> exchangeEntities = DBUtil.getData(ExchangeEntity.class, "rid = " + eventId);
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
