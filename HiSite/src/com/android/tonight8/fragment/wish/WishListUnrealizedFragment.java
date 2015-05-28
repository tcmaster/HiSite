package com.android.tonight8.fragment.wish;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

import com.android.tonight8.R;
import com.android.tonight8.activity.wish.WishLiveActivity;
import com.android.tonight8.adapter.wish.WishListAdapter;
import com.android.tonight8.base.BaseActivity;
import com.android.tonight8.base.BaseFragment;
import com.android.tonight8.io.HandlerConstants;
import com.android.tonight8.view.xlistview.XListView;
import com.android.tonight8.view.xlistview.XListView.IXListViewListener;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;

/**
 * @author lz 愿望列表(未实现)
 */
public class WishListUnrealizedFragment extends BaseFragment {
	private WishListAdapter wishListAdapter;
	private List<String> list;
	@ViewInject(R.id.lv_only_list)
	private XListView lv_wish;
	private View rootView;
	private BaseActivity mActivity;

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
	/** 本界面的数据更新handler */
	private Handler handler = new Handler() {

		@SuppressWarnings("unchecked")
		@Override
		public void handleMessage(Message msg) {
			switch (msg.what) {
			case HandlerConstants.Event.MAINPAGE_LIST:
				if (msg.arg1 == HandlerConstants.RESULT_OK) {// 网络数据获取成功
					if (msg.arg2 == INIT) {
						lv_wish.setVisibility(View.VISIBLE);
						List<String> data = (List<String>) msg.obj;
						if (data == null || data.size() < ITEM_COUNT)
							lv_wish.setPullLoadEnable(false);
						else
							lv_wish.setPullLoadEnable(true);
						wishListAdapter = new WishListAdapter(getActivity(),
								data);
						lv_wish.setAdapter(wishListAdapter);
					} else if (msg.arg2 == REFRESH) {
						List<String> data = (List<String>) msg.obj;
						if (data == null || data.size() < ITEM_COUNT)
							lv_wish.setPullLoadEnable(false);
						wishListAdapter.initData(data);
						lv_wish.stopRefresh();
					} else if (msg.arg2 == LOAD_MORE) {
						List<String> data = (List<String>) msg.obj;
						if (data == null || data.size() < ITEM_COUNT)
							lv_wish.setPullLoadEnable(false);
						wishListAdapter.addData((List<String>) msg.obj);
						lv_wish.stopLoadMore();
					}

				} else if (msg.arg1 == HandlerConstants.NETWORK_BEGIN) {// 网络数据开始
					if (msg.arg2 == INIT) {

						lv_wish.setVisibility(View.INVISIBLE);
					}
				} else if (msg.arg1 == HandlerConstants.RESULT_FAIL) {// 出错处理
					if (msg.arg2 == INIT) {
						lv_wish.setVisibility(View.INVISIBLE);
					}
				} else if (msg.arg1 == HandlerConstants.NETWORK_END) {// 网络数据获取完毕

				}
				break;

			default:
				break;
			}
		};
	};

	public static final WishListUnrealizedFragment newInstance() {
		WishListUnrealizedFragment wUnrealizedFragment = new WishListUnrealizedFragment();
		return wUnrealizedFragment;

	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

	}

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		mActivity = (BaseActivity) activity;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		super.onCreateView(inflater, container, savedInstanceState);
		rootView = inflater.inflate(R.layout.activity_only_list, container,
				false);
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
		lv_wish.setPullLoadEnable(true);
		lv_wish.setPullLoadEnable(true);
		lv_wish.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				mActivity.startActivity(new Intent(mActivity,
						WishLiveActivity.class));
			}
		});
		lv_wish.setXListViewListener(new IXListViewListener() {

			@Override
			public void onRefresh() {
				stopOnLoad();
			}

			@Override
			public void onLoadMore() {
				stopOnLoad();
			}
		});
		return rootView;
	}

	/*
	 * 停止刷新或加载操作
	 */
	private void stopOnLoad() {
		lv_wish.stopRefresh();
		lv_wish.stopLoadMore();
		lv_wish.setRefreshTime(true);

	}
}
