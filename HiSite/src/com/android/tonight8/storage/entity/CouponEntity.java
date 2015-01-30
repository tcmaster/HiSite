package com.android.tonight8.storage.entity;

import com.lidroid.xutils.db.annotation.Column;
import com.lidroid.xutils.db.annotation.Foreign;
import com.lidroid.xutils.db.annotation.Table;

/**
 * @Description:优惠券表
 * @author LiXiaoSong
 * @date 2015-1-17
 */
@Table(name = "coupon")
public class CouponEntity extends BaseEntity {

	/** 券编号 */
	@Column(column = "code")
	private String code;
	/** 券使用状态 */
	@Column(column = "useStatus", defaultValue = "0")
	private boolean useStatus;
	@Foreign(column = "rid", foreign = "id")
	public EventEntity event;
	@Foreign(column = "uid", foreign = "id")
	public UserEntity user;

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

	@Override
	public String toString() {
		return "CouponEntity [code=" + code + ", useStatus=" + useStatus + ", event=" + event + ", user=" + user + "]";
	}

}
