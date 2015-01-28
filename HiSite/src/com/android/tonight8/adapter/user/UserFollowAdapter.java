/**
 * 2015-1-28
 */
package com.android.tonight8.adapter.user;

import java.util.List;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.android.tonight8.R;
import com.android.tonight8.adapter.BaseListAdapter;
import com.android.tonight8.model.user.UserFollowModel;

/**
 * @Description:用户关注列表
 * @author:LiXiaoSong
 * @copyright @HiSite
 * @Date:2015-1-28
 */
public class UserFollowAdapter extends BaseListAdapter<UserFollowModel> {

	public UserFollowAdapter(Context context, List<UserFollowModel> values) {
		super(context, values);
	}

	@Override
	public int getCount() {
		return 4;
	}

	@Override
	protected View getItemView(View convertView, int position) {
		ViewHolder holder = null;
		if (convertView == null) {
			convertView = mInflater.inflate(R.layout.item_i_follow, null);
			holder = new ViewHolder();
			holder.iv_com_logo = (ImageView) convertView.findViewById(R.id.iv_com_logo);
			holder.tv_com_distance = (TextView) convertView.findViewById(R.id.tv_com_distance);
			holder.tv_com_phone = (TextView) convertView.findViewById(R.id.tv_com_phone);
			holder.tv_com_location = (TextView) convertView.findViewById(R.id.tv_com_location);
			holder.tv_com_name = (TextView) convertView.findViewById(R.id.tv_com_name);
			holder.tv_consult = (TextView) convertView.findViewById(R.id.tv_consult);
			holder.lv_consult_content = (ListView) convertView.findViewById(R.id.lv_consult_content);
			convertView.setTag(holder);
		} else
			holder = (ViewHolder) convertView.getTag();
		return convertView;
	}

	private class ViewHolder {

		ImageView iv_com_logo;// 公司图片
		TextView tv_com_name;// 公司名称
		TextView tv_com_location; // 公司地址
		TextView tv_com_phone;// 公司电话
		TextView tv_com_distance;// 公司距离
		TextView tv_consult;// 询问
		ListView lv_consult_content;// 询问内容列表
	}

}
