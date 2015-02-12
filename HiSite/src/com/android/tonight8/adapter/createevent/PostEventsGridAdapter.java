package com.android.tonight8.adapter.createevent;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.android.tonight8.R;

public class PostEventsGridAdapter extends BaseAdapter {

	private String[] strMenu = { "发布活动", "活动中奖管理", "促销券使用", " 绑定经销商", "已用券核销",
			"兑奖地点管理", " 用户反馈", "退出后台", "" };
	private int[] intMenu = { R.drawable.pencil_red_big,
			R.drawable.star_red_big, R.drawable.avg_red, R.drawable.chain_big,
			R.drawable.avg_red_ok, R.drawable.talk_red_big,
			R.drawable.talk_red_big, R.drawable.talk_red_big,
			R.drawable.talk_red_big };
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
			convertView = mLiInflater.inflate(R.layout.adapter_postevents_grid,
					null, false);
			holder.tv_grid_title = (TextView) convertView
					.findViewById(R.id.tv_grid_title);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		holder.tv_grid_title.setText(strMenu[position]);
		Drawable drawable = context.getResources().getDrawable(
				intMenu[position]);
		int minimumWidth = context.getResources().getDrawable(intMenu[0])
				.getMinimumWidth();
		drawable.setBounds(0, 0, minimumWidth, minimumWidth);
		holder.tv_grid_title.setCompoundDrawables(null, drawable, null, null);
		if (position == 8) {
			holder.tv_grid_title.setVisibility(View.INVISIBLE);
		}
		return convertView;
	}

	class ViewHolder {

		TextView tv_grid_title;
	}
}
