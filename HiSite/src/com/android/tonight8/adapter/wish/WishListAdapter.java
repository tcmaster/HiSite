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
import com.android.tonight8.view.MyProgressBar;

/**
 * @author lz愿望列表
 * 
 */
public class WishListAdapter extends BaseListAdapter<WishListModel> {

	public WishListAdapter(Context context, List<WishListModel> values) {
		super(context, values);

	}

	@Override
	protected View getItemView(View convertView, int position) {
		if (convertView == null) {
			convertView = mInflater.inflate(R.layout.adapter_wish_list, null);
		}
		ImageView iv_wishpic = ViewHolder.get(convertView, R.id.iv_wishpic);
		TextView tv_wishtitle = ViewHolder.get(convertView, R.id.tv_wishtitle);
		TextView tv_wishcontent = ViewHolder.get(convertView,
				R.id.tv_wishcontent);
		CircleImageView iv_wish_userpic = ViewHolder.get(convertView,
				R.id.civ_wish_userpic);
		TextView tv_wish_username = ViewHolder.get(convertView,
				R.id.tv_wish_username);
		TextView tv_wish_supportcount = ViewHolder.get(convertView,
				R.id.tv_wish_supportcount);
		MyProgressBar pb_wish_progress = ViewHolder.get(convertView,
				R.id.pb_wish_progress);
		WishListModel wishListModel = new WishListModel();
		wishListModel = mValues.get(position);
		bmUtils.display(iv_wishpic,
				"http://pica.nipic.com/2008-05-07/20085722191339_2.jpg");

		// bmUtils.display(iv_wishpic, wishListModel.getPopPic().getUrl());
		tv_wishtitle.setText(wishListModel.getWish().getName());
		tv_wishcontent.setText(wishListModel.getWish().getDescribe());
		tv_wish_username.setText(wishListModel.getUser().getName());
		tv_wish_supportcount.setText(wishListModel.getWish().getSupportCount()
				+ "");
		bmUtils.display(iv_wish_userpic, wishListModel.getUser().getPic());
		pb_wish_progress.setMax(100);
		pb_wish_progress.setProgress(20);
		tv_wish_supportcount.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				Utils.toast("支持+1");

			}
		});

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
