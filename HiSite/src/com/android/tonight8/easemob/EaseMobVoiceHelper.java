package com.android.tonight8.easemob;

import java.io.File;
import java.io.IOException;

import android.app.Activity;
import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;

import com.easemob.chat.EMMessage;
import com.easemob.chat.VoiceMessageBody;
import com.lidroid.xutils.util.LogUtils;

/**
 * @Descripton 关于声音文件播放的工具类
 * @author LiXiaoSong
 * @2015-4-28
 * @Tonight8
 */
public class EaseMobVoiceHelper {
	/** 同一时刻，只能有一个文件在播放 */
	public static boolean singleChannel = false;
	/** 音频播放器 */
	private static MediaPlayer player;

	public static void playVoice(EMMessage msg, Activity activity) {
		VoiceMessageBody body = (VoiceMessageBody) msg.getBody();
		String localUrl = body.getLocalUrl();
		String remoteUrl = body.getRemoteUrl();
		if (msg.direct == EMMessage.Direct.SEND) {// 发送的消息
			doPlay(localUrl, activity);
		} else {// 接收的消息
			doPlay(localUrl, activity);
		}
	}

	public static void stopVoice() {
		if (player != null) {
			if (player.isPlaying()) {
				player.stop();
				player.reset();
				player.release();
				singleChannel = false;
				player = null;
			}
		}
	}

	private static void doPlay(String path, Activity activity) {
		File file = new File(path);
		if (!file.exists()) {
			LogUtils.v("音频文件未找到");
			return;// 这个文件不存在
		}
		LogUtils.v("音频文件的地址是" + path);
		AudioManager audioManager = (AudioManager) activity
				.getSystemService(Context.AUDIO_SERVICE);
		player = new MediaPlayer();
		// if (EMChatManager.getInstance().getChatOptions().getUseSpeaker()) {
		// audioManager.setMode(AudioManager.MODE_NORMAL);
		// audioManager.setSpeakerphoneOn(true);
		// player.setAudioStreamType(AudioManager.STREAM_RING);
		// } else {
		// audioManager.setSpeakerphoneOn(false);// 关闭扬声器
		// // 把声音设定成Earpiece（听筒）出来，设定为正在通话中
		// audioManager.setMode(AudioManager.MODE_IN_CALL);
		// player.setAudioStreamType(AudioManager.STREAM_VOICE_CALL);
		// }
		try {
			// player.setVolume(1, 1);
			// 听筒播放逻辑处理
			audioManager.setSpeakerphoneOn(false);
			audioManager.setMode(AudioManager.MODE_IN_CALL);
			activity.setVolumeControlStream(AudioManager.STREAM_VOICE_CALL);
			player.setAudioStreamType(AudioManager.STREAM_MUSIC);
			player.setDataSource(path);
			player.setLooping(false);
			player.prepare();

			player.setOnCompletionListener(new OnCompletionListener() {
				@Override
				public void onCompletion(MediaPlayer mp) {
					player.reset();
					player.release();
					player = null;
					singleChannel = false;
				}
			});
			singleChannel = true;
			player.start();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static boolean isPlaying() {
		return singleChannel;
	}
}
