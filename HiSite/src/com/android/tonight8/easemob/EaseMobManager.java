package com.android.tonight8.easemob;

import java.io.File;

import android.app.Activity;
import android.content.Context;
import android.content.IntentFilter;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.android.tonight8.R;
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
import com.lidroid.xutils.BitmapUtils;

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
	 * ��ʼ�����ţ��ڿͻ���ʹ��ʱ������APP���е����������
	 * 
	 * @param context
	 */
	private static Context useContext;// �������context
	private static MessageReceiver receiver;// ������Ϣ�Ĺ㲥

	public static void initEaseMob(Context context) {
		Log.v("test", "���뻷�ų�ʼ��");
		useContext = context;
		int pid = android.os.Process.myPid();
		String processAppName = MobUtils.getAppName(useContext, pid);
		// ���app������Զ�̵�service����application:onCreate�ᱻ����2��
		// Ϊ�˷�ֹ����SDK����ʼ��2�Σ��Ӵ��жϻᱣ֤SDK����ʼ��1��
		// Ĭ�ϵ�app�����԰���ΪĬ�ϵ�process name�����У����鵽��process
		// name����app��process
		// name����������

		if (processAppName == null
				|| !processAppName.equalsIgnoreCase("com.example.easemobtest")) {
			Log.e("lixiaosong", "enter the service process!");
			// "com.easemob.chatuidemo"Ϊdemo�İ������Լ���Ŀ��Ҫ�ĳ��Լ�����
			// ���application::onCreate �Ǳ�service ���õģ�ֱ�ӷ���
			return;
		}
		EMChat.getInstance().setAutoLogin(false);
		EMChat.getInstance().init(useContext);
		EMChat.getInstance().setDebugMode(true);
	}

	/**
	 * ע��һ�������˺ţ�������
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
						Log.v("test", "�����쳣");
						break;
					case EMError.USER_ALREADY_EXISTS:
						Log.v("test", "�û��Ѵ���");
						break;
					case EMError.UNAUTHORIZED:
						Log.v("test", "��Ȩ��");
						break;
					default:
						Log.v("test", "ע��ʧ��");
						break;
					}
				}
			}
		}).start();
	}

	/**
	 * ��¼�����˺�
	 * 
	 * @param userName
	 *            �û���
	 * @param password
	 *            ����
	 * @param callBack
	 *            ��¼�ص�
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
							Log.v("test", "�����������¼ʧ��");
							callBack.onError(arg0, arg1);
						}
					});
		} else {
			callBack.onError(444, "�ѵ�½");
		}
	}

	/**
	 * �˳���¼�����˺�
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
	private static void sendMessage(String userName, ChatType type,
			EMMessage.Type type2, MessageBody body, EMCallBack callBack) {
		EMConversation conversation = EMChatManager.getInstance()
				.getConversation(userName);
		EMMessage message = EMMessage.createSendMessage(type2);
		message.setChatType(type);
		message.addBody(body);
		message.setReceipt(userName);
		conversation.addMessage(message);
		EMChatManager.getInstance().sendMessage(message, callBack);

	}

	/**
	 * ����������Ϣ
	 * 
	 * @param userName
	 * @param content
	 * @param callBack
	 */
	public static void sendTxtMessage(String userName, String content,
			EMCallBack callBack) {
		TextMessageBody body = new TextMessageBody(content);
		sendMessage(userName, ChatType.Chat, EMMessage.Type.TXT, body, callBack);
	}

	/**
	 * ����ͼƬ��Ϣ
	 * 
	 * @param userName
	 * @param imageFile
	 * @param callBack
	 */
	public static void sendImgMessage(final String userName, File imageFile,
			final Activity activity, final View container,
			final ViewGroup parent, final BitmapUtils bmUtils,
			final ImageCallBack callBack) {
		parent.addView(container);
		/** ͼƬcontainer���Ŀؼ� */
		final ImageView iv_photo = (ImageView) container
				.findViewById(R.id.iv_photo);
		final ProgressBar pb_bar = (ProgressBar) container
				.findViewById(R.id.pb_image);
		final TextView tv_pnum = (TextView) container
				.findViewById(R.id.tv_pnum);
		pb_bar.setVisibility(View.VISIBLE);
		tv_pnum.setVisibility(View.VISIBLE);
		ImageMessageBody body = new ImageMessageBody(imageFile);
		body.setSendOriginalImage(true);// ����ԭͼ
		sendMessage(userName, ChatType.Chat, EMMessage.Type.IMAGE, body,
				new EMCallBack() {
					@Override
					public void onSuccess() {
						activity.runOnUiThread(new Runnable() {

							@Override
							public void run() {
								EMConversation conversation = EMChatManager
										.getInstance()
										.getConversation(userName);
								EMMessage msg = conversation.getLastMessage();
								EaseMobImageHelper.showImage(msg, container,
										activity, bmUtils);
								callBack.onSuccess(msg);
							}
						});

					}

					@Override
					public void onProgress(final int progress, String arg1) {
						activity.runOnUiThread(new Runnable() {

							@Override
							public void run() {
								pb_bar.setProgress(progress);
								tv_pnum.setText(progress + "");
							}
						});
					}

					@Override
					public void onError(final int arg0, final String arg1) {
						activity.runOnUiThread(new Runnable() {

							@Override
							public void run() {
								parent.removeView(container);
								callBack.onFail(arg0, arg1);
							}
						});
					}
				});
	}

	/**
	 * ����������Ϣ
	 */
	public static void sendVoiceMessage(String userName, File voiceFile,
			int second, EMCallBack callBack) {
		VoiceMessageBody body = new VoiceMessageBody(voiceFile, second);
		sendMessage(userName, ChatType.Chat, EMMessage.Type.VOICE, body,
				callBack);
	}

	/**
	 * ˢ��������Ϣ
	 */
	public static void reflushInfo() {
		EMGroupManager.getInstance().loadAllGroups();
		EMChatManager.getInstance().loadAllConversations();
	}

	/**
	 * ��¼��Ļص��ӿ�
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

	public static interface ImageCallBack {
		public void onSuccess(EMMessage msg);

		public void onFail(int code, String msg);
	}
}
