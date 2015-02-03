package com.android.tonight8.storage.entity;

import com.lidroid.xutils.db.annotation.Column;
import com.lidroid.xutils.db.annotation.Foreign;
import com.lidroid.xutils.db.annotation.Id;

/**
 * @author liuzhao 二维码 主键自增长
 */
public class QuickMarkEntity {

	@Id()
	private int id;
	/** 商家二维码编号 */
	@Column(column = "code")
	private String code;
	/** 商家二维码图片文件地址 */
	@Column(column = "photo")
	private String photo;
	/** 优惠券 */
	@Foreign(column = "cid", foreign = "id")
	public CouponEntity couponEntity;
	/** 商家 */
	@Foreign(column = "oid", foreign = "id")
	public OrgEntity orgEntity;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

}
