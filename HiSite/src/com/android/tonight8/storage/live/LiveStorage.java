package com.android.tonight8.storage.live;

import java.lang.ref.SoftReference;

/**
 * @author liuzhao 活动现场数据存储
 */
public class LiveStorage {

	/** 现场列表数据存储控制类 */
	private static SoftReference<LiveListNativeController> listControllerReference = new SoftReference<LiveListNativeController>(new LiveListNativeController());
	/** 现场详情数据存储控制类 */
	private static SoftReference<LiveDetailNativeController> detailControllerReference = new SoftReference<LiveDetailNativeController>(new LiveDetailNativeController());

	/** 获取现场列表数据存储控制类 */
	public LiveListNativeController getLiveListDBController() {
		if (listControllerReference.get() == null) {
			listControllerReference = new SoftReference<LiveListNativeController>(new LiveListNativeController());
		}
		return listControllerReference.get();

	}

	/** 获取现场详情数据存储控制类 */
	public LiveDetailNativeController getLiveDetailDBController() {
		if (detailControllerReference.get() == null) {
			detailControllerReference = new SoftReference<LiveDetailNativeController>(new LiveDetailNativeController());
		}
		return detailControllerReference.get();

	}
}
