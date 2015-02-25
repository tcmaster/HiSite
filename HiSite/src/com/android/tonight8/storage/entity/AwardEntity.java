package com.android.tonight8.storage.entity;

import com.lidroid.xutils.db.annotation.Column;
import com.lidroid.xutils.db.annotation.Foreign;
import com.lidroid.xutils.db.annotation.Table;

/**
 * @Description:领奖
 * @author:LiXiaoSong
 * @copyright @HiSite
 * @Date:2015-2-25
 */
@Table(name = "award")
public class AwardEntity extends BaseEntity {

	/** 中奖号码 */
	@Column(column = "code")
	private String code;
	/** 签到状态 */
	@Column(column = "signInStatus", defaultValue = "0")
	private int signInStatus;
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

	public int getSignInStatus() {
		return signInStatus;
	}

	public void setSignInStatus(int signInStatus) {
		this.signInStatus = signInStatus;
	}

	@Override
	public String toString() {
		return "Award [code=" + code + ", exchangeStatus=" + signInStatus + ", event=" + event + ", user=" + user + "]";
	}

}
