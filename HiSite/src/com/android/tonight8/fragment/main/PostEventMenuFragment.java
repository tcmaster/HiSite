package com.android.tonight8.fragment.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.android.tonight8.R;
import com.android.tonight8.activity.createevent.OrgDetailActivity;
import com.android.tonight8.adapter.createevent.PostEventsGridAdapter;
import com.android.tonight8.utils.QRCodeUtils;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnClick;

/**
 * @Description:发布活动
 * @author:LiuZhao
 * @Date:2014年12月15日
 */
public class PostEventMenuFragment extends Fragment {

	/** 主布局 */
	private View rootView = null;
	/** 滑动的图片viewpager控件 */
	@ViewInject(R.id.vp_header_events)
	private ViewPager viewPager;
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
	/** 我的帐号通栏布局 */
	@ViewInject(R.id.rl_org_account)
	private RelativeLayout rl_org_account;
	/** 请输入商家名称 */
	@ViewInject(R.id.et_org_id)
	private EditText et_org_id;
	/** 请输入商家登录密码 */
	@ViewInject(R.id.et_org_loginpwd)
	private EditText et_org_loginpwd;
	private PostEventsGridAdapter gridAdapter;

	/** 创建一个静态的实例 */
	public static PostEventMenuFragment newInstance() {
		PostEventMenuFragment peFragment = new PostEventMenuFragment();
		return peFragment;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		super.onCreateView(inflater, container, savedInstanceState);
		rootView = inflater.inflate(R.layout.fragment_post_events_afterlogin, container, false);
		ViewUtils.inject(this, rootView); // 注入view和事件
		initView();
		return rootView;
	}

	private void initView() {

		tv_shopname.setText("可乐屏新一代餐饮系统");
		tv_shop_state.setText("发布：12 关注：15");
		tv_postevents_place.setText("北京 朝阳区");
		gridAdapter = new PostEventsGridAdapter(getActivity());
		gv_postevents_main.setAdapter(gridAdapter);
		tv_shop_id.setText("21131243");
		QRCodeUtils.createQRImage(tv_shop_id.getText().toString(), iv_two_dimension);

	}

	@OnClick(R.id.rl_org_account)
	public void onClick(View v) {
		Intent intent = null;
		switch (v.getId()) {

		case R.id.rl_org_account:
			intent = new Intent(getActivity(), OrgDetailActivity.class);
			startActivity(intent);
			break;
		}
	}
}
