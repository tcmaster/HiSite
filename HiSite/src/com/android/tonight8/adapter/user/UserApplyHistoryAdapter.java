/**
 * 2015-1-28
 */
package com.android.tonight8.adapter.user;

import java.util.List;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.tonight8.R;
import com.android.tonight8.adapter.BaseListAdapter;
import com.android.tonight8.model.user.UserApplyHistoryModel;

/**
 * @Description:用户抽奖历史列表
 * @author:LiXiaoSong
 * @copyright @HiSite
 * @Date:2015-1-28
 */
public class UserApplyHistoryAdapter extends BaseListAdapter<UserApplyHistoryModel> {

	public UserApplyHistoryAdapter(Context context, List<UserApplyHistoryModel> values) {
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
			convertView = mInflater.inflate(R.layout.item_apply_histroy, null);
			holder = new ViewHolder();
			holder.tv_event_name = (TextView) convertView.findViewById(R.id.tv_event_name);
			holder.tv_location = (TextView) convertView.findViewById(R.id.tv_location);
			holder.tv_org_name = (TextView) convertView.findViewById(R.id.tv_org_name);
			holder.tv_pop_goods = (TextView) convertView.findViewById(R.id.tv_pop_goods);
			holder.iv_pop_goods_pic = (ImageView) convertView.findViewById(R.id.iv_pop_goods_pic);
			holder.tv_award_value = (TextView) convertView.findViewById(R.id.tv_award_value);
			holder.tv_provide_num = (TextView) convertView.findViewById(R.id.tv_provide_num);
			holder.tv_coupon = (TextView) convertView.findViewById(R.id.tv_coupon);
			holder.tv_have_apply = (TextView) convertView.findViewById(R.id.tv_have_apply);
			holder.iv_pop_goods_pic_left_top = (ImageView) convertView.findViewById(R.id.iv_pop_goods_pic_left_top);
			holder.btn_delete = (Button) convertView.findViewById(R.id.btn_delete);
			convertView.setTag(holder);
		} else
			holder = (ViewHolder) convertView.getTag();
		return convertView;
	}

	private class ViewHolder {

		ImageView iv_pop_goods_pic;// 奖品图片
		TextView tv_event_name;// 活动名称
		TextView tv_location;// 位置
		TextView tv_org_name;// 发布公司名称
		TextView tv_pop_goods;// 奖品内容
		TextView tv_award_value;// 奖品价值
		TextView tv_provide_num;// 中奖名额
		TextView tv_coupon;// 优惠券
		TextView tv_have_apply;// 报名数量
		ImageView iv_pop_goods_pic_left_top;// 是否中奖的图片
		Button btn_delete;// 删除按钮
	}

}
