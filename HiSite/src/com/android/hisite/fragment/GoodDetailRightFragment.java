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
import android.widget.LinearLayout;

import com.android.hisite.R;
import com.android.hisite.adapter.GoodRightAdapter;
import com.android.view.ListViewForScrollView;

/**
 * @Description:奖品详情用户评论部分
 * @author:LiXiaoSong
 * @copyright @HiSite
 * @Date:2014-12-31
 */
public class GoodDetailRightFragment extends Fragment {

	/** 本界面的listView */
	ListViewForScrollView lv_container;

	/** 翻页视图 */
	LinearLayout ll_do_page;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_goods_detail, null);
		lv_container = (ListViewForScrollView) view.findViewById(R.id.lv_container);
		ll_do_page = (LinearLayout) view.findViewById(R.id.ll_do_page);
		ll_do_page.setVisibility(View.VISIBLE);
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
		lv_container.setAdapter(new GoodRightAdapter(getActivity(), data));
	}

	public static GoodDetailRightFragment newInstance() {
		return new GoodDetailRightFragment();
	}
}
