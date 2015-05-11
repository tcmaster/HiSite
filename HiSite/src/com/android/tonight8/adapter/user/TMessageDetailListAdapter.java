package com.android.tonight8.adapter.user;

import java.util.Date;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.android.tonight8.R;
import com.android.tonight8.adapter.BaseListAdapter;
import com.android.tonight8.easemob.EaseMobImageHelper;
import com.android.tonight8.easemob.EaseMobVoiceHelper;
import com.easemob.chat.EMMessage;
import com.easemob.chat.TextMessageBody;
import com.easemob.exceptions.EaseMobException;
import com.lidroid.xutils.util.LogUtils;

public class TMessageDetailListAdapter extends BaseListAdapter<EMMessage> {

	public TMessageDetailListAdapter(Context context, List<EMMessage> values) {
		super(context, values);
	}

	@Override
	protected View getItemView(View convertView, int position) {
		final EMMessage message = mValues.get(position);
		boolean isSend = false;// 这个标志用于判断当前显示的message是发送的消息还是接收的消息
		MessageViewHolder holder = null;
		LogUtils.v("messageInfoIs" + message.toString());
		if (message.direct == EMMessage.Direct.SEND)
			isSend = true;
		else if (message.direct == EMMessage.Direct.RECEIVE)
			isSend = false;
		if (convertView == null) {
			holder = new MessageViewHolder();
			if (isSend) {
				convertView = mInflater.inflate(
						R.layout.item_message_detail_me, null);
				holder.flag = 1;
			} else {
				convertView = mInflater.inflate(
						R.layout.item_message_detail_other, null);
				holder.flag = 0;
			}
			holder.iv_photo = (ImageView) convertView
					.findViewById(R.id.iv_photo);
			holder.iv_user_photo = (ImageView) convertView
					.findViewById(R.id.iv_user_photo);
			holder.layout_img = (FrameLayout) convertView
					.findViewById(R.id.layout_img);
			holder.tv_content = (TextView) convertView
					.findViewById(R.id.tv_content);
			holder.pb_image = (ProgressBar) holder.layout_img
					.findViewById(R.id.pb_image);
			holder.tv_pnum = (TextView) holder.layout_img
					.findViewById(R.id.tv_num);
			holder.tv_time_show = (TextView) convertView
					.findViewById(R.id.tv_time_show);
			holder.iv_voice = (ImageView) convertView
					.findViewById(R.id.iv_voice);
			convertView.setTag(holder);
		} else {
			holder = (MessageViewHolder) convertView.getTag();
			if ((isSend && holder.flag == 1) || (!isSend && holder.flag == 0)) {

			} else {
				// 视图已经不同，重新建立一个viewholder
				holder = new MessageViewHolder();
				if (isSend) {
					convertView = mInflater.inflate(
							R.layout.item_message_detail_me, null);
					holder.flag = 1;
				} else {
					convertView = mInflater.inflate(
							R.layout.item_message_detail_other, null);
					holder.flag = 0;
				}
				holder.iv_photo = (ImageView) convertView
						.findViewById(R.id.iv_photo);
				holder.iv_user_photo = (ImageView) convertView
						.findViewById(R.id.iv_user_photo);
				holder.layout_img = (FrameLayout) convertView
						.findViewById(R.id.layout_img);
				holder.tv_content = (TextView) convertView
						.findViewById(R.id.tv_content);
				holder.pb_image = (ProgressBar) holder.layout_img
						.findViewById(R.id.pb_image);
				holder.tv_pnum = (TextView) holder.layout_img
						.findViewById(R.id.tv_num);
				holder.tv_time_show = (TextView) convertView
						.findViewById(R.id.tv_time_show);
				holder.iv_voice = (ImageView) convertView
						.findViewById(R.id.iv_voice);
				convertView.setTag(holder);
			}
		}
		// 初始化处理
		holder.tv_content.setVisibility(View.INVISIBLE);
		holder.layout_img.setVisibility(View.INVISIBLE);
		holder.tv_time_show.setVisibility(View.INVISIBLE);
		holder.iv_voice.setVisibility(View.INVISIBLE);
		if (isSend) {
			// 发送出去的消息，用户头像直接使用本地头像
			bmUtils.display(holder.iv_user_photo,
					"http://img4.imgtn.bdimg.com/it/u=3923171974,2721923014&fm=21&gp=0.jpg");
		} else {
			// 接收消息，使用该消息附带的用户头像
			try {
				bmUtils.display(holder.iv_user_photo,
						message.getStringAttribute("photoUrl"));
			} catch (EaseMobException e) {
				LogUtils.v("未能成功获取用户头像信息");
			}
		}
		// 时间戳的处理
		if (position == 0) {// 当前位置是顶端，显示时间戳
			holder.tv_time_show.setText(new Date(message.getMsgTime())
					.toLocaleString());
			holder.tv_time_show.setVisibility(View.VISIBLE);
		} else {
			// 当前位置不是顶端，与前一个进行比较，若时间间隔大于5分钟，则显示时间戳
			long beforeTime = mValues.get(position - 1).getMsgTime();
			long nowTime = message.getMsgTime();
			if (nowTime - beforeTime > 1000 * 60 * 5) {// 大于5分钟
				holder.tv_time_show.setText(new Date(message.getMsgTime())
						.toLocaleString());
				holder.tv_time_show.setVisibility(View.VISIBLE);
			}
		}
		if (message.getType() == EMMessage.Type.TXT) {// 文字类型消息的处理
			holder.tv_content.setVisibility(View.VISIBLE);
			holder.tv_content.setText(((TextMessageBody) message.getBody())
					.getMessage());
		} else if (message.getType() == EMMessage.Type.IMAGE) {// 图片类型消息的处理
			holder.layout_img.setVisibility(View.VISIBLE);
			holder.iv_photo.setImageBitmap(null);
			EaseMobImageHelper.showImage(message, holder.layout_img, mContext,
					bmUtils);
		} else if (message.getType() == EMMessage.Type.VOICE) {// 语音类型消息处理
			holder.iv_voice.setVisibility(View.VISIBLE);
			holder.iv_voice.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					if (EaseMobVoiceHelper.isPlaying()) {
						EaseMobVoiceHelper.stopVoice();
					} else {
						EaseMobVoiceHelper.playVoice(message,
								(Activity) mContext);
					}
				}
			});
		}
		return convertView;
	}

	/**
	 * 用于在当前页面接收到新消息时，更新界面所用的方法
	 * 
	 * @param message
	 */
	public void addMessage(EMMessage message) {
		mValues.add(message);
		// notifyDataSetInvalidated();
		notifyDataSetChanged();
	}

	/**
	 * message的专用ViewHolder
	 * 
	 * @Descripton
	 * @author LiXiaoSong
	 * @2015-4-22
	 * @Tonight8
	 */
	private class MessageViewHolder {
		TextView tv_time_show;// 时间戳
		TextView tv_content;// 聊天内容（文字）
		ImageView iv_user_photo;// 用户头像
		FrameLayout layout_img;// 聊天内容（图片）
		ImageView iv_photo;// 图片内容
		ProgressBar pb_image;// 图片进度条（圆形）
		TextView tv_pnum;// 图片下载进度数字显示
		ImageView iv_voice;// 声音内容
		int flag;// 用来标注该视图属于接收视图还是发送视图,1为发送，0为接收
	}
}
