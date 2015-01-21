package com.android.tonight8.storage.entity;

import com.lidroid.xutils.db.annotation.Column;
import com.lidroid.xutils.db.annotation.Foreign;
import com.lidroid.xutils.db.annotation.Table;

/**
 * 话题图片对象
 * 
 * @author liuzhao
 * @date 2015-1-17
 */
@Table(name = "photo")
public class PhotoEntitiy extends BaseEntity {

	/** 话题 */
	@Foreign(column = "rid", foreign = "id")
	private SubjectEntity subject;
	/** 用户 */
	@Foreign(column = "uid", foreign = "id")
	private UserEntity user;
	/** 话题图片文件地址 */
	@Column(column = "url")
	private String url;
	/** 话题图片文件宽高 */
	@Column(column = "size")
	private String size;

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
		return "Photo [subject=" + subject + ", user=" + user + ", url=" + url + ", size=" + size + "]";
	}
}
