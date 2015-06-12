package com.android.tonight8.fragment.wish;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.tonight8.R;
import com.android.tonight8.adapter.wish.MyWishSponsorAdapter;
import com.android.tonight8.base.BaseFragment;
import com.android.tonight8.model.wish.MyWishSponsorListModel;
import com.android.tonight8.view.xlistview.XListView;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;

/**
 * @author 我的心愿：赞助的心愿
 * 
 */
public class MyWishSponsorFragment extends BaseFragment {
	private View rootView;
	private MyWishSponsorAdapter adapter;
	private List<MyWishSponsorListModel> list;
	@ViewInject(R.id.lv_only_list)
	private XListView lv_only_list;

	public static final MyWishPostFragment newInstance() {
		MyWishPostFragment myWishPostFragment = new MyWishPostFragment();
		return myWishPostFragment;

	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		super.onCreateView(inflater, container, savedInstanceState);
		rootView = inflater.inflate(R.layout.activity_only_list, container,
				false);
		ViewUtils.inject(this, rootView);
		initData();
		return rootView;
	}

	private void initData() {
		list = new ArrayList<MyWishSponsorListModel>();
		adapter = new MyWishSponsorAdapter(activity, list);
		lv_only_list.setAdapter(adapter);
	}
}
