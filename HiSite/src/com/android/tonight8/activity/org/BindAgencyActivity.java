package com.android.tonight8.activity.org;

import android.os.Bundle;

import com.android.tonight8.R;
import com.android.tonight8.base.BaseActivity;

/**
 * @Description:绑定经销商
 * @author:LiuZhao
 * @Date:2015年1月29日
 */
public class BindAgencyActivity extends BaseActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		setContentView(R.layout.activity_bingding_agency);
		super.onCreate(savedInstanceState);
		getActionBarBase("经销商绑定");
	}

}
