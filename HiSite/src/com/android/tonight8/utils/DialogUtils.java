/**
 * 2015-1-8
 */
package com.android.tonight8.utils;

import java.util.Collections;
import java.util.Date;
import java.util.List;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.android.tonight8.R;
import com.android.tonight8.adapter.createevent.ShareAdapter;
import com.android.tonight8.base.BaseActivity;
import com.android.tonight8.utils.SharedUtils.ShareThirdEntity;
import com.android.tonight8.view.CustomerDialog;
import com.android.tonight8.view.CustomerDialog.CustomerViewInterface;
import com.android.tonight8.view.MyCalendarView;
import com.android.tonight8.view.MyCalendarView.OnMyItemClickListener;
import com.android.tonight8.view.sortlistview.CharacterParser;
import com.android.tonight8.view.sortlistview.PinyinComparator;
import com.android.tonight8.view.sortlistview.SideBar;
import com.android.tonight8.view.sortlistview.SideBar.OnTouchingLetterChangedListener;
import com.android.tonight8.view.sortlistview.SortAdapter;
import com.android.tonight8.view.sortlistview.SortModel;
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
			final EditText inputDate) {
		final CustomerDialog cdlg = new CustomerDialog(activity,
				R.layout.common_select_calendar);
		cdlg.setOnCustomerViewCreated(new CustomerViewInterface() {

			@Override
			public void getCustomerView(Window window, AlertDialog dlg) {
				final MyCalendarView calendarView = (MyCalendarView) window
						.findViewById(R.id.calendarView_selected);

				calendarView
						.setOnItemClickListener(new OnMyItemClickListener() {

							@Override
							public void OnItemClick(Date selectedStartDate,
									Date selectedEndDate, Date downDate) {
								LogUtils.i(downDate + "日历选中日期");
								inputDate.setText(DateTimeUtils
										.dateToStr(downDate));
								cdlg.dismissDlg();
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
							SharedUtils.shareToQQOrQzone(activity,
									shareThirdEntity, null, true);
							break;
						case 1:// QQ好友
							SharedUtils.shareToQQOrQzone(activity,
									shareThirdEntity, null, false);
							break;
						case 2:// 微信好友
							SharedUtils.shareToWXOrFriends(activity,
									shareThirdEntity, true);
							break;
						case 3:// 朋友圈
							SharedUtils.shareToWXOrFriends(activity,
									shareThirdEntity, false);
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
		cdlg.gravity = Gravity.BOTTOM;
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
	 * 
	 */
	public static void showRegionalDialog(Context context, int width,
			int height, View dropDownView) {
		View contentView = LayoutInflater.from(context).inflate(
				R.layout.dlg_regional_search, null);
		PopupWindow popupWindow = new PopupWindow(contentView, width, height);
		popupWindow.showAsDropDown(dropDownView, 0, 20);// 这里的y轴便宜不太准确，后续需要精确计算
		final ListView lv_regional_search = (ListView) contentView
				.findViewById(R.id.lv_regional_search);
		SideBar sb_right = (SideBar) contentView.findViewById(R.id.sb_right);
		TextView tv_pinyin = (TextView) contentView
				.findViewById(R.id.tv_pinyin);
		sb_right.setTextView(tv_pinyin);
		// 测试数据
		String[] data = new String[] { "北京", "天津", "河北", "法国", "安徽", "内蒙古",
				"印度", "尼泊尔", "英国", "土耳其", "西班牙", "北京", "天津", "河北", "法国", "安徽",
				"内蒙古", "印度", "尼泊尔", "英国", "土耳其", "西班牙", "北京", "天津", "河北", "法国",
				"安徽", "内蒙古", "印度", "尼泊尔", "英国", "土耳其", "西班牙" };
		final CharacterParser parser = CharacterParser.getInstance();
		List<SortModel> models = parser.filledData(data);
		final SortAdapter adapter = new SortAdapter(context, models);
		PinyinComparator comparator = new PinyinComparator();
		Collections.sort(models, comparator);// 按拼音牌序
		lv_regional_search.setAdapter(adapter);
		sb_right.setOnTouchingLetterChangedListener(new OnTouchingLetterChangedListener() {

			@Override
			public void onTouchingLetterChanged(String s) {
				lv_regional_search.setSelection(adapter
						.getPositionForSection((int) s.getBytes()[0]));
			}
		});
	}
}
