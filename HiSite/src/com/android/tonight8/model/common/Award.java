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
	/** 中奖活动外键*/
	public int rid;
	/** 用户外键*/
	public int uid;
	/** 中奖号码 */
	public String code;
	/** 签到状态 */
	public int signInStatus;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	

	public int getRid() {
		return rid;
	}

	public void setRid(int rid) {
		this.rid = rid;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

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
		return "Award [id=" + id + ", code=" + code + ", exchangeStatus=" + signInStatus + "]";
	}

}
