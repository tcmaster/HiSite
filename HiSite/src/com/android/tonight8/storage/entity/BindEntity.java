package com.android.tonight8.storage.entity;

import com.lidroid.xutils.db.annotation.Column;
import com.lidroid.xutils.db.annotation.Foreign;
import com.lidroid.xutils.db.annotation.Id;
import com.lidroid.xutils.db.annotation.Table;

/**
 * @Descripton 商家绑定表
 * @author LiXiaoSong
 * @2015-1-29
 * @Tonight8
 */
@Table(name = "bind")
public class BindEntity extends BaseEntity {
	/** 绑定的状态 */
	@Column(column = "status")
	private int status;
	/** 绑定的日期 */
	@Column(column = "date")
	private String date;
	/** 绑定的商家 */
	@Id
	@Foreign(column = "rid", foreign = "id")
	public OrgEntity org;

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "BindEntity [status=" + status + ", date=" + date + ", org="
				+ org + "]";
	}

}
