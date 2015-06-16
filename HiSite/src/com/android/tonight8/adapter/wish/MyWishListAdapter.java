package com.android.tonight8.adapter.wish;

import java.util.List;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;

import com.android.tonight8.R;
import com.android.tonight8.activity.wish.MyWishActivity;
import com.android.tonight8.activity.wish.WishLiveActivity;
import com.android.tonight8.adapter.BaseListAdapter;
import com.android.tonight8.adapter.ViewHolder;
import com.android.tonight8.dao.entity.WishSponsor;
import com.android.tonight8.dao.model.wish.MyWishListModel;
import com.android.tonight8.view.ListViewForScrollView;
import com.android.tonight8.view.MyProgressBar;

/**
 * @author lz 我发布的心愿列表
 */
public class MyWishListAdapter extends BaseListAdapter<MyWishListModel> {

	private Drawable downDrawable = getContext().getResources().getDrawable(
			R.drawable.vblackarrow);
	private Drawable upDrawable = getContext().getResources().getDrawable(
			R.drawable.vblackarrow_up);

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

		TextView tv_enterlive = ViewHolder.get(convertView, R.id.tv_enterlive);
		TextView tv_mywish_edit = ViewHolder.get(convertView,
				R.id.tv_mywish_edit);
		TextView tv_post_end = ViewHolder.get(convertView, R.id.tv_post_end);
		TextView tv_mywishpost_theme = ViewHolder.get(convertView,
				R.id.tv_mywishpost_theme);
		TextView tv_support_count = ViewHolder.get(convertView,
				R.id.tv_support_count);
		MyProgressBar pb_mywish_progress = ViewHolder.get(convertView,
				R.id.pb_mywish_progress);
		final CheckBox cb_check_sponsor = ViewHolder.get(convertView,
				R.id.cb_check_sponsor);
		final ListViewForScrollView lv_mywish_listview = ViewHolder.get(
				convertView, R.id.lv_mywish_listview);
		MyWishListModel model = mValues.get(position);
		tv_enterlive.setTag(position);
		tv_mywish_edit.setTag(position);
		tv_post_end.setTag(position);
		tv_enterlive.setOnClickListener(onClickListener);
		tv_mywish_edit.setOnClickListener(onClickListener);
		tv_post_end.setOnClickListener(onClickListener);
		tv_support_count.setText(model.getWish().getSupportCount() + "");
		tv_mywishpost_theme.setText(model.getWish().getName());
		pb_mywish_progress.setProgress(20);
		lv_mywish_listview.setTag(position);
		cb_check_sponsor
				.setOnCheckedChangeListener(new OnCheckedChangeListener() {

					@Override
					public void onCheckedChanged(CompoundButton buttonView,
							boolean isChecked) {
						if (isChecked) {
							lv_mywish_listview.setVisibility(View.VISIBLE);
							mValues.get(position).setChecked(true);
							cb_check_sponsor.setCompoundDrawables(null, null,
									upDrawable, null);
						} else {
							lv_mywish_listview.setVisibility(View.GONE);
							mValues.get(position).setChecked(false);
							cb_check_sponsor.setCompoundDrawables(null, null,
									downDrawable, null);
						}

					}
				});
		if (mValues.get(position).isChecked()) {
			lv_mywish_listview.setVisibility(View.VISIBLE);
			cb_check_sponsor.setCompoundDrawables(null, null, upDrawable, null);
		} else {
			lv_mywish_listview.setVisibility(View.GONE);
			cb_check_sponsor.setCompoundDrawables(null, null, downDrawable,
					null);
		}
		List<WishSponsor> list = model.getWishSponsors();
		CheckSponsorAdapter adapter = new CheckSponsorAdapter(mContext, list);
		lv_mywish_listview.setAdapter(adapter);

		return convertView;
	}

	private OnClickListener onClickListener = new OnClickListener() {

		@Override
		public void onClick(View v) {

			switch (v.getId()) {
			case R.id.tv_enterlive:
				int pos = (Integer) v.getTag();
				mContext.startActivity(new Intent(mContext,
						WishLiveActivity.class));
				break;
			case R.id.tv_mywish_edit:

				break;
			case R.id.tv_post_end:

				break;
			default:
				break;
			}
		}
	};

}
