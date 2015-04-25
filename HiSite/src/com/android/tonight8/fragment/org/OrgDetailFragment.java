package com.android.tonight8.fragment.org;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.tonight8.R;
import com.android.tonight8.base.BaseFragment;
import com.android.tonight8.base.Tonight8App;
import com.android.tonight8.model.common.Org;
import com.android.tonight8.utils.QRCodeUtils;
import com.lidroid.xutils.view.annotation.ViewInject;

/**
 * @author lz 商家详情
 * 
 */
public class OrgDetailFragment extends BaseFragment {
	/** 商家标识 */
	@ViewInject(R.id.iv_org_logo)
	private ImageView iv_org_logo;
	/** 名称 */
	@ViewInject(R.id.tv_shop_name_value)
	private TextView tv_shop_name_value;
	/** 商家id */
	@ViewInject(R.id.tv_shop_id_value)
	private TextView tv_shop_id_value;
	/** 商家二维码 */
	@ViewInject(R.id.iv_org_dimension)
	private ImageView iv_org_dimension;
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
	/** 电话 */
	@ViewInject(R.id.tv_tele_value)
	private TextView tv_tele_value;
	/** 邮箱 */
	@ViewInject(R.id.tv_email_value)
	private TextView tv_email_value;
	/** 网站 */
	@ViewInject(R.id.tv_org_website)
	private TextView tv_org_website;
	/** 微博 */
	@ViewInject(R.id.tv_org_weibo)
	private TextView tv_org_weibo;
	/** 网站 */
	@ViewInject(R.id.tv_org_weixinhao)
	private TextView tv_org_weixinhao;
	/** 微信二维码 */
	@ViewInject(R.id.iv_weixin_twocode)
	private ImageView iv_weixin_twocode;
	/** 商家简介 */
	@ViewInject(R.id.tv_org_description)
	private TextView tv_org_description;
	/** 商家实体 */
	private Org org;

	public static final OrgDetailFragment newInstance() {
		OrgDetailFragment orgDetailFragment = new OrgDetailFragment();
		return orgDetailFragment;
	}

	private View rootView;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		rootView = inflater.inflate(R.layout.fragment_org_detail, container, false);
		if (getUserVisibleHint()) {
			initData();
		}

		return rootView;

	}

	@Override
	public void setUserVisibleHint(boolean isVisibleToUser) {
		super.setUserVisibleHint(isVisibleToUser);
	}

	private void initData() {

		org = new Org();
		tv_shop_name_value.setText(org.name);
		Tonight8App.getSelf().bitmapUtils.display(iv_org_logo, org.logo);
		tv_shop_name_value.setText(org.name);
		tv_shop_id_value.setText(org.id + "");
		QRCodeUtils.createQRImage(org.id + "", iv_org_dimension);
		tv_place_value.setText(org.address);
		tv_address_value.setText(org.address);
		tv_personname_value.setText(org.contactPerson);
		tv_phone_value.setText(org.contactMobilPhone);
		tv_email_value.setText(org.email);
		tv_tele_value.setText(org.telphone);
		// tv_org_website.setText();
		tv_org_description.setText(org.intro);
	}
}
