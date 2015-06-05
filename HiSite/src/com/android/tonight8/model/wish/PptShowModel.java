package com.android.tonight8.model.wish;

import com.android.tonight8.dao.entity.PPT;
import com.android.tonight8.dao.entity.PPTFrame;

public class PptShowModel {
	private PPT ppt;
	private PPTFrame pptFrames;

	public PPT getPpt() {
		return ppt;
	}

	public void setPpt(PPT ppt) {
		this.ppt = ppt;
	}

	public PPTFrame getPptFrames() {
		return pptFrames;
	}

	public void setPptFrames(PPTFrame pptFrames) {
		this.pptFrames = pptFrames;
	}
}
