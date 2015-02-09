package com.android.tonight8.adapter.org;

import java.util.List;

import com.android.tonight8.R;
import com.android.tonight8.adapter.BaseListAdapter;
import com.android.tonight8.model.live.LiveCommentModel;

import android.content.Context;
import android.view.View;

/**
 * @Description:用户反馈数据适配器
 * @author:LiuZhao
 * @copyright © soufun.com
 * @Date:2015年1月7日
 */
public class UserFeedbackAdapter extends BaseListAdapter<LiveCommentModel> {

	public UserFeedbackAdapter(Context context, List<LiveCommentModel> values) {
		super(context, values);

	}

	@Override
	protected View getItemView(View convertView, int position) {
		convertView = mInflater.inflate(R.layout.adapter_user_feedback, null);
		return convertView;
	}

}
