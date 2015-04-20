package com.android.tonight8.adapter.wish;

import java.util.List;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.android.tonight8.R;
import com.android.tonight8.adapter.BaseListAdapter;
import com.android.tonight8.adapter.ViewHolder;

/**
 * @author lz 心愿赞助列表数据
 * 
 */
public class WishSponsorAdapter extends BaseListAdapter<String> {

	public WishSponsorAdapter(Context context, List<String> values) {
		super(context, values);

	}

	@Override
	protected View getItemView(View convertView, int position) {
		convertView = mInflater.inflate(R.layout.adapter_wish_sponsor, null);
		TextView tv_shopname = ViewHolder.get(convertView, R.id.tv_wish_orgpname);
		TextView tv_moneycount = ViewHolder.get(convertView, R.id.tv_moneycount);
		TextView tv_wish_orgrequest = ViewHolder.get(convertView, R.id.tv_wish_orgrequest);
		tv_moneycount.setText("赞助：1000元");
		tv_wish_orgrequest.setText("赞助：1000元");
		return convertView;
	}

}
