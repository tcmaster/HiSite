package com.android.tonight8.adapter.event;

import java.util.List;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.tonight8.R;
import com.android.tonight8.adapter.BaseListAdapter;

/**
 * @Description:开奖名单适配器
 * @author:LiXiaoSong
 * @copyright @tonight8
 * @Date:2015-1-8
 */
public class EventAwardAdapter extends BaseListAdapter<String> {

	public EventAwardAdapter(Context context, List<String> values) {
		super(context, values);
	}

	@Override
	protected View getItemView(View convertView, int position) {
		ViewHolder viewHolder = new ViewHolder();
		if (convertView == null) {
			convertView = mInflater.inflate(R.layout.item_event_award, null, false);
			viewHolder.iv_have_do = (ImageView) convertView.findViewById(R.id.iv_user_pic);
			viewHolder.tv_user_name = (TextView) convertView.findViewById(R.id.tv_user_name);
			viewHolder.tv_phone_num = (TextView) convertView.findViewById(R.id.tv_phone_num);
			viewHolder.tv_location = (TextView) convertView.findViewById(R.id.tv_location);
			viewHolder.iv_have_do = (ImageView) convertView.findViewById(R.id.iv_have_do);
			convertView.setTag(viewHolder);
		} else
			viewHolder = (ViewHolder) convertView.getTag();
		viewHolder.tv_user_name.setText("小新");
		viewHolder.tv_phone_num.setText("186****5042");
		viewHolder.tv_location.setText("北京");
		return convertView;
	}

	private class ViewHolder {

		ImageView iv_user_pic;
		TextView tv_user_name;
		TextView tv_phone_num;
		TextView tv_location;
		ImageView iv_have_do;
	}

}
