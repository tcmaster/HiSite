package com.android.tonight8.fragment.livemanage;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.tonight8.R;
import com.android.tonight8.adapter.event.PlayBillListAdapter;
import com.android.tonight8.base.BaseFragment;
import com.android.tonight8.io.event.EventIOController;
import com.android.tonight8.io.event.entity.PlayListNetEntity;
import com.android.tonight8.io.net.NetEntityBase;
import com.android.tonight8.io.net.NetRequest.RequestResult;
import com.android.tonight8.view.ListViewForScrollView;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.view.annotation.ViewInject;

/**
 * @Descripton 用于现场直播的fragment（节目单）
 * @author LiXiaoSong
 * @2015-6-10
 * @Tonight8
 */
public class ProgramListFragment extends BaseFragment {
	/** 父View */
	private View view;
	/** 节目单列表 */
	@ViewInject(R.id.lv_only_list)
	private ListViewForScrollView lv_only_list;
	/** 节目单列表 */
	private PlayBillListAdapter adapter;

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

	public static ProgramListFragment newInstance() {
		return new ProgramListFragment();
	}

	private void initDatas() {
		EventIOController.eventPlayBillRead(22l,
				new RequestResult<PlayListNetEntity>(PlayListNetEntity.class,
						null) {

					@Override
					public void onFailure(HttpException error, String msg) {

					}

					@Override
					public void getData(NetEntityBase netEntityBase,
							final PlayListNetEntity t, Handler handler) {
						getActivity().runOnUiThread(new Runnable() {

							@Override
							public void run() {
								if (adapter == null) {
									adapter = new PlayBillListAdapter(
											getActivity(), t.getPlaybillList());
									lv_only_list.setAdapter(adapter);
								} else
									adapter.notifyDataSetChanged();
							}
						});
					}
				});
	}
}
