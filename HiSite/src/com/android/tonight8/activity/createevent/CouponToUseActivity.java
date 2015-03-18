package com.android.tonight8.activity.createevent;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;

import com.android.tonight8.R;
import com.android.tonight8.base.BaseActivity;
import com.android.tonight8.utils.IntentUtils;
import com.lidroid.xutils.view.annotation.ViewInject;

/**
 * @Description:促销券使用
 * @author LiuZhao
 * @Date2014-12-29 下午11:30:50
 */
public class CouponToUseActivity extends BaseActivity {

	/** 检索框 */
	@ViewInject(R.id.et_coupon_code)
	private EditText et_coupon_code;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		setContentView(R.layout.activity_coupon_touse);
		super.onCreate(savedInstanceState);
		getActionBarNoReturn("促销券使用", R.drawable.ic_launcher,
				new OnClickListener() {

					@Override
					public void onClick(View arg0) {
						IntentUtils.startQRScanCodeActivity(
								CouponToUseActivity.this, 1);
					}
				});
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		if (resultCode == RESULT_OK) {
			Bundle bundle = data.getExtras();
			// 显示扫描到的内容
			String scanCode = bundle.getString("result");
			et_coupon_code.setText(scanCode);
		}
	}

}
