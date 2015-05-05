package com.android.tonight8.easemob;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.media.ThumbnailUtils;
import android.os.AsyncTask;
import android.util.Log;
import android.util.LruCache;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.android.tonight8.R;
import com.android.tonight8.activity.user.ShowImgActivity;
import com.android.tonight8.utils.Utils;
import com.easemob.chat.EMMessage;
import com.easemob.chat.ImageMessageBody;
import com.lidroid.xutils.BitmapUtils;
import com.lidroid.xutils.bitmap.BitmapDisplayConfig;
import com.lidroid.xutils.bitmap.callback.BitmapLoadFrom;
import com.lidroid.xutils.bitmap.callback.DefaultBitmapLoadCallBack;
import com.lidroid.xutils.util.LogUtils;

/**
 * @Descripton 显示图片的类
 * @author LiXiaoSong
 * @2015-4-15
 * @EaseMobTest
 */
public class EaseMobImageHelper {
	/**
	 * 显示消息中的图片，不包含父容器
	 * 
	 * @param message
	 *            显示的消息
	 * @param container
	 *            容器
	 * @param activity
	 * @param bmUtils
	 *            图片下载工具
	 */
	public static void showImage(EMMessage message, final View container,
			final Context activity, final BitmapUtils bmUtils) {
		showImage(message, null, container, activity, bmUtils);
	}

	/**
	 * 显示消息中的图片，包含父容器
	 * 
	 * @param message
	 *            显示的消息
	 * @param parent
	 *            父容器
	 * @param container
	 *            容器
	 * @param activity
	 * @param bmUtils
	 *            图片下载工具
	 */
	public static void showImage(EMMessage message, final ViewGroup parent,
			final View container, final Context activity,
			final BitmapUtils bmUtils) {
		final ImageMessageBody body = (ImageMessageBody) message.getBody();
		final String thUrl = body.getThumbnailUrl();
		final String remoteUrl = body.getRemoteUrl();
		final String localUrl = body.getLocalUrl();
		final ImageView iv_container = (ImageView) container
				.findViewById(R.id.iv_photo);
		final ProgressBar pb_num = (ProgressBar) container
				.findViewById(R.id.pb_image);
		final TextView tv_pnum = (TextView) container
				.findViewById(R.id.tv_pnum);
		if (body != null) {
			if (message.direct == EMMessage.Direct.SEND) {// 发送型图片的处理（直接将本地地址获取到，显示）
				new LocalUrlTask(activity, new LocalResultCall() {

					@Override
					public void getData(Bitmap bm) {
						iv_container.setImageBitmap(bm);
						iv_container.setOnClickListener(new OnClickListener() {

							@Override
							public void onClick(View arg0) {
								Intent intent = new Intent(activity,
										ShowImgActivity.class);
								intent.putExtra("remoteUrl", "");
								intent.putExtra("localUrl", localUrl);
								activity.startActivity(intent);
							}
						});

					}
				}).execute(localUrl);
			} else {
				if (body.downloaded) {
					Log.v("test", "it's downloaded");
					pb_num.setVisibility(View.VISIBLE);
					tv_pnum.setVisibility(View.VISIBLE);
					bmUtils.display(iv_container, thUrl,
							new DefaultBitmapLoadCallBack<View>() {
								@Override
								public void onLoadCompleted(View container,
										String uri, Bitmap bitmap,
										BitmapDisplayConfig config,
										BitmapLoadFrom from) {
									super.onLoadCompleted(container, uri,
											bitmap, config, from);
									pb_num.setVisibility(View.INVISIBLE);
									tv_pnum.setVisibility(View.INVISIBLE);
									tv_pnum.setText("0");
									iv_container
											.setOnClickListener(new OnClickListener() {

												@Override
												public void onClick(View arg0) {
													Intent intent = new Intent(
															activity,
															ShowImgActivity.class);
													intent.putExtra(
															"remoteUrl",
															remoteUrl);
													intent.putExtra("localUrl",
															"");
													activity.startActivity(intent);
												}
											});
								}

								@Override
								public void onLoading(View container,
										String uri, BitmapDisplayConfig config,
										long total, long current) {
									super.onLoading(container, uri, config,
											total, current);
									int progress = (int) (((current * 1.0f) / (total * 1.0f)) * 100);
									tv_pnum.setText(progress);
								}

								@Override
								public void onLoadFailed(View container,
										String uri, Drawable drawable) {
									super.onLoadFailed(container, uri, drawable);
									pb_num.setVisibility(View.INVISIBLE);
									tv_pnum.setVisibility(View.INVISIBLE);
									// parent.removeView(iv_container);

								}
							});
				} else {
					Log.v("test", "it's not downloaded");
					pb_num.setVisibility(View.VISIBLE);
					tv_pnum.setVisibility(View.VISIBLE);
					bmUtils.display(iv_container, thUrl,
							new DefaultBitmapLoadCallBack<View>() {
								@Override
								public void onLoadCompleted(View container,
										String uri, Bitmap bitmap,
										BitmapDisplayConfig config,
										BitmapLoadFrom from) {
									super.onLoadCompleted(container, uri,
											bitmap, config, from);
									pb_num.setVisibility(View.INVISIBLE);
									tv_pnum.setVisibility(View.INVISIBLE);
									tv_pnum.setText("0");
									iv_container
											.setOnClickListener(new OnClickListener() {

												@Override
												public void onClick(View arg0) {
													Intent intent = new Intent(
															activity,
															ShowImgActivity.class);
													intent.putExtra(
															"remoteUrl",
															remoteUrl);
													intent.putExtra("localUrl",
															"");
													activity.startActivity(intent);
												}
											});
								}

								@Override
								public void onLoading(View container,
										String uri, BitmapDisplayConfig config,
										long total, long current) {
									super.onLoading(container, uri, config,
											total, current);
									int progress = (int) (((current * 1.0f) / (total * 1.0f)) * 100);
									tv_pnum.setText(progress + "");
								}

								@Override
								public void onLoadFailed(View container,
										String uri, Drawable drawable) {
									super.onLoadFailed(container, uri, drawable);
									pb_num.setVisibility(View.INVISIBLE);
									tv_pnum.setVisibility(View.INVISIBLE);
									// parent.removeView(iv_container);

								}
							});
				}
			}
		}
	}

	private static String getThUrl(String localUrl) {
		String getUrl = localUrl.substring(0, localUrl.lastIndexOf("/"))
				+ "/th"
				+ localUrl.substring(localUrl.lastIndexOf("/") + 1,
						localUrl.length());
		return getUrl;
	}

	private static class LocalUrlTask extends AsyncTask<String, Void, Bitmap> {
		private static MyCache cache = new MyCache(1024 * 1024 * 4);// 分配4M空间
		private Context context;
		private LocalResultCall callback;

		public LocalUrlTask(Context context, LocalResultCall callback) {
			this.context = context;
			this.callback = callback;
		}

		@Override
		protected Bitmap doInBackground(String... params) {
			LogUtils.v("bmUrl is" + params[0]);
			Bitmap bm = cache.getBitmap(params[0]);
			if (bm == null) {
				bm = ThumbnailUtils.extractThumbnail(
						BitmapFactory.decodeFile(params[0]),
						Utils.dip2px(context, 100), Utils.dip2px(context, 100));
				cache.putBitmap(params[0], bm);
				LogUtils.v("is in cache new");
			}
			return bm;
		}

		@Override
		protected void onPostExecute(Bitmap result) {
			if (callback != null)
				callback.getData(result);
		}

	}

	private static class MyCache extends LruCache<String, Bitmap> {

		public MyCache(int maxSize) {
			super(maxSize);
		}

		public void putBitmap(String url, Bitmap bm) {
			if (bm == null) {
				LogUtils.v("图片为空");
				return;
			}
			put(url, bm);
		}

		public Bitmap getBitmap(String url) {
			return get(url);
		}
	}

	private static interface LocalResultCall {
		public void getData(Bitmap bm);
	}
}
