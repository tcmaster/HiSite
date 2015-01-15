package com.android.tonight8.base;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.tonight8.R;
import com.lidroid.xutils.ViewUtils;

public class BaseActivity extends FragmentActivity {

	/** 通用actionbar */
	public ActionBar mActionBar;
	// 自定义ActionBar相关
	/** 左边文字 */
	private TextView tv_left;
	/** 右边文字 */
	private TextView tv_right;
	/** 标题文字 */
	private TextView tv_title;
	/** 左边箭头 */
	private ImageView iv_arrow;
	/** 左边logo */
	private ImageView iv_logo;
	/** 左边整体 */
	private LinearLayout backButton;
	/** 标题旁边的字 */
	private TextView tv_title_right;
	/** 右边图片 */
	private ImageView iv_right;
	/** 获取当前Activity的上下文对象 */
	protected Context mContext;

	/**
	 * 通过构造方法对上下文内容与全局的app初始化
	 */
	public BaseActivity() {
		mContext = this;
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		ViewUtils.inject(this);
	}

	/**
	 * 启动activity带有动画切换
	 * 
	 * @param intent
	 *            含跳转目标的Intent
	 * @param requestCode
	 *            跳转Activity时的Code,当返回时方便处理数据
	 * @param parentActivity
	 *            获取布当前Activity的父Activity实例，如果父实例存在，那么返回的时候以父Activity为准。
	 * @see:
	 * @since:
	 * @author: PengGuoHua
	 * @date:2014-10-31
	 */
	protected void startActivityForResultAndAnima(Intent intent,
			int requestCode, Activity parentActivity) {
		if (intent != null) {
			parentActivity = getParent();
			if (parentActivity != null) {
				parentActivity.startActivityForResult(intent, requestCode);
				parentActivity.overridePendingTransition(R.anim.push_left_in,
						R.anim.push_left_out);
			} else {
				startActivityForResult(intent, requestCode);
				overridePendingTransition(R.anim.push_left_in,
						R.anim.push_left_out);
			}
		}
	}

	/**
	 * 启动activity带有动画切换
	 * 
	 * @param intent
	 *            含跳转目标的Intent
	 * @param parentActivity
	 *            当前Activity的父Activity
	 * @see:
	 * @since:
	 * @author: PengGuoHua
	 * @date:2014-10-31
	 */
	protected void startActivityForAnima(Intent intent, Activity parentActivity) {
		if (intent != null) {
			parentActivity = getParent();
			if (parentActivity != null) {
				parentActivity.startActivity(intent);
				parentActivity.overridePendingTransition(R.anim.push_left_in,
						R.anim.push_left_out);
			} else {
				startActivity(intent);
				overridePendingTransition(R.anim.push_left_in,
						R.anim.push_left_out);
			}
		}
	}

	/**
	 * 要使用自定义actionBar，必须调用这个方法
	 */
	private void useCustomerActionBar() {
		if (mActionBar == null) {
			mActionBar = getActionBar();
			mActionBar.setDisplayOptions(ActionBar.DISPLAY_HOME_AS_UP
					| ActionBar.DISPLAY_SHOW_TITLE
					| ActionBar.DISPLAY_SHOW_HOME | ActionBar.DISPLAY_USE_LOGO);
			mActionBar.setCustomView(R.layout.layout_actionbar);
			mActionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
			View view = mActionBar.getCustomView();
			tv_left = (TextView) view.findViewById(R.id.leftText);
			tv_right = (TextView) view.findViewById(R.id.rightText);
			iv_logo = (ImageView) view.findViewById(R.id.logo);
			iv_arrow = (ImageView) view.findViewById(R.id.arrow);
			tv_title = (TextView) view.findViewById(R.id.tv_title);
			tv_title_right = (TextView) view.findViewById(R.id.tv_title_right);
			iv_right = (ImageView) view.findViewById(R.id.rightimg);
			backButton = (LinearLayout) view.findViewById(R.id.homelayout);
			backButton.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					BaseActivity.this.onBackPressed();
				}
			});
		}
	}

	/**
	 * @Description:得到actionBar左边的文字
	 * @return
	 * @see:
	 * @since:
	 * @author: LiXiaoSong
	 * @date:2014-12-25
	 */
	private TextView getLeftText() {
		return tv_left;
	}

	/**
	 * @Description:得到actionBar右边的文字
	 * @return
	 * @see:
	 * @since:
	 * @author: LiXiaoSong
	 * @date:2014-12-25
	 */
	private TextView getRightText() {
		return tv_right;
	}

	/**
	 * @Description:得到actionBar的logo
	 * @return
	 * @see:
	 * @since:
	 * @author: LiXiaoSong
	 * @date:2014-12-25
	 */
	private ImageView getLogo() {
		return iv_logo;
	}

	/**
	 * @Description:得到actionBar左边的箭头
	 * @return
	 * @see:
	 * @since:
	 * @author: LiXiaoSong
	 * @date:2014-12-25
	 */
	private ImageView getArrow() {
		return iv_arrow;
	}

	/**
	 * @Description:得到actionBar的标题
	 * @return
	 * @author: LiXiaoSong
	 * @date:2014-12-25
	 */
	private TextView getActionTitle() {
		return tv_title;
	}

	/**
	 * @Description:得到title右边的文字
	 * @return
	 * @author: LiXiaoSong
	 * @date:2014-12-25
	 */
	private TextView getTitleRight() {
		return tv_title_right;
	}

	/**
	 * @Description:得到actionBar右边的图片
	 * @return
	 * @author: LiXiaoSong
	 * @date:2014-12-25
	 */
	private ImageView getImageRight() {
		return iv_right;
	}

	// 对外公开的获取actionBar的方法
	/**
	 * @Description:获取最基本的actionBar，仅有左边返回按钮以及标题
	 * @param title
	 *            标题内容
	 * @author: LiXiaoSong
	 * @date:2015-01-15
	 */
	public void getActionBarBase(String title) {
		useCustomerActionBar();
		getLeftText().setVisibility(View.INVISIBLE);
		getLogo().setVisibility(View.INVISIBLE);
		getRightText().setVisibility(View.INVISIBLE);
		getArrow().setVisibility(View.VISIBLE);
		getActionTitle().setVisibility(View.VISIBLE);
		getActionTitle().setText(title);
		getTitleRight().setVisibility(View.INVISIBLE);
		getImageRight().setVisibility(View.INVISIBLE);

	}

	/**
	 * @Description:获取常规actionBar,有左边的按钮，中间的标题以及右边的图片
	 * @param title
	 *            标题内容
	 * @param res
	 *            右边图片的资源
	 * @param rightclick
	 *            右边图片的点击事件
	 * @author: LiXiaoSong
	 * @date:2015-01-15
	 */
	public void getActionBarNormal(String title, int res,
			OnClickListener rightClick) {
		useCustomerActionBar();
		getLeftText().setVisibility(View.INVISIBLE);
		getLogo().setVisibility(View.INVISIBLE);
		getRightText().setVisibility(View.INVISIBLE);
		getArrow().setVisibility(View.VISIBLE);
		getActionTitle().setVisibility(View.VISIBLE);
		getActionTitle().setText(title);
		getTitleRight().setVisibility(View.INVISIBLE);
		getImageRight().setVisibility(View.VISIBLE);
		getImageRight().setImageResource(res);
		getImageRight().setOnClickListener(rightClick);

	}

	/**
	 * @Description:获取无返回键的actionBar，含有中间的标题以及右边的图片
	 * @param title
	 *            标题内容
	 * @param res
	 *            右边图片的资源
	 * @param rightclick
	 *            右边图片的点击事件
	 * @author: LiXiaoSong
	 * @date:2015-01-15
	 */
	public void getActionBarNoReturn(String title, int res,
			OnClickListener rightClick) {
		useCustomerActionBar();
		getLeftText().setVisibility(View.INVISIBLE);
		getLogo().setVisibility(View.INVISIBLE);
		getRightText().setVisibility(View.INVISIBLE);
		getArrow().setVisibility(View.INVISIBLE);
		getActionTitle().setVisibility(View.VISIBLE);
		getActionTitle().setText(title);
		getTitleRight().setVisibility(View.INVISIBLE);
		getImageRight().setVisibility(View.VISIBLE);
		getImageRight().setImageResource(res);
		getImageRight().setOnClickListener(rightClick);
	}

	/**
	 * @Description: 
	 *               获取特殊的actionBar,如果hasLeft为null，左边的返回将隐藏，如果hasSpeical为false，返回的标题旁边的内容将隐藏
	 *               ，图片资源文件如果传入-1，将不显示
	 * @param title
	 *            标题内容
	 * @param res
	 *            右边图片的资源文件
	 * @param hasLeft
	 *            是否有左边的返回按钮
	 * @param hasSpeical
	 *            是否有标题旁边的内容
	 * @param rightClick
	 *            右边的点击事件
	 * @return 返回标题旁边的内容
	 */
	public TextView getActionBarSpeical(String title, int res, boolean hasLeft,
			boolean hasSpeical, OnClickListener rightClick) {
		useCustomerActionBar();
		getLeftText().setVisibility(View.INVISIBLE);
		getLogo().setVisibility(View.INVISIBLE);
		getRightText().setVisibility(View.INVISIBLE);
		if (hasLeft)
			getArrow().setVisibility(View.VISIBLE);
		else
			getArrow().setVisibility(View.INVISIBLE);
		getActionTitle().setVisibility(View.VISIBLE);
		getActionTitle().setText(title);
		if (hasSpeical)
			getTitleRight().setVisibility(View.VISIBLE);
		else
			getTitleRight().setVisibility(View.INVISIBLE);

		if (res != -1) {
			getImageRight().setVisibility(View.VISIBLE);
			getImageRight().setImageResource(res);
			getImageRight().setOnClickListener(rightClick);
		} else
			getImageRight().setVisibility(View.INVISIBLE);

		return getTitleRight();
	}
}
