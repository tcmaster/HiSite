package com.android.tonight8.activity.wish;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;

import com.android.tonight8.R;
import com.android.tonight8.adapter.wish.WishItemAdapter;
import com.android.tonight8.adapter.wish.WishThemeGridAdapter;
import com.android.tonight8.base.BaseActivity;
import com.android.tonight8.dao.model.other.WishAddItem;
import com.android.tonight8.io.HandlerConstants;
import com.android.tonight8.io.wish.WishIOController;
import com.android.tonight8.model.BaseModel;
import com.android.tonight8.utils.AlbumAndCamera;
import com.android.tonight8.utils.Utils;
import com.android.tonight8.view.GridViewForScrollView;
import com.android.tonight8.view.ListViewForScrollView;
import com.lidroid.xutils.view.annotation.ViewInject;

/**
 * @author lz 许愿页面
 */
public class MakeWishActivity extends BaseActivity {
	@ViewInject(R.id.lv_wish_story)
	private ListViewForScrollView lv_wishitem;
	@ViewInject(R.id.gv_wish_themepic)
	private GridViewForScrollView gv_wish_themepic;
	private WishItemAdapter wishStoryAdapter;
	private WishThemeGridAdapter wishThemeGridAdapter;
	private List<String> themeList;
	/** 空的清单数据 */
	private List<WishAddItem> wishAddItems;
	/** 本地缓存的清单数据 */
	private List<WishAddItem> addlist;
	/** 故事板点击的位置 */
	private int clickPosition;
	/** 更新数据 */
	public static final int UPDATA_DATA = 0;
	/** 增加数据 */
	public static final int ADD_DATA = 1;
	/** 删除数据 */
	public static final int DELETE_DATA = 2;
	private List<Map<String, Object>> mCheckItemList = null;
	@ViewInject(R.id.btn_wish_post)
	private Button btn_wish_post;
	private Handler handler = new Handler() {

		@Override
		public void handleMessage(Message msg) {
			super.handleMessage(msg);

			if (msg.what == HandlerConstants.WISH.WISH_SPONOR_LIST) {

				if (msg.arg1 == HandlerConstants.RESULT_OK) {// 网络数据获取成功
					BaseModel baseModel = (BaseModel) msg.obj;

					if (baseModel != null) {
						Utils.toast("提交成功");
					}
				}
			}
		}

	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		initCreateOverLay(savedInstanceState, R.layout.activity_make_wish);
		getActionBarBase("许愿");
		initData();
	}

	private void initData() {
		wishAddItems = new ArrayList<WishAddItem>();
		wishAddItems.add(new WishAddItem());
		mCheckItemList = new ArrayList<Map<String, Object>>();
		Map<String, Object> mMap = new HashMap<String, Object>();
		mCheckItemList.add(mMap);
		wishStoryAdapter = new WishItemAdapter(mContext, wishAddItems,
				mCheckItemList);
		lv_wishitem.setAdapter(wishStoryAdapter);

		themeList = new ArrayList<String>();
		themeList.add("");
		wishThemeGridAdapter = new WishThemeGridAdapter(mContext, themeList);
		gv_wish_themepic.setAdapter(wishThemeGridAdapter);
		btn_wish_post.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				addlist = new ArrayList<WishAddItem>();
				for (int i = 0; i < lv_wishitem.getChildCount(); i++) {
					WishAddItem wItem = null;
					LinearLayout layout = (LinearLayout) lv_wishitem
							.getChildAt(i);// 获得子item的layout
					EditText et_request_thing = (EditText) layout
							.findViewById(R.id.et_request_thing);// 从layout中获得控件,根据其id
					EditText et_request_reason = (EditText) layout
							.findViewById(R.id.et_request_reason);
					Spinner sp_request_type = (Spinner) layout
							.findViewById(R.id.sp_request_type);

					wItem = new WishAddItem();
					wItem.setType(sp_request_type.getSelectedItemPosition());
					wItem.setThings(et_request_thing.getText().toString());
					wItem.setReason(et_request_reason.getText().toString());
					addlist.add(wItem);
				}
				Map<String, String> params = new HashMap<String, String>();
				// params.put("wishItems", addlist);
				WishIOController.postMyWish(handler, params,
						HandlerConstants.WISH.MAKEWISH_POST, 0);
			}
		});

	}

	/**
	 * @Description: 更新数据
	 * @param @param position
	 * @param @param type 0更新选中的项，1增加数据项，2删除数据项
	 * @return void 返回类型
	 * 
	 */
	public void updateWishThemeData(int position, int type, String picUrl) {
		this.clickPosition = position;
		if (type == ADD_DATA) {
			themeList.set(position, picUrl);
			themeList.add(position + 1, "");
			wishThemeGridAdapter.notifyDataSetChanged();
		}
		if (type == DELETE_DATA) {
			if (themeList != null && themeList.size() != 1) {
				themeList.remove(position);
				wishThemeGridAdapter.notifyDataSetChanged();
			}

		}

	}

	/**
	 * @Description: 更新数据
	 * @param @param position
	 * @param @param type 0更新选中的项，1增加数据项，2删除数据项
	 * @return void 返回类型
	 * 
	 */
	public void updateClickPosition(int position, int type,
			WishAddItem wishAddItem) {
		this.clickPosition = position;
		switch (type) {
		case ADD_DATA:
			wishAddItems.add(new WishAddItem());
			break;
		case DELETE_DATA:
			wishAddItems.remove(position);
			break;
		case UPDATA_DATA:
			wishAddItems.set(position, wishAddItem);
			break;
		default:
			break;
		}

		for (int i = 0; i < wishAddItems.size(); i++) {
			if (i == wishAddItems.size() - 1) {
				wishAddItems.get(i).setAdd(true);
			} else {
				wishAddItems.get(i).setAdd(false);
			}

		}
		wishStoryAdapter.update(wishAddItems);

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
			cropPicture(data.getData(), CROP, 256, 256);
			break;
		case TAKEPHOTO:
			File tempFile = new File(Environment.getExternalStorageDirectory()
					+ "/Camera/", tempName);
			cropPicture(Uri.fromFile(tempFile), CROP, 256, 256);
			break;
		case CROP:
			Uri cropImageUri = data.getData();
			// 图片解析成Bitmap对象
			Bitmap bitmap = null;
			try {
				bitmap = BitmapFactory.decodeStream(getContentResolver()
						.openInputStream(cropImageUri));
				String tempPicPath = AlbumAndCamera.getImagePath(
						AlbumAndCamera.getTempPath(), bitmap);
				updateWishThemeData(clickPosition, ADD_DATA, tempPicPath);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} finally {
				if (bitmap != null) {
					bitmap.recycle();
				}

			}

			break;

		default:
			break;
		}
	}
}