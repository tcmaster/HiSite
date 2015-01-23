package com.android.tonight8.storage.entity;

import com.lidroid.xutils.db.annotation.Column;
import com.lidroid.xutils.db.annotation.Foreign;
import com.lidroid.xutils.db.annotation.NotNull;
import com.lidroid.xutils.db.annotation.Table;

@Table(name = "award")
public class AwardEntity extends BaseEntity {

	/** 中奖号码 */
	@NotNull()
	@Column(column = "code")
	private String code;
	/** 中奖兑奖状态 */
	@NotNull()
	@Column(column = "exchangeStatus", defaultValue = "0")
	private int exchangeStatus;
	@Foreign(column = "rid", foreign = "id")
	public EventEntity event;
	@Foreign(column = "uid", foreign = "id")
	public UserEntity user;

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
		return "Award [code=" + code + ", exchangeStatus=" + exchangeStatus + ", event=" + event + ", user=" + user + "]";
	}

}
