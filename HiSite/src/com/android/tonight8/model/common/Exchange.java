package com.android.tonight8.model.common;

import com.android.tonight8.model.BaseModel;

/**
 * 
 * @Description:兑奖对象
 * @author:LiXiaoSong
 * @copyright @HiSite
 * @Date:2015-1-13
 */
public class Exchange extends BaseModel {

	private static final long serialVersionUID = 1L;
	/** 兑奖id */
	public int id;
	/** 兑奖方式 */
	public boolean method;
	/** 兑奖指定地址 */
	public String address;
	/** 兑奖是否是全部经销商地址 */
	public boolean orgAll;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isMethod() {
		return method;
	}

	public void setMethod(boolean method) {
		this.method = method;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public boolean isOrgAll() {
		return orgAll;
	}

	public void setOrgAll(boolean orgAll) {
		this.orgAll = orgAll;
	}

	@Override
	public String toString() {
		return "Exchange [id=" + id + ", method=" + method + ", address=" + address + ", orgAll=" + orgAll + "]";
	}

}
