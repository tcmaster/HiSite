package com.android.tonight8.activity.user;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.android.tonight8.R;
import com.android.tonight8.base.BaseActivity;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnClick;

/**
 * @Description:用户登录
 * @author LiXiaoSong
 * @date 2015-1-17
 */
public class UserLoginActivity extends BaseActivity {

	/** 用户名 */
	@ViewInject(R.id.et_user_id)
	private EditText et_user_id;
	/** 用户登陆密码 */
	@ViewInject(R.id.et_user_loginpwd)
	private EditText et_user_loginpwd;
	/** 是否自动登录 */
	@ViewInject(R.id.cb_auto_login)
	private CheckBox cb_auto_login;
	/** 第三方账号登录 */
	@ViewInject(R.id.tv_three_party_login)
	private TextView tv_three_party_login;
	/** 忘记密码 */
	@ViewInject(R.id.tv_forgot_pwd)
	private TextView tv_forgot_pwd;
	/** 注册按钮 */
	@ViewInject(R.id.btn_shop_register)
	private Button btn_shop_register;
	/** 登录按钮 */
	@ViewInject(R.id.btn_shop_login)
	private Button btn_shop_login;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		setContentView(R.layout.activity_user_login);
		super.onCreate(savedInstanceState);
		initDatas();
	}

	@OnClick({ R.id.tv_three_party_login, R.id.tv_forgot_pwd, R.id.btn_shop_register, R.id.btn_shop_login })
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.tv_three_party_login:
			processThreePartyLogin();
			break;
		case R.id.tv_forgot_pwd:
			processForgetPwd();
			break;
		case R.id.btn_shop_register:
			processRegister();
			break;
		case R.id.btn_shop_login:
			processLogin();
			break;
		default:
			break;
		}
	}

	private void initDatas() {
		getActionBarBase("用户登录");
	}

	/**
	 * @Description:处理第三方账号登陆
	 * @author: LiXiaoSong
	 * @date:2015-3-2
	 */
	private void processThreePartyLogin() {

	}

	/**
	 * @Description:处理忘记密码
	 * @author: LiXiaoSong
	 * @date:2015-3-2
	 */
	private void processForgetPwd() {

	}

	/**
	 * @Description:处理注册
	 * @author: LiXiaoSong
	 * @date:2015-3-2
	 */
	private void processRegister() {
		Intent intent = new Intent(this, UserRegisterActivity.class);
		startActivity(intent);
	}

	/**
	 * @Description:处理登录
	 * @author: LiXiaoSong
	 * @date:2015-3-2
	 */
	private void processLogin() {

	}
}
