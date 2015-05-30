package com.android.tonight8.dao.model.event;

import com.android.tonight8.dao.entity.Event;
import com.android.tonight8.dao.entity.PopPic;
import com.android.tonight8.dao.entity.Prize;

/**
 * 活动推荐模块
 * 
 * @Descripton
 * @author LiXiaoSong
 * @2015-5-28
 * @Tonight8
 */
public class EventRecommends {
	private Event event;
	private Prize prize;
	private PopPic popPic;

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

	@Override
	public String toString() {
		return "EventRecommends [event=" + event + ", prize=" + prize
				+ ", popPic=" + popPic + "]";
	}

}
