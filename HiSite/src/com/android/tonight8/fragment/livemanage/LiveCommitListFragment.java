package com.android.tonight8.fragment.livemanage;

import java.util.List;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.tonight8.R;
import com.android.tonight8.activity.live.EventLivePlayActivity;
import com.android.tonight8.adapter.live.EventLiveCommitAdapter;
import com.android.tonight8.base.BaseFragment;
import com.android.tonight8.dao.model.live.SubjectList;
import com.android.tonight8.io.HandlerConstants;
import com.android.tonight8.io.live.LiveIOController;
import com.android.tonight8.view.ListViewForScrollView;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;

/**
 * 
 * @Descripton 用于现场直播的fragment（现场评论）
 * @author LiXiaoSong
 * @2015-6-10
 * @Tonight8
 */
public class LiveCommitListFragment extends BaseFragment {
	/** 该界面的listView */
	@ViewInject(R.id.lv_only_list)
	private ListViewForScrollView lv_only_list;
	/** listView尾部文字 */
	private TextView tv_foot;
	/** listView尾部布局 */
	private LinearLayout ll_foot;
	/** 父View */
	private View view;
	private EventLiveCommitAdapter adapter;
	@SuppressLint("HandlerLeak")
	private Handler handler = new Handler() {
		@SuppressWarnings("unchecked")
		@Override
		public void handleMessage(android.os.Message msg) {
			switch (msg.what) {
			case HandlerConstants.Live.LIVE_COMMIT:
				switch (msg.arg1) {
				case HandlerConstants.RESULT_OK:
					if (adapter == null) {
						adapter = new EventLiveCommitAdapter(getActivity(),
								(List<SubjectList>) msg.obj);
						lv_only_list.setAdapter(adapter);
					} else
						adapter.notifyDataSetChanged();
					lv_only_list.post(new Runnable() {

						@Override
						public void run() {
							((EventLivePlayActivity) getActivity()).scrollTop();
						}
					});
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
			addFootView();
		}
		return view;
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		initData();
	}

	public static LiveCommitListFragment newInstance() {
		return new LiveCommitListFragment();
	}

	private void initData() {
		LiveIOController.readEventLiveCommit(handler);
	}

	private void addFootView() {
		if (lv_only_list != null) {
			View footView = LayoutInflater.from(getActivity()).inflate(
					R.layout.foot_lv_event_live_commit, null);
			tv_foot = (TextView) footView.findViewById(R.id.tv_foot);
			ll_foot = (LinearLayout) footView.findViewById(R.id.ll_foot);
			ll_foot.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					tv_foot.setText("点击到了");
				}
			});
			lv_only_list.addFooterView(footView);
		}
	}
}
