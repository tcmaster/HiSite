package com.android.tonight8.activity.createevent;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import com.android.tonight8.R;
import com.android.tonight8.base.BaseActivity;
import com.android.tonight8.utils.StringUtils;
import com.android.tonight8.utils.TimeCount;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnClick;

/**
 * @Description:商家注册
 * @author:LiuZhao
 * @Date:2014年12月25日
 */
public class OrgRegisterActivity extends BaseActivity {

	/** 注册的手机号 */
	@ViewInject(R.id.et_phone_register)
	private EditText et_phone_register;
	/** 注册的验证码 */
	@ViewInject(R.id.et_code_register)
	private EditText et_code_register;
	/** 设置的密码 */
	@ViewInject(R.id.et_setpwd)
	private EditText et_setpwd;
	/** 再次确认的密码 */
	@ViewInject(R.id.et_setpwd_again)
	private EditText et_setpwd_again;
	/** 获取验证码 */
	@ViewInject(R.id.btn_code_register)
	private Button btn_code_register;
	/** 注册按钮 */
	@ViewInject(R.id.btn_register_ok)
	private Button btn_register_ok;
	private TimeCount timeCount;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_shop_register);

	}

	@OnClick({ R.id.btn_register_ok, R.id.btn_code_register })
	public void onClick(View v) {
		String phoneString = null;
		switch (v.getId()) {
		case R.id.btn_register_ok:
			phoneString = et_phone_register.getText().toString();
			String codeString = et_code_register.getText().toString();
			String pwdString = et_setpwd.getText().toString();
			String pwdAgainString = et_setpwd_again.getText().toString();
			break;
		case R.id.btn_code_register:
			phoneString = et_phone_register.getText().toString();
			if (!StringUtils.phoneOrMobile(phoneString)) {
				timeCount = new TimeCount(60000, 1000, btn_code_register);// 构造CountDownTimer对象
				timeCount.start();
			}
			break;
		default:
			break;
		}

	}
}
