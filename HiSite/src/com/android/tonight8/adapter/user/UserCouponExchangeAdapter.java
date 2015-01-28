package com.android.tonight8.adapter.user;

import java.util.List;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.tonight8.R;
import com.android.tonight8.adapter.BaseListAdapter;
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
		ViewHolder holder = null;
		if (convertView == null) {
			convertView = mInflater.inflate(R.layout.item_coupon_exchange_list, null);
			holder = new ViewHolder();
			holder.iv_com_logo = (ImageView) convertView.findViewById(R.id.iv_com_logo);
			holder.tv_com_distance = (TextView) convertView.findViewById(R.id.tv_com_distance);
			holder.tv_com_phone = (TextView) convertView.findViewById(R.id.tv_com_phone);
			holder.tv_com_location = (TextView) convertView.findViewById(R.id.tv_com_location);
			holder.tv_com_name = (TextView) convertView.findViewById(R.id.tv_com_name);
			convertView.setTag(holder);
		} else
			holder = (ViewHolder) convertView.getTag();
		return convertView;
	}

	private class ViewHolder {

		ImageView iv_com_logo;// 公司图片
		TextView tv_com_name;// 公司名称
		TextView tv_com_location; // 公司地址
		TextView tv_com_phone;// 公司电话
		TextView tv_com_distance;// 公司距离
	}

}
