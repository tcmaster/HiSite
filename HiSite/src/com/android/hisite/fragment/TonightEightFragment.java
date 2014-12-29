package com.android.hisite.fragment;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.hisite.BaseActivity;
import com.android.hisite.R;
import com.android.hisite.adapter.MainPageListViewAdapter;
import com.android.hisite.adapter.MyPagerAdapter;
import com.android.hisite.function.CirculateFunction;
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
	// ***************************其他成员***********************************//
	/** 测试数据 */
	private List<String> data;
	/** 本界面的activity */
	private BaseActivity bA;
	/** vp轮播功能 */
	private CirculateFunction cFunction;

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
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		this.bA = (BaseActivity) getActivity();
	}

	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
		initData();
	}

	@Override
	public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
		initActionBar();
		super.onCreateOptionsMenu(menu, inflater);
	}

	@Override
	public void onDestroy() {
		if (cFunction != null)
			cFunction.stop();// 结束轮播
		super.onDestroy();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.support.v4.app.Fragment#onResume()
	 */
	@Override
	public void onStart() {
		if (cFunction != null)
			cFunction.resume();
		super.onResume();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.support.v4.app.Fragment#onStop()
	 */
	@Override
	public void onStop() {
		if (cFunction != null)
			cFunction.pause();
		super.onStop();
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
		cFunction = new CirculateFunction(vp_show_img.getAdapter().getCount(), 5, new Handler() {

			@Override
			public void handleMessage(Message msg) {
				vp_show_img.setCurrentItem(msg.what);
				super.handleMessage(msg);
			}
		});
		cFunction.start();// 开始轮播
		lv_item_container.setAdapter(new MainPageListViewAdapter(getActivity(), data));
	}

	/** 创建一个静态的实例 */
	public static final TonightEightFragment newInstance() {
		TonightEightFragment saFragment = new TonightEightFragment();
		saFragment.setHasOptionsMenu(true);
		return saFragment;
	}

	private void initActionBar() {
		bA.useCustomerActionBar();
		bA.getLeftText().setVisibility(View.INVISIBLE);
		bA.getArrow().setVisibility(View.INVISIBLE);
		bA.getLogo().setVisibility(View.INVISIBLE);
		bA.getActionTitle().setText("今晚8点");
		bA.getTitleRight().setText("北京");
		bA.getRightText().setVisibility(View.GONE);
	}

}
