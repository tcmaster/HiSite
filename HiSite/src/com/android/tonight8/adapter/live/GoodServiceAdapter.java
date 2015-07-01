package com.android.tonight8.adapter.live;

import java.util.List;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.android.tonight8.R;
import com.android.tonight8.adapter.BaseListAdapter;
import com.android.tonight8.adapter.ViewHolder;
import com.android.tonight8.dao.entity.GoodsService;

public class GoodServiceAdapter extends BaseListAdapter<GoodsService> {

	public GoodServiceAdapter(Context context, List<GoodsService> values) {
		super(context, values);
	}

	@Override
	protected View getItemView(View convertView, int position) {
		if (convertView == null)
			convertView = mInflater.inflate(R.layout.item_goods_promise, null);
		TextView tv_content = ViewHolder.get(convertView, R.id.tv_content);
		tv_content.setText(mValues.get(position).getContent());
		return convertView;
	}

}
