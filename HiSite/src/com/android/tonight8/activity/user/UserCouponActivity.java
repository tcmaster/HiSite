/**
 * 2015-1-27
 */
package com.android.tonight8.activity.user;

import android.os.Bundle;

import com.android.tonight8.R;
import com.android.tonight8.adapter.user.UserCouponListAdapter;
import com.android.tonight8.base.BaseActivity;
import com.android.tonight8.view.XListView;
import com.lidroid.xutils.view.annotation.ViewInject;

/**
 * @Description:用户优惠券包界面
 * @author:LiXiaoSong
 * @copyright @HiSite
 * @Date:2015-1-27
 */
public class UserCouponActivity extends BaseActivity {
	/** 用户优惠券列表 */
	@ViewInject(R.id.lv_only_list)
	private XListView lv_coupon_list;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		setContentView(R.layout.activity_only_list);
		super.onCreate(savedInstanceState);
		initDatas();
	}

	private void initDatas() {
		getActionBarBase("优惠券包");
		lv_coupon_list.setAdapter(new UserCouponListAdapter(this, null));
	}
}
