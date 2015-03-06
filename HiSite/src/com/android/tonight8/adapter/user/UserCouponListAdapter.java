package com.android.tonight8.adapter.user;

import java.util.List;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.tonight8.R;
import com.android.tonight8.activity.user.UserCouponExchangeActivity;
import com.android.tonight8.adapter.BaseListAdapter;
import com.android.tonight8.adapter.ViewHolder;
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
		if (convertView == null) {
			convertView = mInflater.inflate(R.layout.item_user_coupon_list, null);
		}
		ImageView iv_photo = ViewHolder.get(convertView, R.id.iv_photo);// 用户头像
		TextView tv_user_name = ViewHolder.get(convertView, R.id.tv_user_name);// 用户名称
		TextView tv_time = ViewHolder.get(convertView, R.id.tv_time);// 券的时间
		TextView tv_com_name = ViewHolder.get(convertView, R.id.tv_com_name);// 公司名称
		TextView tv_money = ViewHolder.get(convertView, R.id.tv_money);// 优惠券价值
		TextView tv_valid = ViewHolder.get(convertView, R.id.tv_valid);// 优惠券有效期
		TextView tv_encode_no = ViewHolder.get(convertView, R.id.tv_encode_no);// 优惠券编号
		LinearLayout ll_quickmark = ViewHolder.get(convertView, R.id.ll_quickmark);// 券二维码
		LinearLayout ll_award_location = ViewHolder.get(convertView, R.id.ll_award_location);// 兑奖地点
		ImageView iv_quickmark = ViewHolder.get(convertView, R.id.iv_quickmark);// 二维码图片
		TextView tv_quickmark = ViewHolder.get(convertView, R.id.tv_quickmark);// 二维码文字
		ImageView iv_award_location = ViewHolder.get(convertView, R.id.iv_award_location);// 兑奖地址图片
		TextView tv_award_location = ViewHolder.get(convertView, R.id.tv_award_location);// 兑奖地址文字
		ll_award_location.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(mContext, UserCouponExchangeActivity.class);
				mContext.startActivity(intent);

			}
		});
		return convertView;
	}
}
