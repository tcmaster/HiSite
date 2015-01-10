/**
 * 2015-1-4
 */
package com.android.tonight8.adapter;

import java.util.List;

import android.content.Context;
import android.view.View;

import com.android.tonight8.R;

/**
 * @Description:
 * @author:LiXiaoSong
 * @see:
 * @since:
 * @copyright @tonight8
 * @Date:2015-1-4
 */
public class GoodRightAdapter extends BaseListAdapter<String> {

	public GoodRightAdapter(Context context, List<String> values) {
		super(context, values);
	}

	@Override
	protected View getItemView(View convertView, int position) {
		if (convertView == null) {
			convertView = mInflater.inflate(R.layout.item_fg_goods_detail_right, null, false);
		}
		return convertView;
	}

}
