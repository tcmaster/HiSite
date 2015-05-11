package com.android.tonight8.fragment.main;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.android.tonight8.R;
import com.android.tonight8.activity.MainActivity;
import com.android.tonight8.activity.createevent.CouponHaveUsedActivity;
import com.android.tonight8.activity.createevent.CouponToUseActivity;
import com.android.tonight8.activity.createevent.EventsAwardManageActivity;
import com.android.tonight8.activity.createevent.EventsPlaceManageActivity;
import com.android.tonight8.activity.createevent.UserAgreementActivity;
import com.android.tonight8.activity.org.BindAgencyActivity;
import com.android.tonight8.activity.org.OrgDetailActivity;
import com.android.tonight8.activity.org.OrgMessageListActivity;
import com.android.tonight8.activity.org.UserFeedbackActivity;
import com.android.tonight8.adapter.createevent.PostEventsGridAdapter;
import com.android.tonight8.base.BaseFragment;
import com.android.tonight8.storage.org.OrgLoginNativeController;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnClick;
import com.lidroid.xutils.view.annotation.event.OnItemClick;

/**
 * @Description:发布活动
 * @author:LiuZhao
 * @Date:2014年12月15日
 */
public class PostEventMenuFragment extends BaseFragment {

	/** 主布局 */
	private View rootView = null;
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
	private MainActivity baseActivity;

	/** 创建一个静态的实例 */
	public static PostEventMenuFragment newInstance() {
		PostEventMenuFragment peFragment = new PostEventMenuFragment();
		peFragment.setHasOptionsMenu(true);
		return peFragment;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		super.onCreateView(inflater, container, savedInstanceState);
		rootView = inflater.inflate(R.layout.fragment_post_events_afterlogin,
				container, false);
		ViewUtils.inject(this, rootView); // 注入view和事件

		initData();
		return rootView;
	}

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		baseActivity = (MainActivity) activity;
	}

	@Override
	public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
		baseActivity.getActionBarNormal("发活动", R.drawable.ic_launcher,
				new OnClickListener() {

					@Override
					public void onClick(View arg0) {
						Intent intent = new Intent(baseActivity,
								OrgMessageListActivity.class);
						startActivityForAnima(intent, baseActivity);
					}
				});
		super.onCreateOptionsMenu(menu, inflater);
	}

	@OnItemClick(R.id.gv_postevents_main)
	public void onItemClick(AdapterView<?> arg0, View arg1, int position,
			long arg3) {
		Intent intent = null;
		switch (position) {
		case 0:
			intent = new Intent(getActivity(), UserAgreementActivity.class);
			break;
		case 1:
			intent = new Intent(getActivity(), EventsAwardManageActivity.class);
			break;
		case 2:
			intent = new Intent(getActivity(), CouponToUseActivity.class);
			break;
		case 3:
			intent = new Intent(getActivity(), BindAgencyActivity.class);
			break;
		case 4:
			intent = new Intent(getActivity(), CouponHaveUsedActivity.class);
			break;
		case 5:
			intent = new Intent(getActivity(), EventsPlaceManageActivity.class);
			break;
		case 6:
			intent = new Intent(getActivity(), UserFeedbackActivity.class);
			break;
		case 7:
			// baseActivity.UpdateLoginedFragment(false);
			break;
		default:
			break;
		}
		startActivityForAnima(intent, getActivity());
	}

	private void initData() {
		OrgLoginNativeController orgLogin = new OrgLoginNativeController(
				getActivity());
		// tv_shop_id.setText(orgLogin.getOrgLoginInfo());
		tv_shop_id.setText("15210162168");
		tv_shopname.setText("可乐屏新一代餐饮系统");
		tv_shop_state.setText("发布：12 关注：15");
		tv_postevents_place.setText("北京 朝阳区");
		gridAdapter = new PostEventsGridAdapter(getActivity());
		gv_postevents_main.setAdapter(gridAdapter);
		// QRCodeUtils.createQRImage(tv_shop_id.getText().toString(),
		// iv_two_dimension);

	}

	@OnClick(R.id.rl_org_account)
	public void onClick(View v) {
		Intent intent = null;
		switch (v.getId()) {

		case R.id.rl_org_account:
			intent = new Intent(getActivity(), OrgDetailActivity.class);
			startActivityForAnima(intent, getActivity());
			break;
		}
	}
}
