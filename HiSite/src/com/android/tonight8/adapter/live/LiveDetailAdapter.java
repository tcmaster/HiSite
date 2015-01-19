package com.android.tonight8.adapter.live;

import java.util.List;

import android.content.Context;
import android.view.View;

import com.android.tonight8.R;
import com.android.tonight8.adapter.BaseListAdapter;
import com.android.tonight8.model.live.LiveDetailModel;

/**
 * @Description:活动详情列表的数据适配器
 * @author:LiuZhao
 * @Date:2015年1月16日
 */
public class LiveDetailAdapter extends BaseListAdapter<LiveDetailModel> {

	public LiveDetailAdapter(Context context, List<LiveDetailModel> values) {
		super(context, values);
	}

	@Override
	protected View getItemView(View convertView, int position) {
		ViewHolder holder = null;
		if (convertView == null) {
			convertView = mInflater.inflate(R.layout.adapter_list_detail, null, false);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}

		return convertView;
	}

	public class ViewHolder {

	}

}
