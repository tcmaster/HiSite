package com.android.tonight8.utils;

import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.lidroid.xutils.util.LogUtils;

/**
 * 解析JSON的实体类
 * 
 * @author LiXiaoSong
 * 
 */
public class JsonUtils {

	static String newJsonkey = "";
	static String key1 = "";//

	public static <T> T parseJsonStr(String jsonStr, Class<T> clazz) {
		T t = JSON.parseObject(jsonStr, clazz);
		LogUtils.v(t.toString());
		return t;
	}

	public static String getObjectToString(JSONObject jsonObject) {
		newJsonkey = "";
		Iterator<Entry<String, Object>> it = jsonObject.entrySet().iterator();
		Set<String> keysey = jsonObject.keySet();
		key1 = key1 + "," + keysey.toString();
		while (it.hasNext()) {
			Entry<String, Object> entiy = it.next();
			String key = entiy.getKey();
			Object value = entiy.getValue();
			newJsonkey = newJsonkey + key + ",";

			if (value instanceof Integer) {
				// newJson = newJson + key;
			} else if (value instanceof String) {
				// newJson = newJson + key;
			} else if (value instanceof List) {

				JSONObject jsonObject2 = JSONObject.parseObject(value.toString().substring(1, value.toString().length() - 1));
				Set<String> keysey2 = jsonObject2.keySet();
				for (int i = 0; i < keysey2.size(); i++) {
					getObjectToString(jsonObject2);
				}

			} else if (value instanceof JSONObject) {
				getObjectToString((JSONObject) value);

			}
		}

		return newJsonkey.substring(0, newJsonkey.length() - 1);
	}

	public static String getStringData(String jsonkey, JSONObject jsonObject) {
		String jsonObjectString = jsonObject.toString();
		String[] json = jsonkey.split(",");
		for (int i = 0; i < json.length; i++) {
			String word = getFirstLetterToUpper(json[i]);
			jsonObjectString = jsonObjectString.replace(json[i], word);
		}
		return jsonObjectString;
	}

	private static String getFirstLetterToUpper(String keyStr) {
		String tempJsonStr = "";
		if (!StringUtils.isNullOrEmpty(keyStr) && keyStr.contains("_")) {
			String[] tempJson = keyStr.split("_");
			for (int i = 1; i < tempJson.length; i++) {
				keyStr = StringUtils.firstLetterToUpper(tempJson[i]);
				tempJsonStr = tempJson[0] + keyStr;
			}
		} else {
			tempJsonStr = keyStr;
		}
		return tempJsonStr;
	}
	// --------------下划线改为驼峰用到的-------------

}
