package com.android.tonight8.storage.entity;

import com.lidroid.xutils.db.annotation.Column;
import com.lidroid.xutils.db.annotation.Foreign;
import com.lidroid.xutils.db.annotation.NotNull;
import com.lidroid.xutils.db.annotation.Table;

/**
 * 
 * @Description:
 * @author LiXiaoSong
 * @date 2015-1-17
 */
@Table(name = "apply")
public class ApplyEntity extends EntityBaseEntity {
	/** 引用外键Event id */
	@Foreign(column = "rid", foreign = "id")
	private EventEntity event;
	/** 引用外键User id */
	@Foreign(column = "uid", foreign = "id")
	private UserEntity user;
	/** 日期 */
	@Column(column = "date")
	@NotNull()
	private String date;
	/** 时间 */
	@Column(column = "time")
	@NotNull()
	private String time;

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	@Override
	public String toString() {
		return "Apply [event=" + event + ", user=" + user + ", date=" + date
				+ ", time=" + time + "]";
	}

}
