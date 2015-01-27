package com.android.tonight8.adapter.user;

import java.util.List;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.tonight8.R;
import com.android.tonight8.adapter.BaseListAdapter;
import com.android.tonight8.model.user.UserCouponModel;

/**
 * @Descripton 用户优惠券列表
 * @author LiXiaoSong
 * @2015-1-27
 * @Tonight8
 */
public class UserCouponListAdapter extends BaseListAdapter<UserCouponModel> {

	public UserCouponListAdapter(Context context, List<UserCouponModel> values) {
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
			convertView = mInflater.inflate(R.layout.item_user_coupon_list,
					null);
			holder = new ViewHolder();
			holder.iv_award_location = (ImageView) convertView
					.findViewById(R.id.iv_award_location);
			holder.iv_photo = (ImageView) convertView
					.findViewById(R.id.iv_photo);
			holder.iv_quickmark = (ImageView) convertView
					.findViewById(R.id.iv_quickmark);
			holder.tv_award_location = (TextView) convertView
					.findViewById(R.id.tv_award_location);
			holder.tv_com_name = (TextView) convertView
					.findViewById(R.id.tv_com_name);
			holder.tv_encode_no = (TextView) convertView
					.findViewById(R.id.tv_encode_no);
			holder.tv_money = (TextView) convertView
					.findViewById(R.id.tv_money);
			holder.tv_quickmark = (TextView) convertView
					.findViewById(R.id.tv_quickmark);
			holder.tv_time = (TextView) convertView.findViewById(R.id.tv_time);
			holder.tv_user_name = (TextView) convertView
					.findViewById(R.id.tv_user_name);
			holder.tv_valid = (TextView) convertView
					.findViewById(R.id.tv_valid);
			convertView.setTag(holder);
		} else
			holder = (ViewHolder) convertView.getTag();
		return convertView;
	}

	private class ViewHolder {
		ImageView iv_photo;// 用户头像
		TextView tv_user_name;// 用户名称
		TextView tv_time;// 券的时间
		TextView tv_com_name;// 公司名称
		TextView tv_money;// 优惠券价值
		TextView tv_valid;// 优惠券有效期
		TextView tv_encode_no;// 优惠券编号
		LinearLayout ll_quickmark;// 券二维码
		LinearLayout ll_award_location;// 兑奖地点
		ImageView iv_quickmark;// 二维码图片
		TextView tv_quickmark;// 二维码文字
		ImageView iv_award_location;// 兑奖地址图片
		TextView tv_award_location;// 兑奖地址文字

	}

}
