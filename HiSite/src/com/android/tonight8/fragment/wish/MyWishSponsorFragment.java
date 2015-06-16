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
import com.android.tonight8.adapter.wish.MyWishSponsorAdapter;
import com.android.tonight8.base.BaseFragment;
import com.android.tonight8.dao.model.wish.MyWishSponsorListModel;
import com.android.tonight8.io.HandlerConstants;
import com.android.tonight8.io.wish.WishIOController;
import com.android.tonight8.view.xlistview.XListView;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;

/**
 * @author 我的心愿：赞助的心愿
 * 
 */
public class MyWishSponsorFragment extends BaseFragment {
	private View rootView;
	private MyWishSponsorAdapter adapter;
	private List<MyWishSponsorListModel> list;
	@ViewInject(R.id.lv_only_list)
	private XListView xlist;
	/** 每页显示的条数 */
	private final int ITEM_COUNT = 10;
	/** 本界面的数据更新handler */
	private Handler handler = new Handler() {

		@Override
		public void handleMessage(Message msg) {
			if (msg.what == HandlerConstants.WISH.MYWISH_SPONSOR) {

				if (msg.arg1 == HandlerConstants.RESULT_OK) {// 网络数据获取成功
					List<MyWishSponsorListModel> data = (List<MyWishSponsorListModel>) msg.obj;
					switch (msg.arg2) {
					case REFRESH:
						if (data == null || data.size() < ITEM_COUNT)
							xlist.setPullLoadEnable(false);
						adapter.update(data);
						xlist.stopRefresh();
						break;
					case LOAD_MORE:
						if (data == null || data.size() < ITEM_COUNT)
							xlist.setPullLoadEnable(false);
						adapter.addData(data);
						xlist.stopLoadMore();
						break;
					default:
						break;
					}
				}
			}
		};
	};

	public static final MyWishSponsorFragment newInstance() {
		MyWishSponsorFragment myWishPostFragment = new MyWishSponsorFragment();
		return myWishPostFragment;

	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		super.onCreateView(inflater, container, savedInstanceState);
		rootView = inflater.inflate(R.layout.activity_only_list, container,
				false);
		ViewUtils.inject(this, rootView);
		initData();
		return rootView;
	}

	private void initData() {
		list = new ArrayList<MyWishSponsorListModel>();
		adapter = new MyWishSponsorAdapter(activity, list);
		xlist.setAdapter(adapter);
		Map<String, String> params = new HashMap<String, String>();
		WishIOController.getMyWishSponsorList(handler, params,
				HandlerConstants.WISH.MYWISH_SPONSOR, REFRESH);
	}
}
