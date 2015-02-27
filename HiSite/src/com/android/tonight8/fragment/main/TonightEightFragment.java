package com.android.tonight8.fragment.main;

import java.util.ArrayList;
import java.util.List;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ProgressBar;

import com.android.tonight8.R;
import com.android.tonight8.activity.event.GoodsDetailActivity;
import com.android.tonight8.adapter.event.MainPageListViewAdapter;
import com.android.tonight8.adapter.event.MyPagerAdapter;
import com.android.tonight8.base.BaseActivity;
import com.android.tonight8.base.BaseFragment;
import com.android.tonight8.function.CirculateFunction;
import com.android.tonight8.io.HandlerConstants;
import com.android.tonight8.io.event.EventIOController;
import com.android.tonight8.model.event.EventListModel;
import com.android.tonight8.view.PointLinearlayout;
import com.android.tonight8.view.XListView;
import com.android.tonight8.view.XListView.IXListViewListener;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnItemClick;

/**
 * @Description:今晚8点
 * @author:LiXiaoSong
 * @Date:2014年12月15日
 */
public class TonightEightFragment extends BaseFragment {

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
	/** 列表loading圈 */
	@ViewInject(R.id.pb_loading)
	private ProgressBar pb_loading;
	// ***************************其他成员***********************************//
	/** 测试数据 */
	private List<String> data;
	/** 本界面的activity */
	private BaseActivity bA;
	/** vp轮播功能 */
	private CirculateFunction cFunction;
	/** 本界面列表页的数据源 */
	private MainPageListViewAdapter adapter;
	/** 本界面的数据更新handler */
	@SuppressLint("HandlerLeak")
	private Handler handler = new Handler() {

		@SuppressWarnings("unchecked")
		@Override
		public void handleMessage(Message msg) {
			switch (msg.what) {
			case HandlerConstants.Event.MAINPAGE_LIST:
				if (msg.arg1 == HandlerConstants.RESULT_OK) {// 网络数据获取成功
					if (msg.arg2 == INIT) {
						pb_loading.setVisibility(View.INVISIBLE);
						lv_item_container.setVisibility(View.VISIBLE);
						List<EventListModel> data = (List<EventListModel>) msg.obj;
						if (data == null || data.size() < ITEM_COUNT)
							lv_item_container.setPullLoadEnable(false);
						else
							lv_item_container.setPullLoadEnable(true);
						adapter = new MainPageListViewAdapter(getActivity(), data);
						lv_item_container.setAdapter(adapter);
					} else if (msg.arg2 == REFRESH) {
						List<EventListModel> data = (List<EventListModel>) msg.obj;
						if (data == null || data.size() < ITEM_COUNT)
							lv_item_container.setPullLoadEnable(false);
						adapter.initData(data);
						lv_item_container.stopRefresh();
					} else if (msg.arg2 == LOAD_MORE) {
						List<EventListModel> data = (List<EventListModel>) msg.obj;
						if (data == null || data.size() < ITEM_COUNT)
							lv_item_container.setPullLoadEnable(false);
						adapter.addData((List<EventListModel>) msg.obj);
						lv_item_container.stopLoadMore();
					}

				} else if (msg.arg1 == HandlerConstants.NETWORK_BEGIN) {// 网络数据开始
					if (msg.arg2 == INIT) {
						pb_loading.setVisibility(View.VISIBLE);
						lv_item_container.setVisibility(View.INVISIBLE);
					}
				} else if (msg.arg1 == HandlerConstants.RESULT_FAIL) {// 出错处理
					if (msg.arg2 == INIT) {
						pb_loading.setVisibility(View.INVISIBLE);
						lv_item_container.setVisibility(View.INVISIBLE);
					} else if (msg.arg2 == REFRESH) {
						lv_item_container.stopRefresh();
					} else if (msg.arg2 == LOAD_MORE) {
						lv_item_container.stopLoadMore();
					}
				} else if (msg.arg1 == HandlerConstants.NETWORK_END) {// 网络数据获取完毕

				}
				break;

			default:
				break;
			}
		};
	};
	/** 当前展示的页数 */
	private int current = 0;
	/** 每页显示的条数 */
	private final int ITEM_COUNT = 3;
	/** 下拉刷新标识 */
	private final int REFRESH = 1;
	/** 上拉加载标识 */
	private final int LOAD_MORE = 2;
	/** 首次加载标识 */
	private final int INIT = 3;

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
		current = 0;
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
		EventIOController.eventsRead(handler, INIT, ITEM_COUNT, current * ITEM_COUNT);
		lv_item_container.setXListViewListener(new IXListViewListener() {// 设置上拉下拉事件

			@Override
			public void onRefresh() {
				current = 0;// 回归0页
				lv_item_container.setPullLoadEnable(true);
				EventIOController.eventsRead(handler, REFRESH, ITEM_COUNT, current * ITEM_COUNT);
			}

			@Override
			public void onLoadMore() {
				current++;
				EventIOController.eventsRead(handler, LOAD_MORE, ITEM_COUNT, current * ITEM_COUNT);
			}
		});
	}

	/** 创建一个静态的实例 */
	public static final TonightEightFragment newInstance() {
		TonightEightFragment saFragment = new TonightEightFragment();
		saFragment.setHasOptionsMenu(true);
		return saFragment;
	}

	private void initActionBar() {
		bA.getActionBarSpeical("今晚8点", R.drawable.m_action_right, false, true, null).setText("北京");
	}

	/**
	 * @Description:初始化listView头部视图
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
