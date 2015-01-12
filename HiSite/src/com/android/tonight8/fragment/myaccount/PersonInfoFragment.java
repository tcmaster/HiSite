/**
 * 2015-1-12
 */
package com.android.tonight8.fragment.myaccount;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.tonight8.R;

/**
 * @Description:个人资料信息Fragment
 * @author:LiXiaoSong
 * @copyright @HiSite
 * @Date:2015-1-12
 */
public class PersonInfoFragment extends MyAccountBaseFragment {

	private View v_rootView;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		/* 主布局初始化 */
		if (v_rootView != null) {
			/* 已存在空的view */
			return v_rootView;
		}
		v_rootView = inflater.inflate(R.layout.fragment_personinfo, container, false);
		return v_rootView;
	}

	@Override
	public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
		super.onCreateOptionsMenu(menu, inflater);
	}

	public PersonInfoFragment newInstance() {
		PersonInfoFragment fg = new PersonInfoFragment();
		setHasOptionsMenu(true);
		return fg;
	}
}
