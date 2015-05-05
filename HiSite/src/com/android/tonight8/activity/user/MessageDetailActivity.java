package com.android.tonight8.activity.user;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.android.tonight8.R;
import com.android.tonight8.adapter.user.TMessageDetailListAdapter;
import com.android.tonight8.base.BaseActivity;
import com.android.tonight8.easemob.EaseMobManager;
import com.android.tonight8.easemob.EaseMobManager.SendCallBack;
import com.android.tonight8.easemob.EaseMobVoiceHelper;
import com.android.tonight8.easemob.MobConstants;
import com.android.tonight8.easemob.MobUtils;
import com.android.tonight8.utils.HSAnimationUtils;
import com.android.tonight8.utils.Utils;
import com.easemob.chat.EMChatManager;
import com.easemob.chat.EMConversation;
import com.easemob.chat.EMMessage;
import com.easemob.util.VoiceRecorder;
import com.lidroid.xutils.util.LogUtils;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnClick;

public class MessageDetailActivity extends BaseActivity {
	/** 聊天内容列表 */
	@ViewInject(R.id.lv_message_detail)
	private ListView lv_message;
	/** 发送声音 */
	@ViewInject(R.id.iv_voice)
	private ImageView iv_voice;
	/** 发送文字 */
	@ViewInject(R.id.et_content)
	private EditText et_content;
	/** 发送图片 */
	@ViewInject(R.id.iv_add_photo)
	private ImageView iv_add_photo;
	/** 聊天历史记录（测试用） */
	@ViewInject(R.id.btn_history)
	private Button btn_history;
	/** 添加附件的布局 */
	@ViewInject(R.id.ll_send_attachments)
	private LinearLayout ll_send_attachments;
	/** 图库传图片 */
	@ViewInject(R.id.ib_gallery)
	private ImageView ib_gallery;
	/** 拍照传图片 */
	@ViewInject(R.id.ib_take_pic)
	private ImageView ib_take_pic;
	/** 发送声音 */
	@ViewInject(R.id.ib_voice)
	private ImageView ib_voice;
	/** 附件发送进度 */
	@ViewInject(R.id.tv_process)
	private TextView tv_process;
	/** 声音控件布局 */
	@ViewInject(R.id.rl_recording_container)
	private RelativeLayout rl_recording_container;
	/** 麦克风图像 */
	@ViewInject(R.id.iv_mic_image)
	private ImageView iv_mic_image;
	/** 录音文字 */
	@ViewInject(R.id.tv_recording_hint)
	private TextView tv_recording_hint;
	/** 点击按语音时候的提示控件 */
	@ViewInject(R.id.tv_voice_prompt)
	private TextView tv_voice_prompt;
	/** 本界面要对话的用户 */
	private String userName;
	/** 本界面的适配器 */
	private TMessageDetailListAdapter tmdadapter;
	/** 本界面的广播接收器 */
	private MyReceiver receiver;
	/** 本界面的录音器 */
	private VoiceRecorder voiceRecorder;
	/** 录音器的handler */
	private Handler voiceHandler;
	/** 麦克风图片资源 */
	private Drawable[] micImages;
	/**
	 * 本界面的会话
	 */
	private EMConversation conversation;
	/**
	 * 该页面当前所翻的页码
	 */
	private int currentPage = 0;
	private final int PAGE_COUNT = 10;
	/** 当前更新后的位置标志位，历史记录 */
	private final int HISTORY = 1;
	/** 当前更新后的标志位，新消息 */
	private final int NEW_MESSAGE = 2;
	/** 当前更新后的标志位，其他 */
	private final int OTHER = 3;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		setContentView(R.layout.activity_message_detail);
		super.onCreate(savedInstanceState);
		initDatas();
	}

	private void initDatas() {
		userName = getIntent().getStringExtra("userName");
		conversation = EMChatManager.getInstance().getConversation(userName);
		update(OTHER, -1);
		micImages = new Drawable[] {
				getResources().getDrawable(R.drawable.record_animate_01),
				getResources().getDrawable(R.drawable.record_animate_02),
				getResources().getDrawable(R.drawable.record_animate_03),
				getResources().getDrawable(R.drawable.record_animate_04),
				getResources().getDrawable(R.drawable.record_animate_05),
				getResources().getDrawable(R.drawable.record_animate_06),
				getResources().getDrawable(R.drawable.record_animate_07),
				getResources().getDrawable(R.drawable.record_animate_08),
				getResources().getDrawable(R.drawable.record_animate_09),
				getResources().getDrawable(R.drawable.record_animate_10),
				getResources().getDrawable(R.drawable.record_animate_11),
				getResources().getDrawable(R.drawable.record_animate_12),
				getResources().getDrawable(R.drawable.record_animate_13),
				getResources().getDrawable(R.drawable.record_animate_14), };
		voiceHandler = new Handler() {
			@Override
			public void handleMessage(Message msg) {
				iv_mic_image.setImageDrawable(micImages[msg.what]);
			}
		};
		if (voiceRecorder == null) {
			voiceRecorder = new VoiceRecorder(voiceHandler);
		}
		ib_voice.setOnTouchListener(new VoiceClickListener());
		receiver = new MyReceiver();
		IntentFilter filter = new IntentFilter(MobConstants.MESSAGE_GET);
		this.registerReceiver(receiver, filter);
	}

	@Override
	protected void onDestroy() {
		if (receiver != null)
			this.unregisterReceiver(receiver);
		super.onDestroy();
	}

	@OnClick({ R.id.iv_voice, R.id.iv_add_photo, R.id.btn_history,
			R.id.ib_gallery, R.id.ib_take_pic, R.id.ib_voice })
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.iv_voice:// 暂时当做文字消息提交使用
			processSendText();
			break;
		case R.id.iv_add_photo:
			processShowAttachment();
			break;
		case R.id.btn_history:
			processHistory();
			break;
		case R.id.ib_gallery:
			getPhotoFromGallery(PICKPICTURE);
			break;
		case R.id.ib_take_pic:
			getPhotoByTakePicture(TAKEPHOTO);
			break;
		case R.id.ib_voice:
			// 暂时作为声音入口
			// sendVoiceMessage();
			break;
		default:
			break;
		}
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (requestCode == PICKPICTURE && resultCode == RESULT_OK) {
			if (data != null) {
				Uri uri = data.getData();
				String path = Utils.getRealPathFromURI(uri, this);
				File file = new File(path);
				// 发送
				sendImageMessage(file);
			}
		} else if (requestCode == TAKEPHOTO && resultCode == RESULT_OK) {
			File file = new File(Environment.getExternalStoragePublicDirectory(
					Environment.DIRECTORY_DCIM).getAbsolutePath()
					+ File.separator + tempName);
			// String phoneName = android.os.Build.MODEL;
			// Bitmap bm = BitmapFactory.decodeFile(file.getAbsolutePath());
			// // 有些型号的手机不支持图片旋转
			// // if (!phoneName.equals("HUAWEI C8813D")) {
			// // // 这里需要对照片的角度进行校正
			// // bm =
			// Utils.rotaingImageView(Utils.rotateImg(file.getAbsolutePath()),
			// bm);
			// // }
			// File resultFile = Utils.createBitmapFile(bm);
			// 发送
			sendImageMessage(file);
		}
		super.onActivityResult(requestCode, resultCode, data);
	}

	/**
	 * 发送文字消息
	 */
	private void processSendText() {
		EaseMobManager.sendTxtMessage(userName,
				et_content.getText().toString(), new SendCallBack() {

					@Override
					public void onSuccess(final EMMessage msg) {
						runOnUiThread(new Runnable() {

							@Override
							public void run() {
								// 保存这条消息到数据库
								MobUtils.saveOrUpdateMessage(msg, userName);
								runOnUiThread(new Runnable() {

									@Override
									public void run() {
										et_content.setText("");
										currentPage = 0;
										update(OTHER, -1);
									}
								});
							}
						});
					}

					@Override
					public void onProcess(int value, String des) {
					}

					@Override
					public void onFail(int code, String msg) {
					}
				});
	}

	/**
	 * 发送图片消息
	 */
	private void sendImageMessage(File file) {
		ib_gallery.setEnabled(false);
		ib_take_pic.setEnabled(false);
		tv_process.setVisibility(View.VISIBLE);
		tv_process.setText("图片传送中...进度0%");
		EaseMobManager.sendImgMessage(userName, file, new SendCallBack() {
			@Override
			public void onSuccess(EMMessage msg) {
				MobUtils.saveOrUpdateMessage(msg, userName);
				runOnUiThread(new Runnable() {
					@Override
					public void run() {
						ib_gallery.setEnabled(true);
						ib_take_pic.setEnabled(true);
						tv_process.setVisibility(View.INVISIBLE);
						update(OTHER, -1);
					}
				});

			}

			@Override
			public void onProcess(final int value, String des) {
				runOnUiThread(new Runnable() {
					@Override
					public void run() {
						tv_process.setText("图片传送中...进度" + value + "%");
					}
				});

			}

			@Override
			public void onFail(int code, String msg) {
				runOnUiThread(new Runnable() {

					@Override
					public void run() {
						ib_gallery.setEnabled(true);
						ib_take_pic.setEnabled(true);
						tv_process.setVisibility(View.INVISIBLE);
						Utils.toast("图片发送失败");
					}
				});

			}
		});
	}

	/**
	 * 显示/隐藏附件发送
	 */
	private void processShowAttachment() {
		if (ll_send_attachments.isShown()) {
			HSAnimationUtils.playShowOrHideAnimation(ll_send_attachments,
					new AnimationListener() {

						@Override
						public void onAnimationStart(Animation animation) {
						}

						@Override
						public void onAnimationRepeat(Animation animation) {
						}

						@Override
						public void onAnimationEnd(Animation animation) {
							ll_send_attachments.setVisibility(View.GONE);
						}
					}, true, false);
		} else {
			HSAnimationUtils.playShowOrHideAnimation(ll_send_attachments,
					new AnimationListener() {

						@Override
						public void onAnimationStart(Animation animation) {
						}

						@Override
						public void onAnimationRepeat(Animation animation) {
						}

						@Override
						public void onAnimationEnd(Animation animation) {
							ll_send_attachments.setVisibility(View.VISIBLE);
						}
					}, false, false);
		}
	}

	/**
	 * 历史记录
	 */
	private void processHistory() {
		currentPage++;
		update(HISTORY, lv_message.getCount());
	}

	/**
	 * 更新聊天界面
	 * 
	 * @param isBack
	 *            是否回到更新前的消息位置
	 * @param beforPos
	 *            更新前的消息位置
	 */
	private void update(int flag, int beforPos) {
		List<EMMessage> cacheMessages = conversation.getAllMessages();// 内存中的消息
		LogUtils.v(conversation.getMsgCount() + "");
		List<EMMessage> dbMessages = new ArrayList<EMMessage>();// 数据库消息
		List<EMMessage> messages = new ArrayList<EMMessage>();// 更新后的消息
		int showCount = PAGE_COUNT * currentPage + PAGE_COUNT;
		String recentMsgId = cacheMessages.get(0).getMsgId();
		if (cacheMessages == null || cacheMessages.size() == 0) {
			if (cacheMessages.size() < conversation.getAllMsgCount()) {
				dbMessages = conversation.loadMoreMsgFromDB(recentMsgId,
						showCount);
				cacheMessages = conversation.getAllMessages();
			}
			if (cacheMessages.size() < showCount) {
				btn_history.setEnabled(false);
				btn_history.setText("已是全部内容");
			}
			messages.addAll(cacheMessages);
		} else if (cacheMessages.size() < showCount && cacheMessages.size() > 0) {
			if (conversation.getMsgCount() > cacheMessages.size()) {
				conversation.loadMoreMsgFromDB(recentMsgId, showCount
						- cacheMessages.size());
				cacheMessages = conversation.getAllMessages();
			}
			if (cacheMessages.size() < showCount) {
				btn_history.setEnabled(false);
				btn_history.setText("已是全部内容");
			}
			messages.addAll(cacheMessages);
		} else if (cacheMessages.size() == showCount) {
			messages.addAll(cacheMessages);
		} else if (cacheMessages.size() > showCount) {
			// 这里的实现不要改成用sublist
			for (int i = cacheMessages.size() - showCount; i < cacheMessages
					.size(); i++)
				messages.add(cacheMessages.get(i));
			btn_history.setEnabled(true);
			btn_history.setText("获取更多记录");
		}
		if (tmdadapter == null) {
			tmdadapter = new TMessageDetailListAdapter(this, messages);
			lv_message.setAdapter(tmdadapter);
		} else {
			tmdadapter.update(messages);
		}
		conversation.resetUnreadMsgCount();// 重置未读消息数
		// 设置当前的显示位置
		if (flag == HISTORY) {
			lv_message.setSelection(lv_message.getCount() - beforPos);
		} else if (flag == NEW_MESSAGE) {
			lv_message.setSelection(beforPos);
		} else if (flag == OTHER) {
			lv_message.setSelection(lv_message.getCount());
		}

	}

	/**
	 * 
	 * @Descripton 语音消息按钮监听器
	 * @author LiXiaoSong
	 * @2015-4-28
	 * @Tonight8
	 */
	private class VoiceClickListener implements OnTouchListener {
		@Override
		public boolean onTouch(View v, MotionEvent event) {
			float yPos = event.getY();
			switch (event.getAction()) {
			case MotionEvent.ACTION_DOWN:
				// 按下之后，停止播放其他声音，开启录音模式录音
				if (EaseMobVoiceHelper.isPlaying()) {
					EaseMobVoiceHelper.stopVoice();
				}
				if (rl_recording_container.getVisibility() == View.INVISIBLE)
					rl_recording_container.setVisibility(View.VISIBLE);// 显示录音控件
				voiceRecorder.startRecording(null, userName,
						getApplicationContext());

				break;
			case MotionEvent.ACTION_UP:
				// 抬起之后，判断当前位置，是否处于该控件上方，若不处于，则录音取消
				if (rl_recording_container.getVisibility() == View.VISIBLE)
					rl_recording_container.setVisibility(View.INVISIBLE);// 隐藏录音控件
				if (yPos < 0) {
					voiceRecorder.discardRecording();
					Utils.toast("声音已取消发送");
					return true;
				}
				int second = 0;
				if (voiceRecorder.isRecording())
					second = voiceRecorder.stopRecoding();
				if (second < 1) {
					Utils.toast("录音时间太短");
					return true;
				}
				EaseMobManager.sendVoiceMessage(userName, new File(
						voiceRecorder.getVoiceFilePath()), second,
						new SendCallBack() {

							@Override
							public void onSuccess(EMMessage msg) {
								MobUtils.saveOrUpdateMessage(msg, userName);
								runOnUiThread(new Runnable() {

									@Override
									public void run() {
										update(OTHER, -1);
									}
								});

							}

							@Override
							public void onProcess(int value, String des) {

							}

							@Override
							public void onFail(int code, String msg) {
							}
						});
				tv_voice_prompt.setText("长按说话");
				break;
			case MotionEvent.ACTION_MOVE:
				// 处于移动状态,根据移动的位置不同，显示不同的文字
				if (yPos < 0) {// 在该控件上方
					tv_voice_prompt.setText("松开取消发送");
				} else {
					tv_voice_prompt.setText("向上滑动取消发送");
				}
				break;
			default:
				break;
			}
			return false;
		}
	}

	private class MyReceiver extends BroadcastReceiver {

		@Override
		public void onReceive(Context context, Intent intent) {
			update(NEW_MESSAGE, lv_message.getFirstVisiblePosition());
		}
	}

}
