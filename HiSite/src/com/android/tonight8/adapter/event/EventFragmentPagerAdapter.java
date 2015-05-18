package com.android.tonight8.adapter.event;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.view.ViewGroup;

public class EventFragmentPagerAdapter extends FragmentPagerAdapter {
	private Fragment[] fragments;
	private FragmentManager fm;

	public EventFragmentPagerAdapter(FragmentManager fm) {
		super(fm);
		this.fm = fm;
	}

	public EventFragmentPagerAdapter(FragmentManager fm, Fragment[] fragments) {
		super(fm);
		this.fm = fm;
		this.fragments = fragments;
	}

	@Override
	public int getCount() {
		return fragments.length;
	}

	@Override
	public Fragment getItem(int position) {
		return fragments[position];
	}

	@Override
	public int getItemPosition(Object object) {
		return POSITION_NONE;
	}

	public void setFragments(int tab_postion) {
		if (this.fragments != null) {
			FragmentTransaction ft = fm.beginTransaction();
			ft = fm.beginTransaction();
			for (int i = 0; i < fragments.length; i++) {
				if (tab_postion == i) {
					ft.show(fragments[i]);
				} else
					ft.hide(fragments[i]);
			}
			ft.commit();
			ft = null;
			fm.executePendingTransactions();
		}

		notifyDataSetChanged();
	}

	@Override
	public Object instantiateItem(ViewGroup container, final int position) {
		Object obj = super.instantiateItem(container, position);
		return obj;
	}

}
