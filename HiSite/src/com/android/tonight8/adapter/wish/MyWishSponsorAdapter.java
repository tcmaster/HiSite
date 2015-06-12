package com.android.tonight8.adapter.wish;

import java.util.List;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.tonight8.R;
import com.android.tonight8.adapter.BaseListAdapter;
import com.android.tonight8.adapter.ViewHolder;
import com.android.tonight8.model.wish.MyWishSponsorListModel;

/**
 * @author lz我的心愿赞助
 * 
 */
public class MyWishSponsorAdapter extends
		BaseListAdapter<MyWishSponsorListModel> {

	public MyWishSponsorAdapter(Context context,
			List<MyWishSponsorListModel> values) {
		super(context, values);

	}

	@Override
	protected View getItemView(View convertView, int position) {
		if (convertView == null) {
			convertView = mInflater.inflate(R.layout.adapter_my_wish_sponsor,
					null);
		}

		ImageView civ_mywish_userpic = ViewHolder.get(convertView,
				R.id.civ_mywish_userpic);
		TextView tv_mywish_username = ViewHolder.get(convertView,
				R.id.tv_mywish_username);
		// ImageView civ_mywish_userpic = ViewHolder.get(convertView,
		// R.id.civ_mywish_userpic);
		// ImageView civ_mywish_userpic = ViewHolder.get(convertView,
		// R.id.civ_mywish_userpic);
		// ImageView civ_mywish_userpic = ViewHolder.get(convertView,
		// R.id.civ_mywish_userpic);
		// ImageView civ_mywish_userpic = ViewHolder.get(convertView,
		// R.id.civ_mywish_userpic);
		return convertView;
	}

}
