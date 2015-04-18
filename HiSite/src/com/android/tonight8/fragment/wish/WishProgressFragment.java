package com.android.tonight8.fragment.wish;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.tonight8.R;
import com.android.tonight8.base.BaseFragment;

public class WishProgressFragment extends BaseFragment {
	public static final WishProgressFragment newInstance() {
		WishProgressFragment wishProgressFragment = new WishProgressFragment();
		return wishProgressFragment;
	}

	private View rootView;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		rootView = inflater.inflate(R.layout.fragment_wish_talk, container, false);
		return rootView;

	}
}
