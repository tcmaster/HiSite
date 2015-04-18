package com.android.tonight8.fragment.wish;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.tonight8.R;
import com.android.tonight8.base.BaseFragment;
import com.android.tonight8.view.xlistview.XListView;

public class WishTalkFragment extends BaseFragment {
	private XListView xlist;

	public static final WishTalkFragment newInstance() {
		WishTalkFragment wishTalkFragment = new WishTalkFragment();
		return wishTalkFragment;
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
