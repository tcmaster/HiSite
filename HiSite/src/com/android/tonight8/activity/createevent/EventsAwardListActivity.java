package com.android.tonight8.activity.createevent;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import com.android.tonight8.R;
import com.android.tonight8.adapter.event.EventAwardListAdapter;
import com.android.tonight8.base.BaseActivity;
import com.android.tonight8.io.HandlerConstants;
import com.android.tonight8.model.manageevent.ManageAwardModel;
import com.android.tonight8.view.xlistview.XListView;
import com.lidroid.xutils.view.annotation.ViewInject;

/**
 * @Description:活动中奖名单
 * @author LiuZhao
 * @Date 2014-12-29 下午11:28:19
 */
public class EventsAwardListActivity extends BaseActivity {

	/** 活动中奖名单数据适配器 */
	private EventAwardListAdapter listAdapter;
	@ViewInject(R.id.lv_event_awardlist)
	private XListView lv_event_awardlist;
	/** 当前展示的页数 */
	private int current = 0;
	/** 每页显示的条数 */
	private final int ITEM_COUNT = 10;
	/** 下拉刷新标识 */
	private final int REFRESH = 1;
	/** 上拉加载标识 */
	private final int LOAD_MORE = 2;
	/** 首次加载标识 */
	private final int INIT = 3;
	private Handler handler = new Handler() {

		@Override
		public void handleMessage(Message msg) {
			switch (msg.arg1) {
			case HandlerConstants.RESULT_OK:
				if (msg.obj == null)
					return;
				List<ManageAwardModel> data = (List<ManageAwardModel>) msg.obj;
				if (msg.arg2 == INIT) {
					if (data == null || data.size() < ITEM_COUNT)
						lv_event_awardlist.setPullLoadEnable(false);
					else
						lv_event_awardlist.setPullLoadEnable(true);
					listAdapter = new EventAwardListAdapter(mContext, data);
					lv_event_awardlist.setAdapter(listAdapter);
				} else if (msg.arg2 == REFRESH) {

					if (data == null || data.size() < ITEM_COUNT)
						lv_event_awardlist.setPullLoadEnable(false);
					listAdapter.initData(data);
					lv_event_awardlist.stopRefresh();
				} else if (msg.arg2 == LOAD_MORE) {
					if (data == null || data.size() < ITEM_COUNT)
						lv_event_awardlist.setPullLoadEnable(false);
					listAdapter.addData(data);
					lv_event_awardlist.stopLoadMore();
				}
				break;
			case HandlerConstants.NETWORK_BEGIN:

				break;
			case HandlerConstants.NETWORK_END:

				break;
			case HandlerConstants.RESULT_FAIL:
				List<ManageAwardModel> datafail = (List<ManageAwardModel>) msg.obj;
				listAdapter.addData(datafail);
				break;
			default:
				break;
			}
			super.handleMessage(msg);
		}

	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		setContentView(R.layout.activity_event_award_list);
		super.onCreate(savedInstanceState);
		initData();
	}

	private void initData() {
		List<ManageAwardModel> list = new ArrayList<ManageAwardModel>();
		for (int i = 0; i < 10; i++) {
			ManageAwardModel model = new ManageAwardModel();
			list.add(model);
		}
		listAdapter = new EventAwardListAdapter(mContext, list);
		lv_event_awardlist.setPullLoadEnable(true);
		lv_event_awardlist.setAdapter(listAdapter);
	}

}
