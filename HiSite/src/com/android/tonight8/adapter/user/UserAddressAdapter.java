/**
 * 2015-2-25
 */
package com.android.tonight8.adapter.user;

import java.util.List;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

import com.android.tonight8.R;
import com.android.tonight8.activity.user.EditReceiveAddressActivity;
import com.android.tonight8.adapter.BaseListAdapter;
import com.android.tonight8.model.common.User;

/**
 * @Description:用户地址管理适配器
 * @author:LiXiaoSong
 * @copyright @HiSite
 * @Date:2015-2-25
 */
public class UserAddressAdapter extends BaseListAdapter<User> {

	public UserAddressAdapter(Context context, List<User> values) {
		super(context, values);
	}

	@Override
	protected View getItemView(View convertView, int position) {
		ViewHolder holder = null;
		if (convertView == null) {
			convertView = mInflater.inflate(R.layout.item_user_address, null);
			holder = new ViewHolder();
			holder.tv_address = (TextView) convertView.findViewById(R.id.tv_address);
			holder.tv_name_and_phone = (TextView) convertView.findViewById(R.id.tv_name_and_phone);
			holder.tv_edit = (TextView) convertView.findViewById(R.id.tv_edit);
			holder.tv_delete = (TextView) convertView.findViewById(R.id.tv_delete);
			convertView.setTag(holder);
		} else
			holder = (ViewHolder) convertView.getTag();
		holder.tv_edit.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(mContext, EditReceiveAddressActivity.class);
				mContext.startActivity(intent);
			}
		});
		return convertView;
	}

	private class ViewHolder {

		TextView tv_name_and_phone;// 用户的姓名和电话
		TextView tv_address;// 用户的地址
		TextView tv_edit;// 编辑按钮
		TextView tv_delete;// 删除按钮
	}

}
