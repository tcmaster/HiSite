package com.android.hisite.activity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.hisite.BaseActivity;
import com.android.hisite.R;
import com.lidroid.xutils.view.annotation.ViewInject;

/**
 * @Description:商家资料
 * @author LiuZhao
 * @Date2014-12-29 下午10:53:32
 */
public class ShopsDetailActivity extends BaseActivity {

	/** 名称 */
	@ViewInject(R.id.tv_shop_name_value)
	private TextView tv_shop_name_value;
	/** 上传标识 */
	@ViewInject(R.id.iv_up_flag)
	private ImageView iv_up_flag;
	/** 上传标识修改 */
	@ViewInject(R.id.tv_up_flag_change)
	private TextView tv_up_flag_change;
	/** 商家id */
	@ViewInject(R.id.tv_shop_id_value)
	private TextView tv_shop_id_value;
	/** 二维码 */
	@ViewInject(R.id.iv_two_dimension)
	private ImageView iv_two_dimension;
	/** 地区 */
	@ViewInject(R.id.tv_place_value)
	private TextView tv_place_value;
	/** 联系人 */
	@ViewInject(R.id.tv_personname_value)
	private TextView tv_personname_value;
	/** 手机号 */
	@ViewInject(R.id.tv_phone_value)
	private TextView tv_phone_value;
	/** 邮箱 */
	@ViewInject(R.id.tv_email_value)
	private TextView tv_email_value;
	/** 证件号 */
	@ViewInject(R.id.tv_id_value)
	private TextView tv_id_value;
	/** 密码 */
	@ViewInject(R.id.tv_password_value)
	private TextView tv_password_value;
	/** 密码修改*/
	@ViewInject(R.id.tv_pwd_change_value)
	private TextView tv_pwd_change_value;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_shops_detail);
	}
}
