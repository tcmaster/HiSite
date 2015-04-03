package com.android.tonight8.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;

import com.android.tonight8.R;
import com.android.tonight8.base.BaseActivity;
import com.android.tonight8.base.BaseFragment;
import com.android.tonight8.fragment.main.MyAccountFragment;
import com.android.tonight8.fragment.main.OrgLoginFragment;
import com.android.tonight8.fragment.main.TonightEightFragment;
import com.android.tonight8.storage.DBUtil;
import com.android.tonight8.view.RegionalSortPopupWindow;
import com.android.tonight8.view.SlideView;
import com.lidroid.xutils.util.LogUtils;
import com.lidroid.xutils.view.annotation.ViewInject;

/**
 * @Description:主界面
 * @author:LiXiaoSong
 * @Date:2014年12月17日
 */
public class MainActivity extends BaseActivity implements
		OnCheckedChangeListener {

	/** 界面下方四个按钮组 */
	private RadioGroup rg_mian;
	/** 本界面的popupwindow */
	private RegionalSortPopupWindow window;
	/** "我"的界面 */
	private View leftView;
	/** 主界面 */
	private View rightView;
	/** slideView */
	@ViewInject(R.id.sv_main_page)
	private SlideView sv_main;
	/** Fragment管理类 */
	private FragmentManager fragmentManager;
	/** 判断跳转到哪个页面的下标 */
	private int switchid = 0;
	// 自定义actionBar相关（主页）
	/** 主页左边按钮（我） */
	private ImageView iv_left_btn;
	/** 主页最右边按钮 */
	private ImageView iv_right_btn;
	/** 主页较右边按钮 */
	private ImageView iv_right_btn2;
	/** 中间左边的选择 */
	private RadioButton rb_left;
	/** 中间右边的选择 */
	private RadioButton rb_right;
	/** 页面信息标题数组 */
	private String[] titleArr = { "8点", "商家登陆" };
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
		default:
			LogUtils.v("点击此处无效");
			break;
		}
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		setContentView(R.layout.activity_main);
		super.onCreate(savedInstanceState);
		initMainInterface();
		initActionBar();
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		DBUtil.close();// 关闭数据库
	}

	private void initMainInterface() {
		rightView = LayoutInflater.from(this).inflate(
				R.layout.layout_main_right, null);
		leftView = LayoutInflater.from(this).inflate(
				R.layout.activity_org_forgotid, null);
		rg_mian = (RadioGroup) rightView.findViewById(R.id.radio_group);
		sv_main.initView(leftView, rightView);
		// 界面初始化工作
		sv_main.post(new Runnable() {

			@Override
			public void run() {
				initFragment();
			}
		});
	}

	private void initActionBar() {
		iv_left_btn = (ImageView) rightView.findViewById(R.id.iv_left_btn);
		iv_left_btn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				if (sv_main.isOpen()) {
					sv_main.closeMenu();
				} else
					sv_main.openMenu();

			}
		});
	}

	private void initFragment() {
		fragments = new BaseFragment[2];
		fragments[0] = TonightEightFragment.newInstance();
		fragments[1] = OrgLoginFragment.newInstance();
		/* 设置跳转那个fragment页面 */
		fragmentManager = getSupportFragmentManager();
		fragmentTransaction = fragmentManager.beginTransaction();
		fragmentTransaction.add(R.id.tabcontent, fragments[0], titleArr[0]);
		fragmentTransaction.add(R.id.tabcontent, fragments[1], titleArr[1]);
		fragmentTransaction.commit();
		/* fragment管理器初始化 */
		/* 实始化下方单选按钮组 */
		rg_mian.setOnCheckedChangeListener(this);
		((RadioButton) rg_mian.getChildAt(0)).setChecked(true);
		Intent intent = new Intent();

	}

	/**
	 * @Description:得到当前用户的fragment对象
	 * @return
	 * @author: LiXiaoSong
	 * @date:2015-2-6
	 */
	public MyAccountFragment getMyAccountFragment() {
		return null;
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
		if (window != null && window.isShowing()) {
			rlDown();
			window.dismissPopWindow();
			return;
		} else
			super.onBackPressed();
	}

}
