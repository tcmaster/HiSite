package com.android.tonight8.activity.live;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.widget.ListView;

import com.android.tonight8.R;
import com.android.tonight8.adapter.live.LiveDetailAdapter;
import com.android.tonight8.base.BaseActivity;
import com.android.tonight8.model.live.LiveDetailModel;
import com.lidroid.xutils.view.annotation.ViewInject;

/**
 * @author liuzhao 活动现场详情
 */
public class LiveDetailActivity extends BaseActivity {
	/** */
	private LiveDetailAdapter liveDetailAdapter;
	/** */
	private List<LiveDetailModel> liveDetailModel;
	/** */
	@ViewInject(R.id.lv_foot_detail)
	private ListView lv_foot_detail;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		setContentView(R.layout.activity_live_detail);
		super.onCreate(savedInstanceState);
		initData();
	}

	private void initData() {
		liveDetailModel = new ArrayList<LiveDetailModel>();
		liveDetailAdapter = new LiveDetailAdapter(mContext, liveDetailModel);
		lv_foot_detail.setAdapter(liveDetailAdapter);
	}

}
