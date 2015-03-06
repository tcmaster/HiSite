package com.android.tonight8.adapter.event;

import java.util.List;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.tonight8.R;
import com.android.tonight8.adapter.BaseListAdapter;
import com.android.tonight8.adapter.ViewHolder;

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
		if (convertView == null) {
			convertView = mInflater.inflate(R.layout.item_event_award, null, false);
		}
		ImageView iv_user_pic = ViewHolder.get(convertView, R.id.iv_user_pic);// 用户头像
		TextView tv_user_name = ViewHolder.get(convertView, R.id.tv_user_name);// 用户姓名
		TextView tv_phone_num = ViewHolder.get(convertView, R.id.tv_phone_num);// 电话号码
		TextView tv_location = ViewHolder.get(convertView, R.id.tv_location);// 用户省份
		ImageView iv_have_do = ViewHolder.get(convertView, R.id.iv_have_do);// 是否中奖图标
		tv_user_name.setText("小新");
		tv_phone_num.setText("186****5042");
		tv_location.setText("北京");
		return convertView;
	}

}
