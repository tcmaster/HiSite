package com.android.tonight8.activity.createevent;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.android.tonight8.R;
import com.android.tonight8.base.BaseActivity;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnClick;
import com.lidroid.xutils.view.annotation.event.OnRadioGroupCheckedChange;

/**
 * @Description:认证页面
 * @author LiuZhao
 * @Date2014-12-29 下午11:01:31
 */
public class AuthenticationActivity extends BaseActivity {

	/** 认证类型 */
	@ViewInject(R.id.rg_auth_type)
	private RadioGroup rg_auth_type;
	/** 公司认证 */
	@ViewInject(R.id.rb_company)
	private RadioButton rb_company;
	/** 个人认证 */
	@ViewInject(R.id.rb_person)
	private RadioButton rb_person;
	/** 公司名称 */
	@ViewInject(R.id.et_auth_companyname)
	private EditText et_auth_companyname;
	/** 所在地区 */
	@ViewInject(R.id.et_auth_area1)
	private EditText et_auth_area1;
	/** 地址 */
	@ViewInject(R.id.et_auth_address)
	private EditText et_auth_address;
	/** 联系人 */
	@ViewInject(R.id.et_auth_person)
	private EditText et_auth_person;
	/** 联系人 */
	@ViewInject(R.id.ll_auth_person)
	private LinearLayout ll_auth_person;
	/** 手机号 */
	@ViewInject(R.id.et_auth_phone)
	private EditText et_auth_phone;
	/** 邮箱 */
	@ViewInject(R.id.et_auth_email)
	private EditText et_auth_email;
	/** 确定按钮下一步 */
	@ViewInject(R.id.btn_auth_ok)
	private Button btn_auth_ok;

	@OnRadioGroupCheckedChange(R.id.rg_auth_type)
	public void onCheckedChanged(RadioGroup arg0, int arg1) {

		/* 处理被单击的按钮 */
		RadioButton mRadioButton = (RadioButton) arg0.findViewById(arg1);
		int switchid = Integer.parseInt(mRadioButton.getTag().toString());

		switch (switchid) {
		// 公司认证
		case 0:
			ll_auth_person.setVisibility(View.VISIBLE);
			break;
		// 个人认证
		case 1:
			ll_auth_person.setVisibility(View.GONE);
			break;

		}
	}

	@OnClick(R.id.btn_auth_ok)
	public void onClick() {
		startActivityForAnima(new Intent(AuthenticationActivity.this, AuthSuccessActivity.class), null);
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		setContentView(R.layout.activity_authentication);
		super.onCreate(savedInstanceState);
		getActionBarBase("认证");

	}
}
