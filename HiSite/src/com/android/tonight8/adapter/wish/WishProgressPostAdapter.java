package com.android.tonight8.adapter.wish;

import java.util.List;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

import com.android.tonight8.R;
import com.android.tonight8.activity.wish.WishProcessPostActivity;
import com.android.tonight8.adapter.BaseListAdapter;
import com.android.tonight8.adapter.ViewHolder;
import com.android.tonight8.base.BaseActivity;
import com.android.tonight8.dao.model.wish.MyWishSponsorListModel;
import com.android.tonight8.io.HandlerConstants;
import com.android.tonight8.utils.DialogUtils;

public class WishProgressPostAdapter extends BaseListAdapter<String> {
	private WishProcessPostActivity mActivity;

	public WishProgressPostAdapter(Context context, List<String> values) {
		super(context, values);
		mActivity = (WishProcessPostActivity) context;
	}

	@Override
	protected View getItemView(View convertView, final int position) {
		convertView = mInflater.inflate(R.layout.adapter_wishtheme_grid, null);
		ImageView wishthemepic = ViewHolder.get(convertView,
				R.id.iv_wish_themepic);
		ImageView iv_cs_gallay_delete = ViewHolder.get(convertView,
				R.id.iv_cs_gallay_delete);
		if (mValues.get(position) != null && mValues.get(position) == "") {
			iv_cs_gallay_delete.setVisibility(View.GONE);
		} else {
			iv_cs_gallay_delete.setVisibility(View.VISIBLE);
		}

		bmUtils.display(wishthemepic, mValues.get(position));
		wishthemepic.setTag(position);
		wishthemepic.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {

				if (mValues.get(position) == null
						|| "".equals(mValues.get(position))) {
					DialogUtils.showSelectPicDialog(mActivity,
							BaseActivity.PICKPICTURE, BaseActivity.TAKEPHOTO);
				}
			}
		});
		iv_cs_gallay_delete.setTag(position);
		iv_cs_gallay_delete.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				mActivity.deleteWishProcessPost(position);
			}
		});
		return convertView;
	}

	/**
	 * 按照顺序更新最新数据
	 */
	public void updateData(List<String> list) {
		mValues = list;
		notifyDataSetChanged();
	}

}
