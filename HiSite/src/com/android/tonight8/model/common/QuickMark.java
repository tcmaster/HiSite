package com.android.tonight8.model.common;

import java.io.Serializable;

/**
 * @Description: 二维码对象
 * @author:LiXiaoSong
 * @copyright @HiSite
 * @Date:2015-1-13
 */
public class QuickMark implements Serializable {

	private static final long serialVersionUID = 1L;
	/** 商家二维码编号 */
	public String code;
	/** 商家二维码图片文件地址 */
	public String photo;

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

	@Override
	public String toString() {
		return "QuickMark [code=" + code + ", photo=" + photo + "]";
	}

}
