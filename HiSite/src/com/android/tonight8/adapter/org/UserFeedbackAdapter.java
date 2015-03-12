package com.android.tonight8.adapter.org;

import java.util.Date;
import java.util.List;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.android.tonight8.R;
import com.android.tonight8.activity.org.UserFeedbackActivity;
import com.android.tonight8.adapter.BaseListAdapter;
import com.android.tonight8.adapter.ViewHolder;
import com.android.tonight8.base.Tonight8App;
import com.android.tonight8.io.org.OrgIOController;
import com.android.tonight8.model.organization.OrgQuestionModel;
import com.android.tonight8.storage.org.OrgStorage;
import com.android.tonight8.utils.DateTimeUtils;
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
			TextView tv = (TextView)arg0;
			Integer pos = (Integer) tv.getTag();
			// mValues.get(pos).getQuestion().getId();
			// mValues.get(pos).getQuestion().getContent();
			// mValues.get(pos).getOrg().getId();
			DialogUtils.showCommitDialog((UserFeedbackActivity) mContext,
					"给**用户回复");
			// OrgIOController.OrgOrgQuestionsReply(handler, questionId,
			// content, orgId, attachments);
		}
	};

	@Override
	protected View getItemView(View convertView, int position) {
		if (convertView == null)
			convertView = mInflater.inflate(R.layout.adapter_user_feedback,
					null);
		ImageView iv_comment_head_icon = ViewHolder.get(convertView,
				R.id.iv_comment_head_icon);
		TextView tv_userback_name = ViewHolder.get(convertView,
				R.id.tv_userback_name);
		TextView tv_userback_date = ViewHolder.get(convertView,
				R.id.tv_userback_date);
		TextView tv_userback_content = ViewHolder.get(convertView,
				R.id.tv_userback_content);
		TextView tv_userback_placetime = ViewHolder.get(convertView,
				R.id.tv_userback_placetime);
		TextView tv_feedback_reply = ViewHolder.get(convertView,
				R.id.tv_feedback_reply);
		tv_feedback_reply.setOnClickListener(replyListener);

		ListView lv_org_quesition_reply = ViewHolder.get(convertView,
				R.id.lv_org_quesition_reply);
		OrgQuestionModel model = mValues.get(position);
		List<OrgQuestionModel> list2 = OrgStorage.getOrgQuestionController()
				.selectData(123, model.getQuestion().getToId(), 0, 0);
		UserFeedbackAdapter listAdapter = new UserFeedbackAdapter(mContext,
				list2);
		lv_org_quesition_reply.setAdapter(listAdapter);

		if (model.getOrg() != null) {
			Tonight8App.getSelf().bitmapUtils.display(iv_comment_head_icon,
					model.getOrg().logo);
			tv_userback_name.setText(model.getOrg().name);
		} else if (model.getUser() != null) {
			Tonight8App.getSelf().bitmapUtils.display(iv_comment_head_icon,
					model.getUser().pic);
			tv_userback_name.setText(model.getUser().name);
		}
		tv_userback_date.setText(model.getQuestion().date);
		tv_userback_content.setText(model.getQuestion().content);
		// tv_userback_placetime.setText(DateTimeUtils.getUpdateDate(new
		// Date(model.getQuestion().getDate() +
		// model.getQuestion().getTime())));
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
