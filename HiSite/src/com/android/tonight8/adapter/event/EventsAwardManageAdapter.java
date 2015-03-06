package com.android.tonight8.adapter.event;

import java.util.List;

import android.content.Context;
import android.view.View;

import com.android.tonight8.R;
import com.android.tonight8.adapter.BaseListAdapter;
import com.android.tonight8.model.event.EventAwardModel;

/**
 * @Description:活动中奖管理数据适配器
 * @author:LiuZhao
 * @Date:2015年2月2日
 */
public class EventsAwardManageAdapter extends BaseListAdapter<EventAwardModel> {

	public EventsAwardManageAdapter(Context context, List<EventAwardModel> values) {
		super(context, values);

	}

	@Override
	protected View getItemView(View convertView, int position) {
		if (convertView == null) {
			convertView = mInflater.inflate(R.layout.adapter_event_award_item, null, false);
		}

		return convertView;
	}

}
