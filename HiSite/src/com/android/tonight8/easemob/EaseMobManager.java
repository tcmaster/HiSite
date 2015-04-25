package com.android.tonight8.easemob;

import java.io.File;

import android.content.Context;
import android.content.IntentFilter;
import android.util.Log;

import com.easemob.EMCallBack;
import com.easemob.EMError;
import com.easemob.chat.EMChat;
import com.easemob.chat.EMChatManager;
import com.easemob.chat.EMConversation;
import com.easemob.chat.EMGroupManager;
import com.easemob.chat.EMMessage;
import com.easemob.chat.EMMessage.ChatType;
import com.easemob.chat.ImageMessageBody;
import com.easemob.chat.MessageBody;
import com.easemob.chat.TextMessageBody;
import com.easemob.chat.VoiceMessageBody;
import com.easemob.exceptions.EaseMobException;

/**
 * ���Ź�����
 * 
 * @Descripton
 * @author LiXiaoSong
 * @2015-4-13
 * @EaseMobTest
 */
public class EaseMobManager {
	/**
	 * 
	 * @param context
	 */
	private static Context useContext;// context
	private static MessageReceiver receiver;// 接收消息的广播

	public static void initEaseMob(Context context) {
		useContext = context;
		int pid = android.os.Process.myPid();
		String processAppName = MobUtils.getAppName(useContext, pid);

		if (processAppName == null
				|| !processAppName.equalsIgnoreCase("com.android.tonight8")) {
			return;
		}
		EMChat.getInstance().setAutoLogin(false);
		EMChat.getInstance().init(useContext);
		EMChat.getInstance().setDebugMode(true);
	}

	/**
	 * 注册一个账号
	 * 
	 * @param userName
	 * @param password
	 */
	public static void registerAccount(final String userName,
			final String password) {
		new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					EMChatManager.getInstance().createAccountOnServer(userName,
							password);
				} catch (EaseMobException e) {
					int errorCode = e.getErrorCode();
					switch (errorCode) {
					case EMError.NONETWORK_ERROR:
						Log.v("test", "网络异常");
						break;
					case EMError.USER_ALREADY_EXISTS:
						Log.v("test", "用户已注册");
						break;
					case EMError.UNAUTHORIZED:
						Log.v("test", "权限不足");
						break;
					default:
						Log.v("test", "注册失败");
						break;
					}
				}
			}
		}).start();
	}

	/**
	 * 登录
	 * 
	 * @param userName
	 *            用户名
	 * @param password
	 *            密码
	 * @param callBack
	 *            登录回调
	 */
	public static void loginAccount(final String userName,
			final String password, final LoginCallBack callBack) {
		if (!EMChatManager.getInstance().isConnected()) {
			EMChatManager.getInstance().login(userName, password,
					new EMCallBack() {

						@Override
						public void onSuccess() {
							reflushInfo();
							receiver = new MessageReceiver();
							IntentFilter intentFilter = new IntentFilter(
									EMChatManager.getInstance()
											.getNewMessageBroadcastAction());
							intentFilter.setPriority(3);
							useContext.registerReceiver(receiver, intentFilter);
							EMChat.getInstance().setAppInited();
							callBack.onSuccess();
						}

						@Override
						public void onProgress(int arg0, String arg1) {

						}

						@Override
						public void onError(int arg0, String arg1) {
							callBack.onError(arg0, arg1);
						}
					});
		} else {
			callBack.onError(444, "未连接");
		}
	}

	/**
	 * 登出
	 */
	public static void logout() {
		if (EMChatManager.getInstance().isConnected()) {
			EMChatManager.getInstance().logout(new EMCallBack() {

				@Override
				public void onSuccess() {
					// �ǳ��ɹ�
					if (receiver != null)// ȡ����Ϣ����
						useContext.unregisterReceiver(receiver);
				}

				@Override
				public void onProgress(int arg0, String arg1) {
				}

				@Override
				public void onError(int arg0, String arg1) {
				}
			});
		}
	}

	// /////////////////////////������Ϣ���//////////////////////////////////////
	/**
	 * 
	 * @param userName
	 *            �û���
	 * @param type
	 *            �������ͣ����ģ�Ⱥ�ģ�
	 * @param type2
	 *            ��Ϣ���ͣ��ı���ͼƬ��������
	 * @param body
	 *            ��Ϣʵ��
	 * @param callBack
	 *            �ص�
	 */
	private static EMMessage sendMessage(String userName, ChatType type,
			EMMessage.Type type2, MessageBody body, final SendCallBack callBack) {
		EMConversation conversation = EMChatManager.getInstance()
				.getConversation(userName);
		final EMMessage message = EMMessage.createSendMessage(type2);
		message.setChatType(type);
		message.addBody(body);
		message.setReceipt(userName);
		message.setAttribute("photoUrl",
				"http://img4.imgtn.bdimg.com/it/u=2352711400,4289515900&fm=11&gp=0.jpg");// 用户头像,自定义属性
		conversation.addMessage(message);
		EMChatManager.getInstance().sendMessage(message, new EMCallBack() {

			@Override
			public void onSuccess() {
				if (callBack != null)
					callBack.onSuccess(message);
			}

			@Override
			public void onProgress(int value, String des) {
				if (callBack != null)
					callBack.onProcess(value, des);
			}

			@Override
			public void onError(int code, String msg) {
				if (callBack != null)
					callBack.onFail(code, msg);
			}
		});
		return message;

	}

	/**
	 * ����������Ϣ
	 * 
	 * @param userName
	 * @param content
	 * @param callBack
	 */
	public static EMMessage sendTxtMessage(String userName, String content,
			SendCallBack callBack) {
		TextMessageBody body = new TextMessageBody(content);
		return sendMessage(userName, ChatType.Chat, EMMessage.Type.TXT, body,
				callBack);
	}

	/**
	 * 发送图片消息
	 * 
	 * @param userName
	 * @param imageFile
	 * @param callBack
	 */
	public static void sendImgMessage(final String userName, File imageFile,
			final SendCallBack callBack) {
		ImageMessageBody body = new ImageMessageBody(imageFile);
		body.setSendOriginalImage(true);// ����ԭͼ
		sendMessage(userName, ChatType.Chat, EMMessage.Type.IMAGE, body,
				callBack);
	}

	/**
	 * 发送声音消息
	 */
	public static void sendVoiceMessage(String userName, File voiceFile,
			int second, SendCallBack callBack) {
		VoiceMessageBody body = new VoiceMessageBody(voiceFile, second);
		sendMessage(userName, ChatType.Chat, EMMessage.Type.VOICE, body,
				callBack);
	}

	/**
	 * 刷新信息
	 */
	public static void reflushInfo() {
		EMGroupManager.getInstance().loadAllGroups();
		EMChatManager.getInstance().loadAllConversations();
	}

	/**
	 * 登录回调
	 * 
	 * @Descripton
	 * @author LiXiaoSong
	 * @2015-4-13
	 * @EaseMobTest
	 */
	public static interface LoginCallBack {
		public void onSuccess();

		public void onError(int code, String msg);
	}

	/**
	 * 发送消息的回调
	 * 
	 * @Descripton
	 * @author LiXiaoSong
	 * @2015-4-22
	 * @Tonight8
	 */
	public static interface SendCallBack {
		public void onSuccess(EMMessage msg);

		public void onProcess(int value, String des);

		public void onFail(int code, String msg);
	}
}
