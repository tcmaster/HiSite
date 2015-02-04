package com.android.tonight8.activity.createevent;

import android.os.Bundle;
import android.widget.ListView;

import com.android.tonight8.R;
import com.android.tonight8.base.BaseActivity;
import com.lidroid.xutils.view.annotation.ViewInject;

/**
 * @Description:用户反馈
 * @author LiuZhao
 * @Date2014-12-29 下午11:37:38
 */
public class UserFeedbacktActivity extends BaseActivity {
	/** 用户反馈列表*/
	@ViewInject(R.id.lv_only_list)
	private ListView lv_only_list;
//	private 

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_user_comment);
	}

}
