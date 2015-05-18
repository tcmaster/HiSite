package com.android.tonight8.fragment.event;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.tonight8.R;
import com.android.tonight8.base.BaseFragment;
import com.android.tonight8.view.xlistview.XListView;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;

/**
 * @author lz 优惠券使用
 * 
 */
public class CouponUseFragment extends BaseFragment {

	private View rootView;
	@ViewInject(R.id.lv_coupon_haveused)
	private XListView lv_coupon_haveused;
	@ViewInject(R.id.tv_coupon_search)
	private TextView tv_coupon_search;

	public static final CouponUseFragment newInstance() {
		CouponUseFragment CouponUseFragment = new CouponUseFragment();
		return CouponUseFragment;

	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		rootView = inflater.inflate(R.layout.fragment_coupon_haveused,
				container, false);
		ViewUtils.inject(this, rootView);
		lv_coupon_haveused = (XListView) rootView
				.findViewById(R.id.lv_coupon_haveused);
		return rootView;

	}
}
