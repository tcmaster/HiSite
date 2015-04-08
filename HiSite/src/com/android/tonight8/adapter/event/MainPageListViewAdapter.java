/**
 * 2014-12-25
 */
package com.android.tonight8.adapter.event;

import java.util.List;

import android.content.Context;
import android.view.View;

import com.android.tonight8.R;
import com.android.tonight8.adapter.BaseListAdapter;
import com.android.tonight8.model.event.EventListModel;
import com.lidroid.xutils.BitmapUtils;

/**
 * @Description:
 * @author:LiXiaoSong
 * @see:
 * @since:
 * @copyright @tonight8
 * @Date:2014-12-25
 */
public class MainPageListViewAdapter extends BaseListAdapter<EventListModel> {

	private BitmapUtils bmUtils;

	public MainPageListViewAdapter(Context context, List<EventListModel> values) {
		super(context, values);
		bmUtils = new BitmapUtils(mContext);
	}

	@Override
	protected View getItemView(View convertView, int position) {
		EventListModel model = mValues.get(position);
		if (convertView == null) {
			convertView = mInflater.inflate(R.layout.item_home_lv, null, false);
		}

		return convertView;
	}

	/**
	 * 增加数据源
	 * 
	 * @param models
	 */
	public void addData(List<EventListModel> models) {
		mValues.addAll(models);
		notifyDataSetChanged();
	}

	/**
	 * 重置数据源
	 * 
	 * @param models
	 */
	public void initData(List<EventListModel> models) {
		mValues.clear();
		mValues.addAll(models);
		notifyDataSetChanged();
	}
}
