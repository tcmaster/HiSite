package com.android.tonight8.model.event;

import com.android.tonight8.model.BaseModel;
import com.android.tonight8.model.common.Exchange;
import com.android.tonight8.model.common.Org;

/**
 * 活动兑奖地址
 * 
 * @author LiXiaoSong
 * 
 */
public class EventExchangeModel extends BaseModel {
	private static final long serialVersionUID = 1L;
	/** 兑奖对象 */
	public Exchange exchange;
	/** 商家对象 */
	public Org org;
}
