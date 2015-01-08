/**
 * 2015-1-8
 */
package com.android.hisite.adapter;

import java.util.List;

import android.content.Context;
import android.view.View;

import com.android.hisite.R;

/**
 * @Description:商品详情界面所有活动地点的适配器
 * @author:LiXiaoSong
 * @see:
 * @since:
 * @copyright @HiSite
 * @Date:2015-1-8
 */
public class AllPrizeLocationAdapter extends BaseListAdapter<String> {

	public AllPrizeLocationAdapter(Context context, List<String> values) {
		super(context, values);
	}

	@Override
	protected View getItemView(View convertView, int position) {
		if (convertView == null) {
			convertView = mInflater.inflate(R.layout.item_dg_list, null, false);
		}
		return convertView;
	}

}
