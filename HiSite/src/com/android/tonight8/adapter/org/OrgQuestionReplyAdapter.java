package com.android.tonight8.adapter.org;

import java.util.List;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.android.tonight8.R;
import com.android.tonight8.adapter.BaseListAdapter;
import com.android.tonight8.adapter.ViewHolder;
import com.android.tonight8.model.organization.OrgQuestionModel;

/**
 * @Description:商家问题回复数据适配器
 * @author:LiuZhao
 * @copyright © soufun.com
 * @Date:2015年1月7日
 */
public class OrgQuestionReplyAdapter extends BaseListAdapter<OrgQuestionModel> {

	public OrgQuestionReplyAdapter(Context context, List<OrgQuestionModel> values) {
		super(context, values);

	}

	@Override
	protected View getItemView(View convertView, int position) {
		if (convertView == null)
			convertView = mInflater.inflate(R.layout.adapter_org_quesition_reply, null);
		TextView tv_repy_name = ViewHolder.get(convertView, R.id.tv_repy_name);
		TextView tv_repy_content = ViewHolder.get(convertView, R.id.tv_repy_content);
		OrgQuestionModel model = mValues.get(position);
		if (model.getOrg() != null) {
			tv_repy_name.setText(model.getOrg().name);
		} else if (model.getUser() != null) {
			tv_repy_name.setText(model.getUser().name);
		}
		tv_repy_content.setText(model.getQuestion().content);
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
