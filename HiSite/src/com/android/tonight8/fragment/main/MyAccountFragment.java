package com.android.tonight8.fragment.main;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.android.tonight8.R;
import com.android.tonight8.activity.user.UserInfoActivity;
import com.android.tonight8.base.AppConstants;
import com.android.tonight8.fragment.myaccount.MyAccountBaseFragment;
import com.android.tonight8.view.RolePopupWindow;
import com.android.tonight8.view.RolePopupWindow.RolePopupWindowCallBack;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnClick;

/**
 * @Description:我的账户
 * @author:LiXiaoSong
 * @Date:2014年12月15日
 */
public class MyAccountFragment extends MyAccountBaseFragment {

	// *********************视图成员****************************//
	/** 根布局 */
	private View v_rootView;
	/** 上边布局 */
	@ViewInject(R.id.rl_head)
	private RelativeLayout rl_head;
	/** 中间布局 */
	@ViewInject(R.id.ll_center_layout)
	private LinearLayout ll_center_layout;
	/** 用户图片 */
	@ViewInject(R.id.iv_user_photo)
	private ImageView iv_user_photo;
	/** 用户名 */
	@ViewInject(R.id.tv_user_name)
	private TextView tv_user_name;
	/** 用户地址 */
	@ViewInject(R.id.tv_user_address)
	private TextView tv_user_address;
	/** 用户角色 */
	@ViewInject(R.id.tv_user_role)
	private TextView tv_user_role;
	/** 中奖号码 */
	@ViewInject(R.id.layout_award_no)
	private RelativeLayout layout_award_no;
	/** 我的红包 */
	@ViewInject(R.id.layout_my_redpacket)
	private RelativeLayout layout_my_redpacket;
	/** 我的订单 */
	@ViewInject(R.id.layout_my_orders)
	private RelativeLayout layout_my_orders;
	/** 我的地址 */
	@ViewInject(R.id.layout_my_address)
	private RelativeLayout layout_my_address;
	/** 我要当卖手 */
	@ViewInject(R.id.layout_act_seller)
	private RelativeLayout layout_act_seller;
	/** 我要当商家 */
	@ViewInject(R.id.layout_act_org)
	private RelativeLayout layout_act_org;
	/** 我的账户 */
	@ViewInject(R.id.layout_my_money)
	private RelativeLayout layout_my_money;
	/** 我的心愿 */
	@ViewInject(R.id.layout_my_wish)
	private RelativeLayout layout_my_wish;
	/** 我的活动 */
	@ViewInject(R.id.layout_my_event)
	private RelativeLayout layout_my_event;
	/** 我的收藏 */
	@ViewInject(R.id.layout_my_save)
	private RelativeLayout layout_my_save;
	/** 我的关注 */
	@ViewInject(R.id.layout_my_attention)
	private RelativeLayout layout_my_attention;
	/** 消息中心 */
	@ViewInject(R.id.layout_my_message)
	private RelativeLayout layout_my_message;
	/** 设置 */
	@ViewInject(R.id.layout_my_settings)
	private RelativeLayout layout_my_settings;
	/** 账户角色0用户1卖手2商家 */
	private int AccountType = 2;

	// *********************其他成员****************************//
	private RolePopupWindow window;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		/* 主布局初始化 */
		if (v_rootView != null) {
			/* 已存在空的view */
			return v_rootView;
		}
		v_rootView = inflater.inflate(R.layout.fragment_myaccount, container,
				false);
		ViewUtils.inject(this, v_rootView);
		initDatas();
		return v_rootView;
	}

	private void initDatas() {
		setTextAndContent(layout_award_no, R.drawable.vaward, R.string.my_code,
				null, null, true);
		setTextAndContent(layout_my_redpacket, R.drawable.vredpacket,
				R.string.my_redpecket, null, null, true);
		setTextAndContent(layout_my_orders, R.drawable.vorder,
				R.string.my_order, null, null, true);
		setTextAndContent(layout_my_address, R.drawable.vaddress,
				R.string.my_address, null, null, true);
		setTextAndContent(layout_act_seller, R.drawable.vseller,
				R.string.my_seller_role, null, null, true);
		setTextAndContent(layout_act_org, R.drawable.vorg,
				R.string.my_org_role, null, null, true);
		setTextAndContent(layout_my_money, R.drawable.vlove,
				R.string.my_account, null, null, true);
		setTextAndContent(layout_my_wish, R.drawable.vlove, R.string.my_wish,
				null, null, true);
		setTextAndContent(layout_my_event, R.drawable.vattention,
				R.string.my_event, null, null, true);
		setTextAndContent(layout_my_save, R.drawable.vsave, R.string.my_save,
				null, null, true);
		setTextAndContent(layout_my_attention, R.drawable.vattention,
				R.string.my_attention, null, null, true);
		setTextAndContent(layout_my_message, R.drawable.vmessage,
				R.string.message_center, null, null, false);
		setTextAndContent(layout_my_settings, R.drawable.vsetting,
				R.string.settings, null, null, false);
		tv_user_role.setText("用户");
		rl_head.getLayoutParams().height = AppConstants.heightPx / 10 * 1;
		ll_center_layout.getLayoutParams().height = AppConstants.heightPx / 10 * 8;
		if (AccountType == 0) {

		} else if (AccountType == 1) {

		} else if (AccountType == 2) {
			// layout_my_wish.setVisibility(View.GONE);
		}

	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		window = new RolePopupWindow(getActivity(),
				new RolePopupWindowCallBack() {

					@Override
					public void onUser(String userText) {
						tv_user_role.setText(userText);
					}

					@Override
					public void onSeller(String sellerText) {
						tv_user_role.setText(sellerText);
					}

					@Override
					public void onOrg(String orgText) {
						tv_user_role.setText(orgText);
					}
				});
	}

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);

	}

	@OnClick({ R.id.tv_user_role, R.id.iv_user_photo })
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.tv_user_role:
			window.showWindow(tv_user_role);
			break;
		case R.id.iv_user_photo:
			Intent intent = new Intent(getActivity(), UserInfoActivity.class);
			startActivity(intent);
			break;
		default:
			break;
		}
	}

	/** 创建一个静态的实例 */
	public static final MyAccountFragment newInstance() {
		MyAccountFragment saFragment = new MyAccountFragment();
		return saFragment;
	}
}
