package com.android.tonight8.activity.user;

import android.os.Bundle;

import com.android.tonight8.R;
import com.android.tonight8.adapter.user.UserCouponExchangeAdapter;
import com.android.tonight8.base.BaseActivity;
import com.android.tonight8.view.xlistview.XListView;
import com.lidroid.xutils.view.annotation.ViewInject;

/**
 * @Description:用户优惠券兑换地点
 * @author:LiXiaoSong
 * @copyright @HiSite
 * @Date:2015-1-28
 */
public class UserCouponExchangeActivity extends BaseActivity {

	@ViewInject(R.id.lv_only_list)
	private XListView lv_coupon_exchange;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		setContentView(R.layout.activity_only_list);
		super.onCreate(savedInstanceState);
		initDatas();
	}

	private void initDatas() {
		lv_coupon_exchange.setAdapter(new UserCouponExchangeAdapter(this, null));
	}
}
