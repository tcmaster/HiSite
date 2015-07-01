package com.android.tonight8.activity.wish;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

import com.android.tonight8.R;
import com.android.tonight8.adapter.wish.CheckSponsorAdapter;
import com.android.tonight8.base.BaseActivity;
import com.android.tonight8.dao.model.wish.MyWishSponsorListModel;
import com.android.tonight8.io.HandlerConstants;
import com.android.tonight8.io.wish.WishIOController;
import com.android.tonight8.utils.Utils;
import com.android.tonight8.view.MyProgressBar;
import com.android.tonight8.view.xlistview.XListView;
import com.lidroid.xutils.view.annotation.ViewInject;

/**
 * @author 我的心愿赞助
 * 
 */
public class MyWishSponsorActivity extends BaseActivity {
	private CheckSponsorAdapter adapter;
	private List<MyWishSponsorListModel> list;
	@ViewInject(R.id.lv_mywishsponsor)
	private XListView xlist;
	@ViewInject(R.id.tv_mywishpost_theme)
	private TextView tv_mywishpost_theme;
	@ViewInject(R.id.tv_mywishpost_datetime)
	private TextView tv_mywishpost_datetime;
	@ViewInject(R.id.tv_support_count)
	private TextView tv_support_count;
	@ViewInject(R.id.pb_mywish_progress)
	private MyProgressBar pb_mywish_progress;
	@ViewInject(R.id.tv_wish_over)
	private TextView tv_wish_over;
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

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		initCreateNomal(savedInstanceState, R.layout.activity_my_wishsponsor);
		getActionBarBase("我的心愿赞助");
		initData();
	}

	private void initData() {
		tv_wish_over.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Utils.toast("发布结束");
			}
		});
		tv_mywishpost_theme.setText("不如去大理");
		tv_mywishpost_datetime.setText("2015-6-25 10:10");
		tv_support_count.setText("2015-6-25 10:10");
		list = new ArrayList<MyWishSponsorListModel>();
		adapter = new CheckSponsorAdapter(mContext, list, xlist);
		xlist.setAdapter(adapter);
		Map<String, String> params = new HashMap<String, String>();
		WishIOController.getMyWishSponsorList(handler, params,
				HandlerConstants.WISH.MYWISH_SPONSOR, REFRESH);

	}
}
