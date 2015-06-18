package com.android.tonight8.activity.wish;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;

import com.android.tonight8.R;
import com.android.tonight8.base.BaseActivity;
import com.android.tonight8.base.BaseFragment;
import com.android.tonight8.fragment.wish.MyWishPostFragment;
import com.android.tonight8.fragment.wish.MyWishSponsorFragment;

/**
 * @author lz 我的心愿
 * 
 */
public class MyWishActivity extends BaseActivity implements
		OnCheckedChangeListener {
	private FragmentManager fm;
	private FragmentTransaction ft;
	private BaseFragment[] baseFragments;
	private RadioGroup rg_mywish;

	@Override
	public void onCheckedChanged(RadioGroup group, int checkedId) {
		/* 处理被单击的按钮 */
		switch (checkedId) {
		case R.id.rb_wywish_post:
			doFragmentShow(0);
			break;
		case R.id.rb_wywish_sponsor:
			doFragmentShow(1);
			break;

		default:
			break;
		}

	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		initCreateNomal(savedInstanceState, R.layout.activity_my_wish);
		getActionBarNormal("我的心愿", R.drawable.vadd,
				new OnClickListener() {

					@Override
					public void onClick(View v) {
						startActivityForAnima(new Intent(MyWishActivity.this,
								MakeWishActivity.class), null);
					}
				});
		initData();

	}

	private void initData() {

		fm = getSupportFragmentManager();
		ft = fm.beginTransaction();
		baseFragments = new BaseFragment[2];
		baseFragments[0] = MyWishPostFragment.newInstance();
		baseFragments[1] = MyWishSponsorFragment.newInstance();
		ft.add(R.id.ll_mywish_rcontent, baseFragments[0]);
		ft.add(R.id.ll_mywish_rcontent, baseFragments[1]);
		ft.commit();
		rg_mywish = (RadioGroup) findViewById(R.id.rg_mywish);
		rg_mywish.setOnCheckedChangeListener(this);

	}

	/**
	 * @Description:显示当前的fragment对象
	 * @param which
	 *            第几个对象
	 * @author: LiXiaoSong
	 * @date:2015-2-6
	 */
	private void doFragmentShow(int which) {
		ft = fm.beginTransaction();
		for (int i = 0; i < baseFragments.length; i++) {
			if (which == i) {
				ft.show(baseFragments[i]);
			} else
				ft.hide(baseFragments[i]);
		}
		ft.commit();
	}

}
