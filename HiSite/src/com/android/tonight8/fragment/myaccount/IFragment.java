/**
 * 2015-1-12
 */
package com.android.tonight8.fragment.myaccount;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.android.tonight8.R;
import com.android.tonight8.base.BaseActivity;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;

/**
 * @Description:“我”页面底部内容的fragment
 * @author:LiXiaoSong
 * @copyright @HiSite
 * @Date:2015-1-12
 */
public class IFragment extends MyAccountBaseFragment {

	/** 根布局 */
	private View v_rootView;
	/** 中奖码 */
	@ViewInject(R.id.layout_award_code)
	private View layout_award_code;
	/** 优惠券 */
	@ViewInject(R.id.layout_my_coupon)
	private View layout_my_coupon;
	/** 参加过的抽奖活动 */
	@ViewInject(R.id.layout_lottery_activity)
	private View layout_lottery_activity;
	/** 我关注的商家 */
	@ViewInject(R.id.layout_business)
	private View layout_business;
	/** 收货地址 */
	@ViewInject(R.id.layout_address)
	private View layout_address;
	/** 投诉主办方 */
	@ViewInject(R.id.layout_sponsor)
	private View layout_sponsor;
	/** 设置 */
	@ViewInject(R.id.layout_setting)
	private View layout_setting;
	/** 客服热线 */
	@ViewInject(R.id.rl_phone)
	private RelativeLayout rl_phone;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		/* 主布局初始化 */
		if (v_rootView != null) {
			/* 已存在空的view */
			return v_rootView;
		}
		v_rootView = inflater.inflate(R.layout.fragment_i, container, false);
		ViewUtils.inject(this, v_rootView);
		initDatas();
		return v_rootView;
	}

	@Override
	public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
		((BaseActivity) getActivity()).getActionBarNormal("我", R.drawable.ic_launcher, null);
		super.onCreateOptionsMenu(menu, inflater);
	}

	public static IFragment newInstance() {
		IFragment fg = new IFragment();
		fg.setHasOptionsMenu(true);
		return fg;
	}

	private void initDatas() {
		setTextAndContent(layout_award_code, R.string.award_code, R.drawable.ic_launcher, "21", "");
		setTextAndContent(layout_my_coupon, R.string.my_coupon, R.drawable.ic_launcher, "23", "");
		setTextAndContent(layout_lottery_activity, R.string.lottery_activity, R.drawable.ic_launcher, "33", "");
		setTextAndContent(layout_business, R.string.business, R.drawable.ic_launcher, "15", "");
		setTextAndContent(layout_address, R.string.address, R.drawable.ic_launcher, "", "方庄桥南路边所");
		setTextAndContent(layout_sponsor, R.string.complain_sponsor, R.drawable.ic_launcher, "", "");
		setTextAndContent(layout_setting, R.string.setting, R.drawable.ic_launcher, "", "");
	}
}
