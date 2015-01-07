/**
 * 2015-1-4
 */
package com.android.hisite.adapter;

import java.util.List;

import android.content.Context;
import android.view.View;

import com.android.hisite.R;

/**
 * @Description:
 * @author:LiXiaoSong
 * @see:
 * @since:
 * @copyright @HiSite
 * @Date:2015-1-4
 */
public class GoodLeftAdapter extends BaseListAdapter<String> {

	public GoodLeftAdapter(Context context, List<String> values) {
		super(context, values);
	}

	@Override
	protected View getItemView(View convertView, int position) {
		if (convertView == null) {
			convertView = mInflater.inflate(R.layout.item_fg_goods_detail_left, null, false);
		}
		return convertView;
	}

}
