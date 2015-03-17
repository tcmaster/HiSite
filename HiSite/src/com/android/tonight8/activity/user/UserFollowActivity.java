/**
 * 2015-1-28
 */
package com.android.tonight8.activity.user;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import com.android.tonight8.R;
import com.android.tonight8.adapter.user.UserFollowAdapter;
import com.android.tonight8.base.BaseActivity;
import com.android.tonight8.view.xlistview.XListView;
import com.lidroid.xutils.view.annotation.ViewInject;

/**
 * @Description:用户关注列表
 * @author:LiXiaoSong
 * @copyright @HiSite
 * @Date:2015-1-28
 */
public class UserFollowActivity extends BaseActivity {

	@ViewInject(R.id.lv_only_list)
	XListView lv_i_follow;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		setContentView(R.layout.activity_only_list);
		super.onCreate(savedInstanceState);
		initDatas();
	}

	private void initDatas() {
		getActionBarBase("我关注的商家");
		View view = LayoutInflater.from(this).inflate(R.layout.header_i_follow, null);
		lv_i_follow.addExtraHeaderView(view);
		lv_i_follow.setAdapter(new UserFollowAdapter(this, null));
	}
}
