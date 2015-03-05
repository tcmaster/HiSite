package com.android.tonight8.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import android.graphics.Bitmap;
import android.os.Environment;

import com.android.tonight8.base.AppConstants;
import com.lidroid.xutils.util.LogUtils;

/**
 * 相册和拍照
 */
public class AlbumAndCamera {

	public static String imagePath = "";

	/**
	 * 将inputstream保存至文件中
	 * 
	 * @param is
	 * @param context
	 * @return返回文件路径
	 */
	public static String convertStream2File(InputStream is) {
		File file = getTempPath();
		final String filePath = file.getAbsolutePath();
		try {
			FileOutputStream fos = new FileOutputStream(file);
			CopyStream(is, fos);
			is.close();
			fos.close();
		} catch (Exception e) {
			LogUtils.w(e.toString());
		}
		return filePath;
	}

	public static boolean isImage(String url) {
		if (StringUtils.isNullOrEmpty(url)) {
			return false;
		}
		if (url.indexOf("images") > 0) {
			return true;
		} else {
			if (url.endsWith(".jpg") || url.endsWith(".png")) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 获取路径
	 * 
	 * @return
	 */
	public static File getTempPath() {
		File tempFile = null;
		if (checkSDCard()) {
			File dirFile = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + AppConstants.CACHE_DIR_PATH);
			tempFile = new File(dirFile, System.currentTimeMillis() + ".jpg");
			if (!tempFile.getParentFile().exists()) {
				tempFile.getParentFile().mkdirs();
			}
		}
		return tempFile;
	}

	/**
	 * 检查SD卡是否存在
	 * 
	 * @return true:存在 false:不存在
	 * @see:
	 * @since:
	 * @author: ZhongCongXu
	 * @date:2014年5月23日
	 */
	public static boolean checkSDCard() {
		if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
			return true;
		} else {
			return false;
		}
	}

	public static void CopyStream(InputStream is, OutputStream os) {
		final int buffer_size = 1024;
		try {
			byte[] bytes = new byte[buffer_size];
			for (;;) {
				int count = is.read(bytes, 0, buffer_size);
				if (count == -1)
					break;
				os.write(bytes, 0, count);
			}
		} catch (Exception ex) {
		}
	}

	/**
	 * 获取图片路径
	 * 
	 * @param data
	 * @param file
	 * @return
	 */
	public static String getImagePath(File file, Bitmap b) {
		imagePath = "";
		FileOutputStream fos = null;

		try {
			fos = new FileOutputStream(file);
			if (fos != null) {
				b.compress(Bitmap.CompressFormat.JPEG, 90, fos);
				fos.flush();
				fos.close();
			}
		} catch (FileNotFoundException e) {
			LogUtils.w(e.toString());
		} catch (IOException e) {
			LogUtils.w(e.toString());
		}
		imagePath = file.getAbsolutePath();
		return imagePath;
	}

}
