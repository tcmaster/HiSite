package com.android.tonight8.adapter.live;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.tonight8.R;
import com.android.tonight8.adapter.BaseListAdapter;
import com.android.tonight8.dao.model.live.EventAward;

public class EventLiveWinnerListAdapter extends BaseListAdapter<EventAward> {
	private List<String> times;// 测试时间控件

	public EventLiveWinnerListAdapter(Context context, List<EventAward> values) {
		super(context, values);
		times = new ArrayList<String>();
		times.add("20:08分 有10人中奖");
		times.add("20:08分 有15人中奖");
		times.add("20:08分 有14人中奖");
	}

	@Override
	public int getCount() {
		return mValues.size() + 3;// 测试用
	}

	@Override
	public Object getItem(int position) {
		if (position == 0)
			return times.get(0);
		else if (position > 0 && position < 4)
			return mValues.get(position - 1);
		else if (position == 4)
			return times.get(1);
		else if (position > 4 && position < 7)
			return mValues.get(position - 2);
		else if (position == 7)
			return times.get(2);
		else if (position > 7) {
			return mValues.get(position - 3);
		} else
			return null;
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	protected View getItemView(View convertView, int position) {
		ContentHolder contentHolder = null;
		TitleHolder titleHolder = null;
		if (convertView == null) {
			if (position == 0 || position == 4 || position == 7) {
				titleHolder = new TitleHolder();
				convertView = mInflater.inflate(
						R.layout.item_event_award_title, null);
				titleHolder.tv_time = (TextView) convertView
						.findViewById(R.id.tv_time);
				convertView.setTag(titleHolder);
			} else {
				contentHolder = new ContentHolder();
				convertView = mInflater
						.inflate(R.layout.item_event_award, null);
				contentHolder.iv_have_do = (ImageView) convertView
						.findViewById(R.id.iv_have_do);
				contentHolder.iv_user_pic = (ImageView) convertView
						.findViewById(R.id.iv_user_pic);
				contentHolder.tv_location = (TextView) convertView
						.findViewById(R.id.tv_location);
				contentHolder.tv_phone_num = (TextView) convertView
						.findViewById(R.id.tv_phone_num);
				contentHolder.tv_user_name = (TextView) convertView
						.findViewById(R.id.tv_user_name);
				convertView.setTag(contentHolder);
			}
		} else {
			if (position == 0 || position == 4 || position == 7) {
				if (convertView.getTag() instanceof TitleHolder) {
					titleHolder = (TitleHolder) convertView.getTag();
				} else {// 布局无法重用，重新生成
					titleHolder = new TitleHolder();
					convertView = mInflater.inflate(
							R.layout.item_event_award_title, null);
					titleHolder.tv_time = (TextView) convertView
							.findViewById(R.id.tv_time);
					convertView.setTag(titleHolder);
				}
			} else {
				if (convertView.getTag() instanceof ContentHolder) {
					contentHolder = (ContentHolder) convertView.getTag();
				} else {
					contentHolder = new ContentHolder();
					convertView = mInflater.inflate(R.layout.item_event_award,
							null);
					contentHolder.iv_have_do = (ImageView) convertView
							.findViewById(R.id.iv_have_do);
					contentHolder.iv_user_pic = (ImageView) convertView
							.findViewById(R.id.iv_user_pic);
					contentHolder.tv_location = (TextView) convertView
							.findViewById(R.id.tv_location);
					contentHolder.tv_phone_num = (TextView) convertView
							.findViewById(R.id.tv_phone_num);
					contentHolder.tv_user_name = (TextView) convertView
							.findViewById(R.id.tv_user_name);
				}
			}
		}
		if (position == 0)
			titleHolder.tv_time.setText(times.get(0));
		else if (position > 0 && position < 4) {
			EventAward model = mValues.get(position - 1);
			bmUtils.display(contentHolder.iv_user_pic, model.getUser().getPic());
			contentHolder.tv_location.setText(model.getAddress().getCityCode());
			contentHolder.tv_phone_num
					.setText(model.getUser().getMobilePhone());
			contentHolder.tv_user_name.setText(model.getUser().getName());
		} else if (position == 4)
			titleHolder.tv_time.setText(times.get(1));
		else if (position > 4 && position < 7) {
			EventAward model = mValues.get(position - 2);
			bmUtils.display(contentHolder.iv_user_pic, model.getUser().getPic());
			contentHolder.tv_location.setText(model.getAddress().getCityCode());
			contentHolder.tv_phone_num
					.setText(model.getUser().getMobilePhone());
			contentHolder.tv_user_name.setText(model.getUser().getName());
		} else if (position == 7)
			titleHolder.tv_time.setText(times.get(2));
		else if (position > 7) {
			EventAward model = mValues.get(position - 3);
			bmUtils.display(contentHolder.iv_user_pic, model.getUser().getPic());
			contentHolder.tv_location.setText(model.getAddress().getCityCode());
			contentHolder.tv_phone_num
					.setText(model.getUser().getMobilePhone());
			contentHolder.tv_user_name.setText(model.getUser().getName());
		} else {
		}
		return convertView;
	}

	/**
	 * 
	 * @Descripton特殊的adapter，使用自己的ViewHolder，不能用万能ViewHolder
	 * @author LiXiaoSong
	 * @2015-6-15
	 * @Tonight8
	 */
	private class TitleHolder {
		TextView tv_time;
	}

	private class ContentHolder {
		ImageView iv_have_do;
		ImageView iv_user_pic;
		TextView tv_user_name;
		TextView tv_phone_num;
		TextView tv_location;
	}

}
