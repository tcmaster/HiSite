package com.android.tonight8.activity.wish;

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

import com.android.tonight8.R;
import com.android.tonight8.adapter.wish.WishItemAdapter;
import com.android.tonight8.adapter.wish.WishThemeGridAdapter;
import com.android.tonight8.base.BaseActivity;
import com.android.tonight8.dao.model.other.WishAddItem;
import com.android.tonight8.utils.AlbumAndCamera;
import com.android.tonight8.view.GridViewForScrollView;
import com.android.tonight8.view.ListViewForScrollView;
import com.lidroid.xutils.view.annotation.ViewInject;

/**
 * @author lz 许愿页面
 */
public class MakeWishActivity extends BaseActivity {
	@ViewInject(R.id.lv_wish_story)
	private ListViewForScrollView lv_wish_story;
	@ViewInject(R.id.gv_wish_themepic)
	private GridViewForScrollView gv_wish_themepic;
	// @ViewInject(R.id.iv_addwishpic)
	// private TextView tv_addwishpic;
	private WishItemAdapter wishStoryAdapter;
	private WishThemeGridAdapter wishThemeGridAdapter;
	private List<String> themeList;
	private List<WishAddItem> wishAddItems;
	/** 故事板点击的位置 */
	private int clickPosition;
	/** 更新数据 */
	public static final int UPDATA_DATA = 0;
	/** 增加数据 */
	public static final int ADD_DATA = 1;
	/** 删除数据 */
	public static final int DELETE_DATA = 2;
	/** 主题图片从相册获取标识 */
	public static final int THEME_PICKPICTURE = 4;
	/** 主题图片从拍照获取标识 */
	public static final int THEME_TAKEPHOTO = 5;
	/** 主题图片从剪裁获取的标识 */
	public static final int THEME_CROP = 6;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		initCreateOverLay(savedInstanceState, R.layout.activity_make_wish);
		getActionBarBase("许愿");
		wishAddItems = new ArrayList<WishAddItem>();
		WishAddItem bean = new WishAddItem();
		wishAddItems.add(bean);
		wishStoryAdapter = new WishItemAdapter(mContext, wishAddItems);
		lv_wish_story.setAdapter(wishStoryAdapter);

		themeList = new ArrayList<String>();
		themeList.add("");
		wishThemeGridAdapter = new WishThemeGridAdapter(mContext, themeList);
		gv_wish_themepic.setAdapter(wishThemeGridAdapter);
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

				WishAddItem wishItem = wishAddItems.get(clickPosition);
				// wishStroyModel.setWishPic(tempPicPath);
				updateClickPosition(clickPosition, MakeWishActivity.ADD_DATA,
						wishItem);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} finally {
				if (bitmap != null) {
					bitmap.recycle();
				}

			}

			break;
		case THEME_PICKPICTURE:
			cropPicture(data.getData(), THEME_CROP, 256, 256);
			break;
		case THEME_TAKEPHOTO:
			File tempFile2 = new File(Environment.getExternalStorageDirectory()
					+ "/Camera/", tempName);
			cropPicture(Uri.fromFile(tempFile2), THEME_CROP, 256, 256);
			break;
		case THEME_CROP:
			Uri cropImageUri2 = data.getData();
			// 图片解析成Bitmap对象
			Bitmap bitmap2 = null;
			try {
				bitmap2 = BitmapFactory.decodeStream(getContentResolver()
						.openInputStream(cropImageUri2));
				String tempPicPath2 = AlbumAndCamera.getImagePath(
						AlbumAndCamera.getTempPath(), bitmap2);
				updateWishThemeData(clickPosition, MakeWishActivity.ADD_DATA,
						tempPicPath2);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} finally {
				if (bitmap2 != null) {
					bitmap2.recycle();
				}

			}

			break;
		default:
			break;
		}
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
			wishAddItems.add(position + 1, new WishAddItem());
			// WishAddItem addItem = wishAddItems.get(position);
			// addItem.setAdd(false);
			// wishAddItems.set(position, addItem);
			break;
		case DELETE_DATA:
			wishAddItems.remove(position);
			// WishAddItem delelteItem = wishAddItems.get(position);
			// delelteItem.setAdd(false);
			// wishAddItems.set(position - 1, delelteItem);

			break;
		case UPDATA_DATA:
			wishAddItems.set(position, wishAddItem);
			break;
		default:
			break;
		}
		// wishStoryAdapter = new WishItemAdapter(mContext, wishAddItems);
		// lv_wish_story.setAdapter(wishStoryAdapter);
		for (int i = 0; i < wishAddItems.size(); i++) {
			if (i == wishAddItems.size()-1) {
				wishAddItems.get(i).setAdd(true);
			} else {
				wishAddItems.get(i).setAdd(false);
			}

		}
		wishStoryAdapter.update(wishAddItems);

	}

}