package com.android.tonight8.activity.createevent;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.android.tonight8.R;
import com.android.tonight8.base.BaseActivity;
import com.android.tonight8.model.common.Coupon;
import com.android.tonight8.utils.DialogUtils;
import com.android.tonight8.utils.Utils;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnClick;

/**
 * @Description:创建活动第二步发优惠券
 * @author:LiuZhao
 * @Date:2015年1月28日
 */
public class CreateEventSecondActivity extends BaseActivity {

	/** 没中奖是否发券 */
	@ViewInject(R.id.cb_ispost_coupon)
	private CheckBox cb_ispost_coupon;
	/** 发券内容 */
	@ViewInject(R.id.et_coupon_content)
	private EditText et_coupon_content;
	/** 价值 */
	@ViewInject(R.id.et_coupon_value)
	private EditText et_coupon_value;
	/** 发券数量 */
	@ViewInject(R.id.rg_coupon_count)
	private RadioGroup rg_coupon_count;
	/** 发券数量随机选 */
	@ViewInject(R.id.et_random_count)
	private EditText et_random_count;
	/** 优惠券有效期开始日期 */
	@ViewInject(R.id.et_coupon_startdate)
	private TextView tv_coupon_startdate;
	/** 优惠券有效期结束日期 */
	@ViewInject(R.id.et_coupon_enddate)
	private TextView tv_coupon_enddate;
	/** 优惠券有效期开始日期 */
	private String strCouponStartDate;
	/** 优惠券有效期结束日期 */
	private String etCouponEndDate;
	/** 优惠券实体 */
	private Coupon coupon;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		setContentView(R.layout.activity_create_event_second);
		super.onCreate(savedInstanceState);
		initData();
	}

	private void initData() {
		coupon = new Coupon();
	}

	@OnClick({ R.id.et_coupon_startdate, R.id.et_coupon_enddate })
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.et_coupon_startdate:
			DialogUtils.showSelectDateDialog(CreateEventSecondActivity.this, tv_coupon_startdate);
			break;
		case R.id.et_coupon_enddate:
			DialogUtils.showSelectDateDialog(CreateEventSecondActivity.this, tv_coupon_startdate);
			break;
		default:
			break;
		}
	}
}
