package com.android.tonight8.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;

import com.android.tonight8.R;
import com.android.tonight8.base.BaseActivity;
import com.android.tonight8.base.BaseFragment;
import com.android.tonight8.fragment.main.HiLiveFragment;
import com.android.tonight8.fragment.main.MyAccountFragment;
import com.android.tonight8.fragment.main.OrgLoginFragment;
import com.android.tonight8.fragment.main.PostEventMenuFragment;
import com.android.tonight8.fragment.main.TonightEightFragment;
import com.android.tonight8.storage.DBUtil;

/**
 * @Description:主界面
 * @author:LiXiaoSong
 * @Date:2014年12月17日
 */
public class MainActivity extends BaseActivity implements
		OnCheckedChangeListener {

	/** 界面下方四个按钮组 */
	private RadioGroup rg_mian;
	/** Fragment管理类 */
	private FragmentManager fragmentManager;
	/** 判断跳转到哪个页面的下标 */
	private int switchid = 0;
	/** 页面信息标题数组 */
	private String[] titleArr = { "8点", "Hi现场", "发活动", "商家登陆", "我" };
	private boolean isLogin = false;
	private FragmentTransaction fragmentTransaction;
	private BaseFragment[] fragments;// 本界面所用到的fragment（方便以后使用）

	@Override
	public void onCheckedChanged(RadioGroup arg0, int arg1) {

		/* 处理被单击的按钮 */
		RadioButton mRadioButton = (RadioButton) arg0.findViewById(arg1);
		switchid = Integer.parseInt(mRadioButton.getTag().toString());

		switch (switchid) {
		case 0:
			doFragmentShow(0);
			break;
		case 1:
			doFragmentShow(1);
			break;
		case 2:
			if (isLogin) {
				doFragmentShow(2);
			} else {
				doFragmentShow(3);
			}
			break;
		case 3:
			doFragmentShow(4);
			break;
		}
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initDatas();
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		DBUtil.close();// 关闭数据库
	}

	private void initDatas() {
		fragments = new BaseFragment[5];
		fragments[0] = TonightEightFragment.newInstance();
		fragments[1] = HiLiveFragment.newInstance();
		fragments[2] = PostEventMenuFragment.newInstance();
		fragments[3] = OrgLoginFragment.newInstance();
		fragments[4] = MyAccountFragment.newInstance();
		/* 设置跳转那个fragment页面 */
		fragmentManager = getSupportFragmentManager();
		fragmentTransaction = fragmentManager.beginTransaction();
		fragmentTransaction.add(R.id.tabcontent, fragments[0], titleArr[0]);
		fragmentTransaction.add(R.id.tabcontent, fragments[1], titleArr[1]);
		fragmentTransaction.add(R.id.tabcontent, fragments[2], titleArr[2]);
		fragmentTransaction.add(R.id.tabcontent, fragments[3], titleArr[3]);
		fragmentTransaction.add(R.id.tabcontent, fragments[4], titleArr[4]);
		fragmentTransaction.commit();
		/* fragment管理器初始化 */
		/* 实始化下方单选按钮组 */
		rg_mian = (RadioGroup) findViewById(R.id.radio_group);
		rg_mian.setOnCheckedChangeListener(this);
		((RadioButton) rg_mian.getChildAt(0)).setChecked(true);
	}

	public void UpdateLoginedFragment(boolean logined) {
		isLogin = logined;
		if (isLogin) {
			doFragmentShow(2);
		} else {
			doFragmentShow(3);
		}
	}

	/**
	 * @Description:得到当前用户的fragment对象
	 * @return
	 * @author: LiXiaoSong
	 * @date:2015-2-6
	 */
	public MyAccountFragment getMyAccountFragment() {
		return (MyAccountFragment) fragments[4];
	}

	/**
	 * @Description:显示当前的fragment对象
	 * @param which
	 *            第几个对象
	 * @author: LiXiaoSong
	 * @date:2015-2-6
	 */
	private void doFragmentShow(int which) {
		fragmentTransaction = fragmentManager.beginTransaction();
		for (int i = 0; i < fragments.length; i++) {
			if (which == i) {
				fragmentTransaction.show(fragments[i]);
			} else
				fragmentTransaction.hide(fragments[i]);
		}
		fragmentTransaction.commit();
	}

	@Override
	public void onBackPressed() {
		// 点击返回的逻辑，若在首页，则进行正常退出操作，若在其他页（除“我页”），则进行返回主页的操作，若在“我”页面，根据当前我页的状态进行返回操作
		if (fragments[0].isVisible()) {
			super.onBackPressed();
			return;
		}
		if (fragments[4].isVisible()) {
			if (fragments[4].onBackPress()) {
			} else {
				return;
			}
		}
		// 其他情况下，返回首页
		rg_mian.check(R.id.rb_main);
	}

}
