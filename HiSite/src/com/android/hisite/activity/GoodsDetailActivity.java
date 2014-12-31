/**
 * 2014-12-29
 */
package com.android.hisite.activity;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
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

	@OnClick({ R.id.tv_choice_award, R.id.tv_choice_activity_q })
	public void onClick(View v) {
		FragmentTransaction transaction = manager.beginTransaction();
		switch (v.getId()) {
		case R.id.tv_choice_award:
			transaction.replace(R.id.ll_tab_container, fg_left);
			break;
		case R.id.tv_choice_activity_q:
			transaction.replace(R.id.ll_tab_container, fg_right);
			break;
		default:
			break;
		}
		transaction.commit();
	}

	// ***************************子方法***********************************//
	private void initData() {
		manager = getFragmentManager();
		fg_left = GoodDetailsLeftFragment.newInstance();
		fg_right = GoodDetailRightFragment.newInstance();
	}

}
