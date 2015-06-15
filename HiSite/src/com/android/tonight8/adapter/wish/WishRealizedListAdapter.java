package com.android.tonight8.adapter.wish;

import java.util.List;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.tonight8.R;
import com.android.tonight8.adapter.BaseListAdapter;
import com.android.tonight8.adapter.ViewHolder;
import com.android.tonight8.dao.model.wish.WishListModel;
import com.android.tonight8.utils.Utils;
import com.android.tonight8.view.CircleImageView;

/**
 * @author lz已经愿望列表
 * 
 */
public class WishRealizedListAdapter extends BaseListAdapter<WishListModel> {

	public WishRealizedListAdapter(Context context, List<WishListModel> values) {
		super(context, values);

	}

	@Override
	protected View getItemView(View convertView, int position) {
		if (convertView == null) {
			convertView = mInflater.inflate(
					R.layout.adapter_realized_wish_item, null);
		}
		ImageView iv_wishpic = ViewHolder.get(convertView,
				R.id.iv_realized_wishpic);
		TextView tv_wish_username = ViewHolder.get(convertView,
				R.id.tv_realized_wishusername);
		TextView tv_wish_supportcount = ViewHolder.get(convertView,
				R.id.tv_realized_wishsupportcount);
		TextView tv_realized_wishtitle = ViewHolder.get(convertView,
				R.id.tv_realized_wishtitle);
		TextView tv_realized_wishcontent = ViewHolder.get(convertView,
				R.id.tv_realized_wishcontent);
		CircleImageView wish_userpic = ViewHolder.get(convertView,
				R.id.civ_realized_wish_userpic);

		WishListModel wishListModel = mValues.get(position);
		tv_realized_wishtitle.setText(wishListModel.getWish().getName());
		tv_realized_wishcontent.setText(wishListModel.getWish().getDescribe());
		tv_wish_username.setText(wishListModel.getUser().getName());
		tv_wish_supportcount.setText(wishListModel.getWish().getSupportCount()
				.toString());
		bmUtils.display(iv_wishpic,
				"http://pic1.nipic.com/2008-09-08/200898163242920_2.jpg");
		bmUtils.display(wish_userpic,
				"http://pica.nipic.com/2007-12-22/2007122215556437_2.jpg");
		tv_wish_supportcount.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				Utils.toast("支持+1");

			}
		});
		// iv_wishpic.setOnClickListener(new OnClickListener() {
		//
		// @Override
		// public void onClick(View arg0) {
		// mContext.startActivity(new Intent(mContext, WishLiveActivity.class));
		// }
		// });
		return convertView;
	}

	/**
	 * 增加数据源
	 * 
	 * @param models
	 */
	public void addData(List<WishListModel> models) {
		mValues.addAll(models);
		notifyDataSetChanged();
	}

	/**
	 * 重置数据源
	 * 
	 * @param models
	 */
	public void initData(List<WishListModel> models) {
		mValues.clear();
		mValues.addAll(models);
		notifyDataSetChanged();
	}

}
