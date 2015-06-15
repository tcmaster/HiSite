package com.android.tonight8.adapter.wish;

import java.util.List;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.android.tonight8.R;
import com.android.tonight8.adapter.BaseListAdapter;
import com.android.tonight8.adapter.ViewHolder;
import com.android.tonight8.dao.model.wish.WishSponsorList;
import com.android.tonight8.view.CircleImageView;

/**
 * @author lz 心愿赞助列表数据
 * 
 */
public class WishSponsorAdapter extends BaseListAdapter<WishSponsorList> {

	public WishSponsorAdapter(Context context, List<WishSponsorList> values) {
		super(context, values);

	}

	@Override
	protected View getItemView(View convertView, int position) {
		convertView = mInflater.inflate(R.layout.adapter_wish_sponsor, null);
		TextView tv_sponsor_orgname = ViewHolder.get(convertView,
				R.id.tv_sponsor_orgname);
		TextView tv_sponsormoney = ViewHolder.get(convertView,
				R.id.tv_sponsormoney);
		TextView tv_sponsor_orgrequest = ViewHolder.get(convertView,
				R.id.tv_sponsor_orgrequest);
		CircleImageView iv_sponsor_orglogopic = ViewHolder.get(convertView,
				R.id.iv_sponsor_orglogopic);
		WishSponsorList wishSponsorList = mValues.get(position);

		// bmUtils.display(iv_sponsor_orglogopic,
		// wishSponsorList.getWishSponsor().getPic());
		// tv_sponsor_orgname.setText(wishSponsorList.getWishSponsor().getName());
		tv_sponsormoney.setText(wishSponsorList.getWishItem().getValue()+"");
		tv_sponsor_orgrequest.setText(wishSponsorList.getWishSponsor()
				.getDescribe());
		return convertView;
	}
	/**
	 * 增加数据源
	 * 
	 * @param models
	 */
	public void addData(List<WishSponsorList> models) {
		mValues.addAll(models);
		notifyDataSetChanged();
	}

	/**
	 * 重置数据源
	 * 
	 * @param models
	 */
	public void initData(List<WishSponsorList> models) {
		mValues.clear();
		mValues.addAll(models);
		notifyDataSetChanged();
	}
}
