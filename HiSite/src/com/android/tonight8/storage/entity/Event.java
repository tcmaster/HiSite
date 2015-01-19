package com.android.tonight8.storage.entity;

import com.lidroid.xutils.db.annotation.Column;
import com.lidroid.xutils.db.annotation.Foreign;
import com.lidroid.xutils.db.annotation.NotNull;

/** 活动实体 */
public class Event extends EntityBase {
	/** 活动名称 */
	@Column(column = "name")
	@NotNull()
	private String name;
	/** 活动状态 */
	@Column(column = "status", defaultValue = "0")
	@NotNull()
	private int status;
	/** 活动举办开始时间 */
	@Column(column = "timeRangeStart", defaultValue = "0")
	@NotNull()
	private String timeRangeStart;
	/** 活动举办结束时间 */
	@Column(column = "timeRangeEnd")
	@NotNull()
	private String timeRangeEnd;
	/** 活动举办开始时间的时间戳 */
	@Column(column = "timeStamp")
	@NotNull()
	private long timeStamp;
	/** 活动距离 */
	@Column(column = "distance")
	@NotNull()
	private float distance;
	/** 活动上架时间 */
	@Column(column = "publishTime")
	@NotNull()
	private String publishTime;
	/** 活动规则 */
	@Column(column = "ruleDesc")
	@NotNull()
	private String ruleDesc;
	/** 活动中奖状态 */
	@Column(column = "winningStatus", defaultValue = "0")
	@NotNull()
	private boolean winningStatus;
	/** 活动中奖名额 */
	@Column(column = "winningLimit")
	@NotNull()
	private int winningLimit;
	/** 活动奖品统计数 */
	@Column(column = "goodsCount", defaultValue = "0")
	@NotNull()
	private int goodsCount;
	/** 活动报名统计数 */
	@Column(column = "applyCount", defaultValue = "0")
	@NotNull()
	private int applyCount;
	/** 活动咨询统计数 */
	@Column(column = "consultCount", defaultValue = "0")
	@NotNull()
	private int consultCount;
	/** 活动中奖用户数 */
	@Column(column = "awardCount", defaultValue = "0")
	@NotNull()
	private int awardCount;
	/** 活动举办是否在所有城市 */
	@Column(column = "cityAll", defaultValue = "0")
	@NotNull()
	private boolean cityAll;
	/** 活动没中奖用户是否发放券 */
	@Column(column = "isCouponNoneAward", defaultValue = "0")
	@NotNull()
	private boolean isCouponNoneAward;
	/** 话题数量 */
	@Column(column = "subjectCount", defaultValue = "0")
	@NotNull()
	private int subjectCount;
	@Foreign(column = "rid", foreign = "id")
	private Org org;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getTimeRangeStart() {
		return timeRangeStart;
	}

	public void setTimeRangeStart(String timeRangeStart) {
		this.timeRangeStart = timeRangeStart;
	}

	public String getTimeRangeEnd() {
		return timeRangeEnd;
	}

	public void setTimeRangeEnd(String timeRangeEnd) {
		this.timeRangeEnd = timeRangeEnd;
	}

	public long getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(long timeStamp) {
		this.timeStamp = timeStamp;
	}

	public float getDistance() {
		return distance;
	}

	public void setDistance(float distance) {
		this.distance = distance;
	}

	public String getPublishTime() {
		return publishTime;
	}

	public void setPublishTime(String publishTime) {
		this.publishTime = publishTime;
	}

	public String getRuleDesc() {
		return ruleDesc;
	}

	public void setRuleDesc(String ruleDesc) {
		this.ruleDesc = ruleDesc;
	}

	public boolean isWinningStatus() {
		return winningStatus;
	}

	public void setWinningStatus(boolean winningStatus) {
		this.winningStatus = winningStatus;
	}

	public int getWinningLimit() {
		return winningLimit;
	}

	public void setWinningLimit(int winningLimit) {
		this.winningLimit = winningLimit;
	}

	public int getGoodsCount() {
		return goodsCount;
	}

	public void setGoodsCount(int goodsCount) {
		this.goodsCount = goodsCount;
	}

	public int getApplyCount() {
		return applyCount;
	}

	public void setApplyCount(int applyCount) {
		this.applyCount = applyCount;
	}

	public int getConsultCount() {
		return consultCount;
	}

	public void setConsultCount(int consultCount) {
		this.consultCount = consultCount;
	}

	public int getAwardCount() {
		return awardCount;
	}

	public void setAwardCount(int awardCount) {
		this.awardCount = awardCount;
	}

	public boolean isCityAll() {
		return cityAll;
	}

	public void setCityAll(boolean cityAll) {
		this.cityAll = cityAll;
	}

	public boolean isCouponNoneAward() {
		return isCouponNoneAward;
	}

	public void setCouponNoneAward(boolean isCouponNoneAward) {
		this.isCouponNoneAward = isCouponNoneAward;
	}

	public int getSubjectCount() {
		return subjectCount;
	}

	public void setSubjectCount(int subjectCount) {
		this.subjectCount = subjectCount;
	}

	@Override
	public String toString() {
		return "Event [name=" + name + ", status=" + status
				+ ", timeRangeStart=" + timeRangeStart + ", timeRangeEnd="
				+ timeRangeEnd + ", timeStamp=" + timeStamp + ", distance="
				+ distance + ", publishTime=" + publishTime + ", ruleDesc="
				+ ruleDesc + ", winningStatus=" + winningStatus
				+ ", winningLimit=" + winningLimit + ", goodsCount="
				+ goodsCount + ", applyCount=" + applyCount + ", consultCount="
				+ consultCount + ", awardCount=" + awardCount + ", cityAll="
				+ cityAll + ", isCouponNoneAward=" + isCouponNoneAward
				+ ", subjectCount=" + subjectCount + ", org=" + org + "]";
	}

}
