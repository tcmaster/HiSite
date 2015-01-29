package com.android.tonight8.model.common;

import java.io.Serializable;

/**
 * 
 * @Description:券对象
 * @author:LiXiaoSong
 * @copyright @HiSite
 * @Date:2015-1-13
 */
public class Coupon implements Serializable {

	private static final long serialVersionUID = 1L;
	/** 券id */
	public long id;
	/** 活动外键 */
	public int rid;
	/** 用户外键*/
	public int uid;
	/** 券编号 */
	public String code;
	/** 券使用状态 */
	public boolean useStatus;
	/** 券发放类型 */
	public int provideType;
	/** 券发放数量 */
	public int provideNum;
	/** 券发放报名者都有 */
	public boolean provideAll;
	/** 券价值 */
	public int value;
	/** 券内容 */
	public String content;
	/** 券有效开始日期 */
	public String dateRangeStart;
	/** 券有效结束日期 */
	public String dateRangeEnd;
	/** 券模版图片 */
	public String templatePic;
	/** 券发放时间 */
	public String publishTime;
	/** 券二维码信息 */
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
		return "Coupon [id=" + id + ", rid=" + rid + ", uid=" + uid + ", code="
				+ code + ", useStatus=" + useStatus + ", provideType="
				+ provideType + ", provideNum=" + provideNum + ", provideAll="
				+ provideAll + ", value=" + value + ", content=" + content
				+ ", dateRangeStart=" + dateRangeStart + ", dateRangeEnd="
				+ dateRangeEnd + ", templatePic=" + templatePic
				+ ", publishTime=" + publishTime + ", quickMark=" + quickMark
				+ "]";
	}
	

}
