package com.android.tonight8.storage.live;

import java.lang.ref.SoftReference;

/**
 * @author liuzhao 活动现场数据存储
 */
public class LiveStorage {

	/** 现场列表数据存储控制类 */
	private static SoftReference<LiveListNativeController> listControllerReference = new SoftReference<LiveListNativeController>(
			new LiveListNativeController());
	/** 现场详情数据存储控制类 */
	private static SoftReference<LiveDetailNativeController> detailControllerReference = new SoftReference<LiveDetailNativeController>(
			new LiveDetailNativeController());
	/** 评论列表录入数据存储控制类 */
	private static SoftReference<LiveCommentsNativeController> liveCommentsControllerReference = new SoftReference<LiveCommentsNativeController>(
			new LiveCommentsNativeController());
	/** 评论录入数据存储控制类 */
	private static SoftReference<LiveCommentNativeController> liveCommentControllerReference = new SoftReference<LiveCommentNativeController>(
			new LiveCommentNativeController());
	/** 现场签到数据存储控制类 */
	private static SoftReference<LiveSignInNativeController> liveSignInControllerReference = new SoftReference<LiveSignInNativeController>(
			new LiveSignInNativeController());
	/** 现场话题列表录入数据存储控制类 */
	private static SoftReference<LiveSubjectsNativeController> liveSubjectsControllerReference = new SoftReference<LiveSubjectsNativeController>(
			new LiveSubjectsNativeController());
	/** 现场话题录入数据存储控制类 */
	private static SoftReference<LiveSubjectNativeController> liveSubjectControllerReference = new SoftReference<LiveSubjectNativeController>(
			new LiveSubjectNativeController());

	/** 获取现场列表数据存储控制类 */
	public static LiveListNativeController getLiveListDBController() {
		if (listControllerReference.get() == null) {
			listControllerReference = new SoftReference<LiveListNativeController>(
					new LiveListNativeController());
		}
		return listControllerReference.get();

	}

	/** 获取现场详情数据存储控制类 */
	public static LiveDetailNativeController getLiveDetailDBController() {
		if (detailControllerReference.get() == null) {
			detailControllerReference = new SoftReference<LiveDetailNativeController>(
					new LiveDetailNativeController());
		}
		return detailControllerReference.get();

	}

	/** 获取评论列表录入数据存储控制类 */
	public static LiveCommentsNativeController getLiveCommentsController() {
		if (liveCommentsControllerReference.get() == null) {
			liveCommentsControllerReference = new SoftReference<LiveCommentsNativeController>(
					new LiveCommentsNativeController());
		}
		return liveCommentsControllerReference.get();

	}

	/** 获取评论录入数据存储控制类 */
	public static LiveCommentNativeController getLiveCommentNativeController() {
		if (liveCommentControllerReference.get() == null) {
			liveCommentControllerReference = new SoftReference<LiveCommentNativeController>(
					new LiveCommentNativeController());
		}
		return liveCommentControllerReference.get();

	}

	/** 获取现场签到数据存储控制类 */
	public static LiveSignInNativeController getLiveSignInNativeController() {
		if (liveSignInControllerReference.get() == null) {
			liveSignInControllerReference = new SoftReference<LiveSignInNativeController>(
					new LiveSignInNativeController());
		}
		return liveSignInControllerReference.get();

	}

	/** 获取现场话题列表录入数据存储控制类 */
	public static LiveSubjectsNativeController getLiveSubjectsNativeController() {
		if (liveSubjectsControllerReference.get() == null) {
			liveSubjectsControllerReference = new SoftReference<LiveSubjectsNativeController>(
					new LiveSubjectsNativeController());
		}
		return liveSubjectsControllerReference.get();

	}

	/** 获取现场话题录入数据存储控制类 */
	public static LiveSubjectNativeController getLiveSubjectNativeController() {
		if (liveSubjectControllerReference.get() == null) {
			liveSubjectControllerReference = new SoftReference<LiveSubjectNativeController>(
					new LiveSubjectNativeController());
		}
		return liveSubjectControllerReference.get();

	}
}
