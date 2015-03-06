package com.android.tonight8.adapter.event;

import java.util.List;

import android.content.Context;
import android.view.View;

import com.android.tonight8.R;
import com.android.tonight8.adapter.BaseListAdapter;
import com.android.tonight8.model.manageevent.ManageAwardModel;

/**
 * @Description：活动中奖名单
 * @date 2015-3-5下午9:49:37
 * @author liuzhao
 */
public class EventAwardListAdapter extends BaseListAdapter<ManageAwardModel> {

	public EventAwardListAdapter(Context context, List<ManageAwardModel> values) {
		super(context, values);

	}

	@Override
	protected View getItemView(View convertView, int position) {
		if (convertView == null) {
			convertView = mInflater.inflate(R.layout.adapter_event_award_list_item, null, false);
		}

		return convertView;
	}
}
