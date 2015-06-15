/**
 * 2015-2-11
 */
package com.android.tonight8.io.user;

import java.util.HashMap;
import java.util.Map;

import android.os.Handler;

import com.android.tonight8.io.net.NetEntityBase;
import com.android.tonight8.io.net.NetRequest;
import com.android.tonight8.io.net.NetRequest.RequestResult;
import com.android.tonight8.io.user.entity.UserAwardNetEntity;
import com.lidroid.xutils.exception.HttpException;

/**
 * @Description: 用户数据IO
 * @author:LiXiaoSong
 * @copyright @HiSite
 * @Date:2015-2-11
 */
public class UserIOController {

	private static String USER_AWARDS_URL = NetRequest.BASE_URL
			+ "/api/member/awards";

	public static void userAwardsRead(final Handler handler) {
		Map<String, String> param = new HashMap<String, String>();
		param.put(NetRequest.REQUEST_URL, USER_AWARDS_URL);
		NetRequest.doGetRequest(param, new RequestResult<UserAwardNetEntity>(
				UserAwardNetEntity.class, handler) {

			@Override
			public void getData(NetEntityBase netEntityBase,
					UserAwardNetEntity t, Handler handler) {

			}

			@Override
			public void onFailure(HttpException arg0, String arg1) {
			}
		});
	}
}
