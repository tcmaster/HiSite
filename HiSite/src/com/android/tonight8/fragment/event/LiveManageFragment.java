package com.android.tonight8.fragment.event;

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
import com.android.tonight8.fragment.livemanage.BindingTwoFragment;
import com.android.tonight8.fragment.livemanage.PollFragment;
import com.android.tonight8.fragment.main.MyAccountFragment;
import com.android.tonight8.fragment.main.TonightEightFragment;
import com.android.tonight8.fragment.main.WishMainFragment;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;

/**
 * @author lz 直播管理
 * 
 */
public class LiveManageFragment extends BaseFragment implements
		OnCheckedChangeListener {
	private View rootView;

	/** 按钮 */
	@ViewInject(R.id.rg_live_manage)
	private RadioGroup rg_live_manage;
	private BaseFragment[] fragments;
	private FragmentManager fragmentManager;
	private FragmentTransaction fragmentTransaction;

	public static final LiveManageFragment newInstance() {
		LiveManageFragment liveManageFragment = new LiveManageFragment();
		return liveManageFragment;

	}

	public void onCheckedChanged(RadioGroup arg0, int arg1) {
		/* 处理被单击的按钮 */
		RadioButton mRadioButton = (RadioButton) arg0.findViewById(arg1);
		int switchid = Integer.parseInt(mRadioButton.getTag().toString());

	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		rootView = inflater.inflate(R.layout.fragment_live_manage, container,
				false);
		ViewUtils.inject(this, rootView);
		initData();
		return rootView;

	}

	private void initData() {
		fragments = new BaseFragment[3];
		fragments[0] = BindingTwoFragment.newInstance();
		fragments[1] = PollFragment.newInstance();
		fragments[2] = WishMainFragment.newInstance();
		/* 设置跳转那个fragment页面 */
		fragmentManager = getChildFragmentManager();
		fragmentTransaction = fragmentManager.beginTransaction();
		fragmentTransaction.add(R.id.tabcontent, fragments[0]);
		fragmentTransaction.add(R.id.tabcontent, fragments[1]);
		fragmentTransaction.add(R.id.left_content, fragments[2]);
		fragmentTransaction.commit();
		/* fragment管理器初始化 */
		/* 实始化下方单选按钮组 */
		rg_live_manage.setOnCheckedChangeListener(this);
	}
}
