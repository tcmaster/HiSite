package com.android.tonight8.activity.event;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.tonight8.R;
import com.android.tonight8.adapter.event.EventAwardAdapter;
import com.android.tonight8.base.BaseActivity;
import com.android.tonight8.view.XListView;
import com.lidroid.xutils.view.annotation.ViewInject;

/**
 * 活动兑奖名单
 * 
 * @author LiXiaoSong
 * 
 */
public class EventAwardActivity extends BaseActivity {

	// ***************************控件成员***********************************//
	// 头部内容
	/** 活动名称 */
	private TextView tv_event_name;
	/** 奖品海报 */
	private ImageView iv_popgoods_icon;
	/** 公司名称 */
	private TextView tv_org_name;
	/** 附加信息 */
	private TextView tv_info;
	/** 奖品价值 */
	private TextView tv_value;

	// 头部内容end
	/** 中奖名单列表 */
	@ViewInject(R.id.lv_award_or_exchange)
	private XListView lv_award;

	// ***************************其他成员***********************************//
	// ***************************生命周期,回调方法***********************************//
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		setContentView(R.layout.activity_event_award_or_exchange);
		super.onCreate(savedInstanceState);
		initHeaderView();
		getActionBarBase("领奖地址");
		initData();
	}

	// ***************************子方法***********************************//
	private void initHeaderView() {
		View view = (View) LayoutInflater.from(this).inflate(R.layout.header_award_or_exchange, null);
		lv_award.addExtraHeaderView(view);
	}

	private void initData() {
		List<String> data = new ArrayList<String>();
		data.add("");
		data.add("");
		data.add("");
		lv_award.setAdapter(new EventAwardAdapter(this, data));
	}

}
