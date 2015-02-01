package com.android.tonight8.storage.createevent;

import java.lang.ref.SoftReference;

/**
 * @author liuzhao
 * @date 2015-1-22 发布活动模块数据存储
 */
public class CreateEventStorage {
	/** 发布活动数据存储控制类 */
	private static SoftReference<CreateEventNativeController> createeventReference = new SoftReference<CreateEventNativeController>(
			new CreateEventNativeController());

	/** 获取发布活动列表数据存储控制类 */
	public CreateEventNativeController getLiveListDBController() {
		if (createeventReference.get() == null) {
			createeventReference = new SoftReference<CreateEventNativeController>(
					new CreateEventNativeController());
		}
		return createeventReference.get();

	}
}
