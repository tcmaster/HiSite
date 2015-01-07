/**
 * 2015-1-7
 */
package com.android.utils;

import java.util.HashMap;

import android.graphics.Bitmap;
import android.widget.ImageView;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

/**
 * @Description:二维码生成工具
 * @author:LiXiaoSong
 * @copyright @HiSite
 * @Date:2015-1-7
 */
public class QRCodeUtils {

	/**
	 * 
	 * @Description:根据给定字符串生成二维码，并显示在图像控件上
	 * @param str
	 *            给定字符串
	 * @param iv
	 *            图像控件
	 * @author: LiXiaoSong
	 * @date:2015-1-7
	 */
	public static void createQRImage(String str, ImageView iv) {
		if (StringUtils.isNullOrEmpty(str)) {
			return;
		}

		try {
			int width = iv.getLayoutParams().width;
			int height = iv.getLayoutParams().height;
			HashMap<EncodeHintType, String> hints = new HashMap<EncodeHintType, String>();
			hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
			BitMatrix bm = new QRCodeWriter().encode(str, BarcodeFormat.QR_CODE, width, height, hints);// 生成图片每个点的像素值
			int[] pixels = new int[width * height];
			for (int y = 0; y < height; y++) {
				for (int x = 0; x < width; x++) {
					if (bm.get(x, y)) {
						pixels[y * width + x] = 0xff000000;
					} else {
						pixels[y * width + x] = 0xffffffff;
					}
				}
			}
			Bitmap bm_result = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
			bm_result.setPixels(pixels, 0, width, 0, 0, width, height);
			iv.setImageBitmap(bm_result);
		} catch (WriterException e) {
			e.printStackTrace();
		}
	}
}
