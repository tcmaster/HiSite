package com.android.tonight8.activity.org;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.widget.ListView;

import com.android.tonight8.R;
import com.android.tonight8.adapter.org.UserFeedbackAdapter;
import com.android.tonight8.base.BaseActivity;
import com.android.tonight8.model.organization.OrgQuestionModel;
import com.lidroid.xutils.view.annotation.ViewInject;

/**
 * @Description:用户反馈(用户询问列表)
 * @author LiuZhao
 * @Date2014-12-29 下午11:37:38
 */
public class UserFeedbackActivity extends BaseActivity {

	/** 用户反馈列表 */
	@ViewInject(R.id.lv_only_list)
	private ListView lv_only_list;
	/** 用户反馈数据适配器 */
	private UserFeedbackAdapter userFeedbackAdapter;
	/** 商家咨询 */
	private List<OrgQuestionModel> list;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		setContentView(R.layout.activity_user_feedback);
		super.onCreate(savedInstanceState);
		getActionBarBase("用户反馈");
		initData();
	}

	private void initData() {
		list = new ArrayList<OrgQuestionModel>();
		for (int i = 0; i < 12; i++) {
			OrgQuestionModel model = new OrgQuestionModel();
			list.add(model);
		}
		userFeedbackAdapter = new UserFeedbackAdapter(mContext, list);
		lv_only_list.setAdapter(userFeedbackAdapter);
	}

}
