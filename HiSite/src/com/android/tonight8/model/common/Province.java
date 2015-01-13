package com.android.tonight8.model.common;

import java.io.Serializable;

/**
 * @Description:省份对象
 * @author:LiXiaoSong
 * @copyright @HiSite
 * @Date:2015-1-13
 */
public class Province implements Serializable {

	private static final long serialVersionUID = 1L;
	/** 省份名称 */
	public String name;
	/** 省份编号 */
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
