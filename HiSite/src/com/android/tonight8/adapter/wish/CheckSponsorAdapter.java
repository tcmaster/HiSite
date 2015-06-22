package com.android.tonight8.adapter.wish;

import java.util.List;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.android.tonight8.R;
import com.android.tonight8.adapter.BaseListAdapter;
import com.android.tonight8.adapter.ViewHolder;
import com.android.tonight8.dao.model.wish.MyWishSponsorListModel;
import com.android.tonight8.view.CircleImageView;

/**
 * @author lz 我的心愿赞助列表
 * 
 */
public class CheckSponsorAdapter extends
		BaseListAdapter<MyWishSponsorListModel> {

	public CheckSponsorAdapter(Context context,
			List<MyWishSponsorListModel> values) {
		super(context, values);

	}

	@Override
	protected View getItemView(View convertView, int position) {
		if (convertView == null) {
			convertView = mInflater.inflate(R.layout.adapter_check_sponsor,
					null);
		}

		CircleImageView civ_mywish_userpic = ViewHolder.get(convertView,
				R.id.civ_mywishcheck_userpic);
		TextView tv_mywishcheck_username = ViewHolder.get(convertView,
				R.id.tv_mywishcheck_username);
		TextView tv_mywishcheck_sponsortype = ViewHolder.get(convertView,
				R.id.tv_mywishcheck_sponsortype);
		TextView tv_mywishcheck_sponsoritem = ViewHolder.get(convertView,
				R.id.tv_mywishcheck_sponsoritem);
		TextView tv_mywishcheck_sponsorrequest = ViewHolder.get(convertView,
				R.id.tv_mywishcheck_sponsorrequest);
		Button btn_accept = ViewHolder.get(convertView, R.id.btn_check_accept);
		Button btn_refuse = ViewHolder.get(convertView, R.id.btn_check_refuse);

		if (mValues != null) {
			MyWishSponsorListModel myModel = mValues.get(position);
			tv_mywishcheck_username.setText("北京相宜本化妆品有限公司");
			tv_mywishcheck_sponsorrequest.setText(myModel.getWishSponsor()
					.getDescribe());
			tv_mywishcheck_sponsoritem.setText("赞助的项目");
			tv_mywishcheck_sponsortype.setText(myModel.getWishSponsor()
					.getType() + "");
		}
		// bmUtils.display(civ_mywish_userpic, myModel.get);

		btn_accept.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

			}
		});
		btn_refuse.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

			}
		});
		return convertView;
	}
}
