/**
 * 2014-12-31
 */
package com.android.hisite.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.hisite.R;
import com.android.view.XListView;

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
	XListView lv_container;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_goods_detail, null, false);
		lv_container = (XListView) view.findViewById(R.id.lv_container);
		return view;
	}

	public static GoodDetailsLeftFragment newInstance() {
		return new GoodDetailsLeftFragment();
	}
}
