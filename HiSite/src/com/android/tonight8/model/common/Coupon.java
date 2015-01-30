package com.android.tonight8.model.common;

import java.io.Serializable;

/**
 * 
 * @Description:用户持有的优惠券
 * @author:LiXiaoSong
 * @copyright @HiSite
 * @Date:2015-1-13
 */
public class Coupon implements Serializable {

	private static final long serialVersionUID = 1L;
	public long id;
	/** 活动id */
	public int rid;
	/** 用户id */
	public int uid;
	/** 优惠券编码 */
	public String code;
	/** 使用状态 */
	public boolean useStatus;
	/** 二维码 */
	public QuickMark quickMark;

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

	public boolean isUseStatus() {
		return useStatus;
	}

	public void setUseStatus(boolean useStatus) {
		this.useStatus = useStatus;
	}

	public QuickMark getQuickMark() {
		return quickMark;
	}

	public void setQuickMark(QuickMark quickMark) {
		this.quickMark = quickMark;
	}

	@Override
	public String toString() {
		return "Coupon [id=" + id + ", rid=" + rid + ", uid=" + uid + ", code=" + code + ", useStatus=" + useStatus + ", quickMark=" + quickMark + "]";
	}

}
