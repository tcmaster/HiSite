package com.android.tonight8.adapter.user;

import java.util.List;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.tonight8.R;
import com.android.tonight8.adapter.BaseListAdapter;
import com.android.tonight8.adapter.ViewHolder;
import com.android.tonight8.dao.entity.TMessage;

public class TMessageListAdapter extends BaseListAdapter<TMessage> {

	public TMessageListAdapter(Context context, List<TMessage> values) {
		super(context, values);
	}

	@Override
	protected View getItemView(View convertView, int position) {
		TMessage tm = mValues.get(position);
		if (convertView == null) {
			convertView = mInflater.inflate(R.layout.item_message_list, null);
		}
		ImageView iv_user_photo = ViewHolder.get(convertView,// 用户头像
				R.id.iv_user_photo);
		TextView tv_name = ViewHolder.get(convertView, R.id.tv_name);// 用户名
		TextView tv_last_message = ViewHolder.get(convertView,// 最后的消息
				R.id.tv_last_message);
		TextView tv_time = ViewHolder.get(convertView, R.id.tv_time);// 时间
		bmUtils.display(iv_user_photo, tm.getUserPic());
		tv_name.setText(tm.getUserName());
		tv_time.setText(tm.getLastTime());
		tv_last_message.setText(tm.getUserLastMessage());
		return convertView;
	}

}
