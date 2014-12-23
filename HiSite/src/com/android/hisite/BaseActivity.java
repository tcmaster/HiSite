package com.android.hisite;

import com.lidroid.xutils.ViewUtils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

public class BaseActivity extends FragmentActivity {
	/** 获取当前Activity的上下文对象 */
	protected Context mContext;
	/**
	 * 通过构造方法对上下文内容与全局的app初始化
	 */
	public BaseActivity() {
		mContext = this;
	}
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		ViewUtils.inject(this);
	}
	
	/**
	 * 启动activity带有动画切换
	 * 
	 * @param intent
	 *            含跳转目标的Intent
	 * @param requestCode
	 *            跳转Activity时的Code,当返回时方便处理数据
	 * @param parentActivity
	 *            获取布当前Activity的父Activity实例，如果父实例存在，那么返回的时候以父Activity为准。
	 * @see:
	 * @since:
	 * @author: PengGuoHua
	 * @date:2014-10-31
	 */
	protected void startActivityForResultAndAnima(Intent intent,
			int requestCode, Activity parentActivity) {
		if (intent != null) {
			parentActivity = getParent();
			if (parentActivity != null) {
				parentActivity.startActivityForResult(intent, requestCode);
				parentActivity.overridePendingTransition(R.anim.push_left_in,
						R.anim.push_left_out);
			} else {
				startActivityForResult(intent, requestCode);
				overridePendingTransition(R.anim.push_left_in,
						R.anim.push_left_out);
			}
		}
	}

	/**
	 * 启动activity带有动画切换
	 * 
	 * @param intent
	 *            含跳转目标的Intent
	 * @param parentActivity
	 *            当前Activity的父Activity
	 * @see:
	 * @since:
	 * @author: PengGuoHua
	 * @date:2014-10-31
	 */
	protected void startActivityForAnima(Intent intent, Activity parentActivity) {
		if (intent != null) {
			parentActivity = getParent();
			if (parentActivity != null) {
				parentActivity.startActivity(intent);
				parentActivity.overridePendingTransition(R.anim.push_left_in,
						R.anim.push_left_out);
			} else {
				startActivity(intent);
				overridePendingTransition(R.anim.push_left_in,
						R.anim.push_left_out);
			}
		}
	}
}
