/**
 * 2015-1-27
 */
package com.android.tonight8.activity.user;

import android.os.Bundle;

import com.android.tonight8.R;
import com.android.tonight8.base.BaseActivity;

/**
 * @Description: 用户中奖码签收界面
 * @author:LiXiaoSong
 * @copyright @HiSite
 * @Date:2015-1-27
 */
public class UserAwardSignActivity extends BaseActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		setContentView(R.layout.activity_user_award_sign);
		super.onCreate(savedInstanceState);
		initDatas();
	}

	private void initDatas() {
		getActionBarBase("中奖码");
	}
}
