package com.android.tonight8.adapter.org;

import java.util.List;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.tonight8.R;
import com.android.tonight8.activity.org.UserFeedbackActivity;
import com.android.tonight8.adapter.BaseListAdapter;
import com.android.tonight8.adapter.ViewHolder;
import com.android.tonight8.model.organization.OrgMessageModel;
import com.android.tonight8.model.organization.OrgQuestionModel;
import com.android.tonight8.utils.DialogUtils;

/**
 * @Description:用户反馈数据适配器
 * @author:LiuZhao
 * @copyright © soufun.com
 * @Date:2015年1月7日
 */
public class UserFeedbackAdapter extends BaseListAdapter<OrgQuestionModel> {

	public UserFeedbackAdapter(Context context, List<OrgQuestionModel> values) {
		super(context, values);

	}

	private OnClickListener replyListener = new OnClickListener() {

		@Override
		public void onClick(View arg0) {
			DialogUtils.showCommitDialog((UserFeedbackActivity) mContext,
					"给**用户回复");
		}
	};

	@Override
	protected View getItemView(View convertView, int position) {
		if (convertView == null)
			convertView = mInflater.inflate(R.layout.adapter_user_feedback,
					null);
		ImageView iv_comment_head_icon = ViewHolder.get(convertView,
				R.id.iv_comment_head_icon);
		TextView tv_commentadapter_title = ViewHolder.get(convertView,
				R.id.tv_commentadapter_title);
		TextView tv_commentadapter_date = ViewHolder.get(convertView,
				R.id.tv_commentadapter_date);
		TextView tv_commentadapter_content = ViewHolder.get(convertView,
				R.id.tv_commentadapter_content);
		TextView tv_commentadapter_placetime = ViewHolder.get(convertView,
				R.id.tv_commentadapter_placetime);
		Button btn_reply = ViewHolder.get(convertView, R.id.btn_feedback_reply);

		btn_reply.setOnClickListener(replyListener);
		return convertView;
	}

	/**
	 * 增加数据源
	 * 
	 * @param models
	 */
	public void addData(List<OrgQuestionModel> models) {
		mValues.addAll(models);
		notifyDataSetChanged();
	}

	/**
	 * 重置数据源
	 * 
	 * @param models
	 */
	public void initData(List<OrgQuestionModel> models) {
		mValues.clear();
		mValues.addAll(models);
		notifyDataSetChanged();
	}
}
