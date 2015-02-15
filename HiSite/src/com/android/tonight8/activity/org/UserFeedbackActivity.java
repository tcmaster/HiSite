package com.android.tonight8.activity.org;

import java.util.List;

import android.os.Bundle;
import android.widget.ListView;

import com.android.tonight8.R;
import com.android.tonight8.adapter.org.UserFeedbackAdapter;
import com.android.tonight8.base.BaseActivity;
import com.android.tonight8.model.live.LiveCommentModel;
import com.lidroid.xutils.view.annotation.ViewInject;

/**
 * @Description:用户反馈
 * @author LiuZhao
 * @Date2014-12-29 下午11:37:38
 */
public class UserFeedbackActivity extends BaseActivity {

	/** 用户反馈列表 */
	@ViewInject(R.id.lv_only_list)
	private ListView lv_only_list;
	/** 用户反馈数据适配器 */
	private UserFeedbackAdapter userFeedbackAdapter;
	private List<LiveCommentModel> liveCommentModels;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		setContentView(R.layout.activity_user_feedback);
		super.onCreate(savedInstanceState);
		getActionBarBase("用户反馈");
	}

	private void initData() {
		userFeedbackAdapter = new UserFeedbackAdapter(mContext, liveCommentModels);
		lv_only_list.setAdapter(userFeedbackAdapter);
	}

}
