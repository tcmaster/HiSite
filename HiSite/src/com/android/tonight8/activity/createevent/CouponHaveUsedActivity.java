package com.android.tonight8.activity.createevent;

import android.os.Bundle;

import com.android.tonight8.R;
import com.android.tonight8.base.BaseActivity;

/**
 * @Description:已用券核销
 * @author LiuZhao
 * @Date2014-12-29 下午11:34:57
 */
public class CouponHaveUsedActivity extends BaseActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		setContentView(R.layout.activity_coupon_haveused);
		super.onCreate(savedInstanceState);
		getActionBarBase("已用券核销");
	}
}
