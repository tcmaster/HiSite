package com.android.tonight8.io.event.entity;

import com.android.tonight8.io.net.NetEntityBase;
import com.android.tonight8.model.event.EventDetailModel;

/**
 * 
 * @Descripton 活动详情网络实体
 * @author LiXiaoSong
 * @2015-3-7
 * @Tonight8
 */
public class EventDetailNetEntity extends NetEntityBase {
	/** 活动详情 */
	EventDetailModel eventPublishDetail;

	public EventDetailModel getEventPublishDetail() {
		return eventPublishDetail;
	}

	public void setEventPublishDetail(EventDetailModel eventPublishDetail) {
		this.eventPublishDetail = eventPublishDetail;
	}

}
