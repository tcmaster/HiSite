package com.android.tonight8.activity.org;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;

import com.android.tonight8.R;
import com.android.tonight8.base.BaseActivity;
import com.android.tonight8.base.BaseFragment;
import com.android.tonight8.fragment.org.OrgDetailFragment;
import com.android.tonight8.fragment.org.OrgEventListFragment;
import com.android.tonight8.fragment.org.SponsorWishFragment;
import com.lidroid.xutils.util.LogUtils;
import com.lidroid.xutils.view.annotation.ViewInject;

/**
 * @author asus 别人看到的商家资料
 */
public class OrgDetailForOtherActivity extends BaseActivity implements
		OnCheckedChangeListener {
	@ViewInject(R.id.rg_org_detail)
	private RadioGroup rg_org_detail;
	@ViewInject(R.id.rb_wish_talk)
	private RadioButton rb_wish_talk;
	@ViewInject(R.id.rb_wish_process)
	private RadioButton rb_wish_process;
	@ViewInject(R.id.rb_wish_sponsor)
	private RadioButton rb_wish_sponsor;
	private FragmentManager fm;
	private FragmentTransaction ft;
	private BaseFragment[] baseFragments;

	public void onCheckedChanged(RadioGroup arg0, int arg1) {
		int radioButtonId = arg0.getCheckedRadioButtonId();
		LogUtils.i(arg1 + "");
		switch (radioButtonId) {
		case R.id.rb_wish_talk:
			doFragmentShow(0);
			break;
		case R.id.rb_wish_process:
			doFragmentShow(1);
			break;
		case R.id.rb_wish_sponsor:
			doFragmentShow(2);
			break;
		default:
			break;
		}

	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_orgdetail_forother);
		initData();
		doFragmentShow(0);
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

	private void initData() {

		fm = getSupportFragmentManager();
		ft = fm.beginTransaction();
		baseFragments = new BaseFragment[3];
		baseFragments[0] = OrgDetailFragment.newInstance();
		baseFragments[1] = OrgEventListFragment.newInstance();
		baseFragments[2] = SponsorWishFragment.newInstance();
		ft.add(R.id.ll_wish_fourcontent, baseFragments[0]);
		ft.add(R.id.ll_wish_fourcontent, baseFragments[1]);
		ft.add(R.id.ll_wish_fourcontent, baseFragments[2]);
		ft.commit();
		rg_org_detail.setOnCheckedChangeListener(this);
	}
}
