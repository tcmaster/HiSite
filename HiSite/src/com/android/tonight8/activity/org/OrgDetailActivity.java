package com.android.tonight8.activity.org;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.tonight8.R;
import com.android.tonight8.base.BaseActivity;
import com.android.tonight8.base.Tonight8App;
import com.android.tonight8.model.common.Org;
import com.lidroid.xutils.view.annotation.ViewInject;

/**
 * @Description:商家资料
 * @author LiuZhao
 * @Date2014-12-29 下午10:53:32
 */
public class OrgDetailActivity extends BaseActivity {

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
	// /** 二维码 */
	// @ViewInject(R.id.iv_two_dimension)
	// private ImageView iv_two_dimension;
	/** 地区 */
	@ViewInject(R.id.tv_place_value)
	private TextView tv_place_value;
	/** 地址 */
	@ViewInject(R.id.tv_address_value)
	private TextView tv_address_value;
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
	/** 密码修改 */
	@ViewInject(R.id.tv_pwd_change_value)
	private TextView tv_pwd_change_value;
	/** 商家实体 */
	private Org org;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_shops_detail);
		getActionBarBase("商家资料");
		// initData();
	}

	private void initData() {
		org = new Org();
		tv_shop_name_value.setText(org.name);
		Tonight8App.getSelf().bitmapUtils.display(iv_up_flag, org.logo);
		tv_shop_id_value.setText(org.id+"");
		tv_address_value.setText(org.address);
		tv_personname_value.setText(org.contactPerson);
		tv_phone_value.setText(org.contactMobilPhone);
		tv_email_value.setText(org.email);
		tv_id_value.setText(org.paperCode);
		tv_id_value.setText(org.password);
	}
}
