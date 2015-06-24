package com.android.tonight8.adapter.live;

import java.util.List;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.tonight8.R;
import com.android.tonight8.adapter.BaseListAdapter;
import com.android.tonight8.adapter.ViewHolder;
import com.android.tonight8.dao.entity.DetailPic;

/**
 * @Descripton 商品介绍
 * @author LiXiaoSong
 * @2015-6-23
 * @Tonight8
 */
public class GoodsDetailItoAdapter extends BaseListAdapter<DetailPic> {

	public GoodsDetailItoAdapter(Context context, List<DetailPic> values) {
		super(context, values);

	}

	@Override
	protected View getItemView(View convertView, int position) {
		DetailPic model = mValues.get(position);
		if (convertView == null)
			convertView = mInflater.inflate(R.layout.item_photo_and_text, null);
		TextView tv_result = ViewHolder.get(convertView, R.id.tv_result);
		ImageView iv_photo = ViewHolder.get(convertView, R.id.iv_photo);
		tv_result.setText(model.getDescribe());
		bmUtils.display(iv_photo, model.getUrl());
		return convertView;
	}

}
