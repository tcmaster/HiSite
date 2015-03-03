package com.android.tonight8.activity.org;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;

import com.android.tonight8.R;
import com.android.tonight8.adapter.org.MessageListAdapter;
import com.android.tonight8.base.BaseActivity;
import com.android.tonight8.model.common.Notice;
import com.android.tonight8.view.XListView;
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
	private List<Notice> list;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		setContentView(R.layout.activity_org_message_list);
		super.onCreate(savedInstanceState);
		getActionBarBase("消息列表");
		initData();
	}

	private void initData() {
		list = new ArrayList<Notice>();
		listAdapter = new MessageListAdapter(mContext, list);
		lv_only_list.setAdapter(listAdapter);
	}
}
