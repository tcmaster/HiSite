package com.android.tonight8.activity.createevent;

import java.util.List;
import android.os.Bundle;
import android.os.Handler;
import com.android.tonight8.R;
import com.android.tonight8.adapter.event.EventAwardListAdapter;
import com.android.tonight8.base.BaseActivity;
import com.android.tonight8.io.HandlerConstants;
import com.android.tonight8.model.manageevent.ManageAwardModel;
import com.android.tonight8.view.XListView;
import com.lidroid.xutils.view.annotation.ViewInject;

/**
 * @Description:活动中奖名单
 * @author LiuZhao
 * @Date2014-12-29 下午11:28:19
 */
public class EventsAwardListActivity extends BaseActivity {

	/** 活动中奖名单数据适配器 */
	private EventAwardListAdapter listAdapter;
	@ViewInject(R.id.lv_only_list)
	private XListView lv_only_list;
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
		public void handleMessage(android.os.Message msg) {
			switch (msg.arg1) {
			case HandlerConstants.RESULT_OK:
				if (msg.obj == null)
					return;
				List<ManageAwardModel> data = (List<ManageAwardModel>) msg.obj;
				if (msg.arg2 == INIT) {
					if (data == null || data.size() < ITEM_COUNT)
						lv_only_list.setPullLoadEnable(false);
					else
						lv_only_list.setPullLoadEnable(true);
					listAdapter = new EventAwardListAdapter(mContext, data);
					lv_only_list.setAdapter(listAdapter);
				} else if (msg.arg2 == REFRESH) {

					if (data == null || data.size() < ITEM_COUNT)
						lv_only_list.setPullLoadEnable(false);
					listAdapter.initData(data);
					lv_only_list.stopRefresh();
				} else if (msg.arg2 == LOAD_MORE) {
					if (data == null || data.size() < ITEM_COUNT)
						lv_only_list.setPullLoadEnable(false);
					listAdapter.addData(data);
					lv_only_list.stopLoadMore();
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
		getActionBarBase("中奖名单");
		initData();
	}

	private void initData() {
		
	}

}
