package com.android.tonight8.activity.createevent;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.android.tonight8.R;
import com.android.tonight8.base.BaseActivity;
import com.android.tonight8.utils.DialogUtils;
import com.android.tonight8.utils.DialogUtils.ButtonOnClick;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnClick;

/**
 * @Description:认证照片上传页面
 * @author:LiuZhao
 * @Date:2015年2月27日
 */
public class AuthPicActivity extends BaseActivity {

	/** 营业执照 */
	@ViewInject(R.id.rl_org_license)
	private RelativeLayout rl_org_license;
	/** 营业执照 */
	@ViewInject(R.id.iv_org_license)
	private ImageView iv_org_license;
	/** 身份证前面 */
	@ViewInject(R.id.rl_identity_front)
	private RelativeLayout ll_identity_front;
	/** 身份证前面 */
	@ViewInject(R.id.iv_identity_front)
	private ImageView iv_identity_front;
	/** 身份证后面 */
	@ViewInject(R.id.rl_identity_reverse)
	private RelativeLayout ll_identity_reverse;
	/** 身份证后面 */
	@ViewInject(R.id.iv_identity_reverse)
	private ImageView iv_identity_reverse;

	private ButtonOnClick buttonOnClick = new ButtonOnClick() {
		
		@Override
		public void getButton(Button leftButton, Button rightButton, AlertDialog dlg) {
			leftButton.setText("从相册选取");
			leftButton.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View arg0) {

					getPhotoFromGallery();
				}
			});
			leftButton.setText("拍照");
			rightButton.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					getPhotoByTakePicture();
				}
			});
		}
	};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		setContentView(R.layout.activity_auth_pic);
		super.onCreate(savedInstanceState);
		getActionBarBase("认证");
		initData();
	}
    @OnClick({R.id.rl_org_license,R.id.rl_identity_front,R.id.rl_identity_reverse})
	public void onClick(View arg0) {
		switch (arg0.getId()) {
		case R.id.rl_org_license:

			break;
		case R.id.rl_identity_front:
			
			break;
		case R.id.rl_identity_reverse:
			
			break;
		default:
			break;
		}
		DialogUtils.showSelectPicDialog(AuthPicActivity.this, buttonOnClick);
	}

	private void initData() {
		if (getIntent().getBooleanExtra("isPerson", true)) {
			rl_org_license.setVisibility(View.GONE);
		}

	}
}
