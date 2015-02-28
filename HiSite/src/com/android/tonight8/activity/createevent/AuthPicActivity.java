package com.android.tonight8.activity.createevent;

import java.io.FileNotFoundException;

import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
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
import com.lidroid.xutils.util.LogUtils;
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
	/** 0营业执照1身份证前面2身份证后面 */
	private int imageType = 0;
	/** 营业执照 身份证前面 身份证后面 */
	private String licensePicPath, idFrontPicPath, idReversePicPath;

	private ButtonOnClick buttonOnClick = new ButtonOnClick() {

		@Override
		public void getButton(Button leftButton, Button rightButton, final AlertDialog dlg) {

			leftButton.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View arg0) {

					getPhotoFromGallery();
					dlg.dismiss();
				}
			});

			rightButton.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View arg0) {
					getPhotoByTakePicture();
					dlg.dismiss();
				}
			});
		}
	};

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		if (resultCode != RESULT_OK) {
			return;
		}

		switch (imageType) {

		case 0: // 0营业执照
			if (requestCode == PICKPICTURE) {
				Uri selectedImage = data.getData();
				cropPicture(selectedImage);
			} else if (requestCode == TAKEPHOTO) {

			} else if (requestCode == CROP) {
				try {
					Uri cropImageUri = data.getData();
					// 图片解析成Bitmap对象
					Bitmap bitmap = BitmapFactory.decodeStream(getContentResolver().openInputStream(cropImageUri));
					iv_org_license.setImageBitmap(bitmap); // 将剪裁后照片显示出来
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
			}

			break;

		case 1: // 1身份证前面
			if (requestCode == PICKPICTURE) {
				Uri selectedImage = data.getData();
				cropPicture(selectedImage);
			} else if (requestCode == TAKEPHOTO) {

			} else if (requestCode == CROP) {
				try {
					Uri cropImageUri = data.getData();
					// 图片解析成Bitmap对象
					Bitmap bitmap = BitmapFactory.decodeStream(getContentResolver().openInputStream(cropImageUri));
					iv_identity_front.setImageBitmap(bitmap); // 将剪裁后照片显示出来
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
			}
			break;
		case 2: // 2身份证后面
			if (requestCode == PICKPICTURE) {
				Uri selectedImage = data.getData();
				cropPicture(selectedImage);
			} else if (requestCode == TAKEPHOTO) {

			} else if (requestCode == CROP) {
				try {
					Uri cropImageUri = data.getData();
					idReversePicPath = cropImageUri.getPath();
					LogUtils.d("身份证反面的路径" + idReversePicPath);
					// 图片解析成Bitmap对象
					Bitmap bitmap = BitmapFactory.decodeStream(getContentResolver().openInputStream(cropImageUri));
					iv_identity_reverse.setImageBitmap(bitmap); // 将剪裁后照片显示出来
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
			}
			break;
		default:
			break;
		}

	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		setContentView(R.layout.activity_auth_pic);
		super.onCreate(savedInstanceState);
		getActionBarBase("认证");
		initData();
	}

	@OnClick({ R.id.rl_org_license, R.id.rl_identity_front, R.id.rl_identity_reverse })
	public void onClick(View arg0) {
		switch (arg0.getId()) {
		case R.id.rl_org_license:
			imageType = 0;
			break;
		case R.id.rl_identity_front:
			imageType = 1;
			break;
		case R.id.rl_identity_reverse:
			imageType = 2;
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
