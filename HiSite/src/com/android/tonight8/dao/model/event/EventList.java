package com.android.tonight8.dao.model.event;

import com.android.tonight8.dao.entity.Event;
import com.android.tonight8.dao.entity.Org;
import com.android.tonight8.dao.entity.PopPic;
import com.android.tonight8.dao.entity.Prize;

/**
 * 活动列表
 * 
 * @Descripton
 * @author LiXiaoSong
 * @2015-5-29
 * @Tonight8
 */
public class EventList {
	private Event event;
	private Prize prize;
	private PopPic popPic;
	private Org org;

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	public Prize getPrize() {
		return prize;
	}

	public void setPrize(Prize prize) {
		this.prize = prize;
	}

	public PopPic getPopPic() {
		return popPic;
	}

	public void setPopPic(PopPic popPic) {
		this.popPic = popPic;
	}

	public Org getOrg() {
		return org;
	}

	public void setOrg(Org org) {
		this.org = org;
	}

	@Override
	public String toString() {
		return "EventList [event=" + event + ", prize=" + prize + ", popPic="
				+ popPic + ", org=" + org + "]";
	}

}
