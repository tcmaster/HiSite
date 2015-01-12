package com.android.tonight8.model.common;

import com.android.tonight8.model.BaseModel;

/**
 * 活动奖品对象
 * 
 * @author LiXiaoSong
 */
public class Goods extends BaseModel {

	private static final long serialVersionUID = 1L;
	/** 活动id */
	public long id;
	/** 活动奖品名称 */
	public String name;
	/** 活动奖品图片文件地址 */
	public String pic;
	/** 活动奖品图片宽高 */
	public String size;
	/** 活动奖品价格 */
	public int price;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Goods [id=" + id + ", name=" + name + ", pic=" + pic
				+ ", size=" + size + ", price=" + price + "]";
	}

}
