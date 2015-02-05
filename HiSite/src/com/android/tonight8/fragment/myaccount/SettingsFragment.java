package com.android.tonight8.fragment.myaccount;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.android.tonight8.R;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;

public class SettingsFragment extends MyAccountBaseFragment{
	/** 根布局 */
	private View v_rootView;
	/**账号授权*/
	@ViewInject(R.id.layout_account_authorization)
	private View layout_account_authorization;
	/**意见反馈*/
	@ViewInject(R.id.layout_feed_back)
	private View layout_feed_back;
	/**清理缓存*/
	@ViewInject(R.id.layout_clear_cache)
	private View layout_clear_cache;
	/**版本更新*/
	@ViewInject(R.id.layout_version_update)
	private View layout_version_update;
	/**隐私说明*/
	@ViewInject(R.id.layout_private_policy)
	private View layout_private_policy;
	/**许可协议*/
	@ViewInject(R.id.layout_license)
	private View layout_license;
	/**打分鼓励*/
	@ViewInject(R.id.layout_rate_encourage)
	private View layout_rate_encourage;
	/**关于今晚8点*/
	@ViewInject(R.id.layout_about)
	private View layout_about;
	/**许可协议*/
	@ViewInject(R.id.btn_exit_login)
	private Button btn_exit_login;
	
	@Override
	public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState) {
		/* 主布局初始化 */
		if (v_rootView != null) {
			/* 已存在空的view */
			return v_rootView;
		}
		v_rootView = inflater.inflate(R.layout.fragment_settings, container, false);
		ViewUtils.inject(this, v_rootView);
		initDatas();
		return v_rootView;
	}
	private void initDatas(){
	}
}
