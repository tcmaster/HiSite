package com.android.tonight8.fragment.org;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.tonight8.R;
import com.android.tonight8.activity.createevent.UserAgreementActivity;
import com.android.tonight8.adapter.BaseListAdapter;
import com.android.tonight8.adapter.ViewHolder;
import com.android.tonight8.base.BaseFragment;
import com.android.tonight8.model.common.Event;
import com.android.tonight8.view.xlistview.XListView;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnItemClick;

/**
 * @author lz 赞助心愿列表
 * 
 */
public class SponsorWishFragment extends BaseFragment {
	@ViewInject(R.id.lv_only_list)
	private XListView lv_only_list;
	private List<Event> list;
	private View rootView;
	private SponsorWishListAdapter listAdapter;

	public static final SponsorWishFragment newInstance() {
		SponsorWishFragment sponsorWishFragment = new SponsorWishFragment();
		return sponsorWishFragment;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		super.onCreateView(inflater, container, savedInstanceState);
		rootView = inflater.inflate(R.layout.activity_only_list, null);
		list = new ArrayList<Event>();
		for (int i = 0; i < 10; i++) {
			Event event = new Event();
			list.add(event);
		}
		listAdapter = new SponsorWishListAdapter(activity, list);
		lv_only_list.setAdapter(listAdapter);

		return rootView;
	}

	@OnItemClick(R.id.lv_only_list)
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		startActivityForAnima(
				new Intent(activity, UserAgreementActivity.class), null);

	}

	/**
	 * @author lz商家的活动列表数据
	 * 
	 */
	private class SponsorWishListAdapter extends BaseListAdapter<Event> {

		public SponsorWishListAdapter(Context context, List<Event> values) {
			super(context, values);

		}

		@Override
		protected View getItemView(View convertView, int position) {
			convertView = mInflater.inflate(R.layout.adapter_org_eventlist,
					null);
			ImageView iv_sponsor_wishpic = ViewHolder.get(convertView,
					R.id.iv_sponsor_wishpic);
			TextView tv_sponsor_wishname = ViewHolder.get(convertView,
					R.id.tv_sponsor_wishname);
			TextView tv_sponsor_wishproject = ViewHolder.get(convertView,
					R.id.tv_sponsor_wishproject);
			TextView tv_sponsor_wishstatus = ViewHolder.get(convertView,
					R.id.tv_sponsor_wishstatus);
			TextView tv_sponsor_wishdate = ViewHolder.get(convertView,
					R.id.tv_sponsor_wishdate);
			bmUtils.display(iv_sponsor_wishpic, "");
			// tv_sponsor_wishname.setText();
			// tv_sponsor_wishproject.setText();
			// tv_sponsor_wishstatus.setText();
			// tv_sponsor_wishdate.setText();
			return convertView;
		}

	}
}
