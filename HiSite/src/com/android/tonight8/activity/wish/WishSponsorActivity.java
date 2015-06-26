package com.android.tonight8.activity.wish;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.tonight8.R;
import com.android.tonight8.adapter.wish.WishSponorListAdapter;
import com.android.tonight8.base.BaseActivity;
import com.android.tonight8.dao.entity.WishItem;
import com.android.tonight8.dao.model.wish.WishItemModel;
import com.android.tonight8.io.HandlerConstants;
import com.android.tonight8.io.wish.WishIOController;
import com.android.tonight8.utils.DialogUtils;
import com.android.tonight8.view.ListViewForScrollView;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnClick;

/**
 * @author lz心愿赞助页面
 * 
 */
public class WishSponsorActivity extends BaseActivity {
	/** 赞助总额 */
	@ViewInject(R.id.tv_spnosor_sum)
	private TextView tv_spnosor_sum;
	/** 差额 */
	@ViewInject(R.id.tv_spnosor_balance)
	private TextView tv_spnosor_balance;
	/** 要赞助的总额 */
	@ViewInject(R.id.et_spnosor_money)
	private EditText et_spnosor_money;
	/** 要赞助的东西 */
	@ViewInject(R.id.lv_sponsor_something)
	private ListViewForScrollView lv_sponsor_something;
	private WishItemModel wishItemModel;
	/** 心愿赞助物品清单 */
	private List<WishItem> list;
	/** 心愿赞助 */
	private WishSponorListAdapter wAdapter;
	/** 心愿的ID */
	private String wishId;
	/** 用户的ID */
	private String userId;
	/** 心愿项目的id */
	private String wishItemIds;
	/** 心愿项目的id */
	private String wishItemId;
	/** 赞助提交 */
	@ViewInject(R.id.btn_sponsor_submit)
	private Button btn_sponsor_submit;

	@OnClick(R.id.btn_sponsor_submit)
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btn_sponsor_submit:
			// if (wishItemIds != null) {
			// wishItemIds = wishItemIds
			// .substring(0, wishItemIds.length() - 1);
			// }
			//
			// Map<String, String> postParams = new HashMap<String, String>();
			// postParams.put("wish.id", wishId);
			// postParams.put("user.id", userId);
			// postParams.put("wishItem.ids", wishItemIds);
			// postParams.put("wishItem.id", wishItemId);
			// WishIOController.postWishSponsor(handler, postParams, REFRESH);
			DialogUtils.showPayDialog(WishSponsorActivity.this);
			break;

		default:
			break;
		}
	}

	private Handler handler = new Handler() {

		@Override
		public void handleMessage(Message msg) {
			super.handleMessage(msg);

			if (msg.what == HandlerConstants.WISH.WISH_SPONOR_LIST) {

				if (msg.arg1 == HandlerConstants.RESULT_OK) {// 网络数据获取成功
					wishItemModel = (WishItemModel) msg.obj;
					if (msg.arg2 == REFRESH) {
						if (wishItemModel != null
								&& wishItemModel.getWishitems() != null) {
							wAdapter.update(wishItemModel.getWishitems());
						}
					}
				}
			}
		}

	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		initCreateNomal(savedInstanceState, R.layout.activity_wish_sponsor);
		getActionBarBase("心愿赞助");
		initData();
	}

	/**
	 * 初始化数据
	 */
	private void initData() {
		list = new ArrayList<WishItem>();
		wAdapter = new WishSponorListAdapter(mContext, list);
		lv_sponsor_something.setAdapter(wAdapter);

		Map<String, String> params = new HashMap<String, String>();
		params.put("wish.id", wishId);
		WishIOController.getWishSponsorChecklist(handler, params,
				HandlerConstants.WISH.WISH_SPONOR_LIST, REFRESH);
	}

	public void updateAdaper(int location, boolean ischecked) {
		// list.get(location).setIschecked(ischecked);
		wAdapter.update(list);
	}

}
