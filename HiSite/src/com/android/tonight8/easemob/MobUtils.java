package com.android.tonight8.easemob;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.text.SpannableStringBuilder;
import android.text.style.ImageSpan;

import com.android.tonight8.dao.TMessageDao;
import com.android.tonight8.dao.entity.TMessage;
import com.android.tonight8.storage.GreenDaoUtils;
import com.easemob.chat.EMMessage;
import com.easemob.exceptions.EaseMobException;

import de.greenrobot.dao.Property;

/**
 * �����õ��ĸ������
 * 
 * @Descripton
 * @author LiXiaoSong
 * @2015-4-13
 * @EaseMobTest
 */
public class MobUtils {
	/**
	 * 得到应用的名称
	 * 
	 * @param context
	 * @param pID
	 * @return
	 */
	public static String getAppName(Context context, int pID) {
		String processName = null;
		ActivityManager am = (ActivityManager) context
				.getSystemService(context.ACTIVITY_SERVICE);
		List l = am.getRunningAppProcesses();
		Iterator i = l.iterator();
		PackageManager pm = context.getPackageManager();
		while (i.hasNext()) {
			ActivityManager.RunningAppProcessInfo info = (ActivityManager.RunningAppProcessInfo) (i
					.next());
			try {
				if (info.pid == pID) {
					CharSequence c = pm.getApplicationLabel(pm
							.getApplicationInfo(info.processName,
									PackageManager.GET_META_DATA));
					// Log.d("Process", "Id: "+ info.pid +" ProcessName: "+
					// info.processName +"  Label: "+c.toString());
					// processName = c.toString();
					processName = info.processName;
					return processName;
				}
			} catch (Exception e) {
			}
		}
		return processName;
	}

	/**
	 * 保存或更新一条message消息到本地
	 * 
	 * @param message
	 */
	public static void saveOrUpdateMessage(EMMessage message, String userName) {
		TMessageDao dao = GreenDaoUtils.getDaoSession().getTMessageDao();
		Property property = TMessageDao.Properties.UserName;
		TMessage tMessage = dao.queryBuilder().where(property.eq(userName))
				.build().unique();// 开启一条新的聊天记录列表
		if (tMessage == null) {
			// 插入
			TMessage newTMessage = new TMessage();
			newTMessage.setUserName(userName);
			newTMessage.setLastTime(message.getMsgTime());
			newTMessage.setUserLastMessage(message.getMsgId());
			try {
				newTMessage.setUserPic(message.getStringAttribute("photoUrl"));
			} catch (EaseMobException e) {
				e.printStackTrace();
			}
			dao.insert(newTMessage);
		} else {
			// 更新最新消息
			tMessage.setLastTime(message.getMsgTime());
			tMessage.setUserLastMessage(message.getMsgId());
			try {
				tMessage.setUserPic(message.getStringAttribute("photoUrl"));
			} catch (EaseMobException e) {
				e.printStackTrace();
			}
			dao.update(tMessage);
		}
	}

	/**
	 * 将普通文字解析转换成带表情的文字
	 * 
	 * @param text
	 */
	public SpannableStringBuilder getFaceString(Context context, String src) {
		Iterator<Map.Entry<String, Integer>> iterator = MobConstants.FACELIB
				.entrySet().iterator();
		SpannableStringBuilder builder = new SpannableStringBuilder(src);
		while (iterator.hasNext()) {
			Entry<String, Integer> entry = iterator.next();
			int index = src.indexOf(entry.getKey());
			if (index != -1) {
				builder.setSpan(new ImageSpan(context, entry.getValue()),
						index, index + entry.getKey().length(),
						SpannableStringBuilder.SPAN_INCLUSIVE_INCLUSIVE);
			}
		}
		return builder;
	}
}
