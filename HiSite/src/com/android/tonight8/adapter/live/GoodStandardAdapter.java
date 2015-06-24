package com.android.tonight8.adapter.live;

import java.util.List;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.android.tonight8.R;
import com.android.tonight8.adapter.BaseListAdapter;
import com.android.tonight8.adapter.ViewHolder;
import com.android.tonight8.dao.entity.GoodsStandard;

/**
 * @Descripton 商品规格
 * @author LiXiaoSong
 * @2015-6-24
 * @Tonight8
 */
public class GoodStandardAdapter extends BaseListAdapter<GoodsStandard> {

	public GoodStandardAdapter(Context context, List<GoodsStandard> values) {
		super(context, values);
	}

	@Override
	protected View getItemView(View convertView, int position) {
		GoodsStandard model = mValues.get(position);
		if (convertView == null)
			convertView = mInflater.inflate(R.layout.item_goods_style, null);
		TextView tv_style_name = ViewHolder
				.get(convertView, R.id.tv_style_name);
		TextView tv_style = ViewHolder.get(convertView, R.id.tv_style);
		tv_style_name.setText(model.getContent());
		tv_style.setText(model.getContent());
		return convertView;
	}

}
