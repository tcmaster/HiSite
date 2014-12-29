package com.android.hisite.activity;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.android.hisite.AppConstants;
import com.android.hisite.BaseActivity;
import com.android.hisite.R;
import com.android.utils.CheckId;
import com.android.utils.StringUtils;
import com.android.utils.Utils;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnClick;

/**
 * @Description:忘记ID页或密码页面
 * @author:LiuZhao
 * @Date:2014年12月25日
 */
public class ForgetIDOrPwdActivity extends BaseActivity {

	/** 商家名或者个人名 */
	@ViewInject(R.id.et_master_name)
	private EditText et_master_name;
	/** 身份证 */
	@ViewInject(R.id.et_identity)
	private EditText et_identity;
	/** 手机号 */
	@ViewInject(R.id.et_phonenumber)
	private EditText et_phonenumber;
	/** 邮箱 */
	@ViewInject(R.id.et_email)
	private EditText et_email;
	/** 找回按钮 */
	@ViewInject(R.id.btn_findback)
	private Button btn_findback;
	/** 密码 */
	@ViewInject(R.id.ll_password)
	private LinearLayout ll_password;
	/** 密码 */
	@ViewInject(R.id.et_password)
	private EditText et_password;
	/** id */
	@ViewInject(R.id.ll_shop_id)
	private LinearLayout ll_shop_id;
	/** id */
	@ViewInject(R.id.et_shop_id)
	private EditText et_shop_id;
	/** 0:id 1:密码 */
	private int forgottype = 0;

	@OnClick(R.id.btn_findback)
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_forgotid_main);
		useCustomerActionBar();
		forgottype = getIntent().getIntExtra("forgottype", 0);
		if (forgottype == 0) {
			ll_password.setVisibility(View.GONE);
		} else {
			ll_shop_id.setVisibility(View.GONE);
		}

		btn_findback.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				dealData();
			}
		});
	}

	private void dealData() {
		String master_name = et_master_name.getText().toString();
		String identity = et_identity.getText().toString();
		String phonenumber = et_phonenumber.getText().toString();
		String email = et_email.getText().toString();
		if (!new CheckId(identity).validate()) {
			Utils.toast("请输入正确身份证号");
			return;
		}
		if (!StringUtils.phoneOrMobile(phonenumber)) {
			Utils.toast("请输入正确电话号码");
			return;
		}
		if (!StringUtils.matchRegular(email, AppConstants.strEMAIL)) {
			Utils.toast("请输入正确邮箱地址");
			return;
		}
	}
}
