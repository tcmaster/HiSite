package com.android.tonight8.activity.createevent;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;

import com.android.tonight8.R;
import com.android.tonight8.base.BaseActivity;
import com.lidroid.xutils.view.annotation.ViewInject;

/**
 * @Description:认证页面
 * @author LiuZhao
 * @Date2014-12-29 下午11:01:31
 */
public class AuthenticationActivity extends BaseActivity {

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
	@ViewInject(R.id.et_auth_area)
	private EditText et_auth_area;
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
	/**  */
	@ViewInject(R.id.btn_auth_ok)
	private Button btn_auth_ok;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		setContentView(R.layout.activity_authentication);
		super.onCreate(savedInstanceState);
		getActionBarBase("认证");
	}
}
