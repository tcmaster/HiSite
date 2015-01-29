package com.android.tonight8.adapter.createevent;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.android.tonight8.R;

public class PostEventsGridAdapter extends BaseAdapter {

	private String[] strMenu = { "发布活动", "活动中奖管理", "促销券使用", " 绑定经销商", "已用券核销", " 用户反馈" };
	private int[] intMenu = { R.drawable.eventmenu_createevent, R.drawable.eventmenu_awardmanager, R.drawable.eventmenu_coupon_use, R.drawable.eventmenu_bind_agency, R.drawable.eventmenu_usedcoupon, R.drawable.eventmenu_userfeedback };
	private Context context;
	private LayoutInflater mLiInflater;

	public PostEventsGridAdapter(Context context) {
		super();
		this.context = context;
		mLiInflater = LayoutInflater.from(context);
	}

	@Override
	public int getCount() {
		return strMenu.length;
	}

	@Override
	public Object getItem(int arg0) {
		return null;
	}

	@Override
	public long getItemId(int arg0) {
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup arg2) {
		ViewHolder holder;
		if (convertView == null) {
			holder = new ViewHolder();
			convertView = mLiInflater.inflate(R.layout.adapter_postevents_grid, null, false);
			holder.tv_grid_title = (TextView) convertView.findViewById(R.id.tv_grid_title);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		holder.tv_grid_title.setText(strMenu[position]);
		Drawable drawable = context.getResources().getDrawable(intMenu[position]);
		drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumWidth());
		holder.tv_grid_title.setCompoundDrawables(null, drawable, null, null);
		return convertView;
	}

	class ViewHolder {

		TextView tv_grid_title;
	}
}
