/**
 * 2015-1-21
 */
package com.android.tonight8.storage.event;

import com.android.tonight8.model.event.EventDetailModel;
import com.android.tonight8.storage.entity.CouponEntity;
import com.android.tonight8.storage.entity.EventEntity;
import com.android.tonight8.storage.entity.OrgEntity;

/**
 * @Description:活动详情本地控制类
 * @author:LiXiaoSong
 * @copyright @HiSite
 * @Date:2015-1-21
 */
public class EventDetailModelNativeController {

	public void insertData(EventDetailModel model) {
		EventEntity eventEntity = new EventEntity();
		OrgEntity orgEntity = new OrgEntity();
		CouponEntity couponEntity = new CouponEntity();
	}
}
