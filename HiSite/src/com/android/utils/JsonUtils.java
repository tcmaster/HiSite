package com.android.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.lidroid.xutils.util.LogUtils;

/**
 * 解析JSON的实体类
 * 
 * @author LiXiaoSong
 * 
 */
public class JsonUtils {

	public static <T> T parseJsonStr(String jsonStr, Class<T> clazz) {
		T t = JSON.parseObject(jsonStr, new TypeReference<T>() {
		});
		LogUtils.v(t.toString());
		return t;
	}

}
