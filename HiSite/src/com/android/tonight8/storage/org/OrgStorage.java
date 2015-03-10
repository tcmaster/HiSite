package com.android.tonight8.storage.org;

import java.lang.ref.SoftReference;

/**
 * @author liuzhao
 * @date 2015-1-22 发布活动模块数据存储
 */
public class OrgStorage {

	/** 绑定经销商数据存储控制类 */
	private static SoftReference<OrgCertificateNativeController> orgCertiicateReference = new SoftReference<OrgCertificateNativeController>(new OrgCertificateNativeController());
	/** 商家关注与取消数据存储控制类 */
	private static SoftReference<OrgFollowingNativeController> orgFollowingReference = new SoftReference<OrgFollowingNativeController>(new OrgFollowingNativeController());
	/** 商家消息列表数据存储控制类 */
	private static SoftReference<OrgMessageNativeController> orgMessageReference = new SoftReference<OrgMessageNativeController>(new OrgMessageNativeController());
	/** 商家问题存储控制类 */
	private static SoftReference<OrgQuestionsNativeController> orgQuestionReference = new SoftReference<OrgQuestionsNativeController>(new OrgQuestionsNativeController());

	/** 获取绑定经销商数据存储控制类 */
	public static OrgCertificateNativeController getOrgCertificateController() {
		if (orgCertiicateReference.get() == null) {
			orgCertiicateReference = new SoftReference<OrgCertificateNativeController>(new OrgCertificateNativeController());
		}
		return orgCertiicateReference.get();

	}

	/** 获取商家关注与取消数据存储控制类 */
	public static OrgFollowingNativeController getOrgFollowingController() {
		if (orgFollowingReference.get() == null) {
			orgFollowingReference = new SoftReference<OrgFollowingNativeController>(new OrgFollowingNativeController());
		}
		return orgFollowingReference.get();

	}

	/** 获取商家消息列表数据存储控制类 */
	public static OrgMessageNativeController getOrgMessageController() {
		if (orgMessageReference.get() == null) {
			orgMessageReference = new SoftReference<OrgMessageNativeController>(new OrgMessageNativeController());
		}
		return orgMessageReference.get();

	}

	/** 获取商家问题存储控制类 */
	public static OrgQuestionsNativeController getOrgQuestionController() {
		if (orgQuestionReference.get() == null) {
			orgQuestionReference = new SoftReference<OrgQuestionsNativeController>(new OrgQuestionsNativeController());
		}
		return orgQuestionReference.get();

	}
}
