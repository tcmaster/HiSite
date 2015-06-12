package com.android.tonight8.io.live.entity;

import java.util.List;

import com.android.tonight8.dao.model.live.SubjectList;

public class EventLiveCommitNetEntity {
	private List<SubjectList> subjectList;

	public List<SubjectList> getSubjectList() {
		return subjectList;
	}

	public void setSubjectList(List<SubjectList> subjectList) {
		this.subjectList = subjectList;
	}

	@Override
	public String toString() {
		return "EventLiveCommitNetEntity [subjectList=" + subjectList + "]";
	}

}
