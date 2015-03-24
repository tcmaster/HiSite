package com.android.tonight8.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;

import com.android.tonight8.R;
import com.android.tonight8.base.AppConstants;
import com.android.tonight8.base.BaseActivity;
import com.android.tonight8.base.BaseFragment;
import com.android.tonight8.fragment.main.MyAccountFragment;
import com.android.tonight8.fragment.main.OrgLoginFragment;
import com.android.tonight8.fragment.main.TonightEightFragment;
import com.android.tonight8.storage.DBUtil;
import com.android.tonight8.utils.Utils;
import com.android.tonight8.view.RegionalSortPopupWindow;
import com.android.tonight8.view.RegionalSortPopupWindow.SortListViewCallBack;
import com.android.tonight8.view.SlideLayout;
import com.android.tonight8.view.sortlistview.SortModel;
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
	@ViewInject(R.id.radio_group)
	private RadioGroup rg_mian;
	/** 侧滑菜单，用于管理“我”的界面 */
	private SlideLayout sm_layout;
	/** 本界面的popupwindow */
	private RegionalSortPopupWindow window;
	/** Fragment管理类 */
	private FragmentManager fragmentManager;
	/** 判断跳转到哪个页面的下标 */
	private int switchid = 0;
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
		initMeInterface();
		initActionBar();
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		DBUtil.close();// 关闭数据库
	}

	private void initMainInterface() {
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
	 * 初始化“我”的界面
	 */
	private void initMeInterface() {
		sm_layout = new SlideLayout(this, null, R.style.slidelayout_style);
		View v = LayoutInflater.from(this).inflate(R.layout.activity_me, null);
		sm_layout.addView(v);
		sm_layout.attachToActivity(this, true);
	}

	private void initActionBar() {
		final LinearLayout ll_rl = getActionBarSpeical("今晚8点",
				R.drawable.pencil_gray, false, true, new OnClickListener() {

					@Override
					public void onClick(View arg0) {// 右边按钮点击，弹出popWindow菜单
					}
				});
		final TextView tv_city = (TextView) ll_rl
				.findViewById(R.id.tv_title_right);
		tv_city.setText("北京");

		ll_rl.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				if (window == null) {
					int height = AppConstants.heightPx
							- getActionBar().getHeight();
					window = new RegionalSortPopupWindow(MainActivity.this,
							AppConstants.widthPx, height);// 创建索引的window
				}
				if (window.isShowing()) {
					rlDown();
					window.dismissPopWindow();
				} else {
					window.showRegionalDialog(tv_city,
							new SortListViewCallBack() {
								@Override
								public void getSortModel(SortModel model) {
									rlDown();
									Utils.toast(model.getName());
									tv_city.setText(model.getName());
								}
							});
					rlUp();
				}
			}
		});
		// 本界面actionBar的特殊内容，点击进入“我”
		getLogo().setVisibility(View.VISIBLE);
		getLogo().setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				sm_layout.openLeftMenu(true);
			}
		});
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
