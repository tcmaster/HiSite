package com.android.tonight8.adapter.wish;

import java.util.List;

import android.content.Context;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;

import com.android.tonight8.R;
import com.android.tonight8.activity.wish.WishSponsorActivity;
import com.android.tonight8.adapter.BaseListAdapter;
import com.android.tonight8.adapter.ViewHolder;
import com.android.tonight8.dao.entity.WishItem;

/**
 * @author lz心愿赞助
 * 
 */
public class WishSponorListAdapter extends BaseListAdapter<WishItem> {
	private WishSponsorActivity wActivity;

	public WishSponorListAdapter(Context context, List<WishItem> values) {
		super(context, values);
		wActivity = (WishSponsorActivity) mContext;
	}

	@Override
	protected View getItemView(View convertView, final int position) {
		convertView = mInflater.inflate(R.layout.adapter_sponsor_something,
				null);
		TextView tv_sponsor_name = ViewHolder.get(convertView,
				R.id.tv_sponsor_name);
		CheckBox cb_sponsor_something = ViewHolder.get(convertView,
				R.id.cb_sponsor_thing_title);
		TextView tv_sponsor_content = ViewHolder.get(convertView,
				R.id.tv_sponsor_content);
		WishItem wishItem = mValues.get(position);
		tv_sponsor_name.setText(wishItem.getName());
		tv_sponsor_content.setText(wishItem.getDescribe());
		// cb_sponsor_something.setChecked(wishItem.getIschecked());
		cb_sponsor_something
				.setOnCheckedChangeListener(new OnCheckedChangeListener() {

					@Override
					public void onCheckedChanged(CompoundButton arg0,
							boolean arg1) {
						// wActivity.updateAdaper(position, arg1);
					}
				});
		return convertView;
	}
}
