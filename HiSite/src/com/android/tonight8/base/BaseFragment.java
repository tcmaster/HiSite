package com.android.tonight8.base;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.android.tonight8.R;

public class BaseFragment extends Fragment {
	/** 下拉刷新标识 */
	protected final int REFRESH = 1;
	/** 上拉加载标识 */
	protected final int LOAD_MORE = 2;
	protected Activity activity;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		this.activity = activity;
	}

	protected void startActivityForAnima(Intent intent, Activity parentActivity) {
		if (intent != null) {
			if (parentActivity != null) {
				parentActivity.startActivity(intent);
				parentActivity.overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
			} else {
				startActivity(intent);
				getActivity().overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
			}
		}
	}

	/**
	 * @Description: 更新数据时调用， 子类如需要，则应重写
	 * @author: LiXiaoSong
	 * @date:2015-2-9
	 */
	public void updateData() {

	}

	public boolean onBackPress() {
		return true;
	}
}
