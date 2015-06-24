package com.android.tonight8.activity.wish;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

import com.android.tonight8.R;
import com.android.tonight8.adapter.wish.MyWishListAdapter;
import com.android.tonight8.base.BaseActivity;
import com.android.tonight8.dao.model.wish.MyWishListModel;
import com.android.tonight8.io.HandlerConstants;
import com.android.tonight8.io.wish.WishIOController;
import com.android.tonight8.view.xlistview.XListView;
import com.lidroid.xutils.view.annotation.ViewInject;

/**
 * @author lz 我的心愿
 * 
 */
public class MyWishActivity extends BaseActivity {
	private MyWishListAdapter adapter;
	private List<MyWishListModel> list;
	 @ViewInject(R.id.lv_mywishsponsor)
	private XListView xlist;
	/** 每页显示的条数 */
	private final int ITEM_COUNT = 10;
	/** 本界面的数据更新handler */
	private Handler handler = new Handler() {

		@Override
		public void handleMessage(Message msg) {
			if (msg.what == HandlerConstants.WISH.MYWISH_POST) {

				if (msg.arg1 == HandlerConstants.RESULT_OK) {// 网络数据获取成功
					List<MyWishListModel> data = (List<MyWishListModel>) msg.obj;
					switch (msg.arg2) {
					case REFRESH:
						if (data == null || data.size() < ITEM_COUNT)
							xlist.setPullLoadEnable(false);
						adapter.update(data);
						xlist.stopRefresh();
						break;
					case LOAD_MORE:
						if (data == null || data.size() < ITEM_COUNT) {
							xlist.setPullLoadEnable(false);
							xlist.setPullLoadHide();
						}
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

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		initCreateNomal(savedInstanceState, R.layout.activity_my_wish);
		getActionBarNormal("我的心愿", R.drawable.vadd, new OnClickListener() {

			@Override
			public void onClick(View v) {
				startActivityForAnima(new Intent(MyWishActivity.this,
						MakeWishActivity.class), null);
			}
		});
		initData();
	}

	private void initData() {
		list = new ArrayList<MyWishListModel>();
		adapter = new MyWishListAdapter(mContext, list);
		xlist.setAdapter(adapter);
		Map<String, String> params = new HashMap<String, String>();
		WishIOController.getMyWishList(handler, params,
				HandlerConstants.WISH.MYWISH_POST, REFRESH);  
		xlist.setPullLoadHide();
		xlist.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				startActivity(new Intent(mContext, WishLiveActivity.class));

			}
		});
	}

}
