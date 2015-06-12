package com.android.tonight8.fragment.wish;

import java.util.List;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.tonight8.R;
import com.android.tonight8.adapter.wish.MyWishListAdapter;
import com.android.tonight8.base.BaseFragment;
import com.android.tonight8.model.wish.MyWishListModel;
import com.lidroid.xutils.ViewUtils;

/**
 * @author lz我的心愿：发布的心愿
 * 
 */
public class MyWishPostFragment extends BaseFragment {
	private View rootView;
	private MyWishListAdapter adapter;
	private List<MyWishListModel> list;


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
		adapter = new MyWishListAdapter(activity, list);
	}
}
