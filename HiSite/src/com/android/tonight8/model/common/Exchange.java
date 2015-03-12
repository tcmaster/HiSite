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
	/** 活动外键 */
	public int rid;
	/** 兑奖方式 */
	public int method;
	/** 兑奖指定地址 */
	public String address;
	/** 地址类型 */
	public int locationType;


	public int getRid() {
		return rid;
	}

	public void setRid(int rid) {
		this.rid = rid;
	}
	

	public int getMethod() {
		return method;
	}

	public void setMethod(int method) {
		this.method = method;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getLocationType() {
		return locationType;
	}

	public void setLocationType(int locationType) {
		this.locationType = locationType;
	}

	@Override
	public String toString() {
		return "Exchange [rid=" + rid + ", method=" + method + ", address="
				+ address + ", locationType=" + locationType + "]";
	}


}
