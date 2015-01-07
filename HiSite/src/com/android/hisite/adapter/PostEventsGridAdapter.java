package com.android.hisite.adapter;

import java.util.List;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.android.hisite.R;

public class PostEventsGridAdapter extends BaseListAdapter {

	public PostEventsGridAdapter(Context context, List values) {
		super(context, values);
	}

	@Override
	protected View getItemView(View convertView, int position) {
		Viewholder holder;
		if (convertView == null) {
			holder = new Viewholder();
			convertView = mInflater.inflate(R.layout.adapter_postevents_grid, null);
			holder.tv_grid_title = (TextView) convertView.findViewById(R.id.tv_grid_title);
		} else {
			holder = (Viewholder) convertView.getTag();
		}

		return convertView;
	}

	class Viewholder {

		TextView tv_grid_title;
	}

}
