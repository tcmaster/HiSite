/**
 * 2015-1-8
 */
package com.android.tonight8.utils;

import java.util.Date;

import android.app.Activity;
import android.app.AlertDialog;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.android.tonight8.R;
import com.android.tonight8.adapter.createevent.ShareAdapter;
import com.android.tonight8.base.BaseActivity;
import com.android.tonight8.utils.SharedUtils.ShareThirdEntity;
import com.android.tonight8.view.CustomerDialog;
import com.android.tonight8.view.CustomerDialog.CustomerViewInterface;
import com.android.tonight8.view.MyCalendarView;
import com.android.tonight8.view.MyCalendarView.OnMyItemClickListener;
import com.lidroid.xutils.util.LogUtils;

/**
 * @Description:对话框工厂类
 * @author:LiXiaoSong
 * @copyright @tonight8
 * @Date:2015-1-8
 */
public class DialogUtils {

	public static final int TYPE_SIMPLE_LIST = 1;

	public static void showListDialog(Activity act, int type,
			ListDialogInterface listener) {
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

	public static abstract class ListDialogInterface implements
			CustomerViewInterface {

		@Override
		public void getCustomerView(Window window, AlertDialog dlg) {
			ListView lv_simple = (ListView) window
					.findViewById(R.id.lv_list_simple);// 找到listView
			getListView(lv_simple, dlg);
		}

		public abstract void getListView(ListView lv_list, final AlertDialog dlg);

	}

	/**
	 * @Description:选择拍照还是相册获取图片的对话框
	 * @param activity
	 * @param inputDate
	 * @author: LiuZhao
	 * @date:2015年1月29日
	 */

	public static void showSelectPicDialog(final Activity activity,
			final int requestCodeGallery, final int requestCodeTakePicture) {
		final CustomerDialog cdlg = new CustomerDialog(activity,
				R.layout.dialog_select_pic);

		cdlg.setOnCustomerViewCreated(new CustomerViewInterface() {

			@Override
			public void getCustomerView(Window window, final AlertDialog dlg) {
				Button btn_left = (Button) window
						.findViewById(R.id.btn_pic_left);
				Button btn_right = (Button) window
						.findViewById(R.id.btn_pic_right);
				btn_left.setOnClickListener(new OnClickListener() {

					@Override
					public void onClick(View arg0) {
						((BaseActivity) activity)
								.getPhotoFromGallery(requestCodeGallery);
						dlg.dismiss();

					}
				});
				btn_right.setOnClickListener(new OnClickListener() {

					@Override
					public void onClick(View arg0) {
						((BaseActivity) activity)
								.getPhotoByTakePicture(requestCodeTakePicture);
						dlg.dismiss();
					}
				});
			}
		});
		// cdlg.setOnCustomerViewCreated(listener);
		cdlg.showDlg();
	}

	/**
	 * @Description:选择日历的对话框，默认日期是当前系统日期
	 * @param activity
	 * @param inputDate
	 * @author: LiuZhao
	 * @date:2015年1月29日
	 */

	public static void showSelectCalendarDialog(final Activity activity,
			final String[] selectData, final EditText inputDate) {
		final CustomerDialog cdlg = new CustomerDialog(activity,
				R.layout.common_select_calendar);
		cdlg.setOnCustomerViewCreated(new CustomerViewInterface() {

			@Override
			public void getCustomerView(Window window, AlertDialog dlg) {
				final MyCalendarView calendarView = (MyCalendarView) window
						.findViewById(R.id.calendarView_selected);
				calendarView.setSelectedOtherDay(selectData);
				calendarView
						.setOnItemClickListener(new OnMyItemClickListener() {

							@Override
							public void OnItemClick(Date selectedStartDate,
									Date selectedEndDate, Date downDate) {
								LogUtils.i(downDate + "日历选中日期");
								if (!isInculdeDate(selectData, downDate)) {
									String strSelectDate = DateTimeUtils
											.dateToStr(downDate);
									inputDate.setText(strSelectDate);
									cdlg.dismissDlg();
								}

							}
						});
			}
		});
		Utils.hideSoftKeyBoard(activity);
		cdlg.showDlg();
	}

	private static boolean isInculdeDate(String[] selectData, Date downDate) {
		for (int i = 0; i < selectData.length; i++) {
			if (selectData[i].equals(DateTimeUtils.dateToStr(downDate))) {
				return true;
			}
		}
		return false;
	}

	/**
	 * @Description:分享的对话框
	 * @param activity
	 * @param inputDate
	 * @author: LiuZhao
	 * @date:2015年1月29日
	 */

	public static void showSelectShareDialog(final Activity activity,
			final ShareThirdEntity shareThirdEntity) {
		final CustomerDialog cdlg = new CustomerDialog(activity,
				R.layout.dialog_share_grid);
		cdlg.setOnCustomerViewCreated(new CustomerViewInterface() {

			@Override
			public void getCustomerView(Window window, AlertDialog dlg) {
				window = dlg.getWindow();
				WindowManager.LayoutParams lp = window.getAttributes();
				lp.gravity = Gravity.BOTTOM;
				lp.width = LayoutParams.MATCH_PARENT;
				window.setAttributes(lp);
				final GridView gv_share = (GridView) window
						.findViewById(R.id.gv_share);
				final Button cancleButton = (Button) window
						.findViewById(R.id.btn_share_dialog_cancel);
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
					public void onItemClick(AdapterView<?> arg0, View arg1,
							int position, long arg3) {
						switch (position) {
						case 0:// QQ空间
							SharedUtils.shareToQzone(activity,
									shareThirdEntity, null);
							break;
						case 1:// QQ好友
							SharedUtils.shareToQQ(activity, shareThirdEntity,
									null);
							break;
						case 2:// 微信好友
							SharedUtils.shareToWXOrFriends(activity,
									shareThirdEntity, false);
							break;
						case 3:// 朋友圈
							SharedUtils.shareToWXOrFriends(activity,
									shareThirdEntity, true);
							break;
						case 4:// 新浪微博
							SharedUtils.shareToSinaWeiBo(activity,
									shareThirdEntity);
							break;

						default:
							break;

						}
						cdlg.dismissDlg();
					}
				});
			}
		});
		Utils.hideSoftKeyBoard(activity);
		// cdlg.gravity = Gravity.BOTTOM;
		cdlg.showDlg();
	}

	/**
	 * @Description:
	 * @param activity
	 * @param init
	 * @author: LiXiaoSong
	 * @date:2015-3-4
	 */
	public static void showCommitDialog(Activity activity, final String init) {
		final CustomerDialog cdlg = new CustomerDialog(activity,
				R.layout.dlg_commit);
		cdlg.setOnCustomerViewCreated(new CustomerViewInterface() {

			@Override
			public void getCustomerView(Window window, AlertDialog dlg) {
				EditText et_commit = (EditText) window
						.findViewById(R.id.et_commit);
				Button btn_commit_ok = (Button) window
						.findViewById(R.id.btn_commit_ok);
				et_commit.setHint(init);
				btn_commit_ok.setOnClickListener(new OnClickListener() {

					@Override
					public void onClick(View v) {
						Utils.toast("评论已提交");
					}
				});

			}
		});
		cdlg.setDismissIfClick(true);
		cdlg.setLayoutGravity(Gravity.BOTTOM);
		cdlg.showDlg();
	}

	/**
	 * @Description:支付的对话框：支付宝和微信支付
	 * @param activity
	 * @param inputDate
	 * @author: LiuZhao
	 * @date:2015年1月29日
	 */

	public static void showPayDialog(final Activity activity) {
		final CustomerDialog cdlg = new CustomerDialog(activity,
				R.layout.dialog_select_payway);

		cdlg.setOnCustomerViewCreated(new CustomerViewInterface() {

			@Override
			public void getCustomerView(Window window, final AlertDialog dlg) {
				LinearLayout ll_weixinpay = (LinearLayout) window
						.findViewById(R.id.ll_weixinpay);
				LinearLayout ll_zhifubaopay = (LinearLayout) window
						.findViewById(R.id.ll_zhifubaopay);
				ll_weixinpay.setOnClickListener(new OnClickListener() {

					@Override
					public void onClick(View v) {

					}
				});
				ll_zhifubaopay.setOnClickListener(new OnClickListener() {

					@Override
					public void onClick(View v) {

					}
				});
			}
		});
		cdlg.showDlg();
	}

	public static void showGoodsOrderPopWindow() {

	}
}
