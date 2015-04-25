package com.android.tonight8.activity.user;

import java.util.List;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

import com.android.tonight8.R;
import com.android.tonight8.adapter.user.TMessageListAdapter;
import com.android.tonight8.base.BaseActivity;
import com.android.tonight8.dao.TMessageDao;
import com.android.tonight8.dao.entity.TMessage;
import com.android.tonight8.easemob.MobConstants;
import com.android.tonight8.storage.GreenDaoUtils;
import com.android.tonight8.view.xlistview.XListView;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnItemClick;

/**
 * 消息通知列表页
 * 
 * @Descripton
 * @author LiXiaoSong
 * @2015-4-20
 * @Tonight8
 */
public class MessageListActivity extends BaseActivity {

	/** 消息列表 */
	@ViewInject(R.id.lv_message_list)
	private XListView lv_message_list;

	/** 本界面要对话的用户 */
	private String user_name;
	/** 本界面的适配器 */
	private TMessageListAdapter tmladapter;
	private MyReceiver receiver;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		setContentView(R.layout.activity_message_list);
		super.onCreate(savedInstanceState);
		initDatas();
	}

	private void initDatas() {
		receiver = new MyReceiver();
		IntentFilter filter = new IntentFilter(MobConstants.MESSAGE_GET);
		this.registerReceiver(receiver, filter);
	}

	@Override
	protected void onResume() {
		updateData();
		super.onResume();
	}

	@Override
	protected void onDestroy() {
		if (receiver != null)
			unregisterReceiver(receiver);
		super.onDestroy();
	}

	@OnItemClick(R.id.lv_message_list)
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		Intent intent = new Intent(MessageListActivity.this,
				MessageDetailActivity.class);
		if (tmladapter != null) {
			TMessage tMessage = (TMessage) tmladapter.getItem((int) id);
			intent.putExtra("userName", tMessage.getUserName());
			intent.putExtra("userLastMessage", tMessage.getUserLastMessage());
			startActivity(intent);
		}
	}

	/**
	 * 刷新本界面的数据
	 */
	public void updateData() {
		/**
		 * 从数据库得到所有聊天数据
		 */
		TMessageDao dao = GreenDaoUtils.getDaoSession().getTMessageDao();
		List<TMessage> src = dao.loadAll();
		if (tmladapter == null) {
			tmladapter = new TMessageListAdapter(this, src);
			lv_message_list.setAdapter(tmladapter);
		} else {
			tmladapter.update(src);
		}
		lv_message_list.setSelection(tmladapter.getCount());
	}

	private class MyReceiver extends BroadcastReceiver {

		@Override
		public void onReceive(Context context, Intent intent) {
			updateData();
		}

	}
}
