package com.android.tonight8.easemob;

import java.util.HashMap;
import java.util.Map;

/**
 * 环信用到固定参数
 * 
 * @Descripton
 * @author LiXiaoSong
 * @2015-4-13
 * @EaseMobTest
 */
public class MobConstants {
	public static final String MESSAGE_GET = "get_message";
	/** 表情库 */
	public static final Map<String, Integer> FACELIB;
	static {
		/** 初始化表情库 */
		FACELIB = new HashMap<String, Integer>();
		FACELIB.put("/笑", 100);
		FACELIB.put("/哭", 101);
		FACELIB.put("/惊", 102);
		FACELIB.put("/喜欢", 104);
		FACELIB.put("/玫瑰", 105);
		FACELIB.put("/生气", 106);
	}
}
