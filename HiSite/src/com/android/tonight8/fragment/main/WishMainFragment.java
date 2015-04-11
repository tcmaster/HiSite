package com.android.tonight8.fragment.main;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;

import com.android.tonight8.R;
import com.android.tonight8.base.BaseFragment;
import com.android.tonight8.fragment.wish.WishListUnrealizedFragment;
import com.android.tonight8.fragment.wish.WishRealizedFragment;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;

/**
 * @author lz 心愿列表主页
 * 
 */
public class WishMainFragment extends BaseFragment implements OnCheckedChangeListener {
	private WishListUnrealizedFragment wishListUnrealizedFragment;
	private WishRealizedFragment wishRealizedFragment;
	/** 按钮 */
	@ViewInject(R.id.rg_wishmain)
	private RadioGroup rg_wishmain;
	/** 未实现按钮 */
	@ViewInject(R.id.rb_unrealized)
	private RadioButton rb_unrealized;
	/** 已实现按钮 */
	@ViewInject(R.id.rb_realized)
	private RadioButton rb_realized;
	private FragmentManager fm;
	private FragmentTransaction ft;
	private BaseFragment[] fragments;
	private View rootView;

	public static final WishMainFragment newInstance() {
		WishMainFragment wFragment = new WishMainFragment();
		return wFragment;
	}

	public void onCheckedChanged(RadioGroup arg0, int arg1) {
		/* 处理被单击的按钮 */
		RadioButton mRadioButton = (RadioButton) arg0.findViewById(arg1);
		int switchid = Integer.parseInt(mRadioButton.getTag().toString());
		doFragmentShow(switchid);

	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		super.onCreateView(inflater, container, savedInstanceState);
		rootView = inflater.inflate(R.layout.fragment_wish_main, container, false);
		ViewUtils.inject(this, rootView);
		initData();
		return rootView;
	}

	private void initData() {
		fm = getChildFragmentManager();
		ft = fm.beginTransaction();
		fragments = new BaseFragment[2];
		wishListUnrealizedFragment = WishListUnrealizedFragment.newInstance();
		wishRealizedFragment = WishRealizedFragment.newInstance();
		fragments[0] = wishListUnrealizedFragment;
		fragments[1] = wishRealizedFragment;
		ft.add(R.id.ll_wish_container, wishListUnrealizedFragment);
		ft.add(R.id.ll_wish_container, wishRealizedFragment);
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
