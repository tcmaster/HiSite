package com.android.tonight8.fragment.goodsinfo;

import java.util.List;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.tonight8.R;
import com.android.tonight8.adapter.live.GoodsCommentAdapter;
import com.android.tonight8.base.BaseFragment;
import com.android.tonight8.dao.model.live.EventGoodServiceMark;
import com.android.tonight8.io.HandlerConstants;
import com.android.tonight8.io.live.LiveIOController;
import com.android.tonight8.view.ListViewForScrollView;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;

/**
 * @Descripton 商品口碑
 * @author LiXiaoSong
 * @2015-6-25
 * @Tonight8
 */
public class GoodsPraiseFragment extends BaseFragment {
	/** 父View */
	private View view;
	@ViewInject(R.id.lv_only_list)
	private ListViewForScrollView lv_only_list;
	/** 商品评论适配器 */
	private GoodsCommentAdapter adapter;

	@SuppressLint("HandlerLeak")
	private Handler handler = new Handler() {
		@SuppressWarnings("unchecked")
		@Override
		public void handleMessage(android.os.Message msg) {
			switch (msg.what) {
			case HandlerConstants.Live.GOODS_COMMENT:
				switch (msg.arg1) {
				case HandlerConstants.RESULT_OK:
					if (adapter == null) {
						adapter = new GoodsCommentAdapter(getActivity(),
								(List<EventGoodServiceMark>) msg.obj);
						lv_only_list.setAdapter(adapter);

					} else
						adapter.notifyDataSetChanged();
					break;

				default:
					break;
				}
				break;

			default:
				break;
			}
		};
	};

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		if (view == null) {
			view = inflater.inflate(R.layout.activity_only_list_for_scroll,
					null);
			ViewUtils.inject(this, view);
		}
		return view;
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		initDatas();
	}

	public static GoodsPraiseFragment newInstance() {
		return new GoodsPraiseFragment();
	}

	private void initDatas() {
		LiveIOController.readGoodsComment(handler);
	}
}
