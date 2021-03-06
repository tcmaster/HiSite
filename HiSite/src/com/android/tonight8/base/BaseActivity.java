package com.android.tonight8.base;

import java.io.File;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.provider.MediaStore.Images.ImageColumns;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.tonight8.R;
import com.android.tonight8.utils.Utils;
import com.lidroid.xutils.ViewUtils;

public class BaseActivity extends FragmentActivity {

	/** 通用actionbar */
	public ActionBar mActionBar;
	// 自定义ActionBar相关(非主页）
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
	/** 标题右边的布局 */
	private LinearLayout ll_rl;
	/** 标题旁边的字 */
	private TextView tv_title_right;
	/** 上下的箭头 */
	private ImageView iv_rl;
	/** 右边图片 */
	private ImageView iv_right;
	/** 获取当前Activity的上下文对象 */
	protected Context mContext;
	// 标识位
	/** 图库 */
	public static final int PICKPICTURE = 1;
	/** 相机 */
	public static final int TAKEPHOTO = 2;
	/** 裁剪 */
	public static final int CROP = 3;
	/** 文本 */
	public static final int TEXTEDIT = 4;
	// 默认裁剪的宽高
	private static final int OUTPUT_X = 256;
	private static final int OUTPUT_Y = 256;
	/**
	 * 
	 * 照相时的临时文件名
	 */
	protected String tempName = "";
	/** 下拉刷新标识 */
	protected final static int REFRESH = 1;
	/** 上拉加载标识 */
	protected final static int LOAD_MORE = 2;

	/** 该标记用于本界面的倒计时，如果为false，则倒计时停止 */
	public boolean flagCountDown = true;

	/**
	 * 通过构造方法对上下文内容与全局的app初始化
	 */
	public BaseActivity() {
		mContext = this;
	}

	// 在oncreate的第一行必须调用
	protected void initCreateOverLay(Bundle savedInstanceState, int res) {
		// 悬浮型actionBar
		super.onCreate(savedInstanceState);
		getWindow().requestFeature(Window.FEATURE_ACTION_BAR_OVERLAY);
		setContentView(res);
		ViewUtils.inject(this);
	}

	protected void initCreateNomal(Bundle savedInstanceState, int res) {
		super.onCreate(savedInstanceState);
		setContentView(res);
		ViewUtils.inject(this);
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		if (Tonight8App.getSelf().mTencent != null) {
			Tonight8App.getSelf().mTencent.releaseResource();
		}
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
			mActionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
			mActionBar.setBackgroundDrawable(new ColorDrawable(getResources()
					.getColor(R.color.black_half_transparent)));
			mActionBar.setCustomView(R.layout.layout_actionbar);
			View view = mActionBar.getCustomView();
			tv_left = (TextView) view.findViewById(R.id.leftText);
			tv_right = (TextView) view.findViewById(R.id.rightText);
			iv_logo = (ImageView) view.findViewById(R.id.logo);
			iv_arrow = (ImageView) view.findViewById(R.id.arrow);
			tv_title = (TextView) view.findViewById(R.id.tv_title);
			tv_title_right = (TextView) view.findViewById(R.id.tv_title_right);
			iv_right = (ImageView) view.findViewById(R.id.rightimg);
			backButton = (LinearLayout) view.findViewById(R.id.homelayout);
			iv_rl = (ImageView) view.findViewById(R.id.iv_regional_right);
			ll_rl = (LinearLayout) view.findViewById(R.id.ll_regional);
			backButton.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					BaseActivity.this.onBackPressed();
				}
			});
		}
	}

	@Override
	public void onBackPressed() {
		super.onBackPressed();
	}

	/**
	 * @Description:得到actionBar左边的文字
	 * @return
	 * @author: LiXiaoSong
	 * @date:2014-12-25
	 */
	private TextView getLeftText() {
		return tv_left;
	}

	/**
	 * @Description:得到actionBar右边的文字
	 * @return
	 * @author: LiXiaoSong
	 * @date:2014-12-25
	 */
	private TextView getRightText() {
		return tv_right;
	}

	/**
	 * @Description:得到actionBar的logo
	 * @return
	 * @author: LiXiaoSong
	 * @date:2014-12-25
	 */
	public ImageView getLogo() {
		return iv_logo;
	}

	/**
	 * @Description:得到actionBar左边的箭头
	 * @return
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
	 * @Description:得到标题右边的文字
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

	/**
	 * 得到标题右边的布局
	 * 
	 * @return
	 */
	private LinearLayout getRLayout() {
		return ll_rl;
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
		getLeftText().setVisibility(View.GONE);
		getLogo().setVisibility(View.GONE);
		getRightText().setVisibility(View.GONE);
		getArrow().setVisibility(View.VISIBLE);
		getActionTitle().setVisibility(View.VISIBLE);
		getActionTitle().setText(title);
		getRLayout().setVisibility(View.GONE);
		getImageRight().setVisibility(View.GONE);

	}

	/**
	 * @Description:获取actionBar，有左边返回按钮,标题,右边有文字和点击事件
	 * @param title
	 *            标题内容
	 * @param rightText
	 * @param rightClick
	 */
	public void getActionBarRight(String title, String rightText,
			OnClickListener rightClick) {
		useCustomerActionBar();
		getLeftText().setVisibility(View.GONE);
		getLogo().setVisibility(View.GONE);
		getRightText().setVisibility(View.VISIBLE);
		getArrow().setVisibility(View.VISIBLE);
		getActionTitle().setVisibility(View.VISIBLE);
		getActionTitle().setText(title);
		getRLayout().setVisibility(View.GONE);
		getImageRight().setVisibility(View.GONE);
		getRightText().setOnClickListener(rightClick);
		getRightText().setText(rightText);
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
		getLeftText().setVisibility(View.GONE);
		getLogo().setVisibility(View.GONE);
		getRightText().setVisibility(View.GONE);
		getArrow().setVisibility(View.VISIBLE);
		getActionTitle().setVisibility(View.VISIBLE);
		getActionTitle().setText(title);
		getRLayout().setVisibility(View.GONE);
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
		getLeftText().setVisibility(View.GONE);
		getLogo().setVisibility(View.GONE);
		getRightText().setVisibility(View.GONE);
		getArrow().setVisibility(View.GONE);
		getActionTitle().setVisibility(View.VISIBLE);
		getActionTitle().setText(title);
		getRLayout().setVisibility(View.GONE);
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
	public LinearLayout getActionBarSpeical(String title, int res,
			boolean hasLeft, boolean hasSpeical, OnClickListener rightClick) {
		useCustomerActionBar();
		getLeftText().setVisibility(View.GONE);
		getLogo().setVisibility(View.GONE);
		getRightText().setVisibility(View.GONE);
		if (hasLeft)
			getArrow().setVisibility(View.VISIBLE);
		else
			getArrow().setVisibility(View.GONE);
		getActionTitle().setVisibility(View.VISIBLE);
		getActionTitle().setText(title);
		if (hasSpeical)
			getRLayout().setVisibility(View.VISIBLE);
		else
			getRLayout().setVisibility(View.GONE);

		if (res != -1) {
			getImageRight().setVisibility(View.VISIBLE);
			getImageRight().setImageResource(res);
			getImageRight().setOnClickListener(rightClick);
		} else
			getImageRight().setVisibility(View.GONE);

		return getRLayout();
	}

	/**
	 * 将城市标记右边的图片翻转向上
	 */
	public void rlUp() {
		RotateAnimation animation = new RotateAnimation(0.0f, 180.0f,
				Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF,
				0.5f);
		animation.setFillAfter(true);
		animation.setDuration(300);
		animation.setInterpolator(new LinearInterpolator());
		iv_rl.startAnimation(animation);
	}

	/**
	 * 将城市标记右边的图片翻转向下
	 */
	public void rlDown() {
		RotateAnimation animation = new RotateAnimation(180.0f, 0.0f,
				Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF,
				0.5f);
		animation.setFillAfter(true);
		animation.setDuration(300);
		animation.setInterpolator(new LinearInterpolator());
		iv_rl.startAnimation(animation);
	}

	/**
	 * 裁剪照片
	 * 
	 * @author: LiXiaosong
	 * @date:2014-10-8
	 */
	public void cropPicture(Uri uri, int requestCode, int OUTPUT_X, int OUTPUT_Y) {
		Intent intent = new Intent("com.android.camera.action.CROP");
		intent.setDataAndType(uri, "image/*");
		intent.putExtra("crop", "true");// 可裁剪
		intent.putExtra("aspectX", 1);
		intent.putExtra("aspectY", 1);
		intent.putExtra("outputX", OUTPUT_X);
		intent.putExtra("outputY", OUTPUT_Y);
		intent.putExtra("scale", true);
		intent.putExtra("return-data", false);// 若为false则表示不返回数据
		intent.putExtra("outputFormat", Bitmap.CompressFormat.JPEG.toString());
		intent.putExtra("scale", true);// 去黑边
		intent.putExtra("scaleUpIfNeeded", true);// 去黑边
		intent.putExtra("noFaceDetection", true);
		startActivityForResult(intent, requestCode);
	}

	/**
	 * 从图库获取图片
	 * 
	 * @author: LiXiaosong
	 * @date:2014-10-8
	 */
	public void getPhotoFromGallery(int requestCode) {
		Intent intent = new Intent();
		intent.setAction(Intent.ACTION_PICK);
		intent.setType("image/*");
		startActivityForResult(intent, requestCode);
	}

	/**
	 * 拍照获取图片
	 * 
	 * @author: LiXiaosong
	 * @date:2014-10-8
	 */
	public void getPhotoByTakePicture(int requestCode) {
		String state = Environment.getExternalStorageState();
		if (state.equals(Environment.MEDIA_MOUNTED)) {
			tempName = System.currentTimeMillis() + ".jpg";
			File file = new File(Environment.getExternalStoragePublicDirectory(
					Environment.DIRECTORY_DCIM).getAbsolutePath()
					+ File.separator + tempName);
			Uri u = Uri.fromFile(file);
			Log.v("lixiaosong", "我要往这里放照片" + file.getAbsolutePath());
			Intent getImageByCamera = new Intent(
					"android.media.action.IMAGE_CAPTURE");
			getImageByCamera.putExtra(ImageColumns.ORIENTATION, 0);
			getImageByCamera.putExtra(MediaStore.EXTRA_OUTPUT, u);
			startActivityForResult(getImageByCamera, requestCode);
		} else {
			Utils.toast("未检测到SD卡，无法拍照获取图片");
		}
	}
}
