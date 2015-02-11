package com.android.tonight8.model.common;

import java.io.Serializable;
/**
 * 
 * @Descripton 兑奖城市
 * @author LiXiaoSong
 * @2015-2-10
 * @Tonight8
 */
public class ExchangeCity implements Serializable{

	private static final long serialVersionUID = 1L;
	public int id;
	/**
	 * 兑奖外键
	 */
	public int rid;
	/**
	 * 城市编码
	 */
	public String cityCode;
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
	public String getCityCode() {
		return cityCode;
	}
	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}
	@Override
	public String toString() {
		return "ExchangeCity [id=" + id + ", rid=" + rid + ", cityCode="
				+ cityCode + "]";
	}
	
}
