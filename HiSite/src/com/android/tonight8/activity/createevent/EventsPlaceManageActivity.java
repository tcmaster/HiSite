package com.android.tonight8.activity.createevent;

import android.os.Bundle;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;

import com.android.tonight8.R;
import com.android.tonight8.adapter.event.PlaceExpandableListAdapter;
import com.android.tonight8.base.BaseActivity;
import com.lidroid.xutils.view.annotation.ViewInject;

/**
 * @Description:兑奖地点管理
 * @author LiuZhao
 * @Date2014-12-29 下午11:17:20
 */
public class EventsPlaceManageActivity extends BaseActivity {
	/** */
	@ViewInject(R.id.elv_eventplace)
	private ExpandableListView expandableListView;
	private PlaceExpandableListAdapter adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		setContentView(R.layout.activity_events_place_setting);
		super.onCreate(savedInstanceState);
		getActionBarBase("兑奖地点管理");

	}

	private void initData(){
		adapter = new PlaceExpandableListAdapter();
		expandableListView.setAdapter(adapter);
	}
}
