/**
 * 2014-12-25
 */
package com.android.tonight8.adapter.event;

import java.util.List;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.tonight8.R;
import com.android.tonight8.activity.event.EventAwardActivity;
import com.android.tonight8.adapter.BaseListAdapter;
import com.android.tonight8.model.event.EventListModel;

/**
 * @Description:
 * @author:LiXiaoSong
 * @see:
 * @since:
 * @copyright @tonight8
 * @Date:2014-12-25
 */
public class MainPageListViewAdapter extends BaseListAdapter<EventListModel> {

	public MainPageListViewAdapter(Context context, List<EventListModel> values) {
		super(context, values);
	}

	@Override
	protected View getItemView(View convertView, int position) {
		ViewHolder holder = null;
		EventListModel model = mValues.get(position);
		if (convertView == null) {
			convertView = mInflater.inflate(R.layout.item_home_lv, null, false);
			holder = new ViewHolder();
			holder.iv_bpic = (ImageView) convertView.findViewById(R.id.iv_bpic);
			holder.tv_title = (TextView) convertView.findViewById(R.id.tv_title);
			holder.tv_location = (TextView) convertView.findViewById(R.id.tv_location);
			holder.tv_company = (TextView) convertView.findViewById(R.id.tv_company);
			holder.tv_prize = (TextView) convertView.findViewById(R.id.tv_prize);
			holder.tv_count = (TextView) convertView.findViewById(R.id.tv_count);
			holder.tv_redpacket = (TextView) convertView.findViewById(R.id.tv_redpacket);
			holder.tv_signup_count = (TextView) convertView.findViewById(R.id.tv_signup_count);
			holder.ll_win = (LinearLayout) convertView.findViewById(R.id.ll_win);
			holder.ll_comment = (LinearLayout) convertView.findViewById(R.id.ll_comment);
			holder.ll_apply = (LinearLayout) convertView.findViewById(R.id.ll_apply);
			holder.ll_win.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View arg0) {
					Intent intent = new Intent(mContext, EventAwardActivity.class);
					mContext.startActivity(intent);
				}
			});
			convertView.setTag(holder);
		} else
			holder = (ViewHolder) convertView.getTag();
		holder.tv_title.setText(model.event.name);
		holder.tv_company.setText(model.org.name);
		holder.tv_count.setText(model.event.awardCount + "");
		// holder.tv_prize.setText(model.popGoods.popGoodsName+"");
		return convertView;
	}

	private class ViewHolder {

		ImageView iv_bpic;// 左边的大图
		TextView tv_title;// 标题
		TextView tv_location;// 距离
		TextView tv_company;// 公司
		TextView tv_prize;// 奖品
		TextView tv_count;// 中奖名额
		TextView tv_redpacket;// 红包
		TextView tv_signup_count;// 报名数量
		LinearLayout ll_win;// 中奖
		LinearLayout ll_comment;// 评论
		LinearLayout ll_apply;// 报名
	}

}
