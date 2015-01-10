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
import com.android.tonight8.R.anim;
import com.android.tonight8.R.id;
import com.android.tonight8.R.layout;
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
	protected void startActivityForResultAndAnima(Intent intent, int requestCode, Activity parentActivity) {
		if (intent != null) {
			parentActivity = getParent();
			if (parentActivity != null) {
				parentActivity.startActivityForResult(intent, requestCode);
				parentActivity.overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
			} else {
				startActivityForResult(intent, requestCode);
				overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
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
				parentActivity.overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
			} else {
				startActivity(intent);
				overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
			}
		}
	}

	/**
	 * 要使用自定义actionBar，必须调用这个方法
	 */
	public void useCustomerActionBar() {
		if (mActionBar == null) {
			mActionBar = getActionBar();
			mActionBar.setDisplayOptions(ActionBar.DISPLAY_HOME_AS_UP | ActionBar.DISPLAY_SHOW_TITLE | ActionBar.DISPLAY_SHOW_HOME | ActionBar.DISPLAY_USE_LOGO);
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
	public TextView getLeftText() {
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
	public TextView getRightText() {
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
	public ImageView getLogo() {
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
	public ImageView getArrow() {
		return iv_arrow;
	}

	/**
	 * @Description:得到actionBar的标题
	 * @return
	 * @see:
	 * @since:
	 * @author: LiXiaoSong
	 * @date:2014-12-25
	 */
	public TextView getActionTitle() {
		return tv_title;
	}

	/**
	 * @Description:得到title右边的文字
	 * @return
	 * @see:
	 * @since:
	 * @author: LiXiaoSong
	 * @date:2014-12-25
	 */
	public TextView getTitleRight() {
		return tv_title_right;
	}

	/**
	 * @Description:得到actionBar右边的图片
	 * @return
	 * @see:
	 * @since:
	 * @author: LiXiaoSong
	 * @date:2014-12-25
	 */
	public ImageView getImageRight() {
		return iv_right;
	}
}
