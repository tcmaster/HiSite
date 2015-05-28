package com.android.tonight8.io.event.entity;

import java.util.List;

import com.android.tonight8.io.net.NetEntityBase;
import com.android.tonight8.model.event.EventConsultModel;

public class EventConsultListEntity extends NetEntityBase {
	private List<EventConsultModel> eventPublishConsults;

	public List<EventConsultModel> getEventPublishConsults() {
		return eventPublishConsults;
	}

	public void setEventPublishConsults(
			List<EventConsultModel> eventPublishConsults) {
		this.eventPublishConsults = eventPublishConsults;
	}

}
