package com.android.tonight8.utils;

import android.os.CountDownTimer;
import android.widget.Button;

/**
 * @Description:倒计时计时器
 * @author:LiuZhao
 * @copyright © soufun.com
 * @Date:2014年11月4日
 */
public class TimeCount extends CountDownTimer {

	private Button myButton;

	public TimeCount(long millisInFuture, long countDownInterval, Button button) {
		super(millisInFuture, countDownInterval);// 参数依次为 总时长、计时的时间间隔
		this.myButton = button;
	}

	@Override
	public void onFinish() {// 计时完毕时触发
		myButton.setText("获取验证码");
		myButton.setTextSize(13);
		myButton.setClickable(true);
	}

	@Override
	public void onTick(long millisUntilFinished) {// 计时过程显示
		myButton.setClickable(false);
		myButton.setTextSize(12);
		myButton.setText(millisUntilFinished / 1000 + "秒后重新发送");
	}
}
