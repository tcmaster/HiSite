package com.android.tonight8.fragment.livemanage;

import java.util.List;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.tonight8.R;
import com.android.tonight8.adapter.live.EventLiveWinnerListAdapter;
import com.android.tonight8.base.BaseFragment;
import com.android.tonight8.dao.model.live.EventAward;
import com.android.tonight8.io.HandlerConstants;
import com.android.tonight8.io.live.LiveIOController;
import com.android.tonight8.view.ListViewForScrollView;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;

/**
 * @Descripton 用于现场直播的fragment（获奖名单）
 * @author LiXiaoSong
 * @2015-6-10
 * @Tonight8
 */
public class WinnerListFragment extends BaseFragment {
	/** 父View */
	private View view;
	@ViewInject(R.id.lv_winner_list)
	private ListViewForScrollView lv_winner_list;
	private EventLiveWinnerListAdapter adapter;
	@SuppressLint("HandlerLeak")
	private Handler handler = new Handler() {
		@SuppressWarnings("unchecked")
		@Override
		public void handleMessage(android.os.Message msg) {
			switch (msg.what) {
			case HandlerConstants.Live.LIVE_WINNER_LIST:
				switch (msg.arg1) {
				case HandlerConstants.RESULT_OK:
					if (adapter == null) {
						adapter = new EventLiveWinnerListAdapter(getActivity(),
								(List<EventAward>) msg.obj);
						lv_winner_list.setAdapter(adapter);
					} else {
						adapter.notifyDataSetChanged();
					}

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
			view = inflater.inflate(R.layout.fg_winner_list, null);
			ViewUtils.inject(this, view);
		}
		return view;
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		initDatas();
	}

	public static WinnerListFragment newInstance() {
		return new WinnerListFragment();
	}

	private void initDatas() {
		LiveIOController.readLiveWinnerList(handler);
	}
}
