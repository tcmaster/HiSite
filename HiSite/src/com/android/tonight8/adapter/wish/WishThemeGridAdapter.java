package com.android.tonight8.adapter.wish;

import java.util.List;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

import com.android.tonight8.R;
import com.android.tonight8.adapter.BaseListAdapter;
import com.android.tonight8.adapter.ViewHolder;

/**
 * @author lz心愿主题图片
 * 
 */
public class WishThemeGridAdapter extends BaseListAdapter<String> {

	public WishThemeGridAdapter(Context context, List<String> values) {
		super(context, values);

	}

	@Override
	protected View getItemView(View convertView, final int position) {
		convertView = mInflater.inflate(R.layout.adapter_wishtheme_grid, null);
		ImageView wishthemepic = ViewHolder.get(convertView, R.id.iv_wish_themepic);
		bmUtils.display(wishthemepic, mValues.get(position));
		wishthemepic.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				
				if ("".equals(mValues.get(position))) {
					
				}
			}
		});
		return convertView;
	}

}
