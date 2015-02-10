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

	public static String newJsonkey = "";
	static String key1 = "";//

	public static <T> T parseJsonStr(String jsonStr, Class<T> clazz) {
		T t = JSON.parseObject(jsonStr, clazz);
		LogUtils.v(t.toString());
		return t;
	}

	public static String getObjectToString(JSONObject jsonObject) {

		Iterator<Entry<String, Object>> it = jsonObject.entrySet().iterator();
		Set<String> keysey = jsonObject.keySet();
		key1 = key1 + "," + keysey.toString().replace("[", "").replace("]", "");
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
				String str = value.toString().substring(1, value.toString().length() - 1);
				if (str.contains("}},")) {
					str = str.substring(0, str.indexOf("}},") + 2);
				}

				JSONObject jsonObject2 = JSONObject.parseObject(str);
				Set<String> keysey2 = jsonObject2.keySet();
				key1 = key1 + "," + keysey2.toString().replace("[", "").replace("]", "");
				for (int i = 0; i < keysey2.size(); i++) {
					newJsonkey = newJsonkey + key + ",";
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
			if (json[i].contains("_")) {
				String tempString = json[i];
				String newStr = getFirstLetterToUpper(json[i]);
				jsonObjectString = jsonObjectString.replace(tempString, newStr);
			}
		}
		if (jsonObjectString.contains("_")) {
			String tempString = "";
			String[] tempJson = jsonObjectString.split("_");
			for (int j = 1; j < tempJson.length; j++) {
				String str1 = StringUtils.firstLetterToUpper(tempJson[j]);
				tempString = tempString + str1;
			}
			tempString = tempJson[0] + tempString;
			jsonObjectString = tempString;
		}
		return jsonObjectString;
	}

	private static String getFirstLetterToUpper(String keyStr) {
		String tempJsonStr = "";
		if (!StringUtils.isNullOrEmpty(keyStr) && keyStr.contains("_")) {
			String[] tempJson = keyStr.split("_");
			for (int i = 1; i < tempJson.length; i++) {
				keyStr = StringUtils.firstLetterToUpper(tempJson[i]);
				tempJsonStr = tempJsonStr + keyStr;
			}
			tempJsonStr = tempJson[0] + tempJsonStr;
		} else {
			tempJsonStr = keyStr;
		}
		return tempJsonStr;
	}
	// --------------下划线改为驼峰用到的-------------

}
