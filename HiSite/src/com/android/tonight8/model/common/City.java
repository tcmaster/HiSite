package com.android.tonight8.model.common;

import com.android.tonight8.model.BaseModel;

/**
 * 
 * @Description:城市对象
 * @author:LiXiaoSong
 * @copyright @HiSite
 * @Date:2015-1-13
 */
public class City extends BaseModel {

	private static final long serialVersionUID = 1L;
	/** 城市名称 */
	public String name;
	/** 城市编号 */
	public String code;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Override
	public String toString() {
		return "Province [name=" + name + ", code=" + code + "]";
	}

}
