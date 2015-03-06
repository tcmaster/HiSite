/**
 * 2015-1-27
 */
package com.android.tonight8.adapter.user;

import java.util.List;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.android.tonight8.R;
import com.android.tonight8.activity.user.UserAwardSignActivity;
import com.android.tonight8.adapter.BaseListAdapter;
import com.android.tonight8.adapter.ViewHolder;
import com.android.tonight8.model.user.UserAwardModel;

/**
 * @Description: 用户中奖码列表适配器
 * @author:LiXiaoSong
 * @copyright @HiSite
 * @Date:2015-1-27
 */
public class UserAwardListAdapter extends BaseListAdapter<UserAwardModel> {

	public UserAwardListAdapter(Context context, List<UserAwardModel> models) {
		super(context, models);
	}

	// 测试
	@Override
	public int getCount() {
		return 4;
	}

	@Override
	protected View getItemView(View convertView, int position) {
		if (convertView == null) {
			convertView = mInflater.inflate(R.layout.item_user_award_list, null);
		}
		TextView tv_award_no = ViewHolder.get(convertView, R.id.tv_award_no);// 中奖号码
		TextView tv_date = ViewHolder.get(convertView, R.id.tv_date);// 日期
		ImageView iv_pop_goods_pic = ViewHolder.get(convertView, R.id.iv_pop_goods_pic);// 奖品图片
		TextView tv_event_name = ViewHolder.get(convertView, R.id.tv_event_name);// 活动名称
		TextView tv_location = ViewHolder.get(convertView, R.id.tv_location);// 位置
		TextView tv_org_name = ViewHolder.get(convertView, R.id.tv_org_name);// 发布公司名称
		TextView tv_pop_goods = ViewHolder.get(convertView, R.id.tv_pop_goods);// 奖品内容
		TextView tv_award_value = ViewHolder.get(convertView, R.id.tv_award_value);// 奖品价值
		TextView tv_provide_num = ViewHolder.get(convertView, R.id.tv_provide_num);// 中奖名额
		TextView tv_coupon = ViewHolder.get(convertView, R.id.tv_coupon);// 优惠券
		TextView tv_have_apply = ViewHolder.get(convertView, R.id.tv_have_apply);// 报名数量
		LinearLayout ll_consult = ViewHolder.get(convertView, R.id.ll_consult);// 咨询
		LinearLayout ll_present = ViewHolder.get(convertView, R.id.ll_present);// 转赠
		LinearLayout ll_sign = ViewHolder.get(convertView, R.id.ll_sign);// 签收
		ListView lv_commit = ViewHolder.get(convertView, R.id.lv_commit);// 评论列表
		ImageView iv_consult = ViewHolder.get(convertView, R.id.iv_consult);// 咨询图片
		ImageView iv_complain = ViewHolder.get(convertView, R.id.iv_complain);// 投诉图片
		ImageView iv_sign = ViewHolder.get(convertView, R.id.iv_sign);// 签收图片
		ImageView iv_pop_goods_pic_left_top = ViewHolder.get(convertView, R.id.iv_pop_goods_pic_left_top);// 是否中奖的图片
		Button btn_delete = ViewHolder.get(convertView, R.id.btn_delete);// 删除按钮
		ll_sign.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(mContext, UserAwardSignActivity.class);
				mContext.startActivity(intent);

			}
		});
		return convertView;
	}
}
