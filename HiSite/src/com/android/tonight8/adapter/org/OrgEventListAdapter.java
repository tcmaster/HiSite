package com.android.tonight8.adapter.org;

import java.util.List;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.tonight8.R;
import com.android.tonight8.adapter.BaseListAdapter;
import com.android.tonight8.adapter.ViewHolder;
import com.android.tonight8.model.event.EventListModel;

/**
 * @author lz商家的活动列表数据
 * 
 */
public class OrgEventListAdapter extends BaseListAdapter<EventListModel> {

	public OrgEventListAdapter(Context context, List<EventListModel> values) {
		super(context, values);

	}

	@Override
	protected View getItemView(View convertView, int position) {
		convertView = mInflater.inflate(R.layout.adapter_org_eventlist, null);
		ImageView tv_myevent_pic = ViewHolder.get(convertView, R.id.tv_myevent_pic);
		TextView tv_myevent_name = ViewHolder.get(convertView, R.id.tv_myevent_name);
		TextView tv_price_count = ViewHolder.get(convertView, R.id.tv_price_count);
		TextView tv_enent_number = ViewHolder.get(convertView, R.id.tv_enent_number);
		TextView tv_event_signup = ViewHolder.get(convertView, R.id.tv_event_signup);
		bmUtils.display(convertView, "");
		tv_myevent_name.setText("小米送手机2");
		tv_price_count.setText("价值：" + "699元");
		tv_enent_number.setText("名额:" + "5名");
		tv_event_signup.setText("报名:" + "320名");
		return convertView;
	}

}
