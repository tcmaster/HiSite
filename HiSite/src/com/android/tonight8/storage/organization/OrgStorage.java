package com.android.tonight8.storage.organization;

import java.lang.ref.SoftReference;

/**
 * @author liuzhao
 * @date 2015-1-22 发布活动模块数据存储
 */
public class OrgStorage {
	/** 绑定经销商数据存储控制类 */
	private static SoftReference<OrgCertificateNativeController> orgCertiicateReference = new SoftReference<OrgCertificateNativeController>(
			new OrgCertificateNativeController());
	/** 商家关注与取消数据存储控制类 */
	private static SoftReference<OrgFollowingNativeController> orgFollowingReference = new SoftReference<OrgFollowingNativeController>(
			new OrgFollowingNativeController());

	/** 获取绑定经销商数据存储控制类 */
	public static OrgCertificateNativeController getOrgCertificateController() {
		if (orgCertiicateReference.get() == null) {
			orgCertiicateReference = new SoftReference<OrgCertificateNativeController>(
					new OrgCertificateNativeController());
		}
		return orgCertiicateReference.get();

	}

	/** 获取商家关注与取消数据存储控制类 */
	public static OrgFollowingNativeController getOrgFollowingController() {
		if (orgFollowingReference.get() == null) {
			orgFollowingReference = new SoftReference<OrgFollowingNativeController>(
					new OrgFollowingNativeController());
		}
		return orgFollowingReference.get();

	}
}
