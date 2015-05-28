package com.android.tonight8.activity.event;

import java.util.ArrayList;
import java.util.List;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;

import com.android.tonight8.R;
import com.android.tonight8.activity.createevent.UserAgreementActivity;
import com.android.tonight8.adapter.org.OrgEventListAdapter;
import com.android.tonight8.base.BaseActivity;
import com.android.tonight8.model.event.EventListModel;
import com.android.tonight8.view.xlistview.XListView;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnItemClick;

/**
 * @author lz 商家活动
 * 
 */
public class OrgEventListActivity extends BaseActivity {
	@ViewInject(R.id.lv_only_list)
	private XListView lv_only_list;
	private OrgEventListAdapter orgEventListAdapter;
	private List<EventListModel> list;
	private OnClickListener onClickListener = new OnClickListener() {

		@Override
		public void onClick(View arg0) {
			startActivityForAnima(new Intent(OrgEventListActivity.this,
					UserAgreementActivity.class), null);
		}
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		setContentView(R.layout.activity_only_list);
		super.onCreate(savedInstanceState);
		getActionBarNormal("我的活动", R.drawable.ic_launcher, onClickListener);
		list = new ArrayList<EventListModel>();
		for (int i = 0; i < 10; i++) {
			EventListModel event = new EventListModel();
			list.add(event);
		}

		orgEventListAdapter = new OrgEventListAdapter(mContext, list);
		lv_only_list.setAdapter(orgEventListAdapter);

	}

	@OnItemClick(R.id.lv_only_list)
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		Intent intent = new Intent(OrgEventListActivity.this,
				EventManageActivity.class);
		startActivityForAnima(intent, null);

	}
}
