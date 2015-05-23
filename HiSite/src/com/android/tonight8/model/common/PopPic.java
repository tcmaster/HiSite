package com.android.tonight8.model.common;

/**
 * 海报图片
 */
public class PopPic {
	/** 海报图片id */
	private int id;
	/** 海报图片类型，0：奖品，1: 商品, 2：心愿 */
	private String type;
	/** 海报图片文件地址 */
	private String url;
	/** 海报图片关联奖品，商品，心愿id */
	private int relateId;
	/** 海报图片描述 */
	private String describe;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getRelateId() {
		return relateId;
	}

	public void setRelateId(int relateId) {
		this.relateId = relateId;
	}

	public String getDescribe() {
		return describe;
	}

	public void setDescribe(String describe) {
		this.describe = describe;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
