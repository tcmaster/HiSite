package com.android.tonight8.adapter.wish;

import java.util.List;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;

import com.android.tonight8.R;
import com.android.tonight8.adapter.BaseListAdapter;
import com.android.tonight8.adapter.ViewHolder;
import com.android.tonight8.model.wish.MyWishListModel;

/**
 * @author lz 我的心愿列表
 */
public class MyWishListAdapter extends BaseListAdapter<MyWishListModel> {



	public MyWishListAdapter(Context context, List<MyWishListModel> values) {
		super(context, values);

	}

	@Override
	protected View getItemView(View convertView, int position) {
		if (convertView == null) {
			convertView = mInflater.inflate(R.layout.adapter_my_wish_list, null);
		}

		ImageView iv_wishpic = ViewHolder.get(convertView, R.id.iv_wishpic);
		return convertView;
	}

}
