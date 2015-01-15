package com.android.tonight8.activity.event;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.tonight8.R;
import com.android.tonight8.adapter.event.EventExchangeAdapter;
import com.android.tonight8.base.BaseActivity;
import com.android.tonight8.view.XListView;
import com.lidroid.xutils.view.annotation.ViewInject;

/**
 * 活动兑奖地址
 * 
 * @author LiXiaoSong
 * 
 */
public class EventExchangeActivity extends BaseActivity {
	// ***************************控件成员***********************************//
	// 头部内容
	/** 活动名称 */
	private TextView tv_event_name;
	/** 奖品相关 */
	private TextView tv_pop_goods;
	/** 奖品图片 */
	private ImageView iv_pop_goods_pic;
	/** 中奖名额 */
	private TextView tv_provide_num;
	/** 优惠券 */
	private TextView tv_coupon;
	/** 报名数量 */
	private TextView tv_apply_count;
	/** 公司名称 */
	private TextView tv_org_name;
	/** 上架时间 */
	private TextView tv_added_time;
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
		initData();
	}

	// ***************************子方法***********************************//
	private void initHeaderView() {
		View view = (View) LayoutInflater.from(this).inflate(
				R.layout.header_award_or_exchange, null);
		tv_event_name = (TextView) view.findViewById(R.id.tv_event_name);
		tv_pop_goods = (TextView) view.findViewById(R.id.tv_pop_goods);
		iv_pop_goods_pic = (ImageView) view.findViewById(R.id.iv_pop_goods_pic);
		tv_provide_num = (TextView) view.findViewById(R.id.tv_provide_num);
		tv_coupon = (TextView) view.findViewById(R.id.tv_coupon);
		tv_org_name = (TextView) view.findViewById(R.id.tv_org_name);
		tv_added_time = (TextView) view.findViewById(R.id.tv_added_time);
		lv_award.addExtraHeaderView(view);
	}

	private void initData() {
		List<String> data = new ArrayList<String>();
		data.add("");
		data.add("");
		data.add("");
		lv_award.setAdapter(new EventExchangeAdapter(this, data));
	}
}
