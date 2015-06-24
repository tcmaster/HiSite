package com.android.tonight8.base;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;

import com.android.tonight8.R;

public class BaseFragment extends Fragment {
	/** 下拉刷新标识 */
	protected static final int REFRESH = 1;
	/** 上拉加载标识 */
	protected static final int LOAD_MORE = 2;
	/** 首次加载标识 */
	protected static final int INIT = 3;
	protected Activity activity;
	/** 公共布局 */
	protected View rootView;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		this.activity = activity;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		/** 当前fragment的view */
		if (rootView != null) {
			/*
			 * 缓存的rootView需要判断是否已经被加过parent，
			 * 如果有parent需要从parent删除，要不然会发生这个RootView已经有parent的错误。
			 */
			ViewGroup parent = (ViewGroup) rootView.getParent();
			if (parent != null) {
				parent.removeView(rootView);
			}
			return rootView;
		}
		return null;
	}

	protected void startActivityForAnima(Intent intent, Activity parentActivity) {
		if (intent != null) {
			if (parentActivity != null) {
				parentActivity.startActivity(intent);
				parentActivity.overridePendingTransition(R.anim.push_left_in,
						R.anim.push_left_out);
			} else {
				startActivity(intent);
				getActivity().overridePendingTransition(R.anim.push_left_in,
						R.anim.push_left_out);
			}
		}
	}

	/**
	 * @Description: 更新数据时调用， 子类如需要，则应重写
	 * @author: LiXiaoSong
	 * @date:2015-2-9
	 */
	public <T> void updateData(Class<T> clazz, T t) {

	}

	/**
	 * 在某些时刻更新完数据需滑倒顶端时使用，子类如需要，应重写
	 * 
	 * @param sv
	 */
	public void scrollToTop(ScrollView sv) {

	}

	public boolean onBackPress() {
		return true;
	}
}
