/**
 * 2015-1-29
 */
package com.android.tonight8.adapter.user;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.android.tonight8.R;
import com.android.tonight8.adapter.BaseListAdapter;
import com.android.tonight8.model.common.Question;

/**
 * @Description: 用户关注里关于询问的适配器
 * @author:LiXiaoSong
 * @copyright @HiSite
 * @Date:2015-1-29
 */
public class UserFollowConsultContentAdapter extends BaseListAdapter<Question> {

	public UserFollowConsultContentAdapter(Context context) {
		super(context);
		mValues = new ArrayList<Question>();

	}

	public UserFollowConsultContentAdapter(Context context, List<Question> values) {
		super(context, values);
	}

	public void bindData(List<Question> datas) {
		mValues.clear();
		for (int i = 0; i < datas.size(); i++) {
			mValues.add(datas.get(i));
		}
		notifyDataSetChanged();
	}

	@Override
	protected View getItemView(View convertView, int position) {
		if (convertView == null) {
			convertView = mInflater.inflate(R.layout.item_consult_content, null);
		}
		TextView tv_content = (TextView) convertView.findViewById(R.id.tv_content);
		tv_content.setText("测试一下");
		return convertView;
	}

}
