package com.android.tonight8.fragment.main;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.content.Intent;
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
import android.widget.AdapterView;

import com.android.tonight8.R;
import com.android.tonight8.activity.event.GoodsDetailActivity;
import com.android.tonight8.adapter.event.MainPageListViewAdapter;
import com.android.tonight8.adapter.event.MyPagerAdapter;
import com.android.tonight8.base.BaseActivity;
import com.android.tonight8.function.CirculateFunction;
import com.android.tonight8.io.common.CommonIOController;
import com.android.tonight8.view.PointLinearlayout;
import com.android.tonight8.view.XListView;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnItemClick;

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
	private ViewPager vp_show_img;
	/** 图片轮播底部的圆点父布局 */
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
		initHeader();
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

	@Override
	public void onStart() {
		if (cFunction != null)
			cFunction.resume();
		super.onResume();
	}

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
		CommonIOController.saveRegional();// 测试
	}

	/** 创建一个静态的实例 */
	public static final TonightEightFragment newInstance() {
		TonightEightFragment saFragment = new TonightEightFragment();
		saFragment.setHasOptionsMenu(true);
		return saFragment;
	}

	private void initActionBar() {
		bA.getActionBarSpeical("今晚8点", R.drawable.ic_launcher, false, true, null);
	}

	/**
	 * 
	 * @Description:初始化listView头部视图
	 * @see:
	 * @since:
	 * @author: LiXiaoSong
	 * @date:2015-1-9
	 */
	private void initHeader() {
		LayoutInflater inflater = (LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View view = inflater.inflate(R.layout.header_home_page, null, false);
		vp_show_img = (ViewPager) view.findViewById(R.id.vp_scan_img);
		ll_point_container = (PointLinearlayout) view.findViewById(R.id.ll_point_container);
		lv_item_container.addExtraHeaderView(view);
	}

	@OnItemClick(R.id.lv_show_detail)
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		Intent intent = new Intent(getActivity(), GoodsDetailActivity.class);
		startActivity(intent);
	}

}
