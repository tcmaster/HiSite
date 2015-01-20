package com.android.tonight8.storage.entity;

import com.lidroid.xutils.db.annotation.Column;
import com.lidroid.xutils.db.annotation.NotNull;

/**
 * @Description:区域表
 * @author LiXiaoSong
 * @date 2015-1-17
 */
public class RegionalEntity extends EntityBaseEntity {
	/** 区域名称 */
	@NotNull()
	@Column(column = "name")
	public String name;
	/** 区域编号 */
	@NotNull()
	@Column(column = "code")
	public String code;
	/** 区域所属父编码 */
	@NotNull()
	@Column(column = "pid", defaultValue = "0")
	public int pid;
	/** 区域级别（省，市，区） */
	@NotNull()
	@Column(column = "level")
	public int level;

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

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	@Override
	public String toString() {
		return "Regional [name=" + name + ", code=" + code + ", pid=" + pid
				+ ", level=" + level + "]";
	}

}