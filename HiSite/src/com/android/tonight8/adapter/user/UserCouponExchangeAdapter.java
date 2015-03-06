package com.android.tonight8.adapter.user;

import java.util.List;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.tonight8.R;
import com.android.tonight8.adapter.BaseListAdapter;
import com.android.tonight8.adapter.ViewHolder;
import com.android.tonight8.model.common.Org;

/**
 * @Description:用户优惠券地址适配器
 * @author:LiXiaoSong
 * @copyright @HiSite
 * @Date:2015-1-28
 */
public class UserCouponExchangeAdapter extends BaseListAdapter<Org> {

	public UserCouponExchangeAdapter(Context context, List<Org> values) {
		super(context, values);
	}

	@Override
	public int getCount() {
		return 4;
	}

	@Override
	protected View getItemView(View convertView, int position) {
		if (convertView == null) {
			convertView = mInflater.inflate(R.layout.item_coupon_exchange_list, null);
		}
		ImageView iv_com_logo = ViewHolder.get(convertView, R.id.iv_com_logo);// 公司图片
		TextView tv_com_name = ViewHolder.get(convertView, R.id.iv_com_logo);// 公司名称
		TextView tv_com_location = ViewHolder.get(convertView, R.id.iv_com_logo); // 公司地址
		TextView tv_com_phone = ViewHolder.get(convertView, R.id.iv_com_logo);// 公司电话
		TextView tv_com_distance = ViewHolder.get(convertView, R.id.iv_com_logo);// 公司距离
		return convertView;
	}
}
