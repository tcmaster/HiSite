/**
 * 2015-1-28
 */
package com.android.tonight8.activity.user;

import android.os.Bundle;

import com.android.tonight8.R;
import com.android.tonight8.adapter.user.UserApplyHistoryAdapter;
import com.android.tonight8.base.BaseActivity;
import com.android.tonight8.view.XListView;
import com.lidroid.xutils.view.annotation.ViewInject;

/**
 * @Description:用户抽奖历史记录列表
 * @author:LiXiaoSong
 * @copyright @HiSite
 * @Date:2015-1-28
 */
public class UserApplyHistoryActivity extends BaseActivity {

	@ViewInject(R.id.lv_only_list)
	private XListView lv_apply_history;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		setContentView(R.layout.activity_only_list);
		super.onCreate(savedInstanceState);
		initDatas();
	}

	private void initDatas() {
		getActionBarBase("我参加过的抽奖活动");
		lv_apply_history.setAdapter(new UserApplyHistoryAdapter(this, null));
	}
}
