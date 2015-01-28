/**
 * 2015-1-8
 */
package com.android.tonight8.utils;

import java.util.Calendar;

import android.app.Activity;
import android.app.AlertDialog;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ListView;
import android.widget.TextView;

import com.android.tonight8.R;
import com.android.tonight8.view.CustomerDialog;
import com.android.tonight8.view.CustomerDialog.CustomerViewInterface;

/**
 * @Description:对话框工厂类
 * @author:LiXiaoSong
 * @copyright @tonight8
 * @Date:2015-1-8
 */
public class DialogUtils {

	public static final int TYPE_SIMPLE_LIST = 1;

	public static void showListDialog(Activity act, int type, ListDialogInterface listener) {
		int res = -1;
		switch (type) {
		case TYPE_SIMPLE_LIST:
			res = R.layout.dlg_list_simple;
			break;
		default:
			break;
		}
		CustomerDialog cdlg = new CustomerDialog(act, res);
		cdlg.setOnCustomerViewCreated(listener);
		cdlg.showDlg();
	}

	public static abstract class ListDialogInterface implements CustomerViewInterface {

		@Override
		public void getCustomerView(Window window, AlertDialog dlg) {
			ListView lv_simple = (ListView) window.findViewById(R.id.lv_list_simple);// 找到listView
			getListView(lv_simple, dlg);
		}

		public abstract void getListView(ListView lv_list, final AlertDialog dlg);

	}

	public static void showSelectDateDialog(final Activity activity, final TextView inputDate) {
		final Calendar calendar = Calendar.getInstance();
		// initDateTime = calendar.get(Calendar.YEAR) + "年" + calendar.get(Calendar.MONTH) + "月" +
		// calendar.get(Calendar.DAY_OF_MONTH) + "日 " + calendar.get(Calendar.HOUR_OF_DAY) + ":" +
		// calendar.get(Calendar.MINUTE);
		final CustomerDialog cdlg = new CustomerDialog(activity, R.layout.common_select_date);
		cdlg.setOnCustomerViewCreated(new CustomerViewInterface() {

			@Override
			public void getCustomerView(Window window, AlertDialog dlg) {
				final DatePicker datePicker = (DatePicker) window.findViewById(R.id.datepicker);
				calendar.set(datePicker.getYear(), datePicker.getMonth(), datePicker.getDayOfMonth());
				Button btn_cancel = (Button) window.findViewById(R.id.btn_cancel);
				Button btn_ok = (Button) window.findViewById(R.id.btn_ok);
				btn_cancel.setOnClickListener(new OnClickListener() {

					@Override
					public void onClick(View arg0) {
						cdlg.dismissDlg();
					}
				});
				btn_ok.setOnClickListener(new OnClickListener() {

					@Override
					public void onClick(View arg0) {
						String month = String.valueOf(datePicker.getMonth() + 1);
						String initDateTime = datePicker.getYear() + "年" + month + "月" + datePicker.getDayOfMonth() + "日 ";
						inputDate.setText(initDateTime);
						cdlg.dismissDlg();
					}
				});
			}
		});
		Utils.hideSoftKeyBoard(activity);
		cdlg.showDlg();
	}

}
