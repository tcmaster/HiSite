package com.android.tonight8.activity.createevent;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.android.tonight8.R;
import com.android.tonight8.adapter.createevent.GoodsImageListAdapter;
import com.android.tonight8.base.BaseActivity;
import com.android.tonight8.base.Tonight8App;
import com.android.tonight8.model.common.Event;
import com.android.tonight8.model.common.Goods;
import com.android.tonight8.utils.AlbumAndCamera;
import com.android.tonight8.utils.DialogUtils;
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
	/** 奖品名称 */
	@ViewInject(R.id.et_goodsName)
	private TextView et_goodsName;
	/** 奖品图片 */
	@ViewInject(R.id.iv_goods_temp)
	private ImageView iv_goods_temp;
	/** 活动规则文本 */
	@ViewInject(R.id.et_createevent_rule)
	private TextView et_createevent_rule;

	/** 下一步 */
	@ViewInject(R.id.btn_createevent_first)
	private Button btn_createevent_first;

	/** 奖品图片数据适配器 */
	private GoodsImageListAdapter imageListAdapter;
	private Event event;
	private List<Goods> list;
	/** 是哪一个编辑框跳转到编辑页 */
	private final int createeventNameFlag = 3;
	private final int popGoodsNameFlag = 4;
	private final int goodsNameFlag = 5;
	private final int eventRuleFlag = 6;

	/** 详情相册 */
	private final int PICKPICTURE_DETAIL = 11;
	/** 详情拍照 */
	private final int TAKEPHOTO_DETAIL = 12;
	/** 详情裁剪 */
	private final int CROP_DETAIL = 13;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		setContentView(R.layout.activity_create_event_first);
		super.onCreate(savedInstanceState);
		getActionBarBase("发活动");
		initData();
	}

	@OnClick({ R.id.iv_popgoods_add, R.id.btn_createevent_first,
			R.id.iv_selected_PublishDate, R.id.iv_selected_DateStart,
			R.id.iv_selected_DateEnd, R.id.btn_createevent_first,
			R.id.et_popGoodsName, R.id.et_goodsName, R.id.et_createevent_rule,
			R.id.et_createevent_name, R.id.iv_goods_temp })
	public void OnClick(View v) {
		switch (v.getId()) {
		case R.id.iv_popgoods_add:
			DialogUtils.showSelectPicDialog((CreatEventFirstActivity) mContext,
					PICKPICTURE, TAKEPHOTO);
			break;
		case R.id.btn_createevent_first:
			// StorgeCurrentData();
			Intent intent = new Intent(CreatEventFirstActivity.this,
					CreateEventSecondActivity.class);
			startActivityForAnima(intent, null);
			break;
		case R.id.iv_selected_PublishDate:
			DialogUtils.showSelectCalendarDialog(CreatEventFirstActivity.this,
					et_planPublishTime);
			break;

		case R.id.et_popGoodsName:
			startActivityForResultAndAnima(new Intent(
					CreatEventFirstActivity.this, TextEditActivity.class),
					popGoodsNameFlag, null);
			break;

		case R.id.et_goodsName:
			startActivityForResultAndAnima(new Intent(
					CreatEventFirstActivity.this, TextEditActivity.class),
					goodsNameFlag, null);
			break;
		case R.id.iv_goods_temp:
			DialogUtils.showSelectPicDialog((CreatEventFirstActivity) mContext,
					PICKPICTURE_DETAIL, TAKEPHOTO_DETAIL);
			break;
		case R.id.et_createevent_rule:
			startActivityForResultAndAnima(new Intent(
					CreatEventFirstActivity.this, TextEditActivity.class),
					eventRuleFlag, null);
			break;
		case R.id.et_createevent_name:
			startActivityForResultAndAnima(new Intent(
					CreatEventFirstActivity.this, TextEditActivity.class),
					createeventNameFlag, null);

			break;
		default:
			break;
		}
	}

	private void initData() {
		list = new ArrayList<Goods>();
		imageListAdapter = new GoodsImageListAdapter(mContext, list);
		lv_goodsAddList.setAdapter(imageListAdapter);
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		getWindow().getDecorView().invalidate();
		if (resultCode != RESULT_OK) {
			return;
		}

		switch (requestCode) {
		case PICKPICTURE:
			cropPicture(data.getData(), PICKPICTURE);
			break;
		case TAKEPHOTO:
			File tempFile = new File(Environment.getExternalStorageDirectory()
					+ "/Camera/", tempName);
			cropPicture(Uri.fromFile(tempFile), TAKEPHOTO);
			break;
		case CROP:
			Uri cropImageUri = data.getData();
			// 图片解析成Bitmap对象
			Bitmap bitmap = null;
			try {
				bitmap = BitmapFactory.decodeStream(getContentResolver()
						.openInputStream(cropImageUri));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} finally {
				if (bitmap != null) {
					bitmap.recycle();
				}

			}
			String tempPicPath = AlbumAndCamera.getImagePath(
					AlbumAndCamera.getTempPath(), bitmap);
			Tonight8App.getSelf().bitmapUtils.display(iv_popgoods_add,
					tempPicPath);
			break;
		case PICKPICTURE_DETAIL:
			cropPicture(data.getData(), PICKPICTURE_DETAIL);
			break;
		case TAKEPHOTO_DETAIL:
			File tempFile2 = new File(Environment.getExternalStorageDirectory()
					+ "/Camera/", tempName);
			cropPicture(Uri.fromFile(tempFile2), TAKEPHOTO_DETAIL);
			break;
		case CROP_DETAIL:
			Uri cropImageUri2 = data.getData();
			// 图片解析成Bitmap对象
			Bitmap bitmap2 = null;
			try {
				bitmap2 = BitmapFactory.decodeStream(getContentResolver()
						.openInputStream(cropImageUri2));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} finally {
				if (bitmap2 != null) {
					bitmap2.recycle();
				}
			}
			String tempPicPath2 = AlbumAndCamera.getImagePath(
					AlbumAndCamera.getTempPath(), bitmap2);
			Goods goods = new Goods();
			goods.pic = tempPicPath2;
			list.add(goods);
			break;
		case TEXTEDIT:
			switch (requestCode) {

			case createeventNameFlag:
				et_createevent_name.setText(data
						.getStringExtra(TextEditActivity.INPUT_STRING));
				break;
			case popGoodsNameFlag:
				et_popGoodsName.setText(data
						.getStringExtra(TextEditActivity.INPUT_STRING));
				break;
			case goodsNameFlag:
				et_goodsName.setText(data
						.getStringExtra(TextEditActivity.INPUT_STRING));
				break;
			case eventRuleFlag:
				et_createevent_rule.setText(data
						.getStringExtra(TextEditActivity.INPUT_STRING));
				break;

			default:
				break;
			}

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
