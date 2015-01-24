package com.android.tonight8.model.user;

import java.util.List;

import com.android.tonight8.model.BaseModel;
import com.android.tonight8.model.common.Event;
import com.android.tonight8.model.common.Exchange;
import com.android.tonight8.model.common.Org;

/**
 * 
 * @Descripton 用户中奖码兑换模块
 * @author LiXiaoSong
 * @2015-1-24
 * @Tonight8
 */
public class UserExchangeModel extends BaseModel {

	/** */
	private static final long serialVersionUID = 1L;
	/** 兑换 */
	public Exchange exchange;
	/** 兑换商家列表 */
	public List<Org> orgs;
	/** 哪个活动的兑换 */
	public Event event;

	public Exchange getExchange() {
		return exchange;
	}

	public void setExchange(Exchange exchange) {
		this.exchange = exchange;
	}

	public List<Org> getOrgs() {
		return orgs;
	}

	public void setOrgs(List<Org> orgs) {
		this.orgs = orgs;
	}

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	@Override
	public String toString() {
		return "UserExchangeModel [exchange=" + exchange + ", orgs=" + orgs
				+ ", event=" + event + "]";
	}

}
