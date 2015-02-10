package com.android.tonight8.storage.entity;

import com.lidroid.xutils.db.annotation.Column;
import com.lidroid.xutils.db.annotation.Foreign;
import com.lidroid.xutils.db.annotation.Table;

/**
 * @Descripton 兑奖地址
 * @author LiXiaoSong
 * @2015-2-10
 * @Tonight8
 */
@Table(name = "exchangeAddress")
public class ExchangeAddressEntity extends BaseEntity {
	/** 城市外键 */
	@Foreign(column = "rid", foreign = "id")
	private ExchangeCityEntity exchangeCity;
	/** 具体地址 */
	@Column(column = "address")
	private String address;
	/** 经纬度 */
	@Column(column = "coordinate")
	private String coordinate;

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCoordinate() {
		return coordinate;
	}

	public void setCoordinate(String coordinate) {
		this.coordinate = coordinate;
	}

	@Override
	public String toString() {
		return "ExchangeAddress [exchangeCity=" + exchangeCity + ", address="
				+ address + ", coordinate=" + coordinate + "]";
	}
}
