package com.android.tonight8.fragment.wish;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.tonight8.R;
import com.android.tonight8.adapter.wish.WishTalkAdapter;
import com.android.tonight8.base.BaseFragment;
import com.android.tonight8.io.HandlerConstants;
import com.android.tonight8.io.wish.WishIOController;
import com.android.tonight8.model.wish.SubjectListModel;
import com.android.tonight8.view.xlistview.XListView;
import com.android.tonight8.view.xlistview.XListView.IXListViewListener;

/**
 * @author lz 心愿讨论区
 * 
 */
public class WishTalkFragment extends BaseFragment {

	private XListView xlist;
	private WishTalkAdapter talkAdapter;
	private List<SubjectListModel> list;
	/** 当前展示的页数 */
	private int current = 0;
	/** 每页显示的条数 */
	private final int ITEM_COUNT = 10;
	private View rootView;

	/** 本界面的数据更新handler */
	private Handler handler = new Handler() {

		@SuppressWarnings("unchecked")
		@Override
		public void handleMessage(Message msg) {

			if (msg.what == HandlerConstants.WISH.WISH_LIVE_TALK
					&& msg.arg1 == HandlerConstants.RESULT_OK) {// 网络数据获取成功
				List<SubjectListModel> data = null;
				if (msg.arg2 == INIT) {
					xlist.setVisibility(View.VISIBLE);
					data = (List<SubjectListModel>) msg.obj;
					if (data == null || data.size() < ITEM_COUNT)
						xlist.setPullLoadEnable(false);
					else
						xlist.setPullLoadEnable(true);
					talkAdapter.initData(data);
					xlist.stopRefresh();
				} else if (msg.arg2 == REFRESH) {
					data = (List<SubjectListModel>) msg.obj;
					if (data == null || data.size() < ITEM_COUNT)
						xlist.setPullLoadEnable(false);
					talkAdapter.initData(data);
					xlist.stopRefresh();
				} else if (msg.arg2 == LOAD_MORE) {
					data = (List<SubjectListModel>) msg.obj;
					if (data == null || data.size() < ITEM_COUNT)
						xlist.setPullLoadEnable(false);
					talkAdapter.addData((List<SubjectListModel>) msg.obj);
					xlist.stopLoadMore();
				}

			} else if (msg.arg1 == HandlerConstants.NETWORK_BEGIN) {// 网络数据开始
				if (msg.arg2 == INIT) {

					xlist.setVisibility(View.INVISIBLE);
				}
			} else if (msg.arg1 == HandlerConstants.RESULT_FAIL) {// 出错处理
				if (msg.arg2 == INIT) {
					xlist.setVisibility(View.INVISIBLE);
				}
			} else if (msg.arg1 == HandlerConstants.NETWORK_END) {// 网络数据获取完毕

			}

		};
	};

	public static final WishTalkFragment newInstance() {
		WishTalkFragment wishTalkFragment = new WishTalkFragment();
		return wishTalkFragment;
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// // 为防止layout界面上的EditText在进入页面时就弹出输入法,隐藏软键盘
		// getActivity().getWindow().setSoftInputMode(
		// WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		rootView = inflater.inflate(R.layout.activity_only_list, container,
				false);
		xlist = (XListView) rootView.findViewById(R.id.lv_only_list);
		xlist.setFocusable(false); // 重要：ScrollView起始位置不是最顶部的解决办法
		initData();
		return rootView;

	}

	private void initData() {
		list = new ArrayList<SubjectListModel>();
		Map<String, String> params = new HashMap<String, String>();
		WishIOController.getWishTalkRead(handler, params,
				HandlerConstants.WISH.WISH_LIVE_TALK, REFRESH);
		list = new ArrayList<SubjectListModel>();
		talkAdapter = new WishTalkAdapter(getActivity(), list);
		xlist.setAdapter(talkAdapter);
		xlist.setXListViewListener(new IXListViewListener() {// 设置上拉下拉事件

			@Override
			public void onRefresh() {
				current = 0;// 回归0页
				xlist.setPullLoadEnable(true);
				Map<String, String> params = new HashMap<String, String>();
				WishIOController.getWishTalkRead(handler, params,
						HandlerConstants.WISH.WISH_LIVE_TALK, REFRESH);
			}

			@Override
			public void onLoadMore() {
				current++;
				Map<String, String> params = new HashMap<String, String>();
				WishIOController.getWishTalkRead(handler, params,
						HandlerConstants.WISH.WISH_LIVE_TALK, LOAD_MORE);
			}
		});
	}

}
