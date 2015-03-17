package com.android.tonight8.activity.org;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.os.Handler;

import com.android.tonight8.R;
import com.android.tonight8.adapter.org.UserFeedbackAdapter;
import com.android.tonight8.base.BaseActivity;
import com.android.tonight8.io.HandlerConstants;
import com.android.tonight8.model.common.Org;
import com.android.tonight8.model.common.Question;
import com.android.tonight8.model.common.User;
import com.android.tonight8.model.organization.OrgQuestionModel;
import com.android.tonight8.storage.org.OrgStorage;
import com.android.tonight8.view.xlistview.XListView;
import com.lidroid.xutils.view.annotation.ViewInject;

/**
 * @Description:用户反馈(商家询问列表)
 * @author LiuZhao
 * @Date2014-12-29 下午11:37:38
 */
public class UserFeedbackActivity extends BaseActivity {

	/** 用户反馈列表 */
	@ViewInject(R.id.lv_only_list)
	private XListView lv_only_list;
	/** 用户反馈数据适配器 */
	private UserFeedbackAdapter listAdapter;
	/** 商家咨询 */
	private List<OrgQuestionModel> list;
	/** 当前展示的页数 */
	private int current = 0;
	/** 每页显示的条数 */
	private final int ITEM_COUNT = 10;
	/** 下拉刷新标识 */
	private final int REFRESH = 1;
	/** 上拉加载标识 */
	private final int LOAD_MORE = 2;
	/** 首次加载标识 */
	private final int INIT = 3;
	private Handler handler = new Handler() {

		@Override
		public void handleMessage(android.os.Message msg) {
			switch (msg.arg1) {
			case HandlerConstants.RESULT_OK:
				if (msg.obj == null)
					return;
				List<OrgQuestionModel> data = (List<OrgQuestionModel>) msg.obj;
				if (msg.arg2 == INIT) {
					if (data == null || data.size() < ITEM_COUNT)
						lv_only_list.setPullLoadEnable(false);
					else
						lv_only_list.setPullLoadEnable(true);
					listAdapter = new UserFeedbackAdapter(mContext, data);
					lv_only_list.setAdapter(listAdapter);
				} else if (msg.arg2 == REFRESH) {

					if (data == null || data.size() < ITEM_COUNT)
						lv_only_list.setPullLoadEnable(false);
					listAdapter.initData(data);
					lv_only_list.stopRefresh();
				} else if (msg.arg2 == LOAD_MORE) {
					if (data == null || data.size() < ITEM_COUNT)
						lv_only_list.setPullLoadEnable(false);
					listAdapter.addData(data);
					lv_only_list.stopLoadMore();
				}
				break;
			case HandlerConstants.NETWORK_BEGIN:

				break;
			case HandlerConstants.NETWORK_END:

				break;
			case HandlerConstants.RESULT_FAIL:
				List<OrgQuestionModel> datafail = (List<OrgQuestionModel>) msg.obj;
				listAdapter.addData(datafail);
				break;
			default:
				break;
			}
			super.handleMessage(msg);
		}

	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		setContentView(R.layout.activity_user_feedback);
		super.onCreate(savedInstanceState);
		getActionBarBase("用户反馈");

		// String orgId = new
		// OrgLoginNativeController(mContext).getOrgLoginInfo();
		// OrgIOController.OrgQuestionsRead(handler, "123", current, ITEM_COUNT
		// * current);
		initData();
	}

	private void initData() {
		list = new ArrayList<OrgQuestionModel>();
		for (int i = 0; i < 12; i++) {
			OrgQuestionModel model = new OrgQuestionModel();
			Question question = new Question();
			question.setContent("官方二个如果");
			question.setId(i);
			question.setToId(0);
			question.setUid(1111);
			question.setOid(2222);

			if (i % 2 == 0) {
				Org org = new Org();
				org.id = 2222;
				org.pic = "http://f.hiphotos.baidu.com/image/pic/item/cdbf6c81800a19d8697b640331fa828ba61e46b8.jpg";
				org.name = "商家用户1";
				question.setToId(i);
				model.setOrg(org);
			} else {
				User user = new User();
				user.name = "测试用户1";
				user.id = 1111;
				user.pic = "http://f.hiphotos.baidu.com/image/pic/item/cdbf6c81800a19d8697b640331fa828ba61e46b8.jpg";
				model.setUser(user);
			}
			model.setQuestion(question);

			list.add(model);
		}
		OrgStorage.getOrgQuestionController().saveOrUpdateData(list, 123);
		list = OrgStorage.getOrgQuestionController().selectData(123, 0,
				current, ITEM_COUNT * current);

		listAdapter = new UserFeedbackAdapter(mContext, list);
		lv_only_list.setAdapter(listAdapter);

	}

}
