/**
 * 2015-1-12
 */
package com.android.tonight8.fragment.myaccount;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.tonight8.R;
import com.android.tonight8.base.BaseActivity;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;

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
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		/* 主布局初始化 */
		if (v_rootView != null) {
			/* 已存在空的view */
			return v_rootView;
		}
		v_rootView = inflater.inflate(R.layout.fragment_personinfo, container, false);
		ViewUtils.inject(this, v_rootView);
		initDatas();
		return v_rootView;
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

	private void initDatas() {
		setTextAndContent(layout_nickname, R.string.nick_name, R.drawable.arrow_down, "", "小新");
		setTextAndContent(layout_sex, R.string.sex, R.drawable.arrow_down, "", "男");
		setTextAndContent(layout_receive_address, R.string.receiver_address, R.drawable.arrow_down, "", "北京市房山区丰台");
		setTextAndContent(layout_nickname_phone_num, R.string.phone_num, R.drawable.arrow_down, "", "18600416253");
		setTextAndContent(layout_authorization, R.string.three_party, R.drawable.arrow_down, "", "");
		setTextAndContent(layout_change_psw, R.string.change_password, R.drawable.arrow_down, "", "");
	}
}
