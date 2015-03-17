package com.android.tonight8.activity.event;

import java.util.ArrayList;
import java.util.List;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

import com.android.tonight8.R;
import com.android.tonight8.adapter.event.EventExchangeAdapter;
import com.android.tonight8.base.BaseActivity;
import com.android.tonight8.view.xlistview.XListView;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnItemClick;

/**
 * 活动兑奖地址
 * 
 * @author LiXiaoSong
 * 
 */
public class EventExchangeActivity extends BaseActivity {

	// ***************************控件成员***********************************//
	/** 中奖名单列表 */
	@ViewInject(R.id.lv_award_or_exchange)
	private XListView lv_award;

	// ***************************其他成员***********************************//
	// ***************************生命周期,回调方法***********************************//
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		setContentView(R.layout.activity_event_award_or_exchange);
		super.onCreate(savedInstanceState);
		getActionBarBase("中奖名单");
		initData();
	}

	// ***************************子方法***********************************//
	private void initData() {
		List<String> data = new ArrayList<String>();
		data.add("");
		data.add("");
		data.add("");
		lv_award.setAdapter(new EventExchangeAdapter(this, data));
	}

	@OnItemClick(R.id.lv_award_or_exchange)
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		Intent intent = new Intent(this, ExchangeLocationActivity.class);
		startActivity(intent);
	}
}
