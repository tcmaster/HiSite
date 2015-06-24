package com.android.tonight8.fragment.goodsinfo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.tonight8.R;
import com.android.tonight8.base.BaseFragment;
import com.lidroid.xutils.ViewUtils;

public class GoodsPraiseFragment extends BaseFragment {
	/** 父View */
	private View view;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		if (view == null) {
			view = inflater.inflate(R.layout.activity_only_list_for_scroll,
					null);
			ViewUtils.inject(this, view);
		}
		return view;
	}

	public static GoodsPraiseFragment newInstance() {
		return new GoodsPraiseFragment();
	}
}
