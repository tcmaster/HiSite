/**
 * 2014-12-29
 */
package com.android.hisite.activity;

import java.util.ArrayList;
import java.util.List;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.android.hisite.BaseActivity;
import com.android.hisite.R;
import com.android.hisite.adapter.AllPrizeLocationAdapter;
import com.android.hisite.adapter.GoodLeftAdapter;
import com.android.hisite.adapter.GoodRightAdapter;
import com.android.utils.DialogUtils;
import com.android.utils.DialogUtils.ListDialogInterface;
import com.android.view.XListView;
import com.lidroid.xutils.view.annotation.ViewInject;

/**
 * @Description:商品详情界面
 * @author:LiXiaoSong
 * @copyright @HiSite
 * @Date:2014-12-29
 */
public class GoodsDetailActivity extends BaseActivity implements OnClickListener {

	// ***************************控件成员***********************************//
	// headerView 的成员
	/** 左边的tab */
	Button tv_tab_left;
	/** 右边的tab */
	Button tv_tab_right;
	/** 主办方一栏 */
	LinearLayout ll_company;
	/** 查看兑奖地点按钮 */
	TextView tv_see_prize_location;
	// headView的成员end
	/** 本页面的listView */
	@ViewInject(R.id.lv_goods_detail)
	XListView lv_goods_detail;

	// ***************************其他成员***********************************//
	/** 左边的数据源 */
	/** 右边的数据源 */
	/** 左边的适配器 */
	GoodLeftAdapter adapter_left;
	/** 右边的适配器 */
	GoodRightAdapter adapter_right;

	// ***************************生命周期,回调方法***********************************//

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		setContentView(R.layout.activity_goods_detail);
		super.onCreate(savedInstanceState);
		initHeaderView();
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
		DialogUtils.showListDialog(this, DialogUtils.TYPE_SIMPLE_LIST, new ListDialogInterface() {

			@Override
			public void getListView(ListView lv_list, final AlertDialog dlg) {
				List<String> testData = new ArrayList<String>();
				testData.add("");
				testData.add("");
				testData.add("");
				lv_list.setAdapter(new AllPrizeLocationAdapter(GoodsDetailActivity.this, testData));
				lv_list.setOnItemClickListener(new OnItemClickListener() {

					@Override
					public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
						dlg.dismiss();
					}
				});
			}
		});
	}

}
