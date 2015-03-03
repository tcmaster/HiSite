package com.android.tonight8.adapter.org;

import java.util.List;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.tonight8.R;
import com.android.tonight8.adapter.BaseListAdapter;
import com.android.tonight8.base.Tonight8App;
import com.android.tonight8.model.common.Notice;

public class MessageListAdapter extends BaseListAdapter<Notice> {

	public MessageListAdapter(Context context, List<Notice> values) {
		super(context, values);

	}

	@Override
	protected View getItemView(View convertView, int position) {
		ViewHolder holder = null;
		if (convertView == null) {
			holder = new ViewHolder();
			convertView = mInflater.inflate(R.layout.adapter_message_list_item, null);
			holder.tv_message_type = (TextView) convertView.findViewById(R.id.tv_message_type);
			holder.tv_message_title = (TextView) convertView.findViewById(R.id.tv_message_title);
			holder.tv_message_content = (TextView) convertView.findViewById(R.id.tv_message_content);
			holder.tv_message_datetime = (TextView) convertView.findViewById(R.id.tv_message_datetime);
			holder.iv_org_logopic = (ImageView) convertView.findViewById(R.id.iv_org_logopic);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		Notice notice = mValues.get(position);
		holder.tv_message_type.setText("官方");
		holder.tv_message_type.setText("商家");
		// holder.tv_message_title.setText(notice.get);
		// holder.tv_message_content.setText(notice.get);
		// holder.tv_message_datetime.setText(notice.get);
		// Tonight8App.getSelf().bitmapUtils.display(holder.iv_org_logopic, notice.get);
		return convertView;
	}

	private class ViewHolder {

		/** 消息类型 */
		TextView tv_message_type;
		/** 头部标题 */
		TextView tv_message_title;
		/** 消息内容 */
		TextView tv_message_content;
		/** 通知时间日期 */
		TextView tv_message_datetime;
		/** 图片 */
		ImageView iv_org_logopic;

	}
}
