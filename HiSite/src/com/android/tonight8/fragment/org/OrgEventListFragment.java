package com.android.tonight8.fragment.org;

import java.util.ArrayList;
import java.util.List;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

import com.android.tonight8.R;
import com.android.tonight8.activity.createevent.UserAgreementActivity;
import com.android.tonight8.adapter.org.OrgEventListAdapter;
import com.android.tonight8.base.BaseFragment;
import com.android.tonight8.model.event.EventListModel;
import com.android.tonight8.view.xlistview.XListView;

/**
 * @author lz商家活动列表
 * 
 */
public class OrgEventListFragment extends BaseFragment {

	private XListView lv_only_list;
	private OrgEventListAdapter orgEventListAdapter;
	private List<EventListModel> list;
	private View rootView;

	public static final OrgEventListFragment newInstance() {
		OrgEventListFragment orgEventListFragment = new OrgEventListFragment();
		return orgEventListFragment;
	}

	@Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		super.onCreateView(inflater, container, savedInstanceState);
		rootView = inflater.inflate(R.layout.activity_only_list, null);
		lv_only_list = (XListView) rootView.findViewById(R.id.lv_only_list);
		list = new ArrayList<EventListModel>();
		for (int i = 0; i < 10; i++) {
			EventListModel event = new EventListModel();
			list.add(event);
		}
		orgEventListAdapter = new OrgEventListAdapter(activity, list);
		lv_only_list.setAdapter(orgEventListAdapter);
		lv_only_list.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				startActivityForAnima(new Intent(activity,
						UserAgreementActivity.class), null);

			}
		});
		return rootView;
	}

}
