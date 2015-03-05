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
	/** 兑奖时间 */
	private TextView tv_exchange_time;
	/** 兑奖方式 */
	private TextView tv_exchange_way;
	/** 查看兑奖地址 */
	private TextView tv_see_exchange_location;
	/** 中奖人数显示 */
	private TextView tv_award_count;

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
		tv_event_name = (TextView) view.findViewById(R.id.tv_event_name);
		iv_popgoods_icon = (ImageView) view.findViewById(R.id.iv_popgoods_icon);
		tv_org_name = (TextView) view.findViewById(R.id.tv_org_name);
		tv_info = (TextView) view.findViewById(R.id.tv_info);
		tv_value = (TextView) view.findViewById(R.id.tv_value);
		tv_exchange_time = (TextView) view.findViewById(R.id.tv_exchange_time);
		tv_exchange_way = (TextView) view.findViewById(R.id.tv_exchange_way);
		tv_see_exchange_location = (TextView) view.findViewById(R.id.tv_see_exchange_location);
		tv_award_count = (TextView) view.findViewById(R.id.tv_award_count);
		tv_event_name.setText("小米公司免费送手机");
		tv_org_name.setText("北京俏江南国贸店");
		tv_info.setText("红米note/限量5部/已有457人报名");
		tv_value.setText("¥699");
		tv_exchange_time.setText("兑奖时间:2015-02-20至03-15");
		tv_exchange_way.setText("兑奖方式:到店领取");
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
