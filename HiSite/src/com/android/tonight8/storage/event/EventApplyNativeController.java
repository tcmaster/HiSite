/**
 * 2015-1-23
 */
package com.android.tonight8.storage.event;

import com.android.tonight8.model.common.Apply;
import com.android.tonight8.storage.DBUtil;
import com.android.tonight8.storage.entity.ApplyEntity;
import com.android.tonight8.storage.entity.EventEntity;
import com.android.tonight8.storage.entity.UserEntity;

/**
 * @Description: 报名活动写入接口
 * @author:LiXiaoSong
 * @copyright @HiSite
 * @Date:2015-1-23
 */
public class EventApplyNativeController {

	/**
	 * @Description:写入一条报名数据
	 * @param model
	 *            报名数据
	 * @param eventid
	 *            报的哪个活动
	 * @param userid
	 *            哪个用户报的
	 * @author: LiXiaoSong
	 * @date:2015-1-23
	 */
	public void insertData(Apply model, long eventid, long userid) {
		ApplyEntity entity = new ApplyEntity();
		DBUtil.copyData(Apply.class, ApplyEntity.class, model, entity);
		entity.event = DBUtil.getDataFirst(EventEntity.class, "id = " + eventid);
		entity.user = DBUtil.getDataFirst(UserEntity.class, "id = " + userid);
		DBUtil.addData(entity);
	}
}
