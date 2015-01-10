package com.android.tonight8.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.tonight8.R;

/**
 * @Description:我的账户
 * @author:LiuZhao
 * @Date:2014年12月15日
 */
public class MyAccountFragment extends Fragment {

	private View rootView;

	/** 创建一个静态的实例 */
	public static final MyAccountFragment newInstance() {
		MyAccountFragment saFragment = new MyAccountFragment();
		return saFragment;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		/* 主布局初始化 */
		if (rootView != null) {
			/* 已存在空的view */
			return rootView;
		}
		rootView = inflater.inflate(R.layout.fragment_myaccount, container, false);
		return rootView;
	}
}
