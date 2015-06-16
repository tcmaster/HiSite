package com.android.tonight8.adapter.wish;

import java.util.List;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.tonight8.R;
import com.android.tonight8.activity.wish.MakeWishActivity;
import com.android.tonight8.adapter.BaseListAdapter;
import com.android.tonight8.adapter.ViewHolder;
import com.android.tonight8.base.BaseActivity;
import com.android.tonight8.dao.model.wish.WishListModel;
import com.android.tonight8.utils.DialogUtils;

/**
 * @author lz 心愿故事数据适配器
 * 
 */
public class WishStoryAdapter extends BaseListAdapter<WishListModel> implements
		OnClickListener {
	private MakeWishActivity mActivity;

	public WishStoryAdapter(Context context, List<WishListModel> values) {
		super(context, values);
		mActivity = (MakeWishActivity) mContext;
	}

	@Override
	protected View getItemView(View convertView, int position) {
		convertView = mInflater.inflate(R.layout.adapter_wish_story, null);
		EditText et_wishname = ViewHolder.get(convertView, R.id.et_wishname);
		TextView tv_deletewishpic = ViewHolder.get(convertView,
				R.id.tv_deletewishpic);
		TextView tv_addwishpic = ViewHolder
				.get(convertView, R.id.tv_addwishpic);
		ImageView iv_wish_storypic = ViewHolder.get(convertView,
				R.id.iv_wish_storypic);
		tv_addwishpic.setTag(position);
		tv_deletewishpic.setTag(position);
		iv_wish_storypic.setTag(position);
		tv_addwishpic.setOnClickListener(this);
		tv_deletewishpic.setOnClickListener(this);
		iv_wish_storypic.setOnClickListener(this);
		// bmUtils.display(iv_wish_storypic, mValues.get(position).getWish().);
		return convertView;
	}

	@Override
	public void onClick(View arg0) {
		int pos = (Integer) arg0.getTag();
		switch (arg0.getId()) {
		case R.id.tv_addwishpic:
			mActivity.updateClickPosition(pos, MakeWishActivity.ADD_DATA, null);
			break;
		case R.id.tv_deletewishpic:
			mActivity.updateClickPosition(pos, MakeWishActivity.DELETE_DATA,
					null);
			break;
		case R.id.iv_wish_storypic:
			mActivity.updateClickPosition(pos, MakeWishActivity.UPDATA_DATA,
					null);
			DialogUtils.showSelectPicDialog(mActivity,
					BaseActivity.PICKPICTURE, BaseActivity.TAKEPHOTO);
			break;

		default:
			break;
		}

	}

}
