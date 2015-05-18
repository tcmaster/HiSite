/**
 * 2014-12-29
 */
package com.android.tonight8.activity.event;

import java.util.ArrayList;
import java.util.List;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.android.tonight8.R;
import com.android.tonight8.adapter.event.GoodLeftAdapter;
import com.android.tonight8.adapter.event.GoodRightAdapter;
import com.android.tonight8.base.BaseActivity;
import com.android.tonight8.function.CountDownFunction;
import com.android.tonight8.io.HandlerConstants;
import com.android.tonight8.io.event.EventIOController;
import com.android.tonight8.model.event.EventConsultModel;
import com.android.tonight8.model.event.EventDetailModel;
import com.android.tonight8.utils.DialogUtils;
import com.android.tonight8.utils.Utils;
import com.android.tonight8.view.xlistview.XListView;
import com.android.tonight8.view.xlistview.XListView.IXListViewListener;
import com.lidroid.xutils.BitmapUtils;
import com.lidroid.xutils.util.LogUtils;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnClick;

/**
 * @Description:商品详情界面
 * @author:LiXiaoSong
 * @copyright @tonight8
 * @Date:2014-12-29
 */
public class GoodsDetailActivity extends BaseActivity {

	// ***************************控件成员***********************************//
	// headerView 的成员
	/** 左边的tab */
	private Button tv_tab_left;
	/** 右边的tab */
	private Button tv_tab_right;
	/** 主办方一栏 */
	private LinearLayout ll_company;
	/** 查看兑奖地点按钮 */
	private TextView tv_see_prize_location;
	/** 活动主题 */
	private TextView tv_event_name;
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
	private TextView tv_org_name;
	// headView的成员end
	/** 本页面的listView */
	@ViewInject(R.id.lv_goods_detail)
	private XListView lv_goods_detail;
	/** 评论 */
	@ViewInject(R.id.ibtn_commit)
	private ImageView ibtn_commit;
	/** 提交报名 */
	@ViewInject(R.id.btn_signup)
	private Button btn_signup;
	/** 等待框 */
	@ViewInject(R.id.pb_loading)
	private ProgressBar pb_loading;
	@ViewInject(R.id.ll_bottom)
	private LinearLayout ll_bottom;

	// ***************************其他成员***********************************//
	/** 当前的位置是左边 */
	private static final int LEFT = 1;
	/** 当前的位置是右边 */
	private static final int RIGHT = 2;
	/** 左边的适配器 */
	private GoodLeftAdapter adapter_left;
	/** 右边的适配器 */
	private GoodRightAdapter adapter_right;
	/** 图片下载工具 */
	private BitmapUtils utils;
	/** 该变量用来标记当前展示的是左边还是右边 */
	private int flag = LEFT;
	/** 该变量用来标记当前的行为是下拉刷新还是上拉加载 */
	private int flag2 = REFRESH;
	/** 该标记用于确定当前是否点击了tab按钮 */
	private boolean flag3 = false;
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
					pb_loading.setVisibility(View.INVISIBLE);
					ll_bottom.setVisibility(View.VISIBLE);
					lv_goods_detail.setVisibility(View.VISIBLE);
					EventDetailModel source = (EventDetailModel) msg.obj;
					adapter_left = new GoodLeftAdapter(
							GoodsDetailActivity.this, source.goodses);
					adapter_right = new GoodRightAdapter(
							GoodsDetailActivity.this,
							new ArrayList<EventConsultModel>());
					tv_event_name.setText(source.event.name);
					tv_pop_goods_name.setText(source.popGoods.popGoodsName);
					utils.display(iv_pop_goods_pic, source.popGoods.popGoodsPic);
					tv_pop_goods_price.setText(source.popGoods.popGoodsPrice
							+ "");
					tv_apply_count.setText(source.event.applyCount + "人");
					tv_org_name.setText(source.org.name);
					lv_goods_detail.setAdapter(adapter_left);
					lv_goods_detail.stopRefresh();
					new CountDownFunction().beginCountDown(
							GoodsDetailActivity.this, "2015-03-17 16:10:44",
							tv_count_hour, tv_count_minute, tv_count_second);// 倒计时开始
				} else if (msg.arg1 == HandlerConstants.RESULT_FAIL) {
					Utils.toast("网络异常");
					lv_goods_detail.stopRefresh();
				} else if (msg.arg1 == HandlerConstants.NETWORK_BEGIN) {
					pb_loading.setVisibility(View.VISIBLE);
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
				scrollListView();
				break;
			default:
				break;
			}
		};
	};

	// ***************************生命周期,回调方法***********************************//

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		setContentView(R.layout.activity_goods_detail);
		super.onCreate(savedInstanceState);
		initHeaderView();
		initData();
		for (int i = 0; i < 1000; i++) {
			System.out.print("1");
		}
	}

	@OnClick({ R.id.ibtn_commit, R.id.btn_signup })
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.ibtn_commit:
			DialogUtils.showCommitDialog(this, "请输入评论");
			break;
		case R.id.btn_signup:

			break;
		default:
			break;
		}
	}

	@Override
	protected void onDestroy() {
		flagCountDown = false;// 倒计时结束
		super.onDestroy();
	}

	// ***************************子方法***********************************//
	private void initData() {
		utils = new BitmapUtils(this);
		getActionBarNormal("活动详情", R.drawable.ic_launcher,
				new OnClickListener() {

					@Override
					public void onClick(View v) {
						DialogUtils.showSelectShareDialog(
								GoodsDetailActivity.this, null);
					}
				});
		EventIOController.eventDetailRead(handler);
		lv_goods_detail.setXListViewListener(new IXListViewListener() {

			@Override
			public void onRefresh() {
				lv_goods_detail.setPullLoadEnable(true);
				flag2 = REFRESH;
				if (flag == LEFT) {
					EventIOController.eventDetailRead(handler);
				} else if (flag == RIGHT) {
					EventIOController.eventConsultsRead(handler);
				}
			}

			@Override
			public void onLoadMore() {
				if (flag == RIGHT) {
					flag2 = LOAD_MORE;
					EventIOController.eventConsultsRead(handler);
				}

			}
		});
	}

	/**
	 * @Description:初始化listview的headerview
	 * @author: LiXiaoSong
	 * @date:2015-1-9
	 */
	private void initHeaderView() {
		LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View view = inflater.inflate(R.layout.header_goods_detail, null, false);
		tv_tab_left = (Button) view.findViewById(R.id.btn_choice_award);
		tv_tab_right = (Button) view.findViewById(R.id.btn_choice_activity_q);
		ll_company = (LinearLayout) view.findViewById(R.id.ll_company);
		tv_event_name = (TextView) view.findViewById(R.id.tv_theme);
		tv_pop_goods_name = (TextView) view.findViewById(R.id.tv_fg_left_top);
		iv_pop_goods_pic = (ImageView) view.findViewById(R.id.iv_commodity_img);
		tv_pop_goods_price = (TextView) view
				.findViewById(R.id.tv_fg_right_bottom);
		tv_count_hour = (TextView) view.findViewById(R.id.tv_hour);
		tv_count_minute = (TextView) view.findViewById(R.id.tv_minute);
		tv_count_second = (TextView) view.findViewById(R.id.tv_second);
		tv_apply_count = (TextView) view.findViewById(R.id.tv_apply_count);
		tv_org_name = (TextView) view.findViewById(R.id.tv_company);
		tv_see_prize_location = (TextView) view
				.findViewById(R.id.tv_see_location);
		OnClickListener listener = new OnClickListener() {

			@Override
			public void onClick(View v) {
				switch (v.getId()) {
				case R.id.btn_choice_award:
					doChangeFA();
					break;
				case R.id.btn_choice_activity_q:
					doChangeFB();
					break;
				case R.id.ll_company:
					doJumpCompany();
					break;
				case R.id.tv_see_location:
					doWatchAllPrizeLocation();
					break;
				default:
					break;
				}

			}
		};
		tv_tab_left.setOnClickListener(listener);
		tv_tab_right.setOnClickListener(listener);
		ll_company.setOnClickListener(listener);
		tv_see_prize_location.setOnClickListener(listener);
		lv_goods_detail.addExtraHeaderView(view);

	}

	/**
	 * @Description:切换左边内容
	 * @author: LiXiaoSong
	 * @date:2015-1-8
	 */
	private void doChangeFA() {
		flag = LEFT;
		flag3 = true;
		lv_goods_detail.setPullLoadEnable(false);
		lv_goods_detail.setAdapter(adapter_left);
		scrollListView();
	}

	/**
	 * @Description:切换右边内容
	 * @author: LiXiaoSong
	 * @date:2015-1-8
	 */
	private void doChangeFB() {
		flag = RIGHT;
		flag3 = true;
		lv_goods_detail.setPullLoadEnable(true);
		lv_goods_detail.setAdapter(adapter_right);
		EventIOController.eventConsultsRead(handler);
	}

	/**
	 * 跳转到主办方详情
	 * 
	 * @Description:
	 * @author: LiXiaoSong
	 * @date:2015-1-8
	 */
	private void doJumpCompany() {
		Intent intent = new Intent(this, AboutUsActivity.class);
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
		Intent intent = new Intent(this, EventExchangeActivity.class);
		startActivity(intent);
	}

	/**
	 * 当点击tab按钮时，将listview滑动到listView第一个item的位置
	 */
	private void scrollListView() {
		if (flag3) {
			lv_goods_detail.post(new Runnable() {

				@Override
				public void run() {
					LogUtils.v("已经进入");
					if (lv_goods_detail.getAdapter().getCount() != 0)
						lv_goods_detail.setSelection(2);// 有两个头部，所以首个item的位置是2
					flag3 = false;
				}
			});
		}
	}
}
