package com.android.tonight8.model.common;

import com.android.tonight8.model.BaseModel;

/**
 * @Description:手机屏幕对象
 * @author:LiXiaoSong
 * @copyright @HiSite
 * @Date:2015-1-13
 */
public class Screen extends BaseModel {

	private static final long serialVersionUID = 1L;
	/** 手机屏幕宽度 */
	public int width;
	/** 手机屏幕高度 */
	public int height;

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	@Override
	public String toString() {
		return "Screen [width=" + width + ", height=" + height + "]";
	}

}
