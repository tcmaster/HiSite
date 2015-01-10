package com.android.tonight8.adapter;

import java.util.List;

import com.android.tonight8.R;

import android.content.Context;
import android.view.View;

/**
 * @Description:用户评论
 * @author:LiuZhao
 * @copyright © soufun.com
 * @Date:2015年1月7日
 */
public class UserCommentAdapter extends BaseListAdapter {

	public UserCommentAdapter(Context context, List values) {
		super(context, values);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected View getItemView(View convertView, int position) {
		convertView = mInflater.inflate(R.layout.adapter_user_comment, null);
		return convertView;
	}

}
