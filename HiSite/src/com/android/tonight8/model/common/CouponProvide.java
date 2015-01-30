/**
 * 2015-1-30
 */
package com.android.tonight8.model.common;

import java.io.Serializable;

/**
 * @Description: 商家活动介绍时的优惠券
 * @author:LiXiaoSong
 * @copyright @HiSite
 * @Date:2015-1-30
 */
public class CouponProvide implements Serializable {

	private static final long serialVersionUID = 1L;
	public long id;
	/** 活动外键 */
	public int rid;
	/** 优惠券类型 */
	public int type;
	/** 优惠券面值 */
	public int value;
	/** 优惠券内容 */
	public String content;
	/** 提供的优惠券数量 */
	public int provideNum;
	/** 是否全员提供 */
	public boolean provideAll;
	/** 开始日期 */
	public String dateRangeStart;
	/** 结束日期 */
	public String dateRangeEnd;
	/** 临时图片 */
	public String templatePic;
	/** 发布时间 */
	public String publishTime;

	public int getRid() {
		return rid;
	}

	public void setRid(int rid) {
		this.rid = rid;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getProvideNum() {
		return provideNum;
	}

	public void setProvideNum(int provideNum) {
		this.provideNum = provideNum;
	}

	public boolean isProvideAll() {
		return provideAll;
	}

	public void setProvideAll(boolean provideAll) {
		this.provideAll = provideAll;
	}

	public String getDateRangeStart() {
		return dateRangeStart;
	}

	public void setDateRangeStart(String dateRangeStart) {
		this.dateRangeStart = dateRangeStart;
	}

	public String getDateRangeEnd() {
		return dateRangeEnd;
	}

	public void setDateRangeEnd(String dateRangeEnd) {
		this.dateRangeEnd = dateRangeEnd;
	}

	public String getTemplatePic() {
		return templatePic;
	}

	public void setTemplatePic(String templatePic) {
		this.templatePic = templatePic;
	}

	public String getPublishTime() {
		return publishTime;
	}

	public void setPublishTime(String publishTime) {
		this.publishTime = publishTime;
	}

	@Override
	public String toString() {
		return "CouponProvide [rid=" + rid + ", type=" + type + ", value=" + value + ", content=" + content + ", provideNum=" + provideNum + ", provideAll=" + provideAll + ", dateRangeStart=" + dateRangeStart + ", dateRangeEnd=" + dateRangeEnd + ", templatePic=" + templatePic + ", publishTime=" + publishTime + "]";
	}

}
