/**
 * 2015-1-8
 */
package com.android.utils;

import android.app.Activity;
import android.app.AlertDialog;
import android.view.Window;
import android.widget.ListView;

import com.android.hisite.R;
import com.android.view.CustomerDialog;
import com.android.view.CustomerDialog.CustomerViewInterface;

/**
 * @Description:对话框工厂类
 * @author:LiXiaoSong
 * @copyright @HiSite
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
}
