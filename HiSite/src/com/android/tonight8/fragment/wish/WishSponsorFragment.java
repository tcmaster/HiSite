package com.android.tonight8.fragment.wish;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.tonight8.R;
import com.android.tonight8.adapter.wish.WishSponsorAdapter;
import com.android.tonight8.base.BaseFragment;
import com.android.tonight8.view.xlistview.XListView;

public class WishSponsorFragment extends BaseFragment {
	private XListView xlist;
	private WishSponsorAdapter wishSponsorAdapter;
	private List<String> list;

	public static final WishSponsorFragment newInstance() {
		WishSponsorFragment wishSponsorFragment = new WishSponsorFragment();
		return wishSponsorFragment;
	}

	private View rootView;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		rootView = inflater.inflate(R.layout.fragment_wish_sponsor, container, false);
		list = new ArrayList<String>();
		list.add("1");
		list.add("2");
		list.add("3");
		list.add("4");
		list.add("5");
		list.add("6");
		list.add("6");
		list.add("6");
		list.add("6");
		list.add("6");
		xlist = (XListView) rootView.findViewById(R.id.lv_wishsupportlist);
		wishSponsorAdapter = new WishSponsorAdapter(getActivity(), list);
		xlist.setAdapter(wishSponsorAdapter);
		return rootView;

	}

}
 