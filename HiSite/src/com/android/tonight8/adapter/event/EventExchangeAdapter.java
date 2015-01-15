/**
 * 2015-1-8
 */
package com.android.tonight8.adapter.event;

import java.util.List;

import android.content.Context;
import android.view.View;

import com.android.tonight8.R;
import com.android.tonight8.adapter.BaseListAdapter;

/**
 * @Description:查看所有领奖地点的适配器
 * @author:LiXiaoSong
 * @copyright @tonight8
 * @Date:2015-1-8
 */
public class EventExchangeAdapter extends BaseListAdapter<String> {

	public EventExchangeAdapter(Context context, List<String> values) {
		super(context, values);
	}

	@Override
	protected View getItemView(View convertView, int position) {
		if (convertView == null) {
			convertView = mInflater.inflate(R.layout.item_event_exchange, null,
					false);
		}
		return convertView;
	}

}
