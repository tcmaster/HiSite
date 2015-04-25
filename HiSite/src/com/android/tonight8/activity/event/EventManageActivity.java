package com.android.tonight8.activity.event;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.android.tonight8.R;
import com.android.tonight8.base.BaseActivity;
import com.android.tonight8.base.BaseFragment;
import com.android.tonight8.fragment.event.CouponSettingsFragment;
import com.android.tonight8.fragment.event.CouponUseFragment;
import com.android.tonight8.fragment.event.LiveSettingsFragment;
import com.android.tonight8.fragment.event.OrdersSendFragment;
import com.lidroid.xutils.view.annotation.ViewInject;

/**
 * @author lz 活动管理
 * 
 */
public class EventManageActivity extends BaseActivity {
	/** 赠券设置 */
	private CouponSettingsFragment couponSettingsFragment;
	/** 赠券使用 */
	private CouponUseFragment couponUseFragment;
	/** 现场设置 */
	private LiveSettingsFragment liveSettingsFragment;
	/** 订单寄送 */
	private OrdersSendFragment ordersSendFragment;
	/** 按钮 */
	@ViewInject(R.id.rg_evnetmanage)
	private RadioGroup rg_wishmain;
	private FragmentManager fm;
	private FragmentTransaction ft;
	private BaseFragment[] fragments;
	private View rootView;

	public void onCheckedChanged(RadioGroup arg0, int arg1) {
		/* 处理被单击的按钮 */
		RadioButton mRadioButton = (RadioButton) arg0.findViewById(arg1);
		int switchid = Integer.parseInt(mRadioButton.getTag().toString());
		doFragmentShow(switchid);

	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		setContentView(R.layout.activity_event_manage);
		super.onCreate(savedInstanceState);
		initData();
	}

	private void initData() {
		fm = getSupportFragmentManager();
		ft = fm.beginTransaction();
		fragments = new BaseFragment[7];
		fragments[0] = CouponSettingsFragment.newInstance();
		fragments[1] = CouponUseFragment.newInstance();
		fragments[2] = LiveSettingsFragment.newInstance();
		fragments[3] = OrdersSendFragment.newInstance();
		ft.add(R.id.ll_wish_container, fragments[0]);
		ft.add(R.id.ll_wish_container, fragments[1]);
		ft.add(R.id.ll_wish_container, fragments[2]);
		ft.add(R.id.ll_wish_container, fragments[3]);
		ft.add(R.id.ll_wish_container, fragments[4]);
		ft.add(R.id.ll_wish_container, fragments[5]);
		ft.add(R.id.ll_wish_container, fragments[7]);
		ft.commit();
	}

	/**
	 * @Description:显示当前的fragment对象
	 * @param which
	 *            第几个对象
	 * @author: LiXiaoSong
	 * @date:2015-2-6
	 */
	public void doFragmentShow(int which) {
		ft = fm.beginTransaction();
		for (int i = 0; i < fragments.length; i++) {
			if (which == i) {
				ft.show(fragments[i]);
			} else
				ft.hide(fragments[i]);
		}
		ft.commit();
	}
}
