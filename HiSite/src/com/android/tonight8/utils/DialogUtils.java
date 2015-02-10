/**
 * 2015-1-8
 */
package com.android.tonight8.utils;

import java.util.Calendar;

import android.app.Activity;
import android.app.AlertDialog;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.CalendarView.OnDateChangeListener;
import android.widget.DatePicker;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TextView;

import com.android.tonight8.R;
import com.android.tonight8.adapter.createevent.ShareAdapter;
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

	/**
	 * @Description:选择日期的对话框，默认日期是当前系统日期
	 * @param activity
	 * @param inputDate
	 * @author: LiuZhao
	 * @date:2015年1月29日
	 */

	public static void showSelectDateDialog(final Activity activity, final TextView inputDate) {
		final Calendar calendar = Calendar.getInstance();
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

	/**
	 * @Description:选择日历的对话框，默认日期是当前系统日期
	 * @param activity
	 * @param inputDate
	 * @author: LiuZhao
	 * @date:2015年1月29日
	 */

	public static void showSelectCalendarDialog(final Activity activity, final TextView inputDate) {
		final CustomerDialog cdlg = new CustomerDialog(activity, R.layout.common_select_calendar);
		cdlg.setOnCustomerViewCreated(new CustomerViewInterface() {

			@Override
			public void getCustomerView(Window window, AlertDialog dlg) {
				final CalendarView calendarView = (CalendarView) window.findViewById(R.id.calendarView_selected);

				calendarView.setOnDateChangeListener(new OnDateChangeListener() {

					@Override
					public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
						String date = year + "年" + month + "月" + dayOfMonth + "日";
						inputDate.setText(date);
					}
				});
			}
		});
		Utils.hideSoftKeyBoard(activity);
		cdlg.showDlg();
	}

	/**
	 * @Description:分享的对话框
	 * @param activity
	 * @param inputDate
	 * @author: LiuZhao
	 * @date:2015年1月29日
	 */

	public static void showSelectShareDialog(final Activity activity) {
		final CustomerDialog cdlg = new CustomerDialog(activity, R.layout.dialog_share_grid);
		cdlg.setOnCustomerViewCreated(new CustomerViewInterface() {

			@Override
			public void getCustomerView(Window window, AlertDialog dlg) {
				window = dlg.getWindow();
				WindowManager.LayoutParams lp = window.getAttributes();
				lp.gravity = Gravity.BOTTOM;
				final GridView gv_share = (GridView) window.findViewById(R.id.gv_share);
				final Button cancleButton = (Button) window.findViewById(R.id.btn_share_dialog_cancel);
				cancleButton.setOnClickListener(new OnClickListener() {

					@Override
					public void onClick(View arg0) {
						cdlg.dismissDlg();
					}
				});
				ShareAdapter shareAdapter = new ShareAdapter(activity);
				gv_share.setAdapter(shareAdapter);
				gv_share.setOnItemClickListener(new OnItemClickListener() {

					@Override
					public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
						switch (position) {
						case 0:
							SharedUtils.shareToQQOrQzone(activity, null, null, true);
							break;
						case 1:
							SharedUtils.shareToWXOrFriends(activity, true);
							break;
						case 2:
							SharedUtils.shareToWXOrFriends(activity, true);
							break;
						case 3:
							SharedUtils.shareToWXOrFriends(activity, true);
							break;
						default:
							break;
						}
					}
				});
			}
		});

		Utils.hideSoftKeyBoard(activity);
		cdlg.gravity =Gravity.BOTTOM;
		cdlg.showDlg();
	}
}
