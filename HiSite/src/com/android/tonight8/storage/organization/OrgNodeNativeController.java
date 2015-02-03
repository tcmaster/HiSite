package com.android.tonight8.storage.organization;

import com.android.tonight8.model.common.Bind;
import com.android.tonight8.storage.DBUtil;
import com.android.tonight8.storage.entity.BindEntity;

/**
 * @Description:商家经销商绑定
 * @author:LiuZhao
 * @Date:2015年2月2日
 */
public class OrgNodeNativeController {

	/**
	 * @Description:绑定经销商
	 * @param modle
	 * @author: LiuZhao
	 * @date:2015年2月2日
	 */

	public void InsertData(Bind modle) {
		BindEntity bindEntity = new BindEntity();
		DBUtil.copyData(Bind.class, BindEntity.class, modle, bindEntity);
		// 存到数据库中
		DBUtil.addData(bindEntity);
	}

	/**
	 * @Description:商家经销商解除绑定
	 * @param id
	 * @author: LiuZhao
	 * @date:2015年2月2日
	 */

	public void DeleteData(String id) {
		DBUtil.deleteData(BindEntity.class, id);
	}
}
