package com.android.tonight8.activity.user;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.tonight8.R;
import com.android.tonight8.base.BaseActivity;
import com.android.tonight8.utils.StringUtils;
import com.android.tonight8.utils.Utils;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnClick;

/**
 * @Description:用户注册
 * @author LiXiaoSong
 * @date 2015-1-17
 */
public class UserRegisterActivity extends BaseActivity {

	/** 用户注册手机号/邮箱 */
	@ViewInject(R.id.et_user_id)
	private EditText et_user_id;
	/** 用户注册时的密码 */
	@ViewInject(R.id.et_user_loginpwd)
	private EditText et_user_loginpwd;
	/** 用户注册时确认密码 */
	@ViewInject(R.id.et_user_loginpwd_retry)
	private EditText et_user_loginpwd_retry;
	/** 验证码 */
	@ViewInject(R.id.et_verify_code)
	private EditText et_verify_code;
	/** 获取验证码 */
	@ViewInject(R.id.btn_verify_code)
	private Button btn_verify_code;
	/** 提交注册信息 */
	@ViewInject(R.id.btn_ok)
	private Button btn_ok;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		setContentView(R.layout.activity_user_register);
		super.onCreate(savedInstanceState);
		initDatas();
	}

	@OnClick({ R.id.btn_verify_code, R.id.btn_ok })
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btn_verify_code:
			processVerifyCode();
			break;
		case R.id.btn_ok:
			processRegister();
			break;
		default:
			break;
		}
	}

	private void initDatas() {
		getActionBarBase("用户注册");
	}

	/**
	 * @Description:验证当前输入的内容
	 * @return 返回1，验证成功，当前是以邮箱注册 返回2，验证成功，当前是以手机号注册 返回3，验证失败，
	 * @author: LiXiaoSong
	 * @date:2015-3-2
	 */
	private int verifyInfo() {
		String userId = et_user_id.getText().toString();
		String psw = et_user_loginpwd.getText().toString();
		String psw_re = et_user_loginpwd_retry.getText().toString();
		boolean isEmail = false;
		if (StringUtils.isNullOrEmpty(userId)) {
			Utils.toast("用户名不能为空");
			return 3;
		}
		if (StringUtils.validateEmail(userId))// 字符串是否符合邮箱格式
			isEmail = true;
		else if (StringUtils.phoneOrMobile(userId))
			isEmail = false;
		else {
			Utils.toast("用户名不合法，请以手机号或邮箱为用户名");
			return 3;
		}
		if (StringUtils.isNullOrEmpty(psw)) {
			Utils.toast("密码不能为空");
			return 3;
		}
		if (!psw.equals(psw_re)) {
			Utils.toast("两次输入密码不一致");
			return 3;
		}
		if (isEmail)
			return 1;
		else
			return 2;
	}

	private void processVerifyCode() {
		int result = verifyInfo();
		if (result == 1)
			Utils.toast("获取邮箱验证码");
		else if (result == 2)
			Utils.toast("获取手机验证码");
		else
			return;
		// 点击获取验证码逻辑
		et_verify_code.setText("888888");
	}

	private void processRegister() {
		int result = verifyInfo();
		if (result == 3)
			return;
		if (StringUtils.isNullOrEmpty(et_verify_code.getText().toString())) {
			Utils.toast("验证码不能为空");
			return;
		}
		// 将注册信息提交到网络，进行注册逻辑
		Utils.toast("走注册的网络，让别人去说吧");
	}
}
