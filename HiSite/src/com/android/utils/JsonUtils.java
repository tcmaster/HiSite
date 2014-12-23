package com.android.utils;

import com.alibaba.fastjson.JSON;
import com.lidroid.xutils.util.LogUtils;

/**
 * 解析JSON的实体类
 * 
 * @author LiXiaoSong
 * 
 */
public class JsonUtils {

	public static <T> void parseJsonStr(String jsonStr, Class<T> clazz) {
		T t = JSON.parseObject(jsonStr, clazz);
		LogUtils.v(t.toString());
	}

}
