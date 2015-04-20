package com.android.tonight8.easemob;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * ������Ϣ������������Ϣ��,�����յ�����Ϣ�Թ㲥����ʽ���ͳ�ȥ(msgId)
 */
public class MessageReceiver extends BroadcastReceiver {
	@Override
	public void onReceive(Context context, Intent intent) {
		String msgId = intent.getStringExtra("msgid");
		Intent messageIntent = new Intent();
		messageIntent.setAction(MobConstants.MESSAGE_GET);
		messageIntent.putExtra("msgId", msgId);
		context.sendBroadcast(messageIntent);
	}

}
