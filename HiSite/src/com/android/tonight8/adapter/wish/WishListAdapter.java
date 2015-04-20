package com.android.tonight8.adapter.wish;

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
import com.android.tonight8.utils.Utils;
import com.android.tonight8.view.MyProgressBar;

/**
 * @author lz愿望列表
 * 
 */
public class WishListAdapter extends BaseListAdapter<String> {

	public WishListAdapter(Context context, List<String> values) {
		super(context, values);

	}

	@Override
	protected View getItemView(View convertView, int position) {
		if (convertView == null) {
			convertView = mInflater.inflate(R.layout.adapter_wish_list, null);
		}
		ImageView iv_wishpic = ViewHolder.get(convertView, R.id.iv_wishpic);
		TextView tv_wishtitle = ViewHolder.get(convertView, R.id.tv_wishtitle);
		TextView tv_wishcontent = ViewHolder.get(convertView, R.id.tv_wishcontent);
		ImageView iv_wish_userpic = ViewHolder.get(convertView, R.id.iv_wish_userpic);
		TextView tv_wish_username = ViewHolder.get(convertView, R.id.tv_wish_username);
		TextView tv_wish_supportcount = ViewHolder.get(convertView, R.id.tv_wish_supportcount);
		MyProgressBar pb_wish_progress = ViewHolder.get(convertView, R.id.pb_wish_progress);
		tv_wishtitle.setText("标题测试");
		tv_wishcontent.setText("内容测试:各种好各种好各种好");
		tv_wish_username.setText("用户姓名测试");
		tv_wish_supportcount.setText("1234");
		Tonight8App.getSelf().bitmapUtils
				.display(iv_wishpic, "http://pica.nipic.com/2007-12-22/2007122215556437_2.jpg");
		Tonight8App.getSelf().bitmapUtils.display(iv_wish_userpic,
				"http://pica.nipic.com/2007-12-22/2007122215556437_2.jpg");
		pb_wish_progress.setProgress(20);
		tv_wish_supportcount.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				Utils.toast("支持+1");

			}
		});
		// iv_wishpic.setOnClickListener(new OnClickListener() {
		//
		// @Override
		// public void onClick(View arg0) {
		// mContext.startActivity(new Intent(mContext, WishLiveActivity.class));
		// }
		// });
		return convertView;
	}

}
