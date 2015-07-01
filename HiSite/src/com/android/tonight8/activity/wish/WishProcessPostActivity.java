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
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;

import com.android.tonight8.R;
import com.android.tonight8.adapter.wish.WishProgressPostAdapter;
import com.android.tonight8.base.BaseActivity;
import com.android.tonight8.utils.AlbumAndCamera;
import com.android.tonight8.view.GridViewForScrollView;
import com.lidroid.xutils.view.annotation.ViewInject;

/**
 * @author lz心愿历程发布
 * 
 */
public class WishProcessPostActivity extends BaseActivity {
	@ViewInject(R.id.gv_wishprogress)
	private GridViewForScrollView gv_wishprogress;
	private WishProgressPostAdapter adapter;
	private List<String> values;
	@ViewInject(R.id.et_thinking)
	private EditText et_thinking;

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
				addWishProcessPost(tempPicPath);
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

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		initCreateNomal(savedInstanceState,
				R.layout.activity_wish_progress_post);
		getActionBarRight("历程发布", "发布", new OnClickListener() {

			@Override
			public void onClick(View v) {

			}
		});
		initData();
	}

	private void initData() {
		et_thinking.setMovementMethod(ScrollingMovementMethod.getInstance());
		et_thinking.setSelection(et_thinking.getText().length(), et_thinking
				.getText().length());

		values = new ArrayList<String>();
		values.add("");
		adapter = new WishProgressPostAdapter(mContext, values);
		gv_wishprogress.setAdapter(adapter);
	}

	/**
	 * @Description: 增加数据项
	 */
	public void addWishProcessPost(String picUrl) {
		values.add(picUrl);
		adapter.updateData(values);
	}

	/**
	 * @Description: 删除数据项
	 * @param position删除项的位置
	 * @param picUrl
	 */
	public void deleteWishProcessPost(int position) {
		values.remove(position);
		adapter.updateData(values);
	}
}
