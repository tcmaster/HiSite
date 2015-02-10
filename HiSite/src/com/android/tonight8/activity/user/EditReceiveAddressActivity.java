package com.android.tonight8.activity.user;

import java.util.ArrayList;
import java.util.List;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.android.tonight8.R;
import com.android.tonight8.base.BaseActivity;
import com.android.tonight8.view.CustomerDialog;
import com.android.tonight8.view.CustomerDialog.CustomerViewInterface;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnClick;

public class EditReceiveAddressActivity extends BaseActivity {

	/** 收货人姓名 */
	@ViewInject(R.id.tv_receiver_name)
	private TextView tv_receiver_name;
	/** 收货人电话 */
	@ViewInject(R.id.tv_phone)
	private TextView tv_phone;
	/** 收货省份 */
	@ViewInject(R.id.tv_province)
	private TextView tv_province;
	/** 收货详细地址 */
	@ViewInject(R.id.et_detail_address)
	private TextView et_detail_address;
	/** 确认按钮 */
	@ViewInject(R.id.tv_ok)
	private TextView tv_ok;
	/** 选择收货省份 */
	@ViewInject(R.id.layout_province)
	private LinearLayout layout_province;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		setContentView(R.layout.activity_edit_receive_address);
		super.onCreate(savedInstanceState);
		getActionBarBase("编辑地址");
	}

	@OnClick({ R.id.layout_province, R.id.tv_ok })
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.layout_province:
			processChoiceProvince();
			break;
		case R.id.tv_ok:
			processOk();
			break;
		default:
			break;
		}
	}

	private void processChoiceProvince() {
		CustomerDialog cdlg = new CustomerDialog(this, R.layout.dlg_list_simple);
		cdlg.setLayoutGravity(Gravity.BOTTOM);
		cdlg.setDismissIfClick(true);
		cdlg.setOnCustomerViewCreated(new CustomerViewInterface() {

			@Override
			public void getCustomerView(Window window, AlertDialog dlg) {
				ListView lv_simple = (ListView) window.findViewById(R.id.lv_list_simple);
				List<String> testData = new ArrayList<String>();
				testData.add("北京");
				testData.add("山东");
				testData.add("广州");
				lv_simple.setAdapter(new ArrayAdapter<String>(EditReceiveAddressActivity.this, android.R.layout.simple_list_item_1, testData));
			}
		});
		cdlg.showDlg();
	}

	private void processOk() {

	}
}
