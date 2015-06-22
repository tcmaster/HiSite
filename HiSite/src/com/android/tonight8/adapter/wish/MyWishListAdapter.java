package com.android.tonight8.adapter.wish;

import java.util.List;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

import com.android.tonight8.R;
import com.android.tonight8.activity.wish.MyWishActivity;
import com.android.tonight8.activity.wish.MyWishSponsorActivity;
import com.android.tonight8.activity.wish.WishProcessPostActivity;
import com.android.tonight8.adapter.BaseListAdapter;
import com.android.tonight8.adapter.ViewHolder;
import com.android.tonight8.dao.model.wish.MyWishListModel;
import com.android.tonight8.view.MyProgressBar;

/**
 * @author lz 我发布的心愿列表
 */
public class MyWishListAdapter extends BaseListAdapter<MyWishListModel> {

	public MyWishListAdapter(Context context, List<MyWishListModel> values) {
		super(context, values);
		mContext = (MyWishActivity) mContext;
	}

	@Override
	protected View getItemView(View convertView, final int position) {
		if (convertView == null) {
			convertView = mInflater.inflate(R.layout.adapter_mywish_list_post,
					null);
		}

		TextView tv_mywishpost_datetime = ViewHolder.get(convertView,
				R.id.tv_mywishpost_datetime);
		TextView tv_mywishpost_theme = ViewHolder.get(convertView,
				R.id.tv_mywishpost_theme);
		TextView tv_support_count = ViewHolder.get(convertView,
				R.id.tv_support_count);
		MyProgressBar pb_mywish_progress = ViewHolder.get(convertView,
				R.id.pb_mywish_progress);
		TextView tv_check_sponsor = ViewHolder.get(convertView,
				R.id.tv_check_sponsor);
		TextView tv_wish_progress = ViewHolder.get(convertView,
				R.id.tv_wish_progress);
		MyWishListModel model = mValues.get(position);

		tv_support_count.setText(model.getWish().getSupportCount() + "");
		tv_mywishpost_theme.setText(model.getWish().getName());
		pb_mywish_progress.setProgress(20);
		tv_mywishpost_datetime.setText(model.getWish().getPublishTime());
		tv_check_sponsor.setTag(position);
		tv_wish_progress.setTag(position);
		tv_check_sponsor.setOnClickListener(onClickListener);
		tv_wish_progress.setOnClickListener(onClickListener);
		return convertView;
	}

	private OnClickListener onClickListener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			int pos = (Integer) v.getTag();
			switch (v.getId()) {
			case R.id.tv_wish_progress:
				mContext.startActivity(new Intent(mContext,
						WishProcessPostActivity.class));
				break;
			case R.id.tv_check_sponsor:
				mContext.startActivity(new Intent(mContext,
						MyWishSponsorActivity.class));
				break;

			default:
				break;
			}
		}
	};

}
