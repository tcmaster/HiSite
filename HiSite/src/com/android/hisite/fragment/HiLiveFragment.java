package com.android.hisite.fragment;

import com.android.hisite.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;


/**
 * @Description:Hi现场
 * @author:LiuZhao   
 * @Date:2014年12月15日
 */
public class HiLiveFragment extends Fragment{
	private View rootView;
	private ListView lv_hiLive;

	/** 创建一个静态的实例 */
	public static final HiLiveFragment newInstance() {
		HiLiveFragment hiFragment = new HiLiveFragment();
		return hiFragment;
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
