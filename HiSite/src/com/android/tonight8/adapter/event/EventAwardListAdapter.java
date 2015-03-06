package com.android.tonight8.adapter.event;

import java.util.List;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.tonight8.R;
import com.android.tonight8.adapter.BaseListAdapter;
import com.android.tonight8.adapter.ViewHolder;
import com.android.tonight8.base.Tonight8App;
import com.android.tonight8.model.manageevent.ManageAwardModel;
import com.android.tonight8.utils.IntentUtils;

/**
 * @Description：活动中奖名单
 * @date 2015-3-5下午9:49:37
 * @author liuzhao
 */
public class EventAwardListAdapter extends BaseListAdapter<ManageAwardModel> {

	/** 签到选中颜色 */
	private int signColor = R.color.orange;

	public EventAwardListAdapter(Context context, List<ManageAwardModel> values) {
		super(context, values);

	}

	private OnClickListener onClickListener = new OnClickListener() {

		@Override
		public void onClick(View arg0) {
			int pos = (Integer) arg0.getTag();
			if (mValues.size() > pos && mValues.get(pos).getUser() != null) {
				IntentUtils.showListDialog(mContext, mValues.get(pos).getUser().mobilePhone);
			}

		}
	};

	@Override
	protected View getItemView(View convertView, int position) {

		if (convertView == null)
			convertView = mInflater.inflate(R.layout.adapter_event_award_list_item, null, false);

		ImageView iv_awarduser_headpic = ViewHolder.get(convertView, R.id.iv_awarduser_headpic);
		TextView tv_award_user_name = ViewHolder.get(convertView, R.id.tv_award_user_name);
		TextView tv_award_code = ViewHolder.get(convertView, R.id.tv_award_code);
		TextView tv_user_contact = ViewHolder.get(convertView, R.id.tv_user_contact);
		TextView tv_event_award_telephone = ViewHolder.get(convertView, R.id.tv_event_award_telephone);
		TextView tv_event_award_address = ViewHolder.get(convertView, R.id.tv_event_award_address);
		TextView tv_award_sended_line = ViewHolder.get(convertView, R.id.tv_award_sended_line);
		TextView tv_award_signin_line = ViewHolder.get(convertView, R.id.tv_award_signin_line);
		TextView tv_award_sended = ViewHolder.get(convertView, R.id.tv_award_sended);
		TextView tv_award_signin = ViewHolder.get(convertView, R.id.tv_award_signin);
		ManageAwardModel model = mValues.get(position);
		if (model != null) {
			Tonight8App.getSelf().bitmapUtils.display(iv_awarduser_headpic, model.getUser().pic);
			tv_award_user_name.setText(model.getUser().name);
			tv_award_code.setText(model.getAward().getCode());
			tv_event_award_telephone.setText(model.getUser().mobilePhone);
			tv_event_award_address.setText(model.getUser().address);
			if (model.getAward().signInStatus == 1) {
				tv_award_sended_line.setBackgroundColor(signColor);
				tv_award_sended.setTextColor(signColor);
			} else if (model.getAward().signInStatus == 2) {
				tv_award_signin_line.setBackgroundColor(signColor);
				tv_award_signin.setTextColor(signColor);
			}

		}
		tv_user_contact.setOnClickListener(onClickListener);

		return convertView;
	}
	/**
	 * 增加数据源
	 * 
	 * @param models
	 */
	public void addData(List<ManageAwardModel> models) {
		mValues.addAll(models);
		notifyDataSetChanged();
	}

	/**
	 * 重置数据源
	 * 
	 * @param models
	 */
	public void initData(List<ManageAwardModel> models) {
		mValues.clear();
		mValues.addAll(models);
		notifyDataSetChanged();
	}
}
