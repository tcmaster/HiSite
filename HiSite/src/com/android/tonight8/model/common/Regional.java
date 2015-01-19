package com.android.tonight8.model.common;

import java.io.Serializable;

/**
 * @Description:区域对象
 * @author:LiXiaoSong
 * @copyright @HiSite
 * @Date:2015-1-13
 */
public class Regional implements Serializable {

	private static final long serialVersionUID = 1L;
	/** 区域名称 */
	public String name;
	/** 区域编号 */
	public String code;
	/** 区域所属父编码 */
	public int pid;
	/** 区域id */
	public int id;

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

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Province [name=" + name + ", code=" + code + ", pid=" + pid
				+ ", id=" + id + "]";
	}

}
