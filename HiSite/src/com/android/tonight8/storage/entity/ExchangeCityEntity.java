package com.android.tonight8.storage.entity;

import com.lidroid.xutils.db.annotation.Foreign;
import com.lidroid.xutils.db.annotation.Table;

/**
 * @Descripton 兑奖城市
 * @author LiXiaoSong
 * @2015-2-10
 * @Tonight8
 */
@Table(name="exchangeCity")
public class ExchangeCityEntity extends BaseEntity{
	/**活动外键*/
	@Foreign(column="rid",foreign="id")
	private EventEntity event;
	/**城市外键*/
	@Foreign(column="city_code",foreign="code")
	private RegionalEntity regionalEntity;
	@Override
	public String toString() {
		return "ExchangeCityEntity [event=" + event + ", regionalEntity="
				+ regionalEntity + "]";
	}
	
}
