package com.android.tonight8.activity.createevent;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import com.android.tonight8.R;
import com.android.tonight8.base.BaseActivity;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnClick;
import com.lidroid.xutils.view.annotation.event.OnCompoundButtonCheckedChange;

/**
 * @Description：用户协议页面
 * @date 2015-2-10下午10:06:18
 * @author liuzhao
 */
public class UserAgreementActivity extends BaseActivity {

	/** 协议网页 */
	@ViewInject(R.id.wv_user_agreement)
	private WebView wv_user_agreement;
	/** 选中同意 */
	@ViewInject(R.id.cb_agree)
	private CheckBox cb_agree;
	/** 同意 */
	@ViewInject(R.id.btn_user_agreement)
	private Button btn_user_agreement;
	/** url地址 */
	private String agreementUrl="http://www.baidu.com";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		setContentView(R.layout.activity_user_agreement);
		super.onCreate(savedInstanceState);
		initData();
	}

	private void initData() {
		wv_user_agreement.loadUrl(agreementUrl);
	}

	@OnClick(R.id.btn_user_agreement)
	public void onClick(View arg0) {
		if (!cb_agree.isChecked()) {
			return;
		}
		startActivityForAnima(new Intent(UserAgreementActivity.this,CreatEventFirstActivity.class), null);

	}

	@OnCompoundButtonCheckedChange(R.id.cb_agree)
	public void onCheckedChanged(CompoundButton arg0, boolean arg1) {

	}

}
