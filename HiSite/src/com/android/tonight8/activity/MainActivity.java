package com.android.tonight8.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;

import com.android.tonight8.R;
import com.android.tonight8.base.BaseActivity;
import com.android.tonight8.fragment.main.HiLiveFragment;
import com.android.tonight8.fragment.main.MyAccountFragment;
import com.android.tonight8.fragment.main.OrgLoginFragment;
import com.android.tonight8.fragment.main.PostEventMenuFragment;
import com.android.tonight8.fragment.main.TonightEightFragment;

/**
 * @Description:主界面
 * @author:LiuZhao
 * @Date:2014年12月17日
 */
public class MainActivity extends BaseActivity implements OnCheckedChangeListener {

	/** 界面下方四个按钮组 */
	private RadioGroup rg_mian;
	/** Fragment管理类 */
	private FragmentManager fragmentManager;
	private Fragment mFragment;
	/** 判断跳转到哪个页面的下标 */
	private int switchid = 0;
	/** 页面信息标题数组 */
	private String[] titleArr = { "8点", "Hi现场", "发活动", "我" };
	private boolean isLogin = false;
	private FragmentTransaction fragmentTransaction;

	@Override
	public void onCheckedChanged(RadioGroup arg0, int arg1) {

		/* 处理被单击的按钮 */
		RadioButton mRadioButton = (RadioButton) arg0.findViewById(arg1);
		switchid = Integer.parseInt(mRadioButton.getTag().toString());
		/* 设置跳转那个fragment页面 */
		mFragment = fragmentManager.findFragmentByTag(titleArr[switchid]);
		fragmentTransaction = fragmentManager.beginTransaction();
		switch (switchid) {
		case 0:
			mFragment = TonightEightFragment.newInstance();
			break;
		case 1:
			mFragment = HiLiveFragment.newInstance();
			break;
		case 2:
			if (isLogin) {
				mFragment = PostEventMenuFragment.newInstance();
			} else {
				mFragment = OrgLoginFragment.newInstance();
			}
			break;
		case 3:
			mFragment = MyAccountFragment.newInstance();
			break;
		}

		fragmentTransaction.replace(R.id.tabcontent, mFragment, titleArr[switchid]);
		fragmentTransaction.commitAllowingStateLoss();
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initView();
	}

	private void initView() {
		/* fragment事务初始化 */
		fragmentManager = getSupportFragmentManager();
		/* 实始化下方单选按钮组 */
		rg_mian = (RadioGroup) findViewById(R.id.radio_group);
		rg_mian.setOnCheckedChangeListener(this);
		((RadioButton) rg_mian.getChildAt(0)).setChecked(true);

	}

	public void UpdateLoginedFragment(boolean logined) {
		isLogin = logined;
		fragmentTransaction = fragmentManager.beginTransaction();
		mFragment = PostEventMenuFragment.newInstance();
		fragmentTransaction.replace(R.id.tabcontent, mFragment, titleArr[switchid]);
		fragmentTransaction.commitAllowingStateLoss();
	}

}
