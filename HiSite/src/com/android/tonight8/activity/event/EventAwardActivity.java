package com.android.tonight8.activity.event;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.tonight8.R;
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

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_event_award);
		initHeaderView();
	}

	private void initHeaderView() {
		// LayoutInflater.from(this).inflate(R.layout., root)
		// lv_award.addExtraHeaderView(headers)
	}

}
