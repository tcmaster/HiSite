package com.android.tonight8.model.common;

import com.android.tonight8.model.BaseModel;

/**
 * 活动对象
 * 
 * @author LiXiaoSong
 */
public class Event extends BaseModel {
	private static final long serialVersionUID = 1L;
	/** 活动id */
	public int id;
	/** 活动名称 */
	public String name;
	/** 活动状态 */
	public int status;
	/** 活动海报 */
	public PopGoods popGoods;
	/** 活动距离 */
	public float distance;
	/** 活动举办开始时间 */
	public String timeRangeStart;
	/** 活动举办结束时间 */
	public String timeRangeEnd;
	/** 活动举办开始时间的时间戳 */
	public long timeStamp;
	/** 活动上架时间 */
	public String publishTime;
	/** 活动规则 */
	public String ruleDesc;
	/** 活动中奖状态 */
	public boolean winningStatus;
	/** 活动中奖名额 */
	public int winningLimit;
	/** 活动奖品统计数 */
	public int goodsCount;
	/** 活动报名统计数 */
	public int applyCount;
	/** 活动咨询统计数 */
	public int consultCount;
	/** 活动中奖用户数 */
	public int awardCount;
	/** 活动举办是否在所有城市 */
	public boolean cityAll;
	/** 活动没中奖用户是否发放券 */
	public boolean isCouponNoneAward;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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

	public PopGoods getPopGoods() {
		return popGoods;
	}

	public void setPopGoods(PopGoods popGoods) {
		this.popGoods = popGoods;
	}

	public float getDistance() {
		return distance;
	}

	public void setDistance(float distance) {
		this.distance = distance;
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

	@Override
	public String toString() {
		return "Event [id=" + id + ", name=" + name + ", status=" + status
				+ ", popGoods=" + popGoods + ", distance=" + distance
				+ ", timeRangeStart=" + timeRangeStart + ", timeRangeEnd="
				+ timeRangeEnd + ", timeStamp=" + timeStamp + ", publishTime="
				+ publishTime + ", ruleDesc=" + ruleDesc + ", winningStatus="
				+ winningStatus + ", winningLimit=" + winningLimit
				+ ", goodsCount=" + goodsCount + ", applyCount=" + applyCount
				+ ", consultCount=" + consultCount + ", awardCount="
				+ awardCount + ", cityAll=" + cityAll + ", isCouponNoneAward="
				+ isCouponNoneAward + "]";
	}

}
