package com.android.tonight8.adapter.event;

import java.util.List;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.android.tonight8.R;
import com.android.tonight8.adapter.BaseListAdapter;
import com.android.tonight8.adapter.ViewHolder;
import com.android.tonight8.dao.model.event.PlayBillList;

public class PlayBillListAdapter extends BaseListAdapter<PlayBillList> {

	public PlayBillListAdapter(Context context, List<PlayBillList> values) {
		super(context, values);
	}

	@Override
	protected View getItemView(View convertView, int position) {
		PlayBillList model = mValues.get(position);
		if (convertView == null)
			convertView = mInflater.inflate(R.layout.item_play_bill_list, null);
		if (position % 2 == 0)
			convertView.setBackgroundColor(mContext.getResources().getColor(
					R.color.white));
		else
			convertView.setBackgroundColor(mContext.getResources().getColor(
					R.color.white_gray));
		TextView tv_time = ViewHolder.get(convertView, R.id.tv_time);
		TextView tv_content = ViewHolder.get(convertView, R.id.tv_content);
		tv_time.setText(model.getPlaybill().getTime());
		tv_content.setText(model.getPlaybill().getContent());
		return convertView;
	}

	public void updateData(List<PlayBillList> data) {
		mValues.clear();
		mValues.addAll(data);
		notifyDataSetChanged();
	}

}
