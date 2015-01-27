/**
 * 2015-1-27
 */
package com.android.tonight8.adapter.user;

import java.util.List;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.android.tonight8.R;
import com.android.tonight8.activity.user.UserAwardSignActivity;
import com.android.tonight8.adapter.BaseListAdapter;
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
		ViewHolder holder = null;
		if (convertView == null) {
			convertView = mInflater.inflate(R.layout.item_user_award_list, null);
			holder = new ViewHolder();
			holder.tv_award_no = (TextView) convertView.findViewById(R.id.tv_award_no);
			holder.tv_date = (TextView) convertView.findViewById(R.id.tv_date);
			holder.tv_event_name = (TextView) convertView.findViewById(R.id.tv_event_name);
			holder.tv_location = (TextView) convertView.findViewById(R.id.tv_location);
			holder.tv_org_name = (TextView) convertView.findViewById(R.id.tv_org_name);
			holder.tv_pop_goods = (TextView) convertView.findViewById(R.id.tv_pop_goods);
			holder.iv_pop_goods_pic = (ImageView) convertView.findViewById(R.id.iv_pop_goods_pic);
			holder.tv_award_value = (TextView) convertView.findViewById(R.id.tv_award_value);
			holder.tv_provide_num = (TextView) convertView.findViewById(R.id.tv_provide_num);
			holder.tv_coupon = (TextView) convertView.findViewById(R.id.tv_coupon);
			holder.tv_have_apply = (TextView) convertView.findViewById(R.id.tv_have_apply);
			holder.ll_consult = (LinearLayout) convertView.findViewById(R.id.ll_consult);
			holder.ll_complain = (LinearLayout) convertView.findViewById(R.id.ll_complain);
			holder.ll_sign = (LinearLayout) convertView.findViewById(R.id.ll_sign);
			holder.lv_commit = (ListView) convertView.findViewById(R.id.lv_commit);
			holder.iv_consult = (ImageView) convertView.findViewById(R.id.iv_consult);
			holder.iv_complain = (ImageView) convertView.findViewById(R.id.iv_complain);
			holder.iv_sign = (ImageView) convertView.findViewById(R.id.iv_sign);
			convertView.setTag(holder);
		} else
			holder = (ViewHolder) convertView.getTag();
		holder.ll_sign.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(mContext, UserAwardSignActivity.class);
				mContext.startActivity(intent);

			}
		});
		return convertView;
	}

	private class ViewHolder {

		TextView tv_award_no;// 中奖号码
		TextView tv_date;// 日期
		ImageView iv_pop_goods_pic;// 奖品图片
		TextView tv_event_name;// 活动名称
		TextView tv_location;// 位置
		TextView tv_org_name;// 发布公司名称
		TextView tv_pop_goods;// 奖品内容
		TextView tv_award_value;// 奖品价值
		TextView tv_provide_num;// 中奖名额
		TextView tv_coupon;// 优惠券
		TextView tv_have_apply;// 报名数量
		LinearLayout ll_consult;// 咨询
		LinearLayout ll_complain;// 投诉
		LinearLayout ll_sign;// 签收
		ListView lv_commit;// 评论列表
		ImageView iv_consult;// 咨询图片
		ImageView iv_complain;// 投诉图片
		ImageView iv_sign;// 签收图片
	}
}
