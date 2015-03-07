package com.android.tonight8.adapter.event;

import java.util.List;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.tonight8.R;
import com.android.tonight8.activity.createevent.EventsAwardListActivity;
import com.android.tonight8.activity.createevent.EventsAwardManageActivity;
import com.android.tonight8.adapter.BaseListAdapter;
import com.android.tonight8.adapter.ViewHolder;
import com.android.tonight8.model.manageevent.ManageAwardEventModel;

/**
 * @Description:活动中奖管理数据适配器
 * @author:LiuZhao
 * @Date:2015年2月2日
 */
public class EventsAwardManageAdapter extends
		BaseListAdapter<ManageAwardEventModel> {

	public EventsAwardManageAdapter(Context context,
			List<ManageAwardEventModel> values) {
		super(context, values);

	}

	private OnClickListener awardlistListener = new OnClickListener() {

		@Override
		public void onClick(View arg0) {
			// int pos = (Integer) arg0.getTag();
			Intent intent = new Intent(mContext, EventsAwardListActivity.class);
			((EventsAwardManageActivity) mContext).startActivity(intent);
			((EventsAwardManageActivity) mContext).overridePendingTransition(
					R.anim.push_left_in, R.anim.push_left_out);

		}
	};

	@Override
	protected View getItemView(View convertView, int position) {

		if (convertView == null)
			convertView = mInflater.inflate(R.layout.adapter_event_award_item,
					null, false);
		TextView tv_pulishtime = ViewHolder
				.get(convertView, R.id.tv_pulishtime);
		TextView tv_event_name = ViewHolder
				.get(convertView, R.id.tv_event_name);
		TextView tv_goods_name = ViewHolder
				.get(convertView, R.id.tv_goods_name);
		TextView tv_goods_count = ViewHolder.get(convertView,
				R.id.tv_goods_count);
		TextView tv_goods_pricevalue = ViewHolder.get(convertView,
				R.id.tv_goods_pricevalue);
		TextView tv_event_plan_time = ViewHolder.get(convertView,
				R.id.tv_event_plan_time);
		TextView tv_event_comment_count = ViewHolder.get(convertView,
				R.id.tv_event_comment_count);
		TextView tv_event_signup_count = ViewHolder.get(convertView,
				R.id.tv_event_signup_count);
		TextView tv_event_award_count = ViewHolder.get(convertView,
				R.id.tv_event_award_count);
		TextView tv_awardlist = ViewHolder.get(convertView, R.id.tv_awardlist);
		ImageView iv_event_headpic = ViewHolder.get(convertView,
				R.id.iv_event_headpic);
		tv_awardlist.setOnClickListener(awardlistListener);
		return convertView;
	}

	/**
	 * 增加数据源
	 * 
	 * @param models
	 */
	public void addData(List<ManageAwardEventModel> models) {
		mValues.addAll(models);
		notifyDataSetChanged();
	}

	/**
	 * 重置数据源
	 * 
	 * @param models
	 */
	public void initData(List<ManageAwardEventModel> models) {
		mValues.clear();
		mValues.addAll(models);
		notifyDataSetChanged();
	}
}
