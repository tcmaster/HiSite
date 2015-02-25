package com.android.tonight8.storage.entity;

import com.lidroid.xutils.db.annotation.Column;
import com.lidroid.xutils.db.annotation.Foreign;
import com.lidroid.xutils.db.annotation.Table;

/**
 * @Description:兑奖表
 * @author LiXiaoSong
 * @date 2015-1-17
 */
@Table(name = "exchange")
public class ExchangeEntity extends BaseDefaultEntity{
	/** 兑奖方式 */
	@Column(column = "method")
	private boolean method;
	/** 兑奖指定地址 */
	@Column(column = "address")
	private String address;
	/** 兑奖是否是全部经销商地址 */
	@Column(column = "locationType")
	private int locationType;
	@Foreign(column = "rid", foreign = "id")
	public EventEntity event;

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

	public int getLocationType() {
		return locationType;
	}

	public void setLocationType(int locationType) {
		this.locationType = locationType;
	}

	@Override
	public String toString() {
		return "ExchangeEntity [id=" + id + ", method=" + method + ", address=" + address + ", locationType=" + locationType + ", event=" + event + "]";
	}

}
