package com.android.tonight8.model.common;

import java.io.Serializable;

/**
 * 活动对象
 * 
 * @author LiXiaoSong
 * 
 */
public class SignIn implements Serializable {

	private static final long serialVersionUID = 1L;
	public long id;
	/** 活动图片 */
	public String pic;
	/** 活动时间 */
	public String time;
	/** 图片大小 */
	public String size;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	@Override
	public String toString() {
		return "SignIn [id=" + id + ", pic=" + pic + ", time=" + time
				+ ", size=" + size + "]";
	}

}
