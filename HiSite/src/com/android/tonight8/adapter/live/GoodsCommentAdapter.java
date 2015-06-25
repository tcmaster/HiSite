package com.android.tonight8.adapter.live;

import java.util.List;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.android.tonight8.R;
import com.android.tonight8.adapter.BaseListAdapter;
import com.android.tonight8.adapter.ViewHolder;
import com.android.tonight8.dao.model.live.EventGoodServiceMark;

public class GoodsCommentAdapter extends BaseListAdapter<EventGoodServiceMark> {

	public GoodsCommentAdapter(Context context,
			List<EventGoodServiceMark> values) {
		super(context, values);
	}

	@Override
	protected View getItemView(View convertView, int position) {
		EventGoodServiceMark model = mValues.get(position);
		if (convertView == null)
			convertView = mInflater.inflate(R.layout.item_goods_comment, null);
		ImageView iv_live_talk_headpic = ViewHolder.get(convertView,
				R.id.iv_live_talk_headpic);
		TextView tv_live_talk_name = ViewHolder.get(convertView,
				R.id.tv_live_talk_name);
		RatingBar rab_score = ViewHolder.get(convertView, R.id.rab_score);
		TextView tv_live_talk_content = ViewHolder.get(convertView,
				R.id.tv_live_talk_content);
		FrameLayout fg_container = ViewHolder.get(convertView,
				R.id.fg_container);
		GridView gv_more_info = ViewHolder.get(convertView, R.id.gv_more_info);
		RelativeLayout rl_more_info = ViewHolder.get(convertView,
				R.id.rl_more_info);
		TextView tv_time = ViewHolder.get(convertView, R.id.tv_time);
		bmUtils.display(iv_live_talk_headpic, model.getUser().getPic());
		tv_live_talk_name.setText(model.getUser().getName());
		tv_live_talk_content.setText(model.getSignIn().getContent());
		// rab_score.setRating(model.getSignIn().getServiceMark());// 这里需要到时候修改
		rab_score.setRating((float) (Math.random() * 5));
		// rab_score.setVisibility(View.GONE);
		tv_time.setText(model.getSignIn().getTime());
		return convertView;
	}

}
