package com.android.tonight8.storage.entity;

import com.lidroid.xutils.db.annotation.Column;
import com.lidroid.xutils.db.annotation.Foreign;
import com.lidroid.xutils.db.annotation.NotNull;
import com.lidroid.xutils.db.annotation.Table;

/**
 * @author liuzhao
 * @date 2015-1-17 签到
 */
@Table(name = "signin")
public class SignInEntity extends BaseEntity {

	/** 活动时间 */
	@NotNull
	@Column(column = "time")
	private String time;
	/** 活动图片 */
	@NotNull
	@Column(column = "pic")
	private String pic;
	/** 图片大小 */
	@Column(column = "size")
	private String size;
	// 新加的
	/** 用户 */
	@Foreign(column = "rid", foreign = "id")
	public UserEntity user;
	/** 活动 */
	@Foreign(column = "eid", foreign = "id")
	public EventEntity event;

	@Override
	public String toString() {
		return "SignIn [time=" + time + ", pic=" + pic + ", size=" + size + "]";
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}
}
