package com.android.hisite;

import android.app.Application;
import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class HiApp extends Application {

	/** 保存当前Application实例，用于方便调用当前应用的全局变量 */
	private static HiApp mApp;

	public HiApp() {
		/* 当前应用对像初始化 */
		mApp = this;
	}

	/**
	 * 获取全局的Application静态变量（单例）的方法
	 */
	public static HiApp getSelf() {
		return mApp;
	}
	
	@Override
	public void onCreate() {
		super.onCreate();
		toastMgr.builder.init(mApp);
	}

	public enum toastMgr {
		builder;

		private View v;
		private TextView tv;
		private Toast toast;

		private void init(Context c) {
			v = LayoutInflater.from(c).inflate(R.layout.toast, null);
			tv = (TextView) v.findViewById(R.id.tv_toast);
			toast = new Toast(c);
			toast.setView(v);
			toast.setGravity(Gravity.CENTER, 0, 0);
		}

		public void display(CharSequence text, int duration) {
			if (text.length() != 0) {
				tv.setText(text);
				toast.setDuration(duration);
				toast.show();
			}
		}

		public void display(int Resid, int duration) {
			if (Resid != 0) {
				tv.setText(Resid);
				toast.setDuration(duration);
				toast.show();
			}
		}

		public void display() {
			toast.cancel();
		}

		public Toast getToast() {
			return toast;
		}
	}
}
