package com.android.tonight8.model.common;

import java.io.Serializable;
/**
 * @Descripton 兑奖地址
 * @author LiXiaoSong
 * @2015-2-10
 * @Tonight8
 */
public class ExchangeAddress implements Serializable{
	private static final long serialVersionUID = 1L;
	public int id;
	/**
	 * 城市外键
	 */
	public int rid;
	/**
	 * 地址
	 */
	public String address;
	/**
	 * 经纬度
	 */
	public String coordinate;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getRid() {
		return rid;
	}
	public void setRid(int rid) {
		this.rid = rid;
	}
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
		return "ExchangeAddress [id=" + id + ", rid=" + rid + ", address="
				+ address + ", coordinate=" + coordinate + "]";
	}
	
	
}
