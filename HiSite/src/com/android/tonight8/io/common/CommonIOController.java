/**
 * 2015-2-4
 */
package com.android.tonight8.io.common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.android.tonight8.io.common.entity.ArrayData;
import com.android.tonight8.io.common.entity.RegionalNetEntity;
import com.android.tonight8.io.net.NetRequest;
import com.android.tonight8.io.net.NetRequest.RequestResult;
import com.android.tonight8.io.net.NetUtils;
import com.android.tonight8.model.common.Regional;
import com.android.tonight8.storage.other.RegionalStorage;
import com.lidroid.xutils.exception.HttpException;

/**
 * @Description: 公用io
 * @author:LiXiaoSong
 * @copyright @HiSite
 * @Date:2015-2-4
 */
public class CommonIOController {

	private static final String REGIONAL_URL = "";

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
			public void getData(RegionalNetEntity t) {
				if (NetUtils.checkResult(t)) {
					List<ArrayData> data = t.getCommon_regional();
					List<Regional> regionals = new ArrayList<Regional>();
					for (int i = 0; i < data.size(); i++) {
						regionals.add(data.get(i).getRegional());
					}
					// 数据库存储逻辑
					RegionalStorage.getRegionalNativeController().insertData(regionals);
				} else {
				}

			}

			@Override
			public void onFailure(HttpException arg0, String arg1) {
			}
		});
	}
}
