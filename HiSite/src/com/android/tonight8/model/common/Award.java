package com.android.tonight8.model.common;

import java.io.Serializable;

/**
 * @Description:中奖对象
 * @author:LiXiaoSong
 * @copyright @HiSite
 * @Date:2015-1-13
 */
public class Award implements Serializable {

	private static final long serialVersionUID = 1L;
	/** 中奖id */
	public long id;
	/** 中奖号码 */
	public String code;
	/** 中奖兑奖状态 */
	public int exchangeStatus;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public int getExchangeStatus() {
		return exchangeStatus;
	}

	public void setExchangeStatus(int exchangeStatus) {
		this.exchangeStatus = exchangeStatus;
	}

	@Override
	public String toString() {
		return "Award [id=" + id + ", code=" + code + ", exchangeStatus=" + exchangeStatus + "]";
	}

}
