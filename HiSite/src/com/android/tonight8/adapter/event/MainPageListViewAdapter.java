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
import com.android.tonight8.activity.user.UserLoginActivity;
import com.android.tonight8.adapter.BaseListAdapter;
import com.android.tonight8.adapter.ViewHolder;
import com.android.tonight8.model.event.EventListModel;
import com.android.tonight8.utils.Utils;
import com.lidroid.xutils.BitmapUtils;

/**
 * @Description:
 * @author:LiXiaoSong
 * @see:
 * @since:
 * @copyright @tonight8
 * @Date:2014-12-25
 */
public class MainPageListViewAdapter extends BaseListAdapter<EventListModel> {

	private BitmapUtils bmUtils;

	public MainPageListViewAdapter(Context context, List<EventListModel> values) {
		super(context, values);
		bmUtils = new BitmapUtils(mContext);
	}

	@Override
	protected View getItemView(View convertView, int position) {
		EventListModel model = mValues.get(position);
		if (convertView == null) {
			convertView = mInflater.inflate(R.layout.item_home_lv, null, false);
		}
		ImageView iv_bpic = ViewHolder.get(convertView, R.id.iv_bpic);// 左边的大图
		TextView tv_title = ViewHolder.get(convertView, R.id.tv_title);// 标题
		TextView tv_location = ViewHolder.get(convertView, R.id.tv_location);// 距离
		TextView tv_company = ViewHolder.get(convertView, R.id.tv_company);// 公司
		TextView tv_prize = ViewHolder.get(convertView, R.id.tv_prize);// 奖品
		TextView tv_count = ViewHolder.get(convertView, R.id.tv_count);// 中奖名额
		TextView tv_redpacket = ViewHolder.get(convertView, R.id.tv_redpacket);// 红包
		TextView tv_signup_count = ViewHolder.get(convertView, R.id.tv_signup_count);// 报名数量
		LinearLayout ll_win = ViewHolder.get(convertView, R.id.ll_win);// 中奖
		LinearLayout ll_comment = ViewHolder.get(convertView, R.id.ll_comment);// 评论
		LinearLayout ll_apply = ViewHolder.get(convertView, R.id.ll_apply);// 报名
		tv_title.setText(model.event.name);
		tv_company.setText(model.org.name);
		tv_count.setText(model.event.awardCount + "");
		tv_signup_count.setText(model.event.applyCount + "");
		// tv_prize.setText(model.popGoods.popGoodsName+"");
		bmUtils.display(iv_bpic, model.popGoods.popGoodsPic);
		ll_win.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(mContext, EventAwardActivity.class);
				mContext.startActivity(intent);
			}
		});
		ll_apply.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Utils.toast("您还没有进行登陆，请登陆后在进行操作");
				Intent intent = new Intent(mContext, UserLoginActivity.class);
				mContext.startActivity(intent);
			}
		});
		((TextView) ll_comment.findViewById(R.id.tv_comment)).setText(model.event.consultCount + "");
		return convertView;
	}

	/**
	 * 增加数据源
	 * 
	 * @param models
	 */
	public void addData(List<EventListModel> models) {
		mValues.addAll(models);
		notifyDataSetChanged();
	}

	/**
	 * 重置数据源
	 * 
	 * @param models
	 */
	public void initData(List<EventListModel> models) {
		mValues.clear();
		mValues.addAll(models);
		notifyDataSetChanged();
	}
}
