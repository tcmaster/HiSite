/**
 * 2014-12-25
 */
package com.android.tonight8.adapter;

import java.util.List;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.tonight8.R;

/**
 * @Description:
 * @author:LiXiaoSong
 * @see:
 * @since:
 * @copyright @tonight8
 * @Date:2014-12-25
 */
public class MainPageListViewAdapter extends BaseListAdapter<String> {

	public MainPageListViewAdapter(Context context, List<String> values) {
		super(context, values);
	}

	@Override
	protected View getItemView(View convertView, int position) {
		ViewHolder holder = null;
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
			convertView.setTag(holder);
		} else
			holder = (ViewHolder) convertView.getTag();
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
