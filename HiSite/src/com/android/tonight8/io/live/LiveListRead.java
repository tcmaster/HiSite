package com.android.tonight8.io.live;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.android.tonight8.io.live.entity.LiveListNetEntity;
import com.android.tonight8.io.net.NetEntityBase;
import com.android.tonight8.io.net.NetRequest;
import com.android.tonight8.io.net.NetRequest.RequestResult;
import com.android.tonight8.model.live.LiveListModel;
import com.android.tonight8.storage.live.LiveStorage;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.util.LogUtils;

/**
 * @Description:读取活动现场列表数据
 * @author:LiuZhao
 * @Date:2015年2月5日
 */
public class LiveListRead {

	private static final String LIVE_LIST_URL = NetRequest.BASE_URL+"";

	/**
	 * @Description:从接口中获取省市区数据，并进行处理
	 * @author: LiXiaoSong
	 * @date:2015-2-4
	 */
	public static void saveLiveList() {
		Map<String, String> params = new HashMap<String, String>();
		params.put(NetRequest.REQUEST_URL, LIVE_LIST_URL);
		NetRequest.doGetRequest(params, new RequestResult<LiveListNetEntity>(LiveListNetEntity.class) {

			@Override
			public void getData(NetEntityBase netEntityBase, LiveListNetEntity t) {
				if (t != null) {
					List<LiveListModel> listModel = t.getEvent_live_events().event_live_events;
					// 数据库存储逻辑
					LiveStorage.getLiveListDBController().insertData(listModel);
				}
			}

			@Override
			public void onFailure(HttpException arg0, String arg1) {
				LogUtils.v("LiveListRead is failed");
			}

		});
	}
}
