package com.android.tonight8.activity;

import android.os.Bundle;
import android.view.Menu;
import android.widget.ImageView;
import android.widget.TextView;
import com.android.tonight8.R;
import com.android.tonight8.base.BaseActivity;
import com.android.tonight8.utils.QRCodeUtils;
import com.lidroid.xutils.view.annotation.ViewInject;

/**
 * 
 * @Description:主办方详情页
 * @author:LiXiaoSong
 * @copyright @tonight8
 * @Date:2015-1-7
 */
public class AboutUsActivity extends BaseActivity {

	// ***************************控件成员***********************************//
	/** 二维码图片 */
	@ViewInject(R.id.iv_qd_code)
	ImageView iv_qc_code;
	/** 公司logo */
	@ViewInject(R.id.iv_com_logo)
	ImageView iv_company_logo;
	/** 公司标题 */
	@ViewInject(R.id.tv_title_top)
	TextView tv_title_top;
	/** 发布 */
	@ViewInject(R.id.tv_publish)
	TextView tv_publish;
	/** 关注 */
	@ViewInject(R.id.tv_attention)
	TextView tv_attention;
	/** 发布 */
	@ViewInject(R.id.tv_location)
	TextView tv_location;
	/** 公司全称 */
	@ViewInject(R.id.tv_company_name)
	TextView tv_company_name;
	/** 简介 */
	@ViewInject(R.id.tv_company_introduce)
	TextView tv_company_introduce;
	/** 地址 */
	@ViewInject(R.id.tv_company_address)
	TextView tv_company_address;
	/** 联系人 */
	@ViewInject(R.id.tv_company_contact)
	TextView tv_company_contact;
	/** 联系电话 */
	@ViewInject(R.id.tv_company_phone)
	TextView tv_company_phone;
	/** 网址 */
	@ViewInject(R.id.tv_company_net_address)
	TextView tv_company_net_address;
	/** email */
	@ViewInject(R.id.tv_company_email)
	TextView tv_company_email;
	/** 微博 */
	@ViewInject(R.id.tv_company_weibo)
	TextView tv_company_weibo;
	/** 微信 */
	@ViewInject(R.id.tv_company_weixin)
	TextView tv_company_weixin;
	/** 其他 */
	@ViewInject(R.id.tv_company_other)
	TextView tv_company_other;

	// ***************************其他成员***********************************//
	// ***************************生命周期,回调方法***********************************//
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		setContentView(R.layout.activity_about_us);
		super.onCreate(savedInstanceState);
		QRCodeUtils.createQRImage("这是我们的项目，嗷嗷嗷，欢迎", iv_qc_code);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// getMenuInflater().inflate(R.menu.about_us, menu);
		return true;
	}
	// ***************************子方法***********************************//

}
