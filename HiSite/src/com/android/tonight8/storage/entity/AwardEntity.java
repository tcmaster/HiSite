package com.android.tonight8.storage.entity;

import com.lidroid.xutils.db.annotation.Column;
import com.lidroid.xutils.db.annotation.Foreign;
import com.lidroid.xutils.db.annotation.NotNull;

public class AwardEntity extends EntityBaseEntity {
	/** 中奖号码 */
	@NotNull()
	@Column(column = "code")
	public String code;
	/** 中奖兑奖状态 */
	@NotNull()
	@Column(column = "exchangeStatus", defaultValue = "0")
	public int exchangeStatus;
	@Foreign(column = "rid", foreign = "id")
	EventEntity event;
	@Foreign(column = "uid", foreign = "id")
	UserEntity user;

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
		return "Award [code=" + code + ", exchangeStatus=" + exchangeStatus
				+ ", event=" + event + ", user=" + user + "]";
	}

}
