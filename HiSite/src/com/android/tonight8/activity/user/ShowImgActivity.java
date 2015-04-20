package com.android.tonight8.activity.user;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.lidroid.xutils.BitmapUtils;
import com.lidroid.xutils.bitmap.BitmapDisplayConfig;
import com.lidroid.xutils.bitmap.callback.BitmapLoadFrom;
import com.lidroid.xutils.bitmap.callback.DefaultBitmapLoadCallBack;

public class ShowImgActivity extends Activity {
	ImageView iv_big_img;
	ProgressBar pb_big_image;
	TextView tv_big_pnum;
	BitmapUtils bmUtils;
	TextView tv_ww;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// setContentView(R.layout.activity_show_img);
		// super.onCreate(savedInstanceState);
		// iv_big_img = (ImageView) findViewById(R.id.iv_big_photo);
		// pb_big_image = (ProgressBar) findViewById(R.id.pb_big_image);
		// tv_big_pnum = (TextView) findViewById(R.id.tv_big_pnum);
		// tv_ww = (TextView) findViewById(R.id.tv_ww);
		String remoteUrl = getIntent().getStringExtra("remoteUrl");
		String localUrl = getIntent().getStringExtra("localUrl");
		Log.v("test", "remoteUrl is" + remoteUrl);
		pb_big_image.setVisibility(View.VISIBLE);
		tv_big_pnum.setVisibility(View.VISIBLE);
		bmUtils = new BitmapUtils(this);
		if (remoteUrl != null && !remoteUrl.equals("")) {
			Log.v("test", "i m prepare for do");
			bmUtils.display(iv_big_img, remoteUrl,
					new DefaultBitmapLoadCallBack<ImageView>() {
						@Override
						public void onLoadCompleted(ImageView container,
								String uri, Bitmap bitmap,
								BitmapDisplayConfig config, BitmapLoadFrom from) {
							pb_big_image.setVisibility(View.INVISIBLE);
							tv_big_pnum.setVisibility(View.INVISIBLE);
							tv_ww.requestFocus();
							super.onLoadCompleted(container, uri, bitmap,
									config, from);
						}

						@Override
						public void onLoading(ImageView container, String uri,
								BitmapDisplayConfig config, long total,
								long current) {
							super.onLoading(container, uri, config, total,
									current);
							Log.v("test", "i render" + Thread.currentThread());
							int progress = (int) ((current * 0.0f)
									/ (total * 0.0f) * 100);
							pb_big_image.setProgress(progress);
							tv_big_pnum.setText(progress);
						}

						@Override
						public void onLoadFailed(ImageView container,
								String uri, Drawable drawable) {
							super.onLoadFailed(container, uri, drawable);
							pb_big_image.setVisibility(View.INVISIBLE);
							tv_big_pnum.setVisibility(View.INVISIBLE);
						}
					});
		} else {
			if (localUrl != null && !localUrl.equals("")) {
				iv_big_img.setImageBitmap(BitmapFactory.decodeFile(localUrl));
				pb_big_image.setVisibility(View.INVISIBLE);
				tv_big_pnum.setVisibility(View.INVISIBLE);
			}
		}
	}

	@Override
	protected void onDestroy() {
		Log.v("test", "is destory");
		super.onDestroy();
	}

	@Override
	public void onBackPressed() {
		Log.v("test", "onbackPress");
		finish();
	}
}
