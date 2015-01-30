package com.android.tonight8.fragment.main;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.tonight8.R;
import com.android.tonight8.activity.MainActivity;
import com.android.tonight8.activity.createevent.ForgetIDOrPwdActivity;
import com.android.tonight8.activity.createevent.OrgRegisterActivity;
import com.android.tonight8.adapter.event.MyPagerAdapter;
import com.android.tonight8.base.BaseFragment;
import com.android.tonight8.function.CirculateFunction;
import com.android.tonight8.utils.StringUtils;
import com.android.tonight8.utils.Utils;
import com.android.tonight8.view.PointLinearlayout;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnClick;

/**
 * @Description:商家登录
 * @author:LiuZhao
 * @Date:2014年12月15日
 */
public class OrgLoginFragment extends BaseFragment {

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
	/** 商家头像 */
	@ViewInject(R.id.iv_postevents_title)
	private ImageView iv_postevents_title;
	/** 商家名称 */
	@ViewInject(R.id.tv_shopname)
	private TextView tv_shopname;
	/** 商家id */
	@ViewInject(R.id.tv_shop_id)
	private TextView tv_shop_id;
	/** 商家状态 */
	@ViewInject(R.id.tv_shop_state)
	private TextView tv_shop_state;
	/** 商家地点 */
	@ViewInject(R.id.tv_postevents_place)
	private TextView tv_postevents_place;
	/** 页面主菜单 */
	@ViewInject(R.id.gv_postevents_main)
	private GridView gv_postevents_main;
	/** 二维码 */
	@ViewInject(R.id.iv_two_dimension)
	private ImageView iv_two_dimension;
	/** 请输入商家名称 */
	@ViewInject(R.id.et_org_id)
	private EditText et_org_id;
	/** 请输入商家登录密码 */
	@ViewInject(R.id.et_org_loginpwd)
	private EditText et_org_loginpwd;
	/** 图片轮播底部的圆点父布局 */
	@ViewInject(R.id.pll_point_container)
	private PointLinearlayout pll_point_container;
	private MainActivity mainActivity;
	/** 测试数据 */
	private List<String> data;
	/** vp轮播功能 */
	private CirculateFunction cFunction;
	/** 头部轮播布局 */
	@ViewInject(R.id.fl_header_events)
	private FrameLayout frameLayout;

	/** 创建一个静态的实例 */
	public static OrgLoginFragment newInstance() {
		OrgLoginFragment peFragment = new OrgLoginFragment();
		return peFragment;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		super.onCreateView(inflater, container, savedInstanceState);
		rootView = inflater.inflate(R.layout.fragment_post_events, container, false);
		ViewUtils.inject(this, rootView); // 注入view和事件
		initView();
		return rootView;
	}

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		mainActivity = (MainActivity) activity;
	}

	private void initView() {
		data = new ArrayList<String>();
		data.add("http://g.hiphotos.baidu.com/image/pic/item/622762d0f703918fce56b5d6523d269759eec423.jpg");
		data.add("http://f.hiphotos.baidu.com/image/pic/item/8cb1cb1349540923c841dc779058d109b3de498a.jpg");
		data.add("http://c.hiphotos.baidu.com/image/w%3D230/sign=68825dc2e2fe9925cb0c6e5304a95ee4/9e3df8dcd100baa19fba02bc4510b912c8fc2e26.jpg");
		data.add("http://f.hiphotos.baidu.com/image/pic/item/cdbf6c81800a19d8697b640331fa828ba61e46b8.jpg");
		pll_point_container.setPointCount(4);
		pll_point_container.changePoint(0);
		viewPager.setAdapter(new MyPagerAdapter(getActivity(), data));
		viewPager.setCurrentItem(0);
		viewPager.setOnPageChangeListener(new OnPageChangeListener() {

			@Override
			public void onPageSelected(int arg0) {
				pll_point_container.changePoint(arg0);
			}

			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
			}

			@Override
			public void onPageScrollStateChanged(int arg0) {
			}
		});
		cFunction = new CirculateFunction(viewPager.getAdapter().getCount(), 5, new Handler() {

			@Override
			public void handleMessage(Message msg) {
				viewPager.setCurrentItem(msg.what);
				super.handleMessage(msg);
			}
		});
		cFunction.start();// 开始轮播
	}

	@OnClick({ R.id.btn_shop_login, R.id.btn_shop_register, R.id.tv_forgot_id, R.id.tv_forgot_pwd })
	public void onClick(View v) {
		Intent intent = null;
		switch (v.getId()) {
		case R.id.btn_shop_login:
			String orgid = et_org_id.getText().toString();
			String orgpwd = et_org_loginpwd.getText().toString();
			if (StringUtils.isNullOrEmpty(orgid)) {
				Utils.toast("请输入商家ID");
				return;
			}
			if (StringUtils.isNullOrEmpty(orgpwd)) {
				Utils.toast("请输入密码");
				return;
			}
			mainActivity.UpdateLoginedFragment(true);
			break;
		case R.id.btn_shop_register:
			intent = new Intent(getActivity(), OrgRegisterActivity.class);
			startActivityForAnima(intent, getActivity());
			break;
		case R.id.tv_forgot_id:
			intent = new Intent(getActivity(), ForgetIDOrPwdActivity.class);
			intent.putExtra("forgottype", 0);
			startActivityForAnima(intent, getActivity());
			break;
		case R.id.tv_forgot_pwd:
			intent = new Intent(getActivity(), ForgetIDOrPwdActivity.class);
			intent.putExtra("forgottype", 1);
			startActivityForAnima(intent, getActivity());
			break;
		default:
			break;
		}

	}
}
