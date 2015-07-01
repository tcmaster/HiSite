package com.android.tonight8.dao.model.live;

import java.util.List;

import com.android.tonight8.dao.entity.Coupon;
import com.android.tonight8.dao.entity.CouponProvide;
import com.android.tonight8.dao.entity.Goods;
import com.android.tonight8.dao.entity.GoodsSpecification;
import com.android.tonight8.dao.entity.GoodsStock;
import com.android.tonight8.dao.entity.Org;

public class EventGoodsOrder {
	private Goods goods;
	private Org org;
	private CouponProvide couponProvide;
	private List<Coupon> coupons;
	private List<GoodsSpecification> goodsSpecifications;
	private List<GoodsStock> goodsStocks;

	public Goods getGoods() {
		return goods;
	}

	public void setGoods(Goods goods) {
		this.goods = goods;
	}

	public Org getOrg() {
		return org;
	}

	public void setOrg(Org org) {
		this.org = org;
	}

	public CouponProvide getCouponProvide() {
		return couponProvide;
	}

	public void setCouponProvide(CouponProvide couponProvide) {
		this.couponProvide = couponProvide;
	}

	public List<Coupon> getCoupons() {
		return coupons;
	}

	public void setCoupons(List<Coupon> coupons) {
		this.coupons = coupons;
	}

	public List<GoodsSpecification> getGoodsSpecifications() {
		return goodsSpecifications;
	}

	public void setGoodsSpecifications(
			List<GoodsSpecification> goodsSpecifications) {
		this.goodsSpecifications = goodsSpecifications;
	}

	public List<GoodsStock> getGoodsStocks() {
		return goodsStocks;
	}

	public void setGoodsStocks(List<GoodsStock> goodsStocks) {
		this.goodsStocks = goodsStocks;
	}

	@Override
	public String toString() {
		return "EventGoodsOrder [goods=" + goods + ", org=" + org
				+ ", couponProvide=" + couponProvide + ", coupons=" + coupons
				+ ", goodsSpecifications=" + goodsSpecifications
				+ ", goodsStocks=" + goodsStocks + "]";
	}

}
