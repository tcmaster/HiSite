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
import com.android.tonight8.model.wish.WishStroyModel;
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
	private List<WishStroyModel> storyList;
	/** 故事板点击的位置 */
	private int clickPosition;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		setContentView(R.layout.activity_make_wish);
		super.onCreate(savedInstanceState);

		storyList = new ArrayList<WishStroyModel>();
		WishStroyModel bean = new WishStroyModel();
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
			File tempFile = new File(Environment.getExternalStorageDirectory() + "/Camera/", tempName);
			cropPicture(Uri.fromFile(tempFile), CROP,256, 256);
			break;
		case CROP:
			Uri cropImageUri = data.getData();
			// 图片解析成Bitmap对象
			Bitmap bitmap = null;
			try {
				bitmap = BitmapFactory.decodeStream(getContentResolver().openInputStream(cropImageUri));
				String tempPicPath = AlbumAndCamera.getImagePath(AlbumAndCamera.getTempPath(), bitmap);

				WishStroyModel wishStroyModel = storyList.get(clickPosition);
				wishStroyModel.setWishPic(tempPicPath);
				storyList.set(clickPosition, wishStroyModel);
				wishStoryAdapter.update(storyList);
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

	/**
	 * @Description: 更新数据
	 * @param @param position
	 * @param @param type 0更新选中的项，1增加数据项，2删除数据项
	 * @return void 返回类型
	 * 
	 */
	public void updateClickPosition(int position, int type) {
		this.clickPosition = position;
		if (type == 1) {
			WishStroyModel wishStroyModel = new WishStroyModel();
			storyList.add(position + 1, wishStroyModel);
			wishStoryAdapter.update(storyList);
		}
		if (type == 2) {
			if (storyList.size() == 1) {
				return;
			}
			storyList.remove(position);
			wishStoryAdapter.update(storyList);
		}

	}

}