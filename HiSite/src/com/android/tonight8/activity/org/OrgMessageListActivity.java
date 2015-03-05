package com.android.tonight8.activity.org;

import java.util.List;

import android.os.Bundle;
import android.os.Handler;

import com.android.tonight8.R;
import com.android.tonight8.adapter.org.MessageListAdapter;
import com.android.tonight8.base.BaseActivity;
import com.android.tonight8.io.HandlerConstants;
import com.android.tonight8.io.org.OrgIOController;
import com.android.tonight8.model.organization.OrgMessageModel;
import com.android.tonight8.storage.org.OrgLoginNativeController;
import com.android.tonight8.view.XListView;
import com.android.tonight8.view.XListView.IXListViewListener;
import com.lidroid.xutils.view.annotation.ViewInject;

/**
 * @Description:商家消息列表
 * @author:LiuZhao
 * @Date:2015年3月3日
 */
public class OrgMessageListActivity extends BaseActivity {

	/** 商家消息列表 */
	@ViewInject(R.id.lv_only_list)
	private XListView lv_only_list;
	private MessageListAdapter listAdapter;
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
	/** 商家id */
	private String orgId;
	private Handler handler = new Handler() {

		@Override
		public void handleMessage(android.os.Message msg) {
			switch (msg.arg1) {
			case HandlerConstants.RESULT_OK:
				if (msg.obj == null)
					return;
				List<OrgMessageModel> data = (List<OrgMessageModel>) msg.obj;
				if (msg.arg2 == INIT) {
					if (data == null || data.size() < ITEM_COUNT)
						lv_only_list.setPullLoadEnable(false);
					else
						lv_only_list.setPullLoadEnable(true);
					listAdapter = new MessageListAdapter(mContext, data);
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
				List<OrgMessageModel> datafail = (List<OrgMessageModel>) msg.obj;
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
		setContentView(R.layout.activity_org_message_list);
		super.onCreate(savedInstanceState);
		getActionBarBase("消息列表");
		initData();
	}

	private void initData() {
		OrgLoginNativeController orgLoginNativeController = new OrgLoginNativeController(mContext);
		orgId = orgLoginNativeController.getOrgLoginInfo();
		if (orgId != null) {
			OrgIOController.OrgMessageListRead(handler, orgId, INIT, ITEM_COUNT, current * ITEM_COUNT);
		}
		lv_only_list.setXListViewListener(new IXListViewListener() {// 设置上拉下拉事件

			@Override
			public void onRefresh() {
				current = 0;// 回归0页
				lv_only_list.setPullLoadEnable(true);
				OrgIOController.OrgMessageListRead(handler, orgId, REFRESH, ITEM_COUNT, current * ITEM_COUNT);
			}

			@Override
			public void onLoadMore() {
				current++;
				OrgIOController.OrgMessageListRead(handler, orgId, LOAD_MORE, ITEM_COUNT, current * ITEM_COUNT);
			}
		});
	}
}
