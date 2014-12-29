package com.android.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import android.util.Log;

/**
 * 
 * @Description:md5加密工具
 * @author:LiXiaoSong
 * @copyright @HiSite
 * @Date:2014-12-29
 */
public class MD5Utils {

	public static HashMap<String, String> getFinalHashMap(HashMap<String, String> mHashMap) {
		Object[] key = mHashMap.keySet().toArray();
		Arrays.sort(key);
		String md5String = "";
		for (int i = 0; i < key.length; i++) {
			md5String = md5String + key[i].toString() + "=" + mHashMap.get(key[i].toString());
			if (i != key.length - 1) {
				md5String += "&";
			}
		}
		md5String = MD5Utils.md5s(md5String);
		mHashMap.put("sign", md5String);
		Iterator iter = mHashMap.entrySet().iterator();
		while (iter.hasNext()) {
			Map.Entry entry = (Map.Entry) iter.next();
			Log.e("post entry的key", entry.getKey().toString());
			Log.e("post entry的value", entry.getValue().toString());
		}
		return mHashMap;
	}

	/**
	 * MD5
	 * 
	 * @param view
	 */
	public static String md5s(String plainText) {
		String str = "";
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(plainText.getBytes());
			byte b[] = md.digest();

			int i;

			StringBuffer buf = new StringBuffer("");
			for (int offset = 0; offset < b.length; offset++) {
				i = b[offset];
				if (i < 0)
					i += 256;
				if (i < 16)
					buf.append("0");
				buf.append(Integer.toHexString(i));
			}
			str = buf.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return str;
	}

}
