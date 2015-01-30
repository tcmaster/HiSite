package com.android.tonight8.model.common;

import java.io.Serializable;

/**
 * 
 * @Description:兑奖对象
 * @author:LiXiaoSong
 * @copyright @HiSite
 * @Date:2015-1-13
 */
public class Exchange implements Serializable {

	private static final long serialVersionUID = 1L;
	/** 兑奖id */
	public int id;
	/** 活动外键 */
	public int rid;
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

	public int getRid() {
		return rid;
	}

	public void setRid(int rid) {
		this.rid = rid;
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
		return "Exchange [id=" + id + ", rid=" + rid + ", method=" + method + ", address=" + address + ", orgAll=" + orgAll + "]";
	}

}
