package com.android.tonight8.adapter.wish;

import java.util.List;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.tonight8.R;
import com.android.tonight8.adapter.BaseListAdapter;
import com.android.tonight8.adapter.ViewHolder;
import com.android.tonight8.dao.model.wish.MyWishSponsorListModel;

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
				R.id.civ_mywishsponsor_userpic);
		TextView tv_mywish_username = ViewHolder.get(convertView,
				R.id.tv_mywishsponsor_username);
		TextView tv_mywish_theme = ViewHolder.get(convertView,
				R.id.tv_mywishsponsor_theme);
		TextView tv_mywish_sponsortype = ViewHolder.get(convertView,
				R.id.tv_mywishsponsor_type);
		TextView tv_mywish_sponsoritem = ViewHolder.get(convertView,
				R.id.tv_mywishsponsor_item);
		TextView tv_mywish_sponsorrequest = ViewHolder.get(convertView,
				R.id.tv_mywishsponsor_request);
		MyWishSponsorListModel myModel = mValues.get(position);
		if (myModel != null) {
			bmUtils.display(civ_mywish_userpic, myModel.getUser().getPic());
			tv_mywish_username.setText(myModel.getUser().getName());
			tv_mywish_theme.setText(myModel.getWish().getName());
			tv_mywish_sponsortype.setText(myModel.getWishSponsor().getStatus()+"");
			tv_mywish_sponsoritem.setText(myModel.getWishItem().getValue()
					+ myModel.getWishItem().getDescribe());
			tv_mywish_sponsorrequest.setText(myModel.getWishSponsor()
					.getDescribe());
		}

		return convertView;
	}

}
