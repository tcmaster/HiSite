package com.android.tonight8.activity.live;

import java.util.List;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.GridView;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.android.tonight8.R;
import com.android.tonight8.adapter.live.GoodDetailPopVpAdapter;
import com.android.tonight8.adapter.live.GoodServiceAdapter;
import com.android.tonight8.base.AppConstants;
import com.android.tonight8.base.BaseActivity;
import com.android.tonight8.base.BaseFragment;
import com.android.tonight8.dao.model.live.EventGoods;
import com.android.tonight8.dao.model.live.EventGoodsOrder;
import com.android.tonight8.fragment.goodsinfo.GoodsDetailIntroduceFragment;
import com.android.tonight8.fragment.goodsinfo.GoodsPraiseFragment;
import com.android.tonight8.fragment.goodsinfo.GoodsStandardFragment;
import com.android.tonight8.function.CirculateFunction;
import com.android.tonight8.io.HandlerConstants;
import com.android.tonight8.io.live.LiveIOController;
import com.android.tonight8.view.GoodsOrderPopupWindow;
import com.android.tonight8.view.GoodsOrderPopupWindow.GoodsOrderPWCallBack;
import com.android.tonight8.view.PointLinearlayout;
import com.lidroid.xutils.view.annotation.ViewInject;

public class GoodsInfoActivity extends BaseActivity {
	/** 多图轮播展示 */
	@ViewInject(R.id.vp_goods_img)
	private ViewPager vp_goods_info;
	/** 轮播的白点 */
	@ViewInject(R.id.ll_point_container)
	private PointLinearlayout ll_point_container;
	/** 本页面的滑动按钮 */
	@ViewInject(R.id.sv_goods_detail)
	private ScrollView sv_goods_detail;
	/** 底部布局 */
	@ViewInject(R.id.rl_bottom)
	private RelativeLayout rl_bottom;
	/** 商品名称 */
	@ViewInject(R.id.tv_goods_name)
	private TextView tv_goods_name;
	/** 商品原价 */
	@ViewInject(R.id.tv_goods_prize_old)
	private TextView tv_goods_prize_old;
	/** 商品现价 */
	@ViewInject(R.id.tv_goods_prize_now)
	private TextView tv_goods_prize_now;
	/** 商品数量 */
	@ViewInject(R.id.tv_goods_count)
	private TextView tv_goods_count;
	/** 商品保障项 */
	@ViewInject(R.id.gv_promise_item)
	private GridView gv_promise_item;
	/** 确认订购按钮 */
	@ViewInject(R.id.btn_ensure_order)
	private Button btn_ensure_order;
	/** 底下3个按钮的tab */
	@ViewInject(R.id.rg_goods_info)
	private RadioGroup rg_goods_info;

	private BaseFragment[] baseFragments;
	private FragmentManager fm;
	private CirculateFunction cFunction;
	/** 商品保障适配器 */
	private GoodServiceAdapter adapter;

	@SuppressLint("HandlerLeak")
	private Handler handler = new Handler() {
		@Override
		public void handleMessage(android.os.Message msg) {
			switch (msg.what) {
			case HandlerConstants.Live.GOODS_ORDER:
				switch (msg.arg1) {
				case HandlerConstants.RESULT_OK:
					processEnsureOrder((EventGoodsOrder) msg.obj);
					break;
				default:
					break;
				}
				break;
			case HandlerConstants.Live.GOODS_DETAIL:
				switch (msg.arg1) {
				case HandlerConstants.RESULT_OK:
					EventGoods model = (EventGoods) msg.obj;
					// ViewPager的处理
					vp_goods_info.setAdapter(new GoodDetailPopVpAdapter(model
							.getPopPics()));
					ll_point_container.setPointCount(model.getPopPics().size());
					ll_point_container.changePoint(0);
					if (cFunction == null) {
						initCFunction(model.getPopPics().size());

					}
					// 商品详细信息内容的填充
					tv_goods_name.setText(model.getGoods().getName());
					tv_goods_prize_old.setText(model.getGoods()
							.getPreviewValue() + "");
					tv_goods_prize_now.setText(model.getGoods()
							.getCurrentValue() + "");
					tv_goods_count.setText("剩余："
							+ model.getGoods().getLimitNumber() + "\n"
							+ "限量：1000");
					// 商品保障项内容的填充
					if (adapter == null) {
						adapter = new GoodServiceAdapter(
								GoodsInfoActivity.this,
								model.getGoodsServices());
						gv_promise_item.setAdapter(adapter);
					} else
						adapter.update(model.getGoodsServices());
					// 处理下面两个布局中的adapter
					baseFragments[0].updateData(List.class,
							model.getDetailPics());
					baseFragments[1].updateData(List.class,
							model.getGoodsStandards());
					rg_goods_info.check(R.id.rb_goods_detail);
					btn_ensure_order.setOnClickListener(new OnClickListener() {

						@Override
						public void onClick(View v) {
							LiveIOController.readOrderShow(handler);
						}
					});
					break;

				default:
					break;
				}
				break;

			default:
				break;
			}
		};
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		initCreateNomal(savedInstanceState, R.layout.activity_goods_info);
		getActionBarBase("初始化只希望确定");
		initViews();
		initDatas();
	}

	@Override
	protected void onPause() {
		super.onPause();
		if (cFunction != null)
			cFunction.pause();
	}

	@Override
	protected void onResume() {
		super.onResume();
		if (cFunction != null)
			cFunction.resume();
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		if (cFunction != null)
			cFunction.stop();
		cFunction = null;
	}

	private void initViews() {
		rl_bottom.post(new Runnable() {

			@Override
			public void run() {
				rl_bottom.getLayoutParams().height = AppConstants.heightPx / 9;
				sv_goods_detail.setPadding(0, 0, 0, AppConstants.heightPx / 9);
				rl_bottom.invalidate();
			}
		});
	}

	private void initDatas() {
		baseFragments = new BaseFragment[3];
		baseFragments[0] = GoodsDetailIntroduceFragment.newInstance();
		baseFragments[1] = GoodsStandardFragment.newInstance();
		baseFragments[2] = GoodsPraiseFragment.newInstance();
		fm = getSupportFragmentManager();
		FragmentTransaction ft = null;
		ft = fm.beginTransaction();
		ft.add(R.id.ll_container, baseFragments[0]);
		ft.add(R.id.ll_container, baseFragments[1]);
		ft.add(R.id.ll_container, baseFragments[2]);
		ft.hide(baseFragments[0]);
		ft.hide(baseFragments[1]);
		ft.hide(baseFragments[2]);
		ft.commit();
		rg_goods_info.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				switch (checkedId) {
				case R.id.rb_goods_detail:
					changeFragment(0);
					break;
				case R.id.rb_goods_style:
					changeFragment(1);
					break;
				case R.id.rb_goods_comment:
					changeFragment(2);
					break;
				default:
					break;
				}
			}
		});
		LiveIOController.readGoodsInfo(handler);
		sv_goods_detail.fullScroll(ScrollView.FOCUS_UP);

	}

	/**
	 * 切换当前显示的fragment
	 * 
	 * @param pos
	 */
	private void changeFragment(int pos) {
		FragmentTransaction ft = fm.beginTransaction();
		for (int i = 0; i < baseFragments.length; i++) {
			if (i == pos)
				ft.show(baseFragments[i]);
			else
				ft.hide(baseFragments[i]);
		}
		ft.commit();
	}

	@SuppressLint("HandlerLeak")
	private void initCFunction(int size) {
		cFunction = new CirculateFunction(size, 5, new Handler() {
			@Override
			public void handleMessage(Message msg) {
				vp_goods_info.setCurrentItem(msg.what);
			}
		});
		cFunction.start();
		vp_goods_info.setOnPageChangeListener(new OnPageChangeListener() {

			@Override
			public void onPageSelected(int arg0) {
				ll_point_container.changePoint(arg0);
			}

			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
			}

			@Override
			public void onPageScrollStateChanged(int arg0) {
			}
		});
	}

	private void processEnsureOrder(EventGoodsOrder model) {
		GoodsOrderPopupWindow window = new GoodsOrderPopupWindow(this,
				new GoodsOrderPWCallBack() {
				}, model);
		window.showWindow();
	}
}
