package com.android.tonight8.adapter.wish;

import java.util.List;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.android.tonight8.R;
import com.android.tonight8.adapter.BaseListAdapter;
import com.android.tonight8.adapter.ViewHolder;
import com.android.tonight8.model.ActionItem;
import com.android.tonight8.model.wish.SubjectListModel;
import com.android.tonight8.utils.Utils;
import com.android.tonight8.view.CircleImageView;
import com.android.tonight8.view.CommitPopup;
import com.android.tonight8.view.CommitPopup.onPostClick;
import com.android.tonight8.view.TitlePopup;
import com.android.tonight8.view.TitlePopup.OnItemOnClickListener;

/**
 * @author lz 心愿讨论区数据适配器
 * 
 */
public class WishTalkAdapter extends BaseListAdapter<SubjectListModel> {
	/**赞成和评论按钮弹出框*/
	private TitlePopup titlePopup;
	/**评论提交弹出框*/
	private CommitPopup commitPopup;

	public WishTalkAdapter(Context context, List<SubjectListModel> values) {
		super(context, values);
		titlePopup = new TitlePopup(mContext, Utils.dip2px(context, 165),
				Utils.dip2px(context, 40));
		titlePopup.addAction(new ActionItem(mContext, "赞",
				R.drawable.ic_launcher));
		titlePopup.addAction(new ActionItem(mContext, "评论",
				R.drawable.ic_launcher));

	}

	@Override
	protected View getItemView(View convertView, final int position) {
		convertView = mInflater.inflate(R.layout.adapter_wish_talk_item, null);
		final CheckBox cb_talk_dialog = ViewHolder.get(convertView,
				R.id.cb_talk_dialog);
		CircleImageView iv_wish_talk_headpic = ViewHolder.get(convertView,
				R.id.iv_wish_talk_headpic);
		TextView tv_wish_talk_name = ViewHolder.get(convertView,
				R.id.tv_wish_talk_name);
		TextView tv_wish_talk_time = ViewHolder.get(convertView,
				R.id.tv_wish_talk_time);
		TextView tv_wish_talk_content = ViewHolder.get(convertView,
				R.id.tv_wish_talk_content);

		SubjectListModel subjectListModel = new SubjectListModel();
		subjectListModel = mValues.get(position);
		bmUtils.display(iv_wish_talk_headpic, subjectListModel.getUser()
				.getPic());
		tv_wish_talk_name.setText(subjectListModel.getUser().getName());
		tv_wish_talk_time.setText(subjectListModel.getSubject().getDate()
				+ subjectListModel.getSubject().getTime());
		tv_wish_talk_content
				.setText(subjectListModel.getSubject().getContent());
		cb_talk_dialog.setTag(position);
		cb_talk_dialog.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Utils.toast(((Integer) v.getTag()) + "测试第几个");
				titlePopup.show(v, cb_talk_dialog);
			}
		});
		cb_talk_dialog.setTag(position);
		titlePopup.setItemOnClickListener(new OnItemOnClickListener() {

			@Override
			public void onItemClick(View v, View itemPosView, ActionItem item,
					int position) {
				if (position == 1) {
					commitPopup.show(v, itemPosView);
				} else {
					Utils.toast(((Integer) itemPosView.getTag()) + "赞+1");
				}
			}
		});
		commitPopup = new CommitPopup(mContext, LayoutParams.MATCH_PARENT,
				Utils.dip2px(mContext, 40));
		commitPopup.setPostClick(new onPostClick() {

			@Override
			public void onButtonClick(View v, View itemPosView,
					EditText et_commit) {
				Utils.toast("第" + ((Integer) itemPosView.getTag()) + "个");
			}
		});
		return convertView;
	}

	/**
	 * 增加数据源
	 * 
	 * @param models
	 */
	public void addData(List<SubjectListModel> models) {
		mValues.addAll(models);
		notifyDataSetChanged();
	}

	/**
	 * 重置数据源
	 * 
	 * @param models
	 */
	public void initData(List<SubjectListModel> models) {
		mValues.clear();
		mValues.addAll(models);
		notifyDataSetChanged();
	}

}
