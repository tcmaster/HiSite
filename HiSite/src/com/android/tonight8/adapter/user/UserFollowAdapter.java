/**
 * 2015-1-28
 */
package com.android.tonight8.adapter.user;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.android.tonight8.R;
import com.android.tonight8.adapter.BaseListAdapter;
import com.android.tonight8.model.common.Question;
import com.android.tonight8.model.user.UserFollowModel;
import com.android.tonight8.view.ListViewForScrollView;

/**
 * @Description:用户关注列表
 * @author:LiXiaoSong
 * @copyright @HiSite
 * @Date:2015-1-28
 */
public class UserFollowAdapter extends BaseListAdapter<UserFollowModel> {

	/** 记录了当前的询问列表是否显示 */
	private List<Boolean> isHideInfos;

	public UserFollowAdapter(Context context, List<UserFollowModel> values) {
		super(context, values);
		isHideInfos = new ArrayList<Boolean>();
		for (int i = 0; i < 20; i++) {// 初始化询问列表的情况
			isHideInfos.add(false);
		}
	}

	@Override
	public int getCount() {
		return 20;
	}

	@Override
	public void notifyDataSetChanged() {
		// 更新数据时，重置显隐列表
		isHideInfos = new ArrayList<Boolean>();
		for (int i = 0; i < mValues.size(); i++) {// 初始化询问列表的情况
			isHideInfos.add(false);
		}
		super.notifyDataSetChanged();
	}

	@Override
	protected View getItemView(View convertView, int position) {
		ViewHolder holder = null;
		final int pos = position;
		// UserFollowModel model = mValues.get(position);
		if (convertView == null) {
			convertView = mInflater.inflate(R.layout.item_i_follow, null);
			holder = new ViewHolder();
			holder.iv_com_logo = (ImageView) convertView.findViewById(R.id.iv_com_logo);
			holder.tv_com_distance = (TextView) convertView.findViewById(R.id.tv_com_distance);
			holder.tv_com_phone = (TextView) convertView.findViewById(R.id.tv_com_phone);
			holder.tv_com_location = (TextView) convertView.findViewById(R.id.tv_com_location);
			holder.tv_com_name = (TextView) convertView.findViewById(R.id.tv_com_name);
			holder.tv_consult = (TextView) convertView.findViewById(R.id.tv_consult);
			holder.lv_consult_content = (ListViewForScrollView) convertView.findViewById(R.id.lv_consult_content);
			// 添加一个空的适配器
			holder.lv_consult_content.setAdapter(new UserFollowConsultContentAdapter(mContext));
			convertView.setTag(holder);
		} else
			holder = (ViewHolder) convertView.getTag();
		if (isHideInfos.get(position))
			holder.lv_consult_content.setVisibility(View.VISIBLE);
		else
			holder.lv_consult_content.setVisibility(View.GONE);
		final ListView lv_consult_content = holder.lv_consult_content;
		lv_consult_content.setTag(position);// 绑定当前布局位置，用于检测该布局是否被重用
		holder.tv_consult.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				if (isHideInfos.get(pos)) {
					// 显示的话，点击后对该视图进行隐藏
					lv_consult_content.setVisibility(View.GONE);
					isHideInfos.set(pos, false);
				} else {
					// 之前隐藏的话，点击获取最新数据，进行显示
					List<Question> datas = new ArrayList<Question>();
					datas.add(new Question());
					datas.add(new Question());
					datas.add(new Question());
					((UserFollowConsultContentAdapter) lv_consult_content.getAdapter()).bindData(datas);
					lv_consult_content.setVisibility(View.VISIBLE);
					isHideInfos.set(pos, true);
				}
			}
		});
		return convertView;
	}

	private class ViewHolder {

		ImageView iv_com_logo;// 公司图片
		TextView tv_com_name;// 公司名称
		TextView tv_com_location; // 公司地址
		TextView tv_com_phone;// 公司电话
		TextView tv_com_distance;// 公司距离
		TextView tv_consult;// 询问
		ListViewForScrollView lv_consult_content;// 询问内容列表
	}
}
