package com.android.tonight8.adapter.live;

import java.util.List;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.tonight8.R;
import com.android.tonight8.adapter.BaseListAdapter;
import com.android.tonight8.model.live.LiveCommentModel;
import com.lidroid.xutils.BitmapUtils;

/**
 * @Description:Hi现场话题评论的数据列表适配器
 * @author:LiuZhao
 * @Date:2015年1月15日
 */
public class LiveListCommentAdapter extends BaseListAdapter<LiveCommentModel> {

	private BitmapUtils bmUtils;

	public LiveListCommentAdapter(Context context, List<LiveCommentModel> values) {
		super(context, values);
		bmUtils = new BitmapUtils(context);
	}

	@Override
	protected View getItemView(View convertView, int position) {
		ViewHolder holder;
		if (convertView == null) {
			holder = new ViewHolder();
			convertView = mInflater.inflate(R.layout.adapter_live_comment_item,
					null);
			holder.iv_head = (ImageView) convertView
					.findViewById(R.id.iv_live_comment_headpic);
			holder.tv_name = (TextView) convertView
					.findViewById(R.id.tv_live_comment_name);
			holder.tv_date = (TextView) convertView
					.findViewById(R.id.tv_live_comment_date);
			holder.tv_content = (TextView) convertView
					.findViewById(R.id.tv_live_comment_content);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		LiveCommentModel list = mValues.get(position);
		bmUtils.display(holder.iv_head, list.getUser().pic);
		holder.tv_name.setText(list.getUser().name);
		holder.tv_date.setText(list.getComment().getDate()
				+ list.getComment().getTime());
		holder.tv_content.setText(list.getComment().content);
		return convertView;
	}

	class ViewHolder {

		/** 头像 */
		ImageView iv_head;
		/** 标题 */
		TextView tv_name;
		/** 日期时间 */
		TextView tv_date;
		/** 内容 */
		TextView tv_content;

	}
}
