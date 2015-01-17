package com.android.tonight8.storage.entity;

import com.lidroid.xutils.db.annotation.Column;
import com.lidroid.xutils.db.annotation.Foreign;
import com.lidroid.xutils.db.annotation.NotNull;

/**
 * @Description:兑奖表
 * @author LiXiaoSong
 * @date 2015-1-17
 */
public class Exchange extends EntityBase {
	/** 兑奖方式 */
	@Column(column = "method", defaultValue = "0")
	@NotNull()
	private boolean method;
	/** 兑奖指定地址 */
	@Column(column = "address")
	private String address;
	/** 兑奖是否是全部经销商地址 */
	@Column(column = "orgAll", defaultValue = "0")
	private boolean orgAll;
	@Foreign(column = "rid", foreign = "id")
	private Event event;

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
		return "Exchange [method=" + method + ", address=" + address
				+ ", orgAll=" + orgAll + ", event=" + event + "]";
	}

}
