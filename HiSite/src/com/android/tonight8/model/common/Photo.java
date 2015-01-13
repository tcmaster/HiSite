package com.android.tonight8.model.common;

import com.android.tonight8.model.BaseModel;

/**
 * @Description:话题图片对象
 * @author:LiXiaoSong
 * @copyright @HiSite
 * @Date:2015-1-13
 */
public class Photo extends BaseModel {

	private static final long serialVersionUID = 1L;
	/** 话题图片id */
	public long id;
	/** 话题图片文件地址 */
	public String url;
	/** 话题图片文件宽高 */
	public String size;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	@Override
	public String toString() {
		return "Photo [id=" + id + ", url=" + url + ", size=" + size + "]";
	}

}
