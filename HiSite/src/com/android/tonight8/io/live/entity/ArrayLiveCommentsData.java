package com.android.tonight8.io.live.entity;

import java.util.List;

import com.android.tonight8.model.live.LiveCommentModel;

/**
 * @Description：活动现场评论
 * @date 2015-2-5下午9:42:28
 * @author liuzhao
 */
public class ArrayLiveCommentsData {
	private List<LiveCommentModel> event_live_subjects;

	public List<LiveCommentModel> getEvent_live_subjects() {
		return event_live_subjects;
	}

	public void setEvent_live_subjects(
			List<LiveCommentModel> event_live_subjects) {
		this.event_live_subjects = event_live_subjects;
	}
}
