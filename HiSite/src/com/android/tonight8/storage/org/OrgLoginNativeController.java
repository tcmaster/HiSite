package com.android.tonight8.storage.org;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class OrgLoginNativeController {

	private String STORE_NAME = "OrgLoginInfo";
	private SharedPreferences preference;

	public OrgLoginNativeController(Context context) {
		super();
		preference = context.getSharedPreferences(STORE_NAME, Context.MODE_PRIVATE);
	}

	/**
	 * @Descripton 保存商家登录信息
	 * @param context
	 *            上下文
	 * @param info
	 *            用户信息
	 */
	public void saveOrgLoginInfo(String inputOrgId) {

		Editor editor = preference.edit();
		editor.putString("org_id", inputOrgId);
		editor.commit();

	}

	/**
	 * @Descripton 获取商家登录信息
	 * @param context
	 *            上下文
	 * @param info
	 *            用户信息
	 */
	public String getOrgLoginInfo() {
		String inputOrgId = preference.getString("org_id", "");
		return inputOrgId;
	}

	/**
	 * @Descripton 清空商家登录信息
	 * @param context
	 *            上下文
	 */
	public void clearInfo(Context context) {
		Editor editor = preference.edit();
		editor.clear();
		editor.commit();
	}
}
