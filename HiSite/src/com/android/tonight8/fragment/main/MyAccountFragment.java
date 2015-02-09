package com.android.tonight8.fragment.main;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.tonight8.R;
import com.android.tonight8.fragment.myaccount.IFragment;
import com.android.tonight8.fragment.myaccount.PersonInfoFragment;
import com.android.tonight8.fragment.myaccount.SettingsFragment;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnClick;

/**
 * @Description:我的账户
 * @author:LiXiaoSong
 * @Date:2014年12月15日
 */
public class MyAccountFragment extends Fragment {

	// *********************视图成员****************************//
	/** 根布局 */
	private View v_rootView;
	/** 用户头像 */
	@ViewInject(R.id.iv_photo)
	private ImageView iv_photo;
	/** 用户昵称 */
	@ViewInject(R.id.tv_name)
	private TextView tv_name;
	/** 用户位置 */
	@ViewInject(R.id.tv_location)
	private TextView tv_location;
	/** 右边箭头 */
	@ViewInject(R.id.iv_arrow)
	private ImageView iv_arrow;
	/** fragment容器 */
	@ViewInject(R.id.ll_fg_container)
	private LinearLayout ll_fg_container;
	// *********************其他成员****************************//
	/**
	 * 附加资料fragment
	 */
	private IFragment iFragment;
	/**
	 * 个人资料的fragment
	 */
	private PersonInfoFragment piFragment;
	/**
	 * 设置的fragment
	 */
	private SettingsFragment sFragment;

	/**
	 * 用来判断当前是哪个界面，false为附加资料，true为个人资料
	 */
	private boolean which = false;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		/* 主布局初始化 */
		if (v_rootView != null) {
			/* 已存在空的view */
			return v_rootView;
		}
		v_rootView = inflater.inflate(R.layout.fragment_myaccount, container, false);
		ViewUtils.inject(this, v_rootView);
		initDatas();
		return v_rootView;
	}

	@OnClick(R.id.iv_arrow)
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.iv_arrow:
			FragmentManager fm = getChildFragmentManager();
			FragmentTransaction ft = fm.beginTransaction();
			if (which) {
				ft.show(iFragment);
				ft.hide(piFragment);
				ft.hide(sFragment);
			} else {
				ft.show(piFragment);
				ft.hide(iFragment);
				ft.hide(sFragment);
			}
			which = !which;
			ft.commit();
			break;

		default:
			break;
		}
	}

	private void initDatas() {
		iFragment = IFragment.newInstance();
		piFragment = PersonInfoFragment.newInstance();
		sFragment = SettingsFragment.newInstance();
		FragmentManager fm = getChildFragmentManager();
		FragmentTransaction ft = fm.beginTransaction();
		ft.add(R.id.ll_fg_container, iFragment);
		ft.add(R.id.ll_fg_container, piFragment);
		ft.add(R.id.ll_fg_container, sFragment);
		ft.show(iFragment);
		ft.hide(piFragment);
		ft.hide(sFragment);
		ft.commit();
	}

	/** 创建一个静态的实例 */
	public static final MyAccountFragment newInstance() {
		MyAccountFragment saFragment = new MyAccountFragment();
		return saFragment;
	}

	/** 显示设置的fragment */
	public void showSettingFragment() {
		FragmentManager fm = getChildFragmentManager();
		FragmentTransaction ft = fm.beginTransaction();
		ft.show(sFragment);
		ft.hide(piFragment);
		ft.hide(iFragment);
		ft.commit();
		which = true;
	}

}
