/**
 * 2015-1-4
 */
package com.android.tonight8.adapter.event;

import java.util.List;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.tonight8.R;
import com.android.tonight8.adapter.BaseListAdapter;
import com.android.tonight8.adapter.ViewHolder;
import com.android.tonight8.model.common.Goods;

public class GoodLeftAdapter extends BaseListAdapter<Goods> {

	public GoodLeftAdapter(Context context, List<Goods> values) {
		super(context, values);
	}

	@Override
	protected View getItemView(View convertView, int position) {
		Goods goods = mValues.get(position);
		if (convertView == null) {
			convertView = mInflater.inflate(R.layout.item_fg_goods_detail_left,
					null, false);
		}
		ImageView iv_activity_img = ViewHolder.get(convertView,
				R.id.iv_activity_img);
		TextView tv_goods_info = ViewHolder
				.get(convertView, R.id.tv_goods_info);
		bmUtils.display(iv_activity_img, goods.pic);
		tv_goods_info.setText(goods.name + " 价格：" + goods.price + "元");
		return convertView;
	}

	/**
	 * 增加数据
	 */
	public void addData(List<Goods> data) {
		mValues.addAll(data);
		notifyDataSetChanged();
	}

	/**
	 * 刷新数据
	 */
	public void updateData(List<Goods> data) {
		mValues.clear();
		mValues.addAll(data);
		notifyDataSetChanged();
	};

}
