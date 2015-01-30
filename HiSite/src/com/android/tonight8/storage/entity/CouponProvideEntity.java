/**
 * 2015-1-30
 */
package com.android.tonight8.storage.entity;

import com.lidroid.xutils.db.annotation.Column;
import com.lidroid.xutils.db.annotation.Foreign;
import com.lidroid.xutils.db.annotation.Table;

/**
 * @Description:商家优惠券表
 * @author:LiXiaoSong
 * @copyright @HiSite
 * @Date:2015-1-30
 */
@Table(name = "couponProvide")
public class CouponProvideEntity extends BaseEntity {

	/** 优惠券类型 */
	@Column(column = "type")
	private int type;
	/** 优惠券面值 */
	@Column(column = "value")
	private int value;
	/** 优惠券内容 */
	@Column(column = "content")
	private String content;
	/** 提供的优惠券数量 */
	@Column(column = "provideNum")
	private int provideNum;
	/** 是否全员提供 */
	@Column(column = "provideAll")
	private boolean provideAll;
	/** 开始日期 */
	@Column(column = "dateRangeStart")
	private String dateRangeStart;
	/** 结束日期 */
	@Column(column = "dateRangeEnd")
	private String dateRangeEnd;
	/** 临时图片 */
	@Column(column = "templatePic")
	private String templatePic;
	/** 发布时间 */
	@Column(column = "publishTime")
	private String publishTime;
	@Foreign(column = "rid", foreign = "id")
	public EventEntity event;

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
		return "CouponProvideEntity [type=" + type + ", value=" + value + ", content=" + content + ", provideNum=" + provideNum + ", provideAll=" + provideAll + ", dateRangeStart=" + dateRangeStart + ", dateRangeEnd=" + dateRangeEnd + ", templatePic=" + templatePic + ", publishTime=" + publishTime + ", event=" + event + "]";
	}

}
