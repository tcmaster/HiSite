package com.android.tonight8.activity.wish;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.android.tonight8.R;
import com.android.tonight8.base.BaseActivity;
import com.android.tonight8.base.BaseFragment;
import com.android.tonight8.fragment.wish.MyWishPostFragment;
import com.android.tonight8.fragment.wish.MyWishSponsorFragment;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnCompoundButtonCheckedChange;

/**
 * @author lz 我的心愿
 * 
 */
public class MyWishActivity extends BaseActivity {
	private FragmentManager fm;
	private FragmentTransaction ft;
	private BaseFragment[] baseFragments;
	@ViewInject(R.id.rg_mywish)
	private RadioGroup rg_mywish;
	@ViewInject(R.id.rb_wywish_post)
	private RadioButton rb_wywish_post;
	@ViewInject(R.id.rb_wywish_sponsor)
	private RadioButton rb_wywish_sponsor;

	@OnCompoundButtonCheckedChange(R.id.rb_wywish_post)
	public void onCheckedChanged(RadioGroup group, int checkedId) {
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
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_my_wish);
		initData();
		
	}

	private void initData() {
		baseFragments = new BaseFragment[2];
		baseFragments[0] = MyWishPostFragment.newInstance();
		baseFragments[1] = MyWishSponsorFragment.newInstance();
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
