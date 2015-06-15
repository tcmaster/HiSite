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
import android.widget.TextView;

import com.android.tonight8.R;
import com.android.tonight8.adapter.wish.WishStoryAdapter;
import com.android.tonight8.adapter.wish.WishThemeGridAdapter;
import com.android.tonight8.base.BaseActivity;
import com.android.tonight8.dao.model.wish.WishListModel;
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
	@ViewInject(R.id.tv_addwishpic)
	private TextView tv_addwishpic;
	private WishStoryAdapter wishStoryAdapter;
	private WishThemeGridAdapter wishThemeGridAdapter;
	private List<String> themeList;
	private List<WishListModel> storyList;
	/** 故事板点击的位置 */
	private int clickPosition;
	public static final int UPDATA_DATA = 0;
	public static final int ADD_DATA = 1;
	public static final int DELETE_DATA = 2;
	public static final int THEME_PICKPICTURE = 4;
	public static final int THEME_TAKEPHOTO = 5;
	public static final int THEME_CROP = 6;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		setContentView(R.layout.activity_make_wish);
		super.onCreate(savedInstanceState);

		storyList = new ArrayList<WishListModel>();
		WishListModel bean = new WishListModel();
		storyList.add(bean);
		wishStoryAdapter = new WishStoryAdapter(mContext, storyList);
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

				WishListModel wishStroyModel = storyList.get(clickPosition);
				// wishStroyModel.setWishPic(tempPicPath);
				updateClickPosition(clickPosition, MakeWishActivity.ADD_DATA,
						wishStroyModel);
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
			WishListModel wishStroyModel) {
		this.clickPosition = position;
		if (type == ADD_DATA) {
			if (wishStroyModel == null) {
				wishStroyModel = new WishListModel();
				storyList.add(position + 1, wishStroyModel);
			} else {
				storyList.set(position, wishStroyModel);
			}

			wishStoryAdapter.notifyDataSetChanged();
		}
		if (type == DELETE_DATA) {
			if (storyList != null && storyList.size() != 1) {
				storyList.remove(position);
				wishStoryAdapter.notifyDataSetChanged();
			}

		}

	}

}