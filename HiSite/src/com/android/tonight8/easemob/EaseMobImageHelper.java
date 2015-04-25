package com.android.tonight8.easemob;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.android.tonight8.R;
import com.android.tonight8.activity.user.ShowImgActivity;
import com.easemob.EMCallBack;
import com.easemob.chat.EMMessage;
import com.easemob.chat.ImageMessageBody;
import com.lidroid.xutils.BitmapUtils;
import com.lidroid.xutils.bitmap.BitmapDisplayConfig;
import com.lidroid.xutils.bitmap.callback.BitmapLoadFrom;
import com.lidroid.xutils.bitmap.callback.DefaultBitmapLoadCallBack;

/**
 * @Descripton �����շ�ͼƬ������
 * @author LiXiaoSong
 * @2015-4-15
 * @EaseMobTest
 */
public class EaseMobImageHelper {
	/**
	 * ����ǰ��Ϣ��ͼƬչʾ����Ӧ�Ľ�����
	 * 
	 * @param message
	 *            ͼƬ����Ϣ
	 * @param container
	 *            ͼƬ������
	 * @param activity
	 *            ��Ӧ��activity
	 * @param bmUtils
	 *            ͼƬ����
	 */
	public static void showImage(EMMessage message, final View container,
			final Context activity, final BitmapUtils bmUtils) {
		showImage(message, null, container, activity, bmUtils);
	}

	/**
	 * ����ǰ��Ϣ��ͼƬչʾ����Ӧ�Ľ�����
	 * 
	 * @param message
	 *            ͼƬ����Ϣ
	 * @param parent
	 *            ���ؼ�
	 * @param container
	 *            ͼƬ������
	 * @param activity
	 *            ��Ӧ��activity
	 * @param bmUtils
	 *            ͼƬ����
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
			// ���͵���Ϣ����
			if (message.direct == EMMessage.Direct.SEND) {
				bmUtils.display(iv_container, thUrl,
						new DefaultBitmapLoadCallBack<ImageView>() {
							@Override
							public void onLoading(ImageView container,
									String uri, BitmapDisplayConfig config,
									long total, long current) {
								super.onLoading(container, uri, config, total,
										current);
							}

							@Override
							public void onLoadFailed(ImageView container,
									String uri, Drawable drawable) {
								super.onLoadFailed(container, uri, drawable);
								pb_num.setVisibility(View.INVISIBLE);
								tv_pnum.setVisibility(View.INVISIBLE);

							}

							@Override
							public void onLoadCompleted(ImageView container,
									String uri, Bitmap bitmap,
									BitmapDisplayConfig config,
									BitmapLoadFrom from) {
								super.onLoadCompleted(container, uri, bitmap,
										config, from);
								pb_num.setVisibility(View.INVISIBLE);
								tv_pnum.setVisibility(View.INVISIBLE);
							}
						});
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
			} else {// ���յ�����Ϣ����
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
					body.downloadCallback = new EMCallBack() {

						@Override
						public void onSuccess() {
							pb_num.setVisibility(View.VISIBLE);
							tv_pnum.setVisibility(View.VISIBLE);
							bmUtils.display(iv_container, thUrl,
									new DefaultBitmapLoadCallBack<View>() {
										@Override
										public void onLoadCompleted(
												View container, String uri,
												Bitmap bitmap,
												BitmapDisplayConfig config,
												BitmapLoadFrom from) {
											super.onLoadCompleted(container,
													uri, bitmap, config, from);
											pb_num.setVisibility(View.INVISIBLE);
											tv_pnum.setVisibility(View.INVISIBLE);
											tv_pnum.setText("0");
											iv_container
													.setOnClickListener(new OnClickListener() {

														@Override
														public void onClick(
																View arg0) {
															Intent intent = new Intent(
																	activity,
																	ShowImgActivity.class);
															intent.putExtra(
																	"remoteUrl",
																	remoteUrl);
															intent.putExtra(
																	"localUrl",
																	"");
															activity.startActivity(intent);
														}
													});
										}

										@Override
										public void onLoading(View container,
												String uri,
												BitmapDisplayConfig config,
												long total, long current) {
											super.onLoading(container, uri,
													config, total, current);
											int progress = (int) (((current * 1.0f) / (total * 1.0f)) * 100);
											tv_pnum.setText(progress);
										}

										@Override
										public void onLoadFailed(
												View container, String uri,
												Drawable drawable) {
											super.onLoadFailed(container, uri,
													drawable);
											pb_num.setVisibility(View.INVISIBLE);
											tv_pnum.setVisibility(View.INVISIBLE);
											// parent.removeView(iv_container);

										}
									});
						}

						@Override
						public void onProgress(int arg0, String arg1) {
						}

						@Override
						public void onError(int arg0, String arg1) {
						}
					};
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
}
