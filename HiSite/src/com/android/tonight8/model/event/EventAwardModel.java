package com.android.tonight8.model.event;

import com.android.tonight8.model.BaseModel;
import com.android.tonight8.model.common.Apply;
import com.android.tonight8.model.common.Award;
import com.android.tonight8.model.common.Event;
import com.android.tonight8.model.common.Exchange;
import com.android.tonight8.model.common.Org;
import com.android.tonight8.model.common.User;

/**
 * 活动中奖名单
 * 
 * @author LiXiaoSong
 */
public class EventAwardModel extends BaseModel {
	private static final long serialVersionUID = 1L;
	/** 奖品 */
	public Award award;
	/** 用户 */
	public User user;
	/** 活动 */
	public Event event;
	/** 报名 */
	public Apply apply;
	/** 兑奖 */
	public Exchange exchange;
	/** 商家 */
	public Org org;

	public Award getAward() {
		return award;
	}

	public void setAward(Award award) {
		this.award = award;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	public Apply getApply() {
		return apply;
	}

	public void setApply(Apply apply) {
		this.apply = apply;
	}

	public Exchange getExchange() {
		return exchange;
	}

	public void setExchange(Exchange exchange) {
		this.exchange = exchange;
	}

	public Org getOrg() {
		return org;
	}

	public void setOrg(Org org) {
		this.org = org;
	}

}
