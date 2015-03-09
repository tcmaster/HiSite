/**
 * 2015-2-11
 */
package com.android.tonight8.io.org;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.os.Handler;

import com.android.tonight8.io.HandlerConstants;
import com.android.tonight8.io.net.NetEntityBase;
import com.android.tonight8.io.net.NetRequest;
import com.android.tonight8.io.net.NetRequest.RequestResult;
import com.android.tonight8.io.net.NetUtils;
import com.android.tonight8.io.org.entity.OrgMessageNetEntity;
import com.android.tonight8.io.org.entity.UserQuestionBackNetEntity;
import com.android.tonight8.model.common.Org;
import com.android.tonight8.model.organization.OrgMessageModel;
import com.android.tonight8.model.organization.OrgQuestionModel;
import com.android.tonight8.model.user.UserQuestionModel;
import com.android.tonight8.storage.org.OrgStorage;
import com.android.tonight8.utils.Utils;
import com.lidroid.xutils.exception.HttpException;

/**
 * @Description: 商家数据IO
 * @copyright @HiSite
 * @Date:2015-2-11
 */
public class OrgIOController {

	/** 商家忘记ID接口 */
	private static String ORG_FORGOTID_URL = NetRequest.BASE_URL;
	/** 商家消息列表接口 */
	private static String ORG_MESSAGE_LIST_URL = NetRequest.BASE_URL;
	/** 商家问题列表接口 */
	private static String ORG_QUESTION_LIST_URL = NetRequest.BASE_URL;
	/** 商家问题回复接口 */
	private static String ORG_QUESTION_REPLY_URL = NetRequest.BASE_URL;

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

	public static void OrgMessageListRead(final Handler handler, final String orgId, final int... attachments) {
		Map<String, String> params = new HashMap<String, String>();
		params.put(NetRequest.REQUEST_URL, ORG_MESSAGE_LIST_URL);
		params.put("org.id", orgId);
		HandlerConstants.sendMessage(handler, null, 0, HandlerConstants.NETWORK_BEGIN, attachments[0]);
		NetRequest.doGetRequest(params, new RequestResult<OrgMessageNetEntity>(OrgMessageNetEntity.class, handler) {

			@Override
			public void getData(NetEntityBase netEntityBase, OrgMessageNetEntity t, Handler handler) {

				if (netEntityBase != null && NetUtils.checkResult(netEntityBase)) {
					Utils.toast(netEntityBase.message);
					// OrgStorage.getOrgMessageController().saveOrUpdateData(t.getOrgMessageModels());
					// List<OrgMessageModel> list = OrgStorage.getOrgMessageController().selectData(orgId,
					// attachments[1], attachments[2]);
					List<OrgMessageModel> list = new ArrayList<OrgMessageModel>();
					for (int i = 0; i < 20; i++) {
						OrgMessageModel orgMessageModel = new OrgMessageModel();
						list.add(orgMessageModel);
					}
					HandlerConstants.sendMessage(handler, list, 0, HandlerConstants.RESULT_OK, attachments[0]);
				} else {
					List<OrgMessageModel> list = new ArrayList<OrgMessageModel>();
					for (int i = 0; i < 20; i++) {
						OrgMessageModel orgMessageModel = new OrgMessageModel();
						list.add(orgMessageModel);
					}
					HandlerConstants.sendMessage(handler, list, 0, HandlerConstants.RESULT_OK, attachments[0]);
				}
			}

			@Override
			public void onFailure(HttpException arg0, String arg1) {
				// List<OrgMessageModel> list = OrgStorage.getOrgMessageController().selectData(orgId,
				// attachments[1], attachments[2]);
				List<OrgMessageModel> list = new ArrayList<OrgMessageModel>();
				for (int i = 0; i < 20; i++) {
					OrgMessageModel orgMessageModel = new OrgMessageModel();
					list.add(orgMessageModel);
				}
				HandlerConstants.sendMessage(handler, list, 0, HandlerConstants.RESULT_FAIL, 0);
			}

		});
	}

	/**
	 * @Description:商家问题列表
	 * @param handler
	 * @author: LiuZhao
	 * @date:2015年3月4日
	 */

	public static void OrgQuestionsRead(final Handler handler, final int orgId, final int... attachments) {
		Map<String, String> params = new HashMap<String, String>();
		params.put(NetRequest.REQUEST_URL, ORG_QUESTION_LIST_URL);
		params.put("org.id", Integer.toString(orgId));
		params.put("page.row", Integer.toString(attachments[1]));
		params.put("page.offSet", Integer.toString(attachments[2]));

		HandlerConstants.sendMessage(handler, null, 0, HandlerConstants.NETWORK_BEGIN, attachments[0]);
		NetRequest.doPostRequest(params, new RequestResult<UserQuestionBackNetEntity>(UserQuestionBackNetEntity.class, handler) {

			@Override
			public void getData(NetEntityBase netEntityBase, UserQuestionBackNetEntity t, Handler handler) {
				List<OrgQuestionModel> list = null;
				if (NetUtils.checkResult(netEntityBase)) {
					list = t.getOrgManageQuestions();
					// OrgStorage.getOrgQuestionController().saveOrUpdateData(list, orgId);
				}
				list = OrgStorage.getOrgQuestionController().selectData(orgId, attachments[0], attachments[1], attachments[2]);
				HandlerConstants.sendMessage(handler, list, 0, HandlerConstants.RESULT_OK, attachments[0]);
			}

			@Override
			public void onFailure(HttpException arg0, String arg1) {
				HandlerConstants.sendMessage(handler, null, 0, HandlerConstants.RESULT_FAIL, 0);
			}

		});
	}

	/**
	 * @Description:商家问题回复
	 * @param handler
	 * @param org
	 * @author: LiuZhao
	 * @date:2015年3月4日
	 */

	public static void OrgOrgQuestionsReply(final Handler handler, String questionId, String content, final String orgId, final int... attachments) {
		Map<String, String> params = new HashMap<String, String>();
		params.put(NetRequest.REQUEST_URL, ORG_QUESTION_REPLY_URL);
		params.put("question.id", questionId);
		params.put("question.content", content);
		params.put("org.id", orgId);

		HandlerConstants.sendMessage(handler, null, 0, HandlerConstants.NETWORK_BEGIN, attachments[0]);
		NetRequest.doPostRequest(params, new RequestResult<UserQuestionModel>(UserQuestionModel.class, handler) {

			@Override
			public void getData(NetEntityBase netEntityBase, UserQuestionModel t, Handler handler) {

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
}
