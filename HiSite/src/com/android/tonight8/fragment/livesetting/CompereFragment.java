package com.android.tonight8.fragment.livesetting;

import java.util.List;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.android.tonight8.R;
import com.android.tonight8.adapter.BaseListAdapter;
import com.android.tonight8.adapter.ViewHolder;
import com.android.tonight8.base.BaseFragment;
import com.android.tonight8.view.xlistview.XListView;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;

public class CompereFragment extends BaseFragment {
	/** 按钮 */
	private View rootView;
	@ViewInject(R.id.lv_only_list)
	private XListView lv_only_list;
	private CompereAdapter compereAdapter;

	public static final CompereFragment newInstance() {
		CompereFragment compereFragment = new CompereFragment();
		return compereFragment;

	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		rootView = inflater
				.inflate(R.layout.fragment_compere, container, false);
		ViewUtils.inject(this, rootView);
		compereAdapter = new CompereAdapter(activity, null);
		lv_only_list.setAdapter(compereAdapter);
		return rootView;

	}

	/**
	 * @author lz 主持人数据适配器
	 * 
	 */
	private class CompereAdapter extends BaseListAdapter<String> {

		public CompereAdapter(Context context, List<String> values) {
			super(context, values);

		}

		@Override
		protected View getItemView(View convertView, int position) {

			if (convertView == null) {
				convertView = mInflater.inflate(R.layout.adapter_compere_item,
						null, false);
			}

			ImageView iv_awarduser_headpic = ViewHolder.get(convertView,
					R.id.iv_awarduser_headpic);
			return convertView;
		}

	}
}
