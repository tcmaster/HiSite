package com.android.tonight8.fragment.livemanage;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.android.tonight8.R;
import com.android.tonight8.base.BaseFragment;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;

public class PollFragment extends BaseFragment {
	/** 按钮 */
	@ViewInject(R.id.rg_live_manage)
	private RadioGroup rg_live_manage;
	private View rootView;

	public static final PollFragment newInstance() {
		PollFragment pollFragment = new PollFragment();
		return pollFragment;

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

		return rootView;

	}
}
