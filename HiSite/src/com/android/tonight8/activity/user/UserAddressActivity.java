/**
 * 2015-2-15
 */
package com.android.tonight8.activity.user;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;

import com.android.tonight8.R;
import com.android.tonight8.adapter.user.UserAddressAdapter;
import com.android.tonight8.base.BaseActivity;
import com.android.tonight8.model.common.User;
import com.android.tonight8.view.xlistview.XListView;
import com.lidroid.xutils.view.annotation.ViewInject;

/**
 * @Description:用户地址管理界面
 * @author:LiXiaoSong
 * @copyright @HiSite
 * @Date:2015-2-15
 */
public class UserAddressActivity extends BaseActivity {

	@ViewInject(R.id.lv_only_list)
	XListView lv_only_list;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		setContentView(R.layout.activity_only_list);
		super.onCreate(savedInstanceState);
		initDatas();
	}

	private void initDatas() {
		getActionBarBase("地址管理");
		List<User> testData = new ArrayList<User>();
		testData.add(new User());
		testData.add(new User());
		testData.add(new User());
		lv_only_list.setAdapter(new UserAddressAdapter(this, testData));
	}
}
