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
 * @Description:奖品详情用户评论部分
 * @author:LiXiaoSong
 * @copyright @HiSite
 * @Date:2014-12-31
 */
public class GoodDetailRightFragment extends Fragment {

	/**
	 * 本界面的listView
	 */
	XListView lv_container;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_goods_detail, container);
		lv_container = (XListView) view.findViewById(R.id.lv_container);
		return view;
	}

	public static GoodDetailRightFragment newInstance() {
		return new GoodDetailRightFragment();
	}
}
