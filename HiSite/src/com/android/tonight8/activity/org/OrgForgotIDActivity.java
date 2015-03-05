package com.android.tonight8.activity.org;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.android.tonight8.R;
import com.android.tonight8.base.AppConstants;
import com.android.tonight8.base.BaseActivity;
import com.android.tonight8.io.HandlerConstants;
import com.android.tonight8.io.org.OrgIOController;
import com.android.tonight8.model.common.Org;
import com.android.tonight8.utils.CheckId;
import com.android.tonight8.utils.StringUtils;
import com.android.tonight8.utils.Utils;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnClick;

/**
 * @Description:商家忘记ID
 * @author:LiuZhao
 * @Date:2014年12月25日
 */
public class OrgForgotIDActivity extends BaseActivity {

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
	/** id */
	@ViewInject(R.id.ll_shop_id)
	private LinearLayout ll_shop_id;
	/** id */
	@ViewInject(R.id.et_shop_id)
	private EditText et_shop_id;
	/** 商家信息 */
	private Org org;
	public static Handler handler = new Handler() {

		@Override
		public void handleMessage(Message msg) {
			super.handleMessage(msg);

			switch (msg.arg1) {
			case HandlerConstants.RESULT_OK:

				break;
			case HandlerConstants.NETWORK_BEGIN:

				break;
			case HandlerConstants.NETWORK_END:

				break;
			case HandlerConstants.RESULT_FAIL:

				break;
			default:
				break;
			}
		}

	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		setContentView(R.layout.activity_org_forgotid);
		super.onCreate(savedInstanceState);
		getActionBarBase("忘记ID");

	}

	@OnClick(R.id.btn_findback)
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btn_findback:
			if (dealData() && org != null) {
				OrgIOController.OrgFrogotIdWrite(handler, org);
			}
			break;
		default:
			break;
		}

	}

	private boolean dealData() {
		String master_name = et_master_name.getText().toString();
		String identity = et_identity.getText().toString();
		String phonenumber = et_phonenumber.getText().toString();
		String email = et_email.getText().toString();
		if (!new CheckId(identity).validate()) {
			Utils.toast("请输入正确身份证号");
			return false;
		}
		if (!StringUtils.phoneOrMobile(phonenumber)) {
			Utils.toast("请输入正确电话号码");
			return false;
		}
		if (!StringUtils.matchRegular(email, AppConstants.strEMAIL)) {
			Utils.toast("请输入正确邮箱地址");
			return false;
		}
		org = new Org();
		org.name = master_name;
		org.paperCode = identity;
		org.telphone = phonenumber;
		org.email = email;
		return true;
	}
}
