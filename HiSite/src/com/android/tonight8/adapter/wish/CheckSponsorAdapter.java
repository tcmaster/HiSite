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
import com.android.tonight8.dao.entity.WishSponsor;
import com.android.tonight8.utils.Utils;

/**
 * @author lz 我的心愿赞助列表
 * 
 */
public class CheckSponsorAdapter extends BaseListAdapter<WishSponsor> {

	public CheckSponsorAdapter(Context context, List<WishSponsor> values) {
		super(context, values);

	}

	@Override
	protected View getItemView(View convertView, int position) {
		if (convertView == null) {
			convertView = mInflater.inflate(R.layout.adapter_check_sponsor,
					null);
		}

		// CircleImageView civ_mywish_userpic = ViewHolder.get(convertView,
		// R.id.civ_mywishcheck_userpic);
		TextView tv_mywishcheck_username = ViewHolder.get(convertView,
				R.id.tv_mywishcheck_username);
		TextView tv_mywishcheck_sponsortype = ViewHolder.get(convertView,
				R.id.tv_mywishcheck_sponsortype);
		TextView tv_mywishcheck_sponsoritem = ViewHolder.get(convertView,
				R.id.tv_mywishcheck_sponsoritem);
		TextView tv_mywishcheck_sponsorrequest = ViewHolder.get(convertView,
				R.id.tv_mywishcheck_sponsorrequest);
		final Button btn_accept = ViewHolder.get(convertView,
				R.id.btn_check_accept);
		final Button btn_refuse = ViewHolder.get(convertView,
				R.id.btn_check_refuse);
		WishSponsor myModel = mValues.get(position);
		if (myModel != null) {
			tv_mywishcheck_sponsorrequest.setText(myModel.getDescribe());
			tv_mywishcheck_sponsoritem.setText("赞助的项目");
			tv_mywishcheck_sponsortype.setText(myModel.getStatus() + "");
		}
		btn_accept.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				Utils.toast("");
				btn_accept.setText("已经接受邀请");
			}
		});
		btn_refuse.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				btn_accept.setText("已经拒绝邀请");
			}
		});
		return convertView;
	}
}
