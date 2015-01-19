package com.android.tonight8.storage.entity;

import com.lidroid.xutils.db.annotation.Column;
import com.lidroid.xutils.db.annotation.Foreign;
import com.lidroid.xutils.db.annotation.NotNull;

/**
 * @Description: 商品表
 * @author LiXiaoSong
 * @date 2015-1-17
 */
public class Goods extends EntityBase {
	/** 活动奖品名称 */
	@Column(column = "name")
	@NotNull()
	private String name;
	/** 活动奖品图片文件地址 */
	@Column(column = "pic")
	@NotNull()
	private String pic;
	/** 活动奖品图片宽高 */
	@Column(column = "size")
	@NotNull()
	private String size;
	/** 活动奖品价格 */
	@Column(column = "price")
	@NotNull()
	private int price;
	@Foreign(column = "rid", foreign = "id")
	private Event event;

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
		return "Goods [name=" + name + ", pic=" + pic + ", size=" + size
				+ ", price=" + price + ", event=" + event + "]";
	}

}
