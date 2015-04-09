package com.android.tonight8.utils;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.LinearInterpolator;
import android.view.animation.ScaleAnimation;

public class HSAnimationUtils {
	/**
	 * 播放折叠和打开的动画
	 * 
	 * @param v
	 */
	public static void playShowOrHideAnimation(View v,
			AnimationListener listener, boolean isShow) {
		v.clearAnimation();
		if (!isShow)
			v.startAnimation(AnimationFactory.createShowAnimation(listener));
		else
			v.startAnimation(AnimationFactory.createHideAnimation(listener));
	}

	/**
	 * 动画工厂类
	 * 
	 * @Descripton
	 * @author LiXiaoSong
	 * @2015-4-9
	 * @Tonight8
	 */
	private static class AnimationFactory {
		public static Animation createShowAnimation(AnimationListener listener) {
			ScaleAnimation animation = new ScaleAnimation(1.0f, 1.0f, 0.0f,
					1.0f, 1.0f, 0.0f);
			animation.setDuration(100);
			animation.setInterpolator(new LinearInterpolator());
			if (listener != null)
				animation.setAnimationListener(listener);
			return animation;
		}

		public static Animation createHideAnimation(AnimationListener listener) {
			ScaleAnimation animation = new ScaleAnimation(1.0f, 1.0f, 1.0f,
					0.0f, 1.0f, 1.0f);
			animation.setDuration(100);
			if (listener != null)
				animation.setAnimationListener(listener);
			animation.setInterpolator(new LinearInterpolator());
			return animation;
		}
	}
}
