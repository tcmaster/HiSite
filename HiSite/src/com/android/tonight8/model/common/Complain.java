package com.android.tonight8.model.common;

import java.io.Serializable;

/**
 * @Description:投诉对象
 * @author:LiXiaoSong
 * @copyright @HiSite
 * @Date:2015-1-13
 */
public class Complain implements Serializable {

	private static final long serialVersionUID = 1L;
	/** 投诉id */
	public int id;
	/** 投诉类型 */
	public int type;
	/** 投诉内容 */
	public String content;
	/** 联系方式内容 */
	public String contactContent;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getContactContent() {
		return contactContent;
	}

	public void setContactContent(String contactContent) {
		this.contactContent = contactContent;
	}

	@Override
	public String toString() {
		return "Complain [id=" + id + ", type=" + type + ", content=" + content
				+ ", contactContent=" + contactContent + "]";
	}

}
