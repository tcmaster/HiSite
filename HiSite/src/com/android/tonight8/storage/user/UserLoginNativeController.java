package com.android.tonight8.storage.user;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

import com.android.tonight8.model.user.UserInfo;
/**
 * @Descripton 用户登录信息本地控制类
 * @author LiXiaoSong
 * @2015-1-24
 * @Tonight8
 */
public class UserLoginNativeController {
	/**
	 * @Descripton 保存用户登录信息
	 * @param context 上下文
	 * @param info 用户信息
	 */
	public void saveUserInfo(Context context,UserInfo info){
		clearInfo(context);
		SharedPreferences preferences = context.getSharedPreferences("userInfo",Context.MODE_PRIVATE);
		Editor editor = preferences.edit();
		editor.putInt("userInfo", info.userId);
		editor.commit();
		
	}
	/**
	 * @Descripton 获取用户登录信息
	 * @param context 上下文
	 * @param info 用户信息
	 */
	public UserInfo getUserInfo(Context context){
		UserInfo userInfo = new UserInfo();
		SharedPreferences preferences = context.getSharedPreferences("userInfo",Context.MODE_PRIVATE);
		userInfo.userId = preferences.getInt("userInfo",-1);
		return userInfo;
	}
	/**
	 * @Descripton 清空用户登录信息
	 * @param context 上下文
	 */
	public void clearInfo(Context context){
		SharedPreferences preferences = context.getSharedPreferences("userInfo",Context.MODE_PRIVATE);
		Editor editor = preferences.edit();
		editor.clear();
		editor.commit();
	}
}
