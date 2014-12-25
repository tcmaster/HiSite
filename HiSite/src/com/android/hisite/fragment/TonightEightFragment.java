package com.android.hisite.fragment;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.hisite.R;
import com.android.hisite.adapter.MainPageListViewAdapter;
import com.android.hisite.adapter.MyPagerAdapter;
import com.android.view.PointLinearlayout;
import com.android.view.XListView;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;

/**
 * @Description:今晚8点
 * @author:LiXiaoSong
 * @Date:2014年12月15日
 */
public class TonightEightFragment extends Fragment {

	// ***************************控件成员***********************************//
	/** 根布局 */
	private View rootView;
	/** 图片轮播 */
	@ViewInject(R.id.vp_scan_img)
	private ViewPager vp_show_img;
	/** 图片轮播底部的圆点父布局 */
	@ViewInject(R.id.ll_point_container)
	private PointLinearlayout ll_point_container;
	/** 内容列表 */
	@ViewInject(R.id.lv_show_detail)
	private XListView lv_item_container;
	// ***************************变量成员***********************************//
	/** 测试数据 */
	private List<String> data;

	// ***************************生命周期***********************************//
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		/* 主布局初始化 */
		if (rootView != null) {
			/* 已存在空的view */
			return rootView;
		}
		rootView = inflater.inflate(R.layout.fragment_tonight_eight, container, false);
		ViewUtils.inject(this, rootView);
		return rootView;
	}

	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
		initData();
	}

	// ***************************子方法***********************************//
	private void initData() {
		data = new ArrayList<String>();
		data.add("http://g.hiphotos.baidu.com/image/pic/item/622762d0f703918fce56b5d6523d269759eec423.jpg");
		data.add("http://f.hiphotos.baidu.com/image/pic/item/8cb1cb1349540923c841dc779058d109b3de498a.jpg");
		data.add("http://c.hiphotos.baidu.com/image/w%3D230/sign=68825dc2e2fe9925cb0c6e5304a95ee4/9e3df8dcd100baa19fba02bc4510b912c8fc2e26.jpg");
		data.add("http://f.hiphotos.baidu.com/image/pic/item/cdbf6c81800a19d8697b640331fa828ba61e46b8.jpg");
		ll_point_container.setPointCount(4);
		ll_point_container.changePoint(0);
		vp_show_img.setAdapter(new MyPagerAdapter(getActivity(), data));
		vp_show_img.setCurrentItem(0);
		vp_show_img.setOnPageChangeListener(new OnPageChangeListener() {

			@Override
			public void onPageSelected(int arg0) {
				ll_point_container.changePoint(arg0);
			}

			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
			}

			@Override
			public void onPageScrollStateChanged(int arg0) {
			}
		});
		lv_item_container.setAdapter(new MainPageListViewAdapter(getActivity(), data));
	}

	/** 创建一个静态的实例 */
	public static final TonightEightFragment newInstance() {
		TonightEightFragment saFragment = new TonightEightFragment();
		return saFragment;
	}

}
