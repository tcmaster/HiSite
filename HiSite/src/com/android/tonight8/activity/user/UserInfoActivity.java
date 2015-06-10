package com.android.tonight8.activity.user;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.android.tonight8.R;
import com.android.tonight8.base.BaseActivity;
import com.android.tonight8.view.CircleImageView;
import com.lidroid.xutils.view.annotation.ViewInject;

/**
 * 用户消息界面
 * 
 * @Descripton
 * @author LiXiaoSong
 * @2015-6-9
 * @Tonight8
 */
public class UserInfoActivity extends BaseActivity {
	/** 背景图片 */
	@ViewInject(R.id.iv_background)
	private ImageView iv_background;
	/** 背景图像 */
	@ViewInject(R.id.tv_change_bg)
	private TextView tv_change_bg;
	/** 用户头像 图片 */
	@ViewInject(R.id.iv_right_arrow)
	private CircleImageView iv_right_info;
	/** 用户头像 */
	@ViewInject(R.id.rl_photo)
	private RelativeLayout rl_photo;
	/** 用户昵称 */
	@ViewInject(R.id.layout_nickname)
	private RelativeLayout layout_nickname;
	/** 用户性别 */
	@ViewInject(R.id.layout_sex)
	private RelativeLayout layout_sex;
	/** 用户手机 */
	@ViewInject(R.id.layout_phone)
	private RelativeLayout layout_phone;
	/** 用户邮箱 */
	@ViewInject(R.id.layout_email)
	private RelativeLayout layout_email;
	/** 用户所在地 */
	@ViewInject(R.id.layout_location)
	private RelativeLayout layout_location;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		initCreateOverLay(savedInstanceState, R.layout.activity_user_s);
		initDatas();
	}

	private void initDatas() {
		getActionBarBase("我");
		setTextAndContent(layout_nickname, R.string.nick_name,
				R.drawable.vnickname);
		setTextAndContent(layout_sex, R.string.sex, R.drawable.vsex);
		setTextAndContent(layout_phone, R.string.phone_num, R.drawable.vphone);
		setTextAndContent(layout_email, R.string.email_name, R.drawable.vemail);
		setTextAndContent(layout_location, R.string.location,
				R.drawable.vlocation);
	}

	private void setTextAndContent(View includeView, int leftRes, int lefticon) {
		if (includeView == null)
			return;
		TextView tv_left = (TextView) includeView
				.findViewById(R.id.tv_left_text);
		ImageView iv_left_icon = (ImageView) includeView
				.findViewById(R.id.iv_left_icon);
		if (leftRes < 0)
			tv_left.setVisibility(View.INVISIBLE);
		else
			tv_left.setText(leftRes);
		if (lefticon < 0)
			iv_left_icon.setVisibility(View.INVISIBLE);
		else
			iv_left_icon.setImageResource(lefticon);
	}
}
