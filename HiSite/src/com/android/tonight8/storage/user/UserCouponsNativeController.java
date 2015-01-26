package com.android.tonight8.storage.user;

import java.util.ArrayList;
import java.util.List;

import com.android.tonight8.model.common.Coupon;
import com.android.tonight8.model.common.Org;
import com.android.tonight8.model.user.UserCouponModel;
import com.android.tonight8.storage.DBUtil;
import com.android.tonight8.storage.entity.CouponEntity;
import com.android.tonight8.storage.entity.OrgEntity;

/**
 * 
 * @Descripton 用户优惠券本地控制类
 * @author LiXiaoSong
 * @2015-1-24
 * @Tonight8
 */
public class UserCouponsNativeController {
	/**
	 * 优惠券列表存储
	 * @param models
	 */
	public void insertData(List<UserCouponModel> models){
		List<CouponEntity> couponEntities = new ArrayList<CouponEntity>();
		List<OrgEntity> orgEntities = new ArrayList<OrgEntity>();
		for(int i = 0;i < models.size();i++){
			CouponEntity couponEntity = new CouponEntity();
			OrgEntity orgEntity = new OrgEntity();
			DBUtil.copyData(Org.class,OrgEntity.class,models.get(i).org,orgEntity);
			DBUtil.copyData(Coupon.class, CouponEntity.class,models.get(i).coupon, couponEntity);
			/**优惠券无法和userId进行连接*/
			
		}
	}
	/**
	 * 根据用户id读取优惠券列表
	 * @param userId 
	 * @return
	 */
	public List<UserCouponModel> selectData(long userId){
		List<UserCouponModel> models = new ArrayList<UserCouponModel>();
		
		return models;
	}
}
