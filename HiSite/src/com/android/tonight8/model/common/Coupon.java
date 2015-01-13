package com.android.tonight8.model.common;

import com.android.tonight8.model.BaseModel;

/**
 * 
 * @Description:券对象
 * @author:LiXiaoSong
 * @copyright @HiSite
 * @Date:2015-1-13
 */
public class Coupon extends BaseModel {

	private static final long serialVersionUID = 1L;
	/** 券id */
	long id;
	/** 券编号 */
	String code;
	/** 券使用状态 */
	boolean useStatus;
	/** 券发放类型 */
	int provideType;
	/** 券发放数量 */
	int provideNum;
	/** 券发放报名者都有 */
	boolean provideAll;
	/** 券价值 */
	int value;
	/** 券内容 */
	String content;
	/** 券有效开始日期 */
	String dateRangeStart;
	/** 券有效结束日期 */
	String dateRangeEnd;
	/** 券模版图片 */
	String templatePic;
	/** 券发放时间 */
	String publishTime;
	/** 券二维码信息 */
	QuickMark quickMark;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public QuickMark getQuickMark() {
		return quickMark;
	}

	public void setQuickMark(QuickMark quickMark) {
		this.quickMark = quickMark;
	}

	@Override
	public String toString() {
		return "Coupon [id=" + id + ", code=" + code + ", useStatus=" + useStatus + ", provideType=" + provideType + ", provideNum=" + provideNum + ", provideAll=" + provideAll + ", value=" + value + ", content=" + content + ", dateRangeStart=" + dateRangeStart + ", dateRangeEnd=" + dateRangeEnd + ", templatePic=" + templatePic + ", publishTime=" + publishTime + ", quickMark=" + quickMark + "]";
	}

}