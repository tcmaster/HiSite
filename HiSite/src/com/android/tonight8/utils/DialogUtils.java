/**
 * 2015-1-8
 */
package com.android.tonight8.utils;

import android.app.Activity;
import android.app.AlertDialog;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.CalendarView.OnDateChangeListener;
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

	public static void showSelectPicDialog(final Activity activity, ButtonOnClick listener) {
		final CustomerDialog cdlg = new CustomerDialog(activity, R.layout.dialog_select_pic);
		cdlg.setOnCustomerViewCreated(listener);
		cdlg.showDlg();
	}

	public static abstract class ButtonOnClick implements CustomerViewInterface {

		@Override
		public void getCustomerView(Window window, AlertDialog dlg) {
			Button btn_left = (Button) window.findViewById(R.id.btn_left);// 找到listView
			Button btn_right = (Button) window.findViewById(R.id.btn_right);
			getButton(btn_left, btn_right, dlg);
		}

		public abstract void getButton(Button leftButton, Button rightButton, final AlertDialog dlg);

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

	public static void showSelectShareDialog(final Activity activity, ShareListener listener) {
		final CustomerDialog cdlg = new CustomerDialog(activity, R.layout.dialog_share_grid);
		cdlg.setOnCustomerViewCreated(listener);
		cdlg.showDlg();
		Utils.hideSoftKeyBoard(activity);
		cdlg.gravity = Gravity.BOTTOM;
		cdlg.showDlg();
	}

	public static abstract class ShareListener implements CustomerViewInterface {

		@Override
		public void getCustomerView(Window window, final AlertDialog cdlg) {
			window = cdlg.getWindow();
			WindowManager.LayoutParams lp = window.getAttributes();
			lp.gravity = Gravity.BOTTOM;
			final GridView gv_share = (GridView) window.findViewById(R.id.gv_share);
			final Button cancleButton = (Button) window.findViewById(R.id.btn_share_dialog_cancel);
			getShareGridview(gv_share, cancleButton, cdlg);
		}

		public abstract void getShareGridview(GridView shareGridview, Button cancleButton, final AlertDialog cdlg);

	}
}
