/**
 * 2014-12-29
 */
package com.android.tonight8.activity.event;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.tonight8.R;
import com.android.tonight8.activity.AboutUsActivity;
import com.android.tonight8.adapter.event.GoodLeftAdapter;
import com.android.tonight8.adapter.event.GoodRightAdapter;
import com.android.tonight8.base.BaseActivity;
import com.android.tonight8.model.common.PopGoods;
import com.android.tonight8.model.event.EventRecommendModel;
import com.android.tonight8.storage.event.EventStorage;
import com.android.tonight8.view.XListView;
import com.lidroid.xutils.view.annotation.ViewInject;

/**
 * @Description:商品详情界面
 * @author:LiXiaoSong
 * @copyright @tonight8
 * @Date:2014-12-29
 */
public class GoodsDetailActivity extends BaseActivity implements OnClickListener {

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
	/** 小时低位 */
	private TextView tv_count_hour_low;
	/** 小时高位 */
	private TextView tv_count_hour_high;
	/** 分钟低位 */
	private TextView tv_count_minute_low;
	/** 分钟高位 */
	private TextView tv_count_minute_high;
	/** 秒低位 */
	private TextView tv_count_second_low;
	/** 秒高位 */
	private TextView tv_count_second_high;
	/** 报名人数 */
	private TextView tv_apply_count;
	/** 主办方名称 */
	private TextView tv_org_name;
	// headView的成员end
	/** 本页面的listView */
	@ViewInject(R.id.lv_goods_detail)
	private XListView lv_goods_detail;

	// ***************************其他成员***********************************//
	/** 左边的数据源 */
	/** 右边的数据源 */
	/** 左边的适配器 */
	private GoodLeftAdapter adapter_left;
	/** 右边的适配器 */
	private GoodRightAdapter adapter_right;

	// ***************************生命周期,回调方法***********************************//

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		setContentView(R.layout.activity_goods_detail);
		super.onCreate(savedInstanceState);
		initHeaderView();
		getActionBarNormal("活动详情", R.drawable.ic_launcher, null);
		// 测试
		EventRecommendModel model = new EventRecommendModel();
		model.id = 224214;
		model.name = "kakdka";
		PopGoods popGoods = new PopGoods();
		popGoods.id = 23143;
		popGoods.popGoodsName = "dsadkak";
		popGoods.popGoodsPic = "idiafjag.jpg";
		popGoods.popGoodsPrice = 232423;
		model.popGoods = popGoods;
		EventStorage.getRecommandsDBController().saveData(model);
		EventRecommendModel model2 = EventStorage.getRecommandsDBController().getData(model.id);
		Log.v("test", model2.toString());
		initData();
	}

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

	// ***************************子方法***********************************//
	private void initData() {
		adapter_left = new GoodLeftAdapter(this, initTestData());
		adapter_right = new GoodRightAdapter(this, initTestData());
		lv_goods_detail.setAdapter(adapter_left);
	}

	private List<String> initTestData() {// 测试数据
		List<String> test = new ArrayList<String>();
		test.add("");
		test.add("");
		test.add("");
		return test;
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
		tv_see_prize_location = (TextView) view.findViewById(R.id.tv_see_location);
		tv_tab_left.setOnClickListener(this);
		tv_tab_right.setOnClickListener(this);
		ll_company.setOnClickListener(this);
		tv_see_prize_location.setOnClickListener(this);
		lv_goods_detail.addExtraHeaderView(view);
	}

	/**
	 * @Description:切换左边内容
	 * @author: LiXiaoSong
	 * @date:2015-1-8
	 */
	private void doChangeFA() {
		lv_goods_detail.setAdapter(adapter_left);
	}

	/**
	 * @Description:切换右边内容
	 * @author: LiXiaoSong
	 * @date:2015-1-8
	 */
	private void doChangeFB() {
		lv_goods_detail.setAdapter(adapter_right);
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

}
