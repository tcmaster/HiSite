package com.android.tonight8.dao.model.other;

/**
 * @author lz许愿清单录入
 * 
 */
public class WishAddItem {
	/** 0物品 1现金 */
	private int type = 0;
	/** 赞助的东西：现金或者物品 */
	private String things;
	/** 原因 */
	private String reason;
	/** 是否是添加 */
	private boolean isAdd = true;

	public boolean isAdd() {
		return isAdd;
	}

	public void setAdd(boolean isAdd) {
		this.isAdd = isAdd;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getThings() {
		return things;
	}

	public void setThings(String things) {
		this.things = things;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}
}
