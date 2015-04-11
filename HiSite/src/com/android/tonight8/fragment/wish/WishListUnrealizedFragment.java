package com.android.tonight8.fragment.wish;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.tonight8.R;
import com.android.tonight8.adapter.wish.WishListAdapter;
import com.android.tonight8.base.BaseFragment;
import com.android.tonight8.view.xlistview.XListView;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;

/**
 * @author lz 愿望列表(未实现)
 */
public class WishListUnrealizedFragment extends BaseFragment {
	private WishListAdapter wishListAdapter;
	private List<String> list;
	@ViewInject(R.id.lv_wish)
	private XListView lv_wish;
	private View rootView;

	public static final WishListUnrealizedFragment newInstance() {
		WishListUnrealizedFragment wUnrealizedFragment = new WishListUnrealizedFragment();
		return wUnrealizedFragment;

	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		super.onCreateView(inflater, container, savedInstanceState);
		rootView = inflater.inflate(R.layout.activity_wish_list, container, false);
		ViewUtils.inject(this, rootView);
		list = new ArrayList<String>();
		list.add("123");
		list.add("123");
		list.add("123");
		list.add("123");
		list.add("123");
		list.add("123");
		wishListAdapter = new WishListAdapter(activity, list);
		lv_wish.setAdapter(wishListAdapter);
		return rootView;
	}

}
