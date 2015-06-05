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
import com.android.tonight8.io.HandlerConstants;
import com.android.tonight8.io.wish.WishIOController;
import com.android.tonight8.model.wish.WishListModel;
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
	/** 下拉刷新标识 */
	private final int REFRESH = 1;
	/** 上拉加载标识 */
	private final int LOAD_MORE = 2;
	/** 首次加载标识 */
	private final int INIT = 3;

	public static final WishRealizedFragment newInstance() {
		WishRealizedFragment wUnrealizedFragment = new WishRealizedFragment();
		return wUnrealizedFragment;

	}

	/** 本界面的数据更新handler */
	private Handler handler = new Handler() {

		@SuppressWarnings("unchecked")
		@Override
		public void handleMessage(Message msg) {

			if (msg.arg1 == HandlerConstants.RESULT_OK) {// 网络数据获取成功
				List<WishListModel> data = null;
				if (msg.arg2 == INIT) {
					xlist.setVisibility(View.VISIBLE);
					data = (List<WishListModel>) msg.obj;
					if (data == null || data.size() < ITEM_COUNT)
						xlist.setPullLoadEnable(false);
					else
						xlist.setPullLoadEnable(true);
					wishListAdapter.initData(data);
					xlist.stopRefresh();
				} else if (msg.arg2 == REFRESH) {
					data = (List<WishListModel>) msg.obj;
					if (data == null || data.size() < ITEM_COUNT)
						xlist.setPullLoadEnable(false);
					wishListAdapter.initData(data);
					xlist.stopRefresh();
				} else if (msg.arg2 == LOAD_MORE) {
					data = (List<WishListModel>) msg.obj;
					if (data == null || data.size() < ITEM_COUNT)
						xlist.setPullLoadEnable(false);
					wishListAdapter.addData((List<WishListModel>) msg.obj);
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
		xlist = (XListView) rootView.findViewById(R.id.lv_only_list);
		list = new ArrayList<WishListModel>();
		// WishListModel wListModel = new WishListModel();
		// PopPic poppic = new PopPic();
		// Wish wish = new Wish();
		// User user = new User();
		// wish.setName("我想去大理");
		// wish.setPublishTime("2015年10月1日 8:00");
		// wish.setSupportCount(200);
		// wish.setProgress((float) 0.23);
		// wish.setDescribe("给我三个月假期和2万元钱助我一臂之力去大理，嗷嗷嗷叫");
		// poppic.setUrl("http://pica.nipic.com/2007-12-22/2007122215556437_2.jpg");
		// user.setPic("http://pica.nipic.com/2007-12-22/2007122215556437_2.jpg");
		// user.setName("明月");
		// wListModel.setPopPic(poppic);
		// wListModel.setWish(wish);
		// wListModel.setUser(user);
		// list.add(wListModel);
		// list.add(wListModel);
		// list.add(wListModel);
		// list.add(wListModel);
		// list.add(wListModel);
		Map<String, String> params = new HashMap<String, String>();
		WishIOController.getWishList(handler, params, INIT);
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
		return rootView;
	}

}
