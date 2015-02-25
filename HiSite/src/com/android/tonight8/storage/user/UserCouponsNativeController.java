package com.android.tonight8.storage.user;

import java.util.ArrayList;
import java.util.List;

import com.android.tonight8.model.common.Coupon;
import com.android.tonight8.model.common.CouponProvide;
import com.android.tonight8.model.common.Org;
import com.android.tonight8.model.common.QuickMark;
import com.android.tonight8.model.user.UserCouponModel;
import com.android.tonight8.storage.DBUtil;
import com.android.tonight8.storage.entity.CouponEntity;
import com.android.tonight8.storage.entity.CouponProvideEntity;
import com.android.tonight8.storage.entity.EventEntity;
import com.android.tonight8.storage.entity.OrgEntity;
import com.android.tonight8.storage.entity.QuickMarkEntity;
import com.android.tonight8.storage.entity.UserEntity;

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
	 * 
	 * @param models
	 */
	public void insertData(List<UserCouponModel> models) {
		List<CouponEntity> couponEntities = new ArrayList<CouponEntity>();
		List<OrgEntity> orgEntities = new ArrayList<OrgEntity>();
		List<QuickMarkEntity> quickMarkEntities = new ArrayList<QuickMarkEntity>();
		List<CouponProvideEntity> couponProvideEntities = new ArrayList<CouponProvideEntity>();
		for (int i = 0; i < models.size(); i++) {
			CouponEntity couponEntity = new CouponEntity();
			OrgEntity orgEntity = new OrgEntity();
			QuickMarkEntity quickMarkEntity = new QuickMarkEntity();
			CouponProvideEntity couponProvideEntity = new CouponProvideEntity();
			DBUtil.copyData(Org.class, OrgEntity.class, models.get(i).org, orgEntity);
			DBUtil.copyData(Coupon.class, CouponEntity.class, models.get(i).coupon, couponEntity);
			DBUtil.copyData(QuickMark.class, QuickMarkEntity.class, models.get(i).quickMark, quickMarkEntity);
			DBUtil.copyData(CouponProvide.class, CouponProvideEntity.class, models.get(i).couponProvide, couponProvideEntity);
			couponEntity.event = DBUtil.getDataFirst(EventEntity.class, "id = " + models.get(i).coupon.rid);
			couponEntity.user = DBUtil.getDataFirst(UserEntity.class, "id = " + models.get(i).coupon.uid);
			quickMarkEntity.couponEntity = couponEntity;
			quickMarkEntity.orgEntity = orgEntity;
			couponProvideEntity.event = DBUtil.getDataFirst(EventEntity.class, "rid = " + models.get(i).coupon.rid);
			couponEntities.add(couponEntity);
			couponProvideEntities.add(couponProvideEntity);
			quickMarkEntities.add(quickMarkEntity);
			orgEntities.add(orgEntity);
			couponEntities.add(couponEntity);
		}
		DBUtil.saveOrUpdateAll(couponEntities, CouponEntity.class, "code", "useStatus", "rid", "uid");
		DBUtil.saveOrUpdateAll(couponProvideEntities, CouponProvideEntity.class, "content", "value", "dateRangeStart", "dateRangeEnd", "publishTime", "templatePic", "rid");
		DBUtil.saveOrUpdateAll(quickMarkEntities, QuickMarkEntity.class, "code", "photo", "cid", "oid");
		DBUtil.saveOrUpdateAll(orgEntities, OrgEntity.class, "name");
	}

	/**
	 * 根据用户id读取优惠券列表
	 * 
	 * @param userId
	 * @return
	 */
	public List<UserCouponModel> selectData(long userId) {
		List<UserCouponModel> models = new ArrayList<UserCouponModel>();
		List<CouponEntity> couponEntities = DBUtil.getData(CouponEntity.class, "uid = " + userId);
		if (couponEntities != null) {
			for (int i = 0; i < couponEntities.size(); i++) {
				UserCouponModel model = new UserCouponModel();
				Coupon coupon = new Coupon();
				CouponProvide couponProvide = new CouponProvide();
				Org org = new Org();
				QuickMark quickMark = new QuickMark();
				CouponEntity couponEntity = couponEntities.get(i);
				QuickMarkEntity quickMarkEntity = DBUtil.getDataFirst(QuickMarkEntity.class, "cid = " + couponEntity.getId());
				CouponProvideEntity couponProvideEntity = DBUtil.getDataFirst(CouponProvideEntity.class, "rid = " + couponEntity.event.getId());
				OrgEntity orgEntity = quickMarkEntity.orgEntity;
				DBUtil.copyData(CouponEntity.class, Coupon.class, couponEntity, coupon);
				DBUtil.copyData(CouponProvideEntity.class, CouponProvide.class, couponProvideEntity, couponProvide);
				DBUtil.copyData(OrgEntity.class, Org.class, orgEntity, org);
				DBUtil.copyData(QuickMarkEntity.class, QuickMark.class, quickMarkEntity, quickMark);
				coupon.rid = (int) couponEntity.event.getId();
				coupon.uid = (int) couponEntity.user.getId();
				couponProvide.rid = (int) couponEntity.event.getId();
				quickMark.cid = coupon.getId();
				quickMark.oid = org.getId();
				model.coupon = coupon;
				model.couponProvide = couponProvide;
				model.org = org;
				model.quickMark = quickMark;
				models.add(model);
			}
		}
		return models;
	}
}
