package com.android.tonight8.dao.model.live;

import java.util.List;

import com.android.tonight8.dao.entity.DetailPic;
import com.android.tonight8.dao.entity.Goods;
import com.android.tonight8.dao.entity.GoodsService;
import com.android.tonight8.dao.entity.GoodsStandard;
import com.android.tonight8.dao.entity.PopPic;

public class EventGoods {
	private Goods goods;
	private List<PopPic> popPics;
	private List<DetailPic> detailPics;
	private List<GoodsService> goodsServices;
	private List<GoodsStandard> goodsStandards;

	public Goods getGoods() {
		return goods;
	}

	public void setGoods(Goods goods) {
		this.goods = goods;
	}

	public List<PopPic> getPopPics() {
		return popPics;
	}

	public void setPopPics(List<PopPic> popPics) {
		this.popPics = popPics;
	}

	public List<DetailPic> getDetailPics() {
		return detailPics;
	}

	public void setDetailPics(List<DetailPic> detailPics) {
		this.detailPics = detailPics;
	}

	public List<GoodsService> getGoodsServices() {
		return goodsServices;
	}

	public void setGoodsServices(List<GoodsService> goodsServices) {
		this.goodsServices = goodsServices;
	}

	public List<GoodsStandard> getGoodsStandards() {
		return goodsStandards;
	}

	public void setGoodsStandards(List<GoodsStandard> goodsStandards) {
		this.goodsStandards = goodsStandards;
	}

	@Override
	public String toString() {
		return "EventGoods [goods=" + goods + ", popPics=" + popPics
				+ ", detailPics=" + detailPics + ", goodsServices="
				+ goodsServices + ", goodsStandards=" + goodsStandards + "]";
	}

}
