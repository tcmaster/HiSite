package com.android.hisite.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;

import com.android.hisite.R;
import com.android.utils.StringUtils;
import com.lidroid.xutils.BitmapUtils;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.util.LogUtils;
import com.lidroid.xutils.view.annotation.ViewInject;

/**
 * @Description:发布活动
 * @author:LiuZhao
 * @Date:2014年12月15日
 */
public class PostEventsFragment extends Fragment implements OnClickListener {

	/** 主布局 */
	private View rootView;
	/** 滑动的图片viewpager控件 */
	@ViewInject(R.id.vp_header_events)
	private ViewPager viewPager;
	/** 登录按钮 */
	@ViewInject(R.id.btn_shop_login)
	private Button btn_shop_login;
	/** 注册按钮 */
	@ViewInject(R.id.btn_shop_register)
	private Button btn_shop_register;

	/** 创建一个静态的实例 */
	public static PostEventsFragment newInstance() {
		PostEventsFragment peFragment = new PostEventsFragment();
		return peFragment;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		super.onCreateView(inflater, container, savedInstanceState);
		/* 主布局初始化 */
		if (rootView != null) {
			return rootView;
		}
		rootView = inflater.inflate(R.layout.fragment_post_events, container, false);
		ViewUtils.inject(this, rootView); // 注入view和事件
		initView();
		return rootView;
	}

	private void initView() {
		btn_shop_login.setOnClickListener(this);
		btn_shop_register.setOnClickListener(this);
	}

	/**
	 * 构造ViewPage页面
	 * 
	 * @param context
	 * @param imgResId
	 * @return
	 */
	private ImageView getPageView(final Context context, int imgResId, String imgUrl) {

		DisplayMetrics dm = new DisplayMetrics();
		getActivity().getWindowManager().getDefaultDisplay().getMetrics(dm);
		LogUtils.i("width=" + dm.widthPixels + "---" + getActivity().getWindowManager().getDefaultDisplay().getWidth());
		imgUrl = "http://bbs.lidroid.com/static/image/common/logo.png";
		ImageView iv = new ImageView(context);
		iv.setScaleType(ScaleType.FIT_XY);
		iv.setImageResource(R.drawable.ic_launcher);
		if (!StringUtils.isNullOrEmpty(imgUrl)) {
			BitmapUtils bitmapUtils = new BitmapUtils(getActivity());
			// 加载网络图片
			bitmapUtils.display(iv, imgUrl);
		} else {
			iv.setImageResource(imgResId);// 不可拉伸图片
		}

		return iv;
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btn_shop_login:

			break;
		case R.id.btn_shop_register:

			break;
		default:
			break;
		}

	}
}
