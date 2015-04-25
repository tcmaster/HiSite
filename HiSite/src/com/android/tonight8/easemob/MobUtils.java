package com.android.tonight8.easemob;

import java.util.Iterator;
import java.util.List;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageManager;

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
	 * �õ�Ӧ�����
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
}
