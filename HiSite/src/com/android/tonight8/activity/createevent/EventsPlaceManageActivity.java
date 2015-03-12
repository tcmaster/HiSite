package com.android.tonight8.activity.createevent;

import android.os.Bundle;

import com.android.tonight8.R;
import com.android.tonight8.base.BaseActivity;

/**
 * @Description:兑奖地点管理
 * @author LiuZhao
 * @Date2014-12-29 下午11:17:20
 */
public class EventsPlaceManageActivity extends BaseActivity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		setContentView(R.layout.activity_events_place_setting);
		super.onCreate(savedInstanceState);
		getActionBarBase("兑奖地点管理");
	}
}
