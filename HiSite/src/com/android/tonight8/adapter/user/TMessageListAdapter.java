package com.android.tonight8.adapter.user;

import java.util.Date;
import java.util.List;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.tonight8.R;
import com.android.tonight8.adapter.BaseListAdapter;
import com.android.tonight8.adapter.ViewHolder;
import com.android.tonight8.dao.entity.TMessage;
import com.easemob.chat.EMChatManager;
import com.easemob.chat.EMMessage;
import com.easemob.chat.TextMessageBody;

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
		tv_time.setText(new Date(tm.getLastTime()).toLocaleString());
		EMMessage msg = EMChatManager.getInstance().getMessage(
				tm.getUserLastMessage());
		if (msg == null) {
			tv_last_message.setText("");
			return convertView;
		}
		if (msg.getType() == EMMessage.Type.TXT) {
			tv_last_message.setText(((TextMessageBody) msg.getBody())
					.getMessage());
		} else if (msg.getType() == EMMessage.Type.IMAGE) {
			tv_last_message.setText("[图片文件]");
		} else if (msg.getType() == EMMessage.Type.VOICE) {
			tv_last_message.setText("[声音文件]");
		}

		return convertView;
	}

}
