package com.android.tonight8.activity.createevent;

import android.os.Bundle;

import com.android.tonight8.R;
import com.android.tonight8.base.BaseActivity;

/**
 * @Description:促销券使用
 * @author LiuZhao
 * @Date2014-12-29 下午11:30:50
 */
public class CouponToUseActivity extends BaseActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		setContentView(R.layout.activity_coupon_touse);
		super.onCreate(savedInstanceState);
		getActionBarBase("促销券使用");
	}

}
