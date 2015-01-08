/**
 * 2014-12-29
 */
package com.android.hisite.activity;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.hisite.BaseActivity;
import com.android.hisite.R;
import com.android.hisite.fragment.GoodDetailRightFragment;
import com.android.hisite.fragment.GoodDetailsLeftFragment;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnClick;

/**
 * @Description:商品详情界面
 * @author:LiXiaoSong
 * @copyright @HiSite
 * @Date:2014-12-29
 */
public class GoodsDetailActivity extends BaseActivity {

	// ***************************控件成员***********************************//
	/** 左边的tab */
	@ViewInject(R.id.tv_choice_award)
	TextView tv_tab_left;
	/** 右边的tab */
	@ViewInject(R.id.tv_choice_activity_q)
	TextView tv_tab_right;
	/** 主办方一栏 */
	@ViewInject(R.id.ll_company)
	LinearLayout ll_company;
	/** 查看兑奖地点按钮 */
	@ViewInject(R.id.tv_see_location)
	TextView tv_see_prize_location;
	// ***************************其他成员***********************************//
	FragmentManager manager;
	/** 左边的fragment */
	GoodDetailsLeftFragment fg_left;
	GoodDetailRightFragment fg_right;

	/** 右边的fragment */

	// ***************************生命周期,回调方法***********************************//

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		setContentView(R.layout.activity_goods_detail);
		super.onCreate(savedInstanceState);
		initData();
	}

	@OnClick({ R.id.tv_choice_award, R.id.tv_choice_activity_q, R.id.ll_company, R.id.tv_see_location })
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.tv_choice_award:
			doChangeFA();
			break;
		case R.id.tv_choice_activity_q:
			doChangeFB();
			break;
		case R.id.ll_company:
			doJumpCompany();
		case R.id.tv_see_location:
			doWatchAllPrizeLocation();
			break;
		default:
			break;
		}
	}

	// ***************************子方法***********************************//
	private void initData() {
		manager = getFragmentManager();
		fg_left = GoodDetailsLeftFragment.newInstance();
		fg_right = GoodDetailRightFragment.newInstance();
		FragmentTransaction transaction = manager.beginTransaction();
		transaction.replace(R.id.ll_tab_container, fg_left);
		transaction.commit();
	}

	/**
	 * 切换到fragmentA
	 * 
	 * @Description:
	 * @author: LiXiaoSong
	 * @date:2015-1-8
	 */
	private void doChangeFA() {
		FragmentTransaction transaction = manager.beginTransaction();
		transaction.replace(R.id.ll_tab_container, fg_left);
		transaction.commit();
	}

	/**
	 * 切换到fragmentB
	 * 
	 * @Description:
	 * @author: LiXiaoSong
	 * @date:2015-1-8
	 */
	private void doChangeFB() {
		FragmentTransaction transaction = manager.beginTransaction();
		transaction.replace(R.id.ll_tab_container, fg_right);
		transaction.commit();
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

	}

}
