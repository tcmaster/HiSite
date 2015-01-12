package com.android.tonight8.model.common;

import com.android.tonight8.model.BaseModel;

/**
 * 活动对象
 * 
 * @author LiXiaoSong
 * 
 */
public class Live extends BaseModel {

	private static final long serialVersionUID = 1L;
	/** 活动图片 */
	public String signPic;
	/** 活动时间 */
	public String signTime;

	public String getSignPic() {
		return signPic;
	}

	public void setSignPic(String signPic) {
		this.signPic = signPic;
	}

	public String getSignTime() {
		return signTime;
	}

	public void setSignTime(String signTime) {
		this.signTime = signTime;
	}

	@Override
	public String toString() {
		return "Live [signPic=" + signPic + ", signTime=" + signTime + "]";
	}

}
