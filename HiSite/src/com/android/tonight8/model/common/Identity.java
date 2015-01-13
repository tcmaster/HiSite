package com.android.tonight8.model.common;

import com.android.tonight8.model.BaseModel;

/**
 * @Description:商家身份对象
 * @author:LiXiaoSong
 * @copyright @HiSite
 * @Date:2015-1-13
 */
public class Identity extends BaseModel {

	private static final long serialVersionUID = 1L;
	/** 商家身份类型 */
	public int type;
	/** 商家身份证编号 */
	public String code;
	/** 商家身份证照正面图片文件地址 */
	public String photoFront;
	/** 商家身份证照反面图片文件地址 */
	public String photoReverse;

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getPhotoFront() {
		return photoFront;
	}

	public void setPhotoFront(String photoFront) {
		this.photoFront = photoFront;
	}

	public String getPhotoReverse() {
		return photoReverse;
	}

	public void setPhotoReverse(String photoReverse) {
		this.photoReverse = photoReverse;
	}

	@Override
	public String toString() {
		return "Identity [type=" + type + ", code=" + code + ", photoFront=" + photoFront + ", photoReverse=" + photoReverse + "]";
	}

}
