package com.android.tonight8.activity.live;

import java.util.List;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.widget.Button;
import android.widget.GridView;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.ScrollView;
import android.widget.TextView;

import com.android.tonight8.R;
import com.android.tonight8.base.BaseActivity;
import com.android.tonight8.base.BaseFragment;
import com.android.tonight8.dao.model.live.EventGoods;
import com.android.tonight8.fragment.goodsinfo.GoodsDetailIntroduceFragment;
import com.android.tonight8.fragment.goodsinfo.GoodsPraiseFragment;
import com.android.tonight8.fragment.goodsinfo.GoodsStandardFragment;
import com.android.tonight8.io.HandlerConstants;
import com.android.tonight8.io.live.LiveIOController;
import com.lidroid.xutils.view.annotation.ViewInject;

public class GoodsInfoActivity extends BaseActivity {
	/** 多图轮播展示 */
	@ViewInject(R.id.vp_goods_img)
	private ViewPager vp_goods_info;
	/** 本页面的滑动按钮 */
	@ViewInject(R.id.sv_goods_detail)
	private ScrollView sv_goods_detail;
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
	/** 商品运费 */
	@ViewInject(R.id.tv_goods_freight)
	private TextView tv_goods_freight;
	/** 商品保障项 */
	@ViewInject(R.id.gv_promise_item)
	private GridView gv_promise_item;
	/** 选择优惠券 */
	@ViewInject(R.id.tv_coupon)
	private TextView tv_coupon;
	/** 确认订购按钮 */
	@ViewInject(R.id.btn_ensure_order)
	private Button btn_ensure_order;
	/** 底下3个按钮的tab */
	@ViewInject(R.id.rg_goods_info)
	private RadioGroup rg_goods_info;

	private BaseFragment[] baseFragments;
	private FragmentManager fm;
	@SuppressLint("HandlerLeak")
	private Handler handler = new Handler() {
		@Override
		public void handleMessage(android.os.Message msg) {
			switch (msg.what) {
			case HandlerConstants.Live.GOODS_DETAIL:
				switch (msg.arg1) {
				case HandlerConstants.RESULT_OK:
					EventGoods model = (EventGoods) msg.obj;
					baseFragments[0].updateData(List.class,
							model.getDetailPics());
					baseFragments[1].updateData(List.class,
							model.getGoodsStandards());
					rg_goods_info.check(R.id.rb_goods_detail);
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
		initDatas();
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
				int which = -1;
				switch (checkedId) {
				case R.id.rb_goods_detail:
					which = changeFragment(0);
					break;
				case R.id.rb_goods_style:
					which = changeFragment(1);
					break;
				case R.id.rb_goods_comment:
					which = changeFragment(2);
					break;
				default:
					which = 0;
					break;
				}
			}
		});
		LiveIOController.readGoodsInfo(handler);
	}

	/**
	 * 切换当前显示的fragment
	 * 
	 * @param pos
	 */
	private int changeFragment(int pos) {
		FragmentTransaction ft = fm.beginTransaction();
		for (int i = 0; i < baseFragments.length; i++) {
			if (i == pos)
				ft.show(baseFragments[i]);
			else
				ft.hide(baseFragments[i]);
		}
		ft.commit();
		return pos;
	}
}
