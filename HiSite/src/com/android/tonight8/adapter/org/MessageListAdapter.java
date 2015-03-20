package com.android.tonight8.adapter.org;

import java.util.List;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.tonight8.R;
import com.android.tonight8.adapter.BaseListAdapter;
import com.android.tonight8.model.common.Message;
import com.android.tonight8.model.organization.OrgMessageModel;

public class MessageListAdapter extends BaseListAdapter<OrgMessageModel> {

	public MessageListAdapter(Context context, List<OrgMessageModel> values) {
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
		Message message = mValues.get(position).getMessage();
		 if ("1".equals(message.getType())) {
		 holder.tv_message_type.setText("官方");
		 } else {
		 holder.tv_message_type.setText("商家");
		 }

		holder.tv_message_title.setText(message.getTitle());
		holder.tv_message_content.setText(message.getContent());
		holder.tv_message_datetime.setText(message.getDate() + message.getTime());
		// Tonight8App.getSelf().bitmapUtils.display(holder.iv_org_logopic, message.get);
		return convertView;
	}

	/**
	 * 增加数据源
	 * 
	 * @param models
	 */
	public void addData(List<OrgMessageModel> models) {
		mValues.addAll(models);
		notifyDataSetChanged();
	}

	/**
	 * 重置数据源
	 * 
	 * @param models
	 */
	public void initData(List<OrgMessageModel> models) {
		mValues.clear();
		mValues.addAll(models);
		notifyDataSetChanged();
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
