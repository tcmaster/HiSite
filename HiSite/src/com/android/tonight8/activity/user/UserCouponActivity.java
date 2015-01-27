/**
 * 2015-1-27
 */
package com.android.tonight8.activity.user;

import android.os.Bundle;

import com.android.tonight8.R;
import com.android.tonight8.base.BaseActivity;

/**
 * @Description:用户优惠券包界面
 * @author:LiXiaoSong
 * @copyright @HiSite
 * @Date:2015-1-27
 */
public class UserCouponActivity extends BaseActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		setContentView(R.layout.activity_only_list);
		super.onCreate(savedInstanceState);
		initDatas();
	}

	private void initDatas() {

	}
}
