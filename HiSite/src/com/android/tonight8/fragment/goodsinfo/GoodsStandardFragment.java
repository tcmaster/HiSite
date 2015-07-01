package com.android.tonight8.fragment.goodsinfo;

import java.util.List;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;

import com.android.tonight8.R;
import com.android.tonight8.adapter.live.GoodStandardAdapter;
import com.android.tonight8.base.BaseFragment;
import com.android.tonight8.dao.entity.GoodsStandard;
import com.android.tonight8.view.ListViewForScrollView;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;

public class GoodsStandardFragment extends BaseFragment {
	/** 父View */
	private View view;
	@ViewInject(R.id.lv_only_list)
	ListViewForScrollView lv_only_list;
	/** 适配器 */
	private GoodStandardAdapter adapter;

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

	public static GoodsStandardFragment newInstance() {
		return new GoodsStandardFragment();
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> void updateData(Class<T> clazz, T t) {
		if (adapter == null) {
			adapter = new GoodStandardAdapter(getActivity(),
					(List<GoodsStandard>) t);
			lv_only_list.setAdapter(adapter);

		} else
			adapter.update((List<GoodsStandard>) t);
	}

	@Override
	public void scrollToTop(final ScrollView sv) {
		lv_only_list.post(new Runnable() {

			@Override
			public void run() {
				sv.scrollTo(0, 0);
			}
		});
	}
}
