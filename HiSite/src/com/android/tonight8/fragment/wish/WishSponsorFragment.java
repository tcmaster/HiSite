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
import com.android.tonight8.adapter.wish.WishSponsorAdapter;
import com.android.tonight8.base.BaseFragment;
import com.android.tonight8.io.HandlerConstants;
import com.android.tonight8.io.event.EventIOController;
import com.android.tonight8.io.wish.WishIOController;
import com.android.tonight8.model.wish.WishSponsorList;
import com.android.tonight8.view.xlistview.XListView;
import com.android.tonight8.view.xlistview.XListView.IXListViewListener;

/**
 * @author 心愿直播赞助页
 * 
 */
public class WishSponsorFragment extends BaseFragment {
	private XListView xlist;
	private WishSponsorAdapter wishSponsorAdapter;
	private List<WishSponsorList> list;
	/** 当前展示的页数 */
	private int current = 0;
	/** 每页显示的条数 */
	private final int ITEM_COUNT = 10;

	private View rootView;
	/** 本界面的数据更新handler */
	private Handler handler = new Handler() {

		@Override
		public void handleMessage(Message msg) {
			if (msg.what == HandlerConstants.WISH.WISH_SPONOR_LIST) {

				if (msg.arg1 == HandlerConstants.RESULT_OK) {// 网络数据获取成功
					List<WishSponsorList> data = (List<WishSponsorList>) msg.obj;
					switch (msg.arg2) {
					case REFRESH:
						if (data == null || data.size() < ITEM_COUNT)
							xlist.setPullLoadEnable(false);
						wishSponsorAdapter.initData(data);
						xlist.stopRefresh();
						break;
					case LOAD_MORE:
						if (data == null || data.size() < ITEM_COUNT)
							xlist.setPullLoadEnable(false);
						wishSponsorAdapter.addData(data);
						xlist.stopLoadMore();
						break;
					default:
						break;
					}
				}
			}
		};
	};

	public static final WishSponsorFragment newInstance() {
		WishSponsorFragment wishSponsorFragment = new WishSponsorFragment();
		return wishSponsorFragment;
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		rootView = inflater.inflate(R.layout.fragment_wish_sponsor, container,
				false);
		Map<String, String> params = new HashMap<String, String>();
		WishIOController.getWishSponorRead(handler, params,
				HandlerConstants.WISH.WISH_SPONOR_LIST, REFRESH);
		xlist = (XListView) rootView.findViewById(R.id.lv_wishsupportlist);
		xlist.setFocusable(false);
		list = new ArrayList<WishSponsorList>();
		wishSponsorAdapter = new WishSponsorAdapter(getActivity(), list);
		xlist.setAdapter(wishSponsorAdapter);
		xlist.setXListViewListener(new IXListViewListener() {// 设置上拉下拉事件

			@Override
			public void onRefresh() {
				current = 0;// 回归0页
				xlist.setPullLoadEnable(true);
				EventIOController.eventsRead(handler, REFRESH, ITEM_COUNT,
						current * ITEM_COUNT);
			}

			@Override
			public void onLoadMore() {
				current++;
				EventIOController.eventsRead(handler, LOAD_MORE, ITEM_COUNT,
						current * ITEM_COUNT);
			}
		});
		return rootView;

	}
}
