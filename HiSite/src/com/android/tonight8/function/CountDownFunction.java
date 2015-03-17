package com.android.tonight8.function;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import android.os.Handler;
import android.os.Message;
import android.widget.TextView;

import com.android.tonight8.base.BaseActivity;
import com.lidroid.xutils.util.LogUtils;

/**
 * @Descripton 倒计时功能，用于距开奖时间的倒计时
 * @author LiXiaoSong
 * @2015-3-17
 * @Tonight8
 */
public class CountDownFunction {
	public void beginCountDown(final BaseActivity bA, String time,
			final TextView hour, final TextView minute, final TextView second) {
		final Handler countDownHandler = new Handler() {
			@SuppressWarnings("deprecation")
			@Override
			public void handleMessage(Message msg) {
				long time = (Long) msg.obj;
				if (time < 0) {
					hour.setText("00");
					minute.setText("00");
					second.setText("00");
					bA.flagCountDown = false;
					return;
				}
				Date date = new Date(time);
				SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
				format.setTimeZone(TimeZone.getTimeZone("GMT"));
				String result = format.format(date);
				hour.setText(result.split(":")[0]);
				minute.setText(result.split(":")[1]);
				second.setText(result.split(":")[2]);
			}
		};

		try {
			SimpleDateFormat format = new SimpleDateFormat(
					"yyyy-MM-dd HH:mm:ss");
			format.setTimeZone(TimeZone.getDefault());
			Date date = format.parse(time);
			final long needTimeMillis = date.getTime();
			final long currentTimeMillis = System.currentTimeMillis();
			LogUtils.v("need is " + needTimeMillis);
			LogUtils.v("system is" + currentTimeMillis);
			if (needTimeMillis - currentTimeMillis > 0) {
				new Thread(new Runnable() {

					@Override
					public void run() {
						long timeMillis = needTimeMillis - currentTimeMillis;
						Message msginit = countDownHandler.obtainMessage();
						msginit.obj = timeMillis;
						countDownHandler.sendMessage(msginit);
						try {
							while (bA.flagCountDown) {
								Message msg = countDownHandler.obtainMessage();
								Thread.sleep(1000);
								timeMillis = timeMillis - 1000;
								msg.obj = timeMillis;
								countDownHandler.sendMessage(msg);
							}

						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}).start();
			}

		} catch (ParseException e) {
			e.printStackTrace();
		}

	}
}
