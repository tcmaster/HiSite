package com.android.tonight8.activity.createevent;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.widget.ListView;

import com.android.tonight8.R;
import com.android.tonight8.adapter.event.EventsAwardManageAdapter;
import com.android.tonight8.base.BaseActivity;
import com.android.tonight8.model.event.EventAwardModel;
import com.lidroid.xutils.view.annotation.ViewInject;

/**
 * @Description:活动中奖管理
 * @author LiuZhao
 * @Date2014-12-29 下午11:26:28
 */
public class EventsAwardManageActivity extends BaseActivity {

	/** 活动中奖管理 */
	@ViewInject(R.id.lv_only_list)
	private ListView lv_award_manage;
	/** 活动中奖管理数据适配器 */
	private EventsAwardManageAdapter eventAwardAdapter;
	private List<EventAwardModel> list;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		setContentView(R.layout.activity_award_manage);
		super.onCreate(savedInstanceState);
		// initData();
	}

	private void initData() {
		list = new ArrayList<EventAwardModel>();
		eventAwardAdapter = new EventsAwardManageAdapter(mContext, list);
		lv_award_manage.setAdapter(eventAwardAdapter);
	}

}
