/**
 * 2015-2-4
 */
package com.android.tonight8.io.common;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.android.tonight8.io.common.entity.RegionalNetEntity;
import com.android.tonight8.io.net.NetEntityBase;
import com.android.tonight8.io.net.NetRequest;
import com.android.tonight8.io.net.NetRequest.RequestResult;
import com.android.tonight8.model.common.Regional;
import com.android.tonight8.storage.other.RegionalStorage;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.util.LogUtils;

/**
 * @Description: 公用io
 * @author:LiXiaoSong
 * @copyright @HiSite
 * @Date:2015-2-4
 */
public class CommonIOController {

	private static final String REGIONAL = "/api/common/regional";
	private static final String REGIONAL_URL = NetRequest.BASE_URL + REGIONAL;

	/**
	 * @Description:从接口中获取省市区数据，并进行处理
	 * @author: LiXiaoSong
	 * @date:2015-2-4
	 */
	public static void saveRegional() {
		Map<String, String> params = new HashMap<String, String>();
		params.put(NetRequest.REQUEST_URL, REGIONAL_URL);
		NetRequest.doGetRequest(params, new RequestResult<RegionalNetEntity>(RegionalNetEntity.class) {

			@Override
			public void getData(NetEntityBase base, RegionalNetEntity t) {
				LogUtils.v("getData");
				if (t != null) {
					List<Regional> data = t.getCommon_regional().getRegional();
					// 数据库存储逻辑
					RegionalStorage.getRegionalNativeController().insertData(data);
					LogUtils.v(RegionalStorage.getRegionalNativeController().testgetData().toString());
				} else {
				}

			}

			@Override
			public void onFailure(HttpException arg0, String arg1) {
				LogUtils.v("fail");
			}
		});
	}
}
