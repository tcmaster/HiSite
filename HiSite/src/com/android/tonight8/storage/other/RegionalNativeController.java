/**
 * 2015-2-4
 */
package com.android.tonight8.storage.other;

import java.util.ArrayList;
import java.util.List;

import com.android.tonight8.model.common.Regional;
import com.android.tonight8.storage.DBUtil;
import com.android.tonight8.storage.entity.RegionalEntity;

/**
 * @Description: 省市区数据本地控制类
 * @author:LiXiaoSong
 * @copyright @HiSite
 * @Date:2015-2-4
 */
public class RegionalNativeController {

	/**
	 * @Description: 存储由接口获取的省市区县的数据
	 * @param models
	 * @author: LiXiaoSong
	 * @date:2015-2-4
	 */
	public void insertData(List<Regional> models) {
		// level分为3级，1级为省，2级为市，3级为区县
		List<RegionalEntity> entities = new ArrayList<RegionalEntity>();
		for (int i = 0; i < models.size(); i++) {
			Regional model = models.get(i);
			RegionalEntity entity = new RegionalEntity();
			DBUtil.copyData(Regional.class, RegionalEntity.class, model, entity);
			entities.add(entity);
		}
		DBUtil.saveOrUpdateAll(entities, RegionalEntity.class, "pid", "level", "name", "code");// 存储省市区数据
		List<RegionalEntity> levelOne = DBUtil.getData(RegionalEntity.class, "pid = " + 0);// 查找所有省的数据,将level定为1
		for (RegionalEntity e : levelOne)
			e.level = 1;
		DBUtil.updateAll(levelOne, "level");// 更新省的级别
		List<RegionalEntity> levelTwo = DBUtil.getData(RegionalEntity.class, "level <> 0 and pid in(select id from regional where level = 1)");
		for (RegionalEntity e : levelTwo)
			e.level = 2;
		DBUtil.updateAll(levelTwo, "level");// 更新市的级别
		List<RegionalEntity> levelThree = DBUtil.getData(RegionalEntity.class, "level = 0");
		for (RegionalEntity e : levelThree)
			e.level = 3;
		DBUtil.updateAll(levelThree, "level");// 更新县的级别
	}

	public List<RegionalEntity> testgetData() {
		List<RegionalEntity> result = DBUtil.getData(RegionalEntity.class);
		return result;

	}
}
