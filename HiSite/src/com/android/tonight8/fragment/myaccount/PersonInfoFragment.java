/**
 * 2015-1-12
 */
package com.android.tonight8.fragment.myaccount;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.tonight8.R;
import com.android.tonight8.activity.user.UserAddressActivity;
import com.android.tonight8.base.BaseActivity;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnClick;

/**
 * @Description:个人资料信息Fragment
 * @author:LiXiaoSong
 * @copyright @HiSite
 * @Date:2015-1-12
 */
public class PersonInfoFragment extends MyAccountBaseFragment {

	/** 根布局 */
	private View v_rootView;
	/** 昵称 */
	@ViewInject(R.id.layout_nickname)
	View layout_nickname;
	/** 性别 */
	@ViewInject(R.id.layout_sex)
	View layout_sex;
	/** 收货地址 */
	@ViewInject(R.id.layout_receive_address)
	View layout_receive_address;
	/** 手机号 */
	@ViewInject(R.id.layout_nickname_phone_num)
	View layout_nickname_phone_num;
	/** 第三方账号授权 */
	@ViewInject(R.id.layout_authorization)
	View layout_authorization;
	/** 修改密码 */
	@ViewInject(R.id.layout_change_psw)
	View layout_change_psw;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		/* 主布局初始化 */
		if (v_rootView != null) {
			/* 已存在空的view */
			return v_rootView;
		}
		v_rootView = inflater.inflate(R.layout.fragment_personinfo, container,
				false);
		ViewUtils.inject(this, v_rootView);
		return v_rootView;
	}

	@OnClick({ R.id.layout_receive_address })
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.layout_receive_address:
			processClickReceiveAddress();
			break;

		default:
			break;
		}
	}

	@Override
	public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
		((BaseActivity) getActivity()).getActionBarBase("个人资料");
		super.onCreateOptionsMenu(menu, inflater);
	}

	public static PersonInfoFragment newInstance() {
		PersonInfoFragment fg = new PersonInfoFragment();
		fg.setHasOptionsMenu(true);
		return fg;
	}

	/**
	 * 点击收货地址时的处理
	 */
	private void processClickReceiveAddress() {
		Intent intent = new Intent(getActivity(), UserAddressActivity.class);
		startActivity(intent);
	}

}
