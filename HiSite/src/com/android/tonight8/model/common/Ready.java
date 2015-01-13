package com.android.tonight8.model.common;

import java.io.Serializable;

/**
 * 准备发布活动对象
 * 
 * @author LiXiaoSong
 * 
 */
public class Ready implements Serializable {

	private static final long serialVersionUID = 1L;
	/** 活动准备上架时间 */
	public String publishTime;
	/** 活动举办开始日期 */
	public String liveDateStart;
	/** 活动举办开始时间 */
	public String liveTimeStart;
	/** 活动举办结束日期 */
	public String liveDateEnd;
	/** 活动举办结束时间 */
	public String liveTimeEnd;
	/** 活动没中奖用户是否发放券 */
	public boolean isCouponNoneAward;

	public String getPublishTime() {
		return publishTime;
	}

	public void setPublishTime(String publishTime) {
		this.publishTime = publishTime;
	}

	public String getLiveDateStart() {
		return liveDateStart;
	}

	public void setLiveDateStart(String liveDateStart) {
		this.liveDateStart = liveDateStart;
	}

	public String getLiveTimeStart() {
		return liveTimeStart;
	}

	public void setLiveTimeStart(String liveTimeStart) {
		this.liveTimeStart = liveTimeStart;
	}

	public String getLiveDateEnd() {
		return liveDateEnd;
	}

	public void setLiveDateEnd(String liveDateEnd) {
		this.liveDateEnd = liveDateEnd;
	}

	public String getLiveTimeEnd() {
		return liveTimeEnd;
	}

	public void setLiveTimeEnd(String liveTimeEnd) {
		this.liveTimeEnd = liveTimeEnd;
	}

	public boolean getIsCouponNoneAward() {
		return isCouponNoneAward;
	}

	public void setIsCouponNoneAward(boolean isCouponNoneAward) {
		this.isCouponNoneAward = isCouponNoneAward;
	}

	@Override
	public String toString() {
		return "Ready [publishTime=" + publishTime + ", liveDateStart="
				+ liveDateStart + ", liveTimeStart=" + liveTimeStart
				+ ", liveDateEnd=" + liveDateEnd + ", liveTimeEnd="
				+ liveTimeEnd + ", isCouponNoneAward=" + isCouponNoneAward
				+ "]";
	}

}
