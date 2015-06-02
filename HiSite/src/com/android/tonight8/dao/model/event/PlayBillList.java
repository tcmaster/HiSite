package com.android.tonight8.dao.model.event;

import com.android.tonight8.dao.entity.PlayBill;

/**
 * 节目列表
 * 
 * @Descripton
 * @author LiXiaoSong
 * @2015-5-30
 * @Tonight8
 */
public class PlayBillList {
	private PlayBill playbill;

	public PlayBill getPlaybill() {
		return playbill;
	}

	public void setPlaybill(PlayBill playbill) {
		this.playbill = playbill;
	}

	@Override
	public String toString() {
		return "PlayBillList [playbill=" + playbill + "]";
	}

}
