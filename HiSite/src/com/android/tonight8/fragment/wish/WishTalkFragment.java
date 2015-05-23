package com.android.tonight8.fragment.wish;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.tonight8.R;
import com.android.tonight8.adapter.wish.WishTalkAdapter;
import com.android.tonight8.base.BaseFragment;
import com.android.tonight8.view.xlistview.XListView;

/**
 * @author lz 心愿讨论区
 * 
 */
public class WishTalkFragment extends BaseFragment {

	private XListView xlist;
	private WishTalkAdapter talkAdapter;
	private List<String> list;

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
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		rootView = inflater.inflate(R.layout.activity_only_list, container,
				false);
		xlist = (XListView) rootView.findViewById(R.id.lv_only_list);
		list = new ArrayList<String>();
		list.add("心愿1");
		list.add("心愿2");
		list.add("心愿3");
		talkAdapter = new WishTalkAdapter(getActivity(), list);
		xlist.setAdapter(talkAdapter);
		return rootView;

	}

}
