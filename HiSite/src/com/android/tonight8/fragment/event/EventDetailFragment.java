package com.android.tonight8.fragment.event;

import java.util.ArrayList;
import java.util.List;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.tonight8.R;
import com.android.tonight8.activity.event.AboutUsActivity;
import com.android.tonight8.activity.event.EventExchangeActivity;
import com.android.tonight8.adapter.event.GoodRightAdapter;
import com.android.tonight8.base.BaseActivity;
import com.android.tonight8.base.BaseFragment;
import com.android.tonight8.base.Tonight8App;
import com.android.tonight8.function.CountDownFunction;
import com.android.tonight8.io.HandlerConstants;
import com.android.tonight8.model.event.EventConsultModel;
import com.android.tonight8.model.event.EventDetailModel;
import com.android.tonight8.utils.DialogUtils;
import com.android.tonight8.utils.Utils;
import com.android.tonight8.view.xlistview.XListView;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnClick;

public class EventDetailFragment extends BaseFragment {

	// ***************************控件成员***********************************//
	/** 主办方一栏 */
	private LinearLayout ll_company;
	/** 活动主题 */
	private TextView tv_detail_theme;
	/** 左上角海报名称 */
	private TextView tv_pop_goods_name;
	/** 海报图片 */
	private ImageView iv_pop_goods_pic;
	/** 奖品价值 */
	private TextView tv_pop_goods_price;
	/** 小时 */
	private TextView tv_count_hour;
	/** 分钟 */
	private TextView tv_count_minute;
	/** 秒 */
	private TextView tv_count_second;
	/** 报名人数 */
	private TextView tv_apply_count;
	/** 主办方名称 */
	private TextView tv_detail_company;
	/** 优惠券 */
	private TextView tv_detail_coupon;
	// headView的成员end
	/** 本页面的listView */
	@ViewInject(R.id.lv_goods_detail)
	private XListView lv_goods_detail;
	@ViewInject(R.id.ll_bottom)
	private LinearLayout ll_bottom;
	/** 兑奖地点 */
	private TextView tv_detail_award_location;
	/** 规则 */
	private TextView tv_detail_activity_rules;
	/** 奖品介绍 */
	private Button btn_detail_award_introduce;
	/** 活动咨询 */
	private Button btn_detail_award_consult;
	// ***************************其他成员***********************************//
	/** 当前的位置是左边 */
	private static final int LEFT = 1;
	/** 当前的位置是右边 */
	private static final int RIGHT = 2;
	/** 右边的适配器 */
	private GoodRightAdapter adapter_right;
	/** 该变量用来标记当前的行为是下拉刷新还是上拉加载 */
	private int flag2 = REFRESH;
	private View rootView;
	/**
	 * 本界面的数据更新handler
	 */
	@SuppressLint("HandlerLeak")
	private Handler handler = new Handler() {
		@SuppressWarnings("unchecked")
		@Override
		public void handleMessage(android.os.Message msg) {
			switch (msg.what) {
			case HandlerConstants.Event.EVENT_DETAIL:
				if (msg.arg1 == HandlerConstants.RESULT_OK) {
					// pb_loading.setVisibility(View.INVISIBLE);
					ll_bottom.setVisibility(View.VISIBLE);
					lv_goods_detail.setVisibility(View.VISIBLE);
					EventDetailModel source = (EventDetailModel) msg.obj;
					adapter_right = new GoodRightAdapter(activity,
							new ArrayList<EventConsultModel>());
					tv_detail_theme.setText(source.event.name);
					tv_pop_goods_name.setText(source.popGoods.popGoodsName);
					Tonight8App.getSelf().bitmapUtils.display(iv_pop_goods_pic,
							source.popGoods.popGoodsPic);
					tv_pop_goods_price.setText(source.popGoods.popGoodsPrice
							+ "");
					tv_apply_count.setText(source.event.applyCount + "人");
					tv_detail_company.setText(source.org.name);

					new CountDownFunction().beginCountDown(
							(BaseActivity) activity, "2015-03-17 16:10:44",
							tv_count_hour, tv_count_minute, tv_count_second);// 倒计时开始
				} else if (msg.arg1 == HandlerConstants.RESULT_FAIL) {
					Utils.toast("网络异常");
					lv_goods_detail.stopRefresh();
				} else if (msg.arg1 == HandlerConstants.NETWORK_BEGIN) {
					// pb_loading.setVisibility(View.VISIBLE);
					ll_bottom.setVisibility(View.INVISIBLE);
					lv_goods_detail.setVisibility(View.INVISIBLE);
				}
				lv_goods_detail.setPullLoadEnable(false);
				break;
			case HandlerConstants.Event.EVENT_DETAIL_CONSULT:
				if (msg.arg1 == HandlerConstants.RESULT_OK) {
					if (flag2 == REFRESH) {
						adapter_right
								.updateData((List<EventConsultModel>) msg.obj);
						lv_goods_detail.stopRefresh();
					} else {
						adapter_right
								.addData((List<EventConsultModel>) msg.obj);
						lv_goods_detail.stopLoadMore();
					}
				} else if (msg.arg1 == HandlerConstants.RESULT_FAIL) {

				} else if (msg.arg1 == HandlerConstants.NETWORK_BEGIN) {

				}

				break;
			default:
				break;
			}
		};
	};

	public static final EventDetailFragment newInstance() {
		EventDetailFragment eventDetailFragment = new EventDetailFragment();
		return eventDetailFragment;

	}

	// ***************************生命周期,回调方法***********************************//
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		rootView = inflater.inflate(R.layout.fragment_event_detail, null);
		ViewUtils.inject(this, rootView);

		initHeaderView();
		initData();
		return rootView;
	};

	@OnClick({ R.id.ibtn_commit, R.id.btn_signup })
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.ibtn_commit:
			DialogUtils.showCommitDialog(activity, "请输入评论");
			break;
		case R.id.btn_signup:

			break;
		default:
			break;
		}
	}

	//
	// @Override
	// public void onDestroy() {
	// flagCountDown = false;// 倒计时结束
	// super.onDestroy();
	// }

	// ***************************子方法***********************************//
	private void initData() {

		// EventIOController.eventDetailRead(handler);

	}

	/**
	 * @Description:初始化listview的headerview
	 * @author: LiXiaoSong
	 * @date:2015-1-9
	 */
	private void initHeaderView() {

		ll_company = (LinearLayout) rootView.findViewById(R.id.ll_company);
		tv_detail_theme = (TextView) rootView
				.findViewById(R.id.tv_detail_theme);
		tv_pop_goods_name = (TextView) rootView
				.findViewById(R.id.tv_fg_left_top);
		iv_pop_goods_pic = (ImageView) rootView
				.findViewById(R.id.iv_commodity_img);
		tv_pop_goods_price = (TextView) rootView
				.findViewById(R.id.tv_fg_right_bottom);
		tv_count_hour = (TextView) rootView.findViewById(R.id.tv_detail_hour);
		tv_count_minute = (TextView) rootView
				.findViewById(R.id.tv_detail_minute);
		tv_count_second = (TextView) rootView
				.findViewById(R.id.tv_detail_second);
		tv_apply_count = (TextView) rootView
				.findViewById(R.id.tv_detail_apply_count);
		tv_detail_company = (TextView) rootView
				.findViewById(R.id.tv_detail_company);
		tv_detail_award_location = (TextView) rootView
				.findViewById(R.id.tv_detail_award_location);
		tv_detail_coupon = (TextView) rootView
				.findViewById(R.id.tv_detail_coupon);
		tv_detail_activity_rules = (TextView) rootView
				.findViewById(R.id.tv_detail_activity_rules);
		btn_detail_award_introduce = (Button) rootView
				.findViewById(R.id.btn_detail_award_introduce);
		btn_detail_award_consult = (Button) rootView
				.findViewById(R.id.btn_detail_award_consult);

		OnClickListener listener = new OnClickListener() {

			@Override
			public void onClick(View v) {
				switch (v.getId()) {
				// case R.id.ll_company:
				// doJumpCompany();
				// break;
				case R.id.btn_detail_award_introduce:

					break;
				case R.id.btn_detail_award_consult:

					break;
				default:
					break;
				}

			}
		};
		// ll_company.setOnClickListener(listener);
		// tv_see_prize_location.setOnClickListener(listener);
		btn_detail_award_introduce.setOnClickListener(listener);
		btn_detail_award_consult.setOnClickListener(listener);
		tv_detail_theme.setText("小米公司送手机");
		tv_detail_coupon.setText("价值200元优惠券");
		tv_detail_company.setText("北京可乐屏有限公司");
		tv_detail_activity_rules.setText("活动规则：1.规则*******2.规则***********");

	}

	/**
	 * 跳转到主办方详情
	 * 
	 * @Description:
	 * @author: LiXiaoSong
	 * @date:2015-1-8
	 */
	private void doJumpCompany() {
		Intent intent = new Intent(activity, AboutUsActivity.class);
		startActivity(intent);
	}

	/**
	 * 查看兑奖地点
	 * 
	 * @Description:
	 * @author: LiXiaoSong
	 * @date:2015-1-8
	 */
	private void doWatchAllPrizeLocation() {
		Intent intent = new Intent(activity, EventExchangeActivity.class);
		startActivity(intent);
	}

}
