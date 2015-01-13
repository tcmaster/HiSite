package com.android.tonight8.model.common;

import java.io.Serializable;

/**
 * @Description:地区对象
 * @author:LiXiaoSong
 * @copyright @HiSite
 * @Date:2015-1-13
 */
public class Area implements Serializable {

	private static final long serialVersionUID = 1L;
	/** 地区名称 */
	public String name;
	/** 地区编号 */
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
