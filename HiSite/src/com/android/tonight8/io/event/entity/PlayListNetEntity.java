package com.android.tonight8.io.event.entity;

import java.util.List;

import com.android.tonight8.dao.model.event.PlayBillList;

public class PlayListNetEntity {
	private List<PlayBillList> playbillList;

	public List<PlayBillList> getPlaybillList() {
		return playbillList;
	}

	public void setPlaybillList(List<PlayBillList> playbillList) {
		this.playbillList = playbillList;
	}

	@Override
	public String toString() {
		return "PlayListNetEntity [playbillList=" + playbillList + "]";
	}

}
