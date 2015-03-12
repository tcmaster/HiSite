/**
 * 2015-1-4
 */
package com.android.tonight8.adapter.event;

import java.util.List;

import android.content.Context;
import android.view.View;

import com.android.tonight8.R;
import com.android.tonight8.adapter.BaseListAdapter;
import com.android.tonight8.model.common.Goods;

/**
 * @Description:
 * @author:LiXiaoSong
 * @see:
 * @since:
 * @copyright @tonight8
 * @Date:2015-1-4
 */
public class GoodLeftAdapter extends BaseListAdapter<Goods> {

	public GoodLeftAdapter(Context context, List<Goods> values) {
		super(context, values);
	}

	@Override
	protected View getItemView(View convertView, int position) {
		if (convertView == null) {
			convertView = mInflater.inflate(R.layout.item_fg_goods_detail_left, null, false);
		}
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
