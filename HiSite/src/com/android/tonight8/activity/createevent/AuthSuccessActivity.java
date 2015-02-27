package com.android.tonight8.activity.createevent;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.android.tonight8.R;
import com.android.tonight8.base.BaseActivity;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnClick;

/**
 * @Description:认证成功页面
 * @author:LiuZhao
 * @Date:2015年2月27日
 */
public class AuthSuccessActivity extends BaseActivity {

	/** 认证成功 */
	@ViewInject(R.id.ok_auth_success)
	private Button ok_auth_success;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		setContentView(R.layout.activity_auth_success);
		super.onCreate(savedInstanceState);
		getActionBarBase("认证");
	}

	@OnClick(R.id.ok_auth_success)
	public void onClick(View v) {
		finish();
	}
}
