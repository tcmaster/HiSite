/**
 * 2015-1-22
 */
package com.android.tonight8.storage.event;

import java.util.ArrayList;
import java.util.List;

import com.android.tonight8.model.common.Apply;
import com.android.tonight8.model.common.Award;
import com.android.tonight8.model.common.Exchange;
import com.android.tonight8.model.event.EventAwardModel;
import com.android.tonight8.storage.DBUtil;
import com.android.tonight8.storage.entity.ApplyEntity;
import com.android.tonight8.storage.entity.AwardEntity;
import com.android.tonight8.storage.entity.ExchangeEntity;

/**
 * @Description:
 * @author:LiXiaoSong
 * @see:
 * @since:
 * @copyright @HiSite
 * @Date:2015-1-22
 */
public class EventExchangesNativeController {

	/**
	 * @Description: 活动中奖名单列表存入
	 * @param models
	 * @author: LiXiaoSong
	 * @date:2015-1-22
	 */
	public void insertData(List<EventAwardModel> models) {
		List<AwardEntity> awardEntities = new ArrayList<AwardEntity>();
		List<ApplyEntity> applyEntities = new ArrayList<ApplyEntity>();
		List<ExchangeEntity> exchangeEntities = new ArrayList<ExchangeEntity>();
		for (int i = 0; i < models.size(); i++) {
			AwardEntity awardEntity = new AwardEntity();
			ApplyEntity applyEntity = new ApplyEntity();
			ExchangeEntity exchangeEntity = new ExchangeEntity();
			DBUtil.copyData(Award.class, AwardEntity.class, models.get(i).award, awardEntity);
			DBUtil.copyData(Apply.class, ApplyEntity.class, models.get(i).apply, applyEntity);
			DBUtil.copyData(Exchange.class, ExchangeEntity.class, models.get(i).exchange, exchangeEntity);

		}
		DBUtil.saveOrUpdate(awardEntities);
		DBUtil.saveOrUpdate(applyEntities);
		DBUtil.saveOrUpdate(exchangeEntities);
	}

	/**
	 * @Description: 活动中奖名单列表取出
	 * @param models
	 * @author: LiXiaoSong
	 * @date:2015-1-22
	 */
	public List<EventAwardModel> selectData(long eventid) {
		List<EventAwardModel> models = new ArrayList<EventAwardModel>();

		return models;
	}
}
