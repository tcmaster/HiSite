package com.android.tonight8.fragment.wish;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.tonight8.R;
import com.android.tonight8.base.BaseFragment;

public class WishAboutMeFragment extends BaseFragment {
	public static final WishAboutMeFragment newInstance() {
		WishAboutMeFragment wishAboutMeFragment = new WishAboutMeFragment();
		return wishAboutMeFragment;
	}

	private View rootView;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

	}

	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		rootView = inflater.inflate(R.layout.fragment_wish_aboutme, container, false);
		return rootView;

	}
}
