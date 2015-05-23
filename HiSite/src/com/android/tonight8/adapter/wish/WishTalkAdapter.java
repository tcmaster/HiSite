package com.android.tonight8.adapter.wish;

import java.util.List;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.tonight8.R;
import com.android.tonight8.adapter.BaseListAdapter;
import com.android.tonight8.adapter.ViewHolder;

/**
 * @author lz 心愿讨论区数据适配器
 * 
 */
public class WishTalkAdapter extends BaseListAdapter<String> {

	public WishTalkAdapter(Context context, List<String> values) {
		super(context, values);

	}

	@Override
	protected View getItemView(View convertView, int position) {
		convertView = mInflater.inflate(R.layout.adapter_wish_talk_item, null);
		EditText et_wishname = ViewHolder.get(convertView, R.id.et_wishname);
		LinearLayout ll_talk_comment_left = ViewHolder.get(convertView,
				R.id.ll_talk_comment_left);
		TextView tv_talk_dialog = ViewHolder.get(convertView,
				R.id.tv_talk_dialog);
		ll_talk_comment_left.setTag(position);
		tv_talk_dialog.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
			}
		});
		return convertView;
	}

}
