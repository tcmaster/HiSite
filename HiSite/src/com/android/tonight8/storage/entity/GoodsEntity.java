package com.android.tonight8.storage.entity;

import com.lidroid.xutils.db.annotation.Column;
import com.lidroid.xutils.db.annotation.Foreign;

/**
 * @Description: 商品表
 * @author LiXiaoSong
 * @date 2015-1-17
 */
public class GoodsEntity extends BaseEntity {

	/** 活动奖品名称 */
	@Column(column = "name")
	private String name;
	/** 活动奖品图片文件地址 */
	@Column(column = "pic")
	private String pic;
	/** 活动奖品图片宽高 */
	@Column(column = "size")
	private String size;
	/** 活动奖品价格 */
	@Column(column = "price")
	private int price;
	@Foreign(column = "rid", foreign = "id")
	public EventEntity event;

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
}
