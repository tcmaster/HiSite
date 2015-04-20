package com.android.tonight8.activity.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

import com.android.tonight8.R;
import com.android.tonight8.adapter.user.TMessageListAdapter;
import com.android.tonight8.dao.entity.TMessage;
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
public class MessageListActivity extends Activity {

	/** 消息列表 */
	@ViewInject(R.id.lv_message_list)
	private XListView lv_message_list;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		setContentView(R.layout.activity_message_list);
		super.onCreate(savedInstanceState);
		lv_message_list
				.setAdapter(new TMessageListAdapter(this, getTestData()));
	}

	@OnItemClick(R.id.lv_message_list)
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		Intent intent = new Intent(MessageListActivity.this,
				MessageDetailActivity.class);
		intent.putExtra("userName",
				((TMessage) parent.getAdapter().getItem((int) id))
						.getUserName());
		startActivity(intent);
	}

	private List<TMessage> getTestData() {
		List<TMessage> list = new ArrayList<TMessage>();
		for (int i = 0; i < 5; i++) {
			TMessage message = new TMessage();
			message.setLastTime(new Date(System.currentTimeMillis())
					.toLocaleString());
			message.setUserLastMessage("老地方去吧" + i);
			message.setUserName("XX公司");
			message.setUserPic("http://img4.imgtn.bdimg.com/it/u=2352711400,4289515900&fm=11&gp=0.jpg");
			list.add(message);
		}
		return list;
	}
}
