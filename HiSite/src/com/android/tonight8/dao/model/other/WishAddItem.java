package com.android.tonight8.dao.model.other;

/**
 * @author lz许愿清单录入
 * 
 */
public class WishAddItem {
	/** 0现金 1物品 */
	private int type;
	/** 金额 */
	private String money;
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

	public String getMoney() {
		return money;
	}

	public void setMoney(String money) {
		this.money = money;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}
}
