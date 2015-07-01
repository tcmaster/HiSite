package com.android.tonight8.activity.event;

import java.util.ArrayList;
import java.util.List;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;

import com.android.tonight8.R;
import com.android.tonight8.activity.createevent.UserAgreementActivity;
import com.android.tonight8.adapter.org.OrgEventListAdapter;
import com.android.tonight8.base.BaseActivity;
import com.android.tonight8.io.HandlerConstants;
import com.android.tonight8.model.event.EventListModel;
import com.android.tonight8.view.xlistview.XListView;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnItemClick;

/**
 * @author lz 商家活动
 * 
 */
public class OrgEventListActivity extends BaseActivity {
	@ViewInject(R.id.lv_orgeventlist)
	private XListView listview;
	private OrgEventListAdapter orgEventListAdapter;
	private List<EventListModel> list;
	private OnClickListener onClickListener = new OnClickListener() {

		@Override
		public void onClick(View arg0) {
			startActivityForAnima(new Intent(OrgEventListActivity.this,
					UserAgreementActivity.class), null);
		}
	};
	private Handler handler = new Handler() {

		@Override
		public void handleMessage(Message msg) {
			super.handleMessage(msg);

			if (msg.what == HandlerConstants.WISH.WISH_SPONOR_LIST) {

				if (msg.arg1 == HandlerConstants.RESULT_OK) {// 网络数据获取成功
					List<EventListModel> models = (List<EventListModel>) msg.obj;
					if (msg.arg2 == REFRESH) {

					}
				}
			}
		}

	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		initCreateNomal(savedInstanceState, R.layout.activity_org_eventlist);
		getActionBarNormal("我的活动", R.drawable.vadd, onClickListener);
		list = new ArrayList<EventListModel>();
		for (int i = 0; i < 10; i++) {
			EventListModel event = new EventListModel();
			list.add(event);
		}

		orgEventListAdapter = new OrgEventListAdapter(mContext, list);
		listview.setAdapter(orgEventListAdapter);

	}

	@OnItemClick(R.id.lv_only_list)
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		Intent intent = new Intent(OrgEventListActivity.this,
				EventManageActivity.class);
		startActivityForAnima(intent, null);

	}
}
