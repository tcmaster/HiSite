package com.android.tonight8.easemob;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.easemob.chat.EMChatManager;
import com.easemob.chat.EMMessage;

/**
 * 接收发送到本用户的消息(msgId)
 */
public class MessageReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		String msgId = intent.getStringExtra("msgid");
		String username = intent.getStringExtra("from");
		Intent messageIntent = new Intent();
		messageIntent.setAction(MobConstants.MESSAGE_GET);
		messageIntent.putExtra("msgId", msgId);
		EMMessage message = EMChatManager.getInstance().getMessage(msgId);
		MobUtils.saveOrUpdateMessage(message, username);
		context.sendBroadcast(messageIntent);
	}

}
