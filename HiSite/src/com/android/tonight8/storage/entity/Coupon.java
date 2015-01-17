package com.android.tonight8.storage.entity;

import com.lidroid.xutils.db.annotation.Column;
import com.lidroid.xutils.db.annotation.Foreign;
import com.lidroid.xutils.db.annotation.NotNull;

/**
 * @Description:优惠券表
 * @author LiXiaoSong
 * @date 2015-1-17
 */
public class Coupon extends EntityBase {
	/** 券编号 */
	@Column(column = "code")
	@NotNull()
	private String code;
	/** 券使用状态 */
	@Column(column = "useStatus", defaultValue = "0")
	@NotNull()
	private boolean useStatus;
	/** 券发放类型 */
	@Column(column = "provideType", defaultValue = "0")
	@NotNull()
	private int provideType;
	/** 券发放数量 */
	@Column(column = "provideNum", defaultValue = "0")
	@NotNull()
	private int provideNum;
	/** 券发放报名者都有 */
	@Column(column = "provideAll", defaultValue = "0")
	@NotNull()
	private boolean provideAll;
	/** 券价值 */
	@Column(column = "value", defaultValue = "0")
	@NotNull()
	private int value;
	/** 券内容 */
	@Column(column = "content")
	@NotNull()
	private String content;
	/** 券有效开始日期 */
	@Column(column = "dateRangeStart")
	@NotNull()
	private String dateRangeStart;
	/** 券有效结束日期 */
	@Column(column = "dateRangeEnd")
	@NotNull()
	private String dateRangeEnd;
	/** 券模版图片 */
	@Column(column = "templatePic")
	@NotNull()
	private String templatePic;
	/** 券发放时间 */
	@Column(column = "publishTime")
	@NotNull()
	private String publishTime;
	@Foreign(column = "rid", foreign = "id")
	Event event;

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

	public int getProvideType() {
		return provideType;
	}

	public void setProvideType(int provideType) {
		this.provideType = provideType;
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
		return "Coupon [code=" + code + ", useStatus=" + useStatus
				+ ", provideType=" + provideType + ", provideNum=" + provideNum
				+ ", provideAll=" + provideAll + ", value=" + value
				+ ", content=" + content + ", dateRangeStart=" + dateRangeStart
				+ ", dateRangeEnd=" + dateRangeEnd + ", templatePic="
				+ templatePic + ", publishTime=" + publishTime + ", event="
				+ event + "]";
	}
}
