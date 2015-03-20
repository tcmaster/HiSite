package com.android.tonight8.activity.createevent;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import com.android.tonight8.R;
import com.android.tonight8.base.BaseActivity;
import com.android.tonight8.view.WebViewForScrollView;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnClick;
import com.lidroid.xutils.view.annotation.event.OnCompoundButtonCheckedChange;

/**
 * @Description：活动协议页面
 * @date 2015-2-10下午10:06:18
 * @author liuzhao
 */
public class UserAgreementActivity extends BaseActivity {

	/** 协议网页 */
	@ViewInject(R.id.wv_user_agreement)
	private WebViewForScrollView wv_user_agreement;
	/** 选中同意 */
	@ViewInject(R.id.cb_agree)
	private CheckBox cb_agree;
	/** 同意 */
	@ViewInject(R.id.btn_user_agreement)
	private Button btn_user_agreement;
	/** url地址 */
	private String agreementUrl = "http://www.baidu.com";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		setContentView(R.layout.activity_user_agreement);
		getActionBarBase("活动协议");
		super.onCreate(savedInstanceState);
		initData();
	}

	private void initData() {
		WebSettings webSettings = wv_user_agreement.getSettings();
		// 设置WebView属性，能够执行Javascript脚本
		webSettings.setJavaScriptEnabled(true);
		// 设置可以访问文件
		webSettings.setAllowFileAccess(true);
		// 设置支持缩放
		webSettings.setBuiltInZoomControls(true);

		// 设置Web视图
		wv_user_agreement.setWebViewClient(new webViewClient());
		// 加载需要显示的网页
		wv_user_agreement.loadUrl(agreementUrl);
	}

	// Web视图
	private class webViewClient extends WebViewClient {
		@Override
		public boolean shouldOverrideUrlLoading(WebView view, String url) {
			view.loadUrl(url);
			return true;
		}
	}

	@OnClick(R.id.btn_user_agreement)
	public void onClick(View arg0) {
		if (!cb_agree.isChecked()) {
			return;
		}
		startActivityForAnima(new Intent(UserAgreementActivity.this,
				CreatEventFirstActivity.class), null);

	}

	@OnCompoundButtonCheckedChange(R.id.cb_agree)
	public void onCheckedChanged(CompoundButton arg0, boolean arg1) {

	}

}
