/**
 * 2014-12-31
 */
package com.android.hisite.fragment;

import java.util.ArrayList;
import java.util.List;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.hisite.R;
import com.android.hisite.adapter.GoodLeftAdapter;
import com.android.view.ListViewForScrollView;

/**
 * @Description:奖品详情商品介绍部分
 * @author:LiXiaoSong
 * @copyright @HiSite
 * @Date:2014-12-31
 */
public class GoodDetailsLeftFragment extends Fragment {

	/**
	 * 本界面的listView
	 */
	ListViewForScrollView lv_container;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_goods_detail, null);
		lv_container = (ListViewForScrollView) view.findViewById(R.id.lv_container);
		return view;
	}

	@Override
	public void onResume() {
		update();
		super.onResume();
	}

	private void update() {
		List<String> data = new ArrayList<String>();
		data.add("aaa");
		data.add("bbb");
		data.add("ccc");
		lv_container.setAdapter(new GoodLeftAdapter(getActivity(), data));
	}

	public static GoodDetailsLeftFragment newInstance() {
		return new GoodDetailsLeftFragment();
	}
}
