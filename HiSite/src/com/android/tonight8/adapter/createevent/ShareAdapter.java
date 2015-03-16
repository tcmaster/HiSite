package com.android.tonight8.adapter.createevent;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.android.tonight8.R;
import com.android.tonight8.base.AppConstants;

/**
 * @Description:分享的数据适配器
 * @author:LiuZhao
 * @Date:2015年2月9日
 */
public class ShareAdapter extends BaseAdapter {

	private String[] strMenu = { "QQ空间", "QQ好友", "微信好友", "朋友圈" };
	private int[] intMenu = { R.drawable.share_qq_zone, R.drawable.share_cqq, R.drawable.share_wx, R.drawable.share_wx_friend };
	private Context context;
	private LayoutInflater mLiInflater;

	public ShareAdapter(Context context) {
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
		drawable.setBounds(0, 0, AppConstants.widthPx/6, AppConstants.widthPx/6);
		holder.tv_grid_title.setCompoundDrawables(null, drawable, null, null);
		return convertView;
	}

	class ViewHolder {

		TextView tv_grid_title;
	}
}