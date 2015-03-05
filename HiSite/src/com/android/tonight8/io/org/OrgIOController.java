/**
 * 2015-2-11
 */
package com.android.tonight8.io.org;

import java.util.HashMap;
import java.util.Map;

import android.os.Handler;

import com.android.tonight8.io.HandlerConstants;
import com.android.tonight8.io.net.NetEntityBase;
import com.android.tonight8.io.net.NetRequest;
import com.android.tonight8.io.net.NetRequest.RequestResult;
import com.android.tonight8.io.net.NetUtils;
import com.android.tonight8.model.common.Org;
import com.android.tonight8.model.organization.OrgMessageModel;
import com.android.tonight8.storage.org.OrgMessageNativeController;
import com.android.tonight8.storage.org.OrgStorage;
import com.android.tonight8.utils.Utils;
import com.lidroid.xutils.exception.HttpException;

/**
 * @Description: 商家数据IO
 * @copyright @HiSite
 * @Date:2015-2-11
 */
public class OrgIOController {

	private static String ORG_FORGOTID_URL = NetRequest.BASE_URL;

	/**
	 * @Description:商家忘记密码
	 * @param handler
	 * @param org
	 * @author: LiuZhao
	 * @date:2015年3月4日
	 */

	public static void OrgFrogotIdWrite(final Handler handler, Org org) {
		Map<String, String> params = new HashMap<String, String>();
		params.put(NetRequest.REQUEST_URL, ORG_FORGOTID_URL);
		params.put("name", org.name);
		params.put("code", org.paperCode);
		params.put("telphone", org.telphone);
		params.put("email", org.email);
		params.put("password", org.password);
		HandlerConstants.sendMessage(handler, null, 0, HandlerConstants.NETWORK_BEGIN, 0);
		NetRequest.doPostRequest(params, new RequestResult<Org>(Org.class, handler) {

			@Override
			public void getData(NetEntityBase netEntityBase, Org t, Handler handler) {

				if (NetUtils.checkResult(netEntityBase)) {
					Utils.toast(netEntityBase.message);
					HandlerConstants.sendMessage(handler, null, 0, HandlerConstants.RESULT_OK, 0);
				}
			}

			@Override
			public void onFailure(HttpException arg0, String arg1) {
				HandlerConstants.sendMessage(handler, null, 0, HandlerConstants.RESULT_FAIL, 0);
			}

		});
	}

	/**
	 * @Description:商家消息列表
	 * @param handler
	 * @param org
	 * @author: LiuZhao
	 * @date:2015年3月4日
	 */

	public static void OrgMessageListRead(final Handler handler, String id) {
		Map<String, String> params = new HashMap<String, String>();
		params.put(NetRequest.REQUEST_URL, ORG_FORGOTID_URL);
		params.put("org.id", id);
		HandlerConstants.sendMessage(handler, null, 0, HandlerConstants.NETWORK_BEGIN, 0);
		NetRequest.doGetRequest(params, new RequestResult<OrgMessageModel>(OrgMessageModel.class, handler) {

			@Override
			public void getData(NetEntityBase netEntityBase, OrgMessageModel t, Handler handler) {

				if (NetUtils.checkResult(netEntityBase)) {
					Utils.toast(netEntityBase.message);
					// OrgStorage.getOrgMessageController().saveOrUpdateData();
					HandlerConstants.sendMessage(handler, null, 0, HandlerConstants.RESULT_OK, 0);
				}
			}

			@Override
			public void onFailure(HttpException arg0, String arg1) {
				HandlerConstants.sendMessage(handler, null, 0, HandlerConstants.RESULT_FAIL, 0);
			}

		});
	}
}
