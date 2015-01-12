package com.android.tonight8.fragment.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.tonight8.R;
import com.android.tonight8.activity.ForgetIDOrPwdActivity;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;

/**
 * @Description:发布活动
 * @author:LiuZhao
 * @Date:2014年12月15日
 */
public class PostEventsFragment extends Fragment implements OnClickListener {

	/** 主布局 */
	private View rootView = null;
	/** 滑动的图片viewpager控件 */
	@ViewInject(R.id.vp_header_events)
	private ViewPager viewPager;
	/** 登录按钮 */
	@ViewInject(R.id.btn_shop_login)
	private Button btn_shop_login;
	/** 注册按钮 */
	@ViewInject(R.id.btn_shop_register)
	private Button btn_shop_register;
	/** 忘记id */
	@ViewInject(R.id.tv_forgot_id)
	private TextView tv_forgot_id;
	/** 忘记密码 */
	@ViewInject(R.id.tv_forgot_pwd)
	private TextView tv_forgot_pwd;
	/** 商店头像 */
	@ViewInject(R.id.iv_postevents_title)
	private ImageView iv_postevents_title;
	/** 商店名称 */
	@ViewInject(R.id.tv_shopname)
	private TextView tv_shopname;
	/** 商店状态 */
	@ViewInject(R.id.tv_shop_state)
	private TextView tv_shop_state;
	/** 商店地点 */
	@ViewInject(R.id.tv_postevents_place)
	private TextView tv_postevents_place;

	/** 是否登录 */
	private boolean isLogin = true;

	/** 创建一个静态的实例 */
	public static PostEventsFragment newInstance() {
		PostEventsFragment peFragment = new PostEventsFragment();
		return peFragment;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		super.onCreateView(inflater, container, savedInstanceState);
		if (isLogin) {
			rootView = inflater.inflate(R.layout.fragment_post_events_afterlogin, container, false);
		} else {
			rootView = inflater.inflate(R.layout.fragment_post_events, container, false);
		}

		ViewUtils.inject(this, rootView); // 注入view和事件
		initView();
		return rootView;
	}

	private void initView() {
		if (isLogin) {
			tv_shopname.setText("可乐屏新一代餐饮系统");
			tv_shop_state.setText("发布：12 关注：15");
			tv_postevents_place.setText("北京 朝阳区");
		}else {
			btn_shop_login.setOnClickListener(this);
			btn_shop_register.setOnClickListener(this);
		}
	}

	@Override
	public void onClick(View v) {
		Intent intent = null;
		switch (v.getId()) {
		case R.id.btn_shop_login:

			break;
		case R.id.btn_shop_register:

			break;
		case R.id.tv_forgot_id:
			intent = new Intent(getActivity(), ForgetIDOrPwdActivity.class);
			intent.putExtra("forgottype", 0);
			startActivity(intent);
			break;
		case R.id.tv_forgot_pwd:
			intent = new Intent(getActivity(), ForgetIDOrPwdActivity.class);
			intent.putExtra("forgottype", 1);
			startActivity(intent);
			break;
		default:
			break;
		}

	}
}
