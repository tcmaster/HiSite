package com.android.tonight8.adapter.live;

import java.util.List;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.tonight8.R;
import com.android.tonight8.adapter.BaseListAdapter;
import com.android.tonight8.model.common.Comment;
import com.lidroid.xutils.BitmapUtils;

/**
 * @Description:Hi现场话题的数据列表适配器
 * @author:LiuZhao
 * @copyright © soufun.com
 * @Date:2015年1月15日
 */
public class SubjectListAdapter extends BaseListAdapter<Comment> {

	private BitmapUtils bmUtils;

	public SubjectListAdapter(Context context, List<Comment> values) {
		super(context, values);
		bmUtils = new BitmapUtils(context);
	}

	@Override
	protected View getItemView(View convertView, int position) {
		ViewHolder holder;
		if (convertView == null) {
			holder = new ViewHolder();
			convertView = mInflater.inflate(R.layout.adapter_subject_item, null);
			holder.iv_subject_head = (ImageView) convertView.findViewById(R.id.iv_subject_head);
			holder.tv_subject_title = (TextView) convertView.findViewById(R.id.tv_subject_title);
			holder.tv_subject_date = (TextView) convertView.findViewById(R.id.tv_subject_date);
			holder.tv_subject_content = (TextView) convertView.findViewById(R.id.iv_camera_icon);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		bmUtils.display(holder.iv_subject_head, "");
		holder.tv_subject_date.setText(mValues.get(position).getDate());

		return convertView;
	}

	class ViewHolder {

		/** 头像 */
		ImageView iv_subject_head;
		/** 标题 */
		TextView tv_subject_title;
		/** 日期时间 */
		TextView tv_subject_date;
		/** 内容 */
		TextView tv_subject_content;

	}
}
