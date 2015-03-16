package com.android.tonight8.activity.createevent;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.android.tonight8.R;
import com.android.tonight8.adapter.createevent.GoodsImageListAdapter;
import com.android.tonight8.base.BaseActivity;
import com.android.tonight8.model.common.Event;
import com.android.tonight8.utils.DialogUtils;
import com.android.tonight8.view.CustomerDialog;
import com.android.tonight8.view.CustomerDialog.CustomerViewInterface;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnClick;

/**
 * @author liuzhao 发活动第一步编辑
 */
public class CreatEventFirstActivity extends BaseActivity {

	/** 活动主题 */
	@ViewInject(R.id.et_createevent_name)
	private TextView et_createevent_name;
	/** 计划上架日期 */
	@ViewInject(R.id.et_planPublishTime)
	private EditText et_planPublishTime;
	/** 活动开始日期 */
	@ViewInject(R.id.et_eventDateStart)
	private EditText et_eventDateStart;
	/** 活动结束日期 */
	@ViewInject(R.id.et_eventDateEnd)
	private EditText et_eventDateEnd;
	/** 活动奖品名称（海报） */
	@ViewInject(R.id.et_popGoodsName)
	private TextView et_popGoodsName;
	/** 增加活动海报照片 */
	@ViewInject(R.id.iv_popgoods_add)
	private ImageView iv_popgoods_add;
	/** 增加活动照片列表 */
	@ViewInject(R.id.lv_goodsAddList)
	private ListView lv_goodsAddList;
	/** 上架日期 */
	@ViewInject(R.id.iv_selected_PublishDate)
	private ImageView iv_selected_PublishDate;
	/** 举办开始日期 */
	@ViewInject(R.id.iv_selected_DateStart)
	private ImageView iv_selected_DateStart;
	/** 举办结束日期 */
	@ViewInject(R.id.iv_selected_DateEnd)
	private ImageView iv_selected_DateEnd;

	/** 下一步 */
	@ViewInject(R.id.btn_createevent_first)
	private Button btn_createevent_first;

	/** 奖品图片数据适配器 */
	private GoodsImageListAdapter imageListAdapter;
	private Event event;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		setContentView(R.layout.activity_create_event_first);
		super.onCreate(savedInstanceState);
		getActionBarBase("发活动");

	}

	@OnClick({ R.id.iv_popgoods_add, R.id.btn_createevent_first,
			R.id.iv_selected_PublishDate,R.id.iv_selected_DateStart,R.id.iv_selected_DateEnd })
	public void OnClick(View v) {
		switch (v.getId()) {
		case R.id.iv_popgoods_add:
			CustomerDialog customerDialog = new CustomerDialog(
					CreatEventFirstActivity.this, R.layout.dialog_select_pic);
			customerDialog
					.setOnCustomerViewCreated(new CustomerViewInterface() {

						@Override
						public void getCustomerView(Window window,
								AlertDialog dlg) {
							Button leftButton = (Button) window
									.findViewById(R.id.btn_left);
							Button rightButton = (Button) window
									.findViewById(R.id.btn_right);
							leftButton
									.setOnClickListener(new OnClickListener() {

										@Override
										public void onClick(View arg0) {
											getPhotoByTakePicture();
										}
									});
							rightButton
									.setOnClickListener(new OnClickListener() {

										@Override
										public void onClick(View arg0) {
											getPhotoFromGallery();
										}
									});
						}
					});
			customerDialog.showDlg();
			break;
		case R.id.btn_createevent_first:
			// StorgeCurrentData();
			Intent intent = new Intent(CreatEventFirstActivity.this,
					CalendarActivity.class);
			startActivityForAnima(intent, null);
			break;
		case R.id.iv_selected_PublishDate:
			DialogUtils.showSelectCalendarDialog(CreatEventFirstActivity.this,
					et_planPublishTime);
			break;
		case R.id.iv_selected_DateStart:
			DialogUtils.showSelectCalendarDialog(CreatEventFirstActivity.this,
					et_eventDateStart);
			break;
		case R.id.iv_selected_DateEnd:
			DialogUtils.showSelectCalendarDialog(CreatEventFirstActivity.this,
					et_eventDateEnd);
			break;

		default:
			break;
		}
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		switch (requestCode) {
		case PICKPICTURE:

			break;
		case TAKEPHOTO:

			break;
		default:
			break;
		}
	}

	/**
	 * @Description:保存当前数据
	 * @author: LiuZhao
	 * @date:2015年1月29日
	 */

	private void StorgeCurrentData() {
		event = new Event();
		event.setName(et_createevent_name.getText().toString());
		event.setPublishTime(et_planPublishTime.getText().toString());
		event.setTimeRangeStart(et_eventDateStart.getText().toString());
		event.setTimeRangeEnd(et_eventDateEnd.getText().toString());
	}
}
