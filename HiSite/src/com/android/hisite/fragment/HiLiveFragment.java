package com.android.hisite.fragment;

import com.android.hisite.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * @Description:Hi现场
 * @author:LiuZhao   
 * @Date:2014年12月15日
 */
public class HiLiveFragment extends Fragment{
	private View rootView;

	/** 创建一个静态的实例 */
	public static final TonightEightFragment newInstance() {
		TonightEightFragment saFragment = new TonightEightFragment();
		return saFragment;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		/* 主布局初始化 */
		if (rootView != null) {
			/* 已存在空的view */
			return rootView;
		}
		rootView = inflater.inflate(R.layout.fragment_hi_live, container, false);
		return rootView;
	}
}
