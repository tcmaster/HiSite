package com.android.tonight8.fragment.wish;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import com.android.tonight8.adapter.wish.WishRealizedListAdapter;
import com.android.tonight8.base.BaseActivity;
import com.android.tonight8.base.BaseFragment;
import com.android.tonight8.dao.model.wish.WishListModel;
import com.android.tonight8.io.HandlerConstants;
import com.android.tonight8.io.wish.WishIOController;
import com.android.tonight8.view.xlistview.XListView;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;

/**
 * @author lz 愿望列表(未实现)
 */
public class WishRealizedFragment extends BaseFragment {
	private WishRealizedListAdapter wishListAdapter;
	private List<WishListModel> list;
	@ViewInject(R.id.gv_wish)
	private XListView xlist;
	private View rootView;
	private BaseActivity mActivity;
	/** 当前展示的页数 */
	private int current = 0;
	/** 每页显示的条数 */
	private final int ITEM_COUNT = 10;

	public static final WishRealizedFragment newInstance() {
		WishRealizedFragment wUnrealizedFragment = new WishRealizedFragment();
		return wUnrealizedFragment;

	}

	/** 本界面的数据更新handler */
	private Handler handler = new Handler() {

		@Override
		public void handleMessage(Message msg) {
			if (msg.what == HandlerConstants.WISH.WISH_LIST_REALIZED) {

				if (msg.arg1 == HandlerConstants.RESULT_OK) {// 网络数据获取成功
					List<WishListModel> data = (List<WishListModel>) msg.obj;
					switch (msg.arg2) {
					case REFRESH:
						if (data == null || data.size() < ITEM_COUNT)
							xlist.setPullLoadEnable(false);
						wishListAdapter.initData(data);
						xlist.stopRefresh();
						break;
					case LOAD_MORE:
						if (data == null || data.size() < ITEM_COUNT)
							xlist.setPullLoadEnable(false);
						wishListAdapter.addData((List<WishListModel>) msg.obj);
						xlist.stopLoadMore();
						break;
					default:
						break;
					}
				}
			}
		};
	};

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
		initData();
		return rootView;
	}

	private void initData() {
		xlist = (XListView) rootView.findViewById(R.id.lv_only_list);
		list = new ArrayList<WishListModel>();
		Map<String, String> params = new HashMap<String, String>();
		WishIOController.getWishList(handler, params,
				HandlerConstants.WISH.WISH_LIST_REALIZED, REFRESH);
		wishListAdapter = new WishRealizedListAdapter(activity, list);
		xlist.setAdapter(wishListAdapter);
		xlist.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				Intent intent = new Intent(getActivity(),
						WishLiveActivity.class);
				startActivityForAnima(intent, mActivity);

			}

		});
	}
}
