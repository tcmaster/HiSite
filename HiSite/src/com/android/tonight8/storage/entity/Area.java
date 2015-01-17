package com.android.tonight8.storage.entity;

import com.lidroid.xutils.db.annotation.Column;
import com.lidroid.xutils.db.annotation.Foreign;
import com.lidroid.xutils.db.annotation.NotNull;
import com.lidroid.xutils.db.annotation.Table;

/**
 * @Description:地区表
 * @author LiXiaoSong
 * @date 2015-1-17
 */
@Table(name = "area")
public class Area extends EntityBase {
	/** 城市外键 */
	@Foreign(column = "pid", foreign = "id")
	private City city;
	/** 名称 */
	@Column(column = "name")
	@NotNull()
	private String name;
	/** 编码 */
	@Column(column = "code")
	@NotNull()
	private String code;

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
		return "Area [city=" + city + ", name=" + name + ", code=" + code + "]";
	}

}
